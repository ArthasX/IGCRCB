/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.emo.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.emo.model.EmInfo;
import com.deliverik.infogovernor.emo.model.condition.EmSearchCond;
import com.deliverik.infogovernor.emo.model.entity.EmTB;

/**
  * 概述: oracle性能采集DAO实现
  * 功能描述: oracle性能采集DAO实现
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class EmDAOImpl extends
		BaseHibernateDAOImpl<EmInfo> implements EmDAO {

	/**
	 * 构造函数
	 */
	public EmDAOImpl(){
		super(EmTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EmInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EmInfo findByPK(Serializable pk) {
		EmInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EmSearchCond cond){
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
	public List<EmInfo> findByCond(final EmSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EmSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		String type_str = "";
		if(StringUtils.isNotEmpty(cond.getEm_type())){
			c.add(Expression.eq("em_type", cond.getEm_type()));
			type_str = "where em_type='"+cond.getEm_type()+"'";
		}
		if(StringUtils.isNotEmpty(cond.getFingerprint())){
			c.add(Restrictions.sqlRestriction("fingerprint ='"+cond.getFingerprint()+"'"));
		}
		if(StringUtils.isNotEmpty(cond.getMax_collecttime())){
			c.add(Restrictions.sqlRestriction("em_collecttime = (select max(em_collecttime) from EM "+type_str+" and fingerprint='"+cond.getFingerprint()+"')"));
		}
		if(StringUtils.isNotEmpty(cond.getOrder_Totail_desc())){
			c.addOrder(Order.desc("em_Totail"));
		}
		return c;
	}

}