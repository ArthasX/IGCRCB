/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: SOC0107VW检索条件实现
  * 功能描述: SOC0107VW检索条件实现
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public class SOC0107VWSearchCondImpl implements
		SOC0107VWSearchCond {
	/** 数据库ID */
	protected Integer id;
	
	/** 资产ID */
	protected String eiid;

	/** 资产模型ID */
	protected String eid;
	
	/** 资产属性版本号 */
	protected String civersion;
	
	/** 资产模型属性ID */
	protected String cid;
	
	/** 资产模型属性值 */
	protected String civalue;

	/** 资产属性小版本号*/
	protected String cismallversion;
	
	protected String[]  cids;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 资产模型属性ID设定
	 *
	 * @param cid 资产模型属性ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产属性版本号取得
	 * @return 资产属性版本号
	 */
	public String getCiversion() {
		return civersion;
	}

	/**
	 * 资产属性版本号设定
	 *
	 * @param civersion 资产属性版本号
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}
	
	/**
	 * 资产模型属性值取得
	 * @return 资产模型属性值
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * 资产模型属性值设定
	 * @param civalue 资产模型属性值
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}
	
	/**
	 * 资产属性小版本号取得
	 * @return 资产属性小版本号
	 */
	public String getCismallversion() {
		return cismallversion;
	}
	/**
	 * 资产属性小版本号设定
	 *
	 * @param cismallversion 资产属性小版本号
	 */
	public void setCismallversion(String cismallversion) {
		this.cismallversion = cismallversion;
	}

	public String[] getCids() {
		return cids;
	}

	public void setCids(String[] cids) {
		this.cids = cids;
	}
}