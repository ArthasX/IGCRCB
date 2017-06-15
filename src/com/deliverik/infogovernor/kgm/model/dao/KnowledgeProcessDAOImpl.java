/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeProcessTB;

/**
 * 概述: 知识流程关联信息DAO实现
 * 功能描述：知识流程关联信息DAO实现
 * 创建记录：刘鹏 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("deprecation")
public class KnowledgeProcessDAOImpl extends
		BaseHibernateDAOImpl<KnowledgeProcess> implements KnowledgeProcessDAO {
	
	/**
	 * 构造函数
	 */
	public KnowledgeProcessDAOImpl() {
		super(KnowledgeProcessTB.class);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<KnowledgeProcess> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		List<KnowledgeProcess> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * 
	 * @param kpid主键
	 * @return 检索结果
	 */
	public KnowledgeProcess findByPK(Serializable kpid) {
		KnowledgeProcess result = super.findByPK(kpid);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final KnowledgeProcessSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> findByCond(
			final KnowledgeProcessSearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		List<KnowledgeProcess> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> findByCond_KnowledgeProcess(
			final KnowledgeProcessSearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria_KnowledgeProcess(cond);
		c.addOrder(Order.asc("connecttype"));
		List<KnowledgeProcess> ret = findByCriteria(c, start, count);
		
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(KnowledgeProcessSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//知识ID
		if(cond.getKnid() != null && cond.getKnid() > 0){
			c.add(Expression.eq("knid", cond.getKnid()));
		}
		//知识版本
		if(cond.getKnversion() != null && cond.getKnversion() > 0){
			c.add(Expression.eq("knversion", cond.getKnversion()));
		}
		//流程ID
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		//服务工单ID
		if(cond.getSfid() != null && cond.getSfid() > 0){
			c.add(Expression.eq("sfid", cond.getSfid()));
		}
		//关联类型
		if(StringUtils.isNotEmpty(cond.getConnecttype())){
			c.add(Expression.eq("connecttype", cond.getConnecttype()));
		}
		return c;
	}
	
	/**
	 * 检索条件生成(关联流程和服务工单)
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria_KnowledgeProcess(KnowledgeProcessSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//知识ID
		if(cond.getKnid() != null && cond.getKnid() > 0){
			c.add(Expression.eq("knid", cond.getKnid()));
		}
		//关联类型
		if(StringUtils.isNotEmpty(cond.getConnecttype())){
			c.add(Expression.not(Expression.eq("connecttype", cond.getConnecttype())));
		}
		if(cond.getKpEffect() != null ){
			c.add(Expression.eq("kpEffect", cond.getKpEffect()));
		}
		return c;
	}
}
