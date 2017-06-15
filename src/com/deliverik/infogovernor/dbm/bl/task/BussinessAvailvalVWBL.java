/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.dbm.model.dao.BussinessAvailvalVWDAO;
import com.deliverik.infogovernor.dbm.model.entity.BussinessAvailvalVW;

/**
  * 概述: TOPOXML业务逻辑接口
  * 功能描述: TOPOXML业务逻辑接口
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
public interface BussinessAvailvalVWBL extends BaseBL {

	/**
	 * BussinessAvailvalVW实例取得
	 *
	 * @return BussinessAvailvalVW实例
	 */
	public BussinessAvailvalVW getBussinessAvailvalVWInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<BussinessAvailval> searchBussinessAvailvalVW();
	/**
	 * bussinessAvailvalVWDAO设定
	 *
	 * @param bussinessAvailvalVWDAO bussinessAvailvalVWDAO
	 */
	public void setBussinessAvailvalVWDAO(BussinessAvailvalVWDAO bussinessAvailvalVWDAO);
}