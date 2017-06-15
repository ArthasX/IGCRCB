/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.api;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.framework.igflow.parameter.PrivateProcessInfoValueInfo;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValueInfo;
import com.deliverik.framework.igflow.parameter.StatusParticipantInfo;
import com.deliverik.framework.igflow.parameter.WorkFlowLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * 流程更新功能API
 */
public class FlowSetBLImpl extends BaseBLImpl implements FlowSetBL {
    
	/** 流程定义BL */
    protected WorkFlowDefinitionBL workFlowDefinitionBL; 
    
    /** 流程处理BL */
    protected WorkFlowOperationBL workFlowOperationBL;

	/** 资产基本信息BL */
	protected SOC0118BL soc0118BL;
	
	/** 资产属性BL */
	protected SOC0107BL soc0107BL;
	
	/** 角色BL */
	protected RoleBL roleBL;

	/** 用户BL */
	protected UserBL userBL;

	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/** 资产模型BL */
	protected SOC0117BL soc0117BL;
	
	/** 资产配置属性定义BL */
	protected SOC0109BL soc0109BL;
	
	/** 附件上传BL */
	protected FileUploadBL fileUploadBL;
	
    /**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 流程处理BL设定
	 * @param workFlowOperationBL 流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 资产基本信息BL设定
	 *
	 * @param soc0118BL 资产基本信息BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}
	
	/**
	 * 资产属性BL设定
	 * 
	 * @param soc0107BL 资产属性BL
	 */
	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}
	
	/**
	 * 角色BL设定
	 * 
	 * @param roleBL 角色BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 用户BL设定
	 * 
	 * @param userBL 用户BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * 用户角色BL设定
	 * 
	 * @param userRoleBL 用户角色BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * 资产模型BL设定
	 * @param soc0117BL 资产模型BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	/**
	 * 资产配置属性定义BL设定
	 * @param soc0109BL 资产配置属性定义BL
	 */
	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}

	/**
	 * 附件上传BL设定
	 * @param fileUploadBL 附件上传BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	/**
	 * 添加资产属性
	 * @param eiid 资产ID
	 * @param lst_EntityItemConfigValueInfo 资产属性信息
	 * @throws BLException
	 */
	public void createConfigItem(Integer eiid, List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo) throws BLException {
		if(eiid == null || eiid == 0) throw new BLException("IGFLOW0000.E001","资产ID");
		if(lst_EntityItemConfigValueInfo == null || lst_EntityItemConfigValueInfo.size() == 0)
			throw new BLException("IGFLOW0000.E001","资产属性信息");
		//封装资产基本信息
		SOC0118Info entity = soc0118BL.searchEntityItemByKey(eiid);
		if(entity.getEiversion() != null || entity.getEiversion() > 0) {
			throw new BLException("IGFLOW0000.E005", entity.getEiname() + "已包含属性信息");
		}
		//增加资产配置信息
		//查询资产的配置信息
		List<SOC0117Info> parentNodes = soc0117BL.getParentNodes(entity.getEsyscoding());
		List<SOC0109Info> configurations = new ArrayList<SOC0109Info>();
		SOC0109SearchCondImpl configcond = new SOC0109SearchCondImpl();
		configcond.setCseq(1);
		for(SOC0117Info e:parentNodes){
			configcond.setEid(e.getEid().toString());
			configurations.addAll(soc0109BL.searchConfiguration(configcond, 0, 0));
		}
		Map<String, EntityItemConfigValueInfo> configItemValueMap = new HashMap<String, EntityItemConfigValueInfo>();
		for(EntityItemConfigValueInfo configItem: lst_EntityItemConfigValueInfo){
			configItemValueMap.put(configItem.getName(), configItem);
		}
		for(SOC0109Info configuration:configurations){
			SOC0107TB configItem = new SOC0107TB();
			//设备ID
			configItem.setEiid(entity.getEiid());
			//模型属性ID
			configItem.setCid(configuration.getCid());
			//模型ID
			configItem.setEid(entity.getEid());
			//模型层次码
			configItem.setEsyscoding(entity.getEsyscoding());
			//大版本号
			configItem.setCiversion(1);
			//小版本号
			configItem.setCismallversion(0);
			//更新时间
			configItem.setCiupdtime(entity.getEiupdtime());
			//处理配置项值
			EntityItemConfigValueInfo valueInfo = configItemValueMap.get(configuration.getCname());
			if(valueInfo != null){
				configItem.setCivalue(valueInfo.getValue());
				//附件类属性处理
				if("1".equals(configuration.getCattach())){
					String fileName = uploadAssetFormFile(valueInfo.getFile(), entity.getEiid(), 1);
					configItem.setCivalue(fileName);
				}
			}
			soc0107BL.registSOC0107(configItem);
		}
		SOC0118TB instance = (SOC0118TB) SerializationUtils.clone(entity);
		instance.setEiversion(1);
		soc0118BL.updateEntityItem(instance);
	}
	
	/**
	 * 添加资产
	 * 所属机构码不存在时抛异常
	 * 所属模型信息不存在时抛异常
	 * @param entityItem 资产信息
	 * @return 资产ID
	 * @throws BLException
	 */
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException {
		if(entityItem == null) throw new BLException("IGFLOW0000.E001","资产相关信息");
		if(StringUtils.isEmpty(entityItem.getEsyscoding())) throw new BLException("IGFLOW0000.E001","资产所属模型信息");
		if(StringUtils.isEmpty(entityItem.getEiorgsyscoding())) throw new BLException("IGFLOW0000.E001","资产所属机构信息");
		//查询资产所属模型信息
		SOC0117SearchCondImpl entitycond = new SOC0117SearchCondImpl();
		entitycond.setEsyscoding(entityItem.getEsyscoding());
		List<SOC0117Info> entitylist = soc0117BL.searchEntity(entitycond);
		if(entitylist == null || entitylist.isEmpty()){
			throw new BLException("IGFLOW0000.E001","资产所属模型信息");
		}else if(entitylist.size() > 1){
			throw new BLException("IGFLOW0000.E002","资产所属模型信息");
		}
		//封装资产基本信息
		SOC0118TB instance = soc0118BL.getEntityItemTBInstance();
		instance.setEid(entitylist.get(0).getEid().toString());
		instance.setEidesc(entityItem.getEidesc());
		instance.setEiinsdate(IGStringUtils.getCurrentDate());
		instance.setEilabel(entityItem.getEilabel());
		instance.setEiname(entityItem.getEiname());
		instance.setEiorgsyscoding(entityItem.getEiorgsyscoding());
		instance.setEismallversion(0);
		instance.setEistatus(entityItem.getEistatus());
		instance.setEiuserid(entityItem.getEiuserid());
		instance.setEiusername(entityItem.getEiusername());
		instance.setEiversion(0);
		instance.setEsyscoding(entityItem.getEsyscoding());
		instance.setEiupdtime(IGStringUtils.getCurrentDateTime());
		instance.setFingerPrint(entityItem.getFingerPrint());
		SOC0118Info entity = soc0118BL.registEntityItem(instance);
		//增加资产配置信息
		if(entityItem.getConfigItems() != null && entityItem.getConfigItems().size() > 0){
			//查询资产的配置信息
			List<SOC0117Info> parentNodes = soc0117BL.getParentNodes(entity.getEid());
			List<SOC0109Info> configurations = new ArrayList<SOC0109Info>();
			SOC0109SearchCondImpl configcond = new SOC0109SearchCondImpl();
			configcond.setCseq(1);
			for(SOC0117Info e:parentNodes){
				configcond.setEid(e.getEid().toString());
				configurations.addAll(soc0109BL.searchConfiguration(configcond, 0, 0));
			}
			Map<String, EntityItemConfigValueInfo> configItemValueMap = new HashMap<String, EntityItemConfigValueInfo>();
			for(EntityItemConfigValueInfo configItem:entityItem.getConfigItems()){
				configItemValueMap.put(configItem.getName(), configItem);
			}
			for(SOC0109Info configuration:configurations){
				SOC0107TB configItem = new SOC0107TB();
				//设备ID
				configItem.setEiid(entity.getEiid());
				//模型属性ID
				configItem.setCid(configuration.getCid());
				//模型ID
				configItem.setEid(entity.getEid());
				//模型层次码
				configItem.setEsyscoding(entity.getEsyscoding());
				//大版本号
				configItem.setCiversion(1);
				//小版本号
				configItem.setCismallversion(0);
				//更新时间
				configItem.setCiupdtime(entity.getEiupdtime());
				//处理配置项值
				EntityItemConfigValueInfo valueInfo = configItemValueMap.get(configuration.getCname());
				if(valueInfo != null){
					configItem.setCivalue(valueInfo.getValue());
					//附件类属性处理
					if("1".equals(configuration.getCattach())){
						String fileName = uploadAssetFormFile(valueInfo.getFile(), entity.getEiid(), 1);
						if(fileName == null && !"".equals(valueInfo.getValue()) ){
							fileName = valueInfo.getValue();
						}
						configItem.setCivalue(fileName);
					}
				}
				soc0107BL.registSOC0107(configItem);
			}
			instance = (SOC0118TB) SerializationUtils.clone(entity);
			instance.setEiversion(1);
			soc0118BL.updateEntityItem(instance);
		}
		return entity.getEiid();
	}

	/**
	 * 状态参与者删除
	 * 
	 * @param statusParticipantInfo 状态参与者信息
	 * @throws BLException
	 */
	public void deleteStatusParticipant(StatusParticipantInfo statusParticipantInfo) throws BLException {
		//处理用户
		User user = userBL.searchUserByKey(statusParticipantInfo.getLogInfo().getExecutorid());
		//授权用户
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(statusParticipantInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(statusParticipantInfo.getLogInfo().getAuthuserid());
		}
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(statusParticipantInfo.getLogInfo().getPrid());
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(statusParticipantInfo.getLogInfo().getPrid());
		if(StringUtils.isNotEmpty(statusParticipantInfo.getStatuscode())){
			//流程改造，code码将不会有实际意义，由状态ID代替  wangtingzhi 20140513
			//流程改造，code码将不会有实际意义，由状态ID代替  wangtingzhi 20140513
//			cond.setPpstatus(statusParticipantInfo.getStatuscode());
			cond.setPsdid(statusParticipantInfo.getStatuscode());
		}else{
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(process.getPrpdid());
			psdCond.setPsdname(statusParticipantInfo.getStatusname());
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "状态（" + statusParticipantInfo.getStatusname() + "）");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "状态（" + statusParticipantInfo.getStatusname() + "）");
			}
			//流程改造，code码将不会有实际意义，由状态ID代替  wangtingzhi 20140513
