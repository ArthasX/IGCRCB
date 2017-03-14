/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG001TB;

/**
  * 概述: OA角色配置表DAO实现
  * 功能描述: OA角色配置表DAO实现
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG001DAOImpl extends
		BaseHibernateDAOImpl<IG001Info> implements IG001DAO {

	/**
	 * 构造函数
	 */
	public IG001DAOImpl(){
		super(IG001TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG001Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG001Info findByPK(Serializable pk) {
		IG001Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG001SearchCond cond){
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
	public List<IG001Info> findByCond(final IG001SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG001SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//指定机构相关的角色类型
		if(StringUtils.isNotEmpty(cond.getProtype_eq())){
			c.add(Expression.eq("protype", cond.getProtype_eq()));
		}
		return c;
	}

}