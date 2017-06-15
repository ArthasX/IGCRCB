/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: EmergencyResource检索条件接口
  * 功能描述: EmergencyResource检索条件接口
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
public interface EmergencyResourceSearchCond {
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getErid() ;

	/**
	 * 资源名称取得
	 *
	 * @return 资源名称
	 */
	public String getErname() ;

	/**
	 * 资源描述取得
	 *
	 * @return 资源描述
	 */
	public String getErdesc() ;

	/**
	 * 资源状态取得
	 *
	 * @return 资源状态
	 */
	public String getErstatus() ;

	/**
	 * 资源编号取得
	 *
	 * @return 资源编号
	 */
	public String getErlabel() ;
	/**
	 * 资源编码取得
	 *
	 * @return 资源编码
	 */
	public String getErcode() ;

	/**
	 * 父级编码取得
	 *
	 * @return 父级编码
	 */
	public String getErparcode() ;
	/**
	 * 录入时间取得
	 *
	 * @return 录入时间
	 */
	public String getErcreatetime() ;

	/**
	 * 录入人id取得
	 *
	 * @return 录入人id
	 */
	public String getEruserid() ;

	/**
	 * 录入人姓名取得
	 *
	 * @return 录入人姓名
	 */
	public String getErusername() ;
	
	/**
	 * @return the orderby
	 */
	public String getOrderby() ;
	/**
	 * @return the order
	 */
	public String getOrder();
	/**
	 * @return the erparcode_like
	 */
	public String getErparcode_like(); 
	/**
	 * @param 对应资产码  the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding);
}