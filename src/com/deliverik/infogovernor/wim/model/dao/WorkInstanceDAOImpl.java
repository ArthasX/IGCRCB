/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;

/**
  * 概述: 工作实例DAO实现
  * 功能描述: 工作实例DAO实现
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public class WorkInstanceDAOImpl extends
		BaseHibernateDAOImpl<WorkInstanceInfo> implements WorkInstanceDAO {

	/**
	 * 构造函数
	 */
	public WorkInstanceDAOImpl(){
		super(WorkInstanceTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkInstanceInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkInstanceInfo findByPK(Serializable pk) {
		WorkInstanceInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkInstanceSearchCond cond){
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
	public List<WorkInstanceInfo> findByCond(final WorkInstanceSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(WorkInstanceSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//工作实例名称
		if(StringUtils.isNotEmpty(cond.getWiname())){
			c.add(Restrictions.like("winame", ""+cond.getWiname()+""));
		}
		
		//工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
		if(cond.getWistatus()!=null){
			c.add(Restrictions.eq("wistatus", ""+cond.getWistatus()+""));
		}
		
		//部门（id）
		if(StringUtils.isNotEmpty(cond.getWiDepartmentid())){
			c.add(Restrictions.eq("widepartmentid", cond.getWiDepartmentid()));
		}
		
		//人员（userid）
		if(StringUtils.isNotEmpty(cond.getWiuserid())){
			c.add(Restrictions.eq("wiuserid", cond.getWiuserid()));
		}
		
		//发起类型（1，自动发起；2，手动发起）
		if(StringUtils.isNotEmpty(cond.getWiLunchType())){
			c.add(Restrictions.eq("wiLunchType", cond.getWiLunchType()));
		}
		
		//执行需所时间（小时）
		if(StringUtils.isNotEmpty(cond.getExcuteTime())){
			c.add(Restrictions.eq("excuteTime", cond.getExcuteTime()));
		}
		
		//实际处理日期
		if(StringUtils.isNotEmpty(cond.getActualDealwithDate())){
			c.add(Restrictions.like("actualDealwithDate", cond.getActualDealwithDate()+"%"));
		}
		
		//工作确认日期
		if(StringUtils.isNotEmpty(cond.getConfirmDate())){
			c.add(Restrictions.like("confirmDate", cond.getConfirmDate()+"%"));
		}
		
		//日期栏日期
		if(StringUtils.isNotEmpty(cond.getTitleDate())){
			c.add(Restrictions.like("titleDate", cond.getTitleDate()+"%"));
		}
		
		//表记录创建
		if(StringUtils.isNotEmpty(cond.getCrtDate())){
			c.add(Restrictions.like("crtDate", cond.getCrtDate()+"%"));
		}
		
		return c;
	}

}