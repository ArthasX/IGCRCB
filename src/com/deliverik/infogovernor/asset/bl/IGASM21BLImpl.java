/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.bl.task.AuditConfigItemBL;
import com.deliverik.framework.asset.bl.task.AuditEntityItemBL;
import com.deliverik.framework.asset.bl.task.AuditResultBL;
import com.deliverik.framework.asset.bl.task.AuditTaskBL;
import com.deliverik.framework.asset.bl.task.AuditWaitTaskBL;
import com.deliverik.framework.asset.bl.task.CMDBConstants;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.bl.task.ImportVersionBL;
import com.deliverik.framework.asset.bl.task.SocImpactGraphBL;
import com.deliverik.framework.asset.model.AuditEntityItemInfo;
import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.AuditEntityItemSearchCondImpl;
import com.deliverik.framework.asset.model.condition.AuditTaskSearchCondImpl;
import com.deliverik.framework.asset.model.condition.AuditWaitTaskSearchCondImpl;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCondImpl;
import com.deliverik.framework.asset.model.entity.AuditResultTB;
import com.deliverik.framework.asset.model.entity.AuditTaskTB;
import com.deliverik.framework.asset.model.entity.AuditWaitTaskTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
import com.deliverik.infogovernor.asset.form.IGASM2101Form;
import com.deliverik.infogovernor.asset.form.IGASM2102Form;
import com.deliverik.infogovernor.asset.form.IGASM2103Form;
import com.deliverik.infogovernor.asset.form.IGASM2105Form;
import com.deliverik.infogovernor.asset.form.IGASM2108Form;
import com.deliverik.infogovernor.asset.form.IGASM2109Form;

/**
 * 概述: 资产审计业务逻辑实现
 * 功能描述: 资产审计业务逻辑实现
 * 创建记录: 2111/04/25
 * 修改记录: 
 */
public class IGASM21BLImpl extends BaseBLImpl implements IGASM21BL {
	static Log log = LogFactory.getLog(IGASM21BLImpl.class);

	/** 待处理任务业务逻辑接口 */
	protected AuditWaitTaskBL auditWaitTaskBL;
	
	/** 导入数据版本业务逻辑接口 */
	protected ImportVersionBL importVersionBL;
	
	/** 审计对比结果业务逻辑接口 */
	protected AuditResultBL auditResultBL;
	
	/** 审计任务业务逻辑接口 */
	protected AuditTaskBL auditTaskBL;
	
	/** 审计资产业务逻辑接口 */
	protected AuditEntityItemBL auditEntityItemBL;
	
	/** 审计资产属性业务逻辑接口 */
	protected AuditConfigItemBL auditConfigItemBL;
	
	/** 配置项信息BL */
	protected IG013BL ig013BL;
	
	/** 资产取值范围下拉数据BL */
	protected IG545BL ig545BL;
	
	/** 资产配置项BL */
	protected IG800BL ig800BL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/** 影响范围显示业务逻辑接口 */
	protected SocImpactGraphBL socImpactGraphBL;
	
	
	
	/**
	 * 影响范围显示业务逻辑接口设定
	 * @param socImpactGraphBL影响范围显示业务逻辑接口
	 */
	public void setSocImpactGraphBL(SocImpactGraphBL socImpactGraphBL) {
		this.socImpactGraphBL = socImpactGraphBL;
	}

	/**
	 * 机构BL设定
	 * @param organizationBL机构BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * 资产配置项BL设定
	 * @param ig800BL资产配置项BL 
	 */
	public void setIg800BL(IG800BL ig800BL) {
		this.ig800BL = ig800BL;
	}

	/**
	 * 资产取值范围下拉数据BL设定
	 * @param Ig545BL资产取值范围下拉数据BL
	 */
	public void setIg545BL(
			IG545BL ig545BL) {
		this.ig545BL = ig545BL;
	}

	/**
	 * 配置项信息BL
	 * @param ig013BL配置项信息BL
	 */
	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	/**
	 * 审计资产业务逻辑接口设定
	 * @param auditEntityItemBL审计资产业务逻辑接口
	 */
	public void setAuditEntityItemBL(AuditEntityItemBL auditEntityItemBL) {
		this.auditEntityItemBL = auditEntityItemBL;
	}

