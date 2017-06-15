/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 缺省状态参与者关联流程类型定义表检索条件接口
  * 功能描述: 缺省状态参与者关联流程类型定义表检索条件接口
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
public interface IG931SearchCond {

    /**
     * 主键取得
     *
     * @return 主键
     */
    public String getPsprpid();

    /**
     * 流程定义id取得
     *
     * @return 流程定义id
     */
    public String getPdid() ;

    /**
     * 流程状态id取得
     *
     * @return 流程状态id
     */
    public String getPsdid();
    
    /**
     * @return the 流程模板状态（a启用，i停用，t测试）
     */
    public String[] getPtstatuses();
}