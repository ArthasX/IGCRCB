/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.asset.model.condition.IG809SearchCond;
import com.deliverik.framework.asset.model.entity.IG809TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 资产关系图文件信息DAO接口实现
 *
 */
@SuppressWarnings("deprecation")
public class IG809DAOImpl extends BaseHibernateDAOImpl<IG809Info> implements IG809DAO{

	/**
	 * 构造函数
	 */
	public IG809DAOImpl(){
		super(IG809TB.class);
	}
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG809Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eirfid"));
		List<IG809Info> ret = findByCriteria(c);

		return ret;
	}
	
	/**
	 * 主键检索处理
	 * @param eirfid 主键
	 * @return 检索结果
	 */
	public IG809Info findByPK(Serializable eirfid) {

		IG809Info result = super.findByPK(eirfid);
		if(result == null) return null;

		return result;
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG809SearchCond cond){
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
	public List<IG809Info> findByCond(final IG809SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eirfid"));
		List<IG809Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG809SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//资产ID
		if(cond.getEiid() != null && cond.getEiid() != 0){
			c.add(Expression.eq("eiid", cond.getEiid()));
		}
		//流程图类型
		if( StringUtils.isNotEmpty(cond.getEirftype())){
			c.add(Expression.eq("eirftype", cond.getEirftype()));
		}
		//文件名
		if( StringUtils.isNotEmpty(cond.getEirfname())){
			c.add(Expression.eq("eirfname", cond.getEirfname()));
		}
		//资产ID集合
		if( cond.getEiidList() != null && cond.getEiidList().size() > 0){
			c.add(Expression.in("eiid", cond.getEiidList()));
		}
		return c;
	}
}
