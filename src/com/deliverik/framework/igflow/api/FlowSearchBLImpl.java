/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinition;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.igflow.resultset.ConfigItem;
import com.deliverik.framework.igflow.resultset.ConfigItemInfo;
import com.deliverik.framework.igflow.resultset.EntityItem;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.Participant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ParticipantStatusForm;
import com.deliverik.framework.igflow.resultset.ParticipantStatusFormInfo;
import com.deliverik.framework.igflow.resultset.PrivateProcessForm;
import com.deliverik.framework.igflow.resultset.PrivateProcessFormInfo;
import com.deliverik.framework.igflow.resultset.ProcessFormLog;
import com.deliverik.framework.igflow.resultset.ProcessFormLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntity;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.igflow.resultset.ProcessLog;
import com.deliverik.framework.igflow.resultset.ProcessLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessOverdue;
import com.deliverik.framework.igflow.resultset.ProcessOverdueInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecord;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatus;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0107VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG256BL;
import com.deliverik.framework.workflow.prd.bl.task.IG893BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG898PK;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * 流程查询功能API_业务连续性 drm
 */
public class FlowSearchBLImpl extends BaseBLImpl implements FlowSearchBL {
	
    /** 自定义流程日志*/
    private static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
    
    /** 流程定义BL */
    protected WorkFlowDefinitionBL workFlowDefinitionBL; 
    
    /** 流程处理BL */
    protected WorkFlowOperationBL workFlowOperationBL;

	/** 资产信息BL */
	protected SOC0118BL soc0118BL;

	/** 流程逾期未处理信息表BL */
	protected IG256BL ig256BL;
	
	/** 资产属性BL */
	protected SOC0107BL soc0107BL;
	
	/** 流程参与者变量权限BL */
	protected IG893BL ig893BL;
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
	 * 资产信息BL设定
	 * @param soc0118BL 资产信息BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	/**
	 * 流程逾期信息BL注入设置
	 * @param ig256BL
	 */
	public void setIg256BL(IG256BL ig256BL) {
		this.ig256BL = ig256BL;
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
	 * 流程参与者变量权限BL设定
	 * 
	 * @param ig893BL 流程参与者变量权限BL
	 */
	public void setIg893BL(IG893BL ig893BL) {
		this.ig893BL = ig893BL;
	}
	
	/**
	 * 流程当前状态列表查询
	 * @param prid 流程ID
	 * @return 流程当前状态列表
	 */
	public List<ProcessStatusInfo> searchCurrentStatus(Integer prid) throws BLException {
		List<IG224Info> lst_IG224Info = this.workFlowOperationBL.searchCurrentRecordStatusLog(prid, null);
		List<ProcessStatusInfo> lst_ProcessStatus = null;
		ProcessStatus instance = null;
		if(!lst_IG224Info.isEmpty()) {
			lst_ProcessStatus = new ArrayList<ProcessStatusInfo>();
			for(IG224Info bean : lst_IG224Info) {
				instance = new ProcessStatus();
				instance.setPsdid(bean.getPsdid());//流程状态ID
				instance.setPdid(bean.getPrpdid());//流程定义ID
				instance.setPsdcode(bean.getPrstatus());//流程状态标识
				instance.setPpsdid(bean.getPpsdid()); //上级状态ID
				instance.setOpentime(CommonDefineUtils.DATETIME_SECOND_FORMAT.format(bean.getRslOpenTime())); //状态开始时间
				instance.setStatusnum(bean.getPsdnum()==null?"":bean.getPsdnum().toString()); //状态分支编号
				lst_ProcessStatus.add(instance);
			}
		}
		return lst_ProcessStatus;
	}

	/**
	 * 资产信息查询
	 * <BR>
	 * 结果为最新版信息，包括属性信息
	 * @param eiid 资产ID
	 * @return 资产信息
	 * @throws BLException
	 */
	public EntityItemInfo searchEntityItem(Integer eiid) throws BLException {
	    igflowlog.debug(">>>资产信息查询开始");
		//查询资产基本信息
	    SOC0118Info soc0118Info = this.soc0118BL.searchEntityItemByKey(eiid);
		EntityItem entityItem = new EntityItem(); 
		entityItem.setEiid(eiid);//资产ID
		entityItem.setEiname(soc0118Info.getEiname());//资产名称
		entityItem.setEilabel(soc0118Info.getEilabel());//资产编号
		entityItem.setEiorgsyscoding(soc0118Info.getEiorgsyscoding());//资产所属机构层次码
		entityItem.setEsyscoding(soc0118Info.getEsyscoding());//资产所属模型层次码
		entityItem.setEiuserid(soc0118Info.getEiuserid());//资产配置属性信息
		entityItem.setEiusername(soc0118Info.getEiusername());//资产管理人姓名
		entityItem.setEiversion(soc0118Info.getEiversion());//资产版本
		entityItem.setEismallversion(soc0118Info.getEismallversion());//资产小版本
		//查询最新版属性信息
		List<SOC0107Info> lst_SOC0107Info = this.soc0107BL.searchSOC0107HistoryByEiid(eiid, -1, 0, null);
		List<ConfigItemInfo> lst_ConfigItemInfo = new ArrayList<ConfigItemInfo>();
		ConfigItem instance = null;
		for(SOC0107Info bean : lst_SOC0107Info) {
			instance = new ConfigItem();
			instance.setCiid(bean.getCiid());//属性值ID
			instance.setCid(bean.getCid());//属性定义ID
			instance.setName(bean.getConfiguration().getCname());//属性名称
			instance.setValue(bean.getCivalue());//属性值
			lst_ConfigItemInfo.add(instance);
		}
		entityItem.setConfigItems(lst_ConfigItemInfo);
	    igflowlog.debug(">>>资产信息查询结束");
		return entityItem;
	}
	/**
	 * 资产信息查询(应急资源专用)
	 * <BR>
	 * 结果为最新版信息，包括属性信息
	 * @param id 数据库ID
	 * @param eiid 资产ID
	 * @return 资产信息
	 * @throws BLException
	 */
	public EntityItemInfo searchEntityItem(Integer id , Integer eiid) throws BLException {
		igflowlog.debug(">>>资产信息查询开始");
		SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
		SOC0107VWBL soc0107VWBL = (SOC0107VWBL) WebApplicationSupport.getBean("soc0107VWBL");
		//查询资产基本信息
		SOC0118VWInfo soc0118VW = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(id, eiid));
		EntityItem entityItem = new EntityItem(); 
		entityItem.setEiid(eiid);//资产ID
		entityItem.setEiname(soc0118VW.getEiname());//资产名称
		entityItem.setEilabel(soc0118VW.getEilabel());//资产编号
		entityItem.setEiorgsyscoding(soc0118VW.getEiorgsyscoding());//资产所属机构层次码
		entityItem.setEsyscoding(soc0118VW.getEsyscoding());//资产所属模型层次码
		entityItem.setEiuserid(soc0118VW.getEiuserid());//资产配置属性信息
		entityItem.setEiusername(soc0118VW.getEiusername());//资产管理人姓名
		entityItem.setEiversion(soc0118VW.getEiversion()!=null?Integer.parseInt(soc0118VW.getEiversion()):null);//资产版本
		entityItem.setEismallversion(soc0118VW.getEismallversion());//资产小版本
		//查询最新版属性信息
		List<SOC0107VWInfo> lst_SOC0107Info = soc0107VWBL.searchSOC0107VWHistoryByEiid(id ,eiid, -1, 0, null);
		List<ConfigItemInfo> lst_ConfigItemInfo = new ArrayList<ConfigItemInfo>();
		ConfigItem instance = null;
		for(SOC0107VWInfo bean : lst_SOC0107Info) {
			instance = new ConfigItem();
			instance.setCiid(bean.getCiid());//属性值ID
			instance.setCid(bean.getCid());//属性定义ID
			instance.setName(bean.getConfiguration().getCname());//属性名称
			instance.setValue(bean.getCivalue());//属性值
			lst_ConfigItemInfo.add(instance);
		}
		entityItem.setConfigItems(lst_ConfigItemInfo);
		igflowlog.debug(">>>资产信息查询结束");
		return entityItem;
	}

