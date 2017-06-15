/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.cyb.igflow.event.status;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

public class IGCYB0102BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0102BLImpl.class);
    private FlowSetBL flowSetBL;
    
    /** ���̲�ѯ����BL*/
    private FlowSearchBL flowSearchBL;

    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    /**
	 * ���̲�ѯ����BL�趨
	 * @param flowSearchBL the ���̲�ѯ����BL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}


	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========�����������ӷ�����ΪĬ������˿�ʼ========");

        //��־������Ϣ�趨
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //��װ����״̬����
        participant.setStatusname("�¼����");
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(participant);
        
        StatusParticipant participant1 = new StatusParticipant(bean.getLogInfo());
        participant1.setStatusname("�¼����");
        participant1.setUserid(bean.getCrtuserid());
        participant1.setRoleid(bean.getCrtroleid());
        this.flowSetBL.setStatusParticipant(participant1);
        
        //�澯���̷���������Ϊ��ǰ������
        String alarmName = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�¼���Դ");
        if(StringUtils.isNotBlank(alarmName) && alarmName.equals("��ظ澯")){
        	//��װ����״̬����
        	participant.setStatusname("�¼�����");
        	//ɾ��ԾǨ�ڵ��ԭ�в�����
        	flowSetBL.deleteStatusParticipant(participant);
        	StatusParticipant participant2 = new StatusParticipant(bean.getLogInfo());
        	participant2.setStatusname("�¼�����");
        	participant2.setUserid(bean.getCrtuserid());
        	participant2.setRoleid(bean.getCrtroleid());
        	this.flowSetBL.setStatusParticipant(participant2);
        }
        log.debug("========�����������ӷ�����ΪĬ������˽���========");
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
}
