/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:事件和服务请求流程汇总统计查询条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG019SearchCondImpl implements
		IG019SearchCond {
	
	/** 机构层次码*/
	protected String orgsyscoding;
	
	/** 年度*/
	protected String year;
	
	/** 流程类型*/
	protected String prtype;
	
	/** 事件统计模版id*/
    protected String ipdid;
    /** 问题统计模版id*/
    protected String ppdid;
    /** 变更统计模版id*/
    protected String cpdid;
    /** 服务请求统计模版id*/
    protected String spdid;

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

    /**
	 * 功能：机构层次码取得
	 * @retrun Orgsyscoding 机构层级码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 功能：机构层次吗取得
	 * @param orgsyscoding 机构层次吗
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 功能：年度取得
	 * @return year 年度
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 功能：年度
	 * @param year 年度
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 功能：流程类型
	 * @return prtype 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 功能：流程类型
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

}
