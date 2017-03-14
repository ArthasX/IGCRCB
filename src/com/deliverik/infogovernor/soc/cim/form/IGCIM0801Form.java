package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;



/**
 * 摩卡登录画面用FORM
 * IGCIM0801Form ActionForm
 */
public class IGCIM0801Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	protected String j_username;
	protected String j_password;
	protected String url;
	//页面跳转标识
	protected String goPage;
	/**
	 * j_username取得
	 *
	 * @return j_username j_username
	 */
	public String getJ_username() {
		return j_username;
	}
	/**
	 * j_password取得
	 *
	 * @return j_password j_password
	 */
	public String getJ_password() {
		return j_password;
	}
	/**
	 * j_username设定
	 *
	 * @param j_username j_username
	 */
	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}
	/**
	 * j_password设定
	 *
	 * @param j_password j_password
	 */
	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}
	/**
	 * url取得
	 *
	 * @return url url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * url设定
	 *
	 * @param url url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 页面跳转标识取得
	 * 
	 * @return 页面跳转标识
	 */
	public String getGoPage() {
		return goPage;
	}
	
	/**
	 * 页面跳转标识设定
	 * 
	 * @param goPage 页面跳转标识
	 */
	public void setGoPage(String goPage) {
		this.goPage = goPage;
	}
	
}
