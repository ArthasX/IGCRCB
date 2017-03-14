/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareroleTB;

/**
  * 概述: 对比规则业务逻辑接口
  * 功能描述: 对比规则业务逻辑接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareroleBL extends BaseBL {

	/**
	 * 对比规则实例取得
	 *
	 * @return 对比规则实例
	 */
	public CompareroleTB getCompareroleTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareroleInfo> searchComparerole();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareroleInfo searchCompareroleByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareroleSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareroleInfo> searchComparerole(
			CompareroleSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareroleInfo> searchComparerole(
			CompareroleSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareroleInfo registComparerole(CompareroleInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareroleInfo updateComparerole(CompareroleInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareroleByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteComparerole(CompareroleInfo instance)
		throws BLException;

	/**
	 * 保存
	 * @param instantce
	 * @return
	 */
	public CompareroleInfo save(CompareroleInfo instantce)throws BLException;
	/**
     * 根据关系表查询规则及对象
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<CompareroleInfo> searchCompareroleByRelation(CompareroleSearchCond cond) throws BLException;
}