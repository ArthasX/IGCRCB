/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.bl;

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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.bl.task.CMDBConstants;
import com.deliverik.framework.soc.asset.bl.task.SOC0101BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0102BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0103BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0104BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0105BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0106BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0120BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.bl.task.SocImpactGraphBL;
import com.deliverik.framework.soc.asset.model.SOC0102Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0102SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0104SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0105SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0103TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0104TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0105TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0106TB;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0301Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0302Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0303Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0305Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0308Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0309Form;

/**
 * 概述: 资产审计业务逻辑实现
 * 功能描述: 资产审计业务逻辑实现
 * 创建记录: 2111/04/25
 * 修改记录: 
 */
public class IGCIM03BLImpl extends BaseBLImpl implements IGCIM03BL {
	static Log log = LogFactory.getLog(IGCIM03BLImpl.class);

	protected MessageResources resources = MessageResources
			.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources");

	/** 待处理任务业务逻辑接口 */
	protected SOC0105BL soc0105BL;
	/** 待处理任务业务临时逻辑接口 */
	protected SOC0106BL soc0106BL;
	
	/** 导入数据版本业务逻辑接口 */
	protected SOC0120BL soc0120BL;
	
	/** 审计对比结果业务逻辑接口 */
	protected SOC0103BL soc0103BL;
	
	/** 审计任务业务逻辑接口 */
	protected SOC0104BL soc0104BL;
	
	/** 审计资产业务逻辑接口 */
	protected SOC0102BL soc0102BL;
	
	/** 审计资产属性业务逻辑接口 */
	protected SOC0101BL soc0101BL;
	
	/** 配置项信息BL */
	protected SOC0118BL soc0118BL;
	
	/** 资产取值范围下拉数据BL */
	protected SOC0151BL soc0151BL;
	
	/** 资产配置项BL */
	protected SOC0107BL soc0107BL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/** 影响范围显示业务逻辑接口 */
	protected SocImpactGraphBL socImpactGraphBL;
	
	
	


	/**
	 * 待处理任务业务逻辑接口取得
	 *
	 * @return soc0105BL 待处理任务业务逻辑接口
	 */
	public SOC0105BL getSoc0105BL() {
		return soc0105BL;
	}

	/**
	 * 待处理任务业务逻辑接口设定
	 *
	 * @param soc0105BL 待处理任务业务逻辑接口
	 */
	public void setSoc0105BL(SOC0105BL soc0105BL) {
		this.soc0105BL = soc0105BL;
	}

	/**
	 * 待处理任务业务临时逻辑接口取得
	 *
	 * @return soc0106BL 待处理任务业务临时逻辑接口
	 */
	public SOC0106BL getSoc0106BL() {
		return soc0106BL;
	}

	/**
	 * 待处理任务业务临时逻辑接口设定
	 *
	 * @param soc0106BL 待处理任务业务临时逻辑接口
	 */
	public void setSoc0106BL(SOC0106BL soc0106BL) {
		this.soc0106BL = soc0106BL;
	}

	/**
	 * 导入数据版本业务逻辑接口取得
	 *
	 * @return soc0120BL 导入数据版本业务逻辑接口
	 */
	public SOC0120BL getSoc0120BL() {
		return soc0120BL;
	}

	/**
	 * 导入数据版本业务逻辑接口设定
	 *
	 * @param soc0120BL 导入数据版本业务逻辑接口
	 */
	public void setSoc0120BL(SOC0120BL soc0120BL) {
		this.soc0120BL = soc0120BL;
	}

	/**
	 * 审计对比结果业务逻辑接口取得
	 *
	 * @return soc0103BL 审计对比结果业务逻辑接口
	 */
	public SOC0103BL getSoc0103BL() {
		return soc0103BL;
	}

	/**
	 * 审计对比结果业务逻辑接口设定
	 *
	 * @param soc0103BL 审计对比结果业务逻辑接口
	 */
	public void setSoc0103BL(SOC0103BL soc0103BL) {
		this.soc0103BL = soc0103BL;
	}

	/**
	 * 审计任务业务逻辑接口取得
	 *
	 * @return soc0104BL 审计任务业务逻辑接口
	 */
	public SOC0104BL getSoc0104BL() {
		return soc0104BL;
	}

