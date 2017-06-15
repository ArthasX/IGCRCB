/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利
 */
package com.deliverik.framework.soc.asset.model.entity;


/**
 * 概述: 
 * 功能描述: 
 * 创建记录: 杨龙全 2012-7-25
 * 修改记录: 
 */
public class CodeDetailEntity {
	/** 数据分类CD */
	protected String ccid ;
	
	/** 数据CD */
	protected String cid;
	
	/** 数据内容 */
	protected String cvalue;

	/** 数据分类编号(父) */
	protected String pccid;

	/** 数据编号(父) */
	protected String pcid;

	/** 更新时间 */
	protected String updtime;
	
	/** 层次码 */
	public String syscoding;
	
	/** 上级层次码 */
	public String psyscoding;
	
	/** 状态 0-停用，1-启用 */
	public String cdstatus;
	
	/** 数据业务码 */
	public String businesscode;
	
	/** 数据说明 */
	public String cdinfo;

	/**
	 * 数据分类CD取得
	 *
	 * @return ccid 数据分类CD
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
	 *
	 * @return cid 数据CD
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
	 * 数据内容取得
	 *
	 * @return cvalue 数据内容
	 */
	public String getCvalue() {
		return cvalue;
	}

	/**
	 * 数据内容设定
	 *
	 * @param cvalue 数据内容
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	/**
	 * 数据分类编号(父)取得
	 *
	 * @return pccid 数据分类编号(父)
	 */
	public String getPccid() {
		return pccid;
	}

	/**
	 * 数据分类编号(父)设定
	 *
	 * @param pccid 数据分类编号(父)
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	/**
	 * 数据编号(父)取得
	 *
	 * @return pcid 数据编号(父)
	 */
	public String getPcid() {
		return pcid;
	}

	/**
	 * 数据编号(父)设定
	 *
	 * @param pcid 数据编号(父)
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	/**
	 * 更新时间取得
	 *
	 * @return updtime 更新时间
	 */
	public String getUpdtime() {
		return updtime;
	}

	/**
	 * 更新时间设定
	 *
	 * @param updtime 更新时间
	 */
	public void setUpdtime(String updtime) {
		this.updtime = updtime;
	}

	/**
	 * 层次码取得
	 *
	 * @return syscoding 层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * 层次码设定
	 *
	 * @param syscoding 层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * 上级层次码取得
	 *
	 * @return psyscoding 上级层次码
	 */
	public String getPsyscoding() {
		return psyscoding;
	}

	/**
	 * 上级层次码设定
	 *
	 * @param psyscoding 上级层次码
	 */
	public void setPsyscoding(String psyscoding) {
		this.psyscoding = psyscoding;
	}

	/**
	 * 状态0-停用，1-启用取得
	 *
	 * @return cdstatus 状态0-停用，1-启用
	 */
	public String getCdstatus() {
		return cdstatus;
	}

	/**
	 * 状态0-停用，1-启用设定
	 *
	 * @param cdstatus 状态0-停用，1-启用
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}

	/**
	 * 数据业务码取得
	 *
	 * @return businesscode 数据业务码
	 */
	public String getBusinesscode() {
		return businesscode;
	}

	/**
	 * 数据业务码设定
	 *
	 * @param businesscode 数据业务码
	 */
	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}

	/**
	 * 数据说明取得
	 *
	 * @return cdinfo 数据说明
	 */
	public String getCdinfo() {
		return cdinfo;
	}

	/**
	 * 数据说明设定
	 *
	 * @param cdinfo 数据说明
	 */
	public void setCdinfo(String cdinfo) {
		this.cdinfo = cdinfo;
	}
	
	
}
