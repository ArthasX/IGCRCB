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
 * ����������� - ��ȷ�ϣ��ڵ�ǰ����Ԥ�ô����˽�ɫΪ���Թ������Ա
 * @author wangyang
 *
 */
public class IGCRC1001BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC1001BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
    
    /** ϵͳ����API�� */
    private SysManageBL sysManageBL;
    
    /** ȷ�� */
    private String SERVERS_STATUSNAME_BMSP = "ȷ��";
    
    /** ���Թ���� */
    private Integer roleid_1218 = 1218;
    
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
		
	    log.debug("========�����������ȷ�Ͻڵ�ǰ�������ò����ߴ���ʼ========");

	    //��־������Ϣ�趨
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //��װ����״̬����
        participant.setStatusname(SERVERS_STATUSNAME_BMSP);
        
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(participant);
        
        // ����������
        setParticipant(bean);
      
		log.debug("========�����������ȷ�Ͻڵ�ǰ�������ò����ߴ���ʼ========");
	}

	/**
	 * ����������
	 * @param bean
	 * @param applevel
	 * @param roleid
	 * @throws BLException
	 */
	private void setParticipant(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1201Ϊҵ���쵼����
        List<UserInfo> userInfoList = this.sysManageBL.searchUserInfo(roleid_1218,null);
		
//        List<RoleInfo> userInfoList = this.sysManageBL.searchRoleInfo(role_name);
        
        
        
	    if (userInfoList == null || userInfoList.size() == 0) {
	        throw new BLException("IGSVC0804.E001");
	    }
	    for (UserInfo userInfo : userInfoList) {
	    	
	    	
	        //��־������Ϣ�趨
	        StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
	      
	        //��װ����״̬����
	        participants.setStatusname(SERVERS_STATUSNAME_BMSP);
	        
	        //��װ���̴�����id
	        participants.setUserid(userInfo.getUserid());
	      
	        //��װ���̴����ɫid
	        participants.setRoleid(roleid_1218);
	      
	        //�����ɫ�Ͳ��������
	        flowSetBL.setStatusParticipant(participants);
	
	    }
	}
}

