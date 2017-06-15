/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;
import com.deliverik.infogovernor.rdp.model.condition.RealtimedetailSearchCond;
import com.deliverik.infogovernor.rdp.model.entity.RealtimedetailTB;

/**
  * 概述: 日志信息DAO实现
  * 功能描述: 日志信息DAO实现
  * 创建记录: 2014/05/06
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class RealtimedetailDAOImpl extends
		BaseHibernateDAOImpl<RealtimedetailInfo> implements RealtimedetailDAO {

	/**
	 * 构造函数
	 */
	public RealtimedetailDAOImpl(){
		super(RealtimedetailTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<RealtimedetailInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
	public RealtimedetailInfo findByPK(Serializable pk) {
		RealtimedetailInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RealtimedetailSearchCond cond){
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
	public List<RealtimedetailInfo> findByCond(final RealtimedetailSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
//		c.addOrder(Order.desc("id"));
		c.addOrder(Order.asc("id"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RealtimedetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(null!=cond.getTaskid()){
			c.add(Expression.eq("taskid", cond.getTaskid()));
		}
		if(StringUtils.isNotEmpty(cond.getHostip())){
			c.add(Expression.eq("hostip", cond.getHostip()));
		}
		if(null!=cond.getRtdid_gt()){
			c.add(Expression.gt("id", cond.getRtdid_gt()));
		}
		return c;
	}

}