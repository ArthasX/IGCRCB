package com.deliverik.framework.model.condition;

/**
 * ���ݷ�����Ϣ��ѯ�����ӿ�
 * 
 */
public interface CodeCategoryDefSearchCond {
	
	/**
	 * ����CDȡ��
	 * @return ����CD
	 */
	public String getCcid ();
	
	/**
	 * �ϼ�����CDȡ��
	 * @return �ϼ�����CD
	 */
	public String getPccid ();

	/**
	 * ����༭��ʶȡ��
	 * @return ����༭��ʶ
	 */
	public String getCceditable ();
	
	/**
	 * �Ƿ�������ȡ��
	 * @return �Ƿ�������
	 */
	public boolean isTree();
	
}
