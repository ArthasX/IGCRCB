/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG611Info;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * 概述: 资产模型属性缺省值DAO接口
  * 功能描述: 资产模型属性缺省值DAO接口
  * 创建记录: 2012/07/20
  * 修改记录: 
  */
public interface IG611DAO extends BaseHibernateDAO<IG611Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG611Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG611Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG611SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG611Info> findByCond(
			final IG611SearchCond cond, final int start,
			final int count);
	
	/**
	 * 资产属性默认值取得
	 * 
	 * @param cond 检索条件
	 * @return 资产属性默认值
	 */
	public  List<IG612Info> searchDefaultValue(final IG611SearchCond cond);
	
	/**
	 * 资产属性初期化查询
	 * 
	 * @param cond 检索条件
	 * @return 资产属性
	 */
	public  List<IG612Info> searchDefaultLabel(final IG611SearchCond cond);

}