/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.PortRelationInfo;
import com.deliverik.infogovernor.soc.model.condition.PortRelationSearchCond;
import com.deliverik.infogovernor.soc.model.entity.PortRelationPK;
import com.deliverik.infogovernor.soc.model.entity.PortRelationTB;

/**
  * 概述: 端到端关系表业务逻辑接口
  * 功能描述: 端到端关系表业务逻辑接口
  * 创建记录: 2013/01/17
  * 修改记录: 
  */
public interface PortRelationBL extends BaseBL {

	/**
	 * 端到端关系表实例取得
	 *
	 * @return 端到端关系表实例
	 */
	public PortRelationTB getPortRelationTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PortRelationInfo> searchPortRelation();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PortRelationInfo searchPortRelationByPK(PortRelationPK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(PortRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<PortRelationInfo> searchPortRelation(
			PortRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PortRelationInfo> searchPortRelation(
			PortRelationSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public PortRelationInfo registPortRelation(PortRelationInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public PortRelationInfo updatePortRelation(PortRelationInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deletePortRelationByPK(PortRelationPK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deletePortRelation(PortRelationInfo instance)
		throws BLException;
	/**
	 * 剩余hyper查询
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationStr(
			PortRelationSearchCond cond);
	/**
	 * 业务系统查询
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationBuss(
			PortRelationSearchCond cond);
	
	/**
	 * 主机&HBA关键字查询
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationHost(
			PortRelationSearchCond cond);
	/**
	 * 交换机关键字查询
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationSwitch(
			PortRelationSearchCond cond);
	/**
	 * FA
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationFa(
			PortRelationSearchCond cond);
	/**
	 * 查询meta与geteKeeper
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationHyper(
			PortRelationSearchCond cond);
	/**
	 * 线路查询Hyper得到FAeiid
	 * @param eiid
	 * @return
	 */
	public List<String> getHypeEiid(final String eiid,final String einame);
	
}