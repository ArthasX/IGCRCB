/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * 概述: 比对结果检索条件接口
  * 功能描述: 比对结果检索条件接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareresultSearchCond {
    
    /** 
     * 比对对象表主键 取得
     * @return coid_eq 比对对象表主键 
     */
    public Integer getCoid_eq();
    
    /** 
     * 是否是基本属性1：是0：否 取得
     * @return isBase 是否是基本属性1：是0：否 
     */
    public Integer getIsBase();
    /**
     * 对比过程主键取得
     * @return
     */
    public Integer getCpid_eq();
    
    public String getEid();
}