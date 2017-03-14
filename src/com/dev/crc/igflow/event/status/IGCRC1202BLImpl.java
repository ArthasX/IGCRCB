/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**	
 * ����:�����������ۺϹ��������������ڵ�ǰ����
 * �����������ж���֯Ϊ�ۺϹ��������ĸ����˼��������
 *         
 * ������¼��taoye@deliverik.com   2014-7-17
 * �޸ļ�¼��
 */

public class IGCRC1202BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{

	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC1202BLImpl.class);
	
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
		log.debug("=================�����������ۺϹ��������������ڵ�ǰ����ʼ=================");
		//��ѯ�����˶���
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		//��ɫ��Ϣ����
		Set<Integer> set = new LinkedHashSet<Integer>();
		for(ParticipantInfo info:list){
			set.add(info.getRoleid());
		}
		//ʵ������������Ϣ
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatuscode(bean.getAfstatus());
		//ɾ�������˶���
		flowSetBL.deleteStatusParticipant(participant);
		//��ѯ��ɫ�û�
		for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
			Integer roleid = iter.next();
			//��ѯ��ɫ�û�
			List<UserInfo> userList = sysManageBL.searchUserInfo(roleid, null);
			//���������û�
			for(UserInfo user:userList){
				//���û���֯Ϊ�Ƽ��������ۺϹ���ʱ�����Ӳ�����
				if("0002001017001".equals(user.getOrgid())){
					participant.setRoleid(roleid);
					participant.setUserid(user.getUserid());
					flowSetBL.setStatusParticipant(participant);
				}
			}
		}
		log.debug("=================�����������ۺϹ��������������ڵ�ǰ�������=================");
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
