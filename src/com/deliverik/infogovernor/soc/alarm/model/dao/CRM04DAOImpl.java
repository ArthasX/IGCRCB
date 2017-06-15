/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM04SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM04TB;
import com.ibm.icu.text.SimpleDateFormat;

/**
  * 概述: CRM04DAO实现
  * 功能描述: CRM04DAO实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CRM04DAOImpl extends
		BaseHibernateDAOImpl<CRM04Info> implements CRM04DAO {

	/**
	 * 构造函数
	 */
	public CRM04DAOImpl(){
		super(CRM04TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM04Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM04Info findByPK(Serializable pk) {
		CRM04Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CRM04SearchCond cond){
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
	public List<CRM04Info> findByCond(final CRM04SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		
		c.addOrder(Order.desc("alarmtime"));//按照时间由近到远排序
		c.addOrder(Order.desc("rulelevel"));//按照级别由高到低排序
		
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CRM04SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//当告警IP不为空时
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.like("serverip", "%"+cond.getIp_like()+"%"));
		}
		if(cond.getPriority() != null && cond.getPriority().length != 0){
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		//当开始的告警触发时间不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmtime_from())){
			//转换触发时间
			c.add(Expression.ge("alarmtime", cond.getAlarmtime_from()));
		//为空时默认显示当天的全部告警
		}else{
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String from = format.format(date) + " 00:00";
			c.add(Expression.ge("alarmtime", from));
		}
		//当结束的告警触发时间不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmtime_to())){
			//转换触发时间
			c.add(Expression.le("alarmtime", cond.getAlarmtime_to()));
		}else{
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String to = format.format(date) + " 23:59";
			c.add(Expression.le("alarmtime", to));
		}
		//当告警内容关键字不为空时
		if(StringUtils.isNotEmpty(cond.getWord_like())){
			c.add(Expression.like("alarmmsg", "%"+cond.getWord_like()+"%"));
		}
		c.add(Expression.eq("alarmstate","1"));
		return c;
	}

}