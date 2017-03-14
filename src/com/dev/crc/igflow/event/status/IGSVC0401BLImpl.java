/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * ������� - �������������ڵ�ǰ����Ԥ�÷����˽�ɫ �Ĳ��Ÿ�����Ϊ���������ڵ��������
 * @author wanglei
 *
 */
public class IGSVC0401BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGSVC0401BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
    
    /** ϵͳ����API�� */
    private SysManageBL sysManageBL;
    
    /** �������� */
    private String CHANGE_STATUSNAME_BMSP = "��������";
    
    /** ���ĸ����� */
    private Integer roleid_1222 = 1222;
    
	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

    /**
     * @param ϵͳ����API�� the sysManagerBL to set
     */
    public void setSysManageBL(SysManageBL sysManageBL) {
        this.sysManageBL = sysManageBL;
    }
    
	/**
     * ����
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
	
	/**
	 * ǰ������Ӳ�����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========������̲�������ǰ�������ò����ߴ���ʼ========");

	    //��־������Ϣ�趨
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //��װ����״̬����
        participant.setStatusname(CHANGE_STATUSNAME_BMSP);
        
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(participant);
        
        // ���ò���������
        setParticipant(bean);
      
		log.debug("========������̲�������ǰ�������ò����ߴ������========");
	}

	/**
	 * ����������
	 * @param bean
	 * @param applevel
	 * @param roleid
	 * @throws BLException
	 */
	private void setParticipant(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1222Ϊ���ĸ�����
        List<UserInfo> userInfoList = this.sysManageBL.searchUserInfo(roleid_1222, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
		
	    if (userInfoList == null || userInfoList.size() == 0) {
	        throw new BLException("IGSVC0408.E001", CHANGE_STATUSNAME_BMSP);
	    }
	    for (UserInfo userInfo : userInfoList) {
			
	        //��־������Ϣ�趨
	        StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
	      
	        //��װ����״̬����
	        participants.setStatusname(CHANGE_STATUSNAME_BMSP);
	        
	        //��װ���̴�����id
	        participants.setUserid(userInfo.getUserid());
	      
	        //��װ���̴����ɫid
	        participants.setRoleid(roleid_1222);
	      
	        //�����ɫ�Ͳ��������
	        flowSetBL.setStatusParticipant(participants);
	
	    }
	}
}

