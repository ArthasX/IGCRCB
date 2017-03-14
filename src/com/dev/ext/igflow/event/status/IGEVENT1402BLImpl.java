/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.event.status;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ParticipantStatusFormInfo;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.bl.task.ApproveSuggestionBL;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCondImpl;

/**
 * ���ָ����˴������ʱ��
 *
 */
public class IGEVENT1402BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGEVENT1402BLImpl.class);
	
	/** ��ѯ����API�� */
	private FlowSearchBL flowSearchBL;
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	/** �������ҵ��BL */
	private ApproveSuggestionBL approveSuggestionBL;

	/**
	 * ע���ѯ����API��
	 * 
	 * @param flowSearchBL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * �������ҵ��BL�趨
	 * 
	 * @param approveSuggestionBL �������ҵ��BL
	 */
	public void setApproveSuggestionBL(ApproveSuggestionBL approveSuggestionBL) {
		this.approveSuggestionBL = approveSuggestionBL;
	}



	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}
	
	/**
	 * ���ȫ�������ߴ������ʱ��
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    log.debug("========���ָ����˴������ʱ�俪ʼ========");
	    //��ѯ��Ч�ı��������
	    ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
	    cond.setPrid_eq(bean.getLogInfo().getPrid());
	    cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);//��Ч
	    List<ApproveSuggestionInfo> lst_ApproveSuggestionInfo = this.approveSuggestionBL.searchApproveSuggestionInfo(cond);
	    //��ѯ�״̬�µĲ�����
	    List<ParticipantInfo> lst_ParticipantInfo = 
	    		this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), IGSMRCONSTANT.PRSTATUSNAME_REPORT);
	    boolean flag = true;
	    Set<String> set_Participant = new HashSet<String>();
	    for(ParticipantInfo participant : lst_ParticipantInfo) {
	    	//��ѯ�ò����ɫ�ڸ�״̬�µı�Ȩ��
	    	List<ParticipantStatusFormInfo> lst_ParticipantStatusFormInfo =
	    		this.flowSearchBL.searchParticipantStatusFormInfo(bean.getPdid(), IGSMRCONSTANT.PRSTATUSNAME_REPORT, participant.getRoleid());
	    	for(ApproveSuggestionInfo info : lst_ApproveSuggestionInfo) {
	    		for(ParticipantStatusFormInfo form : lst_ParticipantStatusFormInfo) {
	    			//ƥ�������ID�Ϳ�дȨ��
	    			if(info.getPidid().equals(form.getPidid())
	    					&& IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(form.getPidaccess())) {
	    				//��ոò����ߴ������ʱ��
	    				if(!set_Participant.contains(participant.getRoleid() + "_" + participant.getUserid())) {
	    					flowSetBL.setStatusParticipantRehandle(bean.getLogInfo().getPrid(),
	    							IGSMRCONSTANT.PRSTATUSNAME_REPORT, participant.getRoleid(), participant.getUserid());
	    					set_Participant.add(participant.getRoleid() + "_" + participant.getUserid());
	    					flag = false;
	    					break;
	    				}
	    			}
	    		}
	    	}
	    }
	    //��û�ҵ���Ӧ�����ߣ���û�����������ʱ������в����ߵĴ���ʱ��
	    if(flag) {
	    	for(ParticipantInfo participant : lst_ParticipantInfo) {
				flowSetBL.setStatusParticipantRehandle(bean.getLogInfo().getPrid(),
						IGSMRCONSTANT.PRSTATUSNAME_REPORT, participant.getRoleid(), participant.getUserid());
		    }
	    }
		log.debug("========���ָ����˴������ʱ�����========");
	}

}

