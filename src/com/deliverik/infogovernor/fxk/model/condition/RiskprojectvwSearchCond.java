/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * 概述: 风险计划查询Cond
  * 功能描述: 风险计划查询Cond
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public interface RiskprojectvwSearchCond {
    /**计划编号*/
    public String getRisknum_l() ;
    /**计划类型*/
    public String getRisktype_q() ;
    /**计划标题*/
    public String getTitle_l();
    /**计划发起者*/
    public String getPrusername_l();
    /**计划状态*/
    public String getRiskstatus_q();
    /**计划开始时间小于*/
    public String getRiskstart_le();
    /**计划开始时间大于*/
    public String getRiskstart_ge();
}