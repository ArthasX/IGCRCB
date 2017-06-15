/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0127Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0127SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0110TB;

/**
  * 概述: 配置所属关系表业务逻辑接口
  * 功能描述: 配置所属关系表业务逻辑接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0110BL extends BaseBL {

	/**
	 * 配置所属关系表实例取得
	 *
	 * @return 配置所属关系表实例
	 */
	public SOC0110TB getEiBelongRelationTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0110Info> searchEiBelongRelation();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0110Info searchEiBelongRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0110SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> searchEiBelongRelation(
			SOC0110SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> searchEiBelongRelation(
			SOC0110SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0110Info registEiBelongRelation(SOC0110Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0110Info updateEiBelongRelation(SOC0110Info instance)
		throws BLException;
	
	/**
	 * 资产所属关系信息版本升级处理
	 * 
	 * @param eiid 变更资产ID
	 * @param eiversion 关系表中资产最新大版本
	 * @param eismallversion 关闭表中资产最新小版本
	 * @param neweiversion 资产最新大版本
	 * @param neweismallversion 资产最新小版本
	 * @throws BLException 
	 */
	public void upgradeEntityItemRelation(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiBelongRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiBelongRelation(SOC0110Info instance)
		throws BLException;
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0127Info> searchEiBelongRelationVW(SOC0127SearchCond cond);
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0127Info> searchEiBelongRelationVW2(SOC0127SearchCond cond);
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> searchMaxEiBelongRelation(SOC0110SearchCond cond);
	
	/**
	 * 根据父查询所有存在的关系码
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<String> searchBrassetrelationByBrpareiid(final SOC0110SearchCond cond);
	
	/**
	 * 根据顶级设备查询该类型码数据
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> searchInBrassetrelationByEirootmark(final SOC0110SearchCondImpl cond);

	public void delByEiid(Integer eiid);

}