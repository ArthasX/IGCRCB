/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * �ʲ�������Ϣ
 */
public class ConfigItem implements ConfigItemInfo {
	
	/** �ʲ�����ID */
	private Integer ciid;
	
	/** �ʲ����Զ���ID */
	private String cid;

	/** �ʲ��������� */
	private String name;
	
	/** �ʲ�����ֵ */
	private String value;
	
	/**
	 * �ʲ�����IDȡ��
	 * 
	 * @return �ʲ�����ID
	 */
	public Integer getCiid() {
		return ciid;
	}
	
	/**
	 * �ʲ����Զ���IDȡ��
	 * 
	 * @return �ʲ����Զ���ID
	 */
	public String getCid() {
		return cid;
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
	 * �ʲ�����ID�趨
	 * 
	 * @param ciid �ʲ�����ID
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}
	
	/**
	 * �ʲ����Զ���ID�趨
	 * 
	 * @param cid �ʲ����Զ���ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
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
	
}
