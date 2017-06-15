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
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectTB;

/**
  * 概述: 监控对象信息DAO实现
  * 功能描述: 监控对象信息DAO实现
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class MonitorObjectDAOImpl extends
		BaseHibernateDAOImpl<MonitorObjectInfo> implements MonitorObjectDAO {

	/**
	 * 构造函数
	 */
	public MonitorObjectDAOImpl(){
		super(MonitorObjectTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorObjectInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorObjectInfo findByPK(Serializable pk) {
		MonitorObjectInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MonitorObjectSearchCond cond){
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
	public List<MonitorObjectInfo> findByCond(final MonitorObjectSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(MonitorObjectSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getMtSyscoding())){
			c.add(Expression.eq("mtSyscoding", cond.getMtSyscoding()));
		}
		if(StringUtils.isNotEmpty(cond.getMoName())){
			c.add(Expression.eq("moName", cond.getMoName()));
		}
		if(StringUtils.isNotEmpty(cond.getMoCreateTime_from())){
			c.add(Expression.ge("moCreateTime", cond.getMoCreateTime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getMoCreateTime_to())){
			c.add(Expression.le("moCreateTime", cond.getMoCreateTime_to()));
		}
		return c;
	}

}