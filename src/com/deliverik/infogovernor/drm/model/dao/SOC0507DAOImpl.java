/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.SOC0507Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCond;
import com.deliverik.infogovernor.drm.model.entity.SOC0507TB;

/**
  * 概述: 预案信息表DAO实现
  * 功能描述: 预案信息表DAO实现
  * 创建记录: 2016/07/15
  * 修改记录: 
  */
public class SOC0507DAOImpl extends
		BaseHibernateDAOImpl<SOC0507Info> implements SOC0507DAO {

	/**
	 * 构造函数
	 */
	public SOC0507DAOImpl(){
		super(SOC0507TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0507Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0507Info findByPK(Serializable pk) {
		SOC0507Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0507SearchCond cond){
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
	public List<SOC0507Info> findByCond(final SOC0507SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0507SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//cid
		if(StringUtils.isNotEmpty(cond.getCid())){
			c.add(Restrictions.eq("cid", cond.getCid()));
		}
		//eid
		if(StringUtils.isNotEmpty(cond.getEid())){
			c.add(Restrictions.eq("eid", cond.getEid()));
		}
		//eiid
		if(cond.getEiid() != null && cond.getEiid() != 0){
			c.add(Restrictions.eq("eiid", cond.getEiid()));
		}
		//esyscoding
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Restrictions.eq("esyscoding", cond.getEsyscoding()));
		}
		return c;
	}

}