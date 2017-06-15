/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0003Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0003SearchCond;
import com.deliverik.infogovernor.dwp.model.entity.IGDWP0003TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划表单信息DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0003DAOImpl extends BaseHibernateDAOImpl<IGDWP0003Info> implements IGDWP0003DAO{

	/**
	 * 构造函数
	 */
	public IGDWP0003DAOImpl(){
		super(IGDWP0003TB.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGDWP0003SearchCond cond){
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
	public List<IGDWP0003Info> findByCond(IGDWP0003SearchCond cond,int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	
	/**
	 * 检索条件生成
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IGDWP0003SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		return c;
	}
}
