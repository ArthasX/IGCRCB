/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:流程年度汇总统计查询条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG003SearchCondImpl implements IG003SearchCond {
	
	/** 当前年份*/
	protected String currentyear;
	
	/** 去年年份*/
	protected String precedingyear;

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
	 * 功能：当前年份取得
	 * @return currentyear 当前年份
	 */
	public String getCurrentyear() {
		return currentyear;
	}

	/**
	 * 功能：当前年份取得
	 * @param currentyear 当前年份
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

	/**
	 * 功能：上一年年份取得
	 * @return precedingyear 上一年年份
	 */
	public String getPrecedingyear() {
		return precedingyear;
	}

	/**
	 * 功能：上一年年份取得
	 * @param precedingyear 上一年年份
	 */
	public void setPrecedingyear(String precedingyear) {
		this.precedingyear = precedingyear;
	}
	
}
