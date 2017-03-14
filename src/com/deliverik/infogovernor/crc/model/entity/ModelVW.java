package com.deliverik.infogovernor.crc.model.entity;

/**
 * 
 * 功能：封装页面所需要的元素的javaBean
 * @author 史凯龙   2014-7-24
 */
public class ModelVW {
	
	private String type;
	
	private String typeid;
	
	
	private Integer wordSum;
	
	private Integer dowSum = 0;
	
	private Integer readSum;

	public String getType() {
		return type;
	}

	public Integer getDowSum() {
		return dowSum;
	}

	public void setDowSum(Integer dowSum) {
		this.dowSum = dowSum;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getWordSum() {
		return wordSum;
	}

	public void setWordSum(Integer wordSum) {
		this.wordSum = wordSum;
	}

	
	/**
	 * @return the typeid
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public Integer getReadSum() {
		return readSum;
	}

	public void setReadSum(Integer readSum) {
		this.readSum = readSum;
	}
	
	
}
