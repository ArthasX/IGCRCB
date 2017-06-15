/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EvaluationContentInfo;
import com.deliverik.infogovernor.drm.model.condition.EvaluationContentSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EvaluationContentTB;

/**
  * 概述: 项目周报人员工作量DAO实现
  * 功能描述: 项目周报人员工作量DAO实现
  * 创建记录: 2016/08/11
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class EvaluationContentDAOImpl extends
		BaseHibernateDAOImpl<EvaluationContentInfo> implements EvaluationContentDAO {

	/**
	 * 构造函数
	 */
	public EvaluationContentDAOImpl(){
		super(EvaluationContentTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EvaluationContentInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EvaluationContentInfo findByPK(Serializable pk) {
		EvaluationContentInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EvaluationContentSearchCond cond){
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
	public List<EvaluationContentInfo> findByCond(final EvaluationContentSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EvaluationContentSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid()!=null){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(cond.getPsdid()!=null&&!cond.getPsdid().isEmpty()){
			c.add(Expression.eq("psdid",cond.getPsdid()));
		}
		if(cond.getSortId()!=null){
			c.add(Expression.eq("sortId",cond.getSortId()));
		}
		if(cond.getFlowType()!=null){
			c.add(Expression.eq("flowType",cond.getFlowType()));
		}
		c.addOrder(Order.asc("sortId"));
		return c;
	}

}