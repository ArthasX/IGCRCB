/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG273TB;

/**
 * 
 * 流程状态跃迁规则DAO实现
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("deprecation")
public class IG273DAOImpl extends BaseHibernateDAOImpl<IG273Info> implements IG273DAO{
	/**
	 * 构造函数
	 */
	public IG273DAOImpl(){
		super(IG273TB.class);
	}
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG273Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ptdid"));
		List<IG273Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * @param ptdid 主键
	 * @return 检索结果
	 */
	public IG273Info findByPK(Serializable ptdid){
		
		IG273Info processTransitionDef = super.findByPK(ptdid);
		
		if(processTransitionDef == null) return null;

		return processTransitionDef;
	}
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG273SearchCond cond){
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
	public List<IG273Info> findByCond(final IG273SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG273Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG273SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getFpsdid())){
			c.add(Expression.eq("fpsdid", cond.getFpsdid()));
		}
		if( !StringUtils.isEmpty(cond.getPtdcond())){
			c.add(Expression.eq("ptdcond", cond.getPtdcond()));
		}
		if( !StringUtils.isEmpty(cond.getPtdcond_like())){
			c.add(Expression.like("ptdcond", "%" + cond.getPtdcond_like() + "%"));
		}
		if( !StringUtils.isEmpty(cond.getPtdname())){
			c.add(Expression.eq("ptdname", cond.getPtdname()));
		}
		if( !StringUtils.isEmpty(cond.getPtdtype())){
			c.add(Expression.eq("ptdtype", cond.getPtdtype()));
		}
		if(StringUtils.isNotEmpty(cond.getTpsdid())){
			c.add(Expression.eq("tpsdid", cond.getTpsdid()));
		}
		//缺省
		if( cond.isDefaultRule()){
			c.add(Expression.eq("ptdtype", IGPRDCONSTANTS.COND_TYPE_DEFAULT));
		}
		//非缺省
		if( cond.isNotDefaultRule()){
			c.add(Expression.ne("ptdtype", IGPRDCONSTANTS.COND_TYPE_DEFAULT));
		}
		if(StringUtils.isNotEmpty(cond.getPtdid_like())){
			c.add(Expression.like("ptdid", cond.getPtdid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PTDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PTDID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPtdidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(ptd.ptdid) FROM IG273TB ptd WHERE ptd.ptdid LIKE :psdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("psdid", psdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return psdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return psdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(psdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}
}
