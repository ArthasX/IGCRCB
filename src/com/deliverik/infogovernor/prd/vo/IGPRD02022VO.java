/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶��������Ϣ��ʾVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD02022VO extends BaseVO{

	/** ��� */
	protected Integer serial;
	
	/** ״̬��Ϣ */
	protected IG333Info processStatusDefinition;
	
	/** ��������Ϣ */
	protected Map<Role, List<User>> participantMap;
	
	/** ǰ��������� */
	protected String prepositionTaskSerial;
	
	/** ������Ϣ */
	protected List<Attachment> attList;
	
	/** ����ʱ�� */
	protected String handlingTime;

	/**
	 * ���ȡ��
	 * @return serial ���
	 */
	public Integer getSerial() {
		return serial;
	}

	/**
	 * ����趨
	 * @param serial ���
	 */
	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	/**
	 * ״̬��Ϣȡ��
	 * @return processStatusDefinition ״̬��Ϣ
	 */
	public IG333Info getProcessStatusDefinition() {
		return processStatusDefinition;
	}

	/**
	 * ״̬��Ϣ�趨
	 * @param processStatusDefinition ״̬��Ϣ
	 */
	public void setProcessStatusDefinition(IG333Info processStatusDefinition) {
		this.processStatusDefinition = processStatusDefinition;
	}

	/**
	 * ��������Ϣȡ��
	 * @return participantMap ��������Ϣ
	 */
	public Map<Role, List<User>> getParticipantMap() {
		return participantMap;
	}

	/**
	 * ��������Ϣ�趨
	 * @param participantMap ��������Ϣ
	 */
	public void setParticipantMap(Map<Role, List<User>> participantMap) {
		this.participantMap = participantMap;
	}

	/**
	 * ǰ���������ȡ��
	 * @return prepositionTaskSerial ǰ���������
	 */
	public String getPrepositionTaskSerial() {
		return prepositionTaskSerial;
	}

	/**
	 * ǰ����������趨
	 * @param prepositionTaskSerial ǰ���������
	 */
	public void setPrepositionTaskSerial(String prepositionTaskSerial) {
		this.prepositionTaskSerial = prepositionTaskSerial;
	}

	/**
	 * ������Ϣȡ��
	 * @return attList ������Ϣ
	 */
	public List<Attachment> getAttList() {
		return attList;
	}

	/**
	 * ������Ϣ�趨
	 * @param attList ������Ϣ
	 */
	public void setAttList(List<Attachment> attList) {
		this.attList = attList;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return handlingTime ����ʱ��
	 */
	public String getHandlingTime() {
		return handlingTime;
	}

	/**
	 * ����ʱ���趨
	 * @param handlingTime ����ʱ��
	 */
	public void setHandlingTime(String handlingTime) {
		this.handlingTime = handlingTime;
	}
}
