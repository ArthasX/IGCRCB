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
import com.deliverik.infogovernor.syslog.model.Mss00013Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00013SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00013TB;

/**
  * 概述: mss00013DAO实现
  * 功能描述: mss00013DAO实现
  * 创建记录: 2013/08/15
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Mss00013DAOImpl extends
		BaseHibernateDAOImpl<Mss00013Info> implements Mss00013DAO {

	/**
	 * 构造函数
	 */
	public Mss00013DAOImpl(){
		super(Mss00013TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00013Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00013Info findByPK(Serializable pk) {
		Mss00013Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Mss00013SearchCond cond){
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
	public List<Mss00013Info> findByCond(final Mss00013SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Mss00013SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getIp_eq())){
			c.add(Expression.eq("deviceip", cond.getIp_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getPriority_eq())){
			c.add(Expression.eq("rulelevel", cond.getPriority_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getContent())){
			c.add(Expression.eq("alarmmsg", cond.getContent()));
		}
		if (cond.getCvalue() != null && cond.getCvalue().length != 0) {
			c.add(Expression.in("rulelevel", cond.getCvalue()));
		}
		
		if (StringUtils.isNotEmpty(cond.getIp_like())) {
			c.add(Expression.like("deviceip", "%" + cond.getIp_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getContent_like())){
			c.add(Expression.like("alarmmsg", "%" + cond.getContent_like() + "%"));
		}
		return c;
	}

}