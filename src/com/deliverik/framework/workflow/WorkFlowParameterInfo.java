/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow;

/**
 * ���̴�������ӿ�
 * 
 */
public interface WorkFlowParameterInfo {
	
	/**
	 * �ʲ�IDȡ��
	 * 
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid();

	/**
	 * ��չ����ֵ������#�����Ӷ��ֵ��ȡ��
	 * 
	 * @return ��չ����ֵ
	 */
	public String getParameters();
	
	/**
     * ������IDȡ��
     * 
     * @return ������ID
     */
	public Integer getParprid();
	
	public String getPruserid();
}
