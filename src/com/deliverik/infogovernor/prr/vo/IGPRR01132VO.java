/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * @Description: ���̶���_������Vo
 * @Author  
 * @History 2009-8-23     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01132VO extends BaseVO implements Serializable {
	
	/** ��ɫ */
	private Role role;
	
	/** �û��б� */
	private List<IG602Info> lst_ProcessExecutorVWInfo;
	
	/**
	 * ���캯��
	 * 
	 * @param role ��ɫ
	 * @param lst_ProcessExecutorVWInfo �û��б�
	 */
	public IGPRR01132VO(Role role, List<IG602Info> lst_ProcessExecutorVWInfo) {
		this.role = role;
		this.lst_ProcessExecutorVWInfo = lst_ProcessExecutorVWInfo;
	}

	/**
	 * ��ɫȡ��
	 * 
	 * @return ��ɫ
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * �û��б�ȡ��
	 * 
	 * @return �û��б�
	 */
	public List<IG602Info> getLst_ProcessExecutorVWInfo() {
		return lst_ProcessExecutorVWInfo;
	}

}
