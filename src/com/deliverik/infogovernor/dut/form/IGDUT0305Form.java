/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;

/**
 * 概述: 日常维护查询画面Form
 * 功能描述: 日常维护查询画面Form
 * 创建记录: 2012/04/01
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGDUT0305Form extends BaseForm implements OnDutyPersonRecordSearchCond{
	
	
	/** 批量删除id数组 */
	protected String[] delall;

	/** 检索关键字 */
	protected String keywords_like;
	
	/** 开始指定日期 */
	protected String odprctime_ge;
	
	/** 结束指定日期 */
	protected String odprctime_le;	
	
    /** 按主键查询取得 */
	protected Integer odprid_eq;
	
	


    /**
	 * 按主键查询取得取得
	 *
	 * @return odprid_eq 按主键查询取得
	 */
	public Integer getOdprid_eq() {
		return odprid_eq;
	}

	/**
	 * 按主键查询取得设定
	 *
	 * @param odprid_eq 按主键查询取得
	 */
	public void setOdprid_eq(Integer odprid_eq) {
		this.odprid_eq = odprid_eq;
	}

	/**
     * 检索关键字取得
     *
     * @return keywords_like 检索关键字
     */
    public String getKeywords_like() {
        return keywords_like;
    }

    /**
     * 检索关键字设定
     *
     * @param keywords_like 检索关键字
     */
    public void setKeywords_like(String keywords_like) {
        this.keywords_like = keywords_like;
    }

    /**
     * 时间条件：从 取得
     * @return 时间条件：从
     */
	public String getOdprctime_ge() {
		return odprctime_ge;
	}

	/**
	 * 时间条件：从设定
	 * @param odprctime_ge时间条件：从
	 */
	public void setOdprctime_ge(String odprctime_ge) {
		this.odprctime_ge = odprctime_ge;
	}

	/**
	 * 时间条件：到取得
	 * @return 时间条件：到
	 */
	public String getOdprctime_le() {
		return odprctime_le;
	}

	/**
	 * 时间条件：到设定
	 * @param odprctime_le时间条件：到
	 */
	public void setOdprctime_le(String odprctime_le) {
		this.odprctime_le = odprctime_le;
	}

	/**
	 * 批量删除id数组取得
	 *
	 * @return delall 批量删除id数组
	 */
	public String[] getDelall() {
		return delall;
	}

	/**
	 * 批量删除id数组设定
	 *
	 * @param delall 批量删除id数组
	 */
	public void setDelall(String[] delall) {
		this.delall = delall;
	}


}
    

