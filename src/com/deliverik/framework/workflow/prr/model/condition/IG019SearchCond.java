/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:事件和服务请求流程汇总统计查询条件接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG019SearchCond {
	
	/**
	 * 功能：机构层次码取得
	 * @retrun Orgsyscoding 机构层级码
	 */
	public String getOrgsyscoding();
	
	/**
	 * 功能：年度取得
	 * @return year 年度
	 */
	public String getYear();
	
	/**
	 * 功能：流程类型取得
	 * @return prtype 流程类型
	 */
	public String getPrtype();
	
	  /**
     * 事件统计模版id取得
     *
     * @return ipdid 事件统计模版id
     */
    public String getIpdid();
    
    /**
     * 问题统计模版id取得
     *
     * @return ppdid 问题统计模版id
     */
    public String getPpdid();
    
    /**
     * 变更统计模版id取得
     *
     * @return cpdid 变更统计模版id
     */
    public String getCpdid();
    /**
     * 服务请求统计模版id取得
     *
     * @return spdid 服务请求统计模版id
     */
    public String getSpdid();

}
