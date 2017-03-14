/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyRelationBL;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**
 * Ӧ����������-����ʵʩǰ����
 * 
 * ���������ƻ���ͼƻ������ �޸�״̬Ϊ������
 * 
 * @author zyl
 *
 * 2015��3��16��13:34:06
 */
public class IGDRMEVENT0704BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0704BLImpl.class);
    
    /**����API*/
    private FlowSearchBL flowSearchBL;
    
    private FlowOptBL flowOptBL;
    
    private FlowSetBL flowSetBL;
    
    private EmergencyRelationBL emergencyRelationBL;
    

	/** ǩ����BL */
	private SigninBL signinBL;

	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}
	/**
	 * flowOptBL   �趨
	 * @param flowOptBL flowOptBL
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	/**
	 * flowSetBL   �趨
	 * @param FlowSetBL flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	/**
	 * @param ����API the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	public void setEmergencyRelationBL(EmergencyRelationBL emergencyRelationBL) {
		this.emergencyRelationBL = emergencyRelationBL;
	}
	
    /**
     * �����ƻ��������
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
	
	/**
	 * �����ƻ�����ǰ����
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	log.debug("========����ʵ��ǰ����������̿�ʼ========");
		// ��ȡ��������Ϣ
    	ProcessRecordInfo prInfo = this.flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null).get(0);
		//��ѯ�跢�������
		String relateVal = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),IGDRMCONSTANTS.DRILL_RELATE_PROCESS_FORM_NAME);
		
		WorkFlowLog logInfo = new WorkFlowLog();
        logInfo.setAuthuserid(null);
        logInfo.setExecutorid(bean.getLogInfo().getExecutorid());
        logInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
        ProcessRecord processRecord = new ProcessRecord(logInfo);
        processRecord.setTitle(prInfo.getPrtitle());
        processRecord.setDescription(prInfo.getPrdesc());
        
        Integer prid = null;
        
        String relatetype = "";
        
		//Ӧ��ָ��
		if(IGDRMCONSTANTS.DRILL_RELATE_PROCESS_FORM_DIRECT.equals(relateVal)){
		
			Map<String,String> formvalue = new HashMap<String,String>();
			processRecord.setTitle(prInfo.getPrtitle() + "-" + "����ָ��");
			formvalue.put(IGDRMCONSTANTS.PLAN_NAME, "N/A");
			formvalue.put(IGDRMCONSTANTS.SCENE_ITEM_NAME, "N/A");
			formvalue.put(IGDRMCONSTANTS.ITEM_SYSTEM_FORM_NAME, "N/A");
			formvalue.put(IGDRMCONSTANTS.DIRECT_PARTICIPANT_ADJUST_FORM_NAME, "tab");
			formvalue.put(IGDRMCONSTANTS.PRACTISE_PRID_LABEL,prInfo.getPrid().toString());
			formvalue.put("�¼�����", prInfo.getPrtitle() + "-" + "����ָ��");
			processRecord.setFormvalue(formvalue);
			//���̶���
			processRecord.setDefid(IGDRMCONSTANTS.DIRECT_PROCESS_DEF_ID);
			//��������
	        prid = this.flowOptBL.saveProcessAction(processRecord);
	        
	        //�������̱���ֵ
	        PublicProcessInfoValue ptInfo = new PublicProcessInfoValue(bean.getLogInfo());
	        ptInfo.setFormname(IGDRMCONSTANTS.DRILL_FROM_NAME_DIRECT_PRID);
	        ptInfo.setFormvalue(prid+"");
	        flowSetBL.setPublicProcessInfoValue(ptInfo);
	        
	        //*********************Ӧ��ָ������*********************
			//ר��Ԥ��
	        Integer emcproeiid = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.SPECIAL_PLAN_NAME).get(0).getEiid();
			//��������
	        Integer sceneeiiid = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.EMERGENCY_SCENE_NAME).get(0).getEiid();
			//ҵ��ϵͳ
			List<ProcessInfoEntityInfo> list = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.DRILL_SYSTEM_FORM_NAME);
			//��������-�ʲ�������ϵ
			flowSetBL.setProcessEntityRelation(prid, IGDRMCONSTANTS.PLAN_NAME, emcproeiid, null);
			flowSetBL.setProcessEntityRelation(prid, IGDRMCONSTANTS.SCENE_ITEM_NAME, sceneeiiid, null);
			flowSetBL.setProcessEntityItem(prid,IGDRMCONSTANTS.ITEM_SYSTEM_FORM_NAME,list);
			//���ñ���ϵ
			flowSetBL.setProcessSceneParticipant(prInfo.getPrid(), IGDRMCONSTANTS.DRILL_PARTICIPANT_ADJUST_FORM_NAME, prid, IGDRMCONSTANTS.DIRECT_PARTICIPANT_ADJUST_FORM_NAME, IGDRMCONSTANTS.DIRECT_PROCESS_DEF_ID);

			// ����ָ����������Ϊ��������
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("prurgency", "1");
			flowSetBL.updateProcessRecord(prid, map);
			
			//-----------------��ʼ��ǩ����Ϣ----
			signinBL.updateSigninForEcp(prInfo.getPrid(), prid);

			relatetype = IGDRMCONSTANTS.DRILL_RELATE_DIRECT;
		}
		//����
		else if(IGDRMCONSTANTS.DRILL_RELATE_PROCESS_FORM_SCENE.equals(relateVal)){
			
			processRecord.setTitle(prInfo.getPrtitle() + "-" + "��������");
            processRecord.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
            
			//��ѯ�����ʲ�
	    	List<ProcessInfoEntityInfo> eiidList = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.EMERGENCY_SCENE_NAME);
			//��ȡ�����е����̶���id
        	String pdid = flowSearchBL.searchEntityItemConfigValue(eiidList.get(0).getEiid(), IGDRMCONSTANTS.PROCESS_DEF_ID);
        	if(StringUtils.isEmpty(pdid)){
 	            throw new BLException("IGEXTERNAL.E001","δ��ѯ�������й���������ģ��");
        	}	
        	//���̶���
        	processRecord.setDefid(pdid);
    		//��������
            prid = this.flowOptBL.initProcessAction(processRecord);
            
            //�������̱���ֵ
	        PublicProcessInfoValue ptInfo = new PublicProcessInfoValue(bean.getLogInfo());
	        ptInfo.setFormname(IGDRMCONSTANTS.DRILL_FROM_NAME_SCENE_PRID);
	        ptInfo.setFormvalue(prid+"");
	        flowSetBL.setPublicProcessInfoValue(ptInfo);
			
	        relatetype = IGDRMCONSTANTS.DRILL_RELATE_SCENE;
	        
			// -----------------��ʼ��ǩ����Ϣ----
			signinBL.updateSigninForRestore(prInfo.getPrid(), prid);
			
		}
		//����������ϵ
		if(prid != null){
			EmergencyRelationTB erTb = new EmergencyRelationTB();
			erTb.setParprid(prInfo.getPrid());
			erTb.setCldprid(prid);
			erTb.setCldType("1");
			erTb.setRelatetype(relatetype);
			erTb.setPrrinstime(IGStringUtils.getCurrentDateTime());
	        emergencyRelationBL.registEmergencyRelationInfo(erTb);
		}
		
		log.debug("========����ʵ��ǰ����������̽���========");
		//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
		String desc = IGDRMEmergencyTools.getDesc(bean.getLogInfo().getPrid());
		IGDRMEmergencyTools.changeSystemState(prid, "ҵ��ϵͳ", "2",desc);
    }
}
