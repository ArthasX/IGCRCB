/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.SOC0509Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0509SearchCond;
import com.deliverik.infogovernor.drm.model.entity.SOC0509TB;

/**
  * 概述: 预案章节信息DAO实现
  * 功能描述: 预案章节信息DAO实现
  * 创建记录: 2016/07/07
  * 修改记录: 
  */
public class SOC0509DAOImpl extends
		BaseHibernateDAOImpl<SOC0509Info> implements SOC0509DAO {

	/**
	 * 构造函数
	 */
	public SOC0509DAOImpl(){
		super(SOC0509TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0509Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0509Info findByPK(Serializable pk) {
		SOC0509Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0509SearchCond cond){
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
	public List<SOC0509Info> findByCond(final SOC0509SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(cond.getEsyscodingList() != null && !cond.getEsyscodingList().isEmpty()){
			c.addOrder(Order.asc("cid"));
		} else if (StringUtils.isNotBlank(cond.getPcid()) || StringUtils.isNotBlank(cond.getEsyscoding())){
			// 默认按排序字段进行排序
			c.addOrder(Order.asc("corder"));
		} else {
			c.addOrder(Order.desc("cid"));
		}
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0509SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//层次码
		if(StringUtils.isNotEmpty(cond.getEsyscoding_like())){
			c.add(Restrictions.like("esyscoding", cond.getEsyscoding_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getCname())){
			c.add(Restrictions.like("cname", "%" + cond.getCname() + "%"));
		}
		//层次码in
		if(cond.getEsyscodingList() != null && !cond.getEsyscodingList().isEmpty()){
			c.add(Restrictions.in("esyscoding", cond.getEsyscodingList()));
		}
		// 按PCID查询
		if(StringUtils.isNotEmpty(cond.getPcid())){
			c.add(Restrictions.eq("pcid", cond.getPcid()));
		}
		//按EID查询
		if(StringUtils.isNotEmpty(cond.getEid())){
			c.add(Restrictions.eq("eid", cond.getEid()));
		}
		//按层次码查询
		if(StringUtils.isNotBlank(cond.getEsyscoding())){
			c.add(Restrictions.eq("esyscoding", cond.getEsyscoding()));
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public Integer getNextCorder() {
		Session session = getSession();
		String query = "SELECT MAX(corder) FROM soc0509";
		SQLQuery q = session.createSQLQuery(query);
		List<Integer> rt = q.list();
		if(null != rt && rt.size() > 0 && null != rt.get(0)){
			return ((Number)rt.get(0)).intValue() + 1;
		}
		else{
			return 1;
		}
	}

}