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
import com.deliverik.infogovernor.syslog.model.Mss00012Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00012SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00012TB;

/**
  * 概述: MSS00012DAO实现
  * 功能描述: MSS00012DAO实现
  * 创建记录: 2013/04/25
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Mss00012DAOImpl extends
		BaseHibernateDAOImpl<Mss00012Info> implements Mss00012DAO {

	/**
	 * 构造函数
	 */
	public Mss00012DAOImpl(){
		super(Mss00012TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00012Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00012Info findByPK(Serializable pk) {
		Mss00012Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Mss00012SearchCond cond) throws Exception{
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
	 * @throws Exception 
	 */
	public List<Mss00012Info> findByCond(final Mss00012SearchCond cond, final int start, final int count) throws Exception{
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Mss00012SearchCond cond) throws Exception{
		DetachedCriteria c = getDetachedCriteria();
		
		//当告警IP不为空时
		// 当告警IP不为空时
		if (StringUtils.isNotEmpty(cond.getIp_like())) {
			c.add(Expression.like("deviceip", "%" + cond.getIp_like() + "%"));
		}
		// 当开始的告警触发时间不为空时
		if (StringUtils.isNotEmpty(cond.getStarttime_from())) {
			// 转换触发时间
			c.add(Expression.ge("starttime", cond.getStarttime_from()));
		}
		// 当结束的告警触发时间不为空时
		if (StringUtils.isNotEmpty(cond.getStarttime_to())) {
			// 转换触发时间
			c.add(Expression.le("starttime", cond.getStarttime_to()));
		}

		if (StringUtils.isNotEmpty(cond.getEndtime_from())) {
			// 转换触发时间
			c.add(Expression.ge("endtime", cond.getEndtime_from()));
		}
		// 当结束的告警触发时间不为空时
		if (StringUtils.isNotEmpty(cond.getStarttime_to())) {
			// 转换触发时间
			c.add(Expression.le("endtime", cond.getStarttime_to()));
		}

		// 当告警内容关键字不为空时
		if (StringUtils.isNotEmpty(cond.getWord_like())) {
			c.add(Expression.like("alarmmsg", "%" + cond.getWord_like() + "%"));
		}
		// 当设备类型syscoding不为空时
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		if (cond.getPriority() != null && cond.getPriority().length != 0) {
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		if (cond.getCvalue() != null && cond.getCvalue().length != 0) {
			c.add(Expression.in("rulelevel", cond.getCvalue()));
		}
		if (StringUtils.isNotEmpty(cond.getState())) {
			c.add(Expression.eq("state",Integer.parseInt(cond.getState())));
		}
		if(cond.getId()!=null&&cond.getId().length!=0)
		{
			c.add(Expression.in("id", cond.getId()));
		}
		return c;
	}

}