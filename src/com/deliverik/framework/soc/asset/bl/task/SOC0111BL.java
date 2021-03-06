/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0111TB;

/**
  * 概述: 资产域定义表业务逻辑接口
  * 功能描述: 资产域定义表业务逻辑接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0111BL extends BaseBL {

	/**
	 * 资产域定义表实例取得
	 *
	 * @return 资产域定义表实例
	 */
	public SOC0111TB getEiDomainDefTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0111Info> searchEiDomainDef();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0111Info searchEiDomainDefByPK(Serializable pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0111SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0111Info> searchEiDomainDef(
			SOC0111SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0111Info> searchEiDomainDef(
			SOC0111SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0111Info registEiDomainDef(SOC0111Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0111Info updateEiDomainDef(SOC0111Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiDomainDefByPK(Serializable pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiDomainDef(SOC0111Info instance)
		throws BLException;
	/**
	 * 查询最大EiddId
	 * @return 
	 * @throws BLException
	 */
	public Integer findMaxEiddId() throws BLException;

	/**
	 * 获取最新版本域
	 * @param eiddid 域ID
	 * @return 最新版本域
	 * @throws BLException 
	 */
	public SOC0111Info searchDomainMaxVersion(Integer eiddid) throws BLException;

	/**
	 * 获取资产域定义版本
	 * @param eiddid
	 * @param version
	 * @return
	 * @throws BLException
	 */
	public List<SOC0111Info> searchEiDomainDefByPK(Integer eiddid,Integer version) throws BLException;

}