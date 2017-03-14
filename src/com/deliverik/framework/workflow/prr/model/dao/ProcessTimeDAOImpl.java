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
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessTimeTB;


/**
  * 概述: 流程计时表DAO实现
  * 功能描述: 流程计时表DAO实现
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ProcessTimeDAOImpl extends
		BaseHibernateDAOImpl<ProcessTimeInfo> implements ProcessTimeDAO {

	/**
	 * 构造函数
	 */
	public ProcessTimeDAOImpl(){
		super(ProcessTimeTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProcessTimeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProcessTimeInfo findByPK(Serializable pk) {
		ProcessTimeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ProcessTimeSearchCond cond){
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
	public List<ProcessTimeInfo> findByCond(final ProcessTimeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("prtstartTime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ProcessTimeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid()!=null){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(StringUtils.isNotEmpty(cond.getUserId())){
			c.add(Expression.eq("userid", cond.getUserId()));
		}
		if(StringUtils.isNotEmpty(cond.getPrtstartTime_le())){
			c.add(Expression.le("prtstartTime", cond.getPrtstartTime_le()));
		}
		if(StringUtils.isNotEmpty(cond.getPrtEndTime_ge())){
			c.add(Expression.ge("prtEndTime", cond.getPrtEndTime_ge()));
		}
		return c;
	}
}