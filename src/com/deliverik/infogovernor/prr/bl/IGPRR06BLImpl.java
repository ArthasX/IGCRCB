package com.deliverik.infogovernor.prr.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.igflow.api.FlowSetBLImpl;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBean;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.infogovernor.asset.bl.task.CheckItemVWBL;
import com.deliverik.infogovernor.asset.bl.task.RiskPointVMBL;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCondImpl;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;
import com.deliverik.infogovernor.prr.bl.task.IGFXK0403BLImpl;
import com.deliverik.infogovernor.prr.bl.task.ProcessQueryBL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.dto.IGPRR06DTO;
import com.deliverik.infogovernor.prr.model.condition.ProcessSearchCond;

public class IGPRR06BLImpl implements IGPRR06BL{
	
	/** 日志对象 */
	private final static Log log = LogFactory.getLog(IGPRR06BLImpl.class);
	
	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 流程查询BL */
	protected ProcessQueryBL processQueryBL;
	
	protected WorkFlowOperationBL workFlowOperationBL;
	
	protected IGFXK0403BLImpl igfxk0403bl;
	
	protected RiskPointVMBL riskPointVMBL; 
	
	protected CheckItemVWBL checkItemVWBL;
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 流程查询BL设定
	 * @param processQueryBL 流程查询BL
	 */
	public void setProcessQueryBL(ProcessQueryBL processQueryBL) {
		this.processQueryBL = processQueryBL;
	}

	
	/**
	 * @return the riskPointVMBL
	 */
	public RiskPointVMBL getRiskPointVMBL() {
		return riskPointVMBL;
	}


	/**
	 * @return the checkItemVWBL
	 */
	public CheckItemVWBL getCheckItemVWBL() {
		return checkItemVWBL;
	}


	/**
	 * @param checkItemVWBL the checkItemVWBL to set
	 */
	public void setCheckItemVWBL(CheckItemVWBL checkItemVWBL) {
		this.checkItemVWBL = checkItemVWBL;
	}


	/**
	 * @param riskPointVMBL the riskPointVMBL to set
	 */
	public void setRiskPointVMBL(RiskPointVMBL riskPointVMBL) {
		this.riskPointVMBL = riskPointVMBL;
	}


	/**
	 * @return the igfxk0403bl
	 */
	public IGFXK0403BLImpl getIgfxk0403bl() {
		return igfxk0403bl;
	}


	/**
	 * @param igfxk0403bl the igfxk0403bl to set
	 */
	public void setIgfxk0403bl(IGFXK0403BLImpl igfxk0403bl) {
		this.igfxk0403bl = igfxk0403bl;
	}




	public IGPRR01DTO search(IGPRR01DTO dto) throws BLException {
		// TODO Auto-generated method stub
		

		WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
		
		WorkFlowLog log = new WorkFlowLog();
		
		log.setPrid(dto.getPrid());
		bean.setLogInfo(log);
		FlowSetBLImpl flow = new FlowSetBLImpl();
		this.igfxk0403bl.setFlowSetBL(flow);
		this.igfxk0403bl.afterTreatmentExecute(bean);
		dto.setListMap(this.igfxk0403bl.getListMap());
		
		List<Map<String, Object>> dataList = this.igfxk0403bl.getListMap();
		List<RiskPointVM> listPointVMs = new ArrayList<RiskPointVM>();
		List<CheckItemVW> checkItemVWs = new ArrayList<CheckItemVW>();
		
		if(dataList != null){
			int idx_one = 0;
			for(Map<String, Object> map:dataList){
				idx_one ++;
				if(map.get("风险点") != null){
					List<Map<String, String>> tempList = (List<Map<String, String>>) map.get("风险点");
				
					for(Map<String, String> dataMap:tempList){
						String str = dataMap.get("风险点ID");
					//	RiskPointVM pointVM = (RiskPointVM) riskPointVMBL.searchRiskPointVMByPK(Integer.parseInt(str));
					//	listPointVMs.add(pointVM);
						RiskPointVMSearchCondImpl cond = new RiskPointVMSearchCondImpl();
						cond.setSyscoding("");
						cond.setEiid(str);
						List<RiskPointVMInfo> riskPointVMs = riskPointVMBL.searchRiskPointVM(cond, 0, 0);
						if(riskPointVMs.size()>0){
							listPointVMs.add((RiskPointVM) riskPointVMs.get(0));
						}
						
					}
				}
				if(map.get("检查项") != null){
					List<Map<String, String>> tempList = (List<Map<String, String>>) map.get("检查项");
				
					for(Map<String, String> dataMap:tempList){
						String str = dataMap.get("检查项");
						CheckItemVWSearchCondImpl checkCond = new CheckItemVWSearchCondImpl();
						checkCond.setEiname(str);
						checkCond.setSyscoding("");
						List<CheckItemVWInfo> checkItemVWList = checkItemVWBL.searchCheckItemVW(checkCond,0,0);
						if(checkItemVWList.size()>0){
							checkItemVWs.add((CheckItemVW) checkItemVWList.get(0));
						}
					}
				}
			}
		}
		dto.setListPointVMs(listPointVMs);
		dto.setCheckItemVWs(checkItemVWs);
		return dto;
		
	}

	
	
