/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * 概述: 对比记录检索条件接口
  * 功能描述: 对比记录检索条件接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareprocessSearchCond {

    /** 
     * 开始时间Form 取得
     * @return cpstarttime_form 开始时间Form 
     */
    public String getCpstarttime_form();

    /** 
     * 开始时间To 取得
     * @return cpstarttime_to 开始时间To 
     */
    public String getCpstarttime_to();
    
}