package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 检查项配置信息历史记录画面FORM
 * 
 */
public class IGRIS0605Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** 检查项ID */
	protected Integer eiid;
	
	/** 检查项配置版本 */
	protected String civersion;
	
	/** 资产属性小版本号*/
	protected String cismallversion;
	
	/**
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * 检查项ID设定
	 *
	 * @param eiid 检查项ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 检查项配置版本取得
	 * @return 检查项配置版本
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * 检查项配置版本设定
	 *
	 * @param civersion 检查项配置版本
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
