/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.syslog.model.Mss00006Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00006SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00006TB;

/**
  * 概述: 告警信息月表DAO实现
  * 功能描述: 告警信息月表DAO实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Mss00006DAOImpl extends
		BaseHibernateDAOImpl<Mss00006Info> implements Mss00006DAO {

	/**
	 * 构造函数
	 */
	public Mss00006DAOImpl(){
		super(Mss00006TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00006Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00006Info findByPK(Serializable pk) {
		Mss00006Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 * @throws Exception 
	 */
	public int getSearchCount(final Mss00006SearchCond cond) throws Exception{
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
	public List<Mss00006Info> findByCond(final Mss00006SearchCond cond, final int start, final int count) throws Exception{
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("syslogtime"));//按照时间由近到远排序
		c.addOrder(Order.desc("rulelevel"));//按照级别由高到低排序
		return findByCriteria(c, start, count);
	}

	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 * @throws BLException 
	 */
	protected DetachedCriteria getCriteria(Mss00006SearchCond cond) throws Exception{
		DetachedCriteria c = getDetachedCriteria();
		
		//当告警IP不为空时
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.like("deviceip", "%"+cond.getIp_like()+"%"));
		}
//		//当告警优先级不为空时
//		if(StringUtils.isNotEmpty(cond.getPriority_eq())){
//			c.add(Expression.eq("rulelevel", cond.getPriority_eq()));
//		}
		//当开始的告警触发时间不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmtime_from())){
			//转换触发时间
			c.add(Expression.ge("syslogtime", cond.getAlarmtime_from()));
		}
		//当结束的告警触发时间不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmtime_to())){
			//转换触发时间
			c.add(Expression.le("syslogtime", cond.getAlarmtime_to()));
		}
		//当告警内容关键字不为空时
		if(StringUtils.isNotEmpty(cond.getWord_like())){
			c.add(Expression.like("syslogmsg", "%"+cond.getWord_like()+"%"));
		}
		//当设备类型syscoding不为空时
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		//当告警状态alarmstate不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmstate())){
			c.add(Expression.eq("alarmstate", new Integer(cond.getAlarmstate())));
		}
		if(cond.getPriority() != null && cond.getPriority().length != 0){
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		return c;
	}

}