/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG484TB;

/**
  * 概述: 流程组成员实例DAO实现
  * 功能描述: 流程组成员实例DAO实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG484DAOImpl extends
		BaseHibernateDAOImpl<IG484Info> implements IG484DAO {

	/**
	 * 构造函数
	 */
	public IG484DAOImpl(){
		super(IG484TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG484Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG484Info findByPK(Serializable pk) {
		IG484Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG484SearchCond cond){
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
	public List<IG484Info> findByCond(final IG484SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG484SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//流程组ID
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		//流程组ID
		if(cond.getPgrid() != null && cond.getPgrid() > 0){
			c.add(Restrictions.eq("pgrid", cond.getPgrid()));
		}
		return c;
	}

}