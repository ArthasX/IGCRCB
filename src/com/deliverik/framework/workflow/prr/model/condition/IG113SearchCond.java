package com.deliverik.framework.workflow.prr.model.condition;


/**
 * <p>
 * ����־��Ϣ��������
 * </p>
 * 
 */
public interface IG113SearchCond {
	

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getPiid();
	

	/**
	 * ��־IDȡ��
	 * @return ��־ID
	 */
	public Integer getRlid();

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid();
	
	/**
	 * ��ֵ�Ƿ�Ϊ��ȡ��
	 * @return valueIsNull ��ֵ�Ƿ�Ϊ��
	 */
	public String getValueIsNull();
}
