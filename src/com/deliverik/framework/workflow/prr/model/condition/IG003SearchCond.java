/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:流程年度汇总统计查询条件接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG003SearchCond {
	
	/**
	 * 功能：获取当前年份
	 * @return currentyear
	 */
	public String getCurrentyear();
	
	/**
	 * 功能：获取上一年年份
	 * @return precedingyear
	 */
	public String getPrecedingyear();
	
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
