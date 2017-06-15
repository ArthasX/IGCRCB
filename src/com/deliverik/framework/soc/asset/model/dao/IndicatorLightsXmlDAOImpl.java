/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.IndicatorLightsXmlInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsXmlSearchCond;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsXmlTB;

/**
  * 概述: 告警系统显示区域表DAO实现
  * 功能描述: 告警系统显示区域表DAO实现
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IndicatorLightsXmlDAOImpl extends
		BaseHibernateDAOImpl<IndicatorLightsXmlInfo> implements IndicatorLightsXmlDAO {

	/**
	 * 构造函数
	 */
	public IndicatorLightsXmlDAOImpl(){
		super(IndicatorLightsXmlTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IndicatorLightsXmlInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IndicatorLightsXmlInfo findByPK(Serializable pk) {
		IndicatorLightsXmlInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IndicatorLightsXmlSearchCond cond){
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
	public List<IndicatorLightsXmlInfo> findByCond(final IndicatorLightsXmlSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IndicatorLightsXmlSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}