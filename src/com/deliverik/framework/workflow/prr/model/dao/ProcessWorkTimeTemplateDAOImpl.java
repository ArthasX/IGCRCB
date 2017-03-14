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
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeTemplateSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTemplateTB;


/**
  * 概述: 作息时间模板定义表DAO实现
  * 功能描述: 作息时间模板定义表DAO实现
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ProcessWorkTimeTemplateDAOImpl extends
		BaseHibernateDAOImpl<ProcessWorkTimeTemplateInfo> implements ProcessWorkTimeTemplateDAO {

	/**
	 * 构造函数
	 */
	public ProcessWorkTimeTemplateDAOImpl(){
		super(ProcessWorkTimeTemplateTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProcessWorkTimeTemplateInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProcessWorkTimeTemplateInfo findByPK(Serializable pk) {
		ProcessWorkTimeTemplateInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ProcessWorkTimeTemplateSearchCond cond){
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
	public List<ProcessWorkTimeTemplateInfo> findByCond(final ProcessWorkTimeTemplateSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pwtDate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ProcessWorkTimeTemplateSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getDate_like())){
			c.add(Expression.like("pwtDate", "%"+cond.getDate_like()+"%"));
		}
		return c;
	}

}