package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * 
 * ���ܣ�ָ�ɼ�鹤���������ִ���ˣ���ת��ִ��״̬
 * @author   2014-9-11
 */
public class IGVEN0105BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	static Log log = LogFactory.getLog(IGVEN0105BLImpl.class);

	/** ��������BL */
	private IG500BL ig500BL;

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** �û���Ϣ��ѯBL */
	private UserBL userBL;
	
	/** ���̴���BL */
    protected WorkFlowOperationBL workFlowOperationBL;
    
    /** ����״̬����BL */
    protected IG333BL ig333BL;
    
	/** ������ */
	private String STATUSNAME_JCFP = "������";
	
	/** ���ִ�� */
	private String STATUSNAME_JCZX = "���ִ��";


	/**
	 * ��������BL����
	 * 
	 * @param ig500bl ��������BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * @param ��ѯ�๦��API��
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * �û���Ϣ��ѯBL����
	 * 
	 * @param userBL �û���Ϣ��ѯBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * ����״̬����BL����
	 * 
	 * @param ig333bl ����״̬����BL
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}

	/** ǰ���� */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		log.debug("========ָ�ɹ������������ִ���ˣ���ת��ִ��״̬����ʼ========");
		Integer prid = bean.getLogInfo().getPrid();
		List<ParticipantInfo> lst_StatusParticipant = flowSearchBL.searchStatusParticipant(prid, STATUSNAME_JCZX);
		if(lst_StatusParticipant != null && lst_StatusParticipant.size() > 0){
			//��ȡ��ǰ��¼�û�
		    User user = userBL.searchUserByKey(bean.getCrtuserid());
		    //��ȡ��Ȩ�û�
		    User authorizeuser = null;
		    if(StringUtils.isNotEmpty(bean.getLogInfo().getAuthuserid())){
		    	authorizeuser = userBL.searchUserByKey(bean.getLogInfo().getAuthuserid());
		    }
		    
		    //��ȡ��ǰ����
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
			IG500TB processTB = (IG500TB)SerializationUtils.clone(process);
			
			processTB.setPrstatus("X");
			ig500BL.updateIG500Info(processTB);
			
			//��ѯ����״̬��Ϣ
			IG333SearchCondImpl cond333 = new IG333SearchCondImpl();
			cond333.setPdid(processTB.getPrpdid());
			cond333.setPsdname(STATUSNAME_JCFP);
			IG333Info fpsd = ig333BL.searchIG333Info(cond333).get(0);
			cond333.setPsdname(STATUSNAME_JCZX);
			IG333Info tpsd = ig333BL.searchIG333Info(cond333).get(0);
			
			//���������־
			workFlowOperationBL.addRecordLog(prid, user, bean.getCrtroleid(), 
					"����ԾǨ�ɹ�", STATUSNAME_JCZX, null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, "10", null);
			//�������״̬��־
			workFlowOperationBL.addRecordStatusLog(processTB, fpsd, null, new String[]{tpsd.getPsdid()}, 
					WorkFlowConstDefine.STATUSTYPE_NORMAL, user,  bean.getCrtroleid(), authorizeuser, "10");
			
		}
	        	        
		log.debug("========ָ�ɹ������������ִ���ˣ���ת��ִ��״̬�������========");
	}

	/** ���� */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}
}