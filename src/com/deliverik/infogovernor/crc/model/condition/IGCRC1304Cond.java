package com.deliverik.infogovernor.crc.model.condition;

public interface IGCRC1304Cond {
	
	public Integer getFileNum();
	
	
	public String getFileClass();
	
	
	public Integer getDownNum();
	
	
	public Integer getReadNum();
	
	public String getEiSort();
	
	public String getEiid();
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
	
	
	
	/** �������� */	
	public String getOrgparname();

	public void setOrgparname(String orgparname);
	
}
