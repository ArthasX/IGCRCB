/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �������Ա����������ӿ�
  * ��������: �������Ա����������ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG481SearchCond {
	
	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPgdid();

	/**
	 * ����ʽȡ��
	 *
	 * @return ����ʽ
	 */
	public String getCreateType();
	
	public String getPdid();
	
	public String[] getPdids_in();
	/**
	 * @param ȡ�� ��һ���̶���IDģ����ѯ the pdid_like 
	 */
	public String getPdid_like();

}