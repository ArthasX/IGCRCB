/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.EntityItem;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValue;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.infogovernor.util.DateUtils;
/**
 * 组合场景定义-关闭节点前处理将场景流程定义登记为资产处理
 * 
 */
public class IGDRMEVENT0201BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0201BLImpl.class);
    
    /** 查询类API */
    private FlowSearchBL flowSearchBL;
    
    /** 更新类API */
    private FlowSetBL flowSetBL;

    /** 系统类API */
    private SysManageBL sysManageBL;
    
    /** 资产信息BL */
    private SOC0118BL soc0118BL;
    
    /** 模型信息BL */
    private SOC0117BL soc0117BL;
    
    /** 资产关系信息管理BL */
    private SOC0119BL soc0119BL;
    
    /** 基础数据BL */
	private CodeDetailBL codeDetailBL;
	
	/** 流程组信息BL */
	private IG480BL ig480BL;
    
	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 系统类API设定
	 * @param sysManageBL 系统类API
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * 资产信息BL设定
	 * @param soc0118BL 资产信息BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * 模型信息BL设定
	 * @param soc0117BL 模型信息BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	/**
	 * 资产关系信息管理BL设定
	 * @param soc0119BL 资产关系信息管理BL
	 */
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}

	/**
	 * 基础数据BL设定
	 * @param codeDetailBL 基础数据BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * 流程组信息BL设定
	 * @param ig480BL 流程组信息BL
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }

	/**
	 * 场景定义-关闭节点前处理将场景流程定义登记为资产处理
	 * @param dto
	 * @return Map<String, Object>
	 * @throws BLException
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	log.debug("========关闭节点前处理将场景流程定义登记为资产处理开始========");
		//场景名称 scene
		//String prtitle = ig500Info.getPrtitle();
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景名称");
    	String eidesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景描述");
    	String time = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "预计恢复时间");
    	String stepPdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景应急处置步骤");
    	List<ProcessInfoEntityInfo> itemList = flowSearchBL.searchProcessEntityItem(bean.getLogInfo().getPrid(), "应急资源");
    	
    	//soc0118->
    	//流程发起人所在机构
    	String eiorgsyscoding = sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid();
    	String esyscoding = "999060";
    	EntityItem eiTB = new EntityItem();
    	eiTB.setEsyscoding(esyscoding);//999060
    	eiTB.setEiname(prtitle);//场景名称
    	eiTB.setEidesc(eidesc);//场景描述
    	//通过soc0118发番
    	eiTB.setEilabel(getEiLabel(esyscoding));
    	eiTB.setEiorgsyscoding(eiorgsyscoding);
    	eiTB.setEiuserid(bean.getCrtuserid());//
    	eiTB.setEiusername(sysManageBL.searchUserInfo(bean.getCrtuserid()).getUsername());//
    	List<EntityItemConfigValueInfo> configItems = new ArrayList<EntityItemConfigValueInfo>();
    	//soc0107->
    	EntityItemConfigValue entityConfig = null;
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("场景名称");
    	entityConfig.setValue(prtitle);
    	configItems.add(entityConfig);

    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("场景描述");
    	entityConfig.setValue(eidesc);
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("预计恢复时间");
    	entityConfig.setValue(time);
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("场景应急处置步骤");
    	entityConfig.setValue(stepPdid);
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("是否已演练");
    	entityConfig.setValue("否");
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("定义场景流程ID");
    	entityConfig.setValue(bean.getLogInfo().getPrid().toString());
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("场景类型");
    	entityConfig.setValue("1");//0:单一场景  1：组合场景
    	configItems.add(entityConfig);
    	
    	eiTB.setConfigItems(configItems);
    	Integer parEiid = flowSetBL.createEntityItem(eiTB);
    	
    	//封装资产基本信息
		SOC0118TB par_entityItem = soc0118BL.getEntityItemTBInstance();
		par_entityItem.setEiid(parEiid);
		par_entityItem.setEid("CM60000000");
		par_entityItem.setEismallversion(0);
		par_entityItem.setEiversion(1);
		par_entityItem.setEsyscoding(eiTB.getEsyscoding());
		
		//封装资产基本信息
		SOC0118TB cld_entityItem = soc0118BL.getEntityItemTBInstance();
		if(null!=itemList&&itemList.size()>0){
			for (ProcessInfoEntityInfo piei : itemList) {
				Integer clEiid = piei.getEiid();
				cld_entityItem.setEiid(clEiid);
				SOC0118Info info = soc0118BL.searchEntityItemByKey(clEiid);
				cld_entityItem.setEid(info.getEid());
				cld_entityItem.setEismallversion(info.getEismallversion());
				cld_entityItem.setEiversion(info.getEiversion());
				cld_entityItem.setEsyscoding(info.getEsyscoding());
				insertentityItemRelation(par_entityItem, cld_entityItem, "CI600000001005");
				
			}
		}
		
    	// 更新流程定义状态为启用-场景流程
		IG480Info ig480pdInfo = ig480BL.searchIG480ByPK(stepPdid);
		IG480TB ig480pdTB = (IG480TB) SerializationUtils.clone(ig480pdInfo);
		ig480pdTB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//a为启用
		ig480BL.updateIG480(ig480pdTB);
    	
        log.debug("========关闭节点前处理将组合场景流程定义登记为资产处理结束========");
    }
    
    
    /**
	 * 创建资产关联更新
	 * 
	 * @param par_entityItem 父资产
	 * @param cld_entityItem 子资产
	 * @param configItem 当前配置项信息
	 * @param cid 当前配置项定义ID
	 * @throws BLException11
	 */
	private void insertentityItemRelation(SOC0118Info par_entityItem, 
			SOC0118Info cld_entityItem, String cid) throws BLException{
		
		SOC0119TB entityItemRelation = this.soc0119BL.getEntityItemRelationTBInstance();
		//资产关联关系父资产
		entityItemRelation.setPareiid(par_entityItem.getEiid());
		entityItemRelation.setPareid(par_entityItem.getEid());
		entityItemRelation.setParsmallversion(par_entityItem.getEismallversion());
		entityItemRelation.setParversion(par_entityItem.getEiversion());
		
		//资产关联关系子资产
		entityItemRelation.setCldeiid(cld_entityItem.getEiid());
		entityItemRelation.setCldeid(cld_entityItem.getEid());
		entityItemRelation.setCldsmallversion(cld_entityItem.getEismallversion());
		entityItemRelation.setCldversion(cld_entityItem.getEiversion());
		
		//资产关联关系时间
		entityItemRelation.setEirupdtime(IGStringUtils.getCurrentDateTime());
		//设置状态为C，关系管理中不可删除
		entityItemRelation.setEirstatus("C");
		
		//双向
		String relationcode = par_entityItem.getEsyscoding().substring(3, 6)+"-"+cld_entityItem.getEsyscoding().substring(3, 6);	
		boolean flag = true ;
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		condimpl.setBusinesscode_like(relationcode);
		List<CodeDetail> cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		if ( cd.size()==1){
			flag = false;
			entityItemRelation.setEirrelation(cd.get(0).getCid());
			entityItemRelation.setEirrelationcode(cd.get(0).getBusinesscode());
		}
		if(flag){
			condimpl.setBusinesscode_like(cld_entityItem.getEsyscoding().substring(3, 6) + "-" + par_entityItem.getEsyscoding().substring(3, 6));
			cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if ( cd.size()!=1){
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
						"IGCO10000.E017");
			}else{
				entityItemRelation.setEirrelation(cd.get(0).getCid());
				entityItemRelation.setEirrelationcode(cd.get(0).getBusinesscode());
				flag = false;
			}
		}
		if (flag){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E017");
		}
		
		this.soc0119BL.registEntityItemRelation(entityItemRelation);
	}

    /**
	 * 通过esyscoding获取eilabel
	 * @param dto
	 * @return Map<String, Object>
	 * @throws BLException
	 */
    private String getEiLabel(String esyscoding) throws BLException {

    	String eiLabel = "";
    	SOC0117SearchCondImpl soc0117Cond = new SOC0117SearchCondImpl();
    	soc0117Cond.setEsyscoding(esyscoding);
    	List<SOC0117Info> socInfoList= soc0117BL.searchEntity(soc0117Cond);
    	//（CJ）
    	String elabel = socInfoList.get(0).getElabel();
    	//elabel长度（CJ-20150302）
    	//int elabelLen = elabel.length();
		SOC0118SearchCondImpl soc0118Cond = new SOC0118SearchCondImpl();
		soc0118Cond.setEilabel_like(elabel);
		List<SOC0118Info> entitys = soc0118BL.searchEntityItem(soc0118Cond);
		String maxNum;
		if(entitys.size()>0){
			//20150301
			String numLabel = entitys.get(entitys.size()-1).getEilabel().split("-")[1];
			numLabel = numLabel.substring(6);
			Integer max = Integer.valueOf(numLabel)+1;
			
			maxNum ="00".substring(max.toString().length())+max.toString();
		}else{
			maxNum = "01";
		}
		
		eiLabel = elabel+"-"+(DateUtils.getCurrentYear()+DateUtils.getCurrentMonth())+maxNum;
		
    	return eiLabel;
    }
    

}
