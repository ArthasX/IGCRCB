/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;
import com.deliverik.infogovernor.dbm.model.condition.Ip_FilterSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.Ip_FilterTB;

/**
  * 概述: 全网IP过滤DAO实现
  * 功能描述: 全网IP过滤DAO实现
  * 创建记录: 2012/11/07
  * 修改记录: 
  */
public class Ip_FilterDAOImpl extends
		BaseHibernateDAOImpl<Ip_FilterInfo> implements Ip_FilterDAO {

	/**
	 * 构造函数
	 */
	public Ip_FilterDAOImpl(){
		super(Ip_FilterTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Ip_FilterInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("addtime"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Ip_FilterInfo findByPK(Serializable pk) {
		Ip_FilterInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Ip_FilterSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Ip_FilterInfo> findByCond(final Ip_FilterSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Ip_FilterSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		/** IP地址 */
		if(StringUtils.isNotEmpty(cond.getIp())){
		    c.add(Expression.eq("ip", cond.getIp()));
		}
		return c;
	}

}