package com.deliverik.infogovernor.crc.model.condition;

import com.deliverik.infogovernor.crc.form.IGCRC1303Form;

public class IGCRC1303CondImpl implements IGCRC1303Cond{
	
	/** 文档总数 */
	protected Integer fileNum;
	   
	/** 文档类别 */
	protected String fileClass;
	
	/** 文档下载次数 */
	protected Integer downNum;
	
	/** 文档借阅次数 */
	protected Integer readNum;
	
	/** 文档分类 */
	protected String eiSort;

	/** 下载表中的主键码*/
	protected Integer ddid;
	
	/** 每个下载项所对应的文档类型*/
	protected String civalue;
	
	public Integer getDdid() {
		return ddid;
	}

	public void setDdid(Integer ddid) {
		this.ddid = ddid;
	}

	public String getCivalue() {
		return civalue;
	}

	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	public IGCRC1303CondImpl(){
		super();
	}
	
	public IGCRC1303CondImpl(IGCRC1303Form form){
		
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

	
	/** 文档编号 */
	private String eiNumber;
	
	/** 文档名称 */
	private String eiName;
	
	/** 文档类型 */
	private String eiType;
	
	
	/** 文档密级 */
	private String eiDense;
	
	/** 部门 */
	private String department;
	
	/** 管理人 */
	private String managermentPerson;
	
	/** 内容 */
	private String content;
	
	/** 存储方式 */
	private String storageWay;
	
	/** 存放位置 */
	private String storageLocation;
	
	/** 是否可下载 */
	protected String isDownload;

	/**
	 * 文档编号取得
	 * @return eiNumber 文档编号
	 */
	public String getEiNumber() {
		return eiNumber;
	}

	/**
	 * 文档编号设定
	 * @param eiNumber 文档编号
	 */
	public void setEiNumber(String eiNumber) {
		this.eiNumber = eiNumber;
	}

	/**
	 * 文档名称取得
	 * @return eiName 文档名称
	 */
	public String getEiName() {
		return eiName;
	}

	/**
	 * 文档名称设定
	 * @param eiName 文档名称
	 */
	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	/**
	 * 文档类型取得
	 * @return eiType 文档类型
	 */
	public String getEiType() {
		return eiType;
	}

	/**
	 * 文档类型设定
	 * @param eiType 文档类型
	 */
	public void setEiType(String eiType) {
		this.eiType = eiType;
	}


	/**
	 * 文档密级取得
	 * @return eiDense 文档密级
	 */
	public String getEiDense() {
		return eiDense;
	}

	/**
	 * 文档密级设定
	 * @param eiDense 文档密级
	 */
	public void setEiDense(String eiDense) {
		this.eiDense = eiDense;
	}

	/**
	 * 部门取得
	 * @return department 部门
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 部门设定
	 * @param department 部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 管理人取得
	 * @return managermentPerson 管理人
	 */
	public String getManagermentPerson() {
		return managermentPerson;
	}

	/**
	 * 管理人设定
	 * @param managermentPerson 管理人
	 */
	public void setManagermentPerson(String managermentPerson) {
		this.managermentPerson = managermentPerson;
	}

	/**
	 * 内容取得
	 * @return content 内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 内容设定
	 * @param content 内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 存储方式取得
	 * @return storageWay 存储方式
	 */
	public String getStorageWay() {
		return storageWay;
	}

	/**
	 * 存储方式设定
	 * @param storageWay 存储方式
	 */
	public void setStorageWay(String storageWay) {
		this.storageWay = storageWay;
	}

	/**
	 * 存放位置取得
	 * @return storageLocation 存放位置
	 */
	public String getStorageLocation() {
		return storageLocation;
	}

	/**
	 * 存放位置设定
	 * @param storageLocation 存放位置
	 */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	/**
	 * 是否可下载取得
	 * @return isDownload 是否可下载
	 */
	public String getIsDownload() {
		return isDownload;
	}

	/**
	 * 是否可下载设定
	 * @param isDownload 是否可下载
	 */
	public void setIsDownload(String isDownload) {
		this.isDownload = isDownload;
	}
}
