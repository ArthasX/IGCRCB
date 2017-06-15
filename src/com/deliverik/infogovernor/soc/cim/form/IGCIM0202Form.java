/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0111Info;

/**
 * ����: �ʲ�����Form
 * ��������: �ʲ�����Form
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public class IGCIM0202Form extends BaseForm implements SOC0111Info {

	private static final long serialVersionUID = 1L;

	/** ���� */
	protected Integer eiddid;

	/** ���� */
	protected String name;

	/** �汾�� */
	protected Integer version;

	/** ���� */
	protected String description;

	/**
	 * ����ʱ��
	 */
	protected String createtime;
	/**
	 * ����ʱ��
	 */
	protected String updatetime;
	/**
	 * ��¼ʱ���
	 */
	protected String fingerPrint;

	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * ��������
	 * 
	 * @param eiddid����
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ��������
	 * 
	 * @param name����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * �汾��ȡ��
	 * 
	 * @return �汾��
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾������
	 * 
	 * @param version�汾��
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ��������
	 * 
	 * @param description����
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * ����ʱ������
	 * 
	 * @param createtime����ʱ��
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * ����ʱ������
	 * 
	 * @param updatetime����ʱ��
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * �༭ģʽȡ��
	 * 
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * �༭ģʽ����
	 * 
	 * @param mode�༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * ��¼ʱ���ȡ��
	 * @return ��¼ʱ��
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ��¼ʱ�������
	 * @param fingerPrint��¼ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

}
