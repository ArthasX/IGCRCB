/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;

/**
 * <p>概述:表单日志信息检索DAO实现</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.检索条件生成</p>
 *           
 * <p>创建记录：</p>
 */
public class IG113DAOImpl extends BaseHibernateDAOImpl<IG113Info> implements IG113DAO {

	/**
	 * 构造函数
	 */
	public IG113DAOImpl(){
		super(IG113TB.class);
	}

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG113Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rlvid"));
		List<IG113Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * @param rlvid 主键
	 * @return 检索结果
	 */
	public IG113Info findByPK(Serializable rlvid) {

		IG113Info rl = super.findByPK(rlvid);
		if(rl == null) return null;

		return rl;
	}

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG113Info> findByCond(final IG113SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rlvid"));
		List<IG113Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG113SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		
		//变量ID 
		if( cond.getPiid() != null && cond.getPiid() != 0){
			c.add(Restrictions.eq("piid", cond.getPiid()));
		}
		
		//日志ID 
		if( cond.getRlid() != null && cond.getRlid() != 0){
			c.add(Restrictions.eq("rlid", cond.getRlid()));
		}
		
		//流程记录ID
		if( cond.getPrid() != null && cond.getPrid() != 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		//表单值是否为空
		if(StringUtils.isNotEmpty(cond.getValueIsNull())){
			if("N".equals(cond.getValueIsNull())){
				c.add(Restrictions.isNotNull("pivarvalue"));
				c.add(Restrictions.ne("pivarvalue", ""));
			}
		}
		return c;
	}

}
