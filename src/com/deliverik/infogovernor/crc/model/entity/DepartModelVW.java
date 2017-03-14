package com.deliverik.infogovernor.crc.model.entity;

/**
 * 
 * 功能:封装页面所需要的元素的javaBean
 * @author 史凯龙   2014-7-24
 */
public class DepartModelVW {
	
	private String departType;
	
	private String einame;
	
	private String prid;
	
	private Integer wordSum;
	
	private String eiid;
	
	private Integer dowSum = 0;
	
	private Integer readSum;

	public Integer getDowSum() {
		return dowSum;
	}

	public void setDowSum(Integer dowSum) {
		this.dowSum = dowSum;
	}

	public String getDepartType() {
		return departType;
	}

	public void setDepartType(String departType) {
		this.departType = departType;
	}

	public Integer getWordSum() {
		return wordSum;
	}

	public void setWordSum(Integer wordSum) {
		this.wordSum = wordSum;
	}

	public Integer getReadSum() {
		return readSum;
	}

	public void setReadSum(Integer readSum) {
		this.readSum = readSum;
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
	 * @return the einame
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * @param einame the einame to set
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * @return the prid
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * @param prid the prid to set
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}
	
	
	
}
