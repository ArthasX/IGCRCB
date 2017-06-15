/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;

/**
  * 概述: 流程组定义表业务逻辑接口
  * 功能描述: 流程组定义表业务逻辑接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG480BL extends BaseBL {

	/**
	 * 流程组定义表实例取得
	 *
	 * @return 流程组定义表实例
	 */
	public IG480TB getIG480TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG480Info> searchIG480();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG480Info searchIG480ByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG480SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG480Info> searchIG480(
			IG480SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG480Info> searchIG480(
			IG480SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG480Info registIG480(IG480Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG480Info updateIG480(IG480Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG480ByPK(String pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG480(IG480Info instance)
		throws BLException;

	/**
	 * 流程组定义升版处理
	 * 
	 * @param pdid 流程定义ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid) throws BLException;
	/**
	 * 流程组定义主键值取得
	 * @param firstsite 主键首位标识
	 * @param pdsequence 序列名称
	 * @return PDID主键值
	 */
	public String getPdidNextValue(String firstsite,String pdsequence);
	/**
	 * 流程组定义复制处理
	 * 
	 * @param pgdid 流程组定义ID
	 * @param pdsequence 序列定义
	 */
	public String copyGroupProcessDefVersion(String pgdid,String pdsequence) throws BLException;
}