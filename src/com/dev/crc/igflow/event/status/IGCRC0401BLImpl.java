/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
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
public class IGCRC0401BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC0401BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
    
    /** ϵͳ����API�� */
    private SysManageBL sysManageBL;
    
    /** �������� */
    private String CHANGE_STATUSNAME_BMSP = "��������";
    
    /** �����������ĸ����� */
    private Integer roleid_1227 = 1227;
    
    /** ϵͳ�������ĸ����� */
    private Integer roleid_1228 = 1228;
    
    /** ����������ĸ����� */
    private Integer roleid_1229 = 1229;
    
    /** �ۺϹ��������� */
    private Integer roleid_1230 = 1230;
    
    /**���������  roleid*/
    private Integer roleid_1220 = 1220;
    
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
	    
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		Integer roleid = null;
        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1227Ϊ�����������ĸ�����
        List<UserInfo> userInfoList1227 = this.sysManageBL.searchUserInfo(roleid_1227, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
        if(userInfoList1227 != null && userInfoList1227.size() != 0){
        	roleid = roleid_1227;
        	userInfoList.addAll(userInfoList1227);
        }
        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1228Ϊϵͳ�������ĸ�����
        List<UserInfo> userInfoList1228 = this.sysManageBL.searchUserInfo(roleid_1228, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
        if(userInfoList1228 != null && userInfoList1228.size() != 0){
        	roleid = roleid_1228;
        	userInfoList.addAll(userInfoList1228);
        }
        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1229Ϊ����������ĸ�����
        List<UserInfo> userInfoList1229 = this.sysManageBL.searchUserInfo(roleid_1229, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
        if(userInfoList1229 != null && userInfoList1229.size() != 0){
        	roleid = roleid_1229;
        	userInfoList.addAll(userInfoList1229);
        	//��ѯ������������ڵĳ�Ա
        	List<UserInfo> userInfoList1220 = this.sysManageBL.searchUserInfo(roleid_1220, "0002");
        	userInfos.addAll(userInfoList1220);
        }
        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1230Ϊ�ۺϹ���������
        List<UserInfo> userInfoList1230 = this.sysManageBL.searchUserInfo(roleid_1230, this.sysManageBL.searchUserInfo(bean.getCrtuserid()).getOrgid());
        if(userInfoList1230 != null && userInfoList1230.size() != 0){
        	roleid = roleid_1230;
        	userInfoList.addAll(userInfoList1230);
        }
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
	        participants.setRoleid(roleid);
	      
	        //�����ɫ�Ͳ��������
	        flowSetBL.setStatusParticipant(participants);
	
	    }
	    // ������������������������Ա    ����������ڵ�������Ա���벿��������������
	    if(userInfos != null && userInfos.size() > 0){
	    	for (UserInfo userInfo : userInfos) {
	    		if(!bean.getCrtuserid().equals(userInfo.getUserid())){//����������ڴ�������,��ȥ��������
	    			//��־������Ϣ�趨
	    			StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
	    			//��װ����״̬����
	    			participants.setStatusname(CHANGE_STATUSNAME_BMSP);
	    			//��װ���̴�����id
	    			participants.setUserid(userInfo.getUserid());
	    			//��װ���̴����ɫid
	    			participants.setRoleid(roleid_1220);
	    			//�����ɫ�Ͳ��������
	    			flowSetBL.setStatusParticipant(participants);
	    		}
		    }
	    }
	}
}

