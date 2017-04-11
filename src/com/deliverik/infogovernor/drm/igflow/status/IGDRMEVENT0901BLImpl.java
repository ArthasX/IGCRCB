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
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyRelationBL;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;
import com.deliverik.infogovernor.util.DateUtils;

/**
 * Ӧ��ָ������-Ӧ�����ýڵ�ǰ����
 * 
 * ������س�������
 * 
 * @author �Ž�
 *
 * 2015-3-11 ����10:24:34
 */
public class IGDRMEVENT0901BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0901BLImpl.class);
    
    private FlowSearchBL flowSearchBL;
    
    private FlowOptBL flowOptBL;

    private FlowSetBL flowSetBL;

    
    private EmergencyRelationBL emergencyRelationBL;
    
    private SigninBL signinBL;
    
    
    private WorkFlowOperationBL workFlowOperationBL;
    
    public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
    
	public void setEmergencyRelationBL(EmergencyRelationBL emergencyRelationBL) {
		this.emergencyRelationBL = emergencyRelationBL;
	}

	/**
	 * signinBL   �趨
	 * @param signinBL signinBL
	 */
	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}


	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
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

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
	
	/**
	 * 
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	log.debug("========���𳡾��еļ����ָ����迪ʼ========");
    	
    	//��ȡ�����ʲ�eiid
    	Integer eiid = 0;
    	// ��ȡ��������Ϣ
    	ProcessRecordInfo prInfo = this.flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null).get(0);
    	
    	//��ѯ�����ʲ�
    	List<ProcessInfoEntityInfo> eiidList = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.SCENE_ITEM_NAME);
    	
    	//�����ָ�����id
    	Integer cldPrid = null;
    	
    	if(eiidList!=null&&eiidList.size()>0){
    		
    		eiid = eiidList.get(0).getEiid();
    		
			EmergencyRelationTB erTb = new EmergencyRelationTB();
            erTb.setParprid(prInfo.getPrid());
            
			//��ȡ�����е����̶���id
        	String pdid = flowSearchBL.searchEntityItemConfigValue(eiid, IGDRMCONSTANTS.PROCESS_DEF_ID);
        	if(StringUtils.isEmpty(pdid)){
    	         throw new BLException("IGEXTERNAL.E001","δ��ѯ�������й���������ģ��");
        	}
        	// ��ȡӦ����������id
        	String drillPrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.PRACTISE_PRID_LABEL);    
    	    // �������ָ�������Ϣ
            WorkFlowLog logInfo = new WorkFlowLog();
            logInfo.setAuthuserid(null);
            logInfo.setExecutorid(bean.getLogInfo().getExecutorid());
            logInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
            ProcessRecord processRecord = new ProcessRecord(logInfo);
			// ��ȡ��������Ϣ
			if (StringUtils.isEmpty(drillPrid)) {
				processRecord.setTitle(prInfo.getPrtitle() + "-" + "Ӧ���ָ�");
			} else {
				processRecord.setTitle(prInfo.getPrtitle() + "-" + "�����ָ�");
			}
            processRecord.setDescription(prInfo.getPrdesc());
            processRecord.setDefid(pdid);
            processRecord.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
            //������(�����ָ�����)����
			cldPrid = this.flowOptBL.saveProcessAction(processRecord);
			erTb.setCldType(IGDRMCONSTANTS.DIRECT_RELATE_SCENE);
			
			//*********************��ʼ����������**************************

			
			// ����������������ָ���������ʼ������ǩ����Ϣ
			// if (StringUtils.isEmpty(drillPrid)) {
				signinBL.updateSigninForRestoreByDirectPrid(bean.getLogInfo().getPrid(), cldPrid);
			// }
            
            //*********************�����ʼ��������ظ���Ա*********************
            //ר��Ԥ��
	        String emcproeiname= this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.PLAN_NAME).get(0).getEiname();
	        //��������
	        String sceneeiname = this.flowSearchBL.searchProcessEntityItem(prInfo.getPrid(), IGDRMCONSTANTS.SCENE_ITEM_NAME).get(0).getEiname();
	        //�����ʼ�
	        workFlowOperationBL.send(prInfo.getPrid(), emcproeiname, sceneeiname, pdid, IGStringUtils.getCurrentDateTime());
	        
	        
            //****************����Ӧ��ָ��(�������б�)*********************
            
            //����ָ�������е� <��������prid>��ֵΪ�����ָ������prid
			WorkFlowLog wfg = new WorkFlowLog();
			wfg.setPrid(prInfo.getPrid());
			wfg.setExecutorid(bean.getCrtuserid());
			PublicProcessInfoValue ppiv = new PublicProcessInfoValue(wfg);
			
			ppiv.setFormname(IGDRMCONSTANTS.DIRECT_FROM_NAME_SCENE_PRID);
			ppiv.setFormvalue(""+cldPrid);
			flowSetBL.setPublicProcessInfoValue(ppiv);
			
			
			//***************����Ӧ��ָ�����̺ͼ����ָ����̹�ϵ**********************
            erTb.setCldprid(cldPrid);
            erTb.setRelatetype(IGDRMCONSTANTS.DIRECT_RELATE_SCENE);
            erTb.setPrrinstime(IGStringUtils.getCurrentDateTime());
            emergencyRelationBL.registEmergencyRelationInfo(erTb);
			// ***************�����������̺ͼ����ָ����̹�ϵ**********************
			// ��ȡӦ����������id
			if (StringUtils.isNotEmpty(drillPrid)) {
				erTb = new EmergencyRelationTB();
				erTb.setCldprid(cldPrid);
				erTb.setParprid(Integer.valueOf(drillPrid));
				erTb.setCldType("1");
				erTb.setPrrinstime(DateUtils.getCurrentTime());
				erTb.setRelatetype(IGDRMCONSTANTS.DRILL_RELATE_SCENE);
				emergencyRelationBL.registEmergencyRelationInfo(erTb);
				
				//���ô���������ָ��������ͬ������ (Ӧ��/����)
				Map<String, Object> map = new HashMap<String, Object>();
	 			IG500BL i500BL = (IG500BL)WebApplicationSupport.getBean("ig500BL");
	 			
	 			map.put("prurgency", i500BL.searchIG500InfoByKey(prInfo.getPrid()).getPrurgency());
	 			flowSetBL.updateProcessRecord(cldPrid, map);
			}
			this.flowOptBL.transitionProcess(cldPrid, bean.getLogInfo().getExecutorid(), "�ύ", IGStringUtils.getCurrentDateTime());
    	}
    	

        log.debug("========���𳡾��еļ����ָ����迪ʼ========");
    	
    	
    }
}
