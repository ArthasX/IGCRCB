/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 状态级私有表单值记录表检索条件接口
  * 功能描述: 状态级私有表单值记录表检索条件接口
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
public interface IG561SearchCond {
    /**
     *  流程id 取得 
     * @return 流程id
     */
    public String getPrid_q() ;
    /**
     *  节点id 取得 
     * @return 节点id
     */
    public String getPsdid_l() ;
    /**
     *  节点id 取得 
     * @return 节点id
     */
    public String getPidid_l() ;
    /**
     *  表单值 ig599 id 取得 
     * @return 表单值 ig599 id
     */
    public String getPiid_q();
}