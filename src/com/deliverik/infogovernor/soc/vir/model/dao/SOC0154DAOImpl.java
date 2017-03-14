/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.SOC0154Info;
import com.deliverik.infogovernor.soc.vir.model.condition.SOC0154SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.SOC0154TB;

/**
  * 概述: soc0154DAO实现
  * 功能描述: soc0154DAO实现
  * 创建记录: 2013/12/29
  * 修改记录: 
  */
public class SOC0154DAOImpl extends
		BaseHibernateDAOImpl<SOC0154Info> implements SOC0154DAO {

	/**
	 * 构造函数
	 */
	public SOC0154DAOImpl(){
		super(SOC0154TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0154Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0154Info findByPK(Serializable pk) {
		SOC0154Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0154SearchCond cond){
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
	public List<SOC0154Info> findByCond(final SOC0154SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0154SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getFromid())){
			c.add(Expression.eq("fromid", cond.getFromid()));
		}
		if(StringUtils.isNotEmpty(cond.getIsellipsis())){
			c.add(Expression.eq("isellipsis", cond.getIsellipsis()));
		}
		return c;
	}

}