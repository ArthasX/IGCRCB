/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.room.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: compareTemplate接口
  * 功能描述: compareTemplate接口
  * 创建记录: 2011/05/24
  * 修改记录: 2013-05-30 XuDongWang
  */
public interface CompareTemplateInfo extends BaseModel {
	/**
	 * ctpid取得
	 *
	 * @return ctpid ctpid
	 */
	public Integer getCtpid();

	/**
	 * ctcategory取得
	 *
	 * @return ctcategory ctcategory
	 */
	public String getCtcategory();

	/**
	 * cttype取得
	 *
	 * @return cttype cttype
	 */
	public String getCttype();

	/**
	 * cteiid取得
	 *
	 * @return cteiid cteiid
	 */
	public String getCteiid();

	/**
	 * ctx取得
	 *
	 * @return ctx ctx
	 */
	public String getCtx();

	/**
	 * cty取得
	 *
	 * @return cty cty
	 */
	public String getCty();

	/**
	 * ctfloorx取得
	 *
	 * @return ctfloorx ctfloorx
	 */
	public String getCtfloorx();

	/**
	 * ctfloory取得
	 *
	 * @return ctfloory ctfloory
	 */
	public String getCtfloory();
	
	/**
	 * ctindex取得
	 *
	 * @return ctindex ctindex
	 */
	public String getCtindex();
	
	/**
	 * ctName取得
	 *
	 * @return ctName ctName
	 */
	public String getCtName();
	
	/**
	 * ctInfo取得
	 *
	 * @return ctInfo ctInfo
	 */
	public String getCtInfo() ;

	/**
	 * ctZoneId取得
	 *
	 * @return ctZoneId ctZoneId
	 */
	public String getCtZoneId();
}