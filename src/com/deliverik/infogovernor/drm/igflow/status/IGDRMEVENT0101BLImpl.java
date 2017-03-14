/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����������-�رսڵ�ǰ�����������̶���Ǽ�Ϊ�ʲ�����
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
    
    /** �ʲ���ϵ��Ϣ����BL */
	protected SOC0119BL soc0119BL;
	
	/** �ʲ����������Ϣ����BL */
	protected SOC0109BL soc0109BL;
	
	protected CodeDetailBL codeDetailBL;
	/** �����鶨�幦��BL */
	protected IG480BL ig480BL;
	
    /**
	 * @param ig480bl the �����鶨�幦��BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}

	/**
	 * codeDetailBL   �趨
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
	 * �ʲ���ϵ��Ϣ����BL�趨
	 * 
	 * @param soc0119bl �ʲ���ϵ��Ϣ����BL
	 */
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}
	/**
	 * �ʲ����������Ϣ����BL�趨
	 * 
	 * @param soc0109bl �ʲ����������Ϣ����BL
	 */
	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}
	
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }

	/**
	 * ��������-�رսڵ�ǰ�����������̶���Ǽ�Ϊ�ʲ�����
	 * @param dto
	 * @return Map<String, Object>
	 * @throws BLException
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	log.debug("========�رսڵ�ǰ�����������̶���Ǽ�Ϊ�ʲ�����ʼ========");
    	//��һ������������ʵ����Ϣ
		//IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		//�������� scene
		//String prtitle = ig500Info.getPrtitle();
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
    	String eidesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
    	String time = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "Ԥ�ƻָ�ʱ��");
    	String stepPdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����Ӧ�����ò���");
    	String sceneType = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
    	String sceneClassify = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
    	List<ProcessInfoEntityInfo> itemList = flowSearchBL.searchProcessEntityItem(bean.getLogInfo().getPrid(), "Ӧ����Դ");
    	if(StringUtils.isNotEmpty(sceneType)){
    		if("��һ����".equals(sceneType)){
    			//����Ĭ��״̬����ʾȨ��
    			//���ò�������״̬�ڵ�List
    			List<ProcessStatusInfo>  statusList = flowSearchBL.searchProcessStatusList(stepPdid);
    			//����״̬�ڵ�
    			for(int i=0;i<statusList.size();i++){
    				if("C".equals(statusList.get(i).getPsdcode())){
    					continue;//�رսڵ�
    				}
    				if("Z".equals(statusList.get(i).getPsdcode())){
    					continue;//����ڵ�
    				}
    				//��ǰ״̬�ڵ�psdid
    				String curPsdid = statusList.get(i).getPsdid();
    				setFormAccessDef(stepPdid, curPsdid);
    			}
    		}
    		}
    	//soc0118->
    	//���̷��������ڻ���
    	String eiorgsyscoding = sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid();
    	String esyscoding = "999060";
    	EntityItem eiTB = new EntityItem();
    	eiTB.setEsyscoding(esyscoding);//999060
    	eiTB.setEiname(prtitle);//��������
    	eiTB.setEidesc(eidesc);//��������
    	//ͨ��soc0118����
    	eiTB.setEilabel(getEiLabel(esyscoding));
    	eiTB.setEiorgsyscoding(eiorgsyscoding);
    	eiTB.setEiuserid(bean.getCrtuserid());//
    	eiTB.setEiusername(sysManageBL.searchUserInfo(bean.getCrtuserid()).getUsername());//
    	List<EntityItemConfigValueInfo> configItems = new ArrayList<EntityItemConfigValueInfo>();
    	//soc0107->
    	EntityItemConfigValue entityConfig = null;
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("��������");
    	entityConfig.setValue(prtitle);
    	configItems.add(entityConfig);

    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("��������");
    	entityConfig.setValue(eidesc);
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("Ԥ�ƻָ�ʱ��");
    	entityConfig.setValue(time);
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("����Ӧ�����ò���");
    	entityConfig.setValue(stepPdid);
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("�Ƿ�������");
    	entityConfig.setValue("��");
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("���峡������ID");
    	entityConfig.setValue(bean.getLogInfo().getPrid().toString());
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("��������");
    	if(StringUtils.isNotEmpty(sceneType)){
    		if("��һ����".equals(sceneType)){
    			entityConfig.setValue(SenceType.SINGLE.getCode());//0:��һ����  1����ϳ���
    		}else{
    			//���ϳ���
    			entityConfig.setValue(SenceType.COMBINATION.getCode());//0:��һ����  1����ϳ���
    			
    		}
    	}
    	configItems.add(entityConfig);
    	//��������
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setName("��������");
    	if(StringUtils.isNotEmpty(sceneClassify)){
    		if("Ӧ������".equals(sceneClassify)){
    			entityConfig.setValue("0");
    		}else{
    			entityConfig.setValue("1");
    		}
    	}
    	configItems.add(entityConfig);
    	
    	eiTB.setConfigItems(configItems);
    	Integer parEiid = flowSetBL.createEntityItem(eiTB);
    	
    	//��װ�ʲ�������Ϣ
		SOC0118TB par_entityItem = soc0118BL.getEntityItemTBInstance();
		par_entityItem.setEiid(parEiid);
		par_entityItem.setEid("CM60000000");
		par_entityItem.setEismallversion(0);
		par_entityItem.setEiversion(1);
		par_entityItem.setEsyscoding(eiTB.getEsyscoding());
		
		//��װ�ʲ�������Ϣ
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
    		if("��һ����".equals(sceneType)){
    			// �������̶���״̬Ϊ����-��������
    			IG380Info pdInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(stepPdid);
    			IG380TB pdTB = (IG380TB) SerializationUtils.clone(pdInfo);
    			pdTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
    			workFlowDefinitionBL.updateProcessDefinition(pdTB);
    		}else{
    			// �������̶���״̬Ϊ����-��������
    			IG480Info ig480pdInfo = ig480BL.searchIG480ByPK(stepPdid);
    			IG480TB ig480pdTB = (IG480TB) SerializationUtils.clone(ig480pdInfo);
    			ig480pdTB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//aΪ����
    			ig480BL.updateIG480(ig480pdTB);
    		}
    		}
    	
        log.debug("========�رսڵ�ǰ��������ǰ���̶���Ǽ�Ϊ�ʲ��������========");
    }
    
    
    /**
	 * �����ʲ���������
	 * 
	 * @param par_entityItem ���ʲ�
	 * @param cld_entityItem ���ʲ�
	 * @param configItem ��ǰ��������Ϣ
	 * @param cid ��ǰ�������ID
	 * @throws BLException11
	 */
	private void insertentityItemRelation(SOC0118Info par_entityItem, 
			SOC0118Info cld_entityItem, String cid) throws BLException{
		
		SOC0119TB entityItemRelation = this.soc0119BL.getEntityItemRelationTBInstance();
		//�ʲ�������ϵ���ʲ�
		entityItemRelation.setPareiid(par_entityItem.getEiid());
		entityItemRelation.setPareid(par_entityItem.getEid());
		entityItemRelation.setParsmallversion(par_entityItem.getEismallversion());
		entityItemRelation.setParversion(par_entityItem.getEiversion());
		
		//�ʲ�������ϵ���ʲ�
		entityItemRelation.setCldeiid(cld_entityItem.getEiid());
		entityItemRelation.setCldeid(cld_entityItem.getEid());
		entityItemRelation.setCldsmallversion(cld_entityItem.getEismallversion());
		entityItemRelation.setCldversion(cld_entityItem.getEiversion());
		
		//�ʲ�������ϵʱ��
		entityItemRelation.setEirupdtime(IGStringUtils.getCurrentDateTime());
		//����״̬ΪC����ϵ�����в���ɾ��
		entityItemRelation.setEirstatus("C");
		
		//˫��
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
	 * ͨ��esyscoding��ȡeilabel
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
	 * �趨Ĭ�ϵı�
	 * @param pidid
	 * @param psdid
	 * @param access //1�����ɼ���2��ֻ����3����д
	 * @param required//0�������1������
	 * @return
	 * @throws BLException
	 */
	private void setFormAccessDef(String pdid, String psdid) throws BLException {
		log.info("==========����״̬��ȱʡȨ����Ϣ��ʼ=============");
        IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
    	ig007Cond.setPdid(pdid);
    	List<IG007Info> ig007List = workFlowDefinitionBL.searchProcessInfoDef(ig007Cond);
    	//1�����ɼ���2��ֻ����3����д
		//0�������1������
    	String access = "2";
    	
		for (int i = 0; i < ig007List.size(); i++) {
			//���˵�ԾǨ�����ı�
			if(!ig007List.get(i).getPidname().equals("ԾǨ����")){
				//��pidid
				String pidid = ig007List.get(i).getPidid();
				//״̬���Ƿ��д:1:����д��0����д��1:��Ĭ��ֵ��0��û��Ĭ��ֵ��
				String isuse = ig007List.get(i).getPiduse();
				String required = "0";
				if("0".equals(isuse)){
					access = "3";
					if("����˵��".equals(ig007List.get(i).getPidname())){
						required = "0";
					}else{
						required = "1";
					}
				}
				// �趨Ĭ�ϱ�-��Ȩ��
				IG699TB descInfoTB = new IG699TB();
				descInfoTB.setPdvid(workFlowDefinitionBL.getParticipantDefaultVariablePK(psdid));
				descInfoTB.setPidid(pidid);//���̱�����ID
				descInfoTB.setPidaccess(access);//1�����ɼ���2��ֻ����3����д
				descInfoTB.setPidrequired(required);//0�������1������
				descInfoTB.setPsdid(psdid);//����״̬����ID
				workFlowDefinitionBL.registParticipantDefaultVariable(descInfoTB);
			}
		}
		
		log.info("==========����״̬��ȱʡȨ����Ϣ����=============");
	}
	
	/**
	 * ͨ����·����ȡ����·��
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
