/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.mnt.model;

/**
 * 
 * @Description:软件部署信息视图实体接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface SOC0306Info{
/**
*自动增长
*/
public Integer getId();

/**
*symmid
*/
public String getSymmid();

/**
*创建时间
*/
public String getDataitmes();

/**
*类型
*/
public String getSymtype();

/**
*是否已阅读
*/
public String getReaddate();

}

