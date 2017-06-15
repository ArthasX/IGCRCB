/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sya.model.condition;

/**
  * 概述: 制度检索条件接口
  * 功能描述: 制度检索条件接口
  * 创建记录: 2015-2-5 10:59:50
  * 修改记录: 
  */
public interface InstitutionSearchCond {

	/**
	 * 制度名称取得
	 * @return inname  制度名称
	 */
	public String getInname();

	/**
	 * 时间取得
	 * @return createtime_from  时间
	 */
	public String getCreatetime_from();

	/**
	 * createtime_to取得
	 * @return createtime_to  createtime_to
	 */
	public String getCreatetime_to();

	/**
	 * niuserid取得
	 * @return niuserid  niuserid
	 */
	public String getNiuserid();

	/**
	 * 登记人机构名称取得
	 * @return niorgname  登记人机构名称
	 */
	public String getNiorgname();
	
	/**
	 * 制度分类取得
	 * @return intype  制度分类
	 */
	public String getIntype();
	
}