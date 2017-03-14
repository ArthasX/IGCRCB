/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM02TB;

/**
  * 概述: 虚拟资源项目信息表DAO实现
  * 功能描述: 虚拟资源项目信息表DAO实现
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class VIM02DAOImpl extends
		BaseHibernateDAOImpl<VIM02Info> implements VIM02DAO {

	/**
	 * 构造函数
	 */
	public VIM02DAOImpl(){
		super(VIM02TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM02Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM02Info findByPK(Serializable pk) {
		VIM02Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final VIM02SearchCond cond){
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
	public List<VIM02Info> findByCond(final VIM02SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(VIM02SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (StringUtils.isNotEmpty(cond.getProgress_eq())) {
		    c.add(Restrictions.eq("progress", cond.getProgress_eq()));
		}
		
		return c;
	}

}