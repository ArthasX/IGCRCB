/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * 概述: 比对结果检索条件实现
  * 功能描述: 比对结果检索条件实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public class CompareresultSearchCondImpl implements
		CompareresultSearchCond {

    /** 比对对象表主键 */
    public Integer coid_eq ;

    /** 是否是基本属性 1：是 0：否 */
    public Integer isBase;
    
    /**对比过过程id*/
    private Integer cpid_eq;
    
    private String eid;
    
    /** 
     * 比对对象表主键 取得
     * @return coid_eq 比对对象表主键 
     */
    public Integer getCoid_eq() {
        return coid_eq;
    }

    /** 
     * 比对对象表主键 设定
     * @param coid_eq 比对对象表主键 
     */
    public void setCoid_eq(Integer coid_eq) {
        this.coid_eq = coid_eq;
    }

    /** 
     * 是否是基本属性1：是0：否 取得
     * @return isBase 是否是基本属性1：是0：否 
     */
    public Integer getIsBase() {
        return isBase;
    }

    /** 
     * 是否是基本属性1：是0：否 设定
     * @param isBase 是否是基本属性1：是0：否 
     */
    public void setIsBase(Integer isBase) {
        this.isBase = isBase;
    }

	public Integer getCpid_eq() {
		return cpid_eq;
	}

	public void setCpid_eq(Integer cpid_eq) {
		this.cpid_eq = cpid_eq;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
    
    
}