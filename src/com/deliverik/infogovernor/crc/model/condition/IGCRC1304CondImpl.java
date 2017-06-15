package com.deliverik.infogovernor.crc.model.condition;

import com.deliverik.infogovernor.crc.form.IGCRC1304Form;

public class IGCRC1304CondImpl implements IGCRC1304Cond{
	
	/** �ĵ����� */
	protected Integer fileNum;
	   
	/** �ĵ���� */
	protected String fileClass;
	
	/** �ĵ����ش��� */
	protected Integer downNum;
	
	/** �ĵ����Ĵ��� */
	protected Integer readNum;
	
	/** �ĵ����� */
	protected String eiSort;
	
	/** �������� */	
	protected String orgparname;
	
	protected String eiid ;
	
	

	public String getOrgparname() {
		return orgparname;
	}

	public void setOrgparname(String orgparname) {
		this.orgparname = orgparname;
	}
	
	
	public IGCRC1304CondImpl(){
		super();
	}
	
	public IGCRC1304CondImpl(IGCRC1304Form form){
		
	}
	public Integer getFileNum() {
		return fileNum;
	}
	
	public void setFileNum(Integer fileNum) {
		this.fileNum = fileNum;
	}
	
	public String getFileClass() {
		return fileClass;
	}
	
	public void setFileClass(String fileClass) {
		this.fileClass = fileClass;
	}
	public Integer getDownNum() {
		return downNum;
	}
	
	public void setDownNum(Integer downNum) {
		this.downNum = downNum;
	}
	
	public Integer getReadNum() {
		return readNum;
	}
	
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}
	
	public String getEiSort() {
		return eiSort;
	}
	
	public void setEiSort(String eiSort) {
		this.eiSort = eiSort;
	}

	
	/** �ĵ���� */
	private String eiNumber;
	
	/** �ĵ����� */
	private String eiName;
	
	/** �ĵ����� */
	private String eiType;
	
	
	/** �ĵ��ܼ� */
	private String eiDense;
	
	/** ���� */
	private String department;
	
	/** ������ */
	private String managermentPerson;
	
	/** ���� */
	private String content;
	
	/** �洢��ʽ */
	private String storageWay;
	
	/** ���λ�� */
	private String storageLocation;
	
	/** �Ƿ������ */
	protected String isDownload;

	/**
	 * �ĵ����ȡ��
	 * @return eiNumber �ĵ����
	 */
	public String getEiNumber() {
		return eiNumber;
	}

	/**
	 * �ĵ�����趨
	 * @param eiNumber �ĵ����
	 */
	public void setEiNumber(String eiNumber) {
		this.eiNumber = eiNumber;
	}

	/**
	 * �ĵ�����ȡ��
	 * @return eiName �ĵ�����
	 */
	public String getEiName() {
		return eiName;
	}

	/**
	 * �ĵ������趨
	 * @param eiName �ĵ�����
	 */
	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	/**
	 * �ĵ�����ȡ��
	 * @return eiType �ĵ�����
	 */
	public String getEiType() {
		return eiType;
	}

	/**
	 * �ĵ������趨
	 * @param eiType �ĵ�����
	 */
	public void setEiType(String eiType) {
		this.eiType = eiType;
	}


	/**
	 * �ĵ��ܼ�ȡ��
	 * @return eiDense �ĵ��ܼ�
	 */
	public String getEiDense() {
		return eiDense;
	}

	/**
	 * �ĵ��ܼ��趨
	 * @param eiDense �ĵ��ܼ�
	 */
	public void setEiDense(String eiDense) {
		this.eiDense = eiDense;
	}

	/**
	 * ����ȡ��
	 * @return department ����
	 */
	public String getDepartment() {
		return department;
	}

	
	/**
	 * @return the eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * @param eiid the eiid to set
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �����趨
	 * @param department ����
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * ������ȡ��
	 * @return managermentPerson ������
	 */
	public String getManagermentPerson() {
		return managermentPerson;
	}

	/**
	 * �������趨
	 * @param managermentPerson ������
	 */
	public void setManagermentPerson(String managermentPerson) {
		this.managermentPerson = managermentPerson;
	}

	/**
	 * ����ȡ��
	 * @return content ����
	 */
	public String getContent() {
		return content;
	}

	/**
	 * �����趨
	 * @param content ����
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * �洢��ʽȡ��
	 * @return storageWay �洢��ʽ
	 */
	public String getStorageWay() {
		return storageWay;
	}

	/**
	 * �洢��ʽ�趨
	 * @param storageWay �洢��ʽ
	 */
	public void setStorageWay(String storageWay) {
		this.storageWay = storageWay;
	}

	/**
	 * ���λ��ȡ��
	 * @return storageLocation ���λ��
	 */
	public String getStorageLocation() {
		return storageLocation;
	}

	/**
	 * ���λ���趨
	 * @param storageLocation ���λ��
	 */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	/**
	 * �Ƿ������ȡ��
	 * @return isDownload �Ƿ������
	 */
	public String getIsDownload() {
		return isDownload;
	}

	/**
	 * �Ƿ�������趨
	 * @param isDownload �Ƿ������
	 */
	public void setIsDownload(String isDownload) {
		this.isDownload = isDownload;
	}
}
