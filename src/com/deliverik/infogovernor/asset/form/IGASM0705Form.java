package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 机房配置信息历史记录画面FORM
 * 
 */
public class IGASM0705Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** 机房ID */
	protected Integer eiid;
	
	/** 机房配置版本 */
	protected String civersion;

	/** 资产属性小版本号*/
	protected String cismallversion;
	
	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * 机房ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 机房配置版本取得
	 * @return 机房配置版本
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * 机房配置版本设定
	 *
	 * @param civersion 机房配置版本
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}


	public Integer getCid() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEid() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCivalue() {
		// TODO Auto-generated method stub
		return null;
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
