/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
  * ����: ������̼��������ӿ�
  * ��������: ������̼��������ӿ�
  * ������¼: 2015/01/04
  * �޸ļ�¼: 
  */
public interface ChangeProcessVWSearchCond {

	/**
	 * ��������ȡ��
	 * @return the prid
	 */
	public Integer getPrid();

	/**
	 * ������ȡ��
	 * @return the prserialnum_like
	 */
	public String getPrserialnum_like();

	/**
	 * ����״̬ȡ��
	 * @return the prstatus
	 */
	public String getPrstatus();

	/**
	 * ���̿�ʼʱ��(��ʼ)ȡ��
	 * @return the propentime_begin
	 */
	public String getPropentime_begin();

	/**
	 * ���̿�ʼʱ��(����)ȡ��
	 * @return the propentime_end
	 */
	public String getPropentime_end();

	/**
	 * ���̹ر�ʱ��(��ʼ)ȡ��
	 * @return the prclosetime_begin
	 */
	public String getPrclosetime_begin();

	/**
	 * ���̹ر�ʱ��(����)ȡ��
	 * @return the prclosetime_end
	 */
	public String getPrclosetime_end();

	/**
	 * �������ȡ��
	 * @return the changeclassify
	 */
	public String getChangeclassify();

	/**
	 * ����ƽ̨ȡ��
	 * @return the updateplatform_like
	 */
	public String getUpdateplatform_like();
	
	/**
	 * �������ȡ��
	 * @return the changetype_like
	 */
	public String getChangetype_like();

	/**
	 * ���ԭ��ȡ��
	 * @return the changereason_like
	 */
	public String getChangereason_like();

	/**
	 * ������ȡ��
	 * @return the changecategory
	 */
	public String getChangecategory();

	/**
	 * ��������ȡ��
	 * @return the prtitle_like
	 */
	public String getPrtitle_like();
	
	/**
	 * ҵ��Ӱ�췶Χȡ��
	 * @return the businessscope
	 */
	public String getBusinessscope();
	
	/**
	 * �Ƿ�Ӱ��ҵ��ȡ��
	 * @return the isinfluence
	 */
	public String getIsinfluence();
	
	/**
	 * �������ȡ��
	 * @return the changecontent_like
	 */
	public String getChangecontent_like();
	
	/**
	 * ������ȡ��
	 * @return ppusername_like  ������
	 */
	public String getPpusername_like();
}