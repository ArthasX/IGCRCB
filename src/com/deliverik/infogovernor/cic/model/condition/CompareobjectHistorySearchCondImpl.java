/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * 概述: 对比对象历史表检索条件实现
  * 功能描述: 对比对象历史表检索条件实现
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
public class CompareobjectHistorySearchCondImpl implements
		CompareobjectHistorySearchCond {


    /** 对比规则外键 */
    protected Integer fkCrid_eq;
    
    /**对比对象id*/
    private Integer coid_eq;

    /** 对比规则版本 */
    protected Integer crversion_eq;
    
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
    public Integer getCrversion_eq() {
        return crversion_eq;
    }

    /** 
     * 对比规则版本 设定
     * @param crversion_eq 对比规则版本 
     */
    public void setCrversion_eq(Integer crversion_eq) {
        this.crversion_eq = crversion_eq;
    }

	public Integer getCoid_eq() {
		return coid_eq;
	}

	public void setCoid_eq(Integer coid_eq) {
		this.coid_eq = coid_eq;
	}
    
    
    

}