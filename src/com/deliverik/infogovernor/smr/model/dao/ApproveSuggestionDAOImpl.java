/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCond;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
  * 概述: 审批意见表DAO实现
  * 功能描述: 审批意见表DAO实现
  * 创建记录: 2013/07/22
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ApproveSuggestionDAOImpl extends
		BaseHibernateDAOImpl<ApproveSuggestionInfo> implements ApproveSuggestionDAO {

	/**
	 * 构造函数
	 */
	public ApproveSuggestionDAOImpl(){
		super(ApproveSuggestionTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ApproveSuggestionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ApproveSuggestionInfo findByPK(Serializable pk) {
		ApproveSuggestionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ApproveSuggestionSearchCond cond){
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
	public List<ApproveSuggestionInfo> findByCond(final ApproveSuggestionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ApproveSuggestionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//流程主键
		if(cond.getPrid_eq() != null && cond.getPrid_eq() != 0){
			c.add(Expression.eq("prid", cond.getPrid_eq()));
		}
		
		//意见状态
		if(StringUtils.isNotEmpty(cond.getPidid_eq())){
			c.add(Expression.eq("pidid", cond.getPidid_eq()));
		}
		
		//意见状态
		if(StringUtils.isNotEmpty(cond.getStatus_eq())){
			c.add(Expression.eq("status", cond.getStatus_eq()));
		}
		
		//意见状态
		if(StringUtils.isNotEmpty(cond.getPsdcode_eq())){
			c.add(Expression.eq("psdcode", cond.getPsdcode_eq()));
		}
		//表格式表单行号
		if(StringUtils.isNotEmpty(cond.getRownumber_eq())){
			c.add(Expression.eq("rownumber", cond.getRownumber_eq()));
		}
		return c;
	}

}