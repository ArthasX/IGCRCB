/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.parameter;

import java.util.List;

/**
 * �ʲ������Ϣ
 */
public interface EntityItemInfo {

	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname();
	
	/**
	 * �ʲ�˵��ȡ��
	 * @return �ʲ�˵��
	 */
	public String getEidesc();
	
	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel();
	
	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding();
	
	/**
	 * �ʲ�����ģ�Ͳ����ȡ��
	 * @return �ʲ�����ģ�Ͳ����
	 */
	public String getEsyscoding();
	
	/**
	 * �ʲ�������IDȡ��
	 * @return �ʲ�������ID
	 */
	public String getEiuserid();
	
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiusername();
	
	/**
	 * �ʲ�״̬ȡ��
	 * @return �ʲ�״̬
	 */
	public String getEistatus();
	
	/**
	 * ʱ���ȡ��
	 * @return ʱ���
	 */
	public String getFingerPrint();
	
	/**
	 * �ʲ�����������Ϣȡ��
	 * @return �ʲ�����������Ϣ
	 */
	public List<EntityItemConfigValueInfo> getConfigItems();
	
	/**
	 * �����Ǽ���ȡ��
	 * @return eiinsdate  �����Ǽ���
	 */
	public String getEiinsdate();
}
