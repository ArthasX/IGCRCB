/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * ����: �����������������ӿ�
  * ��������: �����������������ӿ�
  * ������¼: 2013/07/22
  * �޸ļ�¼: 
  */
public interface ApproveSuggestionSearchCond {

	/**
	 * ��������ȡ��
	 *
	 * @return prid_eq ��������
	 */
	public Integer getPrid_eq();

	/**
	 * ����������ȡ��
	 *
	 * @return pidid_eq ����������
	 */
	public String getPidid_eq();
	
	/**
	 * ���״̬ȡ��
	 *
	 * @return status_eq ���״̬
	 */
	public String getStatus_eq();
	
	/**
	 * ����״̬��ʶȡ��
	 *
	 * @return psdcode_eq ����״̬��ʶ
	 */
	public String getPsdcode_eq();
	
	/**
	 * ���ʽ���к�ȡ��
	 * @return rownumber_eq ���ʽ���к�
	 */
	public String getRownumber_eq();
}