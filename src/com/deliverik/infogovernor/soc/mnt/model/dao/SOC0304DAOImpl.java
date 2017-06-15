/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0304SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0304TB;

/**
  * 概述: 监控任务主表DAO实现
  * 功能描述: 监控任务主表DAO实现
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0304DAOImpl extends
		BaseHibernateDAOImpl<SOC0304Info> implements SOC0304DAO {

	/**
	 * 构造函数
	 */
	public SOC0304DAOImpl(){
		super(SOC0304TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0304Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0304Info findByPK(Serializable pk) {
		SOC0304Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0304SearchCond cond){
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
	public List<SOC0304Info> findByCond(final SOC0304SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0304SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//状态
		if(StringUtils.isNotEmpty(cond.getMtStatus())){
			c.add(Expression.eq("mtStatus", cond.getMtStatus()));
		}
		//磁盘序列号
		if(StringUtils.isNotEmpty(cond.getMtSsn())){
			c.add(Expression.eq("mtSsn", cond.getMtSsn()));
		}
		c.addOrder(Order.asc("mtId"));
		return c;
	}

}