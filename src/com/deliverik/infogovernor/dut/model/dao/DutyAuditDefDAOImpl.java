/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyAuditDefTB;

/**
 * 值班检查管理DAO接口实现
 */
@SuppressWarnings("deprecation")
public class DutyAuditDefDAOImpl extends BaseHibernateDAOImpl<DutyAuditDef> implements DutyAuditDefDAO {

	/**
	 * 构造函数
	 */
	public DutyAuditDefDAOImpl(){
		super(DutyAuditDefTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyAuditDef> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dadid"));
		List<DutyAuditDef> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param dadid 主键
	 * @return 检索结果
	 */
	public DutyAuditDef findByPK(Serializable dadid) {

		DutyAuditDef result = super.findByPK(dadid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyAuditDefSearchCond cond){
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
	public List<DutyAuditDef> findByCond(final DutyAuditDefSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("dadorderby"));
		List<DutyAuditDef> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DutyAuditDefSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//检查分类
		if(StringUtils.isNotEmpty(cond.getDadtype())){
			c.add(Expression.eq("dadtype", cond.getDadtype()));
		}
		
		//检查名称
		if(StringUtils.isNotEmpty(cond.getDadname())){
			c.add(Expression.like("dadname", "%"+cond.getDadname()+"%"));
		}

		//值班类型
		if(StringUtils.isNotEmpty(cond.getDadcategory())){
			c.add(Expression.eq("dadcategory", cond.getDadcategory()));
		}
		
		return c;
	}


}
