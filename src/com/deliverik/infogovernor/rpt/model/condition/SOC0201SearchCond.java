/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.rpt.model.condition;


/**
 * 
 * @Description:自动报表生成表Cond接口
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将REPORT_GDATA_ITEMSearchCond表名改为SOC0201SearchCond
 */
public interface SOC0201SearchCond{
/**
*统计类型
*/
public String getR_category();

/**
*报表文件名称
*/
public String getR_path();

/**
*报表配置id
*/
public Integer getR_rcid();

/**
*报表统计年月
*/
public String getR_time();

}

