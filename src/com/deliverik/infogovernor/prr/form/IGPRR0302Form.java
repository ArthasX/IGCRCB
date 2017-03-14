/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ɫ��ѯform
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0302Form extends BaseForm{
	
	/** ��ɫ���� */
	protected String rolename_q;
	
	/** ��ɫ���� */
	protected String roletype;
	
	/** ��ɫid���� */
	protected String roleids;
	
	/** ��ӱ�ʶ A �����ˣ�B ֵ���� �� C ִ���� */
	protected String addFlag;
	
	/** �������� */
	protected String[] addContent;
	
	/** ��ɫ���Ͳ���ѡ��ʶ */
	protected String disabled;
	
	/** ��ɫID���� */
	protected String roleidin;

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public final String getRolename_q() {
		return rolename_q;
	}

	/**
	 * ��ɫ�����趨
	 * @param rolename_q ��ɫ����
	 */
	public final void setRolename_q(String rolename_q) {
		this.rolename_q = rolename_q;
	}

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public final String getRoletype() {
		return roletype;
	}

	/**
	 * ��ɫ�����趨
	 * @param roletype ��ɫ����
	 */
	public final void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * ��ɫid����ȡ��
	 * @return ��ɫid
	 */
	public final String getRoleids() {
		return roleids;
	}

	/**
	 * ��ɫid�����趨
	 * @param roleids ��ɫid����
	 */
	public final void setRoleids(String roleids) {
		this.roleids = roleids;
	}
	
	/**
	 * ��дreset�������ԭformֵ
	 */
	public void reset() {
		this.rolename_q = null;
		this.roletype = null;
		this.disabled = null;
		this.roleids = null;
		this.roleidin = null;
	}

	/**
	 * ������ʶȡ��
	 * @return ������ʶ
	 */
	public final String getAddFlag() {
		return addFlag;
	}

	/**
	 * ������ʶ�趨
	 * @param addFlag ������ʶ
	 */
	public final void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public final String[] getAddContent() {
		return addContent;
	}

	/**
	 * ���������ඨ
	 * @param addContent ��������
	 */
	public final void setAddContent(String[] addContent) {
		this.addContent = addContent;
	}

	/**
	 * ��ɫ���Ͳ���ѡ��ʶȡ��
	 * @return disabled ��ɫ���Ͳ���ѡ��ʶ
	 */
	public String getDisabled() {
		return disabled;
	}

	/**
	 * ��ɫ���Ͳ���ѡ��ʶ�趨
	 * @param disabled ��ɫ���Ͳ���ѡ��ʶ
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	/**
	 * ��ɫID����ȡ��
	 * @return roleidin ��ɫID����
	 */
	public String getRoleidin() {
		return roleidin;
	}

	/**
	 * ��ɫID�����趨
	 * @param roleidin ��ɫID����
	 */
	public void setRoleidin(String roleidin) {
		this.roleidin = roleidin;
	}
}
