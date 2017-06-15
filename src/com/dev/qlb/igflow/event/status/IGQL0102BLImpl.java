/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.qlb.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * ����������������
 * @time 2014/06/11
 * @author zhangqiang
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IGQL0102BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	private static Log log = LogFactory.getLog(IGQL0102BLImpl.class);
	
	/** ��ѯ��API */
	private FlowSearchBL flowSearchBL;
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	/** ϵͳ��BL */
	protected SysManageBL sysManageBL;
	
	/**
	 * @param ϵͳ��BL the sysManageBL to set
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * @param ���¹���API�� the flowSetBL to set
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)throws BLException {
		log.debug("=====================���һ����������ʼ=====================");
		
		//��ֵȡ��
//		String appL = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��ǰ�����˵ȼ�");
		//�Ƿ���������
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "��������");
		PublicProcessInfoValue value = new PublicProcessInfoValue(bean.getLogInfo());
		if(null != list){
			//ԾǨ��ִ�нڵ㣬�������������ִ������
			value.setFormname("��ǰ�����˵ȼ�");
			value.setFormvalue("3");
			flowSetBL.setPublicProcessInfoValue(value);
//			//�������������
//			Set<Integer> set = new LinkedHashSet<Integer>();
//			for(ParticipantInfo info:list){
//				set.add(info.getRoleid());
//			}
//			//ʵ������������Ϣ
//			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
//			participant.setStatuscode(bean.getAfstatus());
//			//ɾ�������˶���
//			flowSetBL.deleteStatusParticipant(participant);
//			//��ѯ��ɫ�û�
//			for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
//				Integer roleid = iter.next();
//				//��ѯ��ɫ�û�
//				List<UserInfo> userList = sysManageBL.searchUserInfo(roleid, null);
//				//���������û�
//				for(UserInfo user:userList){
//					participant.setRoleid(roleid);
//					participant.setUserid(user.getUserid());
//					flowSetBL.setStatusParticipant(participant);
//				}
//			}
		}else{
			//ԾǨ��ִ�нڵ㣬�������������ִ������
			value.setFormname("��ǰ�����˵ȼ�");
			value.setFormvalue("0");
			flowSetBL.setPublicProcessInfoValue(value);
		}
		log.debug("=====================���һ�������������=====================");
	}
}
