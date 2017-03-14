/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyRelationBL;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCondImpl;

/**
 * Ӧ����������-�رսڵ�ǰ����
 * 
 * ���������ƻ���ͼƻ������ �޸�״̬Ϊ������
 * 
 * @author zyl
 *
 * 2015��3��16��13:34:06
 */
public class IGDRMEVENT0301BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0301BLImpl.class);
    
    /**����API*/
    private FlowSearchBL flowSearchBL;
    
    private FlowSetBL flowSetBL;
    
    private WorkFlowDefinitionBL workFlowDefinitionBL;
    
    private EmergencyRelationBL emergencyRelationBL;
    
    private IG898BL ig898BL;
    
    private UserRoleBL userRoleBL;
    
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setEmergencyRelationBL(EmergencyRelationBL emergencyRelationBL) {
		this.emergencyRelationBL = emergencyRelationBL;
	}
    
    public void setIg898BL(IG898BL ig898bl) {
		ig898BL = ig898bl;
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
	
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
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
    	log.debug("========����������̸�ֵ�����˿�ʼ========");
		// ��ȡ��������Ϣ
    	ProcessRecordInfo prInfo = this.flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null).get(0);
    	String psdid = bean.getAfstatus();
		// ��ѯ��������Ӧ������
		EmergencyRelationSearchCondImpl erCond = new EmergencyRelationSearchCondImpl();
		erCond.setCldprid(prInfo.getPrid());
		erCond.setRelatetype(IGDRMCONSTANTS.DRILL_RELATE_SCENE);
		List<EmergencyRelationInfo> drillList = emergencyRelationBL.searchEmergencyRelationInfo(erCond, 0, 0);
		// ��ѯ������ص�ָ������
		erCond.setRelatetype(IGDRMCONSTANTS.DIRECT_RELATE_SCENE);
		List<EmergencyRelationInfo> ecpList = emergencyRelationBL.searchEmergencyRelationInfo(erCond, 0, 0);
        
    	//�رսڵ� �������̱���ֵ
    	if((bean.getPdid()+"002").equals(psdid)){
			// ����������������̲���û�й�����ָ������˵��������ֱ�ӷ���ļ����ָ�����,�� ���������������̱���ֵ
			if (drillList != null && drillList.size() > 0 && (ecpList == null || ecpList.size() == 0)) {
    			for(EmergencyRelationInfo info : drillList){
    				//�趨loginfo
    				WorkFlowLog logInfo = new WorkFlowLog();
    				logInfo.setExecutorid(bean.getLogInfo().getExecutorid());
    				logInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
    				logInfo.setPrid(info.getParprid());
    				logInfo.setComment(bean.getLogInfo().getComment());
    				//���ñ�ֵ
    				PublicProcessInfoValue ptInfo = new PublicProcessInfoValue(logInfo);
    				ptInfo.setFormname(IGDRMCONSTANTS.DRILL_PROCESS_FORM_NAME_DIRECTSTATUS);
    				ptInfo.setFormvalue("���");
    				//����
    				flowSetBL.setPublicProcessInfoValue(ptInfo);
    			}
    		}
    		
    	}else{

    		IG898SearchCondImpl ig898Cond = new IG898SearchCondImpl();
			Integer prid = 0;
			if (CollectionUtils.isNotEmpty(drillList)) {
				prid = drillList.get(0).getParprid();
			} else if (CollectionUtils.isNotEmpty(ecpList)) {
				prid = ecpList.get(0).getParprid();
			}
			ig898Cond.setPrid(prid);
            ig898Cond.setPvalue(psdid);
            List<IG898Info> participantList =  ig898BL.searchIG898(ig898Cond);
            if(participantList != null && participantList.size() > 0){
            	IG333Info ig333Info = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
            	//�������ʵʩ������
           	 	StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
           		//�ڵ�״̬
           	 	participant.setStatusname(ig333Info.getPsdname());
           	    //ɾ��ԾǨ�ڵ��ԭ�в�����
                flowSetBL.deleteStatusParticipant(participant);
                
                //��Ӵ�����
				String rownumber = "";

				IG898Info curParticipantForm = null;

				for (IG898Info ig898Info : participantList) {
					if ("���̽ڵ�id".equals(ig898Info.getPvcolname()) && psdid.equals(ig898Info.getPvalue())) {
						rownumber = ig898Info.getPvrownumber();
						break;
					}
				}
				for (IG898Info ig898Info : participantList) {
					if (rownumber.equals(ig898Info.getPvrownumber()) && IGDRMCONSTANTS.DIRECT_ADJUST_PARTIC.equals(ig898Info.getPvcolname())) {
						curParticipantForm = ig898Info;
						break;
					}
				}
				if (curParticipantForm != null) {
					// IG898Info info = list.get(0);
					if (StringUtils.isNotBlank(curParticipantForm.getPvalue())) {
						String[] roleuser = curParticipantForm.getPvalue().split("_roleuser_");
                		for(String roleuserInfo : roleuser){
                			String[] roleur =  roleuserInfo.split("_role_");
                			if(roleur != null){
                				String role = roleuserInfo.split("_role_")[0];
                				//ָ������
                				if(roleur.length > 1){
									String user = roleuserInfo.split("_role_")[1];
                        			String[] userlist = user.split("_user_");
                        			participant.setRoleid(Integer.parseInt(role.split("#")[0]));
                        			
                        			for(String userinfo : userlist){
										String userid = userinfo.split("#")[0];
										if (userid.startsWith("_")) {
											userid = userid.substring(1);
										}
                        				participant.setUserid(userid);
                        				flowSetBL.setStatusParticipant(participant);
                        			}
                    			}
                				//ָ������ɫ����ѯ��ɫ��������
                				else if(roleur != null && roleur.length == 1){
                    				String roleid = role.split("#")[0];
    								UserRoleSearchCondImpl userroleCond = new UserRoleSearchCondImpl();
    								userroleCond.setRoleid(Integer.parseInt(roleid));
    								List<UserRole> userRoleList = userRoleBL.searchUserRole(userroleCond);
    								if(userRoleList != null && userRoleList.size() > 0){
    									for(UserRole userRole : userRoleList){
    										participant.setUserid(userRole.getUserid());
                            				flowSetBL.setStatusParticipant(participant);
    									}
    								}
                    			}
                			}
                			
                		}
                	}
                }
            }
    	}
		log.debug("========����������̸�ֵ�����˽���========");
    }
    
}
