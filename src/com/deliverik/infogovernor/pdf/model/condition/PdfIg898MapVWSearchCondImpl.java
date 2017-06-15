/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.condition;


/**
  * 概述: 报表字段与流程公有表单值映射关系视图检索条件实现
  * 功能描述: 报表字段与流程公有表单值映射关系视图检索条件实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public class PdfIg898MapVWSearchCondImpl implements
		PdfIg898MapVWSearchCond {
    
    /** 流程主键 */
    protected Integer prid;
    
    /** 表单名称 */
    protected String pidname;
    
    /** 表单定义ID */
    protected String pidid;

    /** 父绑定字段 */
    protected String pdatabinding;
    
    /** 排序设置 */
    protected String orderby;
    /** 表格式表单值行号 */
	
	protected String pvrownumber;
	
    /**
	 * @return the 表格式表单值行号
	 */
	public String getPvrownumber() {
		return pvrownumber;
	}

	/**
	 * @param 表格式表单值行号 the pvrownumber to set
	 */
	public void setPvrownumber(String pvrownumber) {
		this.pvrownumber = pvrownumber;
	}

	/**
     * @return the 流程主键
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * @param 流程主键 the prid to set
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * @return the 表单名称
     */
    public String getPidname() {
        return pidname;
    }

    /**
     * @param 表单名称 the pidname to set
     */
    public void setPidname(String pidname) {
        this.pidname = pidname;
    }

    /**
     * @return the 表单定义ID
     */
    public String getPidid() {
        return pidid;
    }

    /**
     * @param 表单定义ID the pidid to set
     */
    public void setPidid(String pidid) {
        this.pidid = pidid;
    }

    /**
     * @return the 父绑定字段
     */
    public String getPdatabinding() {
        return pdatabinding;
    }

    /**
     * @param 父绑定字段 the pdatabinding to set
     */
    public void setPdatabinding(String pdatabinding) {
        this.pdatabinding = pdatabinding;
    }

    /**
     * @return the 排序设置
     */
    public String getOrderby() {
        return orderby;
    }

    /**
     * @param 排序设置 the orderby to set
     */
    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

}