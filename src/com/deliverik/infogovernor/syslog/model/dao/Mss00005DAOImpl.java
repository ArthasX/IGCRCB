/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00005SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00005TB;
import com.ibm.icu.text.SimpleDateFormat;

/**
  * 概述: 告警信息天表DAO实现
  * 功能描述: 告警信息天表DAO实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Mss00005DAOImpl extends
		BaseHibernateDAOImpl<Mss00005Info> implements Mss00005DAO {

	/**
	 * 构造函数
	 */
	public Mss00005DAOImpl(){
		super(Mss00005TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00005Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00005Info findByPK(Serializable pk) {
		Mss00005Info result = super.findByPK(pk);
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
	public int getSearchCount(final Mss00005SearchCond cond) throws Exception{
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
	public List<Mss00005Info> findByCond(final Mss00005SearchCond cond, final int start, final int count) throws Exception{
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
	protected DetachedCriteria getCriteria(Mss00005SearchCond cond) throws Exception{
		DetachedCriteria c = getDetachedCriteria();
		
		//当告警IP不为空时
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.like("deviceip", "%"+cond.getIp_like()+"%"));
		}
//		//当告警优先级不为空时
//		if(StringUtils.isNotEmpty(cond.getPriority_eq())){
//			c.add(Expression.eq("rulelevel", cond.getPriority_eq()));
//		}
		if(cond.getPriority() != null && cond.getPriority().length != 0){
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		//当开始的告警触发时间不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmtime_from())){
			//转换触发时间
			c.add(Expression.ge("syslogtime", cond.getAlarmtime_from()));
		//为空时默认显示当天的全部告警
		}else{
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String from = format.format(date) + " 00:00";
			c.add(Expression.ge("syslogtime", from));
		}
		//当结束的告警触发时间不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmtime_to())){
			//转换触发时间
			c.add(Expression.le("syslogtime", cond.getAlarmtime_to()));
		}else{
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String to = format.format(date) + " 23:59";
			c.add(Expression.le("syslogtime", to));
		}
		//当告警内容关键字不为空时
		if(StringUtils.isNotEmpty(cond.getWord_like())){
			c.add(Expression.like("syslogmsg", "%"+cond.getWord_like()+"%"));
		}
		//当设备类型syscoding不为空时
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		//当告警状态不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmstate())){
			c.add(Expression.eq("alarmstate", new Integer(cond.getAlarmstate())));
		}
		//当要修复的告警id不为空时
		if(cond.getIds() != null && cond.getIds().length != 0){
			Integer[] ids = new Integer[cond.getIds().length];
			for(int i = 0;i<cond.getIds().length;i++){
				ids[i] = Integer.parseInt(cond.getIds()[i]);
			}
			c.add(Expression.in("alarmid", ids));
		}
		return c;
	}
	
}