/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;

/**
 * 流程关系实体DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class EmergencyRelationDAOImpl extends BaseHibernateDAOImpl<EmergencyRelationInfo> implements EmergencyRelationDAO {

	/** EmergencyRelation DAO */
	protected EmergencyRelationDAO EmergencyRelationDAO;
	/**
	 * 构造函数
	 */
	public EmergencyRelationDAOImpl(){
		super(EmergencyRelationTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<EmergencyRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("prrid"));
		List<EmergencyRelationInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param prrid 主键
	 * @return 检索结果
	 */
	public EmergencyRelationInfo findByPK(Serializable prrid) {

		EmergencyRelationInfo result = super.findByPK(prrid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EmergencyRelationSearchCond cond){
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
	public List<EmergencyRelationInfo> findByCond(final EmergencyRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("erid"));
		List<EmergencyRelationInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EmergencyRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//主动流程ID
		if(cond.getParprid() != null && cond.getParprid() > 0){
			c.add(Expression.eq("parprid", cond.getParprid()));
		}
		//被动流程ID
		if(cond.getCldprid() != null && cond.getCldprid() > 0){
			c.add(Expression.eq("cldprid", cond.getCldprid()));
		}
		//关联关系
		if(StringUtils.isNotBlank(cond.getRelatetype())){
			c.add(Restrictions.eq("relatetype", cond.getRelatetype()));
		}
		return c;
	}

}
