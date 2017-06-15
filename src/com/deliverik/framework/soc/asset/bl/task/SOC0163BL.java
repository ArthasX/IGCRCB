/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0163SearchCond;

/**
  * 概述: 用户资产BL
  * 功能描述: 用户资产BL
  * 创建记录: 2011/04/21
  * 修改记录: 
  */
public interface SOC0163BL extends BaseBL {


	

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0163Info searchEntityItemEntityVWByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0163SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0163Info> searchEntityItemEntityVW(
			SOC0163SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0163Info> searchEntityItemEntityVW(
			SOC0163SearchCond cond, int start,
			int count);
	
	/**
	 * 条件检索网络设备结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCountForNetAsset(SOC0163SearchCond cond);
	
	
	/**
	 * 条件检索网络设备处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0163Info> findByCondForNetAsset(SOC0163SearchCond cond, int start,  int count);
	

}