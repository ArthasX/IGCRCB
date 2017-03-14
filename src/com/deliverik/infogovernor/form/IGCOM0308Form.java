package com.deliverik.infogovernor.form;

import java.util.Map;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 配置信息历史记录画面FORM
 * 
 */
public class IGCOM0308Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** 资产ID */
	protected Integer eiid;
	
	/** 配置大版本 */
	protected  String civersion;
	
	/** 配置小版本 */
	protected String cismallversion;
	
	/** 子资产版本集合 */
	protected Map<String, String> cldVersionMap;

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
	 * 配置版本取得
	 * @return 配置版本
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * 配置版本设定
	 *
	 * @param civersion 配置版本
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}


	public String getEid() {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer getCid() {
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


	public Map<String, String> getCldVersionMap() {
		return cldVersionMap;
	}


	public void setCldVersionMap(Map<String, String> cldVersionMap) {
		this.cldVersionMap = cldVersionMap;
	}

}
