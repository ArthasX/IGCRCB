/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: UserRegion接口
  * 功能描述: UserRegion接口
  * 创建记录: 2014/01/10
  * 修改记录: 
  */
public interface UserRegionInfo extends BaseModel {

	/**
	 * ID取得
	 *
	 * @return ID
	 */
	public Integer getID();

	/**
	 * flexID取得
	 *
	 * @return flexID
	 */
	public String getFlexID();

	/**
	 * UserID取得
	 *
	 * @return UserID
	 */
	public String getUserID();

	/**
	 * x取得
	 *
	 * @return x
	 */
	public String getX();

	/**
	 * y取得
	 *
	 * @return y
	 */
	public String getY();

	/**
	 * width取得
	 *
	 * @return width
	 */
	public String getWidth();

	/**
	 * height取得
	 *
	 * @return height
	 */
	public String getHeight();

	/**
	 * title取得
	 *
	 * @return title
	 */
	public String getTitle();

}