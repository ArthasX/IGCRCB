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
import com.deliverik.infogovernor.rpt.model.SOC0209Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0209SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0209VW;

/**
  * 概述: 流程来源视图DAO实现
  * 功能描述: 流程来源视图DAO实现
  * 创建记录: 2011/11/24
  * 修改记录: 2012/08/09 将ProcessRecordInfoVWDAOImpl表名改为SOC0209DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0209DAOImpl extends
		BaseHibernateDAOImpl<SOC0209Info> implements SOC0209DAO {

	/**
	 * 构造函数
	 */
	public SOC0209DAOImpl(){
		super(SOC0209VW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0209Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0209Info findByPK(Serializable pk) {
		SOC0209Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0209SearchCond cond){
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
	public List<SOC0209Info> findByCond(final SOC0209SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0209SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPrtype())){
			c.add(Expression.eq("prtype", cond.getPrtype()));
		}
		if(StringUtils.isNotEmpty(cond.getPropentime())){
			c.add(Expression.sql(" substr(this_.propentime,1,7)='"+cond.getPropentime().substring(0, 7)+"'"));
		}
		return c;
	}

}