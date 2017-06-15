/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0152Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0152SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0152TB;

/**
  * 概述: 资产关系表DAO实现
  * 功能描述: 资产关系表DAO实现
  * 创建记录: 杨龙全 2013/05/27
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0152DAOImpl extends
		BaseHibernateDAOImpl<SOC0152Info> implements SOC0152DAO {

	/**
	 * 构造函数
	 */
	public SOC0152DAOImpl(){
		super(SOC0152TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0152Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0152Info findByPK(Serializable pk) {
		SOC0152Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0152SearchCond cond){
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
	public List<SOC0152Info> findByCond(final SOC0152SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	
	protected DetachedCriteria getCriteria(SOC0152SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//模型从
		if (StringUtils.isNotEmpty(cond.getFromModelEid_eq())) {
			c.add(Expression.eq("fromModelEid", cond.getFromModelEid_eq()));
		}
		//模型到
		if (StringUtils.isNotEmpty(cond.getToModelEid_eq())) {
			c.add(Expression.eq("toModelEid", cond.getToModelEid_eq()));
		}
		//关系码等于
		if (StringUtils.isNotEmpty(cond.getRlnCode_eq())) {
			c.add(Expression.eq("rlnCode", cond.getRlnCode_eq()));
		}
		//关系码包含
		if (cond.getRlnCode_in()!=null&&cond.getRlnCode_in().size()>0) {
			c.add(Expression.in("rlnCode", cond.getRlnCode_in()));
		}
		//关系码包含
		if (StringUtils.isNotEmpty(cond.getRlnType_eq())) {
			c.add(Expression.eq("rlnType", cond.getRlnType_eq()));
		}
		return c;
	}

}