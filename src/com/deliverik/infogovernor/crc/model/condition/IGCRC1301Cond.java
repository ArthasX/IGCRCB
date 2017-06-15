/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
 * ����: �ĵ���ͼ���������ӿ�
 * ��������: �ĵ���ͼ���������ӿ�
 * ������¼: 2014/07/15
 * �޸ļ�¼: 
 */
public interface IGCRC1301Cond {
	/**
	 * �ĵ����ȡ��
	 * @return eiNumber �ĵ����
	 */
	public String getEiNumber();

	/**
	 * �ĵ�����ȡ��
	 * @return eiName �ĵ�����
	 */
	public String getEiName();

	/**
	 * �ĵ�����ȡ��
	 * @return eiType �ĵ�����
	 */
	public String getEiType();

	/**
	 * �ĵ�����ȡ��
	 * @return eiSort �ĵ�����
	 */
	public String getEiSort();

	/**
	 * �ĵ��ܼ�ȡ��
	 * @return eiDense �ĵ��ܼ�
	 */
	public String getEiDense();

	/**
	 * ����ȡ��
	 * @return department ����
	 */
	public String getDepartment();

	/**
	 * ������ȡ��
	 * @return managermentPerson ������
	 */
	public String getManagermentPerson();

	/**
	 * ����ȡ��
	 * @return content ����
	 */
	public String getContent();
	
	/**
	 * �洢��ʽȡ��
	 * @return storageWay �洢��ʽ
	 */
	public String getStorageWay();

	/**
	 * ���λ��ȡ��
	 * @return storageLocation ���λ��
	 */
	public String getStorageLocation();
	
	/**
	 * �Ƿ������ȡ��
	 * @return isDownload �Ƿ������
	 */
	public String getIsDownload();
}
