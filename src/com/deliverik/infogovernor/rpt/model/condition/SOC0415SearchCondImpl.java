/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ��ռ�����ʵʱ���������ʵ��
  * ��������: ��ռ�����ʵʱ���������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��TSCapacityRealTimeSearchCondImpl�����޸�ΪSOC0415SearchCondImpl
  */
public class SOC0415SearchCondImpl implements
		SOC0415SearchCond {
	/**���ݿ����ֵ���*/
	protected String dbName_eq;
	/**�������ֵ���*/
	protected String hostName_eq;
	/**
	 * ���ݿ����ֵ���ȡ��
	 *
	 * @return dbName_eq ���ݿ����ֵ���
	 */
	public String getDbName_eq() {
		return dbName_eq;
	}
	/**
	 * ���ݿ����ֵ����趨
	 *
	 * @param dbName_eq ���ݿ����ֵ���
	 */
	public void setDbName_eq(String dbName_eq) {
		this.dbName_eq = dbName_eq;
	}
	/**
	 * �������ֵ���ȡ��
	 *
	 * @return hostName_eq �������ֵ���
	 */
	public String getHostName_eq() {
		return hostName_eq;
	}
	/**
	 * �������ֵ����趨
	 *
	 * @param hostName_eq �������ֵ���
	 */
	public void setHostName_eq(String hostName_eq) {
		this.hostName_eq = hostName_eq;
	}
	
	
}