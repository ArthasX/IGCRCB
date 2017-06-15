/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;

/**
  * 概述: 组织架构关联表检索条件接口
  * 功能描述: 组织架构关联表检索条件接口
  * 创建记录: 2015/03/09
  * 修改记录: 
  */
public interface StructureRoleSearchCond {
    /**
     * 组织架构层次码取得
     *
     * @return 组织架构层次码
     */
    public String getSyscoding();

    /**
     * 组织架构cid取得
     *
     * @return 组织架构cid
     */
    public String getCid();

    /**
     * 组织架构名称取得
     *
     * @return 组织架构名称
     */
    public String getSname();

    /**
     * 角色id取得
     *
     * @return 角色id
     */
    public Integer getRoleid();

    /**
     * 角色名称取得
     *
     * @return 角色名称
     */
    public String getRolename();

    /**
     * 组织架构类型 Y应急组织架构，R日常组织架构取得
     *
     * @return 组织架构类型 Y应急组织架构，R日常组织架构
     */
    public String getSrtype();
    //完全匹配
    public String getSyscoding_q();
    
    public List<Integer> getRoleid_in();
}