	/**
	 * 资产信息查询
	 * <BR>
	 * 模型层次码进行前方一致模糊匹配
	 * <BR>
	 * 结果为最新版信息，不包括属性信息
	 * @param esyscoding 模型层次码
	 * @return 资产信息
	 * @throws BLException
	 */
	public List<EntityItemInfo> searchEntityItem(String esyscoding) throws BLException {
	    igflowlog.debug(">>>资产信息查询开始");
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		cond.setEsyscoding(esyscoding);
		List<SOC0124Info> lst_SOC0124Info = this.soc0118BL.searchEntityItemVW(cond);
		List<EntityItemInfo> lst_EntityItemInfo = new ArrayList<EntityItemInfo>();
		EntityItem entityItem = null;
		for(SOC0124Info bean : lst_SOC0124Info) {
			entityItem = new EntityItem();
			entityItem.setEiid(bean.getEiid());//资产ID
			entityItem.setEiname(bean.getEiname());//资产名称
			entityItem.setEilabel(bean.getEilabel());//资产编号
			entityItem.setEiorgsyscoding(bean.getEiorgsyscoding());//资产所属机构层次码
			entityItem.setEsyscoding(bean.getEsyscoding());//资产所属模型层次码
			entityItem.setEiuserid(bean.getEiuserid());//资产配置属性信息
			entityItem.setEiusername(bean.getEiusername());//资产管理人姓名
			entityItem.setEiversion(bean.getEiversion());//资产版本
			entityItem.setEismallversion(bean.getEismallversion());//资产小版本
			lst_EntityItemInfo.add(entityItem);
		}
	    igflowlog.debug(">>>资产信息查询结束");
		return lst_EntityItemInfo;
	}

	/**
	 * 资产信息查询
	 * <BR>
	 * 属性集合可为空，其中key：属性名称，value：属性值
	 * <BR>
	 * 默认查询属性名称=key，属性值=value的记录
	 * <BR>
	 * 当value=null时查询属性名称=key的记录
	 * <BR>
	 * 当value=""时查询属性名称=key，属性值=""的记录
	 * @param value 属性集合
	 * @return 资产ID列表
	 * @throws BLException 
	 */
	public List<Integer> searchEntityItem(Map<String, String> value) throws BLException {
		return this.soc0107BL.searchEiByCname(value);
	}

