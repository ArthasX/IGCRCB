package com.deliverik.framework.model.condition;

/**
 * ������Ϣ��ѯ�����ӿ�
 * 
 */
public interface CodeDetailDefSearchCond {
	
	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid ();

	/**
	 * ����CDȡ��
	 * @return ����CD
	 */
	public String getCid ();

	/**
	 * ���ݷ���CD(��)ȡ��
	 * @return ���ݷ���CD(��)
	 */
	public String getPccid ();

	/**
	 * ����CD(��)ȡ��
	 * @return ����CD(��)
	 */
	public String getPcid ();
	
	/**
	 * ����CD״̬ȡ��
	 * @return ����CD״̬
	 */
	public String getCdstatus();
	
	/**
	 * ��ѯ1�����
	 */
	public String getClevel();
	
	/**
	 * ��ѯָ�������¼���
	 */
	public String getSyscoding_q();
	
	/**
	 * ��ѯָ���Ľ��
	 */
	public String getSyscoding();
	
	/**
	 * �ʲ�������ϵ������
	 */
	public String getBusinesscode_like();
	
	public String getCvalue_like();

}
