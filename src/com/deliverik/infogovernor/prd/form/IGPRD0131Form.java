/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Χѡ��action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0131Form extends BaseForm{

	/** ���̶������� */
	protected String pdid;
	
	/** Ҫɾ����������ID���� */
	protected String[] orgid_del;
	
	/** Ҫ��ӵĻ�����Ϣ���� */
	protected String[] orgid_add;
	
	/** ������ʶ 0ɾ��  1���� */
	protected String model;
	
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	/**
	 * ���̶�������ȡ��
	 * @return ���̶�������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶��������趨
	 * @param pdid ���̶�������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * Ҫɾ����������ID����ȡ��
	 * @return Ҫɾ����������ID����
	 */
	public String[] getOrgid_del() {
		return orgid_del;
	}

	/**
	 * Ҫɾ����������ID�����趨
	 * @param orgid_del Ҫɾ����������ID����
	 */
	public void setOrgid_del(String[] orgid_del) {
		this.orgid_del = orgid_del;
	}

	/**
	 * Ҫ��ӵĻ�����Ϣ����ȡ��
	 * @return Ҫ��ӵĻ�����Ϣ����
	 */
	public String[] getOrgid_add() {
		return orgid_add;
	}

	/**
	 * Ҫ��ӵĻ�����Ϣ�����趨
	 * @param orgid_add Ҫ��ӵĻ�����Ϣ����
	 */
	public void setOrgid_add(String[] orgid_add) {
		this.orgid_add = orgid_add;
	}

	/**
	 * ������ʶȡ��
	 * @return ������ʶ
	 */
	public String getModel() {
		return model;
	}

	/**
	 * ������ʶ�趨
	 * @param model ������ʶ
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * �鿴ģʽȡ��
	 * @return viewHistory �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ�趨
	 * @param viewHistory  �鿴ģʽ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}
}
