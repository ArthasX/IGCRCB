/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG286TB;

/**
 * <p>概述:流程级联表单处理DAO实现</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>			 2.检索条件生成</p>
 *        
 * <p>创建记录：</p>
 */

@SuppressWarnings("deprecation")
public class IG286DAOImpl extends BaseHibernateDAOImpl<IG286Info> implements IG286DAO {

	/**
	 * 构造函数
	 */
	public IG286DAOImpl(){
		super(IG286TB.class);
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG286Info> findByCond(final IG286SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		
		
		List<IG286Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG286SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getInitiativepidid())){
			c.add(Expression.eq("initiativepidid", cond.getInitiativepidid()));
		}
		if(StringUtils.isNotEmpty(cond.getPassivitypidid())){
			c.add(Expression.eq("passivitypidid", cond.getPassivitypidid()));
		}
		if(cond.getPldactionid() != null && !"".equals(cond.getPldactionid())){
			c.add(Expression.eq("pldactionid", cond.getPldactionid()));
		}
		if(StringUtils.isNotEmpty(cond.getPldpdid())){
			c.add(Expression.eq("pldpdid", cond.getPldpdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPlid_like())){
			c.add(Expression.like("plid", cond.getPlid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PLID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PLID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPlidSequenceNextValue(String pdid) {
		String sql =  "SELECT MAX(pld.plid) FROM IG286TB pld WHERE pld.plid LIKE :pdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("pdid", pdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return pdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return pdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(pdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}
}
