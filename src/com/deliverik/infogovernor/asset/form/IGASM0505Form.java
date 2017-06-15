package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 文档配置信息历史记录画面FORM
 * 
 */
public class IGASM0505Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** 文档ID */
	protected Integer eiid;
	
	/** 文档配置版本 */
	protected String civersion;
	
	/** 资产属性小版本号*/
	protected String cismallversion;
	
	/**
	 * 文档ID取得
	 * @return 文档ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * 文档ID设定
	 *
	 * @param eiid 文档ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 文档配置版本取得
	 * @return 文档配置版本
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * 文档配置版本设定
	 *
	 * @param civersion 文档配置版本
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
