/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 流程基本信息
 */
public interface ProcessRecordInfo {

	/**
	 * 流程ID取得
	 * @return 流程ID
	 */
	public Integer getPrid();
	
	/**
	 * 流程定义名称取得
	 * @return 流程定义名称
	 */
	public String getPrpdname();

	/**
	 * 工单号取得
	 *
	 * @return 工单号
	 */
	public String getPrserialnum();

    /**
     * 发起时间取得
     * @return 发起时间
     */
    public String getPropentime();

    /**
     * 关闭时间取得
     * @return 关闭时间
     */
    public String getPrclosetime();

    /**
     * 流程描述取得
     * @return 流程描述
     */
    public String getPrdesc();

    /**
     * 流程状态取得
     * @return 流程状态
     */
    public String getPrstatus();

    /**
     * 流程名称取得
     * @return 流程名称
     */
    public String getPrtitle();
    
    /**
     * 优先级取得
     * @return 优先级
     */
    public String getPrPriority();

	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPrpdid();
	
	/**
	 * 流程类型取得
	 * @return 流程类型
	 */
	public String getPrtype();
	
	/**
	 * 发起角色ID取得
	 * @return prroleid 发起角色ID
	 */
	public Integer getPrroleid();

	/**
	 * 发起用户ID取得
	 * @return pruserid 发起用户ID
	 */
	public String getPruserid();
}
