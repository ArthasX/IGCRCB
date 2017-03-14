/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��Դ����ȨVO
 * </p>
 * 
 * @author lujiayun 2012/11/15
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04211VO extends BaseVO implements Serializable {

	/**
	 * ��ɫ����List
	 */
	protected List<Role> roleList;

	/**
	 * ��ɫ����Listȡ��
	 *
	 * @return roleList ��ɫ����List
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * ��ɫ����List�趨
	 *
	 * @param roleList ��ɫ����List
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}