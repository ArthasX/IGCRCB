/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.model;

import java.math.BigDecimal;

/**
 * 
 * @Description:存储实时信息实体接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_Rt{
/**
*主键ID
*/
public Integer getId();

/**
*系统时间
*/
public String getSavetime();

/**
*序列号
*/
public String getSymm_id();

/**
*时间间隔
*/
public String getTimestamp();

/**
*实时读
*/
public BigDecimal getReads_per_sec();

/**
*实时写
*/
public BigDecimal getWrites_per_sec();

/**
*吐量
*/
public BigDecimal getKbytes_read_per_sec();

/**
*吞量
*/
public BigDecimal getKbytes_written_per_sec();

/**
*读命中率
*/
public BigDecimal getHits_read_per_sec();

/**
*写命中率
*/
public BigDecimal getHits_written_per_sec();

/**
*
*/
public BigDecimal getSeq_read_per_sec();

/**
*
*/
public BigDecimal getSeq_written_per_sec();

/**
*
*/
public BigDecimal getNumber_write_pending_tracks();

}

