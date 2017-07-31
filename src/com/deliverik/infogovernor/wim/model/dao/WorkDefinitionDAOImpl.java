/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkDefinitionSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;

/**
  * 概述: 工作定义DAO实现
  * 功能描述: 工作定义DAO实现
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public class WorkDefinitionDAOImpl extends
		BaseHibernateDAOImpl<WorkDefinitionInfo> implements WorkDefinitionDAO {

	/**
	 * 构造函数
	 */
	public WorkDefinitionDAOImpl(){
		super(WorkDefinitionTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkDefinitionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkDefinitionInfo findByPK(Serializable pk) {
		WorkDefinitionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkDefinitionSearchCond cond){
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
	public List<WorkDefinitionInfo> findByCond(final WorkDefinitionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("crtDate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(WorkDefinitionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//工作项名称
		if(StringUtils.isNotEmpty(cond.getWdname())){
			c.add(Restrictions.like("wdname", "%"+cond.getWdname()+"%"));
		}
		
		//发起人
		if(StringUtils.isNotEmpty(cond.getInitiatorId())){
			c.add(Restrictions.like("initiatorId", "%"+cond.getInitiatorId()+"%"));
		}
		
		//多发起人
		if(cond.getInitiatorId_in()!=null && cond.getInitiatorId_in().size()>0){
			c.add(Restrictions.in("initiatorId", cond.getInitiatorId_in()));
		}
		
		//负责人名称
		if(StringUtils.isNotEmpty(cond.getLeaderName())){
			c.add(Restrictions.like("leaderName", "%"+cond.getLeaderName()+"%"));
		}
		
		//启用状态（0，未启用；1，已启用）取得
		if(StringUtils.isNotEmpty(cond.getWdstatus())){
			c.add(Restrictions.eq("wdstatus",cond.getWdstatus()));
		}
		
		//开始日期从 
		if(StringUtils.isNotEmpty(cond.getBeginDateStart())){
			c.add(Restrictions.ge("beginDate", cond.getBeginDateStart()));
		}
		
		//开始日期到
		if(StringUtils.isNotEmpty(cond.getBeginDateOver())){
			c.add(Restrictions.le("beginDate", cond.getBeginDateOver()));
		}
		
		return c;
	}

}