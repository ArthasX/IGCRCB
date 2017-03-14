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
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * ����������������������ڵ�ǰ����
 * @time 2014/06/25
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGCRC0801BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC0801BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    
    /** ���̲�ѯ����API */
    private SysManageBL sysManageBL;
    
	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ע���ѯ����API��
	 * 
	 * @param flowSearchBL
	 */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
      
    /**
     * ע�����̲�ѯ����API
     * @param sysManageBL ���̲�ѯ����API
     */
    public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
     * ǰ����
     */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=====================�����������������������ǰ�ô���ʼ=====================");
		
		//��ȡ�ĵ�����ֵ
		String documentSort = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),"�ĵ�����");
		//��ʼ����ɫ����
		String rolename = "";
		//�ĵ�����Ϊ��ͬ����ʱ���ɲ�ͬ���ĵ�����Ա����
		if( documentSort.indexOf("�Ƽ�������") > 0 ){
			rolename = "�Ƽ��������ĵ�����Ա";
		}else if( documentSort.indexOf("���������") > 0 ){
			rolename = "����������ĵ�����Ա";
		}else if( documentSort.indexOf("����������") > 0 ){
			rolename = "�����������ĵ�����Ա";
		}
		//��ȡ��ɫ�б�
		List<RoleInfo> roleinfos = sysManageBL.searchRoleInfo(rolename);
		
		//ʵ������������Ϣ
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("����������� ");
		
		//ɾ�������˶���
		flowSetBL.deleteStatusParticipant(participant);
		
		for(RoleInfo info : roleinfos){
			//��ȡ�û���Ϣ
			List<UserInfo> userInfos = sysManageBL.searchUserInfo(info.getRoleid(),"");
			for(UserInfo user : userInfos){
				//״̬��������Ϣ����
				StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
				statusParticipant.setRoleid(info.getRoleid());
				statusParticipant.setUserid(user.getUserid());
				statusParticipant.setStatusname("����������� ");
				//��Ӳ�����
				flowSetBL.setStatusParticipant(statusParticipant);
			}
		}
		
		log.debug("=====================�����������������������ǰ�ô���ʼ=====================");
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}