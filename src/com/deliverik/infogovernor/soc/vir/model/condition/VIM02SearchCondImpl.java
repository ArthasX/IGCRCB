/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * 概述: 虚拟资源项目信息表检索条件实现
  * 功能描述: 虚拟资源项目信息表检索条件实现
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public class VIM02SearchCondImpl implements
		VIM02SearchCond {
    
    /** 部署进度  */
    protected String progress_eq;

    /**
     * 获取部署进度
     * @return 部署进度 
     */
    public String getProgress_eq() {
        return progress_eq;
    }

    /**
     * 设置部署进度
     * @param progress_eq 部署进度
     */
    public void setProgress_eq(String progress_eq) {
        this.progress_eq = progress_eq;
    }
    
    
}