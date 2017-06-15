/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.rpt.model.condition;


/**
 * 
 * @Description:自动报表配置列表Cond接口
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将ReportConfigurationSearchCond表名改为SOC0203SearchCond
 */
public interface SOC0203SearchCond{
/**
*报表文件的名称
*/
public String getR_path();

/**
*报表文件的中文含义
*/
public String getR_title();

/**
*报表运行时所用的参数
*/
public String getPara();

/**
 * 数据ID
 * @return 数据ID
 */
public String getDataid();

}

