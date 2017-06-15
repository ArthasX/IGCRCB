/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 相关流程发起Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0306Form extends BaseForm{

	/** 主流程ID */
	protected Integer parprid;
	
	/** 流程类型ID */
	protected String prpdid;
	
	/** 流程类型 */
	protected String prtype;
	
	/** 流程发起url */
	protected String url;
	
	/** 流程类型ID */
	protected String ptid;

	/** 流程发起其他参数 */
    protected String parameters;

	/**
	 * 主流程ID取得
	 * @return parprid 主流程ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * 主流程ID设定
	 * @param parprid 主流程ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * 流程类型ID取得
	 * @return prpdid 流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程类型ID设定
	 * @param prpdid 流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程类型取得
	 * @return prtype 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程发起url取得
	 * @return url 流程发起url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 流程发起url设定
	 * @param url 流程发起url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 流程类型ID取得
	 * @return ptid 流程类型ID
	 */
	public String getPtid() {
		return ptid;
	}

	/**
	 * 流程类型ID设定
	 * @param ptid 流程类型ID
	 */
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	/**
	 * 流程发起其他参数取得
	 * @return parameters 流程发起其他参数
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * 流程发起其他参数设定
	 * @param parameters 流程发起其他参数
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
