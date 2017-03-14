/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskMonitoringSearchCond;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;

/**
  * 概述: 风险监测表DAO实现
  * 功能描述: 风险监测表DAO实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public class RiskMonitoringDAOImpl extends
		BaseHibernateDAOImpl<RiskMonitoringInfo> implements RiskMonitoringDAO {

	/**
	 * 构造函数
	 */
	public RiskMonitoringDAOImpl(){
		super(RiskMonitoringTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskMonitoringInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskMonitoringInfo findByPK(Serializable pk) {
		RiskMonitoringInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskMonitoringSearchCond cond){
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
	public List<RiskMonitoringInfo> findByCond(final RiskMonitoringSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskMonitoringSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getRsid() != null && !(cond.getRsid().equals("0"))) {
			c.add(Restrictions.eq("rsid", cond.getRsid()));
		}
		// 监测任务名称
		if (StringUtils.isNotEmpty(cond.getRmname())) {
			c.add(Restrictions.like("rmname", "%" + cond.getRmname() + "%"));
		}
		// 计划开始时间
		if (StringUtils.isNotEmpty(cond.getRmstartdate_from())
				&& StringUtils.isNotEmpty(cond.getRmstartdate_to())) {
			c.add(Restrictions.ge("rmstartdate", cond.getRmstartdate_from()));
			c.add(Restrictions.le("rmstartdate", cond.getRmstartdate_to()));
		} else if (StringUtils.isNotEmpty(cond.getRmstartdate_from())) {
			c.add(Restrictions.ge("rmstartdate", cond.getRmstartdate_from()));
		} else if (StringUtils.isNotEmpty(cond.getRmstartdate_to())) {
			c.add(Restrictions.le("rmstartdate", cond.getRmstartdate_to()));
		}
		// 完成时间
		if (StringUtils.isNotEmpty(cond.getRmenddate_from())
				&& StringUtils.isNotEmpty(cond.getRmenddate_to())) {
			c.add(Restrictions.ge("rmenddate", cond.getRmenddate_from()));
			c.add(Restrictions.le("rmenddate", cond.getRmenddate_to()));
		} else if (StringUtils.isNotEmpty(cond.getRmenddate_from())) {
			c.add(Restrictions.ge("rmenddate", cond.getRmenddate_from()));
		} else if (StringUtils.isNotEmpty(cond.getRmenddate_to())) {
			c.add(Restrictions.le("rmenddate", cond.getRmenddate_to()));
		}
		c.addOrder(Order.desc("rmid"));
		return c;
	}

}