/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ֪ͨ���Ի�����Ϣ���������ӿ�
  * ��������: ֪ͨ���Ի�����Ϣ���������ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG334SearchCond {

	/**
	 * ��������IDģ����ѯȡ��
	 *
	 * @return pdid_like ��������IDģ����ѯ
	 */
	public String getPdid_like();

	
	/**
	 * ������������ID��ֵ��ѯ
	 * @return
	 */
	public String getPdid_eq();

	/**
	 * ���̱�ID(��ȫƥ��)ȡ��
	 * @return pidid_eq ���̱�ID(��ȫƥ��)
	 */
	public String getPidid_eq();
	
	/**
	 * ���̱�ID(ģ��ƥ��)ȡ��
	 * @return pidid_like ���̱�ID(ģ��ƥ��)
	 */
	public String getPidid_like();

}