	/**
	 * 资产属性值查询
	 * <BR>
	 * 当属性名称不存在时抛出异常
	 * @param eiid 资产ID
	 * @param name 资产属性名称
	 * @return 资产属性值
	 * @throws BLException 
	 */
	public String searchEntityItemConfigValue(Integer eiid, String name) throws BLException {
	    igflowlog.debug(">>>资产属性值查询开始");
		if(eiid == null || eiid <= 0) {
			throw new BLException("IGCO10000.E004","资产ID");
		}
		if(StringUtils.isEmpty(name)) {
			throw new BLException("IGCO10000.E004","资产属性名称");
		}
		List<SOC0107Info> lst_ConfigItem = soc0107BL.searchSOC0107HistoryByEiid(eiid, -1, null, name);
		if(lst_ConfigItem.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "属性（" + name + "）");
		} else if(lst_ConfigItem.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "属性（" + name + "）");
		} else {
			String value = lst_ConfigItem.get(0).getCivalue(); 
			igflowlog.debug(">>>资产属性值查询结束，返回资产属性值："+value);
			return value == null ? "" : value;
		}
	}
	
	/**
	 * 根据工单标识查询当前最大工单号
	 * <BR>
	 * 工单标识进行前方一致模糊匹配
	 * @param serialnum 工单标识
	 * @return 最大工单号
	 */
	public String searchMaxSerialnum(String serialnum) throws BLException {
	    igflowlog.debug(">>>流程最大工单号查询开始");
		if(StringUtils.isEmpty(serialnum)) {
			throw new BLException("IGCO10000.E004","工单号标识");
		}
		String strSerialnum = workFlowOperationBL.searchMaxPrserialnum(serialnum);
		igflowlog.debug(">>>流程最大工单号查询结束，返回最大工单号：" + strSerialnum);
		return strSerialnum;
	}
	
	/**
	 * 参与者状态表单信息
	 * @param pdid 流程定义ID
	 * @param statusname 状态名称
	 * @param roleid 处理角色ID
	 * @return 参与者状态表单信息
	 */
	public List<ParticipantStatusFormInfo> searchParticipantStatusFormInfo(String pdid, String statusname, Integer roleid)
			throws BLException {
	    igflowlog.debug(">>>参与者状态表单信息查询开始");
		if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","流程定义ID");
		}
		if(StringUtils.isEmpty(statusname)) {
			throw new BLException("IGCO10000.E004","状态名称");
		}
		if(roleid == null || roleid <=0) {
			throw new BLException("IGCO10000.E004","处理角色ID");
		}
		IG333SearchCondImpl cond_IG333 = new IG333SearchCondImpl();
		cond_IG333.setPdid(pdid);
		cond_IG333.setPsdname(statusname);
		List<IG333Info> lst_IG333Info = workFlowDefinitionBL.searchProcessStatusDef(cond_IG333);
		IG893SearchCondImpl cond_IG893 = new IG893SearchCondImpl();
		cond_IG893.setPsdid(lst_IG333Info.get(0).getPsdid());
		cond_IG893.setRoleid(roleid);
		List<IG893Info> lst_IG893Info = ig893BL.searchIG893Info(cond_IG893);
		List<ParticipantStatusFormInfo> lst_ParticipantStatusFormInfo = new ArrayList<ParticipantStatusFormInfo>();
		ParticipantStatusForm form = null;
		for(IG893Info info : lst_IG893Info) {
			form = new ParticipantStatusForm();
			form.setPidid(info.getPidid());
			form.setPidlabel(info.getPidlabel());
			form.setPidaccess(info.getPidaccess());
			lst_ParticipantStatusFormInfo.add(form);
		}
	    igflowlog.debug(">>>参与者状态表单信息结束");
		return lst_ParticipantStatusFormInfo;
	}
	
	/**
	 * 流程私有表单值查询
	 * <BR>
	 * 当表单名称不存在时抛出异常
	 * @param prid 流程ID
	 * @param pidname 表单名称
	 * @return 表单值列表
	 * @throws BLException 
	 */
	public List<PrivateProcessFormInfo> searchPrivateProcessInfo(Integer prid, String pidname) throws BLException {
	    igflowlog.debug(">>>流程私有表单值查询开始");
		if(prid == 0 || prid <= 0) {
			throw new BLException("IGCO10000.E004","流程定义ID");
		}
		if(StringUtils.isEmpty(pidname)) {
			throw new BLException("IGCO10000.E004","表单名称");
		}
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(prid);//流程ID
		cond.setPivarlabel(pidname);//表单名称
		List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
		if(lst_ProcessInfo.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "表单（" + pidname + "）");
		} else if(lst_ProcessInfo.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "表单（" + pidname + "）");
		} else {
			//IG899SearchCondImpl ncond = new IG899SearchCondImpl();
			//ncond.setPiid(lst_ProcessInfo.get(0).getPiid());
			//获取私有表单
		//	List<IG899Info> lst_ProcessPrivateInfo = workFlowOperationBL.searchProcessPrivateInfo(ncond);//应急合版？？？
			//获取私有表单
			List<IG899TB> lst_ProcessPrivateInfo = lst_ProcessInfo.get(0).getProcessPrivateInfofList();
			//私有表单集合
			List<PrivateProcessFormInfo> lst_PrivateProcessForm = null;
			//私有表单实例
			PrivateProcessForm instance = null;
			if(lst_ProcessPrivateInfo != null && !lst_ProcessPrivateInfo.isEmpty()) {
				lst_PrivateProcessForm = new ArrayList<PrivateProcessFormInfo>();
				//填充集合
				for(IG899TB bean : lst_ProcessPrivateInfo) {
					instance = new PrivateProcessForm();
					instance.setRoleid(bean.getRoleid());//角色ID
					instance.setUserid(bean.getUserid());//用户ID
					instance.setValue(bean.getPpivalue());//表单值
					instance.setComment(bean.getPpicommect());
					lst_PrivateProcessForm.add(instance);
				}
			}
			
			if (igflowlog.isDebugEnabled()) {
	            StringBuffer sbPpivalue = new StringBuffer();
	            for(IG899TB bean : lst_ProcessPrivateInfo) {
	                if (sbPpivalue.toString().equals("")) {
	                    sbPpivalue.append(bean.getPpivalue());
	                } else {
	                    sbPpivalue.append(",").append(bean.getPpivalue());
	                }
	            }
	            igflowlog.debug(">>>返回私有表单值：" + sbPpivalue.toString());
	        }
			igflowlog.debug(">>>流程私有表单值查询结束");
			return lst_PrivateProcessForm;
		}
	}
	
	/**
	 * 流程相关资产查询
	 * <BR>
	 * 当piname为空时返回该流程ID所有的相关资产，当查询无结果时返回null
	 * @param prid 流程ID
	 * @param pidname 表单名称（可为空）
	 * @return 相关资产列表
	 * @throws BLException 
	 */
	public List<ProcessInfoEntityInfo> searchProcessEntityItem(Integer prid, String pidname) throws BLException {
	    igflowlog.debug(">>>流程相关资产查询开始");
	    if(prid == 0 || prid <= 0) {
			throw new BLException("IGCO10000.E004","流程定义ID");
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
		//查询流程的相关资产
		IG731SearchCondImpl cond731 = new IG731SearchCondImpl();
		cond731.setPrid(prid);
		cond731.setPiid(piid);
		List<IG731Info> lst_IG731 = workFlowOperationBL.searchProcessInfoEntityByCond(cond731);
		
		//定义相关资产ID集合
		List<ProcessInfoEntityInfo> list = null;
		//填充相关资产ID集合
		if(lst_IG731 != null && !lst_IG731.isEmpty()) {
			list = new ArrayList<ProcessInfoEntityInfo>();
			for(IG731Info ig731 : lst_IG731) {
				ProcessInfoEntity entity = new ProcessInfoEntity();
				entity.setEiid(ig731.getEiid());
				entity.setEiversion(ig731.getEiversion());
				entity.setFingerPrint(ig731.getFingerPrint());
//				entity.setEiname(ig731.getEntityItemVWTB().getEiname());
				entity.setEiname(ig731.getEntityItemVWTB() == null?"":ig731.getEntityItemVWTB().getEiname());
				list.add(entity);
			}
		}
		
		if (igflowlog.isDebugEnabled()) {
            StringBuffer sbEiid = new StringBuffer();
            for(IG731Info ig731 : lst_IG731) {
                if (sbEiid.toString().equals("")) {
                    sbEiid.append(ig731.getEiid());
                } else {
                    sbEiid.append(",").append(ig731.getEiid());
                }
            }
            igflowlog.debug(">>>流程相关资产查询结束，返回相关资产ID：" + sbEiid.toString());
        }
		return list;
	}
	
	/**
	 * 流程基本信息查询
	 * @param prid 流程ID（可为空）
	 * @param serialnum 流程工单号（可为空）
	 * @return 流程基本信息
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(Integer prid, String serialnum) throws BLException {
	    igflowlog.debug(">>>调用流程基本信息查询开始");
	    IG500SearchCondImpl cond = new IG500SearchCondImpl();
	    cond.setPrid(prid);
	    cond.setPrserialnum(serialnum);
	    List<IG500Info> IG500InfoList = workFlowOperationBL.searchProcessRecord(cond);
	    List<ProcessRecordInfo> retProcessRecordInfoList = new ArrayList<ProcessRecordInfo>();
	    for (IG500Info ig500info : IG500InfoList) {
	        ProcessRecord processRecord = new ProcessRecord();
	        processRecord.setPrclosetime(ig500info.getPrclosetime());
	        processRecord.setPrid(ig500info.getPrid());
	        processRecord.setPrpdname(ig500info.getPrpdname());
	        processRecord.setPrdesc(ig500info.getPrdesc());
	        processRecord.setPrtitle(ig500info.getPrtitle());
	        processRecord.setPrstatus(ig500info.getPrstatus());
	        processRecord.setPropentime(ig500info.getPropentime());
	        processRecord.setPrserialnum(ig500info.getPrserialnum());
	        processRecord.setPrPriority(ig500info.getPrPriority());
	        processRecord.setPrpdid(ig500info.getPrpdid());
	        processRecord.setPrtype(ig500info.getPrtype());
	        processRecord.setPrroleid(ig500info.getPrroleid());
	        processRecord.setPruserid(ig500info.getPruserid());
	        retProcessRecordInfoList.add(processRecord);
	    }
	    igflowlog.debug(">>>调用流程基本信息查询结束，返回流程基本信息列表条数："+retProcessRecordInfoList.size());
	    return retProcessRecordInfoList;
	}
	
	/**
	 * 流程基本信息查询
	 * @param status 流程状态标识
	 * @return 流程基本信息列表
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String status) throws BLException {
		igflowlog.debug(">>>调用流程基本信息查询开始");
	    if(StringUtils.isEmpty(status)) {
			throw new BLException("IGCO10000.E004","流程状态");
		}
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrstatus(status);
		List<IG500Info> IG500InfoList = workFlowOperationBL.searchProcessRecord(cond);
		List<ProcessRecordInfo> retProcessRecordInfoList = new ArrayList<ProcessRecordInfo>();
		for (IG500Info ig500info : IG500InfoList) {
			ProcessRecord processRecord = new ProcessRecord();
			processRecord.setPrclosetime(ig500info.getPrclosetime());
	        processRecord.setPrid(ig500info.getPrid());
	        processRecord.setPrpdname(ig500info.getPrpdname());
			processRecord.setPrdesc(ig500info.getPrdesc());
			processRecord.setPrtitle(ig500info.getPrtitle());
			processRecord.setPrstatus(ig500info.getPrstatus());
			processRecord.setPropentime(ig500info.getPropentime());
			processRecord.setPrserialnum(ig500info.getPrserialnum());
			processRecord.setPrPriority(ig500info.getPrPriority());
	        processRecord.setPrpdid(ig500info.getPrpdid());
	        processRecord.setPrtype(ig500info.getPrtype());
	        processRecord.setPrroleid(ig500info.getPrroleid());
	        processRecord.setPruserid(ig500info.getPruserid());
			retProcessRecordInfoList.add(processRecord);
		}
		igflowlog.debug(">>>调用流程基本信息查询结束，返回流程基本信息列表条数："+retProcessRecordInfoList.size());
		return retProcessRecordInfoList;
	}

	/**
	 * 流程基本信息查询
	 * @param startTime 流程发起时间开始（可为空）
	 * @param endTime 流程发起时间结束（可为空）
	 * @return 流程基本信息列表
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String startTime, String endTime) throws BLException {
		igflowlog.debug(">>>调用流程基本信息查询开始");
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPropentime(startTime);
		cond.setPrclosetime(endTime);
		List<IG500Info> IG500InfoList = workFlowOperationBL.searchProcessRecord(cond);
		List<ProcessRecordInfo> retProcessRecordInfoList = new ArrayList<ProcessRecordInfo>();
		for (IG500Info ig500info : IG500InfoList) {
			ProcessRecord processRecord = new ProcessRecord();
			processRecord.setPrclosetime(ig500info.getPrclosetime());
	        processRecord.setPrid(ig500info.getPrid());
	        processRecord.setPrpdname(ig500info.getPrpdname());
			processRecord.setPrdesc(ig500info.getPrdesc());
			processRecord.setPrtitle(ig500info.getPrtitle());
			processRecord.setPrstatus(ig500info.getPrstatus());
			processRecord.setPropentime(ig500info.getPropentime());
			processRecord.setPrserialnum(ig500info.getPrserialnum());
	        processRecord.setPrpdid(ig500info.getPrpdid());
	        processRecord.setPrtype(ig500info.getPrtype());
	        processRecord.setPrroleid(ig500info.getPrroleid());
	        processRecord.setPruserid(ig500info.getPruserid());
			retProcessRecordInfoList.add(processRecord);
		}
		igflowlog.debug(">>>调用流程基本信息查询结束，返回流程基本信息列表条数："+retProcessRecordInfoList.size());
		return retProcessRecordInfoList;
	}
	
	/**
	 * 流程基本信息查询
	 * @param pdid 流程定义ID
	 * @param beginTime 流程发起时间开始（可为空）
	 * @param endTime 流程发起时间结束（可为空）
	 * @return 流程基本信息列表
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String pdid, String beginTime, String endTime) throws BLException {
	    igflowlog.debug(">>>调用流程基本信息查询开始");
	    if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","流程定义ID");
		}
	    List<IG500Info> IG500InfoList;
	    IG500SearchCondImpl cond = new IG500SearchCondImpl();
        cond.setPrpdid(pdid);
        cond.setPropentime(beginTime);
        cond.setPrclosetime(endTime);
        IG500InfoList = workFlowOperationBL.searchProcessRecord(cond);
	    List<ProcessRecordInfo> retProcessRecordInfoList = new ArrayList<ProcessRecordInfo>();
	    for (IG500Info ig500info : IG500InfoList) {
	        ProcessRecord processRecord = new ProcessRecord();
	        processRecord.setPrclosetime(ig500info.getPrclosetime());
	        processRecord.setPrid(ig500info.getPrid());
	        processRecord.setPrpdname(ig500info.getPrpdname());
	        processRecord.setPrdesc(ig500info.getPrdesc());
	        processRecord.setPrtitle(ig500info.getPrtitle());
	        processRecord.setPrstatus(ig500info.getPrstatus());
	        processRecord.setPropentime(ig500info.getPropentime());
	        processRecord.setPrserialnum(ig500info.getPrserialnum());
	        processRecord.setPrpdid(ig500info.getPrpdid());
	        processRecord.setPrtype(ig500info.getPrtype());
	        processRecord.setPrroleid(ig500info.getPrroleid());
	        processRecord.setPruserid(ig500info.getPruserid());
	        retProcessRecordInfoList.add(processRecord);
	    }
	    igflowlog.debug(">>>调用流程基本信息查询结束，返回流程基本信息列表条数："+retProcessRecordInfoList.size());
	    return retProcessRecordInfoList;
	}
	
	/**
	 * 流程表单描述信息查询
	 * <BR>
	 * 当表单名称不存在时抛出异常
	 * @param pdid 流程定义ID
	 * @param name 表单名称
	 * @return 表单描述信息
	 * @throws BLException
	 */
	public String searchProcessInfoDefDescByName(String pdid, String name) throws BLException {
	    igflowlog.debug(">>>流程表单描述信息查询开始");
	    if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","流程定义ID");
		}
		if(StringUtils.isEmpty(name)) {
			throw new BLException("IGCO10000.E004","表单名称");
		}
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//流程ID
		cond.setPidname(name);//表单名称
		List<IG007Info> lst_ProcessInfoDef = workFlowDefinitionBL.searchProcessInfoDef(cond);
		
		if(lst_ProcessInfoDef.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "表单（" + name + "）");
		} else if(lst_ProcessInfoDef.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "表单（" + name + "）");
		} else {
			String value = lst_ProcessInfoDef.get(0).getPiddesc(); 
			igflowlog.debug(">>>流程表单描述信息查询结束，返回值：" + value);
			return value == null ? "" : value;
		}
	}

	/**
	 * 流程处理记录查询
	 * @param prid 流程ID
	 * @param psdid 流程状态ID
	 * @param psdnum 流程状态分支编号
	 * @param userid 处理用户ID
	 * @return 流程处理记录列表
	 * @throws BLException
	 */
	public List<ProcessLogInfo> searchProcesslog(Integer prid, String psdid, Integer psdnum, String userid)
			throws BLException {
		IG036SearchCondImpl cond = new IG036SearchCondImpl();
		cond.setPrid(prid);
		cond.setRlType(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);//处理日志
		cond.setPsdid(psdid);
		cond.setPsdnum(psdnum);
		cond.setRluserid(userid);
		List<IG036Info> lst_IG036Info = workFlowOperationBL.searchUserRoleRecondLog(cond);
		List<ProcessLogInfo> lst_ProcessLogInfo = null;
		ProcessLog instance = null;
		int size = lst_IG036Info.size();
		if(size > 0) {
			lst_ProcessLogInfo = new ArrayList<ProcessLogInfo>();
			for(int i=0;i<size;i++) {
				IG036Info bean = lst_IG036Info.get(i);
				instance = new ProcessLog();
				instance.setPlid(bean.getRlid());//日志ID
				instance.setPsdid(bean.getPsdid());//流程状态ID
				instance.setRecord(bean.getRlcomment());//处理记录
				instance.setRoleid(bean.getRoleid());//处理角色ID
				instance.setRolename(bean.getRlrolename());//处理角色名称
				instance.setUserid(bean.getRluserid());//处理人ID
				instance.setUsername(bean.getRlusername()); //处理人姓名
				instance.setCommittime(bean.getRltime()); //提交时间
				lst_ProcessLogInfo.add(instance);
			}
		}
		return lst_ProcessLogInfo;
	}
	
	/**
	 * 流程表单日志查询
	 * @param prid 流程ID
	 * @param psdid 流程状态ID
	 * @param psdnum 流程状态分支编号
	 * @param userid 处理用户ID
	 * @return 流程表单日志列表
	 */
	public List<ProcessFormLogInfo> searchProcessFormlog(Integer prid, String psdid, Integer psdnum, String userid)
			throws BLException {
		IG036SearchCondImpl cond = new IG036SearchCondImpl();
		cond.setPrid(prid);
		cond.setRlType(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);//处理日志
		cond.setPsdid(psdid);
		cond.setPsdnum(psdnum);
		cond.setRluserid(userid);
		List<IG036Info> lst_IG036Info = workFlowOperationBL.searchUserRoleRecondLog(cond);
		List<ProcessFormLogInfo> lst_ProcessFormLogInfo = null;
		for(int i= lst_IG036Info.size() - 1;i>=0; i--){
			IG036Info info = lst_IG036Info.get(i);
		//for(IG036Info info : lst_IG036Info) {//前两行应急合版，此处原逻辑
			//查找处理类日志中，Rldesc不包含"参与者"的记录，取第一条视为提交处理记录
			if(info.getRldesc().indexOf("参与者") == -1) {
				List<IG113Info> lst_IG113Info = this.workFlowOperationBL.searchRecordLogVarInfoByRecordId(info.getRlid());
				ProcessFormLog instance = null;
				if(!lst_IG113Info.isEmpty()) {
					lst_ProcessFormLogInfo = new ArrayList<ProcessFormLogInfo>();
					for(IG113Info bean : lst_IG113Info) {
						instance = new ProcessFormLog();
						instance.setPidid(bean.getPidid());//表单定义ID
						instance.setName(bean.getPivarname());//表单名称
						if(bean.getPivarname().equals("事件上报人")){
							instance.setValue(bean.getPishowvarname());//表单值
						}else{
							instance.setValue(bean.getPivarvalue());//表单值
						}
						lst_ProcessFormLogInfo.add(instance);
					}
				}
				break;
			}
		}
		return lst_ProcessFormLogInfo;
	}

	/**
	 * 指定流程状态逾期未处理参与者查询
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 逾期未处理参与者信息
	 * @throws BLException
	 */
	public List<ProcessOverdueInfo> searchProcessOverdueInfo(Integer prid, String status)
			throws BLException {
		IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
		ig256Cond.setPrid(prid);
//		ig256Cond.setPrstatus(status);
		ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);//只有超时有提示图标 提醒不显示
		List<IG256Info> lst_IG256Info = ig256BL.searchIG256(ig256Cond);
		List<ProcessOverdueInfo> lst_ProcessOverdueInfo = new ArrayList<ProcessOverdueInfo>();
		ProcessOverdue bean = null; 
		for(IG256Info info : lst_IG256Info) {
			bean = new ProcessOverdue();
			bean.setUserid(info.getPpuserid());
			bean.setUsername(info.getPpusername());
			lst_ProcessOverdueInfo.add(bean);
		}
		return lst_ProcessOverdueInfo;
	}

	/**
	 * 流程关系查询
	 * 根据主流程ID查询子流程ID
	 * 
	 * @param parprid 主流程ID
	 * @return 子流程ID列表
	 * @throws BLException
	 */
	public List<Integer> searchProcessRelationForCld(Integer parprid) throws BLException {
		IG512SearchCondImpl cond = new IG512SearchCondImpl();
		cond.setParprid(parprid);
		List<IG512Info> lst_IG512Info = workFlowOperationBL.searchProcessRecordRelation(cond);
		List<Integer> lst_Prid = new ArrayList<Integer>();
		for(IG512Info bean : lst_IG512Info) {
			lst_Prid.add(bean.getCldprid());
		}
		return lst_Prid;
	}
	
	/**
	 * 流程关系查询
	 * 根据子流程ID查询主流程ID
	 * 
	 * @param cldprid 子流程ID
	 * @return 主流程ID
	 * @throws BLException
	 */
	public Integer searchProcessRelationForPar(Integer cldprid) throws BLException {
		IG512SearchCondImpl cond = new IG512SearchCondImpl();
		cond.setCldprid(cldprid);
		List<IG512Info> lst_IG512Info = workFlowOperationBL.searchProcessRecordRelation(cond);
		if(lst_IG512Info.isEmpty()) {
			return null;
		} else {
			return lst_IG512Info.get(0).getParprid();
		}
		
	}

	/**
	 * 流程表格式表单定义查询
	 * <BR>
	 * 该方法的返回结果仅作为表格式表单单个值的查询与设定
	 * <BR>
	 * 定义信息不存在时抛异常
	 * @param prid 流程ID
	 * @return 表格式表单定义信息
	 * @throws BLException
	 */
	public Map<String, ProcessInfoDefinitionInfo> searchProcessTableColumnDef(Integer prid) throws BLException {
		igflowlog.debug(">>>流程表格式表单定义查询开始！");
	    if(prid == null || prid <= 0) {
			throw new BLException("IGCO10000.E004","流程ID");
		}
		//查询流程信息
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
		//查询表单定义信息
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPdid(process.getPrpdid());
		List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(pidcond);
		if(pidList == null){
			throw new BLException("IGFLOW0000.E001","表单定义信息");
		}
		Map<String, IG007Info> pidMap = new HashMap<String, IG007Info>();
		for(IG007Info pid:pidList){
			pidMap.put(pid.getPidid(), pid);
		}
		Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap = new HashMap<String, ProcessInfoDefinitionInfo>();
		for(IG007Info pid:pidList){
			IG007Info cpid = pid;
			String fullName = cpid.getPidname();
			while(StringUtils.isNotEmpty(cpid.getPpidid())){
				cpid = pidMap.get(cpid.getPpidid());
				fullName = cpid.getPidname() + "#" + fullName;
			}
			ProcessInfoDefinition pidInfo = new ProcessInfoDefinition();
			pidInfo.setPidid(pid.getPidid());
			pidInfo.setPidname(pid.getPidname());
			pidInfo.setPpidid(pid.getPpidid());
			tableColumnDefMap.put(fullName, pidInfo);
		}
		igflowlog.debug(">>>流程表格式表单定义查询结束！");
		return tableColumnDefMap;
	}
	
	/**
	 * 查询表格式表单层级定义信息
	 * 定义信息不存在时抛异常
	 * @param prid 流程主键
	 * @return 表格式表单层级定义信息
	 * @throws BLException
	 */
	private Map<String, List<IG007Info>> searchProcessTableColumnTierDef(Integer prid) throws BLException{
		igflowlog.debug(">>>流程表格式表单定义查询开始！");
		//查询流程信息
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
		//查询表单定义信息
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPdid(process.getPrpdid());
		List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(pidcond);
		if(pidList == null){
			throw new BLException("IGFLOW0000.E001","表单定义信息");
		}
		//层级关系map
		Map<String, List<IG007Info>> processTableColumnTierDefMap = new HashMap<String, List<IG007Info>>();
		for(IG007Info info:pidList){
			if(StringUtils.isNotEmpty(info.getPpidid())){
				if(processTableColumnTierDefMap.get(info.getPpidid()) == null){
					List<IG007Info> temp = new ArrayList<IG007Info>();
					temp.add(info);
					processTableColumnTierDefMap.put(info.getPpidid(), temp);
				}else{
					processTableColumnTierDefMap.get(info.getPpidid()).add(info);
				}
			}
		}
		igflowlog.debug(">>>流程表格式表单定义查询结束！");
		return processTableColumnTierDefMap;
	}
	
	/**
	 * 公有人员表单信息查询
	 * 流程信息不存在或表单信息不存在时抛异常
	 * @param prid 流程ID
	 * @param name 表单名称
	 * @return 人员信息集合
	 * @throws BLException
	 */
	public List<ParticipantInfo> searchPublicParticipantFormValue(Integer prid,String name) throws BLException{
		igflowlog.debug(">>>公有人员表单信息查询操作开始");
		//取得表单值
		String value = searchPublicProcessInfo(prid, name);
		//实例化返回值
		List<ParticipantInfo> participants = new ArrayList<ParticipantInfo>();
		if(StringUtils.isNotEmpty(value)){
			//查询当前流程中人员表单信息
			List<IG506Info> list = workFlowOperationBL.searchIG506InfoByprid(prid);
			if(list != null){
				//封装人员信息
				Map<String, IG506Info> map = new HashMap<String, IG506Info>();
				for(IG506Info pv:list){
					String key = pv.getPiuid() + "";
					map.put(key, pv);
				}
				String[] infos = value.split(",");
				if(infos != null && infos.length > 0){
					for(String key:infos){
						IG506Info pv = map.get(key);
						if(pv != null){
							Participant entry = new Participant();
							entry.setOrgid(pv.getPiorgid());
							entry.setOrgname(pv.getPiorgname());
							entry.setUserid(pv.getPiuserid());
							entry.setUsername(pv.getPiusername());
							entry.setRoleid(pv.getPiroleid());
							entry.setRolename(pv.getPirolename());
							entry.setPhone(pv.getPiphone());
							participants.add(entry);
						}
					}
				}
			}
		}
		igflowlog.debug(">>>公有人员表单信息查询操作结束");
		return participants;
	}

	/**
	 * 流程公有表单值查询
	 * <BR>
	 * 当表单名称不存在时抛出异常
	 * @param prid 流程ID
	 * @param name 表单名称
	 * @return 表单值
	 * @throws BLException
	 */
	public String searchPublicProcessInfo(Integer prid, String name) throws BLException {
	    igflowlog.debug(">>>流程公有表单值查询开始");
	    if(prid == null || prid <= 0) {
			throw new BLException("IGCO10000.E004","流程ID");
		}
		if(StringUtils.isEmpty(name)) {
			throw new BLException("IGCO10000.E004","表单名称");
		}
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(prid);//流程ID
		cond.setPivarlabel(name);//表单名称
		List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
		if(lst_ProcessInfo.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "表单（" + name + "）");
		} else if(lst_ProcessInfo.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "表单（" + name + "）");
		}
		igflowlog.debug(">>>流程公有表单值查询结束");
		return lst_ProcessInfo.get(0).getPivarvalue() == null ? "" : lst_ProcessInfo.get(0).getPivarvalue();
	}

	/**
	 * 表格式表单公有值查询(表单层级名称中间以 "#" 隔开)
	 * <BR>
	 * 表单全路径不存在时抛异常
	 * @param tableColumnDefMap 表格式表单列定义
	 * @param tableColumnFullName 表格式表单列全路径名称
	 * @param prid 流程ID
	 * @param rownumber 行号
	 * @return 表格式表单值
	 * @throws BLException
	 */
	public String searchPublicTableColumnValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,
			String tableColumnFullName, Integer prid,String rownumber) throws BLException {
		igflowlog.debug(">>>表格式表单公有列值查询操作开始！");
		String returnValue = null;
		if(prid == null || prid == 0){
			throw new BLException("IGFLOW0000.E001","流程主键");
		}
		if(StringUtils.isEmpty(rownumber)){
			throw new BLException("IGFLOW0000.E001","行号");
		}
		try{
			//取得表单定义信息
			ProcessInfoDefinitionInfo pid = tableColumnDefMap.get(tableColumnFullName);
			IG898PK pk = new IG898PK();
			pk.setPidid(pid.getPpidid());
			pk.setPrid(prid);
			pk.setPvcolpidid(pid.getPidid());
			pk.setPvrownumber(rownumber);
			IG898Info tableColumn = workFlowOperationBL.searchTableFormValueByKey(pk);
			if(tableColumn != null){
				returnValue = tableColumn.getPvalue();
			}
		}catch (Exception e) {
			throw new BLException("IGFLOW0000.E001","表单定义信息");
		}
		igflowlog.debug(">>>表格式表单公有列值查询操作结束，返回表单值：" + returnValue);
		return returnValue;
	}
	
	/**
	 * 表格类表单值查询
	 * <BR>
	 * 表单全路径不存在时抛异常
	 * @param tableFullName 表格式表单全名
	 * @param prid 流程ID
	 * @param rownumber 行号(如果是顶级传空字符串)
	 * @return 表格式表单值（ArrayList）
	 * @throws BLException
	 */
	public Object searchPublicTableValue(String tableFullName, Integer prid,String rownumber) throws BLException{
		igflowlog.debug(">>>表格式表单公有值查询操作开始！");
		Object returnValue = null;
		if(prid == null || prid == 0){
			throw new BLException("IGFLOW0000.E001","流程主键");
		}
		//查询表格定义信息
		Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap = searchProcessTableColumnDef(prid);
		if(tableColumnDefMap != null){
			ProcessInfoDefinitionInfo tabledef = tableColumnDefMap.get(tableFullName);
			if(tabledef != null){
				//取得表格层级定义
				Map<String, List<IG007Info>> tableColumnTierDef = searchProcessTableColumnTierDef(prid);
				//查询该流程下的表格式表单的值
				IG898SearchCondImpl cond = new IG898SearchCondImpl();
				cond.setPrid(prid);
				List<IG898Info> tableColumnValueList = workFlowOperationBL.searchTableFormValue(cond);
				Map<String, Map<String, Map<String, String>>> tableColumnValueMap = new HashMap<String, Map<String,Map<String,String>>>();
				for(IG898Info columnValue:tableColumnValueList){
					if(tableColumnValueMap.get(columnValue.getPidid()) == null){
						Map<String, Map<String, String>> one = new LinkedHashMap<String, Map<String,String>>();
						Map<String, String> two = new LinkedHashMap<String, String>();
						two.put(columnValue.getPvcolpidid(), columnValue.getPvalue());
						one.put(columnValue.getPvrownumber(), two);
						tableColumnValueMap.put(columnValue.getPidid(), one);
					}else{
						if(tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()) == null){
							Map<String, String> temp = new LinkedHashMap<String, String>();
							temp.put(columnValue.getPvcolpidid(), columnValue.getPvalue());
							tableColumnValueMap.get(columnValue.getPidid()).put(columnValue.getPvrownumber(), temp);
						}else{
							tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()).put(columnValue.getPvcolpidid(), columnValue.getPvalue());
						}
					}
				}
				returnValue = getTableColumnValue(tableColumnTierDef,tableColumnValueMap,tabledef.getPidid(),rownumber);
			}else{
				throw new BLException("IGFLOW0000.E001","表单定义信息");
			}
		}else{
			throw new BLException("IGFLOW0000.E001","表单定义信息");
		}
		igflowlog.debug(">>>表格式表单公有值查询操作结束！");
		return returnValue;
	}

	/**
	 * 按层级关系组装表格式表单值
	 * @param tableColumnTierDef 表格式表单值定义
	 * @param tableColumnValueMap 表格式表单值
	 * @param pidid 表单定义主键
	 * @param rownumber 行号
	 * @return 具有层级关系的表格式表单值
	 */
	private Object getTableColumnValue(Map<String, List<IG007Info>> tableColumnTierDef,Map<String, Map<String, Map<String, String>>> tableColumnValueMap,String pidid, String rownumber) {
		List<Object> valueList = null;
		if(tableColumnTierDef != null && tableColumnValueMap != null){
			List<IG007Info> list = tableColumnTierDef.get(pidid);
			Map<String, Map<String, String>> map = tableColumnValueMap.get(pidid);
			if(list != null){
				valueList = new ArrayList<Object>();
				int index = 1;
				if(map != null){
					Set<Entry<String, Map<String, String>>> set = map.entrySet();
					for(Iterator<Entry<String, Map<String, String>>> iter = set.iterator();iter.hasNext();){
						iter.next();
						String crownum = StringUtils.isNotEmpty(rownumber) ? rownumber + "_" + index : index + "";
						Map<String, String> columnValueMap = map.get(crownum);
						if(columnValueMap == null){
							continue;
						}
						Map<String, Object> valueMap = new LinkedHashMap<String, Object>();
						for(IG007Info pid:list){
							if("8".equals(pid.getPidtype())){
								valueMap.put(pid.getPidname(), getTableColumnValue(tableColumnTierDef, tableColumnValueMap, pid.getPidid(), crownum));
							}else{
								valueMap.put(pid.getPidname(), columnValueMap.get(pid.getPidid()));
							}
						}
						valueList.add(valueMap);
						index ++;
					}
				//如果当前层级的下一集是表格式表单，map中不会有值
				}else{
					int rows = 1;
					if(tableColumnValueMap != null){
						for(IG007Info pid:list){
							Map<String, Map<String, String>> value = tableColumnValueMap.get(pid.getPidid());
							if(value != null){
								for(Iterator<String> iter = value.keySet().iterator();iter.hasNext();){
									String next = iter.next();
									if(StringUtils.isNotEmpty(next)){
										String[] split = next.split("_");
										if(split.length > 1){
											if(Integer.valueOf(split[split.length - 2]) > rows){
												rows = Integer.valueOf(split[split.length - 2]);
											}
										}
									}
								}
							}
						}
					}
					for(int i=0;i<rows;i++){
						boolean flag = false;
						Map<String, Object> valueMap = new LinkedHashMap<String, Object>();
						String crownum = StringUtils.isNotEmpty(rownumber) ? rownumber + "_" + index : index + "";
						for(IG007Info pid:list){
							if("8".equals(pid.getPidtype())){
								flag = true;
								valueMap.put(pid.getPidname(), getTableColumnValue(tableColumnTierDef, tableColumnValueMap, pid.getPidid(), crownum));
							}else{
								valueMap.put(pid.getPidname(), "");
							}
						}
						if(flag){
							valueList.add(valueMap);
						}
						index ++;
					}
				}
			}
		}
		return valueList;
	}

	/**
	 * 监管报表信息查询
	 * <BR>
	 * 不包括不定期和中止报表
	 * @param type 报表类型
	 * @param pdid 流程定义ID
	 * @param key 年报格式：2012,季报格式：2012_一季度
	 * @param isClose true：查询已关闭，false：查询未关闭，null：查询全部，不包括中止
	 * @return 监管报表ID列表
	 * @throws BLException
	 */
	public List<Integer> searchRegulatoryReportInfo(String type, String pdid, String key, Boolean isClose)
			throws BLException {
	    igflowlog.debug(">>>调用监管报表基本信息查询开始");
	    List<Integer> lst_Prid= workFlowOperationBL.searchRegulatoryReportDetailByKey(type, pdid, key, isClose);
	    igflowlog.debug(">>>调用监管报表基本信息查询结束，返回流程基本信息列表条数："+lst_Prid.size());
	    return lst_Prid;
	}
	
	/**
	 * 流程状态列表查询
	 * <BR>
	 * 只返回定义信息，时间信息为空
	 * @param pdid 流程定义ID
	 * @return 流程状态列表
	 * @throws BLException 
	 */
	public List<ProcessStatusInfo> searchProcessStatusList(String pdid) throws BLException {
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		List<IG333Info> lst_IG333Info = this.workFlowDefinitionBL.searchProcessStatusDef(cond);
		List<ProcessStatusInfo> lst_ProcessStatus = null;
		ProcessStatus instance = null;
		if(!lst_IG333Info.isEmpty()) {
			lst_ProcessStatus = new ArrayList<ProcessStatusInfo>();
			for(IG333Info bean : lst_IG333Info) {
				instance = new ProcessStatus();
				instance.setPsdid(bean.getPsdid());//流程状态ID
				instance.setPdid(bean.getPdid());//流程定义ID
				instance.setPsdname(bean.getPsdname());//流程状态名称
				instance.setPsdcode(bean.getPsdcode());//流程状态标识
				instance.setBysequence(bean.getBysequence());//排序
				instance.setPpsdid(bean.getPpsdid()); //上级状态ID
				instance.setFingerPrint(bean.getFingerPrint()); //时间戳,应急合版
				lst_ProcessStatus.add(instance);
			}
		}
		return lst_ProcessStatus;
	}
	
	/**
	 * 流程状态查询
	 * <BR>
	 * 只返回定义信息，时间信息为空
	 * @param psdid 流程状态ID
	 * @return 流程状态
	 * @throws BLException 
	 */
	public ProcessStatusInfo searchProcessStatus(String psdid) throws BLException {
		IG333Info ig333Info = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		ProcessStatus instance = new ProcessStatus();
		instance.setPsdid(ig333Info.getPsdid());//流程状态ID
		instance.setPdid(ig333Info.getPdid());//流程定义ID
		instance.setPsdname(ig333Info.getPsdname());//流程状态名称
		instance.setPsdcode(ig333Info.getPsdcode());//流程状态标识
		instance.setBysequence(ig333Info.getBysequence());//排序
		instance.setPpsdid(ig333Info.getPpsdid()); //上级状态ID
		return instance;
	}
	
	/**
	 * 流程状态日志列表查询
	 * @param pdid 流程定义ID
	 * @return 流程状态日志列表
	 * @throws BLException 
	 */
	public List<ProcessStatusInfo> searchProcessStatusLog(Integer prid) throws BLException {
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		List<IG224Info> lst_IG224Info = this.workFlowOperationBL.searchProcessStatusLog(cond);
		List<ProcessStatusInfo> lst_ProcessStatus = null;
		ProcessStatus instance = null;
		if(!lst_IG224Info.isEmpty()) {
			lst_ProcessStatus = new ArrayList<ProcessStatusInfo>();
			for(IG224Info bean : lst_IG224Info) {
				instance = new ProcessStatus();
				instance.setPsdid(bean.getPsdid());//流程状态ID
				instance.setPdid(bean.getPrpdid());//流程定义ID
				instance.setPsdcode(bean.getPrstatus());//流程状态标识
				instance.setPpsdid(bean.getPpsdid()); //上级状态ID
				instance.setOpentime(CommonDefineUtils.DATETIME_SECOND_FORMAT.format(bean.getRslOpenTime())); //状态开始时间
				if(bean.getRslCloseTime() != null) {
					instance.setClosetime(CommonDefineUtils.DATETIME_SECOND_FORMAT.format(bean.getRslCloseTime())); //状态结束时间
				}
				instance.setStatusnum(bean.getPsdnum()==null?"":bean.getPsdnum().toString()); //状态分支编号
				lst_ProcessStatus.add(instance);
			}
		}
		return lst_ProcessStatus;
	}

	/**
	 * 状态参与者查询
	 * <BR>
	 * 当状态名称不存在时抛出异常
	 * @param prid 流程ID
	 * @param name 状态名称
	 * @return 参与者列表
	 * @throws BLException 
	 */
	public List<ParticipantInfo> searchStatusParticipant(Integer prid, String name) throws BLException {
	    igflowlog.debug(">>>状态参与者查询开始");
	    if(prid == null || prid <= 0) {
			throw new BLException("IGCO10000.E004","流程ID");
		}
		if(StringUtils.isEmpty(name)) {
			throw new BLException("IGCO10000.E004","状态名称");
		}
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
		IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
		psdCond.setPdid(process.getPrpdid());
		psdCond.setPsdname(name);
		List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
		if(lst_ProcessStatusDef.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "状态（" + name + "）");
		} else if(lst_ProcessStatusDef.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "状态（" + name + "）");
		}
		igflowlog.debug(">>>状态参与者查询结束");
