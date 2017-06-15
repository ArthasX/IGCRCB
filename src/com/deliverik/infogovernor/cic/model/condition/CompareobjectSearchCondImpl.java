/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * 概述: 对比对象检索条件实现
  * 功能描述: 对比对象检索条件实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public class CompareobjectSearchCondImpl implements
		CompareobjectSearchCond {

    /** 对比规则外键 */
    protected Integer fkCrid_eq;

    /** 对比规则版本 */
    protected String crversion_eq;
    
    /** 
     * 对比规则外键 取得
     * @return fkCrid_eq 对比规则外键 
     */
    public Integer getFkCrid_eq() {
        return fkCrid_eq;
    }

    /** 
     * 对比规则外键 设定
     * @param fkCrid_eq 对比规则外键 
     */
    public void setFkCrid_eq(Integer fkCrid_eq) {
        this.fkCrid_eq = fkCrid_eq;
    }

    /** 
     * 对比规则版本 取得
     * @return crversion_eq 对比规则版本 
     */
    public String getCrversion_eq() {
        return crversion_eq;
    }

    /** 
     * 对比规则版本 设定
     * @param crversion_eq 对比规则版本 
     */
    public void setCrversion_eq(String crversion_eq) {
        this.crversion_eq = crversion_eq;
    }
    
    
}