package com.deliverik.framework.asset.model.condition;

/**
 * 资产属性信息检索条件实现
 * 
 */
public class IG800SearchCondImpl implements IG800SearchCond {

	/** 资产ID */
	protected Integer eiid;

	/** 资产模型ID */
	protected String eid;
	
	/** 资产属性版本号 */
	protected String civersion;
	
	/** 资产模型属性ID */
	protected Integer cid;
	
	/** 资产模型属性值 */
	protected String civalue;

	/** 资产属性小版本号*/
	protected String cismallversion;
	
	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public Integer getCid() {
		if(cid==null){
			return 0;
		}
		return cid;
	}

	/**
	 * 资产模型属性ID设定
	 *
	 * @param cid 资产模型属性ID
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
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
	
}
