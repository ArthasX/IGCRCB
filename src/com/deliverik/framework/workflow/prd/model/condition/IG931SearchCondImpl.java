/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 缺省状态参与者关联流程类型定义表检索条件实现
  * 功能描述: 缺省状态参与者关联流程类型定义表检索条件实现
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
public class IG931SearchCondImpl implements
		IG931SearchCond {

    /** 主键 */
    protected String psprpid;

    /** 流程定义id */
    protected String pdid;

    /** 流程状态id */
    protected String psdid;
    
    /** 流程模板状态（a启用，i停用，t测试）*/
    protected String[] ptstatuses;
    
    /**
     * 主键取得
     *
     * @return 主键
     */
    public String getPsprpid() {
        return psprpid;
    }

    /**
     * 主键设定
     *
     * @param psprpid 主键
     */
    public void setPsprpid(String psprpid) {
        this.psprpid = psprpid;
    }

    /**
     * 流程定义id取得
     *
     * @return 流程定义id
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * 流程定义id设定
     *
     * @param pdid 流程定义id
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

    /**
     * 流程状态id取得
     *
     * @return 流程状态id
     */
    public String getPsdid() {
        return psdid;
    }

    /**
     * 流程状态id设定
     *
     * @param psdid 流程状态id
     */
    public void setPsdid(String psdid) {
        this.psdid = psdid;
    }

    /**
     * @return the 流程模板状态（a启用，i停用，t测试）
     */
    public String[] getPtstatuses() {
        return ptstatuses;
    }

    /**
     * @param 流程模板状态（a启用，i停用，t测试） the ptstatuses to set
     */
    public void setPtstatuses(String[] ptstatuses) {
        this.ptstatuses = ptstatuses;
    }
}