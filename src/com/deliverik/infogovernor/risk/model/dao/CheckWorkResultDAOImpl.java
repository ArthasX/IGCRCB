/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkResultSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkResultTB;

/**
  * 概述: 检查任务DAO实现
  * 功能描述: 检查任务DAO实现
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CheckWorkResultDAOImpl extends
		BaseHibernateDAOImpl<CheckWorkResultInfo> implements CheckWorkResultDAO {

	/**
	 * 构造函数
	 */
	public CheckWorkResultDAOImpl(){
		super(CheckWorkResultTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckWorkResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckWorkResultInfo findByPK(Serializable pk) {
		CheckWorkResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CheckWorkResultSearchCond cond){
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
	public List<CheckWorkResultInfo> findByCond(final CheckWorkResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CheckWorkResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( cond.getCsid()!=null && !(cond.getCsid().equals("0"))){
			c.add(Restrictions.eq("csid", cond.getCsid()));
		}
		//
		if(StringUtils.isNotEmpty(cond.getCwrid_in())){
			c.add(Restrictions.in("cwrid", cond.getCwrid_inSet()));
		}
		//检查方式
		if(StringUtils.isNotEmpty(cond.getCwrtestmode())){
			c.add(Restrictions.eq("cwrtestmode", cond.getCwrtestmode()));
		}
		//检查策略名称
		if(StringUtils.isNotEmpty(cond.getCwrname())){
			c.add(Restrictions.like("cwrname","%"+cond.getCwrname()+"%"));
		}
		//责任人
		if(StringUtils.isNotEmpty(cond.getCwrusername())){
			c.add(Restrictions.like("cwrusername","%"+cond.getCwrusername()+"%"));
		}
		//计划开始时间
		if(StringUtils.isNotEmpty(cond.getCwrplandate_from()) && StringUtils.isNotEmpty(cond.getCwrplandate_to())){
			c.add(Restrictions.ge("cwrplandate",cond.getCwrplandate_from()));
			c.add(Restrictions.le("cwrplandate",cond.getCwrplandate_to()));
		}else if(StringUtils.isNotEmpty(cond.getCwrplandate_from())){
			c.add(Restrictions.ge("cwrplandate",cond.getCwrplandate_from()));
		}else if(StringUtils.isNotEmpty(cond.getCwrplandate_to())){
			c.add(Restrictions.le("cwrplandate",cond.getCwrplandate_to()));
		}		
		//完成时间
		if(StringUtils.isNotEmpty(cond.getCwrrealtime_from()) && StringUtils.isNotEmpty(cond.getCwrrealtime_to())){
			c.add(Restrictions.ge("cwrrealtime",cond.getCwrrealtime_from()));
			c.add(Restrictions.le("cwrrealtime",cond.getCwrrealtime_to()));
		}else if(StringUtils.isNotEmpty(cond.getCwrrealtime_from())){
			c.add(Restrictions.ge("cwrrealtime",cond.getCwrrealtime_from()));
		}else if(StringUtils.isNotEmpty(cond.getCwrrealtime_to())){
			c.add(Restrictions.le("cwrrealtime",cond.getCwrrealtime_to()));
		}	
		return c;
	}

}