/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareProcessRoleRelationInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareProcessRoleRelationSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareProcessRoleRelationTB;

/**
  * 概述: 关系表业务逻辑接口
  * 功能描述: 关系表业务逻辑接口
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
public interface CompareProcessRoleRelationBL extends BaseBL {

	/**
	 * 关系表实例取得
	 *
	 * @return 关系表实例
	 */
	public CompareProcessRoleRelationTB getCompareProcessRoleRelationTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareProcessRoleRelationInfo> searchCompareProcessRoleRelation();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareProcessRoleRelationInfo searchCompareProcessRoleRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareProcessRoleRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareProcessRoleRelationInfo> searchCompareProcessRoleRelation(
			CompareProcessRoleRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareProcessRoleRelationInfo> searchCompareProcessRoleRelation(
			CompareProcessRoleRelationSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareProcessRoleRelationInfo registCompareProcessRoleRelation(CompareProcessRoleRelationInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareProcessRoleRelationInfo updateCompareProcessRoleRelation(CompareProcessRoleRelationInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareProcessRoleRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCompareProcessRoleRelation(CompareProcessRoleRelationInfo instance)
		throws BLException;

}