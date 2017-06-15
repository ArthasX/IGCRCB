/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0208SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0208TB;

/**
  * 概述: 事件变更服务效率DAO实现
  * 功能描述: 事件变更服务效率DAO实现
  * 创建记录: 2011/11/23
  * 修改记录: 2012/08/10 将ServeEfficiencyDAOImpl表名修改为SOC0208DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0208DAOImpl extends
		BaseHibernateDAOImpl<SOC0208Info> implements SOC0208DAO {

	/**
	 * 构造函数
	 */
	public SOC0208DAOImpl(){
		super(SOC0208TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0208Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0208Info findByPK(Serializable pk) {
		SOC0208Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0208SearchCond cond){
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
	public List<SOC0208Info> findByCond(final SOC0208SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0208SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPrtype())){
			c.add(Expression.eq("prtype", cond.getPrtype()));
		}
		if(StringUtils.isNotEmpty(cond.getIsNotTime())){
			c.add(Expression.sql(" this_.efficiencytime!='"+cond.getIsNotTime()+"'"));
		}
		
		return c;
	}

}