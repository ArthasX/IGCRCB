/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG699TB;
import com.deliverik.framework.workflow.prd.model.entity.IG909VW;

/**
 * 
 * 流程缺省参与者变量权限DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class IG699DAOImpl extends BaseHibernateDAOImpl<IG699Info> implements IG699DAO{

	/**
	 * 构造函数
	 */
	public IG699DAOImpl(){
		super(IG699TB.class);
	}
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG699Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pdvid"));
		List<IG699Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * @param pdvid 主键
	 * @return 检索结果
	 */
	public IG699Info findByPK(Serializable pdvid){
		IG699Info processInfoParticipantDef = super.findByPK(pdvid);
		
		if(processInfoParticipantDef == null) return null;

		return processInfoParticipantDef;
	}
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG699SearchCond cond){
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
	public List<IG699Info> findByCond(final IG699SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG699Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG699SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPdvid_like())){
			c.add(Expression.like("pdvid", cond.getPdvid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG909Info> searchIG909Info(final IG909SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG699DAO.searchIG909").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG909VW", IG909VW.class);
				setFetchPoint(q, 0, 0);
				List<IG909Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG909Info>) execute(action);
	}
	
	/**
	 * PDVID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PDVID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPdvidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(pdv.pdvid) FROM IG699TB pdv WHERE pdv.pdvid LIKE :psdid";
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
