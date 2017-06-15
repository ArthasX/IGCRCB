/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTB;


/**
  * 概述: 用户作息时间定义表DAO实现
  * 功能描述: 用户作息时间定义表DAO实现
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ProcessWorkTimeDAOImpl extends
		BaseHibernateDAOImpl<ProcessWorkTimeInfo> implements ProcessWorkTimeDAO {

	/**
	 * 构造函数
	 */
	public ProcessWorkTimeDAOImpl(){
		super(ProcessWorkTimeTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProcessWorkTimeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProcessWorkTimeInfo findByPK(Serializable pk) {
		ProcessWorkTimeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ProcessWorkTimeSearchCond cond){
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
	public List<ProcessWorkTimeInfo> findByCond(final ProcessWorkTimeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pwDate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ProcessWorkTimeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(StringUtils.isNotEmpty(cond.getStartDate())){
			c.add(Expression.ge("pwDate", cond.getStartDate()));
		}
		if(StringUtils.isNotEmpty(cond.getEndDate())){
			c.add(Expression.le("pwDate", cond.getEndDate()));
		}
		if(StringUtils.isNotEmpty(cond.getPwDate())){
			c.add(Expression.eq("pwDate", cond.getPwDate()));
		}
		if(StringUtils.isNotEmpty(cond.getPwFlg())){
			c.add(Expression.eq("pwFlg", cond.getPwFlg()));
		}
		if(StringUtils.isNotEmpty(cond.getPwDate_like())){
			c.add(Expression.like("pwDate", "%"+cond.getPwDate_like()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getUserId())){
			c.add(Expression.eq("userId", cond.getUserId()));
		}
		return c;
	}

}