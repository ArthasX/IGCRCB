package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 功能：
 * @author 史凯龙   2014-7-22
 */
public class IGCRC1303Form extends BaseForm{
	
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
	
	/** 传入部门*/
	protected String type;
	
	
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
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getEiSort() {
		return eiSort;
	}
	
	public void setEiSort(String eiSort) {
		this.eiSort = eiSort;
	}
	
}
