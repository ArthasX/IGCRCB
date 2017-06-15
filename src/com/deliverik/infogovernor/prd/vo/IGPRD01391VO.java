/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG298Info;

/**
 * ����: ����״̬�����ɫ����VO
 * ��������: ����״̬�����ɫ����VO
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD01391VO extends BaseVO implements Serializable {

	/** ��ѡ��ɫ�б� */
	protected List<Role> lst_Role;
	
	/** ��ѡ��ɫ�б�  */
	protected List<IG298Info> lst_ProcessStatusRoleDef;

	/**
	 * ��ѡ��ɫ�б�ȡ��
	 * 
	 * @return ��ѡ��ɫ�б�
	 */
	public List<Role> getLst_Role() {
		return lst_Role;
	}

	/**
	 * ��ѡ��ɫ�б��趨
	 * 
	 * @param lst_Role ��ѡ��ɫ�б�
	 */
	public void setLst_Role(List<Role> lst_Role) {
		this.lst_Role = lst_Role;
	}

	/**
	 * ��ѡ��ɫ�б�ȡ��
	 * 
	 * @return ��ѡ��ɫ�б�
	 */
	public List<IG298Info> getLst_ProcessStatusRoleDef() {
		return lst_ProcessStatusRoleDef;
	}

	/**
	 * ��ѡ��ɫ�б��趨
	 * 
	 * @param lst_ProcessStatusRoleDef ��ѡ��ɫ�б�
	 */
	public void setLst_ProcessStatusRoleDef(
			List<IG298Info> lst_ProcessStatusRoleDef) {
		this.lst_ProcessStatusRoleDef = lst_ProcessStatusRoleDef;
	}
	
}
