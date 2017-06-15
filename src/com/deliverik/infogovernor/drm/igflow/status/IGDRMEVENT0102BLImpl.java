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
import com.deliverik.framework.igflow.parameter.EntityItemConfigValue;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG481BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG481TB;
import com.deliverik.framework.workflow.prd.model.entity.IG699TB;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.infogovernor.drm.util.SenceType;
/**
 * <p>
 * �����޶�-�رսڵ�ǰ�����������̶���Ǽ�Ϊ�ʲ�����
 * 
 * </p>
 */
public class IGDRMEVENT0102BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0101BLImpl.class);
    
    private FlowSearchBL flowSearchBL;
    
    private FlowSetBL flowSetBL;

    private WorkFlowDefinitionBL workFlowDefinitionBL;
    
    protected IG500BL ig500BL;
    
    private SOC0118BL soc0118BL;
    
    /** �ʲ���ϵ��Ϣ����BL */
	protected SOC0119BL soc0119BL;
	
    protected CodeDetailBL codeDetailBL;
    
    protected IG481BL ig481BL;
	/** �����鶨�幦��BL */
	protected IG480BL ig480BL;
	
    /**
	 * @param ig480bl the �����鶨�幦��BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}
	/**
	 * @param ig481bl the ig481BL to set
	 */
	public void setIg481BL(IG481BL ig481bl) {
		ig481BL = ig481bl;
	}
    /**
	 * @param soc0118bl the soc0118BL to set
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * @param flowSearchBL the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * @param soc0119bl the soc0119BL to set
	 */
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}

	/**
	 * codeDetailBL   �趨
	 * @param codeDetailBL codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	public void setIg500BL(IG500BL ig500BL) {
   		this.ig500BL = ig500BL;
   	}
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
	/**
	 * �����޶�-�رսڵ�ǰ�����������̶���Ǽ�Ϊ�ʲ�����
	 * @param dto
	 * @return Map<String, Object>
	 * @throws BLException
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	log.debug("========�رսڵ�ǰ�����������̶���Ǽ�Ϊ�ʲ�����ʼ========");
		//ԭ�ʲ�ID
		String eiid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "ԭ�ʲ�ID");
    	String oldpdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "ԭ����Ӧ�����ò���");
		
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		String sceneType = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		String sceneClassify = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		//�����ʲ�����
		SOC0118Info soc0118Info =  soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
		SOC0118TB soc0118tb = (SOC0118TB) SerializationUtils.clone(soc0118Info);
		soc0118tb.setEiname(prtitle);
		soc0118BL.updateEntityItem(soc0118tb);
    	String eidesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
    	String time = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "Ԥ�ƻָ�ʱ��");
    	String stepPdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����Ӧ�����ò���");
    	//��ȡ��ǰ�����������̵Ķ��Ӧ����Դ
    	List<ProcessInfoEntityInfo> itemList = flowSearchBL.searchProcessEntityItem(bean.getLogInfo().getPrid(), "Ӧ����Դ");
    	
    	List<EntityItemConfigValueInfo> configItems = new ArrayList<EntityItemConfigValueInfo>();
    	//soc0107->
    	EntityItemConfigValue entityConfig = null;
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setEiid(Integer.parseInt(eiid));
    	entityConfig.setName("��������");
    	entityConfig.setValue(prtitle);
    	configItems.add(entityConfig);

    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setEiid(Integer.parseInt(eiid));
    	entityConfig.setName("��������");
    	entityConfig.setValue(eidesc);
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setEiid(Integer.parseInt(eiid));
    	entityConfig.setName("Ԥ�ƻָ�ʱ��");
    	entityConfig.setValue(time);
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setEiid(Integer.parseInt(eiid));
    	entityConfig.setName("����Ӧ�����ò���");
    	entityConfig.setValue(stepPdid);
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setEiid(Integer.parseInt(eiid));
    	entityConfig.setName("�Ƿ�������");
    	entityConfig.setValue("��");
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setEiid(Integer.parseInt(eiid));
    	entityConfig.setName("���峡������ID");
    	entityConfig.setValue(bean.getLogInfo().getPrid().toString());
    	configItems.add(entityConfig);
    	
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setEiid(Integer.parseInt(eiid));
    	entityConfig.setName("��������");
    	if(StringUtils.isNotEmpty(sceneType)){
    		if("��һ����".equals(sceneType)){
    			entityConfig.setValue(SenceType.SINGLE.getCode());//0:��һ����  1����ϳ���
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
    		}else{
    			//��ϳ���
    			entityConfig.setValue(SenceType.COMBINATION.getCode());//0:��һ����  1����ϳ���
    			
    		}
    	}
    	configItems.add(entityConfig);
    	//��������
    	entityConfig = new EntityItemConfigValue();
    	entityConfig.setEiid(Integer.parseInt(eiid));
    	entityConfig.setName("��������");
    	if(StringUtils.isNotEmpty(sceneClassify)){
    		if("Ӧ������".equals(sceneClassify)){
    			entityConfig.setValue("0");
    		}else{
    			entityConfig.setValue("1");
    		}
    	}
    	configItems.add(entityConfig);
//    	entityConfig = new EntityItemConfigValue();
//    	entityConfig.setEiid(Integer.parseInt(eiid));
//    	entityConfig.setName("�Ƿ�������");
//    	entityConfig.setValue("��");
//    	configItems.add(entityConfig);
    	
    	EntityItemInfo eiInfo = flowSearchBL.searchEntityItem(Integer.parseInt(eiid));
    	//����󳡾��ʲ���eiversion
    	Integer newEiversion = eiInfo.getEiversion()+1;
    	
    	//TRUE - >update ����
    	flowSetBL.setEntityItemConfigValue(configItems, true);
    	//�¼��߼� 2015��6��11��14:55:12 zyl
			SOC0119SearchCondImpl soc0119Cond = new SOC0119SearchCondImpl();
			soc0119Cond.setEirrelationcode("050-060");
			soc0119Cond.setDeleteflag("0");
			soc0119Cond.setCldeiid(Integer.parseInt(eiid));
			List<SOC0119Info> soc0119List = soc0119BL.searchEntityItemRelation(soc0119Cond);
			for(SOC0119Info info : soc0119List){
				SOC0119TB tb = (SOC0119TB) SerializationUtils.clone(info);
				tb.setCldversion(newEiversion);
				tb.setCldsmallversion(0);
				soc0119BL.updateEntityItemRelation(tb);
			}
    	//��װ�ʲ�������Ϣ
		SOC0118TB par_entityItem = soc0118BL.getEntityItemTBInstance();
		par_entityItem.setEiid(Integer.parseInt(eiid));
		par_entityItem.setEid("CM60000000");
		par_entityItem.setEismallversion(0);
		par_entityItem.setEiversion(newEiversion);
		par_entityItem.setEsyscoding(eiInfo.getEsyscoding());
		
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
		    	
		    	// �������̶���״̬Ϊͣ��-��������(ZYL�޸ģ���ϳ����й����������Զ����棬Ҫ���ϰ汾��������ͣ��)
		    	//IG380Info oldpdInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(oldpdid);
		    	//IG380TB oldPdTB = (IG380TB) SerializationUtils.clone(oldpdInfo);
		    	//oldPdTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);
		    	//workFlowDefinitionBL.updateProcessDefinition(oldPdTB);
		    	
		
		    	//����481����ϳ����ĵ�һ������ϵ��fingerprint�ֶ� Ϊ1-> �õ�һ��������������
		    	IG481SearchCondImpl ig481cond = new IG481SearchCondImpl();
		    	ig481cond.setPdid_like(oldpdid.substring(0, 5));
		    	List<IG481Info> ig481List = ig481BL.searchIG481(ig481cond);
		    	for(IG481Info info:ig481List){
		    		IG481TB tb = (IG481TB)SerializationUtils.clone(info);
		    		tb.setFingerPrint(stepPdid);//stepPdid:���³������̶���id
		    		ig481BL.updateIG481(tb);
		    	}
    
    		}else{
	    		//��ϳ��������
	    		// �������̶���״̬Ϊ����-��������
				IG480Info ig480pdInfo = ig480BL.searchIG480ByPK(stepPdid);
				IG480TB ig480pdTB = (IG480TB) SerializationUtils.clone(ig480pdInfo);
				ig480pdTB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//aΪ����
				ig480BL.updateIG480(ig480pdTB);
				// �������̶���״̬Ϊͣ��-��������
				IG480Info oldIg480pdInfo = ig480BL.searchIG480ByPK(oldpdid);
				IG480TB oldIg480pdTB = (IG480TB) SerializationUtils.clone(oldIg480pdInfo);
				oldIg480pdTB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);//iΪͣ��
				ig480BL.updateIG480(oldIg480pdTB);
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
			    	required = "1";
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
}
