package com.deliverik.infogovernor.soc.vir.form;



import com.deliverik.framework.base.BaseForm;

/**
 * 设备查询画面FORM
 * 
 */
public class IGVIR0702Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";
	
	/** id */
	protected Integer vcid;
	
	/** 名称 */
	protected String vcname;

	/** URL */
	protected String vcurl;

	/** 用户名 */
	protected String vcusername;

	/** 密码 */
	protected String vcpassword;
	
	
	/**
	 * 获取页面标题显示标志
	 * @return String
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * 设置页面标题显示标志
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * id取得
	 * @return vcid id
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * id设定
	 * @param vcid id
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * 名称取得
	 * @return vcname 名称
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * 名称设定
	 * @param vcname 名称
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
	}

	/**
	 * URL取得
	 * @return vcurl URL
	 */
	public String getVcurl() {
		return vcurl;
	}

	/**
	 * URL设定
	 * @param vcurl URL
	 */
	public void setVcurl(String vcurl) {
		this.vcurl = vcurl;
	}

	/**
	 * 用户名取得
	 * @return vcusername 用户名
	 */
	public String getVcusername() {
		return vcusername;
	}

	/**
	 * 用户名设定
	 * @param vcusername 用户名
	 */
	public void setVcusername(String vcusername) {
		this.vcusername = vcusername;
	}

	/**
	 * 密码取得
	 * @return vcpassword 密码
	 */
	public String getVcpassword() {
		return vcpassword;
	}

	/**
	 * 密码设定
	 * @param vcpassword 密码
	 */
	public void setVcpassword(String vcpassword) {
		this.vcpassword = vcpassword;
	}
}
