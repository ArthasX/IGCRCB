/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * 概述: 日志表检索条件实现
  * 功能描述: 日志表检索条件实现
  * 创建记录: 2014/02/19
  * 修改记录: 
  */
public class VIM04SearchCondImpl implements
		VIM04SearchCond {

    /** 项目主键 */
    protected Integer pid_eq;

    /**
     * 获取项目主键
     * @return 项目主键 
     */
    public Integer getPid_eq() {
        return pid_eq;
    }

    /**
     * 设置项目主键
     * @param pid_eq 项目主键
     */
    public void setPid_eq(Integer pid_eq) {
        this.pid_eq = pid_eq;
    }
    
}