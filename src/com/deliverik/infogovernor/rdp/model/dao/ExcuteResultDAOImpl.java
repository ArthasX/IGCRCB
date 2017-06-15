/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;
import com.deliverik.infogovernor.rdp.model.condition.ExcuteResultSearchCond;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultTB;

/**
  * 概述: ExcuteResultDAO实现
  * 功能描述: ExcuteResultDAO实现
  * 创建记录: 2014/04/16
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ExcuteResultDAOImpl extends
		BaseHibernateDAOImpl<ExcuteResultInfo> implements ExcuteResultDAO {

	/**
	 * 构造函数
	 */
	public ExcuteResultDAOImpl(){
		super(ExcuteResultTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ExcuteResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ExcuteResultInfo findByPK(Serializable pk) {
		ExcuteResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ExcuteResultSearchCond cond){
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
	public List<ExcuteResultInfo> findByCond(final ExcuteResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ExcuteResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTaskID_eq() != null){
			c.add(Expression.eq("taskid",cond.getTaskID_eq()));
		}
		return c;
	}

}