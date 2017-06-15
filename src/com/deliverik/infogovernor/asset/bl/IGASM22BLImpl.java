/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

import com.deliverik.framework.asset.bl.task.CIConfigItemBL;
import com.deliverik.framework.asset.bl.task.CIEntityItemBL;
import com.deliverik.framework.asset.bl.task.CIResultBL;
import com.deliverik.framework.asset.bl.task.CITaskBL;
import com.deliverik.framework.asset.bl.task.CIWaitTaskBL;
import com.deliverik.framework.asset.bl.task.CMDBConstants;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.bl.task.ImportVersionBL;
import com.deliverik.framework.asset.bl.task.SocImpactGraphBL;
import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.asset.model.CIEntityItemInfo;
import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.CIEntityItemSearchCondImpl;
import com.deliverik.framework.asset.model.condition.CITaskSearchCondImpl;
import com.deliverik.framework.asset.model.condition.CIWaitTaskSearchCondImpl;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCondImpl;
import com.deliverik.framework.asset.model.entity.CIResultTB;
import com.deliverik.framework.asset.model.entity.CITaskTB;
import com.deliverik.framework.asset.model.entity.CIWaitTaskTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2201Form;
import com.deliverik.infogovernor.asset.form.IGASM2202Form;
import com.deliverik.infogovernor.asset.form.IGASM2203Form;
import com.deliverik.infogovernor.asset.form.IGASM2205Form;
import com.deliverik.infogovernor.asset.form.IGASM2208Form;
import com.deliverik.infogovernor.asset.form.IGASM2209Form;

/**
 * 概述: 资产CI变更业务逻辑实现
 * 功能描述: 资产CI变更业务逻辑实现
 * 创建记录: 2211/04/25
 * 修改记录: 
 */
public class IGASM22BLImpl extends BaseBLImpl implements IGASM22BL {
	static Log log = LogFactory.getLog(IGASM22BLImpl.class);

	/** 待处理任务业务逻辑接口 */
	protected CIWaitTaskBL ciWaitTaskBL;
	
	/** 导入数据版本业务逻辑接口 */
	protected ImportVersionBL importVersionBL;
	
	/** CI变更对比结果业务逻辑接口 */
	protected CIResultBL ciResultBL;
	
	/** CI变更任务业务逻辑接口 */
	protected CITaskBL ciTaskBL;
	
	/** CI变更资产业务逻辑接口 */
	protected CIEntityItemBL ciEntityItemBL;
	
	/** CI变更资产属性业务逻辑接口 */
	protected CIConfigItemBL ciConfigItemBL;
	
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
	 * CI变更资产业务逻辑接口设定
	 * @param ciEntityItemBLCI变更资产业务逻辑接口
	 */
	public void setCiEntityItemBL(CIEntityItemBL ciEntityItemBL) {
		this.ciEntityItemBL = ciEntityItemBL;
	}

	/**
	 * CI变更资产属性业务逻辑接口设定
	 * @param ciConfigItemBLCI变更资产属性业务逻辑接口
	 */
	public void setCiConfigItemBL(CIConfigItemBL ciConfigItemBL) {
		this.ciConfigItemBL = ciConfigItemBL;
	}

	/**
	 * CI变更任务业务逻辑接口设定
	 * @param ciTaskBLCI变更任务业务逻辑接口
	 */
	public void setCiTaskBL(CITaskBL ciTaskBL) {
		this.ciTaskBL = ciTaskBL;
	}

	/** CI变更对比结果业务逻辑接口设定
	 * 
	 * @param ciResultBL CI变更对比结果业务逻辑接口
	 */
	public void setCiResultBL(CIResultBL ciResultBL) {
		this.ciResultBL = ciResultBL;
	}

