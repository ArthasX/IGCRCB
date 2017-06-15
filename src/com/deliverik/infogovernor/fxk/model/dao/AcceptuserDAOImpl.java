/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.condition.AcceptuserSearchCond;
import com.deliverik.infogovernor.fxk.model.entity.AcceptuserTB;

/**
  * 概述: 风险管理提示接收者数据表DAO实现
  * 功能描述: 风险管理提示接收者数据表DAO实现
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public class AcceptuserDAOImpl extends
		BaseHibernateDAOImpl<AcceptuserInfo> implements AcceptuserDAO {

	/**
	 * 构造函数
	 */
	public AcceptuserDAOImpl(){
		super(AcceptuserTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AcceptuserInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AcceptuserInfo findByPK(Serializable pk) {
		AcceptuserInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AcceptuserSearchCond cond){
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
	public List<AcceptuserInfo> findByCond(final AcceptuserSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AcceptuserSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//接收人员部门ID(完全匹配)
		if(StringUtils.isNotEmpty(cond.getAporgid())){
			c.add(Restrictions.eq("aporgid", cond.getAporgid()));
		}
		//接收人员id(完全匹配)
		if(StringUtils.isNotEmpty(cond.getApuserid())){
			c.add(Restrictions.eq("apuserid", cond.getApuserid()));
		}
		
		//风险提示rwid
		if(cond.getRwid() != null && cond.getRwid() != 0){
			c.add(Restrictions.eq("rwid", cond.getRwid()));
		}
		return c;
	}

}