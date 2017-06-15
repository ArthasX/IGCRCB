/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 服务工单日志查询条件实现
 */
public class IG711SearchCondImpl implements IG711SearchCond {
	
	/** 授权开始日期_从 */
	protected String pabegintime_f;
	
	/** 授权开始日期_到 */
	protected String pabegintime_t;
	
	/** 授权标识位 */
	protected String paflag;
	
	/** 授权人*/
	protected String paiid;
	
	/** 授权类型 */
	protected String patype;
	
	/** 登录用户的id */
	protected String loginUser;
	
	/** 授权标识位 */
	protected String nopaflag;
	
	
	/**
	 * 登录用户的id取得
	 * @return 登录用户的id
	 */
	public String getLoginUser() {
		return loginUser;
	}
	/**
	 * 登录用户的id设定
	 *
	 * @param loginUser 登录用户的id
	 */
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	
	/**
	 * 授权标识位取得
	 * @return 授权标识位
	 */
	public String getPaflag() {
		return paflag;
	}

	/**
	 * 授权标识位设定
	 *
	 * @param paflag 授权标识位
	 */
	public void setPaflag(String paflag) {
		this.paflag = paflag;
	}

	/**
	 * 授权开始日期_从取得
	 * @return 授权开始日期_从
	 */
	public String getPabegintime_f() {
		return pabegintime_f;
	}

	/**
	 * 授权开始日期_到设定
	 *
	 * @param pabegintime_f 授权开始日期_到
	 */
	public void setPabegintime_f(String pabegintime_f) {
		this.pabegintime_f = pabegintime_f;
	}

	/**
	 * 授权开始日期_到取得
	 * @return 授权开始日期_到
	 */
	public String getPabegintime_t() {
		return pabegintime_t;
	}

	/**
	 * 授权开始日期_到设定
	 *
	 * @param pabegintime_t 授权开始日期_到
	 */
	public void setPabegintime_t(String pabegintime_t) {
		this.pabegintime_t = pabegintime_t;
	}
	
	/**
	 * 授权人取得
	 * @return 授权人
	 */
	public String getPaiid() {
		return paiid;
	}

	/**
	 * 授权人设定
	 *
	 * @param paiid 授权人
	 */
	public void setPaiid(String paiid) {
		this.paiid = paiid;
	}

	/**
	 * 授权类型取得
	 * 
	 * @return 授权类型
	 */
	public String getPatype() {
		return patype;
	}

	/**
	 * 授权类型设定
	 *
	 * @param paflag 授权类型
	 */
	public void setPatype(String patype) {
		this.patype = patype;
	}
	
	/**
	 * 授权标识位取得
	 * @return 授权标识位
	 */
	public String getNopaflag() {
		return nopaflag;
	}
	
	/**
	 * 授权标识位设定
	 * @param nopaflag授权标识位
	 */
	public void setNopaflag(String nopaflag) {
		this.nopaflag = nopaflag;
	}

}
