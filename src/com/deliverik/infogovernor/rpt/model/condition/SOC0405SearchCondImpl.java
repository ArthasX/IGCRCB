/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �߼�������ʵʱ���������ʵ��
  * ��������: �߼�������ʵʱ���������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��LVCapacityRealTimeSearchCondImpl������ΪSOC0405SearchCondImpl
  */
public class SOC0405SearchCondImpl implements
		SOC0405SearchCond {
	/**���Ͳ�����*/
	protected String lvType_ne;
	/**���͵���*/
	protected String lvType_eq;
	/**״̬����*/
	protected String lvState_eq;
	/**�ļ�ϵͳ���ֲ�����*/
	protected String fsName_neq;
	/**vg���ֵ���*/
	protected String vgName_eq;
	/**�������Ƶ���*/
	protected String hostName_eq;

	/**
	 * ���Ͳ�����ȡ��
	 *
	 * @return lvType_ne ���Ͳ�����
	 */
	public String getLvType_ne() {
		return lvType_ne;
	}
	/**
	 * ���Ͳ������趨
	 *
	 * @param lvType_ne ���Ͳ�����
	 */
	public void setLvType_ne(String lvType_ne) {
		this.lvType_ne = lvType_ne;
	}
	/**
	 * ״̬����ȡ��
	 *
	 * @return lvState_eq ״̬����
	 */
	public String getLvState_eq() {
		return lvState_eq;
	}
	/**
	 * ״̬�����趨
	 *
	 * @param lvState_eq ״̬����
	 */
	public void setLvState_eq(String lvState_eq) {
		this.lvState_eq = lvState_eq;
	}
	/**
	 * �ļ�ϵͳ���ֲ�����ȡ��
	 *
	 * @return fsName_neq �ļ�ϵͳ���ֲ�����
	 */
	public String getFsName_neq() {
		return fsName_neq;
	}
	/**
	 * �ļ�ϵͳ���ֲ������趨
	 *
	 * @param fsName_neq �ļ�ϵͳ���ֲ�����
	 */
	public void setFsName_neq(String fsName_neq) {
		this.fsName_neq = fsName_neq;
	}
	/**
	 * vg���ֵ���ȡ��
	 *
	 * @return vgName_eq vg���ֵ���
	 */
	public String getVgName_eq() {
		return vgName_eq;
	}
	/**
	 * vg���ֵ����趨
	 *
	 * @param vgName_eq vg���ֵ���
	 */
	public void setVgName_eq(String vgName_eq) {
		this.vgName_eq = vgName_eq;
	}
	/**
	 * �������Ƶ���ȡ��
	 *
	 * @return hostName_eq �������Ƶ���
	 */
	public String getHostName_eq() {
		return hostName_eq;
	}
	/**
	 * �������Ƶ����趨
	 *
	 * @param hostName_eq �������Ƶ���
	 */
	public void setHostName_eq(String hostName_eq) {
		this.hostName_eq = hostName_eq;
	}
	/**
	 * ���͵���ȡ��
	 *
	 * @return lvType_eq ���͵���
	 */
	public String getLvType_eq() {
		return lvType_eq;
	}
	/**
	 * ���͵����趨
	 *
	 * @param lvType_eq ���͵���
	 */
	public void setLvType_eq(String lvType_eq) {
		this.lvType_eq = lvType_eq;
	}
	
	
}