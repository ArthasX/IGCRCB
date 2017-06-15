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
	 * 文档编号取得
	 * @return eiNumber 文档编号
	 */
	public String getEiNumber();

	/**
	 * 文档名称取得
	 * @return eiName 文档名称
	 */
	public String getEiName();

	/**
	 * 文档类型取得
	 * @return eiType 文档类型
	 */
	public String getEiType();


	/**
	 * 文档密级取得
	 * @return eiDense 文档密级
	 */
	public String getEiDense();

	/**
	 * 部门取得
	 * @return department 部门
	 */
	public String getDepartment();

	/**
	 * 管理人取得
	 * @return managermentPerson 管理人
	 */
	public String getManagermentPerson();

	/**
	 * 内容取得
	 * @return content 内容
	 */
	public String getContent();
	
	/**
	 * 存储方式取得
	 * @return storageWay 存储方式
	 */
	public String getStorageWay();

	/**
	 * 存放位置取得
	 * @return storageLocation 存放位置
	 */
	public String getStorageLocation();

	
	public Integer getDdid();
	
	public void setDdid(Integer ddid);

	public String getCivalue();

	public void setCivalue(String civalue);

}
