/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;

/**
  * 概述: 报表填报明细表DAO实现
  * 功能描述: 报表填报明细表DAO实现
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class RegulatoryReportDetailDAOImpl extends
		BaseHibernateDAOImpl<RegulatoryReportDetailInfo> implements RegulatoryReportDetailDAO {

	/**
	 * 构造函数
	 */
	public RegulatoryReportDetailDAOImpl(){
		super(RegulatoryReportDetailTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RegulatoryReportDetailInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RegulatoryReportDetailInfo findByPK(Serializable pk) {
		RegulatoryReportDetailInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RegulatoryReportDetailSearchCond cond){
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
	public List<RegulatoryReportDetailInfo> findByCond(final RegulatoryReportDetailSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RegulatoryReportDetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//实例ID
		if(cond.getInstanceID() != null){
			c.add(Expression.eq("instanceID", cond.getInstanceID()));
		}
		//流程id
		if(cond.getPrid()!=null){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		return c;
	}

}