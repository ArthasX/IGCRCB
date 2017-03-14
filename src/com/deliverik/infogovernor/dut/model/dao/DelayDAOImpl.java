/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCond;
import com.deliverik.infogovernor.dut.model.entity.DelayTB;

/**
  * 概述: 延时解锁信息表DAO实现
  * 功能描述: 延时解锁信息表DAO实现
  * 创建记录: 2012/04/05
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class DelayDAOImpl extends
		BaseHibernateDAOImpl<DelayInfo> implements DelayDAO {

	/**
	 * 构造函数
	 */
	public DelayDAOImpl(){
		super(DelayTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<DelayInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public DelayInfo findByPK(Serializable pk) {
		DelayInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DelaySearchCond cond){
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
	public List<DelayInfo> findByCond(final DelaySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DelaySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( !StringUtils.isEmpty(cond.getOrgname_eq())){
			c.add(Expression.eq("orgname", cond.getOrgname_eq()));
		}
		if( !StringUtils.isEmpty(cond.getTitle_like())){
			c.add(Expression.like("title", "%"+cond.getTitle_like()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getDatetime_from())){
			c.add(Expression.ge("datetime", cond.getDatetime_from()));
		}
		if( !StringUtils.isEmpty(cond.getDatetime_to())){
			c.add(Expression.le("datetime", cond.getDatetime_to()+" 23:59"));
		}
		return c;
	}

}