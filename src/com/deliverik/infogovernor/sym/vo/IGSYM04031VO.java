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
 * Description: ϵͳ����_��Ȩ����_�˵���Ȩ��ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04031VO extends BaseVO implements Serializable {

	/**
	 * ��ɫ����List
	 */
	
	protected List<Role> roleList;

	/**
	 * ���췽��
	 * @param roleList List<Role>
	 */
	
	public IGSYM04031VO(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * ��ȡ��ɫ����List
	 * @return List<Role>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}
}
