/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 流程快捷发起Form
 * @Author
 * @History 
 * @Version
 */
@SuppressWarnings("serial")
public class IGCOM0401Form extends BaseForm {

	/** 流程ID（主动） */
	protected Integer parprid;
	
	/** 流程类型ID */
	protected String prpdid;
	
	/** 流程类型 */
	protected String prtype;
	
	/** 是否流程模板，1是0否 */
	protected String flag;
	
	/** 流程发起url */
	protected String url;
	
	/** 跳转JSP类型*/
	protected String pjdtype;
	
	/** 流程类型ID */
	protected String ptid;

	/** 流程发起其他参数 */
    protected String parameters;
    
    protected String date;
    
    protected String path;
    
	/**
	 * 流程ID（主动）取得
	 * 
	 * @return 流程ID（主动）
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * 流程ID（主动）设定
	 * 
	 * @param prid 流程ID（主动）
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * 流程类型取得
	 * 
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 * 
	 * @param prtype 流程ID
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程类型ID取得
	 * 
	 * @return 流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程类型ID设定
	 * 
	 * @param prpdid 流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 是否流程模板取得
	 * 
	 * @return 是否流程模板
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 是否流程模板设定
	 * 
	 * @param flag 是否流程模板
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 流程发起url取得
	 * 
	 * @return 流程发起url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 流程发起url设定
	 * 
	 * @param url 流程发起url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 流程类型ID取得
	 * @return 流程类型ID
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
     * @return the 流程发起其他参数
     */
    public String getParameters() {
        return parameters;
    }

    /**
     * @param 流程发起其他参数 the parameters to set
     */
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPath() {
		return path;
	}

	
	/**
	 * @return the pjdtype
	 */
	public String getPjdtype() {
		return pjdtype;
	}

	/**
	 * @param pjdtype the pjdtype to set
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
