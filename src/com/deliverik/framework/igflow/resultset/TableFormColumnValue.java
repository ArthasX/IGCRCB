/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.resultset;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ʽ����ֵ��Ϣ
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class TableFormColumnValue implements TableFormColumnValueInfo{

	/** ��ȫ·�� */
	protected String fullName;
	
	/** �к� */
	protected String rownumber;
	
	/** ��ֵ */
	protected String value;

	/**
	 * ��ȫ·��ȡ��
	 * @return fullName ��ȫ·��
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * ��ȫ·���趨
	 * @param fullName ��ȫ·��
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * �к�ȡ��
	 * @return rownumber �к�
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * �к��趨
	 * @param rownumber �к�
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}

	/**
	 * ��ֵȡ��
	 * @return value ��ֵ
	 */
	public String getValue() {
		return value;
	}

	/**
	 * ��ֵ�趨
	 * @param value ��ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