	public IGPRR01DTO searchByEIID(IGPRR01DTO dto) throws BLException {
		// TODO Auto-generated method stub
		

		WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
		
		WorkFlowLog log = new WorkFlowLog();
		
		log.setPrid(dto.getPrid());
		bean.setLogInfo(log);
		FlowSetBLImpl flow = new FlowSetBLImpl();
		this.igfxk0403bl.setFlowSetBL(flow);
		this.igfxk0403bl.afterTreatmentExecute(bean);
		dto.setListMap(this.igfxk0403bl.getListMap());
		
		List<Map<String, Object>> dataList = this.igfxk0403bl.getListMap();
		List<RiskPointVM> listPointVMs = new ArrayList<RiskPointVM>();
		List<CheckItemVW> checkItemVWs = new ArrayList<CheckItemVW>();
		
		if(dataList != null){
			int idx_one = 0;
			for(Map<String, Object> map:dataList){
				idx_one ++;
				if(map.get("风险点") != null){
					List<Map<String, String>> tempList = (List<Map<String, String>>) map.get("风险点");
				
					for(Map<String, String> dataMap:tempList){
						String str = dataMap.get("风险点ID");
						RiskPointVMSearchCondImpl cond = new RiskPointVMSearchCondImpl();
						cond.setSyscoding("");
						cond.setEiid(str);
						List<RiskPointVMInfo> riskPointVMs = riskPointVMBL.searchRiskPointVM(cond, 0, 0);
						if(riskPointVMs.size()>0){
							if(riskPointVMs.get(0).getEiid().equals(dto.getEiid())){
								listPointVMs.add((RiskPointVM) riskPointVMs.get(0));
							}
						}
						
					}
				}
				if(map.get("检查项") != null){
					List<Map<String, String>> tempList = (List<Map<String, String>>) map.get("检查项");
				
					for(Map<String, String> dataMap:tempList){
						String str = dataMap.get("检查项");
						CheckItemVWSearchCondImpl checkCond = new CheckItemVWSearchCondImpl();
						checkCond.setEiname(str);
						checkCond.setSyscoding("");
						List<CheckItemVWInfo> checkItemVWList = checkItemVWBL.searchCheckItemVW(checkCond,0,0);
						if(checkItemVWList.size()>0){
							if(checkItemVWList.get(0).getEiid() == dto.getEiid()){
								checkItemVWs.add((CheckItemVW) checkItemVWList.get(0));
							}	
						}
					}
				}
			}
		}
		dto.setListPointVMs(listPointVMs);
		dto.setCheckItemVWs(checkItemVWs);
		return dto;
		
	}

