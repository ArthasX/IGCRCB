/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.orl.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.orl.model.OrealAlertInfo;
import com.deliverik.orl.model.condition.OrealAlertSearchCond;
import com.deliverik.orl.model.entity.OrealAlertTB;

/**
 * 概述：欧莱雅告警表DAO实现
 * 功能描述：欧莱雅告警表DAO实现
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
@SuppressWarnings("deprecation")
public class OrealAlertDAOImpl extends BaseHibernateDAOImpl<OrealAlertInfo> implements OrealAlertDAO {

	/**
	 * 构造函数
	 */
	public OrealAlertDAOImpl(){
		super(OrealAlertTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<OrealAlertInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		
		//默认按时间倒序进行排序
		c.addOrder(Order.desc("ctime"));
		//增加按优先级由高到低排序
		c.addOrder(Order.desc("priority"));
		
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public OrealAlertInfo findByPK(Serializable pk) {
		OrealAlertInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 * @throws BLException 
	 */
	public int getSearchCount(final OrealAlertSearchCond cond) throws BLException{
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
	 * @throws BLException 
	 */
	public List<OrealAlertInfo> findByCond(final OrealAlertSearchCond cond, final int start, final int count) throws BLException{
		DetachedCriteria c = getCriteria(cond);
		
		//默认按时间倒序进行排序
		c.addOrder(Order.desc("ctime"));
		//增加按优先级由高到低排序
		c.addOrder(Order.desc("priority"));
		
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 * @throws BLException 
	 */
	protected DetachedCriteria getCriteria(OrealAlertSearchCond cond) throws BLException{
		DetachedCriteria c = getDetachedCriteria();
		
		//当是否修复(标识)不为空时
		if(StringUtils.isNotEmpty(cond.getFixed_eq())){
			c.add(Expression.eq("fixed", new Integer(cond.getFixed_eq())));
		}
		//当平台名称不为空时
		if(StringUtils.isNotEmpty(cond.getPlatform_name_like())){
			c.add(Expression.like("platform_name", "%"+cond.getPlatform_name_like()+"%"));
		}
		//当平台名称(in)不为空时
		if(cond.getPlatform_name_in() != null){
			c.add(Expression.in("platform_name", cond.getPlatform_name_in()));
		}
		
		return c;
	}
}