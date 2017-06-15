/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sta.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 工作监督查询Form
 *
 */
@SuppressWarnings("serial")
public class IGSTA0102Form extends BaseForm {
	
	/** 问题标题 */
	protected String prtitle;
	
	/** 问题描述 */
	protected String prdesc;
	
	/** 问题发起时间从 */
	protected String propentime_from;
	
	/** 问题发起时间到 */
	protected String propentime_to;
	
	/** 问题状态 */
	protected String prstatus;
	
	/** 问题查询状态 */
	protected String questionstatus;

	/** 问题分类*/
	protected String category;

    protected String rcclass;
    
    protected String rcsourse;
    
	
	/**
	 * 问题标题取得
	 * @return prtitle 问题标题
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 问题标题设定
	 * @param prtitle 问题标题
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 问题描述取得
	 * @return prdesc 问题描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 问题描述设定
	 * @param prdesc 问题描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * 问题发起时间从取得
	 * @return propentime_from 问题发起时间从
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * 问题发起时间从设定
	 * @param propentime_from 问题发起时间从
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * 问题发起时间到取得
	 * @return propentime_to 问题发起时间到
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * 问题发起时间到设定
	 * @param propentime_to 问题发起时间到
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}

	/**
	 * 问题状态取得
	 * @return prstatus 问题状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 问题状态设定
	 * @param prstatus 问题状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 问题查询状态取得
	 * @return questionstatus 问题查询状态
	 */
	public String getQuestionstatus() {
		return questionstatus;
	}

	/**
	 * 问题查询状态设定
	 * @param questionstatus 问题查询状态
	 */
	public void setQuestionstatus(String questionstatus) {
		this.questionstatus = questionstatus;
	}

    /**
     * 问题分类取得
     *
     * @return category 问题分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 问题分类设定
     *
     * @param category 问题分类
     */
    public void setCategory(String category) {
        this.category = category;
    }

	public String getRcclass() {
		return rcclass;
	}

	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	public String getRcsourse() {
		return rcsourse;
	}

	public void setRcsourse(String rcsourse) {
		this.rcsourse = rcsourse;
	}
    

}
