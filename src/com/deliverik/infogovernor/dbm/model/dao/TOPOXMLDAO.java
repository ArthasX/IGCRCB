/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;
import com.deliverik.infogovernor.dbm.model.condition.TOPOXMLSearchCond;

/**
  * 概述: TOPOXMLDAO接口
  * 功能描述: TOPOXMLDAO接口
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
public interface TOPOXMLDAO extends BaseHibernateDAO<TOPOXMLInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TOPOXMLInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TOPOXMLInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final TOPOXMLSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<TOPOXMLInfo> findByCond(
			final TOPOXMLSearchCond cond, final int start,
			final int count);
	
	/**
	 * 根据用户删除对象
	 * @param userid 用户ID
	 * */
	public boolean deleteTOPOXMLByUserid(String userid);
}