/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �߼�������ʵʱ����������ӿ�
  * ��������: �߼�������ʵʱ����������ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��LVCapacityRealTimeSearchCond������ΪSOC0405SearchCond
  */
public interface SOC0405SearchCond {
	/**
	 * ���͵���ȡ��
	 *
	 * @return lvType_eq ���͵���
	 */
	public String getLvType_eq();
	/**
	 * ����bu����ȡ��
	 *
	 * @return lvType_ne ���͵���
	 */
	public String getLvType_ne();
	/**
	 * ״̬����ȡ��
	 *
	 * @return lvState_eq ״̬����
	 */
	public String getLvState_eq();
	/**
	 * �ļ�ϵͳ���ֲ�����ȡ��
	 *
	 * @return fsName_neq �ļ�ϵͳ���ֲ�����
	 */
	public String getFsName_neq();
	/**
	 * vg���ֵ���ȡ��
	 *
	 * @return vgName_eq vg���ֵ���
	 */
	public String getVgName_eq();
	/**
	 * �������Ƶ���ȡ��
	 *
	 * @return hostName_eq �������Ƶ���
	 */
	public String getHostName_eq();
}