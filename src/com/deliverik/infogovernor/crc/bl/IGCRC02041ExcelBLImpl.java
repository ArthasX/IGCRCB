/*	
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。	
 */
package com.deliverik.infogovernor.crc.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;

/**
 * 功能：告警事件查询导出
 * 
 * 日期：2016/10/14
 * 
 * gongyunpeng
 *
 */
public class IGCRC02041ExcelBLImpl extends BaseBLImpl implements IGCRC02041ExcelBL  {
	/** 流程信息bl */
	private IG599BL ig599BL;
	
	/** 表格类表单bl */
	private IG898BL ig898BL;
	
	/**
	 * 流程信息bl设置
	 * @param ig599bl
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	/**
	 * 表格类表单bl设置
	 * @param ig599bl
	 */
	public void setIg898BL(IG898BL ig898BL) {
		this.ig898BL = ig898BL;
	}

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC02041ExcelBLImpl.class);
	
	/**
	 * 生成excel
	 * @param dto
	 * @return
	 * @throws BLException
	 */
    public String generatedFile(IGCRC02ExcelDTO dto)throws BLException{
        log.debug("========预算模板生成开始========");
  		
        String timestamp = IGStringUtils.getAttKey();
  		// 获取模板文件
  		StringBuffer fileName = new StringBuffer();
  		fileName.append(ResourceUtility.getString("EXCEL_FILE_ROOT_PATH"));
  		fileName.append("temp");
  		fileName.append(File.separator);
  		fileName.append("giveAlarm");
  		fileName.append(File.separator);
  		fileName.append(timestamp);
  		fileName.append(File.separator);
  		//路径检测
		checkPath(fileName.toString());
  		fileName.append("事件管理表.xls");
  		// 创建真实写入的 Excel 工作薄对象  
  		WritableWorkbook book = null;
  		//可写sheet页
		WritableSheet sheet = null;
  		try {
  			book = Workbook.createWorkbook(new File(fileName.toString()));
		} catch (Exception e) {
			log.debug("========创建可编辑模板失败，无法动态生成相关数据码sheet页========",e);
		}  
  		// 创建可编辑Excel失败
  		if(book==null){
  			throw new BLException("IGCUS0101.E001", "生成数据码失败，请从新尝试！");
  		}
  		if(book.getSheet("事件管理")==null){
  			sheet=book.createSheet("事件管理", 1);
  		}
		
  		//设置列宽 
		sheet.setColumnView(0, 15);
		sheet.setColumnView(1, 25);
		sheet.setColumnView(2, 50);
		sheet.setColumnView(3, 15);
		sheet.setColumnView(4, 50);
		sheet.setColumnView(5, 30);
		sheet.setColumnView(6, 25);
		sheet.setColumnView(7, 15);
		sheet.setColumnView(8, 15);
		sheet.setColumnView(9, 25);
		sheet.setColumnView(10, 25);
		sheet.setColumnView(11, 25);
		sheet.setColumnView(12, 25);
		sheet.setColumnView(13, 25);
		sheet.setColumnView(14, 15);
		sheet.setColumnView(15, 25);
		sheet.setColumnView(16, 25);
		sheet.setColumnView(17, 15);


		
		
		// 所有流程信息
		List<IGCRC0208VWInfo> processList = dto.getProcessList();
		// 所有表单信息
		List<IG599Info> processInfoList = dto.getProcessInfoList();
		// 所有参与人信息
		List<IG337Info> processParticipantList = dto.getProcessParticipantList();
		// 所有状态信息
		List<IG333Info> processStatusDefList = dto.getProcessStatusDefList();
		/* 
		 * 表单数据集
		 * 外层map: Key(prid:流程编号) Value(Map:对应流程表单数据)
		 * 内层Map: String(pivarname:表单名称) value(对应表单数据)
		 */
		Map<Integer, Map<String, IG599Info>> piMap = new HashMap<Integer, Map<String, IG599Info>>();
		/* 
		 * 参与人数据集
		 * 外层Map：Key(prid:流程编号) Value(Map:对应状态的参与人集合)
		 * 内层Map：Key(psdid:参与人状态) Value(List:所有对应状态的参与人)
		 */
		Map<Integer, Map<String, List<IG337Info>>> ppMap = new HashMap<Integer, Map<String, List<IG337Info>>>();
		/* 
		 * 状态数据集
		 * Key：(psdcode：流程状态标示)
		 * Value：(对应状态对象)
		 */
		Map<String, IG333Info> psdMap = new HashMap<String, IG333Info>();

		// 所有的表单
		for (IG599Info info599 : processInfoList) {
			// 判断是否有该流程对应表单信息,如果不存在以该流程编号作为Key，创建一个map实例，用于存储所有对应表单
			if (piMap.get(info599.getPrid()) == null) {
				piMap.put(info599.getPrid(), new HashMap<String, IG599Info>());
			}
			// 填充该流程对应的所有表单信息
			piMap.get(info599.getPrid()).put(info599.getPivarname(), info599);
		}

		// 所有的状态
		for (IG333Info psd : processStatusDefList) {
			//以流程状态标示作为Key，填充所有流程状态信息
			psdMap.put(psd.getPsdcode() + "-" + psd.getPdid(), psd);
		}

		// 所有参与人
		for (IG337Info pp : processParticipantList) {
			// 判断该流程是否存在，如果不存在以该流程编号作为Key，创建一个map集合实例，用于填装对应所有参与人
			if (ppMap.get(pp.getPrid()) == null) {
				ppMap.put(pp.getPrid(), new HashMap<String, List<IG337Info>>());
			}
			// 判断参与人状态是否存在，如果不存在以参与人状态作为Key，创建一个List集合实例，用于填装对应流程对应状态的参与人
			if (ppMap.get(pp.getPrid()).get(pp.getPsdid()) == null) {
				ppMap.get(pp.getPrid()).put(pp.getPsdid(),
						new ArrayList<IG337Info>());
			}
			// 填充参与人
			ppMap.get(pp.getPrid()).get(pp.getPsdid()).add(pp);
		}
		
		
		//事件级别
		Map<Integer,String>  eventLevel = searchEventLevelAction();
		
		//故障原因Map<prid,故障原因>
		Map<Integer,String>  causeFailure = searchCauseFailureAction();

		
		//主机名称(故障系统名称)
		Map<Integer,String>  hostName = searchHostNameAction();
		
		
		
		//写入数据
		try {
		 // 定义格式 字体 下划线 斜体 粗体 颜色
			WritableFont font = new WritableFont
			(WritableFont.ARIAL, 15,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.AUTOMATIC);
			//设置单元格格式
			WritableCellFormat contentFormat = new WritableCellFormat(font);
			//设置字体居中
			contentFormat.setAlignment(Alignment.CENTRE);
			//设置文字自动换行
			contentFormat.setWrap(true);
			//设置标题
			sheet.mergeCells(0, 0, 17, 1);
			
			sheet.addCell(new Label(0,0,"事件管理",contentFormat));
			
	    	//导出Excel标题
	    	String [] title = {"工单号","事件名称","具体描述","事件级别","故障系统名称","故障原因"
	    					  ,"事件处理人","处理方法","发生时间","事件分类","事件来源","严重程度"
	    					  ,"紧急程度","发起人","发起时间","当前处理人","状态","关闭时间"};
			if(title!=null && title.length != 0){
				for(int i = 0 ; i < title.length; i++){
					sheet.addCell(new Label(i,2,title[i],contentFormat));
				}
			}
			
			
			// 写入各个单元格
			if (processList != null && processList.size() > 0) {
				for (int i = 0; i < processList.size(); i++) {
					// 获取流程对象
					IGCRC0208VWInfo info = processList.get(i);
					
					// 填充工单号
					sheet.addCell(new Label(0,i+3, info.getPrserialnum()));
					// 填充事件名称
					sheet.addCell(new Label(1,i+3, info.getPrtitle()));
					//获取事件描述信息
					String prdesc = piMap.get(info.getPrid()).get("事件描述").getPivarvalue();
					if(StringUtils.isNotEmpty(prdesc)){
						prdesc = prdesc.replaceAll("&nbsp;", " ");
						prdesc = prdesc.replaceAll("<br>", "");
					}
					
					// 填充具体描述 
					sheet.addCell(new Label(2,i+3, prdesc));
					
					// 填充事件等级
					sheet.addCell(new Label(3,i+3,eventLevel.get(info.getPrid())));
					
					//故障系统名称
					sheet.addCell(new Label(4,i+3,hostName.get(info.getPrid())));
					//原因分析
					sheet.addCell(new Label(5,i+3,causeFailure.get(info.getPrid())));
					
					//事件处理人
					int n = 0;
					int m = 0;
					StringBuffer strPeople = new StringBuffer();
					for (IG337Info bean : processParticipantList) {
						if(info.getPrid().equals(bean.getPrid())){
							String psdid = bean.getPsdid();
							if("01080".equals(psdid.substring(0,5)) && "005".equals(psdid.substring(7,10))){	
								// 拼接流程处理人
								if (m > 0) {
									strPeople.append(",");
								}
								strPeople.append(processParticipantList.get(n).getPpusername());
								m++;
							}
						}
						n++;
					}
					sheet.addCell(new Label(6,i+3, strPeople.toString()));
					
					
					//处理方法
					sheet.addCell(new Label(7,i+3, info.getHandlingMethod()));
					//发生时间
					sheet.addCell(new Label(8,i+3, info.getHappenTime()));
					
					
					// 填充是否需要测试
					String[] strs = piMap.get(info.getPrid()).get("事件分类").getPivarvalue().split("_");
					String[] strs2 = strs[strs.length-1].split("-");
					sheet.addCell(new Label(9,i+3, strs2[strs2.length-1]));
					
					// 填充事件来源
					sheet.addCell(new Label(10, i+3, piMap.get(info.getPrid()).get("事件来源").getPivarvalue()));
					
					//填充影响程度
					sheet.addCell(new Label(11,i+3, piMap.get(info.getPrid()).get("严重程度").getPivarvalue()));
					
					//填充紧急情况
					IG599Info info599 = piMap.get(info.getPrid()).get("紧急程度");
					sheet.addCell(new Label(12,i+3, info599.getPivarvalue()));
					
					// 填充发起人	
					sheet.addCell(new Label(13,i+3, info.getPrusername()));

					StringBuffer str = new StringBuffer();
					// 获取对应流程处理人
					if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
						str.append("");
					}else{					
						List<IG337Info> list = ppMap.get(info.getPrid()).get(
								psdMap.get(info.getPrstatus() + "-" + info.getPrpdid()).getPsdid());
						// 拼接流程处理人
						if (list != null) {
							for (int j = 0; j < list.size(); j++) {
								if (j > 0) {
									str.append(",");
								}
								str.append(list.get(j).getPpusername());
							}
						}
					}
					
					//填充发起时间
					sheet.addCell(new Label(14, i+3, info.getPropentime()));
					// 填充处理人
					sheet.addCell(new Label(15, i+3, str.toString()));
					// 填充工单状态
					if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
						sheet.addCell(new Label(16, i+3, "中止"));
					}else{
						sheet.addCell(new Label(16, i+3, psdMap.get(info.getPrstatus() + "-" + info.getPrpdid()).getPsdname()));
					}
					// 填充关闭时间
					sheet.addCell(new Label(17, i+3, info.getPrclosetime()));
			
				}	
			}		
			
			book.write();
			book.close();
		} catch (Exception e) {
			log.debug("导出失败：",e);
			throw new BLException("IGCO10000.E141","导出失败！");
		}
        log.debug("========预算模板导出结束========");
        return fileName.toString();
    }

	/***
	 * 文件目录检查
	 * @param path 文件目录
	 */
	private void checkPath(String path) throws BLException {
		File objFile = new File(path);
		if (objFile.exists() != true && objFile.isDirectory() != true) {
			// 文件路径不存在时，创建目录
			boolean ret = objFile.mkdirs();
			if (!ret) {
				throw new BLException("IGCO10000.E008",path);
			}
		}
	}
    
    /**
	 * 文件下载
	 * @param fileName 文件名称
	 * @param response 响应对象
	 */
	public void downloadFile(String fileName, HttpServletResponse response) throws BLException {
		// 输出流
    	OutputStream output = null;
    	// 输入流
    	FileInputStream input = null;
    	try{
	        File file = new File(fileName);
	    	//文件下载处理
	        response.reset();
	        response.setContentType("binary/octet-stream");
	        response.setHeader("Content-Disposition", "attachment;filename=" +  new String(file.getName().getBytes("gb2312"),"iso-8859-1"));
	    	// 输出流取得
			output = response.getOutputStream();
			// 输入流取得
			input = new FileInputStream(file);
			int actual = 0;
			byte[] b = new byte[1024];
			
			while ((actual = input.read(b)) > 0) {
				output.write(b,0,actual);
			}
			output.flush();
    	}catch (Exception e) {
    		log.error("DownloadAction Exception", e);
    		throw new BLException("IGCO10000.E009");
		}finally {
			try {
				// 关闭输入流
				if(input != null){
					input.close();
					input = null;
				}
				// 关闭输出流
				if(output != null){
					output.close();
					output = null;
				}
			} catch (Exception e) {
				log.error("DownloadAction Exception", e);
			}
		}
	}
	
	/**
	 * 查询事件级别
	 * 
	 * <prid,事件级别>
	 */
	private Map<Integer,String> searchEventLevelAction(){
		//事件级别
		Map<Integer,String>  eventLevel = new HashMap<Integer,String>();
		
		//根据prid 去查询ig599的事件等级
		IG599SearchCondImpl ig599cond = new IG599SearchCondImpl();
		ig599cond.setPdid("01080");
		ig599cond.setPivarname("事件级别");
		List<IG599Info> ig599Listinfo = ig599BL.searchIG599InfosByCond(ig599cond);
		//一次性将所有数据查出,存入map中 map的key是ig599表中的prid value是pivarname为事件级别的privarvalue
		if(ig599Listinfo != null && !ig599Listinfo.isEmpty()){
			for(int i = 0;i<ig599Listinfo.size();i++){
				if(eventLevel.get(ig599Listinfo.get(i).getPrid()) == null){
					eventLevel.put(ig599Listinfo.get(i).getPrid(), ig599Listinfo.get(i).getPivarvalue());
				}
			}
		}
		return eventLevel;
	}
	
	/**
	 * 查询故障原因
	 * 
	 * @return <prid,故障原因>
	 */
	private Map<Integer,String> searchCauseFailureAction(){
		
		//故障原因Map<prid,故障原因>
		Map<Integer,String>  causeFailure = new HashMap<Integer,String>();
		
		//根据prid 去查询ig599的故障原因
		IG599SearchCondImpl ig599FailureCond = new IG599SearchCondImpl();
		ig599FailureCond.setPdid("01080");
		ig599FailureCond.setPivarname("故障原因");
		List<IG599Info> ig599FailureListinfo = ig599BL.searchIG599InfosByCond(ig599FailureCond);
		//一次性将所有数据查出,存入map中 map的key是ig599表中的prid value是pivarname为故障原因的privarvalue
		if(ig599FailureListinfo != null && !ig599FailureListinfo.isEmpty()){
			for(int i = 0 ;i<ig599FailureListinfo.size();i++){
				if(causeFailure.get(ig599FailureListinfo.get(i).getPrid()) == null){
					causeFailure.put(ig599FailureListinfo.get(i).getPrid(),ig599FailureListinfo.get(i).getPivarvalue());
				}
			}
		}
		return causeFailure;
	}
	
	/**
	 * 查询主机名称(故障系统名称)
	 * 
	 * @return Map<prid,拼接起来的值> 取值时直接根据prid取得
	 */
	private Map<Integer,String> searchHostNameAction(){
		
		//主机名称(故障系统名称)
		Map<Integer,String>  hostName = new HashMap<Integer,String>(); 
		//根据prid 查询ig898的主机名称(故障系统名称为所有主机名称拼接在一起)
		IG898SearchCondImpl ig898cond = new IG898SearchCondImpl();
		ig898cond.setPvcolname("主机名称");
		List<IG898Info> ig898ListInfo = ig898BL.searchIG898(ig898cond);
		//一次性将所有数据查出,存入map中 map的key是ig898表中的prid value是pvcolname为主机名称的pvalue prid相同则给pvalue拼接在一起
		//例：Map<prid,拼接起来的值> 取值时直接根据prid取得
		if(ig898ListInfo != null && !ig898ListInfo.isEmpty() ){
			for(int i = 0;i<ig898ListInfo.size();i++){
				if(hostName.get(ig898ListInfo.get(i).getPrid()) == null){
					hostName.put(ig898ListInfo.get(i).getPrid(),ig898ListInfo.get(i).getPvalue());
				}else{
					hostName.put(ig898ListInfo.get(i).getPrid(), 
							hostName.get(ig898ListInfo.get(i).getPrid())+","+ig898ListInfo.get(i).getPvalue());
					
				}
			}
		}
		return hostName;
	}
	
	
	
}