//		return searchStatusParticipantByCode(prid, lst_ProcessStatusDef.get(0).getPsdcode());
		//自定义流程改造，参与人表中的code码将不会有实际意义，根据状态查询参与人将由状态定义id代替   wangtingzhi 20140513
		return searchStatusParticipantByCode(prid, lst_ProcessStatusDef.get(0).getPsdid());
	}

	/**
	 * 状态参与者查询
	 * @param prid 流程ID
	 * @param status 状态标识
	 * @return 参与者列表
	 * @throws BLException 
	 */
	public List<ParticipantInfo> searchStatusParticipantByCode(Integer prid, String status) throws BLException {
		///自定义流程改造，状态code码将不会有实际意义，根据状态查询参与人将由状态定义ID代替
		///status 原为状态code吗，如今该为状态定义ID
		///wangtingzhi 20140513
	    igflowlog.debug(">>>状态参与者查询开始");
	    if(prid == null || prid <= 0) {
			throw new BLException("IGCO10000.E004","流程ID");
		}
		if(StringUtils.isEmpty(status)) {
			throw new BLException("IGCO10000.E004","状态标识");
		}
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPsdid(status);
//		cond.setPpstatus(status); 原来根据code码查询作废   wangtingzhi  20140513
		//查询参与者
		List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
		//参与者集合
		List<ParticipantInfo> lst_Participant = new ArrayList<ParticipantInfo>();;
		//参与者实例
		Participant instance = null;
		if(lst_ProcessParticipant != null && !lst_ProcessParticipant.isEmpty()) {
			for(IG337Info bean : lst_ProcessParticipant) {
				instance = new  Participant();
				instance.setRoleid(bean.getPproleid());//角色ID
				instance.setRolename(bean.getPprolename());//角色名称
				instance.setUserid(bean.getPpuserid());//用户ID
				instance.setUsername(bean.getPpusername());//用户姓名
				instance.setOrgid(bean.getPporgid()); //用户机构码
				instance.setOrgname(bean.getPporgname()); //用户机构名称
				instance.setPpinittime(bean.getPpinittime()); //处理开始时间
				instance.setPpproctime(bean.getPpproctime()); //处理结束时间
				lst_Participant.add(instance);
			}
		}
		if (igflowlog.isDebugEnabled()) {
		    StringBuffer sbParticipant = new StringBuffer();
	        for(IG337Info bean : lst_ProcessParticipant) {
	            if (sbParticipant.toString().equals("")) {
	                sbParticipant.append(bean.getPpuserid());
	            } else {
	                sbParticipant.append(",").append(bean.getPpuserid());
	            }
	        }
	        igflowlog.debug(">>>返回状态参与者：" + sbParticipant.toString());
	    }
		igflowlog.debug(">>>状态参与者查询结束");
		return lst_Participant;
	}
	
	/**
	 * 人员表单值查询
	 * @param prid 流程ID
	 * @param pidname 表单名称
	 * @return 人员信息集合
	 * @throws 当流程ID为空时抛异常
	 */
	public List<ParticipantInfo> searchProcessParticipantForm(Integer prid,String pidname) throws BLException {
	    if(prid == null || prid == 0){
	        throw new BLException("IGCO10000.E004","流程ID");
	    }
	    List<ParticipantInfo> list = new ArrayList<ParticipantInfo>();
	    //查询人员表单信息
	    List<IG506Info> pfList = workFlowOperationBL.searchIG506InfoByprid(prid);
	    Map<String, IG506Info> map = new HashMap<String, IG506Info>();
	    if(pfList != null){
	        for(IG506Info info:pfList){
	            map.put(info.getPiuid() + "", info);
	        }
	    }
	    //查询表单值
	    if(StringUtils.isNotEmpty(pidname)){
	        String value = searchPublicProcessInfo(prid, pidname);
	        if(StringUtils.isNotEmpty(value)){
	            for(String s:value.split(",")){
	                IG506Info info = map.get(s);
	                if(info != null){
	                    Participant p = new Participant();
	                    p.setOrgid(info.getPiorgid());
	                    p.setOrgname(info.getPiorgname());
	                    p.setPhone(info.getPiphone());
	                    p.setRoleid(info.getPiroleid());
	                    p.setRolename(info.getPirolename());
	                    p.setUserid(info.getPiuserid());
	                    p.setUsername(info.getPiusername());
	                    list.add(p);
	                }
	            }
	        }
	    }
	    return list;
	}
}
