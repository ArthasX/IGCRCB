package com.deliverik.infogovernor.aim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产模型查询画面FORM
 * 
 */
public class IGAIM0150Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/**ip*/
	protected String ipText;
	/**实例名*/
	protected String appText;
	/**是否包含oracle*/
	protected String oracleFlag;
	
	/**
	 * ip取得
	 * @return ipText ip
	 */
	public String getIpText() {
		return ipText;
	}
	/**
	 * ip设定
	 * @param ipText ip
	 */
	public void setIpText(String ipText) {
		this.ipText = ipText;
	}
	/**
	 * 实例名取得
	 * @return appText 实例名
	 */
	public String getAppText() {
		return appText;
	}
	/**
	 * 实例名设定
	 * @param appText 实例名
	 */
	public void setAppText(String appText) {
		this.appText = appText;
	}
	/**
	 * 是否包含oracle取得
	 * @return oracleFlag 是否包含oracle
	 */
	public String getOracleFlag() {
		return oracleFlag;
	}
	/**
	 * 是否包含oracle设定
	 * @param oracleFlag 是否包含oracle
	 */
	public void setOracleFlag(String oracleFlag) {
		this.oracleFlag = oracleFlag;
	}
}
