/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wki.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.birt.report.model.api.util.StringUtil;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;
import com.deliverik.infogovernor.wki.model.condition.WorkinfoSearchCond;
import com.deliverik.infogovernor.wki.model.entity.WorkinfoTB;

/**
  * 概述: 工作信息DAO实现
  * 功能描述: 工作信息DAO实现
  * 创建记录: 2017/03/02
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class WorkinfoDAOImpl extends
		BaseHibernateDAOImpl<WorkinfoInfo> implements WorkinfoDAO {

	/**
	 * 构造函数
	 */
	public WorkinfoDAOImpl(){
		super(WorkinfoTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkinfoInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkinfoInfo findByPK(Serializable pk) {
		WorkinfoInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkinfoSearchCond cond){
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
	public List<WorkinfoInfo> findByCond(final WorkinfoSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(WorkinfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getWorkName()))
			c.add(Expression.like("execname","%"+ cond.getWorkName()+"%"));
		if(StringUtils.isNotEmpty(cond.getExecName()))
			c.add(Expression.like("execname","%"+ cond.getExecName()+"%"));
		if(StringUtils.isNotEmpty(cond.getInitName()))
			c.add(Expression.like("execname","%"+ cond.getInitName()+"%"));
		return c;
	}

}