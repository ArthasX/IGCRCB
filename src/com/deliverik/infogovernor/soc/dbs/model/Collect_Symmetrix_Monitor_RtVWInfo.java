/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.model;

import java.math.BigDecimal;

/**
 * 
 * @Description:存储实时信息视图实体接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtVWInfo{
/**
*
*/
public String getSymtime();

/**
*IOPS
*/
public BigDecimal getSymiops();

/**
*吞吐率
*/
public BigDecimal getSymthroughput();

/**
*读比率
*/
public BigDecimal getReadper();

/**
*写比率
*/
public BigDecimal getWriteper();

/**
*缓存命中率
*/
public BigDecimal getHitper();


public String getFulltime();
}