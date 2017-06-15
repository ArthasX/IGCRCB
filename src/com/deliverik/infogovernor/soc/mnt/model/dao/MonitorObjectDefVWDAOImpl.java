/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefVWInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefVWSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefVW;

/**
  * 概述: 监控对象KPI信息视图DAO实现
  * 功能描述: 监控对象KPI信息视图DAO实现
  * 创建记录: 2012/02/13
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class MonitorObjectDefVWDAOImpl extends
		BaseHibernateDAOImpl<MonitorObjectDefVWInfo> implements MonitorObjectDefVWDAO {

	/**
	 * 构造函数
	 */
	public MonitorObjectDefVWDAOImpl(){
		super(MonitorObjectDefVW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorObjectDefVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorObjectDefVWInfo findByPK(Serializable pk) {
		MonitorObjectDefVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MonitorObjectDefVWSearchCond cond){
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
	public List<MonitorObjectDefVWInfo> findByCond(final MonitorObjectDefVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(MonitorObjectDefVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//当监控对象名称不为空时
		if(StringUtils.isNotEmpty(cond.getMoName())){
			c.add(Expression.eq("moName", cond.getMoName()));
		}
		
		//状态
		if(StringUtils.isNotEmpty(cond.getDeleteFlag())){
			c.add(Expression.eq("deleteFlag", cond.getDeleteFlag()));
		}
		return c;
	}

}