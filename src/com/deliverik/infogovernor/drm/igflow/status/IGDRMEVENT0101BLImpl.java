/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
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
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
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
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG699TB;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.infogovernor.drm.igflow.button.IGDRMBTN0101BLImpl;
import com.deliverik.infogovernor.drm.util.SenceType;
import com.deliverik.infogovernor.util.DateUtils;
/**
 * <p>
 * 场场景定义-关闭节点前处理将场景流程定义登记为资产处理
 * 
 * </p>
 */
public class IGDRMEVENT0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0101BLImpl.class);
    
    private FlowSearchBL flowSearchBL;
    
    private FlowSetBL flowSetBL;

    private SysManageBL sysManageBL;
    
    private SOC0118BL soc0118BL;
    
    private WorkFlowDefinitionBL workFlowDefinitionBL;
    
    protected IG500BL ig500BL;
    
    private SOC0117BL soc0117BL;
    
    /** 资产关系信息管理BL */
	protected SOC0119BL soc0119BL;
	
	/** 资产配置项定义信息管理BL */
	protected SOC0109BL soc0109BL;
	
	protected CodeDetailBL codeDetailBL;
	/** 流程组定义功能BL */
	protected IG480BL ig480BL;
	
    /**
	 * @param ig480bl the 流程组定义功能BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}

	/**
	 * codeDetailBL   设定
	 * @param codeDetailBL codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	public void setIg500BL(IG500BL ig500BL) {
   		this.ig500BL = ig500BL;
   	}
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}
	/**
	 * 资产关系信息管理BL设定
	 * 
	 * @param soc0119bl 资产关系信息管理BL
	 */
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}
	/**
	 * 资产配置项定义信息管理BL设定
	 * 
	 * @param soc0109bl 资产配置项定义信息管理BL
	 */
	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
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
    	//单一场景定义流程实例信息
		//IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		//场景名称 scene
		//String prtitle = ig500Info.getPrtitle();
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景名称");
    	String eidesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景描述");
    	String time = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "预计恢复时间");
    	String stepPdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景应急处置步骤");
    	String sceneType = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景类型");
    	String sceneClassify = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景分类");
    	List<ProcessInfoEntityInfo> itemList = flowSearchBL.searchProcessEntityItem(bean.getLogInfo().getPrid(), "应急资源");
    	if(StringUtils.isNotEmpty(sceneType)){
    		if("单一场景".equals(sceneType)){
    			//设置默认状态表单显示权限
    			//处置步骤流程状态节点List
    			List<ProcessStatusInfo>  statusList = flowSearchBL.searchProcessStatusList(stepPdid);
    			//遍历状态节点
    			for(int i=0;i<statusList.size();i++){
    				if("C".equals(statusList.get(i).getPsdcode())){
    					continue;//关闭节点
    				}
    				if("Z".equals(statusList.get(i).getPsdcode())){
    					continue;//发起节点
    				}
    				//当前状态节点psdid
    				String curPsdid = statusList.get(i).getPsdid();
    				setFormAccessDef(stepPdid, curPsdid);
    			}
    		}
    		}
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
    	if(StringUtils.isNotEmpty(sceneType)){
    		if("单一场景".equals(sceneType)){
    			entityConfig.setValue(SenceType.SINGLE.getCode());//0:单一场景  1：组合场景
    		}else{
    			//复合场景
    			entityConfig.setValue(SenceType.COMBINATION.getCode());//0:单一场景  1：组合场景
    			
    		}
    	}
    	configItems.add(entityConfig);
    	//场景分类
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("场景分类");
    	if(StringUtils.isNotEmpty(sceneClassify)){
    		if("应急场景".equals(sceneClassify)){
    			entityConfig.setValue("0");
    		}else{
    			entityConfig.setValue("1");
    		}
    	}
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
		if(StringUtils.isNotEmpty(sceneType)){
    		if("单一场景".equals(sceneType)){
    			// 更新流程定义状态为启用-场景流程
    			IG380Info pdInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(stepPdid);
    			IG380TB pdTB = (IG380TB) SerializationUtils.clone(pdInfo);
    			pdTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
    			workFlowDefinitionBL.updateProcessDefinition(pdTB);
    		}else{
    			// 更新流程定义状态为启用-场景流程
    			IG480Info ig480pdInfo = ig480BL.searchIG480ByPK(stepPdid);
    			IG480TB ig480pdTB = (IG480TB) SerializationUtils.clone(ig480pdInfo);
    			ig480pdTB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//a为启用
    			ig480BL.updateIG480(ig480pdTB);
    		}
    		}
    	
        log.debug("========关闭节点前处理将场景前流程定义登记为资产处理结束========");
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
		List socInfoList = this.soc0117BL.searchEntity(soc0117Cond);

		String elabel = ((SOC0117Info) socInfoList.get(0)).getElabel() + "-" + DateUtils.getCurrentYear() + DateUtils.getCurrentMonth();

		SOC0118SearchCondImpl soc0118Cond = new SOC0118SearchCondImpl();
		soc0118Cond.setEilabel_like(elabel);
		List entitys = this.soc0118BL.searchEntityItem(soc0118Cond);
		String maxNum;
		if (entitys.size() > 0) {
			Integer max = Integer.valueOf(Integer.valueOf(((SOC0118Info) entitys.get(entitys.size() - 1)).getEilabel().split("-")[1].substring(6)).intValue() + 1);

			maxNum = StringUtils.leftPad(max.toString(), 3, "0");
		} else {
			maxNum = "001";
		}

		eiLabel = elabel + maxNum;
		while (true) {
			soc0118Cond = new SOC0118SearchCondImpl();
			soc0118Cond.setEilabel(eiLabel);
			entitys = this.soc0118BL.searchEntityItem(soc0118Cond);
			if (entitys.size() <= 0)
				break;
			Integer max = Integer.valueOf(Integer.valueOf(((SOC0118Info) entitys.get(entitys.size() - 1)).getEilabel().split("-")[1].substring(6)).intValue() + 1);
			maxNum = StringUtils.leftPad(max.toString(), 3, "0");
			eiLabel = elabel + maxNum;
		}

		return eiLabel;
    }
    
	/**
	 * 设定默认的表单
	 * @param pidid
	 * @param psdid
	 * @param access //1、不可见；2、只读；3、可写
	 * @param required//0、不必填；1、必填
	 * @return
	 * @throws BLException
	 */
	private void setFormAccessDef(String pdid, String psdid) throws BLException {
		log.info("==========设置状态表单缺省权限信息开始=============");
        IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
    	ig007Cond.setPdid(pdid);
    	List<IG007Info> ig007List = workFlowDefinitionBL.searchProcessInfoDef(ig007Cond);
    	//1、不可见；2、只读；3、可写
		//0、不必填；1、必填
    	String access = "2";
    	
		for (int i = 0; i < ig007List.size(); i++) {
			//过滤掉跃迁条件的表单
			if(!ig007List.get(i).getPidname().equals("跃迁条件")){
				//表单pidid
				String pidid = ig007List.get(i).getPidid();
				//状态表单是否可写:1:不可写；0：可写（1:有默认值；0：没有默认值）
				String isuse = ig007List.get(i).getPiduse();
				String required = "0";
				if("0".equals(isuse)){
					access = "3";
					if("处置说明".equals(ig007List.get(i).getPidname())){
						required = "0";
					}else{
						required = "1";
					}
				}
				// 设定默认表单-表单权限
				IG699TB descInfoTB = new IG699TB();
				descInfoTB.setPdvid(workFlowDefinitionBL.getParticipantDefaultVariablePK(psdid));
				descInfoTB.setPidid(pidid);//流程表单定义ID
				descInfoTB.setPidaccess(access);//1、不可见；2、只读；3、可写
				descInfoTB.setPidrequired(required);//0、不必填；1、必填
				descInfoTB.setPsdid(psdid);//流程状态定义ID
				workFlowDefinitionBL.registParticipantDefaultVariable(descInfoTB);
			}
		}
		
		log.info("==========设置状态表单缺省权限信息结束=============");
	}
	
	/**
	 * 通过类路径来取工程路径
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAbsolutePathByClass(){
		String webPath = this.getClass().getResource("/").getPath().replaceAll("^\\/", "");
		webPath = webPath.replaceAll("[\\\\\\/]WEB-INF[\\\\\\/]classes[\\\\\\/]?", "/");
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		webPath = webPath.replaceAll("%20", " ");
		if (webPath.matches("^[a-zA-Z]:.*?$")) {

		} else {
			webPath = "/" + webPath;
		}
		webPath += "/";
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		return webPath;
	}
	public static void main(String[] args) {
		IGDRMBTN0101BLImpl a = new IGDRMBTN0101BLImpl();
		System.out.println(a.getAbsolutePathByClass());
	}
}