	public IGPRR01DTO searchAll(IGPRR01DTO dto) throws BLException {
		// TODO Auto-generated method stub
		//中间转换的list集合
		List<RiskPointVM> listPointVMs = new ArrayList<RiskPointVM>();
		List<CheckItemVW> checkItemVWs = new ArrayList<CheckItemVW>();
		
		RiskPointVM riskPoint = new RiskPointVM();
		
		//临时存放查询结果
//		List<RiskPointVMInfo> riskPointVMs = new ArrayList<RiskPointVMInfo>();
//		List<CheckItemVWInfo> checkItemVWList = new ArrayList<CheckItemVWInfo>();

		//对风险点进行全部查询
		RiskPointVMSearchCondImpl riskCond = new RiskPointVMSearchCondImpl();
		riskCond.setSyscoding("999017");
		
		List<RiskPointVMInfo> riskPointVMs = riskPointVMBL.searchRiskPointVM(riskCond,0,0);
		for(int i=0;i<riskPointVMs.size();i++){
			if(riskPointVMs.get(i).getEiid() == dto.getEiid()){
				riskPoint = (RiskPointVM) riskPointVMs.get(i);		
			}
			listPointVMs.add((RiskPointVM) riskPointVMs.get(i));
		}
		//对检查项进行全部查询
		CheckItemVWSearchCondImpl checkCond = new CheckItemVWSearchCondImpl();
		checkCond.setSyscoding("999018");
		List<CheckItemVWInfo> checkItemVWList = checkItemVWBL.searchCheckItemVW(checkCond,0,0);
		for(int i=0;i<checkItemVWList.size();i++){
			checkItemVWs.add((CheckItemVW) checkItemVWList.get(i));
		}
		
		dto.setListPointVMs(listPointVMs);

		dto.setPointVM(riskPoint);
		
		dto.setCheckItemVWs(checkItemVWs);
		
		return dto;
	}

