/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model;

/**
 * 概述:填报质量考核 
 * 功能描述：填报质量考核
 * 创建人：赵梓廷
 * 创建记录： 2012-12-21
 * 修改记录：
 */
public interface FillInQualityAssessInfo {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();
	
	/**
	 * 用户id或者部门机构码 取得
	 *
	 * @return 用户id或者部门机构码
	 */
	public String getPpuserid();
	
	/**
	 * 用户名或者部门名 取得
	 *
	 * @return 用户名或者部门名
	 */
	public String getUsername();
	
	/**
	 * 年报填报人id或填报部门id取得
	 *
	 * @return 年报填报人id或填报部门id
	 */
	public String getPpuserid1();
	
	/**
	 * 季报填报人id或填报部门id 取得
	 *
	 * @return 季报填报人id或填报部门id 
	 */
	public String getPpuserid2();
	
	/**
	 *不定期报填报人id或填报部门id 取得
	 *
	 * @return 不定期报填报人id或填报部门id
	 */
	public String getPpuserid3();
	
	/**
	 *年报是否及时 取得
	 *
	 * @return 年报是否及时
	 */
	public String getTimely1();
	
	/**
	 *季报是否及时 取得
	 *
	 * @return 季报是否及时
	 */
	public String getTimely2();
	
	/**
	 *不定期报是否及时 取得
	 *
	 * @return 不定期报是否及时
	 */
	public String getTimely3();
	
	public String getPporgid();
	
	public String getPporgname() ;
	
	public String getTruely1();
	
	public String getTruely2();
	
	public String getTruely3();
}
