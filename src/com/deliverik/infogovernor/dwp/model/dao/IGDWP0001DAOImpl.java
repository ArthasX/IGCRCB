/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0001SearchCond;
import com.deliverik.infogovernor.dwp.model.entity.IGDWP0001TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划查询DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0001DAOImpl extends BaseHibernateDAOImpl<IGDWP0001Info> implements IGDWP0001DAO{

	/**
	 * 构造函数
	 */
	public IGDWP0001DAOImpl(){
		super(IGDWP0001TB.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGDWP0001SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGDWP0001Info> findByCond(IGDWP0001SearchCond cond,int start, int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("startdate"));
		return findByCriteria(c, start, count);
	}
	
	/**
	 * 检索条件生成
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IGDWP0001SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getStartdate_from())) {
			c.add(Restrictions.ge("startdate", cond.getStartdate_from()));
		}
		if(StringUtils.isNotEmpty(cond.getStartdate_to())){
			c.add(Restrictions.le("startdate", cond.getStartdate_to()));
		}
		if(StringUtils.isNotEmpty(cond.getIsAddJob())){
			c.add(Restrictions.eq("isAddJob", cond.getIsAddJob()));
		}
		if(StringUtils.isNotEmpty(cond.getPuserid())){
			c.add(Restrictions.eq("puserid", cond.getPuserid()));
		}
		return c;
	}
}
