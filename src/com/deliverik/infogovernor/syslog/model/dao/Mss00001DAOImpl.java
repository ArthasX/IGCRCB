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
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00001TB;

/**
  * 概述: 设备信息表DAO实现
  * 功能描述: 设备信息表DAO实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Mss00001DAOImpl extends
		BaseHibernateDAOImpl<Mss00001Info> implements Mss00001DAO {

	/**
	 * 构造函数
	 */
	public Mss00001DAOImpl(){
		super(Mss00001TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00001Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00001Info findByPK(Serializable pk) {
		Mss00001Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Mss00001SearchCond cond){
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
	public List<Mss00001Info> findByCond(final Mss00001SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Mss00001SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getTypeid())){
			c.add(Expression.eq("typeid",cond.getTypeid()));
		}
		if(StringUtils.isNotEmpty(cond.getDeviceip())){
			c.add(Expression.eq("deviceip",cond.getDeviceip()));
		}
		if(StringUtils.isNotEmpty(cond.getDeviceip2())){
			c.add(Expression.eq("deviceip2",cond.getDeviceip2()));
		}
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.or(Expression.eq("deviceip",cond.getIp_like()), Expression.eq("deviceip2",cond.getIp_like())));
		}
		if(StringUtils.isNotEmpty(cond.getDeviceip_like())){
			c.add(Expression.or(Expression.like("deviceip","%"+cond.getDeviceip_like()+"%"), Expression.like("deviceip2","%"+cond.getDeviceip_like()+"%")));
		}
		return c;
	}

}