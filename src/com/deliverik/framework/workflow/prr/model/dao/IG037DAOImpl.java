/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG037Info;
import com.deliverik.framework.workflow.prr.model.condition.IG037SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG037TB;

/**
  * 概述: 流程导入日志表DAO实现
  * 功能描述: 流程导入日志表DAO实现
  * 创建记录: 2014/11/14
  * 修改记录: 
  */
public class IG037DAOImpl extends
		BaseHibernateDAOImpl<IG037Info> implements IG037DAO {

	/**
	 * 构造函数
	 */
	public IG037DAOImpl(){
		super(IG037TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG037Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG037Info findByPK(Serializable pk) {
		IG037Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG037SearchCond cond){
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
	public List<IG037Info> findByCond(final IG037SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG037SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//流程主键
		if(cond.getPrid() != null && cond.getPrid() != 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		
		//流程导入用户ID
		if(StringUtils.isBlank(cond.getIruserid())){
			c.add(Restrictions.eq("iruserid", cond.getIruserid()));
		}
		
		//流程导入部门ID
		if(StringUtils.isBlank(cond.getIrorgid())){
			c.add(Restrictions.eq("irorgid", cond.getIrorgid()));
		}
		
		//流程导入部门ID左匹配
		if(StringUtils.isBlank(cond.getIrorgid_like_l())){
			c.add(Restrictions.like("irorgid", cond.getIrorgid_like_l()));
		}
		
		return c;
	}

}