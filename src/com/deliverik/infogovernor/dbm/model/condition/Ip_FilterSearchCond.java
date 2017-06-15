/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.condition;

/**
  * 概述: 全网IP过滤检索条件接口
  * 功能描述: 全网IP过滤检索条件接口
  * 创建记录: 2012/11/07
  * 修改记录: 
  */
public interface Ip_FilterSearchCond {
    /**
     * IP地址查询条件 is returned.
     * @return ip
     */
    public String getIp();
}