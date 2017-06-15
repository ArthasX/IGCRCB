/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.change.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;
import com.deliverik.plugin.change.model.condition.InitiateChangLogSearchCond;
import com.deliverik.plugin.change.model.entity.InitiateChangLogTB;

/**
  * 概述: 发起变更流程日志DAO实现
  * 功能描述: 发起变更流程日志DAO实现
  * 创建记录: 2015/07/02
  * 修改记录: 
  */
public class InitiateChangLogDAOImpl extends
		BaseHibernateDAOImpl<InitiateChangLogInfo> implements InitiateChangLogDAO {

	/**
	 * 构造函数
	 */
	public InitiateChangLogDAOImpl(){
		super(InitiateChangLogTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InitiateChangLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InitiateChangLogInfo findByPK(Serializable pk) {
		InitiateChangLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InitiateChangLogSearchCond cond){
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
	public List<InitiateChangLogInfo> findByCond(final InitiateChangLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(InitiateChangLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		/**如果流程ID不为空 则 以流程ID*/
		if(cond.getPrid()!=0 ){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		return c;
	}

}