	/**
	 * 审计资产属性业务逻辑接口设定
	 * @param auditConfigItemBL审计资产属性业务逻辑接口
	 */
	public void setAuditConfigItemBL(AuditConfigItemBL auditConfigItemBL) {
		this.auditConfigItemBL = auditConfigItemBL;
	}

	/**
	 * 审计任务业务逻辑接口设定
	 * @param auditTaskBL审计任务业务逻辑接口
	 */
	public void setAuditTaskBL(AuditTaskBL auditTaskBL) {
		this.auditTaskBL = auditTaskBL;
	}

	/** 审计对比结果业务逻辑接口设定
	 * 
	 * @param auditResultBL 审计对比结果业务逻辑接口
	 */
	public void setAuditResultBL(AuditResultBL auditResultBL) {
		this.auditResultBL = auditResultBL;
	}

	/**
	 * 待处理任务业务逻辑接口设定
	 * 
	 * @param auditWaitTaskBL 待处理任务业务逻辑接口
	 */
	public void setAuditWaitTaskBL(AuditWaitTaskBL auditWaitTaskBL) {
		this.auditWaitTaskBL = auditWaitTaskBL;
	}

	/**
	 * 导入数据版本业务逻辑接口设定
	 * 
	 * @param importVersionBL 导入数据版本业务逻辑接口
	 */
	public void setImportVersionBL(ImportVersionBL importVersionBL) {
		this.importVersionBL = importVersionBL;
	}

