/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;

/**
  * 概述: 抄阅人表DAO接口
  * 功能描述: 抄阅人表DAO接口
  * 创建记录: 2013/02/25
  * 修改记录: 
  */
public interface CopyReadUserDAO extends BaseHibernateDAO<CopyReadUserInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CopyReadUserInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CopyReadUserInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CopyReadUserSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CopyReadUserInfo> findByCond(
			final CopyReadUserSearchCond cond, final int start,
			final int count);

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public List<CopyReadUserInfo> getCopyReadUserInfo(
			final CopyReadUserSearchCond cond, final int start,final int count);
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int getCopyReadUserCount( final CopyReadUserSearchCond cond) ;
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public List<CopyReadUserInfo> getCopyReadUserInfoDesc(final CopyReadUserSearchCond cond, final int start,final int count);
}