/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

/**
 * ����: ���̲����趨��Ϣ
 * ��������: ���̲����趨��Ϣ
 * ������¼: 2013/09/04
 * �޸ļ�¼: 
 */
public interface IG334VWInfo{

	/**
	 * ������IDȡ��
	 *
	 * @return pidid ������ID
	 */
	public String getPidid();
	
	/**
	 * ��������IDȡ��
	 *
	 * @return pdid ��������ID
	 */
	public String getPdid();
	
	/**
	 * ���̲��Է��Ͷ��ű�ʶȡ��
	 *
	 * @return sms ���̲��Է��Ͷ��ű�ʶ
	 */
	public String getSms();
	
	/**
	 * ���̲��Է����ʼ���ʶȡ��
	 *
	 * @return email ���̲��Է����ʼ���ʶ
	 */
	public String getEmail();
	
	/**
	 * ���̲��Զ�Ӧ״̬����ȡ��
	 *
	 * @return psdid ���̲��Զ�Ӧ״̬����
	 */
	public String getPsdid();
	
	/**
	 * ���̲��Զ�Ӧ״̬��ʶȡ��
	 *
	 * @return psdcode ���̲��Զ�Ӧ״̬��ʶ
	 */
	public String getPsdcode();
	
	/**
	 * ���̲��Զ�Ӧ״̬����ȡ��
	 *
	 * @return psdname ���̲��Զ�Ӧ״̬����
	 */
	public String getPsdname();
	
	/**
	 * ���̲�����ر�����ȡ��
	 *
	 * @return pidname ���̲�����ر�����
	 */
	public String getPidname();
	
	/**
	 * ���̲�����ر�ֵȡ��
	 *
	 * @return pivalue ���̲�����ر�ֵ
	 */
	public String getPivalue();
	
	/**
	 * ���̲��Գ�ʱ��������ȡ��
	 *
	 * @return notifyd ���̲��Գ�ʱ��������
	 */
	public Integer getNotifyd();
	
	/**
	 * ���̲��Գ�ʱ����Сʱȡ��
	 *
	 * @return notifyh ���̲��Գ�ʱ����Сʱ
	 */
	public Integer getNotifyh();
	
	/**
	 * ���̲��Գ�ʱ���ѷ���ȡ��
	 *
	 * @return notifym ���̲��Գ�ʱ���ѷ���
	 */
	public Integer getNotifym();
	
	/**
	 * ���̲��Ա����ϼ�����ȡ��
	 *
	 * @return reportd ���̲��Ա����ϼ�����
	 */
	public Integer getReportd();
	
	/**
	 * ���̲��Ա����ϼ�Сʱȡ��
	 *
	 * @return reporth ���̲��Ա����ϼ�Сʱ
	 */
	public Integer getReporth();
	
	/**
	 * ���̲��Ա����ϼ�����ȡ��
	 *
	 * @return reportm ���̲��Ա����ϼ�����
	 */
	public Integer getReportm();
	
	/**
	 * ���̲������ѽ�ɫIDȡ��
	 *
	 * @return roleid ���̲������ѽ�ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * ���̲������ѵ���BLȡ��
	 *
	 * @return processbl ���̲������ѵ���BL
	 */
	public String getProcessbl();
	
	/**
	 * ���̲��������Ƿ��ϱ���ɫ������ȡ��
	 *
	 * @return rolemanager ���̲��������Ƿ��ϱ���ɫ������
	 */
	public String getRolemanager();
	
	/**
	 * �Ƿ�ȷ��ȡ��
	 *
	 * @return psdconfirm �Ƿ�ȷ��
	 */
	public String getPsdconfirm();
}
