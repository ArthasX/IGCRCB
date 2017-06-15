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
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;

/**
 * 
 * 流程状态定义DAO实现
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("deprecation")
public class IG333DAOImpl extends BaseHibernateDAOImpl<IG333Info> implements IG333DAO{

	/**
	 * 构造函数
	 */
	public IG333DAOImpl(){
		super(IG333TB.class);
	}
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG333Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("bysequence"));
		c.addOrder(Order.asc("psdid"));
		List<IG333Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public IG333Info findByPK(Serializable psdid){
		
		IG333Info processStatusDef = super.findByPK(psdid);
		
		if(processStatusDef == null) return null;

		return processStatusDef;
	}
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG333SearchCond cond){
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
	public List<IG333Info> findByCond(final IG333SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		//判断是否为应急所需的流程节点
//		if(StringUtils.isEmpty(cond.getDrmSign())){
//			c.addOrder(Order.asc("bysequence"));
//			c.addOrder(Order.desc("psdcode"));
//		}
		c.addOrder(Order.asc("psdid"));
		List<IG333Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 根据分派状态和分派按钮查询被分派节点集合
	 */
	@SuppressWarnings("unchecked")
	public List<IG333Info> findByAssign(final IG333SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG333DAO.findByAssign").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("assignpsdid", cond.getAssignpsdid());
				q.setString("assignpbdid", cond.getAssignpbdid());
				q.addEntity(IG333TB.class);
				setFetchPoint(q, 0, 0);
				session.clear();
				return q.list();
			}
		};
		return (List<IG333Info>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG333SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPdid_like())){
			c.add(Expression.like("pdid", cond.getPdid_like()+"%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if( StringUtils.isNotEmpty(cond.getPsdname())){
			c.add(Expression.eq("psdname", cond.getPsdname()));
		}
		if( StringUtils.isNotEmpty(cond.getPsdcode())){
			String status = cond.getPsdcode();
			if(status.length() > 3) {
				if (status.indexOf("_") > -1) {
					c.add(Expression.eq("psdid", status.split("_")[0]));
				} else {
					c.add(Expression.eq("psdid", status));
				}
			} else {
				c.add(Expression.eq("psdcode", status));
			}
		}
		if( StringUtils.isNotEmpty(cond.getPsdtype())){
			c.add(Expression.eq("psdtype", cond.getPsdtype()));
		}
		if( StringUtils.isNotEmpty(cond.getPsdmode())){
			c.add(Expression.eq("psdmode", cond.getPsdmode()));
		}
		if( StringUtils.isNotEmpty(cond.getPsdflag())){
			c.add(Expression.eq("psdflag", cond.getPsdflag()));
		}
		
		if( StringUtils.isNotEmpty(cond.getAssignpsdid())){
			c.add(Expression.eq("assignpsdid", cond.getAssignpsdid()));
		}
		
		if( StringUtils.isNotEmpty(cond.getAssignpbdid())){
			c.add(Expression.eq("assignpbdid", cond.getAssignpbdid()));
		}
		
		if(StringUtils.isNotEmpty(cond.getNotContainEndStatus()) && "1".equalsIgnoreCase(cond.getNotContainEndStatus())){
			c.add(Expression.or(Expression.ne("psdcode", IGPRDCONSTANTS.PROCESS_END_STATUS), Expression.isNull("psdcode")));
		}
		if(StringUtils.isNotEmpty(cond.getNotContainStartStatus()) && "1".equalsIgnoreCase(cond.getNotContainStartStatus())){
			c.add(Expression.or(Expression.ne("psdcode", IGPRDCONSTANTS.PROCESS_START_STATUS), Expression.isNull("psdcode")));
		}
		if(StringUtils.isNotEmpty(cond.getNotContainSelf())){
			c.add(Expression.ne("psdid", cond.getNotContainSelf()));
		}
		if(StringUtils.isNotEmpty(cond.getPsdid_like())){
			c.add(Expression.like("psdid", cond.getPsdid_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getFormGlobalControl())){
			c.add(Expression.eq("formGlobalControl", cond.getFormGlobalControl()));
		}
		if(StringUtils.isNotEmpty(cond.getPpsdid())){
			if("null".equals(cond.getPpsdid())){
				c.add(Expression.isNull("ppsdid"));
			}else{
				c.add(Expression.eq("ppsdid", cond.getPpsdid()));
			}
		}
		if("Y".equals(cond.getFatherflag())){
			c.add(Expression.isNull("ppsdid"));
		}
		return c;
	}	
	
	/**
	 * PSDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PSDID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPsdidSequenceNextValue(String pdid) {
		String sql =  "SELECT MAX(psd.psdid) FROM IG333TB psd WHERE psd.psdid LIKE :pdid";
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
	
	/**
	 * 指定状态关联的可调整参与者的状态集合取得
	 *
	 * @param psdid 状态ID
	 * @return 状态集合
	 */
	@SuppressWarnings("unchecked")
	public List<IG333Info> searchAdjustStatus(final String psdid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG333DAO.searchAdjustStatus").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("psdid", psdid);
				q.addEntity("psd",IG333TB.class);
				setFetchPoint(q, 0, 0);
				List<IG333Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG333Info>) execute(action);
	}
	
}
