/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 比对结果接口
  * 功能描述: 比对结果接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareresultInfo extends BaseModel {

	/**
	 * crid取得
	 *
	 * @return crid
	 */
	public Integer getCrid();

	/**
	 * 比较对象表id取得
	 *
	 * @return 比较对象表id
	 */
	public Integer getFkCoid();

	/**
	 * 比较执行表ID取得
	 *
	 * @return 比较执行表ID
	 */
	public Integer getFkCpid();

	/**
	 * eid取得
	 *
	 * @return eid
	 */
	public String getEid();

	/**
	 * cid取得
	 *
	 * @return cid
	 */
	public String getCid();

	/**
	 * 目标eiid取得
	 *
	 * @return 目标eiid
	 */
	public Integer getTeiid();

	/**
	 * 目标ciid取得
	 *
	 * @return 目标ciid
	 */
	public String getTciid();

	/**
	 * 源eiid取得
	 *
	 * @return 源eiid
	 */
	public Integer getSeiid();

	/**
	 * 源ciid取得
	 *
	 * @return 源ciid
	 */
	public String getSciid();

	/**
	 * 源属性值取得
	 *
	 * @return 源属性值
	 */
	public String getSvalue();

	/**
	 * 目标属性值取得
	 *
	 * @return 目标属性值
	 */
	public String getTvalue();

	/**
	 * 属性类型取得
	 *
	 * @return 属性类型
	 */
	public String getConfigtype();

	/**
	 * 是否是基本属性取得
	 *
	 * @return 是否是基本属性
	 */
	public Integer getIsbase();

	/**
	 * 父节点模型id取得
	 *
	 * @return 父节点模型id
	 */
	public String getPeid();

}