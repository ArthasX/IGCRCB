/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0103TB;

/**
  * 概述: 审计对比结果信息表业务逻辑接口
  * 功能描述: 审计对比结果信息表业务逻辑接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface SOC0103BL extends BaseBL {

	/**
	 * 审计对比结果信息表实例取得
	 *
	 * @return 审计对比结果信息表实例
	 */
	public SOC0103TB getSOC0103Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0103Info> searchSOC0103();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0103Info searchSOC0103ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0103SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0103Info> searchSOC0103(
			SOC0103SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0103Info> searchSOC0103(
			SOC0103SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0103Info registSOC0103(SOC0103Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0103Info updateSOC0103(SOC0103Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0103ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0103(SOC0103Info instance)
		throws BLException;

	/**
	 * 更新当前数据为不合理
	 *
	 * @param cond 检索条件
	 */
	public Integer updateSOC0103Without(SOC0103SearchCond cond)
		throws BLException;
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0137Info> searchAuditResultOne(
			SOC0103SearchCond cond)throws BLException;

}