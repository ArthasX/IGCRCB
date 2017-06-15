package com.deliverik.framework.model.condition;

import java.util.List;

/**
 * 数据信息查询条件实现
 * 
 */
public class CodeDetailSearchCondImpl implements CodeDetailSearchCond {

	/** 分类CD */
	protected String ccid ;
	
	/** 数据CD */
	protected String cid;
	
	/** 分类CD(父) */
	protected String pccid;

	/** 数据CD(父) */
	protected String pcid;
	
	/** 数据CD状态 */
	protected String cdstatus;
	
	/** 查询指定结点的下级树 */
	protected String syscoding_q;
	
	/** 查询指定结点 */
	protected String syscoding;
	
	/**资产关联关系用条件*/
	protected String businesscode_like;
	
	/** 级次 */
	protected String clevel;
	
	protected String cvalue;
	
	protected String cdinfo_eq;
	
	protected List<String> cidList;
	
	public List<String> getCidList() {
		return cidList;
	}

	public void setCidList(List<String> cidList) {
		this.cidList = cidList;
	}

	public String getCdinfo_eq() {
		return cdinfo_eq;
	}

	public void setCdinfo_eq(String cdinfo_eq) {
		this.cdinfo_eq = cdinfo_eq;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public String getSyscoding() {
		return syscoding;
	}

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	public String getClevel() {
		return clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	public String getSyscoding_q() {
		return syscoding_q;
	}

	public void setSyscoding_q(String syscoding_q) {
		this.syscoding_q = syscoding_q;
	}

	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 数据分类CD设定
	 *
	 * @param ccid 数据分类CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 数据CD取得
	 * @return 数据CD
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 数据CD设定
	 *
	 * @param cid 数据CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 数据分类CD(父)取得
	 * @return 数据分类CD(父)
	 */
	public String getPccid() {
		return pccid;
	}

	/**
	 * 数据分类CD(父)设定
	 *
	 * @param pccid 数据分类CD(父)
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	/**
	 * 数据CD(父)取得
	 * @return 数据CD(父)
	 */
	public String getPcid() {
		return pcid;
	}

	/**
	 * 数据CD(父)设定
	 *
	 * @param pcid 数据CD(父)
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	/**
	 * 数据CD状态取得
	 * @return 数据CD状态
	 */
	public String getCdstatus() {
		return cdstatus;
	}
	/**
	 * 数据CD状态设定
	 *
	 * @param cdstatus 数据CD状态
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}
	/**
	 * 资产关联关系用条件取得
	 * @return 资产关联关系用条件
	 */
	public String getBusinesscode_like() {
		return businesscode_like;
	}
	/**
	 * 资产关联关系用条件设定
	 *
	 * @param businesscode_like 资产关联关系用条件
	 */
	public void setBusinesscode_like(String businesscode_like) {
		this.businesscode_like = businesscode_like;
	}
	
}
