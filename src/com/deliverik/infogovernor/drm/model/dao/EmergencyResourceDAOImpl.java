/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyResourceSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyResourceTB;

/**
  * 概述: EmergencyResourceDAO实现
  * 功能描述: EmergencyResourceDAO实现
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
public class EmergencyResourceDAOImpl extends
		BaseHibernateDAOImpl<EmergencyResourceInfo> implements EmergencyResourceDAO {

	/**
	 * 构造函数
	 */
	public EmergencyResourceDAOImpl(){
		super(EmergencyResourceTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EmergencyResourceInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EmergencyResourceInfo findByPK(Serializable pk) {
		EmergencyResourceInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EmergencyResourceSearchCond cond){
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
	public List<EmergencyResourceInfo> findByCond(final EmergencyResourceSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EmergencyResourceSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(StringUtils.isNotEmpty(cond.getErparcode())){
			c.add(Restrictions.eq("erparcode", cond.getErparcode()));
		}
		
		if(StringUtils.isNotEmpty(cond.getErparcode_like())){
			c.add(Restrictions.like("erparcode", cond.getErparcode_like()+"%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getErname())){
			c.add(Restrictions.like("ername", "%" + cond.getErname()+"%"));
		}
		
		if(StringUtils.isNotBlank(cond.getOrderby())){
			if(StringUtils.isNotEmpty(cond.getOrder())&&"ASC".equals(cond.getOrder())){
				c.addOrder(Order.asc(cond.getOrderby()));
			}else{
				c.addOrder(Order.desc(cond.getOrderby()));
			}
		}
		return c;
	}

}