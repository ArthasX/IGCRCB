/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0127Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0127SearchCond;

/**
  * 概述: 配置所属关系表DAO接口
  * 功能描述: 配置所属关系表DAO接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0110DAO extends BaseHibernateDAO<SOC0110Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0110Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0110Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0110SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> findByCond(
			final SOC0110SearchCond cond, final int start,
			final int count);
	
	/**
	 * 配置包含关系检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0127Info> searchEiBelongRelationVW(final SOC0127SearchCond cond);
	
	/**
	 * 配置包含关系检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0127Info> searchEiBelongRelationVW2(final SOC0127SearchCond cond);
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> searchMaxEiBelongRelation(final SOC0110SearchCond cond);
	
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