/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0114PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0114TB;

/**
  * 概述: 实体链路图业务逻辑接口
  * 功能描述: 实体链路图业务逻辑接口
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
public interface SOC0114BL extends BaseBL {

	/**
	 * 实体链路图实例取得
	 *
	 * @return 实体链路图实例
	 */
	public SOC0114TB getEiLinkMapTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0114Info> searchEiLinkMap();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0114Info searchEiLinkMapByPK(SOC0114PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0114SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0114Info> searchEiLinkMap(
			SOC0114SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0114Info> searchEiLinkMap(
			SOC0114SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0114Info registEiLinkMap(SOC0114Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0114Info updateEiLinkMap(SOC0114Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEiLinkMapByPK(SOC0114PK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEiLinkMap(SOC0114Info instance)
		throws BLException;
	
	/**
	 * 拓扑图链路检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0114Info> queryEiLinkMapList(SOC0114SearchCond cond);
	
	/**
	 * 影响CI检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> queryImpactCI(final SOC0114SearchCond cond);
	
	public List<SOC0114Info> searchEiLinkMapByOtherEiid(EiLinkMapSearchCondImpl emCond);

	/**
	 * 根据eiid 删除链路
	 * @param eiid
	 */
	public void delByEiid (Integer eiid)throws BLException;
	/**
	 * 根据eiid查询与其相关的业务系统eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchLinkByEiid(Integer eiid)throws BLException;
}