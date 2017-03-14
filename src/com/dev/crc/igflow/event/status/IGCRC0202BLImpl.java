/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.event.status;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼����ɽڵ����������
 * </p>
 * Ĭ��Ϊ����̨
 * ��ظ澯�¼������й���ڷ���
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0202BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־����ȡ�� */
	protected static final Log log = LogFactory.getLog(IGCRC0202BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;
	
	/** ϵͳ����API */
	protected SysManageBL sysManageBL;
	
	/** ����ֵ��ڽ�ɫID */
	protected static final Integer ROLE_ID = 1210;

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ������API�趨
	 * @param flowSetBL ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ϵͳ����API�趨
	 * @param sysManageBL ϵͳ����API
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * ǰ����
	 */
	@SuppressWarnings("unchecked")
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("==============�¼����ɽڵ㴦�������ò�����ʼ===============");
		//��ѯ��ǰ�ڵ������
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		//��ѯ�澯����Ϣ(����澯����ֵ����֤��Ϊ�澯�¼���������Ϊ����ֵ��ڽ�ɫ�µ��ˣ�����Ϊ��ͨ�¼���������Ϊ����̨��ɫ�µ���)
		//���ò����˱�ʶ true ��������ֵ���Ϊ������  false  ���÷���̨Ϊ������
		boolean flag = false;
		//�澯�¼����߸�ǰ����
		String alarmName = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�¼���Դ");
		if(StringUtils.isNotBlank(alarmName) && alarmName.equals("��ظ澯")){
			//����Ǹ澯�¼�����ǰ������Ϊ�����ˣ��ڷ���ڵ�ĺ����Ѿ����������ˣ��ö��߼��Ѿ��ò�����
			return ;
		}
		//��ѯ���ʽ��������Ϣ
		Object obj = flowSearchBL.searchPublicTableValue("�澯��Ϣ", bean.getLogInfo().getPrid(), null);
		//�������ʽ�����鿴���Ƿ���ֵ
		if(obj != null){
			List<Map<String, Object>> tableFormValue = (List<Map<String, Object>>) obj;
			for(Map<String, Object> map : tableFormValue){
				for(Iterator<Entry<String, Object>> iter = map.entrySet().iterator();iter.hasNext();){
					Entry<String, Object> entry = iter.next();
					Object value = entry.getValue();
					if(value != null && StringUtils.isNotEmpty(value.toString().trim())){
						flag = true;
						break;
					}
				}
				if(flag){
					break;
				}
			}
		}
		//ʵ�����ڵ�����˶���
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		//���õ�ǰ�ڵ�
		participant.setStatuscode(bean.getAfstatus());
		//ɾ����ǰ�ڵ������
		flowSetBL.deleteStatusParticipant(participant);
		if(flag){
			//��������ֵ���Ϊ��ǰ�ڵ������
			List<UserInfo> userList = sysManageBL.searchUserInfo(ROLE_ID, null);
			for(UserInfo ur:userList){
				participant.setUserid(ur.getUserid());
				participant.setRoleid(ROLE_ID);
				flowSetBL.setStatusParticipant(participant);
			}
		}else{
			//���÷���̨Ϊ��ǰ�ڵ������
			for(ParticipantInfo info:list){
				List<UserInfo> userList = sysManageBL.searchUserInfo(info.getRoleid(), null);
				for(UserInfo ur:userList){
					participant.setRoleid(info.getRoleid());
					participant.setUserid(ur.getUserid());
					flowSetBL.setStatusParticipant(participant);
				}
			}
		}
		
		log.debug("==============�¼����ɽڵ㴦�������ò�������===============");
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