//			cond.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
			cond.setPsdid(lst_ProcessStatusDef.get(0).getPsdid());
		}
		cond.setPproleid(statusParticipantInfo.getRoleid());
		cond.setPpuserid(statusParticipantInfo.getUserid());
		//查询参与者
		List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
		for(IG337Info pp : lst_ProcessParticipant) {
			workFlowOperationBL.removeProcessParticipant(pp, user, statusParticipantInfo.getLogInfo().getExecutorRoleid(), "", "删除参与者",
					null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, null, null);
		}
	}
	
	/**
	 * 以表格为单位删除公有表格式表单值
	 * 行号为空时删除该表格下所有值
	 * 流程信息不存在或表单信息不存在时抛异常
	 * @param tableColumnDefMap 表格式表单列定义
	 * @param tableColumnFullName 表格式表单列全路径名称
	 * @param prid 流程主键
	 * @param rownumber 行号(可为空)
	 * @throws BLException
	 */
	public void deletePublicTableFormValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,String tableColumnFullName,Integer prid,String rownumber) throws BLException{
		//表单定义信息取得
		ProcessInfoDefinitionInfo tableDef = tableColumnDefMap.get(tableColumnFullName);
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPidid(tableDef.getPidid());
		cond.setRownumber(rownumber);
		List<IG898Info> list = workFlowOperationBL.searchTableFormValue(cond);
		if(list != null && list.size() > 0){
			workFlowOperationBL.deleteTableFormValue(list);
		}
	}
	
	/**
	 * 资产所属机构更新
	 * 
	 * @param eiid 资产ID
	 * @param eiorgsyscoding 更新后的资产所属机构层次码
	 * @throws BLException
	 */
	public void setEntityItemValue(Integer eiid, String eiorgsyscoding) throws BLException {

		if(eiid == null || eiid <= 0) {
			throw new BLException("IGCO10000.E004","资产ID");
		}
		if(StringUtils.isEmpty(eiorgsyscoding)) {
			throw new BLException("IGCO10000.E004","更新后的资产所属机构层次码");
		}
		// 根据主键查询资产信息
		SOC0118Info soc0118Info = this.soc0118BL.searchEntityItemByKey(eiid);
		if(soc0118Info == null){
			throw new BLException("IGFLOW0000.E001", "Eiid为（" + eiid + "）的资产");
		}
		// 更新资产所属机构
		SOC0118TB soc0118TB = (SOC0118TB)SerializationUtils.clone(soc0118Info);
		soc0118TB.setEiorgsyscoding(eiorgsyscoding);
		this.soc0118BL.updateEntityItem(soc0118TB);
	}
	
	/**
	 * 资产属性值更新
	 * 
	 * @param entityItemConfigValueInfo 资产属性信息
	 * @param upgrade 是否升版
	 * @throws BLException
	 */
	public void setEntityItemConfigValue(EntityItemConfigValueInfo entityItemConfigValueInfo,
			boolean upgrade) throws BLException {
		List<SOC0107Info> lst_ConfigItem = soc0107BL.searchSOC0107HistoryByEiid(
				entityItemConfigValueInfo.getEiid(), -1, null, entityItemConfigValueInfo.getName());
		if(lst_ConfigItem.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "属性（" + entityItemConfigValueInfo.getName() + "）");
		} else if(lst_ConfigItem.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "属性（" + entityItemConfigValueInfo.getName() + "）");
		} else {
			SOC0107TB instance = (SOC0107TB)SerializationUtils.clone(lst_ConfigItem.get(0));
			instance.setCivalue(entityItemConfigValueInfo.getValue());
			if(entityItemConfigValueInfo.getFile() != null){
				int version = instance.getEiid();
				if(upgrade){
					version ++;
				}
				String fileName = uploadAssetFormFile(entityItemConfigValueInfo.getFile(), instance.getEiid(), version);
				if(StringUtils.isNotEmpty(fileName)){
					instance.setCivalue(fileName);
				}
			}
			if(upgrade) {
				soc0107BL.saveSOC0107(lst_ConfigItem.get(0).getCiversion(), instance);
			} else {
				//值变化标识
				if(StringUtils.isEmpty(lst_ConfigItem.get(0).getCivalue())) {
					if(StringUtils.isNotEmpty(entityItemConfigValueInfo.getValue())) {
						instance.setCicurver("1");
					}
				} else {
					if(!lst_ConfigItem.get(0).getCivalue().equals(entityItemConfigValueInfo.getValue())) {
						instance.setCicurver("1");
					}
				}
				soc0107BL.updateSOC0107(instance);
			}
		}
	}
	
	/**
	 * 资产属性值更新
	 * 
	 * @param lst_EntityItemConfigValueInfo 资产属性信息集合
	 * @param upgrade 是否升版
	 * @throws BLException
	 */
	public void setEntityItemConfigValue(List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo,
			boolean upgrade) throws BLException {
		List<SOC0107Info> lst_ConfigItem = null;
		List<SOC0107Info> lst_Instance = new ArrayList<SOC0107Info>();
		Integer eiid = null;
		int currentEiversion = -2;
		for(EntityItemConfigValueInfo entityItemConfigValueInfo : lst_EntityItemConfigValueInfo) {
			lst_ConfigItem = soc0107BL.searchSOC0107HistoryByEiid(
					entityItemConfigValueInfo.getEiid(), -1, null, entityItemConfigValueInfo.getName());
			if(lst_ConfigItem.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "属性（" + entityItemConfigValueInfo.getName() + "）");
			} else if(lst_ConfigItem.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "属性（" + entityItemConfigValueInfo.getName() + "）");
			} else {
				SOC0107TB instance = (SOC0107TB)SerializationUtils.clone(lst_ConfigItem.get(0));
				instance.setCivalue(entityItemConfigValueInfo.getValue());
				if(entityItemConfigValueInfo.getFile() != null){
					int version = instance.getEiid();
					if(upgrade){
						version ++;
					}
					String fileName = uploadAssetFormFile(entityItemConfigValueInfo.getFile(), instance.getEiid(), version);
					if(StringUtils.isNotEmpty(fileName)){
						instance.setCivalue(fileName);
					}
				}
				//值变化标识
				if(StringUtils.isEmpty(lst_ConfigItem.get(0).getCivalue())) {
					if(StringUtils.isNotEmpty(entityItemConfigValueInfo.getValue())) {
						instance.setCicurver("1");
					}
				} else {
					if(!lst_ConfigItem.get(0).getCivalue().equals(entityItemConfigValueInfo.getValue())) {
						instance.setCicurver("1");
					}
				}
				lst_Instance.add(instance);
				eiid = lst_ConfigItem.get(0).getEiid();
				currentEiversion = lst_ConfigItem.get(0).getCiversion();
			}
		}
		if(upgrade) {
			soc0107BL.saveSOC0107(eiid, currentEiversion, lst_Instance);
		} else {
			for(SOC0107Info instance : lst_Instance) {
				soc0107BL.updateSOC0107(instance);
			}
		}
	}
	
	/**
	 * 设置流程相关资产
	 * <BR>
	 * 流程信息不存在、表单信息不存在或者资产信息为空时抛异常
	 * @param prid 流程主键
	 * @param pidname 表单名称
	 * @param entitys 资产信息集合
	 * @throws BLException
	 */
	public void setProcessEntityItem(Integer prid, String pidname, List<ProcessInfoEntityInfo> entitys) throws BLException{
	    if(prid == 0 || prid <= 0) {
			throw new BLException("IGCO10000.E004","流程定义ID");
		}
		if(entitys == null || entitys.isEmpty()){
			throw new BLException("IGCO10000.E004","相关资产");
		}
		Integer piid = null;
		//查询流程表单主键
		if(StringUtils.isNotEmpty(pidname)){
			IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
			cond599.setPrid(prid);
			cond599.setPivarname(pidname);
			List<IG599Info> piList = workFlowOperationBL.searchProcessInfoByCond(cond599);
			if(piList != null && piList.size() > 0){
				piid = piList.get(0).getPiid();
			}
		}
		if(piid == null){
			throw new BLException("IGCO10000.E004","表单");
		}
		for(ProcessInfoEntityInfo entity:entitys){
			IG731TB processInfoEntity = new IG731TB();
			processInfoEntity.setPrid(prid);
			processInfoEntity.setPiid(piid);
			processInfoEntity.setEiid(entity.getEiid());
			processInfoEntity.setFingerPrint(entity.getFingerPrint());
			processInfoEntity.setEiversion(entity.getEiversion());
			workFlowOperationBL.saveProcessInfoEntity(processInfoEntity);
		}
	}
	
	/**
	 * 私有表单值更新
	 * 
	 * @param privateProcessInfoValueInfo 私有表单信息
	 * @throws BLException
	 */
	public void setPrivateProcessInfoValue(PrivateProcessInfoValueInfo privateProcessInfoValueInfo) throws BLException {
		//检索流程表单记录
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(privateProcessInfoValueInfo.getLogInfo().getPrid());//流程ID
		cond.setPivarlabel(privateProcessInfoValueInfo.getFormname());//表单名称
		List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
		if(lst_ProcessInfo.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "表单（" + privateProcessInfoValueInfo.getFormname() + "）");
		} else if(lst_ProcessInfo.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "表单（" + privateProcessInfoValueInfo.getFormname() + "）");
		} else {
			//根据流程表单记录ID检索私有表单记录
			IG899SearchCondImpl privateCond = new IG899SearchCondImpl();
			privateCond.setPiid(lst_ProcessInfo.get(0).getPiid());//流程表单记录ID
			privateCond.setRoleid(privateProcessInfoValueInfo.getLogInfo().getExecutorRoleid());//角色ID
			privateCond.setUserid(privateProcessInfoValueInfo.getLogInfo().getExecutorid());//用户ID
			List<IG899Info> lst_ProcessPrivateInfo = workFlowOperationBL.searchProcessPrivateInfo(privateCond);
			if(lst_ProcessPrivateInfo.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "表单（" + privateProcessInfoValueInfo.getFormname() + "）");
			} else if(lst_ProcessPrivateInfo.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "表单（" + privateProcessInfoValueInfo.getFormname() + "）");
			} else {
				//更新私有表单
				IG899TB private_nstance = (IG899TB)SerializationUtils.clone(lst_ProcessPrivateInfo.get(0));
				private_nstance.setPpivalue(privateProcessInfoValueInfo.getFormvalue());
				workFlowOperationBL.updateProcessPrivateInfo(private_nstance);
				//构造表单日志所需参数
				IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
				instance.setPivarvalue(privateProcessInfoValueInfo.getFormvalue());
				lst_ProcessInfo.clear();
				lst_ProcessInfo.add(instance);
				//记录更新日志
				IG036Info recordLog = workFlowOperationBL.addRecordLog(privateProcessInfoValueInfo.getLogInfo().getPrid(),
						userBL.searchUserByKey(privateProcessInfoValueInfo.getLogInfo().getExecutorid()),
						privateProcessInfoValueInfo.getLogInfo().getExecutorRoleid(), privateProcessInfoValueInfo.getLogInfo().getComment(),
						"更新表单", null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, null, null);
				//记录表单更新日志
				workFlowOperationBL.addRecordLogVarInfo(lst_ProcessInfo, recordLog);
			}
		}
	}
	
	/**
	 * 流程日志添加
	 * 
	 * @param logInfo 流程日志参数信息
	 * @param desc 日志功能描述
	 * @param type 日志类型
	 * @throws BLException
	 */
	public void setProcessLog(WorkFlowLogInfo logInfo, String desc, String type) throws BLException {
		workFlowOperationBL.addRecordLog(logInfo.getPrid(),
				userBL.searchUserByKey(logInfo.getExecutorid()),
				logInfo.getExecutorRoleid(), logInfo.getComment(),
				desc, null, type, null, null);
	}

	/**
	 * 流程关系添加
	 * 
	 * @param parprid 主流程ID
	 * @param cldprid 相关流程ID
	 * @throws BLException
	 */
	public void setProcessRelation(Integer parprid, Integer cldprid) throws BLException {
		IG512TB prrTB = workFlowOperationBL.getProcessRecordRelationTBInstance();
		prrTB.setParprid(parprid);//主流程ID
		prrTB.setCldprid(cldprid);//相关流程ID
		prrTB.setPrrinstime(IGStringUtils.getCurrentDateTime());//建立时间
		workFlowOperationBL.createProcessRecordRelation(prrTB);
	}

	/**
	 * 流程工单号更新
	 * 
	 * @param prid 流程ID
	 * @param serialnum 流程工单号
	 * @throws BLException
	 */
	public void setProcessSerialNum(Integer prid, String serialnum) throws BLException {
		IG500Info ig500Info =  workFlowOperationBL.searchProcessRecordByKey(prid);
		IG500TB ig500TB = (IG500TB)SerializationUtils.clone(ig500Info);
		ig500TB.setPrserialnum(serialnum);
		workFlowOperationBL.updateProcessRecord(ig500TB);
	}
	
	/**
	 * 公有表单值更新
	 * 
	 * @param publicProcessInfoValueInfo 公有表单信息
	 * @throws BLException
	 */
	public void setPublicProcessInfoValue(PublicProcessInfoValueInfo publicProcessInfoValueInfo) throws BLException {
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(publicProcessInfoValueInfo.getLogInfo().getPrid());//流程ID
		cond.setPivarlabel(publicProcessInfoValueInfo.getFormname());//表单名称
		List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
		if(lst_ProcessInfo.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "表单（" + publicProcessInfoValueInfo.getFormname() + "）");
		} else if(lst_ProcessInfo.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "表单（" + publicProcessInfoValueInfo.getFormname() + "）");
		} else {
			IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
			instance.setPivarvalue(publicProcessInfoValueInfo.getFormvalue());
			workFlowOperationBL.updateProcessInfo(instance);
			lst_ProcessInfo.clear();
			lst_ProcessInfo.add(instance);
			//记录更新日志
			IG036Info recordLog = workFlowOperationBL.addRecordLog(publicProcessInfoValueInfo.getLogInfo().getPrid(),
					userBL.searchUserByKey(publicProcessInfoValueInfo.getLogInfo().getExecutorid()),
					publicProcessInfoValueInfo.getLogInfo().getExecutorRoleid(), publicProcessInfoValueInfo.getLogInfo().getComment(),
					"更新表单", null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, null, null);
			//记录表单更新日志
			workFlowOperationBL.addRecordLogVarInfo(lst_ProcessInfo, recordLog);
		}
	}
	
	/**
	 * 表格式表单公有值设定(表单层级名称中间以 "#" 隔开)
	 * 如果该表单全路径在列定义map中不存在时抛异常
	 * @param tableColumnDefMap 表格式表单列定义
	 * @param tableColumnFullName 表格式表单列全路径名称
	 * @param prid 流程主键
	 * @param rownumber 行号
	 * @throws BLException
	 */
	public void setPublicTableColumnValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,String tableColumnFullName,Integer prid,String rownumber,String value) throws BLException {
		try{
			//表单定义信息取得
			ProcessInfoDefinitionInfo tableColumnDef = tableColumnDefMap.get(tableColumnFullName);
			//父级定义信息取得
			IG007Info pid = workFlowDefinitionBL.searchProcessInfoDefByKey(tableColumnDef.getPpidid());
			IG898TB entry = new IG898TB();
			entry.setPidid(pid.getPidid());
			entry.setPidname(pid.getPidname());
			entry.setPrid(prid);
			entry.setPvalue(value);
			entry.setPvcolname(tableColumnDef.getPidname());
			entry.setPvcolpidid(tableColumnDef.getPidid());
			entry.setPvrownumber(rownumber);
			workFlowOperationBL.registTableFormValue(entry);
		}catch (Exception e) {
			throw new BLException("IGFLOW0000.E001","表单定义信息");
		}
	}

	/**
	 * 参与角色和参与人添加
	 * 
	 * @param statusParticipantInfo 状态参与者信息
	 * @throws BLException
	 */
	public void setStatusParticipant(StatusParticipantInfo statusParticipantInfo) throws BLException {
		//处理用户
		User user = userBL.searchUserByKey(statusParticipantInfo.getLogInfo().getExecutorid());
		//授权用户
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(statusParticipantInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(statusParticipantInfo.getLogInfo().getAuthuserid());
		}
		//参与者角色
		Role role = roleBL.searchRoleByKey(statusParticipantInfo.getRoleid());
		//参与者用户
		User participant = null;
		if(StringUtils.isNotEmpty(statusParticipantInfo.getUserid())) {
			participant = userBL.searchUserByKey(statusParticipantInfo.getUserid());
		}
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(statusParticipantInfo.getLogInfo().getPrid());
		//参与者实例
		IG337TB instance = workFlowOperationBL.getProcessParticipantTBInstance();
		instance.setPrid(statusParticipantInfo.getLogInfo().getPrid());
		if(StringUtils.isNotEmpty(statusParticipantInfo.getStatuscode())){
			if(statusParticipantInfo.getStatuscode().length() > 3) {
				if (statusParticipantInfo.getStatuscode().indexOf("_") > -1) {
					instance.setPsdid(statusParticipantInfo.getStatuscode().split("_")[0]);
					instance.setPsdnum(new Integer(statusParticipantInfo.getStatuscode().split("_")[1]));
					IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(instance.getPsdid());
					instance.setPpstatus(psd.getPsdcode());
				} else {
					instance.setPsdid(statusParticipantInfo.getStatuscode());
					IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(instance.getPsdid());
					instance.setPpstatus(psd.getPsdcode());
				}
			} else {
				instance.setPpstatus(statusParticipantInfo.getStatuscode());
				instance.setPsdid(workFlowDefinitionBL.searchProcessStatusKey(process.getPrpdid(), instance.getPpstatus()));
			}
		}else{
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(process.getPrpdid());
			psdCond.setPsdname(statusParticipantInfo.getStatusname());
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "状态（" + statusParticipantInfo.getStatusname() + "）");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "状态（" + statusParticipantInfo.getStatusname() + "）");
			}
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "状态（" + statusParticipantInfo.getStatusname() + "）");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "状态（" + statusParticipantInfo.getStatusname() + "）");
			}
			instance.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
			instance.setPsdid(lst_ProcessStatusDef.get(0).getPsdid());
		}
		instance.setPpinittime(IGStringUtils.getCurrentDateTime());
		if(StringUtils.isEmpty(statusParticipantInfo.getUserid())) {
			instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE);
		} else {
			instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
			instance.setPpuserid(participant.getUserid());
			instance.setPpusername(participant.getUsername());
			instance.setPporgid(participant.getOrgid());
			instance.setPporgname(participant.getOrgname());
			//角色负责人
			if(userRoleBL.checkRoleManagerByID(participant.getUserid(), role.getRoleid())){
				instance.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
			}
			//角色值班人
			if(userRoleBL.checkRoleDutyflagByID(participant.getUserid(), role.getRoleid())){
				instance.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
			}
			//不考虑主办部门
		}
		instance.setPproleid(role.getRoleid());
		instance.setPprolename(role.getRolename());
		List<IG337Info> todoList = workFlowOperationBL.searchProcessParticipantTodoRole(statusParticipantInfo.getLogInfo().getPrid(),instance.getPpstatus());
		boolean isRepeat = false;
		for(IG337Info todo: todoList){
			if(instance.getPpuserid().equals(todo.getPpuserid()))
				isRepeat = true;
		}
		if(!isRepeat)
			workFlowOperationBL.addProcessParticipant(instance, user, statusParticipantInfo.getLogInfo().getExecutorRoleid(),
					statusParticipantInfo.getLogInfo().getComment(), "添加参与者", 
					null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, null, statusParticipantInfo.getStatuscode());
	}
	
	/**
	 * 清空全部参与者处理完成时间
	 * 
	 * @param prid 流程ID
	 * @param statuscode 状态标识
	 * @throws BLException
	 */
	public void setStatusParticipantAllRehandle(Integer prid, String statuscode) throws BLException {
		///自定义流程改造，状态code码将不会有实际意义，根据状态查询参与人将由状态定义ID代替
		///status 原为状态code吗，如今该为状态定义ID
		///wangtingzhi 20140513
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPsdid(statuscode);
		List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipants(cond);
//		List<IG337Info> ppList = this.workFlowOperationBL.searchProcessParticipant(prid, statuscode);
		for(IG337Info pp:ppList){
			IG337TB processParticipant = (IG337TB)SerializationUtils.clone(pp);
			processParticipant.setPpproctime(null);
			processParticipant.setPbdid(null);
			this.workFlowOperationBL.updateProcessParticipant(processParticipant);
		}
	}

	/**
	 * 清空指定参与者处理完成时间
	 * 
	 * @param prid 流程ID
	 * @param statusname 状态名称
	 * @param roleid 角色ID
	 * @param userid 用户ID
	 * @throws BLException
	 */
	public void setStatusParticipantRehandle(Integer prid, String statusname, Integer roleid, String userid) throws BLException {
		///自定义流程改造，状态code码将不会有实际意义，根据状态查询参与人将由状态定义ID代替
		///status 原为状态code吗，如今该为状态定义ID
		///wangtingzhi 20140513
		IG500Info ig500 =  this.workFlowOperationBL.searchProcessRecordByKey(prid);
		IG333SearchCondImpl cond_IG333 = new IG333SearchCondImpl();
		cond_IG333.setPdid(ig500.getPrpdid());
		cond_IG333.setPsdname(statusname);
		List<IG333Info> lst_IG333Info = workFlowDefinitionBL.searchProcessStatusDef(cond_IG333);
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPsdid(lst_IG333Info.get(0).getPsdid());
		List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipants(cond);
		for(IG337Info pp:ppList){
			if(StringUtils.isNotEmpty(pp.getPpuserid())){
				if(pp.getPpuserid().equals(userid)){
					IG337TB processParticipant = (IG337TB)SerializationUtils.clone(pp);
					processParticipant.setPpproctime(null);
					processParticipant.setPbdid(null);
					this.workFlowOperationBL.updateProcessParticipant(processParticipant);
				}
			}else{
				if(pp.getPproleid().equals(roleid)) {
					IG337TB processParticipant = (IG337TB)SerializationUtils.clone(pp);
					processParticipant.setPpproctime(null);
					processParticipant.setPbdid(null);
					this.workFlowOperationBL.updateProcessParticipant(processParticipant);
				}
			}
		}
	}
	
	/**
	 * 更新流程信息
	 * @param prid 流程主键
	 * @param valueMap 值：属性名-属性值
	 * @throws BLException
	 */
	public void updateProcessRecord(Integer prid,Map<String, Object> valueMap) throws BLException{
		IG500Info processrecord = workFlowOperationBL.searchProcessRecordByKey(prid);
		try {
			setPropert(processrecord, valueMap);
		} catch (Exception e) {
			throw new BLException("IGFLOW0000.E005","属性值设置异常！");
		}
		workFlowOperationBL.updateProcessRecord(processrecord);
	}
	
	/**
	 * 资产属性附件上传
	 * 附件上传失败是抛异常
	 * @param file 附件对象
	 * @param eiid 资产主键
	 * @param eversion 资产版本
	 * @return 附件名
	 * @throws BLException
	 */
	private String uploadAssetFormFile(FormFile file,Integer eiid,Integer eversion) throws BLException{
		String returnValue = null;
		if(file != null){
			//上传文件跟路径
			String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
			//拼接上传文件路径
			StringBuffer pathBuf = new StringBuffer();
			//根目录
			pathBuf.append(rootPath);
			//机能ID
			pathBuf.append("asm"+File.separator);
			//设备ID
			pathBuf.append(eiid);
			pathBuf.append(File.separator);
			StringBuffer fileName = new StringBuffer();
			//扩展名取得
			String fileType = "";
			String sFileName = file.getFileName();
			int point = sFileName.lastIndexOf(".");
			if (point != -1) {
				fileType = sFileName.substring(point);
				fileName.append(sFileName.substring(0, point));
			}
			//文件名后加版本号
			fileName.append("_");
			fileName.append(eversion);
			//文件扩展名
			fileName.append(fileType);
			//文件上传处理
			try {
				fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E005");
			} 
			returnValue = fileName.toString();
		}
		return returnValue;
	}
	
	/**
	 * 设置对象值
	 * @param obj 要设置值的对象
	 * @param value 值 属性名-属性值
	 */
	@SuppressWarnings("rawtypes")
	private void setPropert(Object obj,Map<String, Object> valueMap) throws Exception{
		Class type = obj.getClass();
		Set<Entry<String, Object>> set = valueMap.entrySet();
		for(Iterator<Entry<String, Object>> iter = set.iterator();iter.hasNext();){
			Entry<String, Object> next = iter.next();
			String key = next.getKey();
			Object value = next.getValue();
			Field field = type.getDeclaredField(key);
			field.setAccessible(true);
			field.set(obj, value);
		}
	}
	
	/**
	 * 添加流程资产关系
	 * @param prid 流程主键
	 * @param pidname 表单名称
	 * @param eiid 资产ID
	 */
	public Integer setProcessEntityRelation(Integer prid,String pidname,Integer eiid,Integer eiversion,Object... dbFlag) throws BLException{
		if(prid == null || prid == 0){
			throw new BLException("IGFLOW0000.E001","流程基本信息");
		}
		Integer piid = null;
		if(StringUtils.isNotEmpty(pidname)){
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			cond.setPrid(prid);//流程ID
			cond.setPivarlabel(pidname);//表单名称
			List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
			if(lst_ProcessInfo.size() == 1){
				piid = lst_ProcessInfo.get(0).getPiid();
				IG599TB ig599Tb = (IG599TB) lst_ProcessInfo.get(0);
				ig599Tb.setPivarvalue("N/A");
				workFlowOperationBL.saveProcessInfo(ig599Tb);
			}
		}
		IG731TB entity = new IG731TB();
		entity.setPrid(prid);
		entity.setPiid(piid);
		entity.setEiversion(eiversion == null || eiversion == 0 ? 1 : eiversion);
		entity.setEiid(eiid);
		// 应急修改 增加数据库标识(资产表单中 fingerprint表示本地库还是dblink远程库) 张剑 2016年10月9日
		if(dbFlag!=null&&dbFlag.length>0){
			entity.setFingerPrint(dbFlag[0].toString());
		}
		IG731Info info = workFlowOperationBL.saveProcessInfoEntity(entity);
		return info.getPieid();
	}

	public void setProcessSceneParticipant(Integer sourcePrid,String sourcePivarname,Integer tagPrid,String tagPivarname,String tagPdid) throws BLException {
		String sourcePidid = "";
		if(StringUtils.isNotBlank(sourcePivarname)){
			IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
			ig599Cond.setPivarname(sourcePivarname);
			ig599Cond.setPrid(sourcePrid);
			List<IG599Info> processList =  workFlowOperationBL.searchProcessInfoByCond(ig599Cond);
			if(processList != null){
				sourcePidid = processList.get(0).getPidid();
			}
		}
		
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(sourcePrid);
		cond.setPidname(sourcePivarname);
		cond.setPidid(sourcePidid);
		List<IG898Info> list = workFlowOperationBL.searchTableFormValue(cond);
		
		if(list != null && list.size() >0){
			String tagPidid = "";
			if(StringUtils.isNotBlank(tagPivarname)){
				IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
				ig599Cond.setPivarname(tagPivarname);
				ig599Cond.setPrid(tagPrid);
				List<IG599Info> processList = workFlowOperationBL.searchProcessInfoByCond(ig599Cond);
				if(processList != null){
					tagPidid = processList.get(0).getPidid();
				}
			}
			for(IG898Info info : list){
				IG898TB tb = new IG898TB();
				tb.setPrid(tagPrid);
				tb.setPidid(tagPidid);
				tb.setPidname(tagPivarname);
				String pvcolpidid = "";
				//暂时按表格式表单的名称相同查询
				IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
				ig007Cond.setPidname(info.getPvcolname());
				ig007Cond.setPpdid_like(tagPdid);
				List<IG007Info> processList = workFlowDefinitionBL.searchProcessInfoDef(ig007Cond);
				if(processList != null){
					pvcolpidid = processList.get(0).getPidid();
				}
				tb.setPvcolpidid(pvcolpidid);
				tb.setPvcolname(info.getPvcolname());
				tb.setPvrownumber(info.getPvrownumber());
				tb.setPvalue(info.getPvalue());
				tb.setFingerPrint(info.getFingerPrint());
				workFlowOperationBL.registTableFormValue(tb);
			}
		}
		
	}
}
