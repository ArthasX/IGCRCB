/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.IndicatorLightsSystemInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsSystemSearchCond;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsSystemTB;

/**
  * 概述: 告警系统显示信息表DAO实现
  * 功能描述: 告警系统显示信息表DAO实现
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IndicatorLightsSystemDAOImpl extends
		BaseHibernateDAOImpl<IndicatorLightsSystemInfo> implements IndicatorLightsSystemDAO {

	/**
	 * 构造函数
	 */
	public IndicatorLightsSystemDAOImpl(){
		super(IndicatorLightsSystemTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IndicatorLightsSystemInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IndicatorLightsSystemInfo findByPK(Serializable pk) {
		IndicatorLightsSystemInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IndicatorLightsSystemSearchCond cond){
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
	public List<IndicatorLightsSystemInfo> findByCond(final IndicatorLightsSystemSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IndicatorLightsSystemSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// 系统名称
		if ( StringUtils.isNotEmpty(cond.getIlsname())) {
			c.add(Expression.eq("ilsname", cond.getIlsname()));
		}
		
		// 状态
		if ( StringUtils.isNotEmpty(cond.getIlsstatus())) {
			c.add(Expression.eq("ilsstatus", cond.getIlsstatus()));
		}
		
		return c;
	}

}