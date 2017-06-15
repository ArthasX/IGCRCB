/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckStrategySearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckStrategyTB;

/**
 * 概述: 检查策略DAO实现 功能描述: 检查策略DAO实现 创建记录: 2014/09/02 修改记录:
 */
@SuppressWarnings("deprecation")
public class CheckStrategyDAOImpl extends
		BaseHibernateDAOImpl<CheckStrategyInfo> implements CheckStrategyDAO {

	/**
	 * 构造函数
	 */
	public CheckStrategyDAOImpl() {
		super(CheckStrategyTB.class);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<CheckStrategyInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param pk
	 *            主键
	 * @return 检索结果
	 */
	public CheckStrategyInfo findByPK(Serializable pk) {
		CheckStrategyInfo result = super.findByPK(pk);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CheckStrategySearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @param start
	 *            检索记录起始行号
	 * @param count
	 *            检索记录件数
	 * @return 检索结果列表
	 */
	public List<CheckStrategyInfo> findByCond(
			final CheckStrategySearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CheckStrategySearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		// 检查策略名
		if (StringUtils.isNotEmpty(cond.getCsname())) {
			c.add(Restrictions.like("csname", "%" + cond.getCsname() + "%"));
		}
		// 检查方式
		if (StringUtils.isNotEmpty(cond.getCsrtestmode())) {
			c.add(Restrictions.eq("csrtestmode", cond.getCsrtestmode()));
		}
		// 重要程度
		if (StringUtils.isNotEmpty(cond.getCstype())) {
			c.add(Restrictions.eq("cstype", cond.getCstype()));
		}
		// 检查项状态
		if (StringUtils.isNotEmpty(cond.getCsstatus())) {
			c.add(Restrictions.eq("csstatus", cond.getCsstatus()));
		}
		// 责任组名称
		if (StringUtils.isNotEmpty(cond.getCsrolename())) {
			c.add(Restrictions.like("csrolename", "%" + cond.getCsrolename()
					+ "%"));
		}

		// 责任人姓名
		if (StringUtils.isNotEmpty(cond.getCsusername())) {
			c.add(Restrictions.like("csusername", "%" + cond.getCsusername()
					+ "%"));
		}
		// 频率
		if (StringUtils.isNotEmpty(cond.getCsfrequency())) {
			c.add(Restrictions.like("csfrequency", "%" + cond.getCsfrequency()
					+ "%"));
		}
		return c;
	}

}