/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ��Ȩ����_��Դ����Ȩ
 * @Author  lujiayuan
 * @History 2010/11/19 �½�
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGSYM0422Form extends BaseForm {
	/** ��ɫID(HQ��) */
	protected String roleid;
	
	/** ��ɫ����(HQͬ��) */
	protected String rolename;
	
	/** ��Դ��ID(��) ��� */
	protected String[] ids_add;
	/** ��Դ��ID(��) ɾ�� */
	protected String[] ids_del;

	/**
	 * getter and setter
	 */
	/**
	 * ��ɫID(HQ��)ȡ��
	 *
	 * @return roleid ��ɫID(HQ��)
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID(HQ��)�趨
	 *
	 * @param roleid ��ɫID(HQ��)
	 */	
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	
	/**
	 * ��ɫ����(HQͬ��)ȡ��
	 *
	 * @return rolename ��ɫ����(HQͬ��)
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * ��ɫ����(HQͬ��)�趨
	 *
	 * @param rolename ��ɫ����(HQͬ��)
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * ��Դ��ID(��)���ȡ��
	 *
	 * @return ids_add ��Դ��ID(��)���
	 */
	public String[] getIds_add() {
		return ids_add;
	}

	/**
	 * ��Դ��ID(��)����趨
	 *
	 * @param ids_add ��Դ��ID(��)���
	 */
	public void setIds_add(String[] ids_add) {
		this.ids_add = ids_add;
	}

	/**
	 * ��Դ��ID(��)ɾ��ȡ��
	 *
	 * @return ids_del ��Դ��ID(��)ɾ��
	 */
	public String[] getIds_del() {
		return ids_del;
	}

	/**
	 * ��Դ��ID(��)ɾ���趨
	 *
	 * @param ids_del ��Դ��ID(��)ɾ��
	 */
	public void setIds_del(String[] ids_del) {
		this.ids_del = ids_del;
	}
}
