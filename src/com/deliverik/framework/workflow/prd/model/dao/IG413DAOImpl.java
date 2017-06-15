package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.annotation.IdGeneratorMethod;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG413TB;

/**
 * 流程事件定义信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG413DAOImpl extends
		BaseHibernateDAOImpl<IG413Info> implements IG413DAO {

	/**
	 * 构造函数
	 */
	public IG413DAOImpl() {
		super(IG413TB.class);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<IG413Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pdid"));
		c.addOrder(Order.asc("psdid"));
		c.addOrder(Order.asc("pedorder"));
		List<IG413Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * 
	 * @param pedid主键
	 * @return 检索结果
	 */
	public IG413Info findByPK(Serializable pedid) {

		IG413Info result = super.findByPK(pedid);
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
	public int getSearchCount(final IG413SearchCond cond) {
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
	public List<IG413Info> findByCond(
			final IG413SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pdid"));
		c.addOrder(Order.asc("psdid"));
		c.addOrder(Order.asc("pedorder"));
		List<IG413Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG413SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//流程定义ID
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		//状态ID
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		//事件类型
		if(StringUtils.isNotEmpty(cond.getPedtype())){
			c.add(Expression.eq("pedtype", cond.getPedtype()));
		}
		//主键
		if(StringUtils.isNotEmpty(cond.getPedid_like())){
			c.add(Expression.like("pedid", cond.getPedid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PEDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	@SuppressWarnings("rawtypes")
	@IdGeneratorMethod("psdid")
	public String getPedidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(ped.pedid) FROM IG413TB ped WHERE ped.pedid LIKE :psdid";
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
