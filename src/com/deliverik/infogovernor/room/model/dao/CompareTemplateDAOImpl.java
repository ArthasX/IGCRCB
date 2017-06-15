/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.room.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.room.model.CompareTemplateInfo;
import com.deliverik.infogovernor.room.model.condition.CompareTemplateSearchCond;
import com.deliverik.infogovernor.room.model.entity.CompareTemplateTB;

/**
  * 概述: compareTemplateDAO实现
  * 功能描述: compareTemplateDAO实现
  * 创建记录: 2011/05/23
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CompareTemplateDAOImpl extends
		BaseHibernateDAOImpl<CompareTemplateInfo> implements CompareTemplateDAO {

	/** 分区类型 */
	public static final String UNNORMAL_TYPE_1 = "zone";
	/** 无效地板类型 */
	public static final String UNNORMAL_TYPE_2 = "naf";
	
	/**
	 * 构造函数
	 */
	public CompareTemplateDAOImpl(){
		super(CompareTemplateTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareTemplateInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareTemplateInfo findByPK(Serializable pk) {
		CompareTemplateInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareTemplateSearchCond cond){
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
	public List<CompareTemplateInfo> findByCond(final CompareTemplateSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ctindex"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CompareTemplateSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getCategory())){
			c.add(Expression.eq("ctcategory", cond.getCategory()));
		}
		if(StringUtils.isNotEmpty(cond.getCabtype())){
			c.add(Expression.like("cttype", cond.getCabtype()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getType())){
			c.add(Expression.eq("cttype", cond.getType()));
		}
		if(cond.getLegendArray() != null){
			c.add(Expression.in("cttype", cond.getLegendArray()));
		}
		if(StringUtils.isNotEmpty(cond.getCteiid())){
			c.add(Expression.eq("cteiid", cond.getCteiid()));
		}
		if(StringUtils.isNotEmpty(cond.getNetype())){
			c.add(Expression.ne("cttype", cond.getNetype()));
		}
		if(StringUtils.isNotEmpty(cond.getCtZoneId())){
			c.add(Expression.eq("ctZoneId", cond.getCtZoneId()));
		}
		if("ok".equals(cond.getNotZoneAndNotNafFlag())){
			c.add(Expression.and(Expression.ne("cttype", UNNORMAL_TYPE_1), Expression.ne("cttype", UNNORMAL_TYPE_2)));
		}
		if(StringUtils.isNotEmpty(cond.getCtfloorx())){
			c.add(Expression.eq("ctfloorx", cond.getCtfloorx()));
		}
		if(StringUtils.isNotEmpty(cond.getCtfloory())){
			c.add(Expression.eq("ctfloory", cond.getCtfloory()));
		}
		return c;
	}

}