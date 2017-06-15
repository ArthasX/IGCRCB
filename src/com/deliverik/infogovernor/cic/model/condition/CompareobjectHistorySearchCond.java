/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * 概述: 对比对象历史表检索条件接口
  * 功能描述: 对比对象历史表检索条件接口
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
public interface CompareobjectHistorySearchCond {

    /** 
     * 对比规则外键 取得
     * @return fkCrid_eq 对比规则外键 
     */
    public Integer getFkCrid_eq();
    
    /** 
     * 对比规则版本 取得
     * @return crversion_eq 对比规则版本 
     */
    public Integer getCrversion_eq();

    /** 
     * 对比id 取得
     * @return crversion_eq 对比id
     */
    public Integer getCoid_eq();

}