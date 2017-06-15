/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.rpt.model.condition;


/**
 * 
 * @Description:自动报表生成表Cond类
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将REPORT_GDATA_ITEMSearchCondImpl表名改为SOC0201SearchCondImpl
 */
public class SOC0201SearchCondImpl implements SOC0201SearchCond{
/**
*统计类型
*/
protected String r_category;

/**
*统计类型取得
* @return 统计类型
*/
public String getR_category(){
return r_category;
}
/**
*统计类型设定
* @param r_category统计类型
*/
public void setR_category(String r_category){
this.r_category=r_category;
}
/**
*报表文件名称
*/
protected String r_path;

/**
*报表文件名称取得
* @return 报表文件名称
*/
public String getR_path(){
return r_path;
}
/**
*报表文件名称设定
* @param r_path报表文件名称
*/
public void setR_path(String r_path){
this.r_path=r_path;
}
/**
*报表配置id
*/
protected Integer r_rcid;

/**
*报表配置id取得
* @return 报表配置id
*/
public Integer getR_rcid(){
return r_rcid;
}
/**
*报表配置id设定
* @param r_rcid报表配置id
*/
public void setR_rcid(Integer r_rcid){
this.r_rcid=r_rcid;
}
/**
*报表统计年月
*/
protected String r_time;

/**
*报表统计年月取得
* @return 报表统计年月
*/
public String getR_time(){
return r_time;
}
/**
*报表统计年月设定
* @param r_time报表统计年月
*/
public void setR_time(String r_time){
this.r_time=r_time;
}
}

