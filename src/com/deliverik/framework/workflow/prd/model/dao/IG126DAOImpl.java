package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG126TB;

/**
 * 流程页面定义信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG126DAOImpl extends
		BaseHibernateDAOImpl<IG126Info> implements IG126DAO {

	/**
	 * 构造函数
	 */
	public IG126DAOImpl() {
		super(IG126TB.class);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<IG126Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pjdid"));
		List<IG126Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * 
	 * @param pjdid主键
	 * @return 检索结果
	 */
	public IG126Info findByPK(Serializable pjdid) {

		IG126Info result = super.findByPK(pjdid);
		if (result == null)
			return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG126SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG126Info> findByCond(
			final IG126SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pjdid"));
		List<IG126Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG126SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//流程定义ID
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		//页面类型
		if(StringUtils.isNotEmpty(cond.getPjdtype())){
			c.add(Expression.eq("pjdtype", cond.getPjdtype()));
		}
		//流程页面定义ID
		if(StringUtils.isNotEmpty(cond.getPjdid_like())){
			c.add(Expression.like("pjdid", cond.getPjdid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PJDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PJDID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPjdidSequenceNextValue(String pdid) {
		String sql =  "SELECT MAX(pjd.pjdid) FROM IG126TB pjd WHERE pjd.pjdid LIKE :pdid";
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
