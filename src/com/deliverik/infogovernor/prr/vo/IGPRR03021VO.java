/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ɫ��ѯvo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR03021VO extends BaseVO{
	
	/** ��ɫ��Ϣ���� */
	protected List<Role> roleList;

	/**
	 * ��ɫ��Ϣ����ȡ��
	 * @return ��ɫ��Ϣ����
	 */
	public final List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * ��ɫ��Ϣ�����趨
	 * @param roleList ��ɫ��Ϣ����
	 */
	public final void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}
