package com.deliverik.infogovernor.crc.model.condition;

public interface IGCRC1303Cond {
	
	public Integer getFileNum();
	
	public void setFileNum(Integer fileNum);
	
	public String getFileClass();
	
	public void setFileClass(String fileClass);
	
	public Integer getDownNum();
	
	public void setDownNum(Integer downNum);
	
	public Integer getReadNum();
	
	public void setReadNum(Integer readNum);
	
	public String getEiSort();
	
	public void setEiSort(String eiSort);
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

	
	public Integer getDdid();
	
	public void setDdid(Integer ddid);

	public String getCivalue();

	public void setCivalue(String civalue);

}
