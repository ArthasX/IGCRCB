/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;


/**
  * 概述: IG344Info接口
  * 功能描述: IG344Info接口
  * 创建记录: 2012/07/13
  * 修改记录: 
  */
public interface IG344Info {

	/**
	 * 服务商名称取得
	 *
	 * @return 服务商名称
	 */
	public String getEiname();

	/**
	 * 服务记录编号取得
	 *
	 * @return 服务记录编号
	 */
	public String getEilabel();

	/**
	 * 服务记录登记时间取得
	 *
	 * @return 服务记录登记时间
	 */
	public String getEiinsdate();

	/**
	 * 服务类型取得
	 *
	 * @return 服务类型
	 */
	public String getCivalue();

	/**
	 * 服务性质取得
	 *
	 * @return 服务性质
	 */
	public String getCivalue1();

	/**
	 * 服务评价取得
	 *
	 * @return 服务评价
	 */
	public String getCivalue2();

	/**
	 * 服务评分取得
	 *
	 * @return 服务评分
	 */
	public Double getCivalue3();

}