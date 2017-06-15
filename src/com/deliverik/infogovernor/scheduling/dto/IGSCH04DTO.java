/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.infogovernor.scheduling.form.IGSCH0401Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_�¼��ලDTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSCH04DTO extends BaseDTO {

	private IGSCH0401Form igsch0401Form;
	
	private List<Role> roleList;

	public IGSCH0401Form getIgsch0401Form() {
		return igsch0401Form;
	}

	public void setIgsch0401Form(IGSCH0401Form igsch0401Form) {
		this.igsch0401Form = igsch0401Form;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
}