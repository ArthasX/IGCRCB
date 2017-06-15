/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditJobSearchCond;
import com.deliverik.infogovernor.iam.model.entity.InternalauditJobTB;

/**
  * 概述: 内置工作表DAO实现
  * 功能描述: 内置工作表DAO实现
  * 创建记录: 2012/07/25
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class InternalauditJobDAOImpl extends
		BaseHibernateDAOImpl<InternalauditJobInfo> implements InternalauditJobDAO {

	/**
	 * 构造函数
	 */
	public InternalauditJobDAOImpl(){
		super(InternalauditJobTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InternalauditJobInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InternalauditJobInfo findByPK(Serializable pk) {
		InternalauditJobInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InternalauditJobSearchCond cond){
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
	public List<InternalauditJobInfo> findByCond(final InternalauditJobSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(InternalauditJobSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//工作名称
		if(StringUtils.isNotEmpty(cond.getIajName_like())){
			c.add(Expression.like("iajname", "%" + cond.getIajName_like() + "%"));
		}
		//年度计划
		if(StringUtils.isNotEmpty(cond.getIajYear_q())){
			c.add(Expression.eq("iajyear", cond.getIajYear_q()));
		}
		//内审项目
		if(0 != cond.getIajIapId_q()){
			c.add(Expression.eq("iajiapid", cond.getIajIapId_q()));
		}
		return c;
	}

}