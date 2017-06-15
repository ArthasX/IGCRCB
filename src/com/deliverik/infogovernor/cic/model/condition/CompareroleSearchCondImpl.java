/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * 概述: 对比规则检索条件实现
  * 功能描述: 对比规则检索条件实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public class CompareroleSearchCondImpl implements
		CompareroleSearchCond {
	
	/** 对比类型 */
	protected String crtype;
	
	/** 业务系统id */
	protected Integer crsystemid;

	public String getCrtype() {
		return crtype;
	}

	public void setCrtype(String crtype) {
		this.crtype = crtype;
	}

	public Integer getCrsystemid() {
		return crsystemid;
	}

	public void setCrsystemid(Integer crsystemid) {
		this.crsystemid = crsystemid;
	}
	
	
	

    /** 比对任务表主键 */
    protected Integer cpid;

    /** 
     * 比对任务表主键 取得
     * @return cpid 比对任务表主键 
     */
    public Integer getCpid() {
        return cpid;
    }

    /** 
     * 比对任务表主键 设定
     * @param cpid 比对任务表主键 
     */
    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }
    
}