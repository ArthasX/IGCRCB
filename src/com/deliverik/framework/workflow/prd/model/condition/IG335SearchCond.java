/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �����Ա���������ӿ�
  * ��������: �����Ա���������ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG335SearchCond {
	/**
	 * ״̬����IDȡ��
	 * @return psdid_eq ״̬����ID
	 */
	public String getPsdid_eq() ;

	/**
	 * ״̬����IDLikeȡ��
	 * @return psdid_like ״̬����IDLike
	 */
	public String getPsdid_like();
	
	/**
	 * ������IDȡ��
	 * @return pidid_eq ������ID
	 */
	public String getPidid_eq();

	/**
	 * ��ֵȡ��
	 * @return pivalue_eq ��ֵ
	 */
	public String getPivalue_eq();
	
	/** 
     * ������ID ȡ��
     * @return pidid_like ������ID 
     */
    public String getPidid_like();

	/**
	 * ���̶���ID(��ȫƥ��)ȡ��
	 * @return pdid_eq ���̶���ID(��ȫƥ��)
	 */
	public String getPdid_eq();
	
	/**
	 * ���̶���ID(ģ��ƥ��)ȡ��
	 * @return pdid_like ���̶���ID(ģ��ƥ��)
	 */
	public String getPdid_like();

}