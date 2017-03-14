/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG700Info;

/**
 * ��Ȩ��_��ȨVO
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01711VO extends BaseVO implements Serializable {

	/** δ��Ӳ����߶���List */
	protected List<Role> roleList;
	
	/** ����ӽ�ɫ����List  */
	protected List<IG700Info> ig700InfoList;
	

	public List<IG700Info> getIg700InfoList() {
		return ig700InfoList;
	}

	public void setIg700InfoList(List<IG700Info> ig700InfoList) {
		this.ig700InfoList = ig700InfoList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
