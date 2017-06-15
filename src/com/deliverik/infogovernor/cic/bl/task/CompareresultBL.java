/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareresultTB;

/**
  * 概述: 比对结果业务逻辑接口
  * 功能描述: 比对结果业务逻辑接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareresultBL extends BaseBL {

	/**
	 * 比对结果实例取得
	 *
	 * @return 比对结果实例
	 */
	public CompareresultTB getCompareresultTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareresultInfo> searchCompareresult();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareresultInfo searchCompareresultByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareresultSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareresultInfo> searchCompareresult(
			CompareresultSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareresultInfo> searchCompareresult(
			CompareresultSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareresultInfo registCompareresult(CompareresultInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareresultInfo updateCompareresult(CompareresultInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareresultByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCompareresult(CompareresultInfo instance)
		throws BLException;

	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<CompareresultVWInfo> searchCompareresultVW(CompareresultSearchCond cond) throws BLException ;
    
    /**
     * 根据对象比对结果标题List
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<Object[]> getEnameList(final CompareresultSearchCond cond) throws BLException;
}