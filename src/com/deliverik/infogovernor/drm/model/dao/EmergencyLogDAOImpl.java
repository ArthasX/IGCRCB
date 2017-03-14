/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;

/**
 * 概述：应急日志信息表DAO实现
 * 功能描述：应急日志信息表DAO实现
 * 创建记录：2014/05/19
 * (1)升序与降序排序条件以EmergencyLogTB中的字段列为主且这里只是简单排序没涉及复杂关系
 * 修改记录：
 */
@SuppressWarnings("deprecation")
public class EmergencyLogDAOImpl extends BaseHibernateDAOImpl<EmergencyLogInfo> implements EmergencyLogDAO {
	/**
	 * 构造函数
	 */
	public EmergencyLogDAOImpl(){
		super(EmergencyLogTB.class);
	}
	
	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
    public List<EmergencyLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("elid"));//全件检索默认按主键升序排列
		return findByCriteria(c);
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
    public EmergencyLogInfo findByPK(Serializable pk) {
		EmergencyLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EmergencyLogSearchCond cond){
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
	public List<EmergencyLogInfo> findByCond(final EmergencyLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EmergencyLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//应急相关流程ID(完全匹配)
		if(StringUtils.isNotEmpty(cond.getElprid_eq())){
			c.add(Expression.eq("elprid", Integer.parseInt(cond.getElprid_eq())));
		}
		//日志信息类型(完全匹配)
		if(StringUtils.isNotEmpty(cond.getEllitype_eq())){
			c.add(Expression.eq("ellitype", cond.getEllitype_eq()));
		}
		if(cond.getPsdid_in()!=null&&cond.getPsdid_in().length>0){
			c.add(Expression.in("elpsdid", cond.getPsdid_in()));
		}
		if(cond.getPrid_in()!=null&&cond.getPrid_in().length>0){
			c.add(Expression.in("elprid", cond.getPrid_in()));
		}
		//升序排序条件组
		if(cond.getAscs() != null){
			for(String asc : cond.getAscs()){
				if(StringUtils.isNotEmpty(asc)){
					c.addOrder(Order.asc(asc));
				}
			}
		}
		//降序排序条件组
		if(cond.getDesc() != null){
			for(String desc : cond.getDesc()){
				if(StringUtils.isNotEmpty(desc)){
					c.addOrder(Order.desc(desc));
				}
			}
		}
		return c;
	}
}