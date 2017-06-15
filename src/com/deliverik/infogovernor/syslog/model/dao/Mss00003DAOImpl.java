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
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00003SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00003TB;

/**
  * 概述: 告警规则条件表DAO实现
  * 功能描述: 告警规则条件表DAO实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Mss00003DAOImpl extends
		BaseHibernateDAOImpl<Mss00003Info> implements Mss00003DAO {

	/**
	 * 构造函数
	 */
	public Mss00003DAOImpl(){
		super(Mss00003TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00003Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00003Info findByPK(Serializable pk) {
		Mss00003Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Mss00003SearchCond cond){
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
	public List<Mss00003Info> findByCond(final Mss00003SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Mss00003SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
//		if( !StringUtils.isEmpty(cond.getRuleid().toString())){
//			c.add(Expression.eq("ruleid", cond.getRuleid()));
//		}
		if(!StringUtils.isEmpty(cond.getIsTemp())){
			if("1".equals(cond.getIsTemp())){
				c.add(Expression.isNotNull("ruletempid"));
			}else if("2".equals(cond.getIsTemp())){
				c.add(Expression.isNull("ruletempid"));
			}
		}
		if(cond.getRuletempid()!=null){
			c.add(Expression.eq("ruletempid", cond.getRuletempid()));
		}
		return c;
	}

}