/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareProcessRoleRelationInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareProcessRoleRelationSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareProcessRoleRelationTB;

/**
  * 概述: 关系表DAO实现
  * 功能描述: 关系表DAO实现
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CompareProcessRoleRelationDAOImpl extends
		BaseHibernateDAOImpl<CompareProcessRoleRelationInfo> implements CompareProcessRoleRelationDAO {

	/**
	 * 构造函数
	 */
	public CompareProcessRoleRelationDAOImpl(){
		super(CompareProcessRoleRelationTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareProcessRoleRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareProcessRoleRelationInfo findByPK(Serializable pk) {
		CompareProcessRoleRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareProcessRoleRelationSearchCond cond){
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
	public List<CompareProcessRoleRelationInfo> findByCond(final CompareProcessRoleRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CompareProcessRoleRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}