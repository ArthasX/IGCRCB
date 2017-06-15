/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG555Info;
import com.deliverik.framework.workflow.prr.model.condition.IG555SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG555TB;

/**
  * 概述: 流程处理页返回配置信息DAO实现
  * 功能描述: 流程处理页返回配置信息DAO实现
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
public class IG555DAOImpl extends
		BaseHibernateDAOImpl<IG555Info> implements IG555DAO {

	/**
	 * 构造函数
	 */
	public IG555DAOImpl(){
		super(IG555TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG555Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG555Info findByPK(Serializable pk) {
		IG555Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG555SearchCond cond){
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
	public List<IG555Info> findByCond(final IG555SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG555SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}