	/**
	 * 审计控制台显示处理
	 * 
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2101Action(IGASM21DTO dto) throws BLException {
		log.debug("========审计控制台显示处理开始========");
		
		IGASM2101Form form = dto.getIgasm2101Form();
		//检测是否存在审计任务
		AuditTaskSearchCondImpl atCond = new AuditTaskSearchCondImpl();
		List<AuditTaskInfo> atList = this.auditTaskBL.searchAuditTask(atCond, 0, 0);
		if(atList.isEmpty()) {
			throw new BLException("IGASM2101.E007");
		} else {
			dto.setAuditTaskInfo(atList.get(0));
		}
		
		//检索条件生成
		AuditWaitTaskSearchCondImpl cond = new AuditWaitTaskSearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//未完成
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//已完成
		} else {
			cond.setTaskError(true);//异常
		}
		cond.setDeleteflag_eq("0");//启用
		
		//待处理任务列表
		List<AuditWaitTaskInfo> auditWaitTaskList = this.auditWaitTaskBL.searchAuditWaitTask(cond);
		
		if("0".equals(form.getTaskDone())) {//未完成
			
			//CI导入应用资源文件
			Properties properties = this.getProperties();
			//待插入文件名列表
			List<String> fileNames = new ArrayList<String>();
			//CI导入文件夹路径
			File ciFile = new File(properties.getProperty("AUDIT_CI_IMPORT_FILE_PATH"));
			//判断文件夹是否存在
			if(ciFile.exists() && ciFile.isDirectory()) {
				//获取文件列表
				 File[] files = ciFile.listFiles();
				 for(File file : files) {
					 //判断是否是文件
					 if(file.isFile()) {
						 fileNames.add(file.getName());
					 }
				 }
			} else {
				throw new BLException("IGASM2101.E002");
			}
		
			//导入数据列表
			ImportVersionSearchCondImpl ivCond = new ImportVersionSearchCondImpl();
			ivCond.setDeleteflag_eq("0");//启用
			List<ImportVersionInfo> importVersionList = this.importVersionBL.searchImportVersion(ivCond);
			
			//当前时间
			String createTime = IGStringUtils.getCurrentDateTime();
			
			//插入在导入数据列表中存在，并且不在待处理任务中的文件
			for(String fileName : fileNames) {
				checkCiImportFileName(fileName);//检测采集文件名是否合法
				String ciName = fileName.substring(0, fileName.lastIndexOf("_"));//顶级CI名称
				for(ImportVersionInfo iv : importVersionList) {
					if(iv.getImpeiname().equals(ciName)) {//判断顶级CI是否在导入数据表中存在
						boolean flag = true;
						for(AuditWaitTaskInfo ewt : auditWaitTaskList){
							if(ewt.getAuwtfilename().equals(fileName)) {//判断文件是否在待处理任务中存在
								flag = false;
								break;
							}
						}
						//插入操作
						if(flag) {
							AuditWaitTaskTB auditWaitTask = this.auditWaitTaskBL.getAuditWaitTaskTBInstance();
							auditWaitTask.setAuwttopci(ciName);//顶级CI名称
							auditWaitTask.setAuwtfilename(fileName);//文件名
							auditWaitTask.setAuwtcreatetime(createTime);//任务创建时间
							auditWaitTask.setAuwtstatus(CMDBConstants.TASK_STATUS_WAIT);//待处理
							auditWaitTask.setImpTypeid(iv.getImpcitype());//顶级CI类型
							auditWaitTask.setEiImportProgrammeTB(iv.getEiImportProgrammeTB());//不设第一次不好使，不显示对应名称。
							this.auditWaitTaskBL.registAuditWaitTask(auditWaitTask);
							log.debug("增加文件" + fileName);
						}
						break;
					}
				}
			}
			
			//查询任务列表
			dto.setAuditWaitTaskList(this.auditWaitTaskBL.searchAuditWaitTask(cond));
		
		} else {//已完成
			dto.setAuditWaitTaskList(auditWaitTaskList);
		}
		
		log.debug("========审计控制台显示处理终了========");
		return dto;
	}
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO deleteAuditWaitTaskAction(IGASM21DTO dto) throws BLException {
		log.debug("========删除待处理任务处理开始========");
		
		IGASM2101Form form = dto.getIgasm2101Form();
		
		String[] auwtids = form.getAuwtids();//主键
		
		//CI导入应用资源文件
		Properties properties = this.getProperties();
		
		//CI导入文件夹路径
		String ciFilePath  = properties.getProperty("AUDIT_CI_IMPORT_FILE_PATH");
		
		//删除任务和相应文件
		if(auwtids != null) {
			for(String auwtid : auwtids) {
				AuditWaitTaskInfo eit = this.auditWaitTaskBL.searchAuditWaitTaskByPK(Integer.parseInt(auwtid));
				File file = new File(ciFilePath + File.separator + eit.getAuwtfilename());
				if(file.exists()) {
					file.delete();
				}
				this.auditWaitTaskBL.deleteAuditWaitTask(eit);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", "任务"));
		
		log.debug("========删除待处理任务处理终了========");
		return dto;
	}
	
	/**
	 * 控制台任务查看处理
	 * 
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2103Action(IGASM21DTO dto) throws BLException {
		log.debug("========控制台任务查看处理开始========");
		
		IGASM2103Form form = dto.getIgasm2103Form();
		
		dto.setAuditWaitTask(this.auditWaitTaskBL.searchAuditWaitTaskByPK(form.getAuwtid()));
			
		log.debug("========控制台任务查看处理终了========");
		return dto;
	}
	
	/**
	 * 检测CI采集文件名是否合法
	 * 文件名格式为：顶级CI标识+‘_’+时间戳(YYYYMMDDHHMI)
	 * @param fileName 文件名
	 * @throws BLException 
	 */
	private void checkCiImportFileName(String fileName) throws BLException {
		if(fileName.indexOf("_") > 0 && fileName.indexOf(".") > 0 && fileName.lastIndexOf("_") < fileName.lastIndexOf(".")
				&& fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf(".")).length() == 10) {
		} else {
			throw new BLException("IGASM2101.E003", fileName);
		}
	}

	/**
	 * 审计控制台导入处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO importIGASM2101Action(IGASM21DTO dto) throws BLException {
		log.debug("========审计控制台导入处理开始========");
		IGASM2101Form form = dto.getIgasm2101Form();
		String[] auwtids = form.getAuwtids();
		List<String> topCIList = new ArrayList<String>();
		List<AuditWaitTaskInfo> awtList = new ArrayList<AuditWaitTaskInfo>();
		for(int i =0 ;i<auwtids.length;i++){
			String auwtid = auwtids[i];
			awtList.add(auditWaitTaskBL.searchAuditWaitTaskByPK(Integer.valueOf(auwtid)));
			topCIList.add(awtList.get(i).getAuwttopci());
		}
		//相同顶级CI只允许导入一次,不可再导入
		AuditEntityItemSearchCondImpl aeiCond = new AuditEntityItemSearchCondImpl();
		aeiCond.setTopCIList(topCIList);
		List<AuditEntityItemInfo> aeiList = this.auditEntityItemBL.searchAuditEntityItem(aeiCond);
		if(aeiList.size() > 0) {
			StringBuffer names = new StringBuffer();
			for(AuditEntityItemInfo aei : aeiList) {
				names.append(aei.getEiname()).append(",");
			}
			throw new BLException("IGASM2101.E008", names.toString().substring(0, names.length() - 1));
		}
		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("AUDIT_CI_IMPORT_BAT_NAME");
		String[] cmd = new String[10];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
        //从form中得到顶级ei名的数组、导入文件名数组、实体名数组
		String batNames = null;
		String filenames = null;
		String einames = null;
		String auwtidParms = null;
		AuditWaitTaskInfo auditWaitTaskInfo = null;
		for(int i =0 ;i<auwtids.length;i++){
			String auwtid = auwtids[i];
			auditWaitTaskInfo = awtList.get(i);
			
			//通过顶级ei名，去导入数据版本管理表中取得版本最大的那条数据的导入类型
			//通过类型，从导入程序管理表中取得批处理文件名和相对目录
			ImportVersionSearchCondImpl cond = new ImportVersionSearchCondImpl();
			cond.setImpeiname(auditWaitTaskInfo.getAuwttopci());
			List<ImportVersionInfo>	importVersionList = importVersionBL.searchImportVersion(cond);
			String batName = null;
			if(importVersionList.size() == 1) {
				batName = importVersionList.get(0).getEiImportProgrammeTB().getImpProgrammeAudit();
			} else {
				throw new BLException("IGCO10000.E004", auditWaitTaskInfo.getAuwttopci());
			}
			String filename = auditWaitTaskInfo.getAuwtfilename();
			String einame = auditWaitTaskInfo.getAuwttopci();
			if(i==0){
				batNames = batName;
				filenames = filename;
				einames = einame;
				auwtidParms = auwtid;
			}else{
				batNames = batNames + "!"+ batName;
				filenames = filenames + "!" + filename;
				einames = einames + "!" + einame;
				auwtidParms = auwtidParms + "!" + auwtid;
			}
			
		}
		try {
			User user = dto.getUser();	
			
			cmd[4] = filepath + importBatName;
			cmd[5] =filenames;
			cmd[6] =batNames;
			cmd[7] =einames;
			cmd[8] =user.getUserid()+ "!" + user.getUsername();
			cmd[9] =auwtidParms;
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("导入应用程序启动失败", e);
			throw new BLException("IGASM2101.E005");
		}
		log.debug("========审计控制台导入处理终了========");
		return dto;
	}
	
	private Properties getProperties() throws BLException {
		//CI导入应用资源文件
		Properties properties = null;
		//输入流
		FileInputStream inputFile = null;
		//加载属性文件
		try {
			properties = new Properties();
			inputFile = new FileInputStream(ResourceUtility.getString("CI_IMPORT_FILE_PATH"));
			properties.load(inputFile);
		} catch (FileNotFoundException e) {
			log.error("CI导入应用资源文件读取错误", e);
			throw new BLException("IGASM2101.E001");
		} catch (IOException e) {
			log.error("CI导入应用资源文件读取错误", e);
			throw new BLException("IGASM2101.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI导入应用资源文件读取错误", e);
					throw new BLException("IGASM2101.E001");
				}
			}
		}
		return properties;
	}
	
	/**
	 * 审计对比结果查询处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditResultAction(IGASM21DTO dto) throws BLException{
		
		log.debug("========审计对比结果查询处理开始========");
		
		List<AuditResultInfo> auditResultList = auditResultBL.searchAuditResult(dto.getAuditResultSearchCond());
		
		dto.setAuditResultList(auditResultList);
		
		log.debug("========审计对比结果查询处理终了========");
		
		return dto;
	}
	
	/**
	 * 审计对比结果保存处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public void updateAuditResultAction(IGASM21DTO dto) throws BLException{
		
		log.debug("========审计对比结果保存处理开始========");
		
		IGASM2102Form form = dto.getIgasm2102Form();
		
		// 选中集合
		Integer[] checkeds = form.getCheckbox(); 
		// 合理标识ID集合
		Integer[] aurids = form.getAurids();
		// 合理说明集合
		String[] auresultdesces = form.getAuresultdesces();
		
		// 将当前数据置成不合理
		auditResultBL.updateAuditResultWithout(dto.getAuditResultSearchCond());
		
		if(checkeds != null && checkeds.length > 0){
			
			// 将选中的集合放入list中
			List<Integer> checkedslist = new ArrayList<Integer>();
			for(Integer checked : checkeds){
				checkedslist.add(checked);
			}
			
			// 选中结果为不合理, 将原值覆盖回审计属性表
			if(aurids != null && aurids.length > 0){
				int i = 0;
				for(Integer aurid : aurids){
					if(checkedslist.contains(aurid)){
						// 选中结果为不合理
						AuditResultInfo ar = auditResultBL.searchAuditResultByPK(aurid);
						AuditResultTB arTB = (AuditResultTB) SerializationUtils.clone(ar);
						arTB.setAuflag(CMDBConstants.RESULT_AUFLAG_OUT);
						arTB.setAuresultdesc(auresultdesces[i]);
						auditResultBL.updateAuditResult(arTB);
					}
					i++;
				}
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I010", "提交"));
		log.debug("========审计对比结果保存处理终了========");
		
	}

	/**
	 * 审计任务登记处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO insertAuditTaskAction(IGASM21DTO dto) throws BLException {
		log.debug("========审计任务信息登记处理开始========");
		// 输入Form取得
		IGASM2105Form form = dto.getIgasm2105Form();
		//根据审计任务删除标识进行逻辑删除
		AuditTaskSearchCondImpl auditTaskSearchCond=new AuditTaskSearchCondImpl();
		auditTaskSearchCond.setAutstatus_eq("0");
		List<AuditTaskInfo> auditTaskInfoList=this.auditTaskBL.searchAuditTask(auditTaskSearchCond);
		if(auditTaskInfoList!=null){
			for(AuditTaskInfo auditTaskInfo:auditTaskInfoList){
				AuditTaskTB auditTask=(AuditTaskTB)SerializationUtils.clone(auditTaskInfo);
				auditTask.setAutstatus("1");
				this.auditTaskBL.updateAuditTask(auditTask);
			}
		}
		//对审计资产表中的数据进行物理删除
		this.auditEntityItemBL.deleteAuditEntityItem();
		//对审计资产属性表中的数据进行物理删除
		this.auditConfigItemBL.deleteAuditConfigItem();
		//审计任务要登记的信息
		String auttime=IGStringUtils.getCurrentDateTime();
		form.setAuttime(auttime);
		form.setAutstatus("0");
		dto.setIgasm2105Form(form);
		this.auditTaskBL.registAuditTask(dto.getIgasm2105Form());
		// 审计任务基本信息
		dto.addMessage(new ActionMessage("IGCO10000.I004", "审计任务基本信息"));
		log.debug("========导审计任务信息登记处理终了========");
		return dto;
	}

	/**
	 * 审计任务查询处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditTaskAction(IGASM21DTO dto) throws BLException {
		log.debug("========审计任务信息查询处理开始========");

		// 审计任务信息查询件数取得
		int totalCount = this.auditTaskBL.getSearchCount(dto.getAuditTaskSearchCond());
		
		if (totalCount == 0) {
			log.debug("========审计任务信息查询数据不存在========");
			// 审计任务信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========审计任务信息查询数据件数过多========");
			// 审计任务信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页审计任务信息取得
		List<AuditTaskInfo> auditTaskInfoList = this.auditTaskBL
				.searchAuditTask(dto.getAuditTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setAuditTaskInfoList(auditTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========审计任务信息查询处理终了========");
		return dto;
	}

	/**
	 * 审计任务查询处理（弹出页）
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditTaskActionForChoose(IGASM21DTO dto) throws BLException {
		log.debug("========审计任务信息查询处理开始========");

		// 审计任务信息查询件数取得
		int totalCount = this.auditTaskBL.getSearchCount(dto.getAuditTaskSearchCond());
		
		if (totalCount == 0) {
			log.debug("========审计任务信息查询数据不存在========");
			// 审计任务信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========审计任务信息查询数据件数过多========");
			// 审计任务信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页审计任务信息取得
		List<AuditTaskInfo> auditTaskInfoList = this.auditTaskBL
				.searchAuditTask(dto.getAuditTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setAuditTaskInfoList(auditTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========审计任务信息查询处理终了========");
		return dto;
	}

	/**
	 * 审计任务变更初期显示
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2105Action(IGASM21DTO dto) throws BLException {
		log.debug("========变更审计任务基本信息查询处理开始========");
		IGASM2105Form form = dto.getIgasm2105Form();
		AuditTaskInfo auditTaskInfo=this.auditTaskBL.searchAuditTaskByPK(form.getAutid());
		form.setAutid(auditTaskInfo.getAutid());//审计任务ID
		form.setAutdesc(auditTaskInfo.getAutdesc());//审计任务描述
		form.setAuttime(auditTaskInfo.getAuttime());//审计任务创建时间
		form.setAutstatus(auditTaskInfo.getAutstatus());//审计任务删除标识
		// 变更初始化模式
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", "审计任务基本信息"));
		log.debug("========变更审计任务基本信息查询处理终了========");
		return dto;
	}

	/**
	 * 审计任务变更处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO updateAuditTaskAction(IGASM21DTO dto) throws BLException {
		log.debug("========变更审计任务基本信息处理开始========");
		this.auditTaskBL.updateAuditTask(dto.getIgasm2105Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005", "审计任务基本信息"));
		log.debug("========变更审计任务基本信息处理终了========");
		return dto;
	}

	/**
	 * CI查询处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchEntityItemAction(IGASM21DTO dto) throws BLException {
		log.debug("========设备信息查询处理开始========");
		
		//设备信息查询件数取得 
		int totalCount = this.ig013BL.getIG688InfoSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			//设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页设备信息取得
		List<IG688Info> entityItemVWInfoList = this.ig013BL.searchIG688Info(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备信息查询处理终了========");
		return dto;
	}

	/**
	 * 设备详细信息查询处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2109Action(IGASM21DTO dto) throws BLException {
		log.debug("========设备配置信息编辑画面初期化处理开始========");
		
		IGASM2109Form form = dto.getIgasm2109Form();
		
		//设备信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				form.getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","设备");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
		form.setEistatus(entityItemVWInfo.getEistatus());
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		form.setEiorgsyscoding(eiorgsyscoding);
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				form.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEiorgname(form.getEiorgname());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//设备配置信息查询件数取得 
		int totalCount = this.ig800BL.getIG002InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========设备配置信息查询数据不存在========");
			//设备配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备配置信息查询数据件数过多========");
			//设备配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//配置项配置信息全件查询
		List<IG002Info> configItemVWInfoList = this.ig800BL.searchIG002Info(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<IG002Info>> map = new LinkedHashMap<String,List<IG002Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(IG002Info e : configItemVWInfoList){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<IG002Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = ig545BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if("5".equals(e.getCattach())){
				List<LabelValueBean> list = ig545BL.searchLabelValueBeanList(e.getCoption());
				if(list.size() > 0){
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		for(String str : strlist){
			for(IG002Info e : map.get(str)){
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
					entityItemCivalue[i] = e.getCivalue();
				} else {
					civalue[i] = e.getCivalue();
				}
				civalue_bak[i] = e.getCivalue();
				i++;
			}
		}
		
		form.setCivalue(civalue);
		form.setEntityItemCivalue(entityItemCivalue);
		form.setCivalue_bak(civalue_bak);
		
		dto.setConfigItemVWInfoMap(map);
		
		
		//获取历史版本更新时间
		if(entityItemVWInfo.getEiversion() > 0) {
			dto.setConfigItemVersionTime(this.ig013BL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}

		
		log.debug("========设备配置信息编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 设备影响范围查询处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2108Action(IGASM21DTO dto) throws BLException {
		log.debug("========设备影响范画面初期化处理开始========");
		
		IGASM2108Form form = dto.getIgasm2108Form();
		
		IG688Info ei = this.ig013BL.searchIG688InfoByKey(Integer.parseInt(form.getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), ei);
		
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			form.setFlag(flag);
			return dto;
		}else{
			form.setFlag(flag);
		}
		
//		Map<String,List<EntityItemEntityVWInfo>> entityItemEntityVWInfoMap=this.socImpactGraphBL.searchTopCI(ei);
//
//		dto.setEntityItemVWInfoMap(entityItemEntityVWInfoMap);
		
		log.debug("========设备影响范画面初期化处理终了========");
		return dto;
	}

	/**
	 * 审计控制台对比处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO compareIGASM2101Action(IGASM21DTO dto) throws BLException {
		log.debug("========审计控制台对比处理开始========");
		
		//审计实体表中无数据要在控制台提示数据还未进行导入的信息
		int count = this.auditEntityItemBL.getSearchCount(new AuditEntityItemSearchCondImpl());
		if(count == 0) {
			throw new BLException("IGASM2101.E009");
		}

		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("AUDIT_COMPARE_BAT_NAME");
		String[] cmd = new String[6];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + importBatName;
			cmd[5] = dto.getIgasm2101Form().getAutid().toString();
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("对比应用程序启动失败", e);
			throw new BLException("IGASM2101.E005");
		}
		log.debug("========审计控制台对比处理终了========");
		return dto;
	
	}
	
	/**
	 * 资产更新处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO updateEntityAction(IGASM21DTO dto) throws BLException{
		log.debug("========资产更新处理开始========");

		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("AUDIT_UPDATE_BAT_NAME");
		String[] cmd = new String[6];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + importBatName;
			cmd[5] = dto.getIgasm2102Form().getAutid().toString();
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("更新应用程序启动失败", e);
			throw new BLException("IGASM2102.E003");
		}
		
//		rootMarkUpdateAction(dto);
		
		log.debug("========资产更新处理终了========");
		return dto;
	
	
	}


//	
//	/**
//	 * 升级顶级CI(调用关系及升级bat)
//	 * 
//	 * @param dtoIGASM21DTO
//	 * @return IGASM21DTO
//	 * @throws BLException
//	 */
//	public IGASM21DTO rootMarkUpdateAction(IGASM21DTO dto) throws BLException{
//		
//		String eirootmarks = "";// 顶级CI的ID字符串
//		String einames = "";// 顶级CI名称字符串
//
//		// 获取顶级CI名称集合
//		Map<Integer, String> map = dto.getICNameMap();
//		if(map != null && map.size() > 0){
//			Iterator<Integer> iter = map.keySet().iterator();
//			while(iter.hasNext()){
//				Integer eirootmark = iter.next();
//				eirootmarks += "!" + String.valueOf(eirootmark);
//				einames += "!" + map.get(eirootmark);
//			}
//		}else{
//			// 不存在顶级CI
//			throw new BLException("IGASM2102.E001");
//		}
//		
//		if(StringUtils.isNotEmpty(eirootmarks)){
//			eirootmarks = eirootmarks.substring(2, eirootmarks.length());
//			einames = einames.substring(2, einames.length());
//		}
//
//		//取得安装路径
//		Properties properties = getProperties();
//		String filepath = properties.getProperty("INSTALL_FILE_PATH");
//		String updateBatName = properties.getProperty("ROOTMARK_UPDATE_BAT_NAME");
//		String[] cmd = new String[7];
//		cmd[0] = "cmd";
//		cmd[1] = "/c";
//		cmd[2] = "start";
//		cmd[3] = " ";
//		try {
//			cmd[4] = filepath + updateBatName;
//			cmd[5] = eirootmarks;
//			cmd[6] = einames;
//		    //调用bat文件执行
//			java.lang.Runtime.getRuntime().exec(cmd);
//
//		} catch (IOException e) {
//			log.error("升级CI应用程序启动失败", e);
//			throw new BLException("IGASM2102.E002");
//		}
//		
//		return dto;
//	}
}
