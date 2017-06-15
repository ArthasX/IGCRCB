/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;
import com.deliverik.infogovernor.dbm.model.condition.Ip_FilterSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.Ip_FilterTB;

/**
  * 概述: 全网IP过滤业务逻辑接口
  * 功能描述: 全网IP过滤业务逻辑接口
  * 创建记录: 2012/11/07
  * 修改记录: 
  */
public interface Ip_FilterBL extends BaseBL {

	/**
	 * 全网IP过滤实例取得
	 *
	 * @return 全网IP过滤实例
	 */
	public Ip_FilterTB getIp_FilterTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Ip_FilterInfo> searchIp_Filter();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Ip_FilterInfo searchIp_FilterByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Ip_FilterSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Ip_FilterInfo> searchIp_Filter(
			Ip_FilterSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Ip_FilterInfo> searchIp_Filter(
			Ip_FilterSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Ip_FilterInfo registIp_Filter(Ip_FilterInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Ip_FilterInfo updateIp_Filter(Ip_FilterInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIp_FilterByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIp_Filter(Ip_FilterInfo instance)
		throws BLException;

}