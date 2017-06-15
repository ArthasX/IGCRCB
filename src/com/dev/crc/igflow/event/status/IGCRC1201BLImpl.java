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

/**	
 * ����:���������̴�����ڵ����
 * �����������ж��ĵ����࣬Ϊ�ĵ�����Ա�����͹黹�ڵ����ò�����
 *         
 * ������¼��taoye@deliverik.com   2014-7-11
 * �޸ļ�¼��
 */

public class IGCRC1201BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{

	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC1201BLImpl.class);
	
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
		
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=====================���������̴�����ڵ����ʼ=====================");
		
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
		
		//����ɾ���ڵ�Ĳ�����
		StatusParticipant statusParticipant_del = new StatusParticipant(bean.getLogInfo());
		statusParticipant_del.setStatusname("�ĵ�����Ա����");
		flowSetBL.deleteStatusParticipant(statusParticipant_del);
		statusParticipant_del.setStatusname("�黹");
		flowSetBL.deleteStatusParticipant(statusParticipant_del);
		
		for(RoleInfo info : roleinfos){
			//��ȡ�û���Ϣ
			List<UserInfo> userInfos = sysManageBL.searchUserInfo(info.getRoleid(),"");
			for(UserInfo user : userInfos){
				//״̬��������Ϣ����
				StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
				statusParticipant.setRoleid(info.getRoleid());
				statusParticipant.setUserid(user.getUserid());
				statusParticipant.setStatusname("�ĵ�����Ա����");
				flowSetBL.setStatusParticipant(statusParticipant);
			
				statusParticipant.setStatusname("�黹");
				flowSetBL.setStatusParticipant(statusParticipant);
			}
		}
		
		log.debug("=====================���������̴�����ڵ�������=====================");
	}

}
