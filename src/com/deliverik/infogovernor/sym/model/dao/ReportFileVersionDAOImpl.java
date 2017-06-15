/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;
import com.deliverik.infogovernor.sym.model.entity.ReportFileVersionTB;


/**
 * 报表版本DAO实现
 */
@SuppressWarnings("deprecation")
public class ReportFileVersionDAOImpl extends BaseHibernateDAOImpl<ReportFileVersion> implements ReportFileVersionDAO {
	/**
	 * 构造函数
	 */
	public ReportFileVersionDAOImpl(){
		super(ReportFileVersionTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<ReportFileVersion> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rfvid"));
		List<ReportFileVersion> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rfvid 主键
	 * @return 检索结果
	 */
	public ReportFileVersion findByPK(Serializable rfvid) {

		ReportFileVersion result = super.findByPK(rfvid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ReportFileVersionSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ReportFileVersion> findByCond(final ReportFileVersionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rfvid"));
		List<ReportFileVersion> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ReportFileVersionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//报表主键
		if( cond.getRfdid() != null && cond.getRfdid() > 0){
			c.add(Expression.eq("rfdid", cond.getRfdid()));
		}
		return c;
	}

}
