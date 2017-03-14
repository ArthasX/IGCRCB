/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:相关资产流程统计汇总统计查询条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG359SearchCondImpl implements IG359SearchCond {

	/** 资产流程编码*/
	protected String prassetcategory;

	/** 统计查询时间_从*/
	protected String propentime_from;

	/** 统计查询时间_到*/
	protected String propentime_to;

	/** 事件统计模版id*/
	protected String ipdid;
	/** 问题统计模版id*/
	protected String ppdid;
	/** 变更统计模版id*/
	protected String cpdid;
	/** 服务请求统计模版id*/
	protected String spdid;

	/**
	 * 功能：相关资产流程编码取得
	 * @return prassetcategory
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * 功能：相关资产流程编码设定
	 * @param prassetcategory 相关资产流程编码
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * 功能：统计查询时间_从取得
	 * @return propentime_from 统计查询时间_从
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * 功能：统计查询时间_从设定
	 * @param propentime_from 统计查询时间_从
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * 功能：统计查询时间_到取得
	 * @return propentime_to 统计查询时间_到
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * 功能：统计查询时间_到设定
	 * @param propentime_to 统计查询时间_到
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}

    /**
     * 事件统计模版id取得
     *
     * @return ipdid 事件统计模版id
     */
    public String getIpdid() {
        return ipdid;
    }

    /**
     * 事件统计模版id设定
     *
     * @param ipdid 事件统计模版id
     */
    public void setIpdid(String ipdid) {
        this.ipdid = ipdid;
    }

    /**
     * 问题统计模版id取得
     *
     * @return ppdid 问题统计模版id
     */
    public String getPpdid() {
        return ppdid;
    }

    /**
     * 问题统计模版id设定
     *
     * @param ppdid 问题统计模版id
     */
    public void setPpdid(String ppdid) {
        this.ppdid = ppdid;
    }

    /**
     * 变更统计模版id取得
     *
     * @return cpdid 变更统计模版id
     */
    public String getCpdid() {
        return cpdid;
    }

    /**
     * 变更统计模版id设定
     *
     * @param cpdid 变更统计模版id
     */
    public void setCpdid(String cpdid) {
        this.cpdid = cpdid;
    }

    /**
     * 服务请求统计模版id取得
     *
     * @return spdid 服务请求统计模版id
     */
    public String getSpdid() {
        return spdid;
    }

    /**
     * 服务请求统计模版id设定
     *
     * @param spdid 服务请求统计模版id
     */
    public void setSpdid(String spdid) {
        this.spdid = spdid;
    }
	
	
}
