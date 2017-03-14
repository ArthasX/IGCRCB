/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareprocessSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareprocessTB;

/**
  * 概述: 对比记录DAO实现
  * 功能描述: 对比记录DAO实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CompareprocessDAOImpl extends
		BaseHibernateDAOImpl<CompareprocessInfo> implements CompareprocessDAO {

	/**
	 * 构造函数
	 */
	public CompareprocessDAOImpl(){
		super(CompareprocessTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareprocessInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareprocessInfo findByPK(Serializable pk) {
		CompareprocessInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareprocessSearchCond cond){
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
	public List<CompareprocessInfo> findByCond(final CompareprocessSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CompareprocessSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// 开始时间Form 
		if (StringUtils.isNotEmpty(cond.getCpstarttime_form())) {
		    c.add(Restrictions.ge("cpstarttime", cond.getCpstarttime_form() + " 00:00"));
		}
		
		// 开始时间To
		if (StringUtils.isNotEmpty(cond.getCpstarttime_to())) {
		    c.add(Restrictions.le("cpstarttime", cond.getCpstarttime_to() + " 23:59"));
		}
		
		return c;
	}

}