/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCond;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.asset.model.entity.EiLinkMapPK;
import com.deliverik.framework.asset.model.entity.EiLinkMapTB;

/**
  * 概述: 实体链路图业务逻辑接口
  * 功能描述: 实体链路图业务逻辑接口
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
public interface EiLinkMapBL extends BaseBL {

	/**
	 * 实体链路图实例取得
	 *
	 * @return 实体链路图实例
	 */
	public EiLinkMapTB getEiLinkMapTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiLinkMapInfo> searchEiLinkMap();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EiLinkMapInfo searchEiLinkMapByPK(EiLinkMapPK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EiLinkMapSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EiLinkMapInfo> searchEiLinkMap(
			EiLinkMapSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiLinkMapInfo> searchEiLinkMap(
			EiLinkMapSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public EiLinkMapInfo registEiLinkMap(EiLinkMapInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public EiLinkMapInfo updateEiLinkMap(EiLinkMapInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEiLinkMapByPK(EiLinkMapPK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEiLinkMap(EiLinkMapInfo instance)
		throws BLException;
	
	/**
	 * 拓扑图链路检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EiLinkMapInfo> queryEiLinkMapList(EiLinkMapSearchCond cond);
	
	/**
	 * 影响CI检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> queryImpactCI(final EiLinkMapSearchCond cond);
	
	public List<EiLinkMapInfo> searchEiLinkMapByOtherEiid(EiLinkMapSearchCondImpl emCond);

}