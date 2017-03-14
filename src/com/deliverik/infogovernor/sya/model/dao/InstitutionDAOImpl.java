/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sya.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;
import com.deliverik.infogovernor.sya.model.condition.InstitutionSearchCond;
import com.deliverik.infogovernor.sya.model.entity.InstitutionTB;

/**
  * 概述: 绩效考核DAO实现
  * 功能描述: 绩效考核DAO实现
  * 创建记录: 2015/01/05
  * 修改记录: 
  */
public class InstitutionDAOImpl extends
		BaseHibernateDAOImpl<InstitutionInfo> implements InstitutionDAO {

	/**
	 * 构造函数
	 */
	public InstitutionDAOImpl(){
		super(InstitutionTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InstitutionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InstitutionInfo findByPK(Serializable pk) {
		InstitutionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InstitutionSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("createtime"));
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
	public List<InstitutionInfo> findByCond(final InstitutionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("createtime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(InstitutionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getInname())){
			c.add(Restrictions.like("inname","%" + cond.getInname() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getIntype())){
			c.add(Restrictions.like("intype", cond.getIntype().split("_tree_")[0]+"%"));
		}
		return c;
	}

}