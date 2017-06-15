/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0204SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0204TB;

/**
  * 概述: 报表自定链接DAO实现
  * 功能描述: 报表自定链接DAO实现
  * 创建记录: 2012/07/20
  * 修改记录: 2012/08/10 将ReportCustomLinkDAOImpl表名修改为SOC0204DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0204DAOImpl extends
		BaseHibernateDAOImpl<SOC0204Info> implements SOC0204DAO {

	/**
	 * 构造函数
	 */
	public SOC0204DAOImpl(){
		super(SOC0204TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0204Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0204Info findByPK(Serializable pk) {
		SOC0204Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0204SearchCond cond){
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
	public List<SOC0204Info> findByCond(final SOC0204SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getRclReportType_eq())){
	    	   c.add(Expression.eq("rclReportType", cond.getRclReportType_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclObjName_eq())){
	    	   c.add(Expression.eq("rclObjName", cond.getRclObjName_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclTemName_eq())){
	    	   c.add(Expression.eq("rclTemName", cond.getRclTemName_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclTemDesc_eq())){
	    	   c.add(Expression.eq("rclTemDesc", cond.getRclTemDesc_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclRfdTitle_eq())){
	    	   c.add(Expression.eq("rclRfdTitle", cond.getRclRfdTitle_eq()));
	    }
		if(cond.getRclObjEiid_eq()!=null){
	    	   c.add(Expression.eq("rclObjEiid", cond.getRclObjEiid_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclObjType_eq())){
	    	   c.add(Expression.eq("rclObjType", cond.getRclObjType_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclMode_eq())){
	    	   c.add(Expression.eq("rclMode", cond.getRclMode_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclCaType_eq())){
	    	   c.add(Expression.eq("rclCaType", cond.getRclCaType_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclMenuDefault_eq())){
	    	   c.add(Expression.eq("rclMenuDefault", cond.getRclMenuDefault_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclUserId_eq())){
	    	   c.add(Expression.eq("rclUserId", cond.getRclUserId_eq()));
	    }
		c.addOrder(Order.desc("rclObjType"));
		c.addOrder(Order.desc("rclTemName"));
		c.addOrder(Order.desc("rclCaType"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0204SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}