package com.deliverik.infogovernor.drm.form;

import java.util.Map;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

/**
 * 资产配置项信息版本比较显示画面FORM
 * 
 */
@SuppressWarnings("serial")
public class IGDRM05031Form extends BaseForm implements SOC0107SearchCond{


	/** 标识哪种资产信息，在标题栏显示 */
	protected String  assetsName;
	
	/** 资产ID */
	protected String eiid;
	
	/** 资产配置版本 */
	protected String civersion;
	
	/** 分辨率 */
	protected Integer screenWidth;

	/** 资产属性小版本号*/
	protected String cismallversion;
	
	/** 子资产版本集合*/
	protected Map<String, String> cldVersionMap;
	
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
	 * 资产配置版本取得
	 * @return 资产配置版本
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * 资产配置版本设定
	 *
	 * @param civersion 资产配置版本
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}


	public String getEid() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCid() {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer getScreenWidth() {
		return screenWidth;
	}


	public void setScreenWidth(Integer screenWidth) {
		this.screenWidth = screenWidth;
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


	public String[] getCids() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getAssetsName() {
		return assetsName;
	}


	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}


}
