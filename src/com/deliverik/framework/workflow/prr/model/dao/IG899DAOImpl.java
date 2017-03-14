/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
  * 概述: 流程私有变量表DAO实现
  * 功能描述: 流程私有变量表DAO实现
  * 创建记录: 2012/03/27
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG899DAOImpl extends
		BaseHibernateDAOImpl<IG899Info> implements IG899DAO {

	/**
	 * 构造函数
	 */
	public IG899DAOImpl(){
		super(IG899TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG899Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG899Info findByPK(Serializable pk) {
		IG899Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG899SearchCond cond){
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
	public List<IG899Info> findByCond(final IG899SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG899SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//流程变量定义ID
		if(StringUtils.isNotEmpty(cond.getPidid())){
			c.add(Expression.eq("pidid", cond.getPidid()));
		}
		//流程变量值ID
		if(cond.getPiid() != null && cond.getPiid() > 0){
			c.add(Expression.eq("piid", cond.getPiid()));
		}
		//流程参与者的角色ID
		if(cond.getRoleid() != null && cond.getRoleid() > 0){
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		//流程参与者ID
		if(StringUtils.isNotEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		//流程参与者的机构码
		if(StringUtils.isNotEmpty(cond.getOrgid())){
			c.add(Expression.eq("orgid", cond.getOrgid()));
		}
		return c;
	}

}