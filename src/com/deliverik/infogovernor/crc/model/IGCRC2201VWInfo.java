/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model;

/**
 * @Description: �������ͳ�ƽӿ�
 * @Author zhangqiang
 * @History @2014-8-7�½�
 * 
 * @Version V1.0
 */
public interface IGCRC2201VWInfo{

	/**
	 * typeIdȡ��
	 * @return typeId  typeId
	 */
	public String getTypeId();
	
	/**
	 * ������ȡ��
	 * @return typeName  ������
	 */
	public String getTypeName();

	/**
	 * ����ȡ��
	 * 
	 * @return totalnum ����
	 */
	public Integer getTotalnum();

	/**
	 * ����ͨ������ȡ��
	 * 
	 * @return passnum ����ͨ������
	 */
	public Integer getPassnum();


	/**
	 * �ɹ�����ȡ��
	 * 
	 * @return successnum �ɹ�����
	 */
	public Integer getSuccessnum();

}
