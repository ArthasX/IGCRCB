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
import com.deliverik.infogovernor.syslog.model.Mss00008Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00008SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00008TB;

/**
  * 概述: SYSLOG信息表DAO实现
  * 功能描述: SYSLOG信息表DAO实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Mss00008DAOImpl extends
		BaseHibernateDAOImpl<Mss00008Info> implements Mss00008DAO {

	/**
	 * 构造函数
	 */
	public Mss00008DAOImpl(){
		super(Mss00008TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00008Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00008Info findByPK(Serializable pk) {
		Mss00008Info result = super.findByPK(pk);
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
	public int getSearchCount(final Mss00008SearchCond cond) throws Exception{
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
	public List<Mss00008Info> findByCond(final Mss00008SearchCond cond, final int start, final int count) throws Exception{
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("createtime"));//按照时间由近到远排序
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
	protected DetachedCriteria getCriteria(Mss00008SearchCond cond) throws Exception{
		DetachedCriteria c = getDetachedCriteria();
		
		//当告警IP不为空时
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.like("deviceip", "%"+cond.getIp_like()+"%"));
		}
		if(cond.getPriority() != null && cond.getPriority().length != 0){
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		//当开始的告警触发时间不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmtime_from())){
			//转换触发时间
			c.add(Expression.ge("createtime", cond.getAlarmtime_from()));
		
		}
		//当结束的告警触发时间不为空时
		if(StringUtils.isNotEmpty(cond.getAlarmtime_to())){
			//转换触发时间
			c.add(Expression.le("createtime", cond.getAlarmtime_to()));
		}
		//当告警内容关键字不为空时
		if(StringUtils.isNotEmpty(cond.getWord_like())){
			c.add(Expression.like("alarmmsg", "%"+cond.getWord_like()+"%"));
		}
		//当设备类型syscoding不为空时
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		
		if("2".equals(cond.getIsalarm())){//2为屏蔽的syslog
			c.add(Expression.eq("isalarm", 2));
		}else if("1".equals(cond.getIsalarm())){//1为告警
			c.add(Expression.eq("isalarm", 1));
		}else if(StringUtils.isEmpty(cond.getIsalarm())){//如果为空，则显示非屏蔽的syslog
			c.add(Expression.not(Expression.eq("isalarm", 2)));
		}
		
		return c;
	}
	

}