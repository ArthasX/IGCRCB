/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;

/**
  * 概述: 导入数据版本管理表DAO接口
  * 功能描述: 导入数据版本管理表DAO接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0120DAO extends BaseHibernateDAO<SOC0120Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0120Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0120Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0120SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0120Info> findByCond(
			final SOC0120SearchCond cond, final int start,
			final int count);
	
	/**
	 * 导入对象版本检索
	 * @param impversion 
	 */
	public List<SOC0120Info> searchImportVersionByImpname(String impeiname, Integer impversion);

	/**
	 * 导入对象不存在检查
	 * 
	 * @param impeiname实体名
	 * @return
	 * @throws BLException 
	 */
	public List<SOC0120Info> findByImpeiname(SOC0120SearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0120Info> findByCondAutoCollect(
			final SOC0120SearchCond cond, final int start,
			final int count);
}