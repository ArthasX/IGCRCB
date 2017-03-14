/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ��ʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentTypeVWInfo {

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();

	/**
	 * OA�칫ȡ��
	 * @return oaWork OA�칫
	 */
	public Integer getOaWork();

	/**
	 * �û���������ȡ��
	 * @return userNameOrPassWord �û���������
	 */
	public Integer getUserNameOrPassWord();

	/**
	 * ���ʹ���ȡ��
	 * @return materialsManager ���ʹ���
	 */
	public Integer getMaterialsManager();

	/**
	 * ���ﵼҽȡ��
	 * @return triageDaoYi ���ﵼҽ
	 */
	public Integer getTriageDaoYi();

	/**
	 * �������ȡ��
	 * @return netWorkMalfunction �������
	 */
	public Integer getNetWorkMalfunction();

	/**
	 * ������ʧ�һ�ȡ��
	 * @return casesOfLossBack ������ʧ�һ�
	 */
	public Integer getCasesOfLossBack();

	/**
	 * �����Э��ȡ��
	 * @return computerHelp �����Э��
	 */
	public Integer getComputerHelp();

	/**
	 * ��ʿ����վȡ��
	 * @return nurseWorkstation ��ʿ����վ
	 */
	public Integer getNurseWorkstation();
	
	/**
	 * ��ظ澯ȡ��
	 * @return prossessingErrorAlarm ��ظ澯
	 */
	public Integer getProssessingErrorAlarm();
}
