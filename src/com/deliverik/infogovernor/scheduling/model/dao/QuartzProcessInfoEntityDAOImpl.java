/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCond;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzProcessInfoEntityTB;

/**
 * 
 * 流程资产关系DAO接口实现
 *
 */
@SuppressWarnings("deprecation")
public class QuartzProcessInfoEntityDAOImpl extends BaseHibernateDAOImpl<QuartzProcessInfoEntity> implements QuartzProcessInfoEntityDAO {
	

	/**
	 * 构造函数
	 */
	public QuartzProcessInfoEntityDAOImpl(){
		super(QuartzProcessInfoEntityTB.class);
	}
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<QuartzProcessInfoEntity> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("qpieid"));
		List<QuartzProcessInfoEntity> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * @param pieid 主键
	 * @return 检索结果
	 */
	public QuartzProcessInfoEntity findByPK(Serializable qpieid){
		
		QuartzProcessInfoEntity quartzProcessInfoEntity = super.findByPK(qpieid);
		
		if(quartzProcessInfoEntity == null) return null;

		return quartzProcessInfoEntity;
	}	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final QuartzProcessInfoEntitySearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<QuartzProcessInfoEntity> findByCond(final QuartzProcessInfoEntitySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<QuartzProcessInfoEntity> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(QuartzProcessInfoEntitySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		
		if( cond.getQprid() != null && cond.getQprid() != 0){
			c.add(Expression.eq("qprid", cond.getQprid()));
		}
		
		return c;
	}
}
