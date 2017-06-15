/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM04TB;

/**
  * 概述: 日志表DAO实现
  * 功能描述: 日志表DAO实现
  * 创建记录: 2014/02/19
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class VIM04DAOImpl extends
		BaseHibernateDAOImpl<VIM04Info> implements VIM04DAO {

	/**
	 * 构造函数
	 */
	public VIM04DAOImpl(){
		super(VIM04TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM04Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM04Info findByPK(Serializable pk) {
		VIM04Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final VIM04SearchCond cond){
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
	public List<VIM04Info> findByCond(final VIM04SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(VIM04SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (null != cond.getPid_eq()) {
		    c.add(Restrictions.eq("pid", cond.getPid_eq()));
		}
		return c;
	}

}