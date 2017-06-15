/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 表格类表单值表检索条件实现
  * 功能描述: 表格类表单值表检索条件实现
  * 创建记录: 2013/06/25
  * 修改记录: 
  */
public class IG898SearchCondImpl implements IG898SearchCond {

	/** 流程主键 */
	protected Integer prid;
	
	/** 父级表单定义主键 */
	protected String pidid;
	
	/** 表单名称 */
	protected String pidname;
	
	/** 行号 */
	protected String rownumber;

	/**列名*/
	protected String pvcolname;
	
	/** 表单值 */
	protected String pvalue;
	
	public String getPvalue() {
		return pvalue;
	}

	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

	/**  
	 * 获取pvcolname  
	 * @return pvcolname 
	 */
	public String getPvcolname() {
		return pvcolname;
	}

	/**  
	 * 设置pvcolname  
	 * @param pvcolname
	 */
	
	public void setPvcolname(String pvcolname) {
		this.pvcolname = pvcolname;
	}

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 父级表单定义主键取得
	 * @return pidid 父级表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 父级表单定义主键设定
	 * @param pidid 父级表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
     * 表单名称取得
     * @return pidname 表单名称
     */
    public String getPidname() {
        return pidname;
    }

    /**
     * 表单名称设定
     * @param pidname 表单名称
     */
    public void setPidname(String pidname) {
        this.pidname = pidname;
    }

	/**
	 * 行号取得
	 * @return rownumber 行号
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * 行号设定
	 * @param rownumber 行号
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}
}