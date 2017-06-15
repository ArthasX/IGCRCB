/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:相关资产流程统计汇总统计查询条件接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG359SearchCond {

	/**
	 * 功能：相关资产流程编码取得
	 * @return prassetcategory 相关资产流程编码
	 */
	public String getPrassetcategory();
	
	/**
	 * 功能：统计查询时间_到取得
	 * @return propentime_to 统计查询时间_到
	 */
	public String getPropentime_to();
	
	/**
	 * 功能：统计查询时间_从取得
	 * @return propentime_from
	 */
	public String getPropentime_from();
	
	

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
