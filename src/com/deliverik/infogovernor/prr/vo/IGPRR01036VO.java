/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ������̲�����vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR01036VO extends BaseVO{
	
	/** ���ݽ�ɫ��ʾ������ */
	protected Map<Role, List<UserInfo>> map_ParticipantDefToBeAssignByRole;
	
	/** ���ݻ�����ʾ������ */
	protected Map<Organization, List<UserInfo>> map_ParticipantDefToBeAssignByOrg;

	/**
	 * ���ݽ�ɫ��ʾ������ȡ��
	 * @return ���ݽ�ɫ��ʾ������
	 */
	public Map<Role, List<UserInfo>> getMap_ParticipantDefToBeAssignByRole() {
		return map_ParticipantDefToBeAssignByRole;
	}

	/**
	 * ���ݽ�ɫ��ʾ�������趨
	 * @param map_ParticipantDefToBeAssignByRole ���ݽ�ɫ��ʾ������
	 */
	public void setMap_ParticipantDefToBeAssignByRole(
			Map<Role, List<UserInfo>> map_ParticipantDefToBeAssignByRole) {
		this.map_ParticipantDefToBeAssignByRole = map_ParticipantDefToBeAssignByRole;
	}

	/**
	 * ���ݻ�����ʾ������ȡ��
	 * @return  ���ݻ�����ʾ������
	 */
	public Map<Organization, List<UserInfo>> getMap_ParticipantDefToBeAssignByOrg() {
		return map_ParticipantDefToBeAssignByOrg;
	}

	/**
	 * ���ݻ�����ʾ�������趨
	 * @param map_ParticipantDefToBeAssignByOrg ���ݻ�����ʾ������
	 */
	public void setMap_ParticipantDefToBeAssignByOrg(
			Map<Organization, List<UserInfo>> map_ParticipantDefToBeAssignByOrg) {
		this.map_ParticipantDefToBeAssignByOrg = map_ParticipantDefToBeAssignByOrg;
	}
}
