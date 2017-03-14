/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * 概述: 对比规则检索条件接口
  * 功能描述: 对比规则检索条件接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareroleSearchCond {
	
	public Integer getCrsystemid();
	
	public String getCrtype();

    /** 
     * 比对任务表主键 取得
     * @return cpid 比对任务表主键 
     */
    public Integer getCpid();
}