/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

/**
 * ����:ͬ���澯ϵͳ��ͼ�ӿ�
 * ��������: ͬ���澯ϵͳ��ͼ�ӿ�
 * �����ˣ�����
 * ������¼: 2014/04/03
 * �޸ļ�¼: 
 */

public interface SynchronizationAlarmSystemVWInfo {

	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getRid();
	
	/**
	 * ��ͬ��ϵͳidȡ��
	 *
	 * @return ��ͬ��ϵͳid
	 */
	public Integer getIlsid();
	
	/**
	 * ��ͬ��ϵͳ����ȡ��
	 *
	 * @return ��ͬ��ϵͳ����
	 */
	public String getIlsname();
	
	/**
	 * ��ͬ��ϵͳ����ȡ��
	 *
	 * @return ��ͬ��ϵͳ����
	 */
	public String getEaname();
}