	/**
	 * 审计任务业务逻辑接口设定
	 *
	 * @param soc0104BL 审计任务业务逻辑接口
	 */
	public void setSoc0104BL(SOC0104BL soc0104BL) {
		this.soc0104BL = soc0104BL;
	}

	/**
	 * 审计资产业务逻辑接口取得
	 *
	 * @return soc0102BL 审计资产业务逻辑接口
	 */
	public SOC0102BL getSoc0102BL() {
		return soc0102BL;
	}

	/**
	 * 审计资产业务逻辑接口设定
	 *
	 * @param soc0102BL 审计资产业务逻辑接口
	 */
	public void setSoc0102BL(SOC0102BL soc0102BL) {
		this.soc0102BL = soc0102BL;
	}

	/**
	 * 审计资产属性业务逻辑接口取得
	 *
	 * @return soc0101BL 审计资产属性业务逻辑接口
	 */
	public SOC0101BL getSoc0101BL() {
		return soc0101BL;
	}

	/**
	 * 审计资产属性业务逻辑接口设定
	 *
	 * @param soc0101BL 审计资产属性业务逻辑接口
	 */
	public void setSoc0101BL(SOC0101BL soc0101BL) {
		this.soc0101BL = soc0101BL;
	}

	/**
	 * 配置项信息BL取得
	 *
	 * @return soc0118BL 配置项信息BL
	 */
	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}

	/**
	 * 配置项信息BL设定
	 *
	 * @param soc0118BL 配置项信息BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}


	public SOC0151BL getSoc0151BL() {
		return soc0151BL;
	}

	public void setSoc0151BL(SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}

	/**
	 * 资产配置项BL取得
	 *
	 * @return soc0107BL 资产配置项BL
	 */
	public SOC0107BL getSoc0107BL() {
		return soc0107BL;
	}

	/**
	 * 资产配置项BL设定
	 *
	 * @param soc0107BL 资产配置项BL
	 */
	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}

	/**
	 * 机构BL取得
	 *
	 * @return organizationBL 机构BL
	 */
	public OrganizationBL getOrganizationBL() {
		return organizationBL;
	}

	/**
	 * 机构BL设定
	 *
	 * @param organizationBL 机构BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * 影响范围显示业务逻辑接口取得
	 *
	 * @return socImpactGraphBL 影响范围显示业务逻辑接口
	 */
	public SocImpactGraphBL getSocImpactGraphBL() {
		return socImpactGraphBL;
	}

	/**
	 * 影响范围显示业务逻辑接口设定
	 *
	 * @param socImpactGraphBL 影响范围显示业务逻辑接口
	 */
	public void setSocImpactGraphBL(SocImpactGraphBL socImpactGraphBL) {
		this.socImpactGraphBL = socImpactGraphBL;
	}

	/**
	 * 审计控制台显示处理
	 * 
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0301Action(IGCIM03DTO dto) throws BLException {
		log.debug("========审计控制台显示处理开始========");
		
		IGCIM0301Form form = dto.getIgcim0301Form();
		//检测是否存在审计任务
		SOC0104SearchCondImpl atCond = new SOC0104SearchCondImpl();
		List<SOC0104Info> atList = this.soc0104BL.searchSOC0104(atCond, 0, 0);
		if(atList.isEmpty()) {
			throw new BLException("IGCIM0301.E007");
		} else {
			dto.setAuditTaskInfo(atList.get(0));
		}
		
		//检索条件生成
		SOC0105SearchCondImpl cond = new SOC0105SearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//未完成
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//已完成
		} else {
			cond.setTaskError(true);//异常
		}
		cond.setDeleteflag_eq("0");//启用
		
		//待处理任务列表
		List<SOC0105Info> auditWaitTaskList = this.soc0105BL.searchSOC0105(cond);
		
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
				throw new BLException("IGCIM0301.E002");
			}
		
			//导入数据列表
			SOC0120SearchCondImpl ivCond = new SOC0120SearchCondImpl();
			ivCond.setDeleteflag_eq("0");//启用
			List<SOC0120Info> importVersionList = this.soc0120BL.searchImportVersion(ivCond);
			
			//当前时间
			String createTime = IGStringUtils.getCurrentDateTime();
			
			//插入在导入数据列表中存在，并且不在待处理任务中的文件
			for(String fileName : fileNames) {
				checkCiImportFileName(fileName);//检测采集文件名是否合法
				String ciName = fileName.substring(0, fileName.lastIndexOf("_"));//顶级CI名称
				for(SOC0120Info iv : importVersionList) {
					if(iv.getImpeiname().equals(ciName)) {//判断顶级CI是否在导入数据表中存在
						boolean flag = true;
						for(SOC0105Info ewt : auditWaitTaskList){
							if(ewt.getAuwtfilename().equals(fileName)) {//判断文件是否在待处理任务中存在
								flag = false;
								break;
							}
						}
						//插入操作
						if(flag) {
							SOC0105TB auditWaitTask = this.soc0105BL.getSOC0105Instance();
							auditWaitTask.setAuwttopci(ciName);//顶级CI名称
							auditWaitTask.setAuwtfilename(fileName);//文件名
							auditWaitTask.setAuwtcreatetime(createTime);//任务创建时间
							auditWaitTask.setAuwtstatus(CMDBConstants.TASK_STATUS_WAIT);//待处理
							auditWaitTask.setImpTypeid(iv.getImpcitype());//顶级CI类型
							auditWaitTask.setEiImportProgrammeTB(iv.getSoc0113TB());//不设第一次不好使，不显示对应名称。
							this.soc0105BL.registSOC0105(auditWaitTask);
							log.debug("增加文件" + fileName);
						}
						break;
					}
				}
			}
			
			//查询任务列表
			dto.setAuditWaitTaskList(this.soc0105BL.searchSOC0105(cond));
		
		} else {//已完成
			dto.setAuditWaitTaskList(auditWaitTaskList);
		}
		
		log.debug("========审计控制台显示处理终了========");
		return dto;
	}
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO deleteAuditWaitTaskAction(IGCIM03DTO dto) throws BLException {
		log.debug("========删除待处理任务处理开始========");
		
		IGCIM0301Form form = dto.getIgcim0301Form();
		
		String[] auwtids = form.getAuwtids();//主键
		
		//CI导入应用资源文件
		Properties properties = this.getProperties();
		
		//CI导入文件夹路径
		String ciFilePath  = properties.getProperty("AUDIT_CI_IMPORT_FILE_PATH");
		
		//删除任务和相应文件
		if(auwtids != null) {
			for(String auwtid : auwtids) {
				SOC0105Info eit = this.soc0105BL.searchSOC0105ByPK(Integer.parseInt(auwtid));
				File file = new File(ciFilePath + File.separator + eit.getAuwtfilename());
				if(file.exists()) {
					file.delete();
				}
				this.soc0105BL.deleteSOC0105(eit);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", resources
				.getMessage(dto.getLocale(), "message.IGCIM0301.005")));
		
		log.debug("========删除待处理任务处理终了========");
		return dto;
	}
	
	/**
	 * 控制台任务查看处理
	 * 
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0303Action(IGCIM03DTO dto) throws BLException {
		log.debug("========控制台任务查看处理开始========");
		
		IGCIM0303Form form = dto.getIgcim0303Form();
		
		dto.setAuditWaitTask(this.soc0105BL.searchSOC0105ByPK(form.getAuwtid()));
			
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
		if(fileName.indexOf("_") > 0 && fileName.indexOf(".") > 0&& fileName.indexOf("(") > 0 && fileName.lastIndexOf("_") < fileName.lastIndexOf(".")
				&& fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf("(")).length() == 12) {
		} else {
			throw new BLException("IGCIM0301.E003", fileName);
		}
	}

	/**
	 * 审计控制台导入处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO importIGCIM0301Action(IGCIM03DTO dto) throws BLException {
		log.debug("========审计控制台导入处理开始========");
		IGCIM0301Form form = dto.getIgcim0301Form();
		String[] auwtids = form.getAuwtids();
		List<String> topCIList = new ArrayList<String>();
		List<SOC0105Info> awtList = new ArrayList<SOC0105Info>();
		for(int i =0 ;i<auwtids.length;i++){
			String auwtid = auwtids[i];
			awtList.add(soc0105BL.searchSOC0105ByPK(Integer.valueOf(auwtid)));
			topCIList.add(awtList.get(i).getAuwttopci());
		}
		//相同顶级CI只允许导入一次,不可再导入
		SOC0102SearchCondImpl aeiCond = new SOC0102SearchCondImpl();
		aeiCond.setTopCIList(topCIList);
		List<SOC0102Info> aeiList = this.soc0102BL.searchSOC0102(aeiCond);
		if(aeiList.size() > 0) {
			StringBuffer names = new StringBuffer();
			for(SOC0102Info aei : aeiList) {
				names.append(aei.getEiname()).append(",");
			}
			throw new BLException("IGCIM0301.E008", names.toString().substring(0, names.length() - 1));
		}
		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("AUDIT_CI_IMPORT_BAT_NAME");
		String[] cmd = new String[6];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
        //从form中得到顶级ei名的数组、导入文件名数组、实体名数组
//		String batNames = null;
//		String filenames = null;
//		String einames = null;
//		String auwtidParms = null;
		SOC0105Info auditWaitTaskInfo = null;
		for(int i =0 ;i<auwtids.length;i++){
			String auwtid = auwtids[i];
			auditWaitTaskInfo = awtList.get(i);
			
			//通过顶级ei名，去导入数据版本管理表中取得版本最大的那条数据的导入类型
			//通过类型，从导入程序管理表中取得批处理文件名和相对目录
			SOC0120SearchCondImpl cond = new SOC0120SearchCondImpl();
			cond.setImpeiname(auditWaitTaskInfo.getAuwttopci());
			List<SOC0120Info>	importVersionList = soc0120BL.searchImportVersion(cond);
			String batName = null;
			if(importVersionList.size() == 1) {
				batName = importVersionList.get(0).getSoc0113TB().getImpProgrammeAudit();
			} else {
				throw new BLException("IGCO10000.E004", auditWaitTaskInfo.getAuwttopci());
			}
			String filename = auditWaitTaskInfo.getAuwtfilename();
			String einame = auditWaitTaskInfo.getAuwttopci();
			SOC0106TB tb=new SOC0106TB();
			tb.setFileName(filename);
			tb.setBatName(batName);
			tb.setAuwtId(auwtid);
			tb.setEiName(einame);
			soc0106BL.registSOC0106(tb);
//			if(i==0){
//				batNames = batName;
//				filenames = filename;
//				einames = einame;
//				auwtidParms = auwtid;
//			}else{
//				batNames = batNames + "!"+ batName;
//				filenames = filenames + "!" + filename;
//				einames = einames + "!" + einame;
//				auwtidParms = auwtidParms + "!" + auwtid;
//			}
			
		}
		try {
			User user = dto.getUser();	
			
			cmd[4] = filepath + importBatName;
			cmd[5] = user.getUserid()+ "!" + user.getUsername();
//			cmd[5] =filenames;
//			cmd[6] =batNames;
//			cmd[7] =einames;
//			cmd[8] =user.getUserid()+ "!" + user.getUsername();
//			cmd[9] =auwtidParms;
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("导入应用程序启动失败", e);
			throw new BLException("IGCIM0301.E005");
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
			throw new BLException("IGCIM0301.E001");
		} catch (IOException e) {
			log.error("CI导入应用资源文件读取错误", e);
			throw new BLException("IGCIM0301.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI导入应用资源文件读取错误", e);
					throw new BLException("IGCIM0301.E001");
				}
			}
		}
		return properties;
	}
	
	/**
	 * 审计对比结果查询处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditResultAction(IGCIM03DTO dto) throws BLException{
		
		log.debug("========审计对比结果查询处理开始========");
		
		List<SOC0103Info> auditResultList = soc0103BL.searchSOC0103(dto.getAuditResultSearchCond());
		
		dto.setAuditResultList(auditResultList);
		
		log.debug("========审计对比结果查询处理终了========");
		
		return dto;
	}
	
	/**
	 * 审计对比结果查询处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchIGCIM0302Action(IGCIM03DTO dto) throws BLException{
		
		log.debug("========审计对比结果查询处理开始========");
		
		List<SOC0137Info> auditResultOneInfoList = soc0103BL.searchAuditResultOne(dto.getAuditResultSearchCond());
		
		dto.setAuditResultOneInfoList(auditResultOneInfoList);
		
		log.debug("========审计对比结果查询处理终了========");
		
		return dto;
	}
	
	/**
	 * 审计对比结果保存处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public void updateAuditResultAction(IGCIM03DTO dto) throws BLException{
		
		log.debug("========审计对比结果保存处理开始========");
		
		IGCIM0302Form form = dto.getIgcim0302Form();
		
		// 选中集合
		String[] checkeds = form.getCheckbox(); 
		
		// 将当前数据置成不合理
		soc0103BL.updateSOC0103Without(dto.getAuditResultSearchCond());
		
		if(checkeds != null && checkeds.length > 0){
			
			//选中结果为不合理, 将原值覆盖回审计属性表
			for(int i=1;i<checkeds.length;i++){
				String autid=checkeds[i].split(",")[0];
				String eiid=checkeds[i].split(",")[1];
				SOC0103SearchCondImpl cond=new SOC0103SearchCondImpl();
				cond.setAutid(Integer.parseInt(autid));
				cond.setEiid(Integer.parseInt(eiid));
				List<SOC0103Info> auditResultInfoList=this.soc0103BL
				.searchSOC0103(cond);
				if(auditResultInfoList!=null&&auditResultInfoList.size()>0){
					for(SOC0103Info auditResultInfo:auditResultInfoList){
						SOC0103TB arTB = (SOC0103TB) SerializationUtils.clone(auditResultInfo);
						arTB.setAuflag(CMDBConstants.RESULT_AUFLAG_OUT);
						this.soc0103BL.updateSOC0103(arTB);
					}
				}
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I010", resources.getMessage(dto.getLocale(), "message.IGCIM0302.002")));
		log.debug("========审计对比结果保存处理终了========");
		
	}

	/**
	 * 审计任务登记处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO insertAuditTaskAction(IGCIM03DTO dto) throws BLException {
		log.debug("========审计任务信息登记处理开始========");
		// 输入Form取得
		IGCIM0305Form form = dto.getIgcim0305Form();
		//根据审计任务删除标识进行逻辑删除
		SOC0104SearchCondImpl auditTaskSearchCond=new SOC0104SearchCondImpl();
		auditTaskSearchCond.setAutstatus_eq("0");
		List<SOC0104Info> auditTaskInfoList=this.soc0104BL.searchSOC0104(auditTaskSearchCond);
		if(auditTaskInfoList!=null){
			for(SOC0104Info auditTaskInfo:auditTaskInfoList){
				SOC0104TB auditTask=(SOC0104TB)SerializationUtils.clone(auditTaskInfo);
				auditTask.setAutstatus("1");
				this.soc0104BL.updateSOC0104(auditTask);
			}
		}
		//对审计资产表中的数据进行物理删除
		this.soc0102BL.deleteSOC0102();
		//对审计资产属性表中的数据进行物理删除
		this.soc0101BL.deleteSOC0101();
		//对 审计资产等待导入表进行物理删除
		this.soc0105BL.deleteSOC0105All();
		
		//审计任务要登记的信息
		String auttime=IGStringUtils.getCurrentDateTime();
		form.setAuttime(auttime);
		form.setAutstatus("0");
		dto.setIgcim0305Form(form);
		this.soc0104BL.registSOC0104(dto.getIgcim0305Form());
		// 审计任务基本信息
		dto.addMessage(new ActionMessage("IGCO10000.I004", resources
				.getMessage(dto.getLocale(), "message.IGCIM03BLImpl.001")));
		log.debug("========导审计任务信息登记处理终了========");
		return dto;
	}

	/**
	 * 审计任务查询处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditTaskAction(IGCIM03DTO dto) throws BLException {
		log.debug("========审计任务信息查询处理开始========");

		// 审计任务信息查询件数取得
		int totalCount = this.soc0104BL.getSearchCount(dto.getAuditTaskSearchCond());
		
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
		List<SOC0104Info> auditTaskInfoList = this.soc0104BL
				.searchSOC0104(dto.getAuditTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setAuditTaskInfoList(auditTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========审计任务信息查询处理终了========");
		return dto;
	}

	/**
	 * 审计任务查询处理（弹出页）
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditTaskActionForChoose(IGCIM03DTO dto) throws BLException {
		log.debug("========审计任务信息查询处理开始========");

		// 审计任务信息查询件数取得
		int totalCount = this.soc0104BL.getSearchCount(dto.getAuditTaskSearchCond());
		
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
		List<SOC0104Info> auditTaskInfoList = this.soc0104BL
				.searchSOC0104(dto.getAuditTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setAuditTaskInfoList(auditTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========审计任务信息查询处理终了========");
		return dto;
	}

	/**
	 * 审计任务变更初期显示
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0305Action(IGCIM03DTO dto) throws BLException {
		log.debug("========变更审计任务基本信息查询处理开始========");
		IGCIM0305Form form = dto.getIgcim0305Form();
		SOC0104Info auditTaskInfo=this.soc0104BL.searchSOC0104ByPK(form.getAutid());
		form.setAutid(auditTaskInfo.getAutid());//审计任务ID
		form.setAutdesc(auditTaskInfo.getAutdesc());//审计任务描述
		form.setAuttime(auditTaskInfo.getAuttime());//审计任务创建时间
		form.setAutstatus(auditTaskInfo.getAutstatus());//审计任务删除标识
		// 变更初始化模式
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", resources
				.getMessage(dto.getLocale(), "message.IGCIM03BLImpl.001")));
		log.debug("========变更审计任务基本信息查询处理终了========");
		return dto;
	}

	/**
	 * 审计任务变更处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO updateAuditTaskAction(IGCIM03DTO dto) throws BLException {
		log.debug("========变更审计任务基本信息处理开始========");
		this.soc0104BL.updateSOC0104(dto.getIgcim0305Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005", resources
				.getMessage(dto.getLocale(), "message.IGCIM03BLImpl.001")));
		log.debug("========变更审计任务基本信息处理终了========");
		return dto;
	}

	/**
	 * CI查询处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchEntityItemAction(IGCIM03DTO dto) throws BLException {
		log.debug("========设备信息查询处理开始========");
		
		//设备信息查询件数取得 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
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
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备信息查询处理终了========");
		return dto;
	}

	/**
	 * 设备详细信息查询处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0309Action(IGCIM03DTO dto) throws BLException {
		log.debug("========设备配置信息编辑画面初期化处理开始========");
		
		IGCIM0309Form form = dto.getIgcim0309Form();
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
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
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//设备配置信息查询件数取得 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
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
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(SOC0129Info e : configItemVWInfoList){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if("5".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				if(list.size() > 0){
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
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
			dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}

		
		log.debug("========设备配置信息编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 设备影响范围查询处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0308Action(IGCIM03DTO dto) throws BLException {
		log.debug("========设备影响范画面初期化处理开始========");
		
		IGCIM0308Form form = dto.getIgcim0308Form();
		
		SOC0124Info ei = this.soc0118BL.searchEntityItemVWByKey(Integer.parseInt(form.getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), ei);
		
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
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO compareIGCIM0301Action(IGCIM03DTO dto) throws BLException {
		log.debug("========审计控制台对比处理开始========");
		
		//审计实体表中无数据要在控制台提示数据还未进行导入的信息
		int count = this.soc0102BL.getSearchCount(new SOC0102SearchCondImpl());
		if(count == 0) {
			throw new BLException("IGCIM0301.E009");
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
			cmd[5] = dto.getIgcim0301Form().getAutid().toString();
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("对比应用程序启动失败", e);
			throw new BLException("IGCIM0301.E005");
		}
		log.debug("========审计控制台对比处理终了========");
		return dto;
	
	}
	
	/**
	 * 资产更新处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO updateEntityAction(IGCIM03DTO dto) throws BLException{
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
			cmd[5] = dto.getIgcim0302Form().getAutid().toString();
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("更新应用程序启动失败", e);
			throw new BLException("IGCIM0302.E003");
		}
		
//		rootMarkUpdateAction(dto);
		
		log.debug("========资产更新处理终了========");
		return dto;
	
	
	}


//	
//	/**
//	 * 升级顶级CI(调用关系及升级bat)
//	 * 
//	 * @param dtoIGCIM03DTO
//	 * @return IGCIM03DTO
//	 * @throws BLException
//	 */
//	public IGCIM03DTO rootMarkUpdateAction(IGCIM03DTO dto) throws BLException{
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
//			throw new BLException("IGCIM0302.E001");
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
//			throw new BLException("IGCIM0302.E002");
//		}
//		
//		return dto;
//	}
}
