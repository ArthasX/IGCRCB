/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogBusinessSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogBusinessTB;

/**
  * 概述: 项目日志付款表DAO实现
  * 功能描述: 项目日志付款表DAO实现
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ProjectLogBusinessDAOImpl extends
		BaseHibernateDAOImpl<ProjectLogBusinessInfo> implements ProjectLogBusinessDAO {

	/**
	 * 构造函数
	 */
	public ProjectLogBusinessDAOImpl(){
		super(ProjectLogBusinessTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProjectLogBusinessInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProjectLogBusinessInfo findByPK(Serializable pk) {
		ProjectLogBusinessInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ProjectLogBusinessSearchCond cond){
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
	public List<ProjectLogBusinessInfo> findByCond(final ProjectLogBusinessSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("plbid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ProjectLogBusinessSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//projectID
		if( cond.getPlbpid() != null && cond.getPlbpid() != 0){
			c.add(Expression.eq("plbpid", cond.getPlbpid()));
		}
		//projectLogID
		if( cond.getPlbplid() != null && cond.getPlbplid() != 0){
			c.add(Expression.eq("plbplid", cond.getPlbplid()));
		}
		return c;
	}

}