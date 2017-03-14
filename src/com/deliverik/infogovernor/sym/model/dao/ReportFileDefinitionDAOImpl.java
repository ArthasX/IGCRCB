/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;
import com.deliverik.infogovernor.sym.model.entity.ReportFileDefinitionTB;


/**
 * 报表定义DAO实现
 */
@SuppressWarnings("deprecation")
public class ReportFileDefinitionDAOImpl extends BaseHibernateDAOImpl<ReportFileDefinition> implements ReportFileDefinitionDAO {
	/**
	 * 构造函数
	 */
	public ReportFileDefinitionDAOImpl(){
		super(ReportFileDefinitionTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<ReportFileDefinition> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rfdid"));
		List<ReportFileDefinition> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rfdid 主键
	 * @return 检索结果
	 */
	public ReportFileDefinition findByPK(Serializable rfdid) {

		ReportFileDefinition result = super.findByPK(rfdid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ReportFileDefinitionSearchCond cond){
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
	public List<ReportFileDefinition> findByCond(final ReportFileDefinitionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rfdid"));
		List<ReportFileDefinition> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ReportFileDefinitionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//报表显示名称(模糊匹配)
		if( StringUtils.isNotEmpty(cond.getRfdtitle_like())){
			c.add(Expression.like("rfdtitle", "%" + cond.getRfdtitle_like() + "%"));
		}
		//报表显示名称
		if( StringUtils.isNotEmpty(cond.getRfdtitle())){
			c.add(Expression.eq("rfdtitle", cond.getRfdtitle()));
		}
		//报表分类
		if( StringUtils.isNotEmpty(cond.getRfdtype())){
			c.add(Expression.eq("rfdtype", cond.getRfdtype()));
		}
		//报表发布名称
		if( StringUtils.isNotEmpty(cond.getRfdfilename())){
			c.add(Expression.eq("rfdfilename", cond.getRfdfilename()));
		}
		//报表ID
		if( null!=cond.getRfdid()){
			c.add(Expression.eq("rfdid", cond.getRfdid()));
		}
		return c;
	}

}
