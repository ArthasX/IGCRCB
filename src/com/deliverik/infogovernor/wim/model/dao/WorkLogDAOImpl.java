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
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkLogTB;

/**
  * 概述: 工作日志DAO实现
  * 功能描述: 工作日志DAO实现
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public class WorkLogDAOImpl extends
		BaseHibernateDAOImpl<WorkLogInfo> implements WorkLogDAO {

	/**
	 * 构造函数
	 */
	public WorkLogDAOImpl(){
		super(WorkLogTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkLogInfo findByPK(Serializable pk) {
		WorkLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkLogSearchCond cond){
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
	public List<WorkLogInfo> findByCond(final WorkLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(WorkLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//工作日志名称
		if(StringUtils.isNotEmpty(cond.getWlname())){
			c.add(Restrictions.like("wlname", "%"+cond.getWlname()+"%"));
		}
		
		//执行人（userid）
		if(StringUtils.isNotEmpty(cond.getExcutorId())){
			c.add(Restrictions.eq("excutorId", cond.getExcutorId()));
		}
		
		//日期栏日期
		if(StringUtils.isNotEmpty(cond.getTitleDate())){
			c.add(Restrictions.like("titleDate", cond.getTitleDate()+"%"));
		}
		
		//执行时间
		if(StringUtils.isNotEmpty(cond.getExcuteTime())){
			c.add(Restrictions.like("excuteTime", cond.getExcuteTime()+"%"));
		}
		
		//实际处理日期
		if(StringUtils.isNotEmpty(cond.getActualDealwithDate())){
			c.add(Restrictions.like("actualDealwithDate", cond.getActualDealwithDate()+"%"));
		}
		
		//表记录创建日期
		if(StringUtils.isNotEmpty(cond.getCrtDate())){
			c.add(Restrictions.like("crtDate", cond.getCrtDate()+"%"));
		}
		
		return c;
	}

}