	/**
	 * 待处理任务业务逻辑接口设定
	 * 
	 * @param ciWaitTaskBL 待处理任务业务逻辑接口
	 */
	public void setCiWaitTaskBL(CIWaitTaskBL ciWaitTaskBL) {
		this.ciWaitTaskBL = ciWaitTaskBL;
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
	 * CI变更控制台显示处理
	 * 
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2201Action(IGASM22DTO dto) throws BLException {
		log.debug("========CI变更控制台显示处理开始========");
		
		IGASM2201Form form = dto.getIgasm2201Form();
		
		//检测是否存在审计任务
		CITaskSearchCondImpl citCond = new CITaskSearchCondImpl();
		List<CITaskInfo> citList = this.ciTaskBL.searchCITask(citCond, 0, 0);
		if(citList.isEmpty()) {
			throw new BLException("IGASM2201.E007");
		} else {
			dto.setCiTaskInfo(citList.get(0));
		}
		
		//检索条件生成
		CIWaitTaskSearchCondImpl cond = new CIWaitTaskSearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//未完成
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//已完成
		} else {
			cond.setTaskError(true);//异常
		}
		cond.setDeleteflag_eq("0");//启用
		
		//待处理任务列表
		List<CIWaitTaskInfo> ciWaitTaskList = this.ciWaitTaskBL.searchCIWaitTask(cond);
		
		if("0".equals(form.getTaskDone())) {//未完成
			
			//CI导入应用资源文件
			Properties properties = this.getProperties();
			//待插入文件名列表
			List<String> fileNames = new ArrayList<String>();
			//CI导入文件夹路径
			File ciFile = new File(properties.getProperty("UPDATE_CI_IMPORT_FILE_PATH"));
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
				throw new BLException("IGASM2201.E002");
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
						for(CIWaitTaskInfo ewt : ciWaitTaskList){
							if(ewt.getCiwtfilename().equals(fileName)) {//判断文件是否在待处理任务中存在
								flag = false;
								break;
							}
						}
						//插入操作
						if(flag) {
							CIWaitTaskTB ciWaitTask = this.ciWaitTaskBL.getCIWaitTaskTBInstance();
							ciWaitTask.setCiwttopci(ciName);//顶级CI名称
							ciWaitTask.setCiwtfilename(fileName);//文件名
							ciWaitTask.setCiwtcreatetime(createTime);//任务创建时间
							ciWaitTask.setCiwtstatus(CMDBConstants.TASK_STATUS_WAIT);//待处理
							ciWaitTask.setImpTypeid(iv.getImpcitype());//顶级CI类型
							ciWaitTask.setEiImportProgrammeTB(iv.getEiImportProgrammeTB());//不设第一次不好使，不显示对应名称。
							this.ciWaitTaskBL.registCIWaitTask(ciWaitTask);
							log.debug("增加文件" + fileName);
						}
						break;
					}
				}
			}
			
			//查询任务列表
			dto.setCiWaitTaskList(this.ciWaitTaskBL.searchCIWaitTask(cond));
		
		} else {//已完成
			dto.setCiWaitTaskList(ciWaitTaskList);
		}
		
		log.debug("========CI变更控制台显示处理终了========");
		return dto;
	}
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO deleteCIWaitTaskAction(IGASM22DTO dto) throws BLException {
		log.debug("========删除待处理任务处理开始========");
		
		IGASM2201Form form = dto.getIgasm2201Form();
		
		String[] ciwtids = form.getCiwtids();//主键
		
		//CI导入应用资源文件
		Properties properties = this.getProperties();
		
		//CI导入文件夹路径
		String ciFilePath  = properties.getProperty("CI_UPDATE_IMPORT_FILE_PATH");
		
		//删除任务和相应文件
		if(ciwtids != null) {
			for(String ciwtid : ciwtids) {
				CIWaitTaskInfo eit = this.ciWaitTaskBL.searchCIWaitTaskByPK(Integer.parseInt(ciwtid));
				File file = new File(ciFilePath + File.separator + eit.getCiwtfilename());
				if(file.exists()) {
					file.delete();
				}
				this.ciWaitTaskBL.deleteCIWaitTask(eit);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", "任务"));
		
		log.debug("========删除待处理任务处理终了========");
		return dto;
	}
	
	/**
	 * 控制台任务查看处理
	 * 
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2203Action(IGASM22DTO dto) throws BLException {
		log.debug("========控制台任务查看处理开始========");
		
		IGASM2203Form form = dto.getIgasm2203Form();
		
		dto.setCiWaitTask(this.ciWaitTaskBL.searchCIWaitTaskByPK(form.getCiwtid()));
			
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
			throw new BLException("IGASM2201.E003", fileName);
		}
	}

	/**
	 * CI变更控制台导入处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO importIGASM2201Action(IGASM22DTO dto) throws BLException {
		log.debug("========CI变更控制台导入处理开始========");
		IGASM2201Form form = dto.getIgasm2201Form();
		String[] ciwtids = form.getCiwtids();
		List<String> topCIList = new ArrayList<String>();
		List<CIWaitTaskInfo> ciwtList = new ArrayList<CIWaitTaskInfo>();
		for(int i =0 ;i<ciwtids.length;i++){
			String auwtid = ciwtids[i];
			ciwtList.add(ciWaitTaskBL.searchCIWaitTaskByPK(Integer.valueOf(auwtid)));
			topCIList.add(ciwtList.get(i).getCiwttopci());
		}
		//相同顶级CI只允许导入一次,不可再导入
		CIEntityItemSearchCondImpl cieiCond = new CIEntityItemSearchCondImpl();
		cieiCond.setTopCIList(topCIList);
		List<CIEntityItemInfo> aeiList = this.ciEntityItemBL.searchCIEntityItem(cieiCond);
		if(aeiList.size() > 0) {
			StringBuffer names = new StringBuffer();
			for(CIEntityItemInfo aei : aeiList) {
				names.append(aei.getEiname()).append(",");
			}
			throw new BLException("IGASM2201.E008", names.toString().substring(0, names.length() - 1));
		}
		
		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("UPDATE_CI_IMPORT_BAT_NAME");
		String[] cmd = new String[10];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
        //从form中得到顶级ei名的数组、导入文件名数组、实体名数组
		String batNames = null;
		String filenames = null;
		String einames = null;
		String ciwtidParms = null;
		CIWaitTaskInfo ciWaitTaskInfo = null;
		for(int i =0 ;i<ciwtids.length;i++){
			String ciwtid = ciwtids[i];
			ciWaitTaskInfo = ciwtList.get(i);
			
			//通过顶级ei名，去导入数据版本管理表中取得版本最大的那条数据的导入类型
			//通过类型，从导入程序管理表中取得批处理文件名和相对目录
			ImportVersionSearchCondImpl cond = new ImportVersionSearchCondImpl();
			cond.setImpeiname(ciWaitTaskInfo.getCiwttopci());
			List<ImportVersionInfo>	importVersionList = importVersionBL.searchImportVersion(cond);
			String batName = null;
			if(importVersionList.size() == 1) {
				batName = importVersionList.get(0).getEiImportProgrammeTB().getImpProgrammeUpdate();
			} else {
				throw new BLException("IGCO10000.E004", ciWaitTaskInfo.getCiwttopci());
			}
			String filename = ciWaitTaskInfo.getCiwtfilename();
			String einame = ciWaitTaskInfo.getCiwttopci();
			if(i==0){
				batNames = batName;
				filenames = filename;
				einames = einame;
				ciwtidParms = ciwtid;
			}else{
				batNames = batNames + "!"+ batName;
				filenames = filenames + "!" + filename;
				einames = einames + "!" + einame;
				ciwtidParms = ciwtidParms + "!" + ciwtid;
			}
			
		}
		try {
			User user = dto.getUser();	
			
			cmd[4] = filepath + importBatName;
			cmd[5] =filenames;
			cmd[6] =batNames;
			cmd[7] =einames;
			cmd[8] =user.getUserid()+ "!" + user.getUsername();
			cmd[9] =ciwtidParms;
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("导入应用程序启动失败", e);
			throw new BLException("IGASM2201.E005");
		}
		log.debug("========CI变更控制台导入处理终了========");
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
			throw new BLException("IGASM2201.E001");
		} catch (IOException e) {
			log.error("CI导入应用资源文件读取错误", e);
			throw new BLException("IGASM2201.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI导入应用资源文件读取错误", e);
					throw new BLException("IGASM2201.E001");
				}
			}
		}
		return properties;
	}
	
	/**
	 * CI变更对比结果查询处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchCIResultAction(IGASM22DTO dto) throws BLException{
		
		log.debug("========CI变更对比结果查询处理开始========");
		
		List<CIResultInfo> ciResultList = ciResultBL.searchCIResult(dto.getCiResultSearchCond());
		
		dto.setCiResultList(ciResultList);
		
		log.debug("========CI变更对比结果查询处理终了========");
		
		return dto;
	}
	
	/**
	 * CI变更对比结果保存处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public void updateCIResultAction(IGASM22DTO dto) throws BLException{
		
		log.debug("========CI变更对比结果保存处理开始========");
		
		IGASM2202Form form = dto.getIgasm2202Form();
		
		// 选中集合
		Integer[] checkeds = form.getCheckbox(); 
		// 合理标识ID集合
		Integer[] cirids = form.getCirids();
		// 合理说明集合
		String[] ciresultdesces = form.getCiresultdesces();
		
		// 将当前数据置成不合理
		ciResultBL.updateCIResultWithout(dto.getCiResultSearchCond());
		
		if(checkeds != null && checkeds.length > 0){
			
			// 将选中的集合放入list中
			List<Integer> checkedslist = new ArrayList<Integer>();
			for(Integer checked : checkeds){
				checkedslist.add(checked);
			}
			
			// 选中结果为不合理, 将原值覆盖回CI变更属性表
			if(cirids != null && cirids.length > 0){
				int i = 0;
				for(Integer cirid : cirids){
					if(checkedslist.contains(cirid)){
						// 选中结果为不合理
						CIResultInfo ar = ciResultBL.searchCIResultByPK(cirid);
						CIResultTB arTB = (CIResultTB) SerializationUtils.clone(ar);
						arTB.setCiflag(CMDBConstants.RESULT_AUFLAG_OUT);
						arTB.setCiresultdesc(ciresultdesces[i]);
						ciResultBL.updateCIResult(arTB);
					}
					i++;
				}
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I010", "提交"));
		log.debug("========CI变更对比结果保存处理终了========");
		
	}

	/**
	 * CI变更任务登记处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO insertCITaskAction(IGASM22DTO dto) throws BLException {
		log.debug("========CI变更任务信息登记处理开始========");
		// 输入Form取得
		IGASM2205Form form = dto.getIgasm2205Form();
		//根据CI变更任务删除标识进行逻辑删除
		CITaskSearchCondImpl ciTaskSearchCond=new CITaskSearchCondImpl();
		ciTaskSearchCond.setCitstatus_eq("0");
		List<CITaskInfo> ciTaskInfoList=this.ciTaskBL.searchCITask(ciTaskSearchCond);
		if(ciTaskInfoList!=null){
			for(CITaskInfo ciTaskInfo:ciTaskInfoList){
				CITaskTB ciTask=(CITaskTB)SerializationUtils.clone(ciTaskInfo);
				ciTask.setCitstatus("1");
				this.ciTaskBL.updateCITask(ciTask);
			}
		}
		//对CI变更资产表中的数据进行物理删除
		List<CIEntityItemInfo> ciEntityItemInfoList=this.ciEntityItemBL.searchCIEntityItem();
		if(ciEntityItemInfoList!=null){
			for(CIEntityItemInfo ciEntityItemInfo:ciEntityItemInfoList){
				this.ciEntityItemBL.deleteCIEntityItem(ciEntityItemInfo);
			}
		}
		//对CI变更资产属性表中的数据进行物理删除
		List<CIConfigItemInfo> ciConfigItemInfoList=this.ciConfigItemBL.searchCIConfigItem();
		if(ciConfigItemInfoList!=null){
			for(CIConfigItemInfo ciConfigItemInfo:ciConfigItemInfoList){
				this.ciConfigItemBL.deleteCIConfigItem(ciConfigItemInfo);
			}
		}
		//CI变更任务要登记的信息
		String cittime=IGStringUtils.getCurrentDateTime();
		form.setCittime(cittime);
		form.setCitstatus("0");
		dto.setIgasm2205Form(form);
		this.ciTaskBL.registCITask(dto.getIgasm2205Form());
		// CI变更任务基本信息
		dto.addMessage(new ActionMessage("IGCO10000.I004", "CI更新任务基本信息"));
		log.debug("========导CI变更任务信息登记处理终了========");
		return dto;
	}

	/**
	 * CI变更任务查询处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchCITaskAction(IGASM22DTO dto) throws BLException {
		log.debug("========CI变更任务信息查询处理开始========");

		// CI变更任务信息查询件数取得
		int totalCount = this.ciTaskBL.getSearchCount(dto.getCiTaskSearchCond());
		
		if (totalCount == 0) {
			log.debug("========CI变更任务信息查询数据不存在========");
			// CI变更任务信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========CI变更任务信息查询数据件数过多========");
			// CI变更任务信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页CI变更任务信息取得
		List<CITaskInfo> ciTaskInfoList = this.ciTaskBL
				.searchCITask(dto.getCiTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setCiTaskInfoList(ciTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========CI变更任务信息查询处理终了========");
		return dto;
	}

	/**
	 * CI变更任务变更初期显示
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2205Action(IGASM22DTO dto) throws BLException {
		log.debug("========变更CI变更任务基本信息查询处理开始========");
		IGASM2205Form form = dto.getIgasm2205Form();
		CITaskInfo ciTaskInfo=this.ciTaskBL.searchCITaskByPK(form.getCitid());
		form.setCitid(ciTaskInfo.getCitid());//CI变更任务ID
		form.setCitdesc(ciTaskInfo.getCitdesc());//CI变更任务描述
		form.setCittime(ciTaskInfo.getCittime());//CI变更任务创建时间
		form.setCitstatus(ciTaskInfo.getCitstatus());//CI变更任务删除标识
		// 变更初始化模式
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", "CI更新任务基本信息"));
		log.debug("========变更CI变更任务基本信息查询处理终了========");
		return dto;
	}

	/**
	 * CI变更任务变更处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO updateCITaskAction(IGASM22DTO dto) throws BLException {
		log.debug("========变更CI变更任务基本信息处理开始========");
		this.ciTaskBL.updateCITask(dto.getIgasm2205Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005","CI更新任务基本信息"));
		log.debug("========变更CI变更任务基本信息处理终了========");
		return dto;
	}

	/**
	 * CI查询处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchEntityItemAction(IGASM22DTO dto) throws BLException {
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
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2209Action(IGASM22DTO dto) throws BLException {
		log.debug("========设备配置信息编辑画面初期化处理开始========");
		
		IGASM2209Form form = dto.getIgasm2209Form();
		
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
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2208Action(IGASM22DTO dto) throws BLException {
		log.debug("========设备影响范画面初期化处理开始========");
		
		IGASM2208Form form = dto.getIgasm2208Form();
		
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
	 * CI变更控制台对比处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO compareIGASM2201Action(IGASM22DTO dto) throws BLException {
		log.debug("========CI变更控制台对比处理开始========");
		
		//更新实体表中无数据要在控制台提示数据还未进行导入的信息
		int count = this.ciEntityItemBL.getSearchCount(new CIEntityItemSearchCondImpl());
		if(count == 0) {
			throw new BLException("IGASM2201.E009");
		}

		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("UPDATE_CI_COMPARE_BAT_NAME");
		String[] cmd = new String[5];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + importBatName;
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("对比应用程序启动失败", e);
			throw new BLException("IGASM2201.E005");
		}
		log.debug("========CI变更控制台对比处理终了========");
		return dto;
	
	}
	
	/**
	 * 资产更新处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO updateEntityAction(IGASM22DTO dto) throws BLException{
		log.debug("========资产更新处理开始========");

		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("UPDATE_CI_UPDATE_BAT_NAME");
		String[] cmd = new String[5];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + importBatName;
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("更新应用程序启动失败", e);
			throw new BLException("IGASM2202.E003");
		}
		log.debug("========资产更新处理终了========");
		return dto;
	
	}

	
	/**
	 * 升级顶级CI(调用关系及升级bat)
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO rootMarkUpdateAction(IGASM22DTO dto) throws BLException{
		
		String eirootmarks = "";// 顶级CI的ID字符串
		String einames = "";// 顶级CI名称字符串

		// 获取顶级CI名称集合
		Map<Integer, String> map = dto.getICNameMap();
		if(map != null && map.size() > 0){
			Iterator<Integer> iter = map.keySet().iterator();
			while(iter.hasNext()){
				Integer eirootmark = iter.next();
				eirootmarks += "!" + String.valueOf(eirootmark);
				einames += "!" + map.get(eirootmark);
			}
		}else{
			// 不存在顶级CI
			throw new BLException("IGASM2202.E001");
		}
		
		if(StringUtils.isNotEmpty(eirootmarks)){
			eirootmarks = eirootmarks.substring(2, eirootmarks.length());
			einames = einames.substring(2, einames.length());
		}

		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String updateBatName = properties.getProperty("ROOTMARK_UPDATE_BAT_NAME");
		String[] cmd = new String[7];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + updateBatName;
			cmd[5] = eirootmarks;
			cmd[6] = einames;
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("升级CI应用程序启动失败", e);
			throw new BLException("IGASM2202.E002");
		}
		
		return dto;
	}
}
