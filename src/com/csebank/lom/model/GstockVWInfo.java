/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;


/**
 * 
 * ���Ԥ����Ϣ��ͼʵ��ӿ�
 *
 */
public interface GstockVWInfo {

	/**
	 * ��Ʒ��ϢIDȡ��
	 * @return ��Ʒ��ϢID
	 */
	public Integer getGid();

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGcategory();

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGname();

	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGcode();

	/**
	 * Ԥ����ʾ����ȡ��
	 * @return Ԥ����ʾ����
	 */
	public Integer getGwarningnum();

	/**
	 * ��Ʒ�ڲ�ת�ƶ��ۣ�%��ȡ��
	 * @return ��Ʒ�ڲ�ת�ƶ��ۣ�%��
	 */
	public Double getGprice();

	/**
	 * ״̬��0:ͣ�� 1:���ã�ȡ��
	 * @return ״̬��0:ͣ�� 1:���ã�
	 */
	public String getGstatus();

	
	/**
	 * ��Ʒ�����ϢIDȡ��
	 * @return ��Ʒ�����ϢID
	 */
	public Integer getGsid();
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public Integer getGsnum();
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGsorg();
	/**
	 * �ɹ�ƽ����ȡ��
	 * @return �ɹ�ƽ����
	 */
	public String getGsavgprice();
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGsfreezenum();

}
