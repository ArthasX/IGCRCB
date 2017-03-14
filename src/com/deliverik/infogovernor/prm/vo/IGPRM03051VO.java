/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������_ȱʡ������_�б�VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM03051VO extends BaseVO implements Serializable {

	/**
	 * δ��������˶���List
	 */
	
	protected List<Role> roleList;
	
	/**
	 * ����������˶���List
	 */
	
	protected List<IG337Info> approveDispatcherList;

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<IG337Info> getApproveDispatcherList() {
		return approveDispatcherList;
	}

	public void setApproveDispatcherList(
			List<IG337Info> approveDispatcherList) {
		this.approveDispatcherList = approveDispatcherList;
	}
	
}
