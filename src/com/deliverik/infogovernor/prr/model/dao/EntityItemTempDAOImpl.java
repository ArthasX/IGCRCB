/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prr.model.EntityItemTempInfo;
import com.deliverik.infogovernor.prr.model.condition.EntityItemTempSearchCond;
import com.deliverik.infogovernor.prr.model.entity.EntityItemTempTB;

/**
  * 概述: 放置临时设备信息表DAO实现
  * 功能描述: 放置临时设备信息表DAO实现
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class EntityItemTempDAOImpl extends BaseHibernateDAOImpl<EntityItemTempInfo> implements EntityItemTempDAO {

	/**
	 * 构造函数
	 */
	public EntityItemTempDAOImpl(){
		super(EntityItemTempTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EntityItemTempInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EntityItemTempInfo findByPK(Serializable pk) {
		EntityItemTempInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EntityItemTempSearchCond cond){
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
	public List<EntityItemTempInfo> findByCond(final EntityItemTempSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EntityItemTempSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//合同编号
		if( StringUtils.isNotEmpty(cond.getEitConNum())){
			c.add(Expression.eq("eitConNum", cond.getEitConNum()));
		}
		if( StringUtils.isNotEmpty(cond.getEitBClass())){
			c.add(Expression.eq("eitBClass", cond.getEitBClass()));
		}
		if( null != cond.getPrid()){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		return c;
	}

}