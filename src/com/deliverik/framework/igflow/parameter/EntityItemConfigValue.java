/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

import org.apache.struts.upload.FormFile;

/**
 * �ʲ�������Ϣ
 */
public class EntityItemConfigValue implements EntityItemConfigValueInfo {
	
	/** �ʲ�ID */
	private Integer eiid;

	/** �ʲ��������� */
	private String name;
	
	/** �ʲ�����ֵ */
	private String value;
	
	/** ������Ϣ */
	private FormFile file;

	/**
	 * �ʲ�IDȡ��
	 * 
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ���������ȡ��
	 * 
	 * @return �ʲ���������
	 */
	public String getName() {
		return name;
	}

	/**
	 * �ʲ�����ֵȡ��
	 * 
	 * @return �ʲ�����ֵ
	 */
	public String getValue() {
		return value;
	}

	/**
	 * �ʲ�ID�趨
	 * 
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ����������趨
	 * 
	 * @param name �ʲ���������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * �ʲ�����ֵ�趨
	 * 
	 * @param value �ʲ�����ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * ������Ϣȡ��
	 * @return file ������Ϣ
	 */
	public FormFile getFile() {
		return file;
	}

	/**
	 * ������Ϣ�趨
	 * @param file ������Ϣ
	 */
	public void setFile(FormFile file) {
		this.file = file;
	}
	
}
