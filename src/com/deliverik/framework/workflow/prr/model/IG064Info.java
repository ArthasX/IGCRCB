/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

/**
  * ����: ���̼�¼�ڵ�������ͼ�ӿ�
  * ��������: ���̼�¼�ڵ�������ͼ�ӿ�
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public interface IG064Info {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid();

	/**
	 * ����״̬IDȡ��
	 *
	 * @return ����״̬ID
	 */
	public String getPsdid();

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();
	
	public String getPsdname();

	/**
	 * ����״̬��ʾȡ��
	 *
	 * @return ����״̬��ʾ
	 */
	public String getPsdcode();

	/**
	 * �Ƿ��ύ��0����1���ǣ�ȡ��
	 *
	 * @return �Ƿ��ύ��0����1���ǣ�
	 */
	public String getPsdconfirm();

	/**
	 * ��ǰ�����ɫIDȡ��
	 *
	 * @return ��ǰ�����ɫID
	 */
	public Integer getPproleid();

	/**
	 * �����ɫ����ȡ��
	 *
	 * @return �����ɫ����
	 */
	public String getPprolename();

	/**
	 * ��ǰ������ԱIDȡ��
	 *
	 * @return ��ǰ������ԱID
	 */
	public String getPpuserid();

	/**
	 * ��Ա����ȡ��
	 *
	 * @return ��Ա����
	 */
	public String getPpusername();

	/**
	 * �ӵ�����ȡ��
	 *
	 * @return �ӵ�����
	 */
	public String getPpsubstatus();
	
	public String getPpinittime();

	/**
	 * �ӵ�ʱ��ȡ��
	 *
	 * @return �ӵ�ʱ��
	 */
	public String getPpbacktime();

	/**
	 * ���Զ���״̬IDȡ��
	 *
	 * @return ���Զ���״̬ID
	 */
	public String getPnsdpsdid();

	/**
	 * ���Ա��ύ��ʾȡ��
	 *
	 * @return ���Ա��ύ��ʾ
	 */
	public String getPnsdconfirm();

	/**
	 * �Ƿ��Ͷ���ȡ��
	 *
	 * @return �Ƿ��Ͷ���
	 */
	public String getSms();

	/**
	 * �Ƿ���EMAILȡ��
	 *
	 * @return �Ƿ���EMAIL
	 */
	public String getEmail();

	/**
	 * ֪ͨʱ����ȡ��
	 *
	 * @return ֪ͨʱ����
	 */
	public Integer getNotifyd();

	/**
	 * ֪ͨСʱȡ��
	 *
	 * @return ֪ͨСʱ
	 */
	public Integer getNotifyh();

	/**
	 * ֪ͨʱ���ȡ��
	 *
	 * @return ֪ͨʱ���
	 */
	public Integer getNotifym();

	/**
	 * �ϱ���ȡ��
	 *
	 * @return �ϱ���
	 */
	public Integer getReportd();

	/**
	 * �ϱ�ʱȡ��
	 *
	 * @return �ϱ�ʱ
	 */
	public Integer getReporth();

	/**
	 * �ϱ���ȡ��
	 *
	 * @return �ϱ���
	 */
	public Integer getReportm();

	/**
	 * ��ɫ������ȡ��
	 *
	 * @return ��ɫ������
	 */
	public String getRolemanager();
	
	public Integer getPpid();
	public String getPrtitle();


	public String getPrserialnum();
	
	//====>130225Begin
	/**
	 * ״̬ģʽȡ��
	 *
	 * @return psdassign ״̬ģʽ
	 */
	public String getPsdassign();
	
	/**
	 * ���������ȡ��
	 *
	 * @return pporgid ���������
	 */
	public String getPporgid();
	
	/**
	 * ��������ȡ��
	 *
	 * @return pporgname ��������
	 */
	public String getPporgname();
	//====>130225End
}