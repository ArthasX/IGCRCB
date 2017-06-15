/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCond;

/**
  * 概述: 实体链路图DAO接口
  * 功能描述: 实体链路图DAO接口
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
public interface SOC0114DAO extends BaseHibernateDAO<SOC0114Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0114Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0114Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0114SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0114Info> findByCond(
			final SOC0114SearchCond cond, final int start,
			final int count);
	
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
	public void delByEiid (Integer eiid );

	/**
	 * 根据eiid查询与其相关的业务系统eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchLinkByEiid(Integer eiid);
}