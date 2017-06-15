/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG229Info;
import com.deliverik.framework.workflow.prd.model.condition.IG229SearchCond;


 /**
  * <P>概述:流程评审详细记录表BL接口</p>
  * <p>功能描述：1.持久化</p>
  * <p>			2.主键检索处理</p>
  * <p>			3.全件检索</p>
  * <p>			4.条件检索结果件数取得</p>
  * <p>			5.条件检索处理</p>
  * <p>			6.删除处理</p>
  * <p>创建记录：songhy 20101129</p>
  */

public interface IG229BL extends BaseBL {
	/**
	 * 持久化处理
	 * 
	 * @param IG229Info实体类
	 * @return IG229Info实体类
	 */
	public IG229Info saveIG229Info(
			IG229Info ig229Info) throws BLException;

	/**
	 * 主键检索处理
	 * 
	 * @param id 主键
	 * @return 检索结果
	 */
	public IG229Info findIG229InfoByPK(Integer id)
			throws BLException;

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<IG229Info> findAllIG229Info()
			throws BLException;

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG229SearchCond cond)
			throws BLException;

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG229Info> findIG229InfoByCond(
			IG229SearchCond cond, int start, int count)
			throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param IG229Info实体类
	 */
	public void deleteIG229Info(
			IG229Info processAssessmentDetail) throws BLException;

}

