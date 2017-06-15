/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.syslog.model.Mss00011Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00011SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00011VW;

/**
  * 概述: mss00011DAO实现
  * 功能描述: mss00011DAO实现
  * 创建记录: 2013/04/16
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Mss00011DAOImpl extends
		BaseHibernateDAOImpl<Mss00011Info> implements Mss00011DAO {

	/**
	 * 构造函数
	 */
	public Mss00011DAOImpl(){
		super(Mss00011VW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00011Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00011Info findByPK(Serializable pk) {
		Mss00011Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Mss00011SearchCond cond){
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
	public List<Mss00011Info> findByCond(final Mss00011SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Mss00011SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//当告警IP不为空时
		if(StringUtils.isNotEmpty(cond.getName_like())){
			c.add(Expression.like("devicename", "%"+cond.getName_like()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getType_eq())){
			c.add(Expression.eq("typeid", cond.getType_eq()));
		}
		return c;
	}

}