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
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG211TB;

/**
 * 流程状态变量前处理DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class IG211DAOImpl extends BaseHibernateDAOImpl<IG211Info> implements IG211DAO {
	

	/**
	 * 构造函数
	 */
	public IG211DAOImpl(){
		super(IG211TB.class);
	}
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG211Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("psidid"));
		List<IG211Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * @param psidid 主键
	 * @return 检索结果
	 */
	public IG211Info findByPK(Serializable psidid){
		
		IG211Info processStatusInfoDef = super.findByPK(psidid);
		
		if(processStatusInfoDef == null) return null;

		return processStatusInfoDef;
	}	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG211SearchCond cond){
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
	public List<IG211Info> findByCond(final IG211SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG211Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG211SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPsidid_like())){
			c.add(Expression.like("psidid", cond.getPsidid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PSIDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSIDID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPsididSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(psid.psidid) FROM IG211TB psid WHERE psid.psidid LIKE :psdid";
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
