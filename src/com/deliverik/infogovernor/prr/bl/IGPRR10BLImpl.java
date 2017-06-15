/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG037BL;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG037TB;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.infogovernor.prr.bl.IGPRR10BLType.Sign;
import com.deliverik.infogovernor.prr.dto.IGPRR10DTO;
import com.deliverik.infogovernor.prr.form.IGPRR1001Form;
import com.deliverik.infogovernor.prr.form.IGPRR1002Form;
import com.deliverik.infogovernor.prr.util.ExcelUtils;
import com.deliverik.infogovernor.prr.util.ExcelUtils.Type;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程导入BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR10BLImpl extends BaseBLImpl implements IGPRR10BL{

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGPRR10BLImpl.class);

	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 流程处理LB */
	protected WorkFlowOperationBL workFlowOperationBL;
	
//	/** 取得配置对象 */
//	protected ImportProcessUtils util = ImportProcessUtils.getInstance();
	
	/** excel工具类取得 */
	protected ExcelUtils eUtils = ExcelUtils.getInstance();
	
	/** 上传附件BL */
	protected FileUploadBL fileUploadBL;
	
	/** 流程主信息BL */
	protected IG500BL ig500BL;
	
	/** 用户BL */
	protected UserBL userBL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/** 参与人BL */
	protected IG337BL ig337BL;
	
	/** 流程状态日志BL */
	protected IG224BL ig224BL;
	
	/** 表格式表单BL */
	protected IG898BL ig898BL;
	
	/** 流程导入日志BL */
	protected IG037BL ig037BL;
	
	/** 资产信息处理BL */
	protected SOC0118BL soc0118BL;
	
	/** 基础数据处理BL */
	protected CodeDetailBL codeDetailBL;
	
	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 流程处理LB设定
	 * @param workFlowOperationBL 流程处理LB
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 上传附件BL设定
	 * @param fileUploadBL 上传附件BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * 流程主信息BL设定
	 * @param ig500BL 流程主信息BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * 用户BL设定
	 * @param userBL 用户BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 用户角色BL设定
	 * @param userRoleBL 用户角色BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 参与人BL设定
	 * @param ig337BL 参与人BL
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	/**
	 * 流程状态日志BL设定
	 * @param ig224bl 流程状态日志BL
	 */
	public void setIg224BL(IG224BL ig224bl) {
		ig224BL = ig224bl;
	}

	/**
	 * 表格式表单BL设定
	 * @param ig898bl 表格式表单BL
	 */
	public void setIg898BL(IG898BL ig898bl) {
		ig898BL = ig898bl;
	}

	/**
	 * 流程导入日志BL设定
	 * @param ig037bl 流程导入日志BL
	 */
	public void setIg037BL(IG037BL ig037bl) {
		ig037BL = ig037bl;
	}

	/**
	 * 资产信息处理BL设定
	 * @param soc0118bl 资产信息处理BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * 基础数据处理BL设定
	 * @param codeDetailBL 基础数据处理BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * 流程定义查询操作开始
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO searchProcessDefinitionsAction(IGPRR10DTO dto) throws BLException {
		log.debug("=============流程定义查询操作开始==============");
		//实例化查询条件
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		//查询通用模板下的流程
		Integer[] ptids = new Integer[]{IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID};
		cond.setPrTypeArray(ptids);
		//查询流程状态为启用
		cond.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
		//调用BL查询流程最新版本定义
		//流程类型范围
		CodeDetailSearchCondImpl cond_code = new CodeDetailSearchCondImpl();
		cond_code.setCcid(CodeDefine.getCodeDefine("PDID_IMPORT_CCID").getCcid());//可导入流程的基本信息
		cond_code.setCdstatus("1");
		List<CodeDetail> lst_codedetail = this.codeDetailBL.searchCodeDetail(cond_code, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		
//		String[] prpdid_like_or = IGPRR10BLType.PROCESS_PDIDS;
		String[] prpdid_like_or = null;
		if(lst_codedetail != null && lst_codedetail.size() > 0){
			prpdid_like_or = new String[lst_codedetail.size()];//记录可导入流程的定义ID
			for (int i = 0; i < lst_codedetail.size(); i++) {
				CodeDetail codeDetail = lst_codedetail.get(i);
				prpdid_like_or[i] = codeDetail.getCvalue();
			}
		}else{
			prpdid_like_or = new String[]{"00000"};
		}
		
		cond.setPrpdid_like_or(prpdid_like_or);
		List<IG380Info> processDefinitionList = workFlowDefinitionBL.searchLastProcessDefinition(cond, 0, 0);
		//设置返回结果
		dto.setProcessDefinitionList(processDefinitionList);
		log.debug("=============流程定义查询操作结束==============");
		return dto;
	}
	
	/**
	 * 封装导出模板
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO initProcessExportTemplateAction(IGPRR10DTO dto) throws BLException {
		log.debug("================封装导出模板操作开始==================");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRR1001Form){
			//页面数据取得
			IGPRR1001Form form = (IGPRR1001Form) dto.getForm();
			if(form.getPdids() != null && form.getPdids().length > 0){
				//生成导出模板
				String timestamp = generatedTemplate(form.getPdids());
				//文件打包
				String fileName = packToolFiles(timestamp);
				//下载文件
				downloadFile(fileName,dto.getResponse());
				//删除缓存文件
				eUtils.flush();
			}
		}
		log.debug("================封装导出模板操作结束==================");
		return dto;
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
	 * 打包
	 * @param timestamp 时间戳
	 * @return 压缩文件名
	 */
	private String packToolFiles(String timestamp) throws BLException{
		//缓存目录跟路径
//		String rootPath = util.get("TEMPLATE_TEMP_PATH").toString();
		String rootPath = ResourceUtility.getString("TEMPLATE_TEMP_PATH");
		//压缩包文件名
		String zipFileName = rootPath + timestamp + "_templates.zip";
		//压缩文件输出对象
		ZipOutputStream out = null;
		try{
			//实例化压缩文件输出对象
			out = new ZipOutputStream(new FileOutputStream(zipFileName));
			out.setEncoding("GBK");
			//待压缩目录file对象
			File file = new File(rootPath + timestamp);
			if(file.exists()){
				toZip(out, file, file.getName(), zipFileName);
			}else{
				throw new BLException("IGCO10000.E141","文件打包失败！");
			}
		}catch (Exception e) {
			log.debug("文件打包失败",e);
			throw new BLException("IGCO10000.E141","文件打包失败！");
		}finally{
			if(out != null){
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					log.debug("",e);
				}
			}
		}
		return zipFileName;
	}
	
	/**
     * 将文件进行压缩.
     * 
     * @param outputStream
     * @param file 要压缩的文件或文件目录.
     * @param base 文件夹中子目录名称.
     * @param zipFileName 压缩后的ZIP文件名.
     * @return 压缩后的文件.
     * @throws Exception 一些常规的IO异常信息.
     */
    private void toZip(ZipOutputStream outputStream, File file, String base, String zipFileName) throws Exception {
        if (file.isDirectory()) {
            File[] fl = file.listFiles();
            outputStream.putNextEntry(new ZipEntry(base + "/"));

            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < fl.length; i++) {
                if(fl[i].getName().equals(new File(zipFileName).getName())) {
                    continue;
                }
                toZip(outputStream, fl[i], base + fl[i].getName(), zipFileName);
            }
        } else {
            outputStream.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(file);
            int b;
            while ((b = in.read()) != -1) {
                outputStream.write(b);
            }
            in.close();
        }
    }

	/**
	 * 生成模板
	 * @param pdids 流程定义ID集合
	 * @return 模板生成时间戳
	 */
	private String generatedTemplate(String[] pdids) throws BLException{
		//时间戳
//		String timestamp = util.getTimestamp();
		String timestamp = IGStringUtils.getAttKey();
		//取得缓存目录根路径
//		String tempRootPath = util.get("TEMPLATE_TEMP_PATH").toString() + timestamp + File.separator;
		String tempRootPath = ResourceUtility.getString("TEMPLATE_TEMP_PATH") + timestamp + File.separator;
		//可写模板
		WritableWorkbook book = null;
		//可写sheet页
		WritableSheet sheet = null;
		//循环生成excel模板
		for(int i=0;i<pdids.length;i++){
			//流程定义主键
			String pdid = pdids[i];
			//查询流程定义信息
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			//查询表单定义
			IG007SearchCondImpl pidCond = new IG007SearchCondImpl();
			pidCond.setPdid(pdid);
			List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(pidCond);
			//处理表单定义中表格式表单列的层级关系
			Map<String, List<IG007Info>> map = new LinkedHashMap<String, List<IG007Info>>();
			map.put(IGPRR10BLType.PROCESS_BASIS_FORM_KEY, new ArrayList<IG007Info>());
			if(pidList != null && pidList.size() > 0){
				for(IG007Info pid:pidList){
					String key = pid.getPpidid();
					if(StringUtils.isNotEmpty(pid.getPpidid())){
						if(map.get(pid.getPpidid()) == null){
							map.put(pid.getPpidid(), new ArrayList<IG007Info>());
						}
					}else{
						key = IGPRR10BLType.PROCESS_BASIS_FORM_KEY;
					}
					map.get(key).add(pid);
				}
			}
			//写入行号
			int index = 0;
			//总列数
			int sumColumn = getSumColumnCount(map);
			
			//-------------生成excel模板------------
			checkPath(tempRootPath);
			try{
				//创建工作簿
				book = Workbook.createWorkbook(new File(tempRootPath + pd.getPdname() + ".xls"));
				//创建sheet页
				sheet = book.createSheet("sheet1", 0);
				sheet.addCell(new Label(0,index,Sign.PDID.toString(),eUtils.format(Type.SIGN)));
				sheet.addCell(new Label(1,index,pd.getPdid(),eUtils.format(Type.CONTENT)));
				sheet.setRowView(index,0); 
				//写入标题
				index ++;
				sheet.addCell(new Label(0, index, pd.getPdname(),eUtils.format(Type.MAIN_TITLE)));
				//合并单元格
				sheet.mergeCells(0, index, sumColumn - 1, index);
				//写入基本信息标记
				index = writeBasisInfo(sheet, pdid, index, sumColumn);
				//写入表单信息
				index = writeProcessInfo(sheet, pdid, index, sumColumn,map);
				//写入参与人信息
				index = writeParticipantInfo(sheet, pdid, index, sumColumn);
				//设置列宽
				for(int colNum=0;colNum<sumColumn;colNum++){
					sheet.setColumnView(colNum, 20);
				}
				book.write();
			}catch (Exception e) {
				log.debug("生成\"" + pd.getPdname() + "\"模板失败",e);
				throw new BLException("IGCO10000.E141","生成\"" + pd.getPdname() + "\"模板失败！");
			}finally{
				try {
					book.close();
				} catch (Exception e) {
					log.error("",e);
				}
			}
		}
		return timestamp;
	}

	/**
	 * 计算总列数
	 * @param map 表单定义信息
	 * @return 总列数
	 */
	private int getSumColumnCount(Map<String, List<IG007Info>> map) {
		int sumCount = 4;
		List<IG007Info> pidList = map.get(IGPRR10BLType.PROCESS_BASIS_FORM_KEY);
		if(pidList != null){
			for(IG007Info pid:pidList){
				int count = getCount(pid.getPidid(),map);
				
				if(count > sumCount){
					sumCount = count;
				}
			}
		}
		return sumCount + 1;
	}

	/**
	 * 取得表格总列数
	 * @param pidid 表格定义主键
	 * @param map 表单定义层级关系map
	 * @return 总列数
	 */
	private int getCount(String pidid, Map<String, List<IG007Info>> map) {
		int count = 0;
		List<IG007Info> list = map.get(pidid);
		if(list != null && list.size() > 0){
			for(IG007Info pid:list){
				count += getCount(pid.getPidid(), map);
			}
		}else{
			count = 1;
		}
		return count;
	}

	/**
	 * 向excel写入流程标题
	 * @param sheet excel sheet页
	 * @param pdid 流程定义ID
	 * @param index 行索引
	 * @param sumColumn 总列数
	 * @return 当前写入行
	 * @throws Exception
	 */
	private int writeParticipantInfo(WritableSheet sheet,String pdid, int index,int sumColumn) throws Exception{
		//查询状态定义信息
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(cond);
		if(psdList != null && psdList.size() > 1){
			//写入参与人标记
			index ++;
			sheet.addCell(new Label(0,index,Sign.PARTICIPANT.toString(),eUtils.format(Type.SIGN)));
			sheet.setRowView(index,0); 
			//设置标题
			index ++;
			sheet.addCell(new Label(0,index,"状态名称",eUtils.format(Type.TITLE)));
			sheet.addCell(new Label(1,index,"处理人ID",eUtils.format(Type.TITLE)));
			sheet.addCell(new Label(2,index,"处理时间",eUtils.format(Type.TITLE)));
			sheet.addCell(new Label(3,index,"处理动作",eUtils.format(Type.TITLE)));
			sheet.addCell(new Label(4,index,"处理意见",eUtils.format(Type.TITLE)));
			if(sumColumn > 5){
				sheet.addCell(new Label(5,index,"",eUtils.format(Type.CONTENT)));
				if(sumColumn > 6){
					//合并单元格
					sheet.mergeCells(5, index, sumColumn - 1, index);
				}
			}
			for(IG333Info psd:psdList){
				//结束状态不设置参与人
				if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode())){
					index ++;
					sheet.addCell(new Label(0,index,psd.getPsdname(),eUtils.format(Type.CONTENT)));
					sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
					sheet.addCell(new Label(2,index,"",eUtils.format(Type.CONTENT)));
					sheet.addCell(new Label(3,index,"",eUtils.format(Type.CONTENT)));
					sheet.addCell(new Label(4,index,"",eUtils.format(Type.CONTENT)));
					if(sumColumn > 5){
						sheet.addCell(new Label(5,index,"",eUtils.format(Type.CONTENT)));
						if(sumColumn > 6){
							//合并单元格
							sheet.mergeCells(5, index, sumColumn - 1, index);
						}
					}
				}
			}
		}
		return index;
	}
	/**
	 * 向excel写入流程标题
	 * @param sheet excel sheet页
	 * @param pdid 流程定义ID
	 * @param index 行索引
	 * @param sumColumn 总列数
	 * @return 当前写入行
	 * @throws Exception
	 */
	private int writeProcessInfo(WritableSheet sheet,String pdid, int index,int sumColumn,Map<String, List<IG007Info>> pidMap) throws Exception{
		//取得基本表单
		List<IG007Info> pidList = pidMap.get(IGPRR10BLType.PROCESS_BASIS_FORM_KEY);
		if(pidList != null && pidList.size() > 0){
			index ++;
			//写入标记
			sheet.addCell(new Label(0,index,Sign.PROCESS_INFO.toString(),eUtils.format(Type.SIGN)));
			sheet.setRowView(index,0); 
			for(IG007Info pid:pidList){
				//写入时不包含表格式表单列定义
				if(StringUtils.isEmpty(pid.getPpidid())){
					//忽略附件表单
					if("F".equals(pid.getPidtype())){
						continue;
					}
					index ++;
					sheet.addCell(new Label(0,index,pid.getPidname(),eUtils.format(Type.TITLE)));
					//表格式表单生成
					if("8".equals(pid.getPidtype())){
						int startColumn = 1;
						List<IG007Info> list = pidMap.get(pid.getPidid());
						if(list != null && list.size() > 0){
							for(IG007Info column:list){
								int count = getCount(column.getPidid(), pidMap);
								sheet.addCell(new Label(startColumn,index,column.getPidname(),eUtils.format(Type.TITLE)));
								if(count > 1){
									//合并单元格
									sheet.mergeCells(startColumn, index, startColumn + count - 1, index);
								}else{
									sheet.addCell(new Label(startColumn,index + 1,"",eUtils.format(Type.CONTENT)));
								}
								startColumn += count;
							}
						}
						if(startColumn < sumColumn){
							sheet.addCell(new Label(startColumn,index,"",eUtils.format(Type.CONTENT)));
							sheet.addCell(new Label(startColumn,index + 1,"",eUtils.format(Type.CONTENT)));
							if(sumColumn - startColumn > 1){
								//合并单元格
								sheet.mergeCells(startColumn, index, sumColumn - 1, index);
								sheet.mergeCells(startColumn, index + 1, sumColumn - 1, index + 1);
							}
						}
						//合并单元格
						sheet.mergeCells(0, index, 0, index + 1);
						index ++;
						
					}else{
						sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
						//合并单元格
						sheet.mergeCells(1, index, sumColumn - 1, index);
					}
				}
			}
		}
		return index;
	}
	
	/**
	 * 向excel写入流程基本信息
	 * @param sheet excel sheet页
	 * @param pdid 流程定义ID
	 * @param index 行索引
	 * @param sumColumn 总列数
	 * @return 当前写入行
	 * @throws Exception
	 */
	private int writeBasisInfo(WritableSheet sheet,String pdid, int index,int sumColumn) throws Exception{
		//查询流程主题信息
		IG243SearchCondImpl cond = new IG243SearchCondImpl();
		cond.setPdid(pdid);
		List<IG243Info> lstProcessTitleDef = this.workFlowDefinitionBL.searchProcessTitleDef(cond);
		index ++;
		sheet.addCell(new Label(0,index,Sign.BASIS.toString(),eUtils.format(Type.SIGN)));
		sheet.setRowView(index,0); 
		//---------------基本信息start--------------
		if(lstProcessTitleDef != null && lstProcessTitleDef.size() == 1){
			//流程标题
			if(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT.equals(lstProcessTitleDef.get(0).getPtitleaccess())){
				index ++;
				sheet.addCell(new Label(0,index,lstProcessTitleDef.get(0).getPtitlename(),eUtils.format(Type.TITLE)));
				sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
				//合并单元格
				sheet.mergeCells(1, index, sumColumn - 1, index);
			}
			//流程描述
			if(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT.equals(lstProcessTitleDef.get(0).getPdescaccess())){
				index ++;
				sheet.addCell(new Label(0,index,lstProcessTitleDef.get(0).getPdescname(),eUtils.format(Type.TITLE)));
				sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
				//合并单元格
				sheet.mergeCells(1, index, sumColumn - 1, index);
			}
		}
		//流程发起时间
		index ++;
		sheet.addCell(new Label(0,index,IGPRR10BLType.PROCESS_BASIS_OPENTIME,eUtils.format(Type.TITLE)));
		sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
		//合并单元格
		sheet.mergeCells(1, index, sumColumn - 1, index);
		//流程结束时间
		index ++;
		sheet.addCell(new Label(0,index,IGPRR10BLType.PROCESS_BASIS_CLOSETIME,eUtils.format(Type.TITLE)));
		sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
		//合并单元格
		sheet.mergeCells(1, index, sumColumn - 1, index);
		return index;
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
	 * 流程导入操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO importProcessRecordsAction(IGPRR10DTO dto) throws BLException {
		log.debug("================流程导入操作开始=================");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRR1002Form){
			IGPRR1002Form form = (IGPRR1002Form) dto.getForm();
			FormFile file = form.getExportFile();
			//上传文件
			FileInfo info = uploadFile(file);
			importProcess(info);
		}
		log.debug("================流程导入操作结束=================");
		return dto;
	}
	
	private void importProcess(FileInfo info) throws BLException{
		log.debug("============解析文件开始==============");
		//文件对象
		File file = info.getFile();
		Workbook wb = null;
		try{
			//取得工作薄
			wb = Workbook.getWorkbook(file);
			if(wb != null){
				Sheet[] sheets = wb.getSheets();
				if(sheets != null && sheets.length > 0){
					for(Sheet sheet:sheets){
						createProcess(sheet);
					}
				}else{
					throw new BLException("IGCO10000.E141","流程内容不存在。");
				}
			}else{
				throw new BLException("IGCO10000.E141","文件读取失败。");
			}
		} catch (BLException e) {
			log.error("流程导入失败",e);
//			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			log.error(e);
			throw new BLException("IGCO10000.E141","文件解析失败。");
		}
		log.debug("============解析文件结束==============");
	}
	
	@SuppressWarnings("unchecked")
	private void createProcess(Sheet sheet) throws BLException{
		//起始行
		int row = 0;
		//取得行数
		int rows = sheet.getRows();
		//取得流程定义
		Info<IG380Info> pdInfo = getProcessDefinition(sheet,row,rows);
		row = pdInfo.row;
		IG380Info pd = pdInfo.obj;
		//查询状态定义信息
		Map<String, IG333Info> statusMap = getProcessStatusDefinition(pd.getPdid());
		//查询表单定义信息
		Map<String, IG007Info> processInfoDefMap = getProcessInfoDefinition(pd.getPdid());
		//参与人定义Map
		Map<String, List<IG222Info>> participantDefMap = getProcessRoleDefinition(pd.getPdid());
		//查询流程主题信息
		IG243SearchCondImpl cond = new IG243SearchCondImpl();
		cond.setPdid(pd.getPdid());
		List<IG243Info> lstProcessTitleDef = this.workFlowDefinitionBL.searchProcessTitleDef(cond);
		Info<Map<String,String>> basisInfo = getBasisInfo(sheet, row, rows);
		Map<String, String> basisMap = basisInfo.obj;
		row = basisInfo.row;
		//取得表单信息
		Info<Map<String, Object>> formInfo = getProcessInfo(sheet,row,rows,processInfoDefMap);
		Map<String, Object> processInfoMap = formInfo.obj;
		row = formInfo.row;
		//取得参与人信息
		Info<Map<String, Map<String, String>>> ppInfo = getParticipantInfo(sheet, row, rows);
		Map<String, Map<String, String>> ppMap = ppInfo.obj;
		row = ppInfo.row;
		IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(pd.getPtid());
		IG500TB prTB = new IG500TB();
		prTB.setPrpdid(pd.getPdid());
		prTB.setPrpdname(pd.getPdname());
		prTB.setPrtype(pt.getPttype());
		if(lstProcessTitleDef != null && lstProcessTitleDef.size() == 1){
			//流程标题
			if(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT.equals(lstProcessTitleDef.get(0).getPtitleaccess())){
				prTB.setPrtitle(basisMap.get(lstProcessTitleDef.get(0).getPtitlename()));
			}else{
				prTB.setPrtitle(pd.getPdname());
			}
			//流程描述
			if(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT.equals(lstProcessTitleDef.get(0).getPdescaccess())){
				prTB.setPrdesc(basisMap.get(lstProcessTitleDef.get(0).getPdescname()));
			}else{
				prTB.setPrdesc(pd.getPdactname());
			}
		}
		//取得发起状态信息
		IG333Info psd = statusMap.get("待发起");
		Map<String, String> pp = ppMap.get("待发起");
		String pruserid = pp.get("处理人ID");
		User user = userBL.searchUserByKey(pruserid);
		if(user == null){
			throw new BLException("IGCO10000.E141","发起人信息不存在");
		}
		//取得发起人角色
		List<IG222Info> ppdList = participantDefMap.get(psd.getPsdid());
		List<Integer> roleIds = new ArrayList<Integer>();
		for(IG222Info info:ppdList){
			roleIds.add(info.getRoleid());
		}
		UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
		urcond.setRoleid_in(roleIds);
		urcond.setUserid(user.getUserid());
		List<UserRoleInfo> urList = userRoleBL.searchUserRoleVW(urcond);
		if(urList == null || urList.size() == 0){
			throw new BLException("IGCO10000.E141","发起人角色信息不存在");
		}
		prTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
		prTB.setPropentime(basisMap.get(IGPRR10BLType.PROCESS_BASIS_OPENTIME));
		prTB.setPrclosetime(basisMap.get(IGPRR10BLType.PROCESS_BASIS_CLOSETIME));
		prTB.setPruserid(user.getUserid());
		prTB.setPrusername(user.getUsername());
		prTB.setProrgid(user.getOrgid());
		prTB.setProrgname(user.getOrgname());
		prTB.setPrroleid(urList.get(0).getRoleid());
		prTB.setPrrolename(urList.get(0).getRolename());
		IG500Info pr = ig500BL.registIG500Info(prTB);
		//新增流程关闭状态日志
		//查询流程关闭状态标识
		String statusNow = workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), IGPRDCONSTANTS.PROCESS_END_STATUS);
		//获取时间
		Date dateTime = new Date();
		IG224TB currentRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		currentRecordStatusLogTB.setPrid(pr.getPrid());//流程ID
		currentRecordStatusLogTB.setPrtype(pr.getPrtype());//流程类型
		currentRecordStatusLogTB.setRslOpenTime(dateTime);//开始时间
		currentRecordStatusLogTB.setRslCloseTime(dateTime);
		currentRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);//当前流程状态
		currentRecordStatusLogTB.setPrpdid(pr.getPrpdid());//自定义流程类型ID
		currentRecordStatusLogTB.setVirtualstatus("0");//非虚拟状态
		currentRecordStatusLogTB.setPsdid(statusNow);//非虚拟状态
		this.ig224BL.registIG224Info(currentRecordStatusLogTB);
				
		for(Iterator<Entry<String, Map<String, String>>> iter = ppMap.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, String>> entry = iter.next();
			String key = entry.getKey();
			Map<String, String> value = entry.getValue();
			psd = statusMap.get(key);
			IG337TB ppTB = new IG337TB();
			ppTB.setPrid(pr.getPrid());
			ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
			ppTB.setPpstatus(psd.getPsdcode());
			ppTB.setPsdid(psd.getPsdid());
			ppTB.setPpinittime(pr.getPropentime());
			ppTB.setPpproctime(value.get("处理时间"));
			User u = userBL.searchUserByKey(value.get("处理人ID"));
			if(u == null){
				throw new BLException("IGCO10000.E141",key + "节点处理人信息不存在");
			}
			ppTB.setPpuserid(u.getUserid());
			ppTB.setPpusername(u.getUsername());
			ppTB.setPpuserinfo(u.getUsermobile());
			ppTB.setPporgid(u.getOrgid());
			ppTB.setPporgname(u.getOrgname());
			List<IG222Info> list = participantDefMap.get(psd.getPsdid());
			urcond = new UserRoleVWSearchCondImpl();
			urcond.setUserid(u.getUserid());
			if(list != null && list.size() > 0){
				List<Integer> roleidList = new ArrayList<Integer>();
				for(IG222Info info:list){
					roleidList.add(info.getRoleid());
				}
				urcond.setRoleid_in(roleidList);
			}
			List<UserRoleInfo> ur = userRoleBL.searchUserRoleVW(urcond);
			if(ur.size() > 0){
				ppTB.setPproleid(ur.get(0).getRoleid());
				ppTB.setPprolename(ur.get(0).getRolename());
			}
			ig337BL.registIG337Info(ppTB);
		}
		
		//表单值新增
		IG599TB instance = null;
		for(Iterator<Entry<String, Object>> iterator = processInfoMap.entrySet().iterator();iterator.hasNext();){
			//获取导入的表单信息
			Entry<String, Object> entry = iterator.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			instance = this.workFlowOperationBL.getProcessInfoTBInstance();//实例化流程表单实体
			//声明表格式表单实体
			IG898TB instance_table = null;
			if(processInfoDefMap.get(key) != null){
				//获取表单定义信息
				IG007Info ig007Info = processInfoDefMap.get(key);
				instance.setPrid(pr.getPrid());//流程主键
				instance.setPivarname(ig007Info.getPidname());//流程表单名称
				instance.setPivarlabel(ig007Info.getPidlabel());//流程表单显示名称
				instance.setPivartype(ig007Info.getPidtype());//流程表单类型
				instance.setPidid(ig007Info.getPidid());//流程表单主键
				instance.setPidmode(ig007Info.getPidmode());//流程表单模式
				
				if("8".equals(ig007Info.getPidtype())){
					instance.setPivarvalue("tab");//流程表单值
					List<Map<String, Object>> lst_processinfo_tab = (List<Map<String, Object>>)value;
					
					//查询表格式表单定义
					int num = 0;
					for (Map<String, Object> linkedHashMap : lst_processinfo_tab) {
						
						num ++;//获取行号
						instance_table = this.ig898BL.getIG898TBInstance();//实例化表格式表单实体
						instance_table.setPrid(pr.getPrid());
						instance_table.setPidid(ig007Info.getPidid());//流程表单主键
						instance_table.setPidname(ig007Info.getPidname());//流程表单名称
						instance_table.setPvrownumber(java.lang.String.valueOf(num));//行号
						
						//获取map集合
						Set<String> keySet = linkedHashMap.keySet();
						for (String pvcolname : keySet) {
							//获取表单定义信息
							IG007Info ig007Info_table = processInfoDefMap.get(pvcolname);
							
							instance_table.setPvcolpidid(ig007Info_table.getPidid());//流程表格式表单列ID
							instance_table.setPvcolname(ig007Info_table.getPidname());//流程表格式表单列名称
							
							//获取表单值信息
							String tab_value = (String)linkedHashMap.get(pvcolname);
							
							//表单值校验
							//获取表单定义信息
							tab_value = grtProcessInfoValue(tab_value, ig007Info_table);
							
							instance_table.setPvalue(tab_value);//表格式表单的值
							//新增表格式表单值
							this.ig898BL.registIG898(instance_table);
						}
					}
				}else{
					//表格式表单子项跳过
					if(StringUtils.isNotBlank(ig007Info.getPpidid())){
						continue;
					}
					
					//普通表单
					//获取流程表单值
					String pivarvalue = "";
					if(value != null){
						pivarvalue = grtProcessInfoValue((String)value, ig007Info);
					}
					instance.setPivarvalue(StringUtils.isEmpty(pivarvalue) ? ig007Info.getPiddefault() : pivarvalue);//流程表单值
				}
				
				//新增表单信息
				this.workFlowOperationBL.saveProcessInfo(instance);
//				IG599Info saveProcessInfo = this.workFlowOperationBL.saveProcessInfo(instance);
				
//				//创建和流程有关联信息的关系记录
//				saveProcessInfoValue(saveProcessInfo, (String)value, ig007Info);
			}
		}
		
		//添加导入日志
		insertImportLogByProcess(pr.getPrid(), user, "流程导入日志", "流程信息导入成功。");
		
	}
	
	/**
	 * 普通表单值生成
	 * 
	 * @param pivalue 导入表单值
	 * @param ig007Info 表单定义信息
	 * @return
	 */
	private String grtProcessInfoValue(String pivalue, IG007Info ig007Info)  throws BLException{
		String value = pivalue;
		String pidtype = ig007Info.getPidtype();
		if("2".equals(pidtype)){
			//下拉列表
			
		}else if ("3".equals(pidtype)){
			//日期
			
		}else if ("4".equals(pidtype)){
			//资产
		}else if ("5".equals(pidtype)){
			//流程
			
		}else if ("6".equals(pidtype)){
			//项目
			
		}else if ("7".equals(pidtype)){
			//数字控件
			
		}else if ("9".equals(pidtype)){
			//文本域
			
		}else if ("A".equals(pidtype)){
			//时间
			
		}else if ("B".equals(pidtype)){
			//单选
			
		}else if ("C".equals(pidtype)){
			//多选
			
		}else if ("E".equals(pidtype)){
			//单选其他
			
		}else if ("F".equals(pidtype)){
			//附件
			
		}else if ("G".equals(pidtype)){
			//机构树
			value = "_OrgTree_" + value;
			
		}else if ("O".equals(pidtype)){
			//机构
			
		}else if ("P".equals(pidtype)){
			//人员
			
		}else if ("R".equals(pidtype)){
			//角色
			
		}else if ("S".equals(pidtype)){
			//多选（其他）
			
		}else if ("T".equals(pidtype)){
			//树
			value = "_tree_" + value;
		}
		return value;
	}
	
	
	/**
	 * 流程表单定义信息查询
	 * @param pdid
	 * @return
	 * @throws BLException
	 */
	private Map<String, IG007Info> getProcessInfoDefinition(String pdid) throws BLException{
		Map<String, IG007Info> map = new HashMap<String, IG007Info>();
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);
		List<IG007Info> list = workFlowDefinitionBL.searchProcessInfoDef(cond);
		for(IG007Info info:list){
			map.put(info.getPidname(), info);
		}
		return map;
	}
	
	/**
	 * 流程导入日志信息新增
	 * @param pdid
	 * @return
	 * @throws BLException
	 */
	private void insertImportLogByProcess(Integer prid, User user, String desc, String comment) throws BLException{
		log.debug("================流程导入日志新增开始================");
		
		IG037TB instance = this.ig037BL.getIG037TBInstance();
		instance.setPrid(prid);//流程主键
		instance.setIrtime(IGStringUtils.getCurrentDateTime());//导入时间
		instance.setIruserid(user.getUserid());//导入用户ID
		instance.setIrusername(user.getUsername());//导入用户名称
		instance.setIrorgid(user.getOrgid());//导入部门ID
		instance.setIrorgname(user.getOrgname());//导入部门名称
		instance.setIrdesc(desc);//导入日志描述
		instance.setIrcomment(comment);//导入日志内容
		
		//保存日志
		this.ig037BL.registIG037(instance);
		
		log.debug("================流程导入日志新增结束================");
	}
	
	/**
	 * 获取导入Excel中的表单信息
	 * @param sheet Exccel中sheet对象
	 * @param row 表单信息起始行号
	 * @param rows 导入信息总行数
	 * @param processInfoDefMap 表单定义信息
	 * @return
	 * @throws BLException
	 */
	private Info<Map<String, Object>> getProcessInfo(Sheet sheet, int row, int rows,Map<String, IG007Info> processInfoDefMap) throws BLException{
		Info<Map<String, Object>> info = null;
		
		for(int i=row;i<rows;i++){
			//取得当前行的单元格
			Cell[] cells = sheet.getRow(i);
			Type type = eUtils.getType(cells[0].getCellFormat());
			if(Type.SIGN.equals(type)){
				String contents = cells[0].getContents();
				if(Sign.PROCESS_INFO.toString().equals(contents)){
					info = new Info<Map<String,Object>>();
					Map<String, Object> map = new HashMap<String, Object>();
					for(int index=i+1;index<rows;index++){
						cells = sheet.getRow(index);
						type = eUtils.getType(cells[0].getCellFormat());
						if(Type.SIGN.equals(type)){
							info.row = index;
							break;
						}
						
						//获取表单定义信息
						IG007Info ig007Info = processInfoDefMap.get(cells[0].getContents());
						if(ig007Info != null){
							if("8".equals(ig007Info.getPidtype())){
								
								List<Map<String, Object>> tableList = new ArrayList<Map<String,Object>>();
								Map<String, Object> mapTable = null;
								//获取表格式表单Excel中所占行数(默认占1行)
								int rows_contents = getRows(sheet, index, 1);
								//遍历表格式表单数据行
								for (int rcs = 1; rcs < rows_contents; rcs++) {
									//获取数据行的单元格信息数组
									Cell[] contents_cell = sheet.getRow(index + rcs);
									
									//封装表格式表单列信息
									mapTable = new HashMap<String, Object>();
									//遍历当前行所有单元格
									for (int j = 1; j < cells.length; j++) {
										if(StringUtils.isBlank(cells[j].getContents())){
											break;
										}
										mapTable.put(cells[j].getContents(), contents_cell[j].getContents());
									}
									//将表格式表单信息记录到集合中
									tableList.add(mapTable);
									
								}
							
								//如果是表格式表单，越过数据行
								index += (rows_contents - 1);
								//封装表格式表单信息
								map.put(cells[0].getContents(), tableList);
							}else{
								map.put(cells[0].getContents(), cells[1].getContents());
							}
						}
					}
					//封装表单信息后，跳出循环
					info.obj = map;
					break;
				}
			}
		}
		//没有获取到表单信息时，提示用户
		if(info == null){
			throw new BLException("IGCO10000.E141","流程表单信息不存在。");
		}
		return info;
	}

	private Map<String, IG333Info> getProcessStatusDefinition(String pdid) throws BLException{
		Map<String, IG333Info> map = new HashMap<String, IG333Info>();
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		List<IG333Info> list = workFlowDefinitionBL.searchProcessStatusDef(cond);
		for(IG333Info info:list){
			map.put(info.getPsdname(), info);
		}
		return map;
	}
	
	/**
	 * 计算表格式表单Excel中所占行数
	 * @param sheet Excel工作薄对象
	 * @param row 表单起始行数
	 * @param rows 表单所占行数
	 * @return
	 */
	private int getRows(Sheet sheet, int row, int rows){
		//取得下一行的单元格
		row++;
		Cell[] cells = sheet.getRow(row);
		
		if(!StringUtils.isBlank(cells[0].getContents())){
			
			return rows;
		}
		rows++;
		return getRows(sheet, row, rows);
	}
	/**
	 * 参与人定义map
	 * @param pdid
	 * @return
	 * @throws BLException
	 */
	private Map<String, List<IG222Info>> getProcessRoleDefinition(String pdid) throws BLException{
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPdid(pdid);
		List<IG222Info> list = workFlowDefinitionBL.searchParticipantDef(cond);
		Map<String, List<IG222Info>> map = new HashMap<String, List<IG222Info>>();
		for(IG222Info info : list){
			if(map.get(info.getPsdid()) == null){
				map.put(info.getPsdid(), new ArrayList<IG222Info>());
			}
			map.get(info.getPsdid()).add(info);
		}
		return map;
	}
	
	private Info<Map<String, Map<String, String>>> getParticipantInfo(Sheet sheet,int row, int rows) throws BLException{
		Info<Map<String, Map<String, String>>> info = null;
		for(int i=row;i<rows;i++){
			//取得当前行的单元格
			Cell[] cells = sheet.getRow(i);
			Type type = eUtils.getType(cells[0].getCellFormat());
			if(Type.SIGN.equals(type)){
				String contents = cells[0].getContents();
				if(Sign.PARTICIPANT.toString().equals(contents)){
					Map<String, Map<String, String>> map = new HashMap<String, Map<String,String>>();
					for(int index=i+2;index<rows;index++){
						cells = sheet.getRow(index);
						String psdname = cells[0].getContents();
						String userid = cells[1].getContents();
						String date = cells[2].getContents();
						String action = cells[3].getContents();
						String comment = cells[4].getContents();
						Map<String, String> temp = new HashMap<String, String>();
						temp.put("处理人ID", userid);
						temp.put("处理时间", date);
						temp.put("处理动作", action);
						temp.put("处理意见", comment);
						map.put(psdname, temp);
					}
					info = new Info<Map<String,Map<String,String>>>();
					info.obj = map;
					info.row = i + 1;
				}
			}
		}
		return info;
	}

	private Info<Map<String, String>> getBasisInfo(Sheet sheet, int row, int rows) throws BLException {
		Info<Map<String,String>> info = null;
		for(int i=row;i<rows;i++){
			//取得当前行的单元格
			Cell[] cells = sheet.getRow(i);
			Type type = eUtils.getType(cells[0].getCellFormat());
			if(Type.SIGN.equals(type)){
				String contents = cells[0].getContents();
				if(Sign.BASIS.toString().equals(contents)){
					info = new Info<Map<String,String>>();
					Map<String, String> map = new HashMap<String, String>();
					for(int index=i+1;index<rows;index++){
						//取得当前行的单元格
						cells = sheet.getRow(index);
						type = eUtils.getType(cells[0].getCellFormat());
						if(Type.SIGN.equals(type)){
							info.row = index;
							break;
						}
						map.put(cells[0].getContents(), cells[1].getContents());
					}
					info.obj = map;
					break;
				}
			}
		}
		if(info == null){
			throw new BLException("IGCO10000.E141","流程基本信息不存在");
		}
		return info;
	}

	private Info<IG380Info> getProcessDefinition(Sheet sheet, int row, int rows) throws BLException {
		Info<IG380Info> info = null;
		for(int i=row;i<rows;i++){
			//取得当前行的单元格
			Cell[] cells = sheet.getRow(i);
			Type type = eUtils.getType(cells[0].getCellFormat());
			if(Type.SIGN.equals(type)){
				String contents = cells[0].getContents();
				if(Sign.PDID.toString().equals(contents)){
					String pdid = cells[1].getContents();
					info = new Info<IG380Info>();
					info.obj = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid); 
					info.row = i + 1;
					if(!(i + 1 < rows && sheet.getRow(i + 1)[0].getContents().equals(info.obj.getPdname()))){
						throw new BLException("IGCO10000.E141","流程定义信息不正确");
					}
					break;
				}
			}
		}
		if(info == null){
			throw new BLException("IGCO10000.E141","流程定义信息不存在");
		}
		return info;
	}

	private FileInfo uploadFile(FormFile file) throws BLException{
		log.debug("===========上传文件操作开始============");
		FileInfo info = new FileInfo();
		if(file != null && file.getFileSize() > 0){
			//时间戳
//			String timestamp = util.getTimestamp();
			String timestamp = IGStringUtils.getAttKey();
			//取得当前年
			String year = timestamp.substring(0,4);
			//取得当前月
			String month = timestamp.substring(4,6);
			//取得当前天
			String day = timestamp.substring(6,8);
			//取得根目录
//			String rootPath = (String) util.get("TEMPLATE_IMPORT_FILE_PATH");
			String rootPath = ResourceUtility.getString("TEMPLATE_IMPORT_FILE_PATH");
			StringBuffer path = new StringBuffer();
			path.append(rootPath);
			path.append(year);
			path.append(File.separator);
			path.append(month);
			path.append(File.separator);
			path.append(day);
			path.append(File.separator);
			try {
				fileUploadBL.saveFile(file, path.toString(), timestamp + "_" + file.getFileName());
				info.filename = timestamp + "_" + file.getFileName();
				info.success = true;
				info.day = day;
				info.month = month;
				info.day = day;
				info.path = path.toString();
			} catch (BLException e) {
				throw e;
			} catch (Exception e) {
				throw new BLException("IGCO10000.E141","上传文件失败");
			}
		}else{
			throw new BLException("IGCO10000.E141","文件内容不存在");
		}
		log.debug("===========上传文件操作结束============");
		return info;
	}
	
	class Info<T>{
		
		/** 返回对象 */
		public T obj;
		
		/** 读取行 */
		public int row;
	}
	
	class FileInfo{
		
		/** 文件上传是否成功 */
		public boolean success = false;
		
		/** 上传路径 */
		public String path = null;
		
		/** 文件名 */
		public String filename = null;
		
		/** 年 */
		public String year = null;
		
		/** 月 */
		public String month = null;
		
		/** 日 */
		public String day = null;
		
		/**
		 * 取得文件对象
		 * @return 文件对象
		 */
		public File getFile(){
			return new File(path + filename);
		}
	}
}