	/**
	 * 流程查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO searchProcessRecordAction(IGPRR06DTO dto) throws BLException {
		log.debug("============流程通用查询操作开始==============");
		// 查询记录总数
		int totalCount = processQueryBL.getProcessCount(dto.getProcessSearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		List<Map<String, Object>> list = processQueryBL.searchProcess(dto.getProcessSearchCond(),pDto.getFromCount(), pDto.getPageDispCount());
		dto.setResult(list);
		pDto.setTotalCount(totalCount);
		log.debug("============流程通用查询操作开始==============");
		return dto;
	}

	/**
	 * 查询流程ID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO searchProcessDefinitionIdAction(IGPRR06DTO dto) throws BLException {
		log.debug("========流程定义ID查询操作开始==========");
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdid_like(dto.getPdid());
		List<IG380Info> pdList = workFlowDefinitionBL.searchProcessDefinition(cond);
		dto.setPdid(pdList.get(pdList.size() - 1).getPdid());
		log.debug("========流程定义ID查询操作结束==========");
		return dto;
	}

	/**
	 * 获取查询定义信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO searchProcessQueryTitleAction(IGPRR06DTO dto) throws BLException {
		log.debug("===============获取查询定义信息操作开始================");
		//流程定义ID
		String pdid = dto.getPdid();
		//获取查询条件
		List<IG111Info> pqList = workFlowDefinitionBL.searchprocessQueryByPdid(pdid);
		//查询显示列
		List<IG110Info> psList = workFlowDefinitionBL.searchProcessQueryShowColumnByPdid(pdid);
		//查询状态信息
		IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
		psdCond.setPdid(pdid);
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
		dto.setPsdList(psdList);
		dto.setProcessQueryList(pqList);
		dto.setProcessQueryShowColumnList(psList);
		log.debug("===============获取查询定义信息操作结束================");
		return dto;
	}

	/**
	 * 流程导出操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO exportProcessRecordAction(IGPRR06DTO dto) throws BLException {
		log.debug("=============流程导出操作开始==============");
		//生成导出文件
		String fileName = generatedFile(dto.getProcessSearchCond());
		//下载文件
		downloadFile(fileName,dto.getResponse());
		log.debug("=============流程导出操作结束==============");
		return dto;
	}
	/**
	 * 生成导出文件
	 * @param cond 流程查询条件
	 * @return 文件名
	 * @throws BLException
	 */
	private String generatedFile(ProcessSearchCond cond) throws BLException{
		//查询数据
		List<Map<String, Object>> list = processQueryBL.searchProcess(cond,0,0);
		//取得流程定义ID
		String pdid = cond.getPdid();
		//取得显示列
		List<IG110Info> columnList = cond.getShowColumnList();
		//取得流程定义信息
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
		String timestamp = IGStringUtils.getAttKey();
		//文件名
		StringBuffer fileName = new StringBuffer();
		fileName.append(ResourceUtility.getString("TEMPLATE_TEMP_PATH"));
		fileName.append(pdid);
		fileName.append(File.separator);
		fileName.append(timestamp);
		fileName.append(File.separator);
		//可写模板
		WritableWorkbook book = null;
		//可写sheet页
		WritableSheet sheet = null;
		//路径检测
		checkPath(fileName.toString());
		fileName.append(pd.getPdname());
		fileName.append(".xls");
		try{
			//创建工作簿
			book = Workbook.createWorkbook(new File(fileName.toString()));
			//创建sheet页
			sheet = book.createSheet("sheet1", 0);
			//设置单元格格式
			WritableCellFormat mainFormat = new WritableCellFormat();
			//设置文字格式
			mainFormat.setFont(new WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD));
			//设置文字垂直居中
			mainFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			//设置文字居中
			mainFormat.setAlignment(Alignment.CENTRE);
			//设置文字自动换行
			mainFormat.setWrap(true);
			//设置边框
			mainFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			sheet.addCell(new Label(0, 0, pd.getPdname(),mainFormat));
			//合并单元格
			sheet.mergeCells(0, 0, columnList.size(), 0);
			
			//设置单元格格式
			WritableCellFormat titleFormat = new WritableCellFormat();
			//设置文字格式
			titleFormat.setFont(new WritableFont(WritableFont.ARIAL,12,WritableFont.BOLD));
			//设置文字垂直居中
			titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			//设置文字居中
			titleFormat.setAlignment(Alignment.CENTRE);
			//设置文字自动换行
			titleFormat.setWrap(true);
			//设置边框
			titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			int a=0;
			sheet.addCell(new Label(a, 1, "序号",titleFormat));
			for(int i=0;i<columnList.size();i++){
				a++;
				sheet.addCell(new Label(a, 1, columnList.get(i).getSname(),titleFormat));
				sheet.setColumnView(a, columnList.get(i).getWidth() / 5);
			}
			//设置单元格格式
			WritableCellFormat contentFormat = new WritableCellFormat();
			//设置文字格式
			contentFormat.setFont(new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD));
			//设置文字垂直居中
			contentFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			//设置文字居中
			contentFormat.setAlignment(Alignment.CENTRE);
			//设置文字自动换行
			contentFormat.setWrap(true);
			//设置边框
			contentFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			if(list != null && list.size() > 0){
				for(int i=0;i<list.size();i++){
					int index = 1;
					sheet.addCell(new Label(0 , 2 + i , ((i+1)+""),contentFormat));
					for(Iterator<Entry<String, Object>> iter = list.get(i).entrySet().iterator();iter.hasNext();){
						Entry<String, Object> next = iter.next();
						if(!"PRID".equals(next.getKey())){
							sheet.addCell(new Label(index , 2 + i , next.getValue().toString(),contentFormat));
							index ++;
						}
					}
				}
			}
			book.write();
		}catch (Exception e) {
			log.debug("导出失败：",e);
			throw new BLException("IGCO10000.E141","导出失败！");
		}finally{
			try {
				book.close();
			} catch (Exception e) {
				log.error("",e);
			}
		}
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
	private void downloadFile(String fileName, HttpServletResponse response) throws BLException {
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
	 * 流程查询JSP取得
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGPRR06DTO searchForwardJsp(IGPRR06DTO dto) throws BLException {
		log.debug("========流程跳转JSP页面查询处理开始========");
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdid_like(dto.getPdid());
		cond.setPdstatus("a");
		List<IG380Info> lst_IG380 = workFlowDefinitionBL.searchProcessDefinition(cond);
		if(lst_IG380 == null || lst_IG380.isEmpty()) {
			//throw new BLException("IGCO10000.E004","流程定义基本");
		} else {
			String forward = workFlowOperationBL.searchForwardJsp(lst_IG380.get(lst_IG380.size() - 1).getPdid(), null,
					IGPRDCONSTANTS.SEARCHJSP, dto.getUser());
			dto.setForwardJsp(forward);
		}
		log.debug("========流程跳转JSP页面查询处理结束========");
		return dto;
	}



	
}
