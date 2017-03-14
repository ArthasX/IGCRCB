/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;

/**
 * <p>概述:流程变量信息DAO实现</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.检索条件生成</p>
 * <p>          5.条件检索处理(自定义流程关闭状态变量查看权限视图)</p>
 * <p>创建记录：</p>
 */
public class IG599DAOImpl extends BaseHibernateDAOImpl<IG599Info> implements IG599DAO {

	/**
	 * 功能：构造函数
	 */
	public IG599DAOImpl(){
		super(IG599TB.class);
	}

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG599Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("piid"));
		List<IG599Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * @param piid 主键
	 * @return 检索结果
	 */
	public IG599Info findByPK(Serializable piid) {

		IG599Info rl = super.findByPK(piid);
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
	public List<IG599Info> findByCond(final IG599SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("piid"));
		List<IG599Info> ret = findByCriteria(c, start, count);
		lazyLoad(ret);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG599SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if( cond.getPrid() != null && cond.getPrid() != 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		if( !StringUtils.isEmpty(cond.getPivarname())){
			c.add(Restrictions.eq("pivarname", cond.getPivarname()));
		}
		if( !StringUtils.isEmpty(cond.getPivartype())){
			c.add(Restrictions.eq("pivartype", cond.getPivartype()));
		}
		if( !StringUtils.isEmpty(cond.getPivarlabel())){
			c.add(Restrictions.eq("pivarlabel", cond.getPivarlabel()));
		}
		if( !StringUtils.isEmpty(cond.getPivarvalue())){
			c.add(Restrictions.eq("pivarvalue", cond.getPivarvalue()));
		}
		if( !StringUtils.isEmpty(cond.getPdid())){
			c.add(Restrictions.like("pidid", cond.getPdid()+"%"));
		}
		
		return c;
	}
	
	/**
	 * 功能：条件检索处理
	 * 
	 * 自定义流程关闭状态变量查看权限视图（缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG599Info> searchIG599InfoForClose(final IG599SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("ProcessInfoTBDAO.searchProcessInfoForClose").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
//				q.addEntity("pi", ProcessInfoTB.class);
				setFetchPoint(q, 0, 0);
				List<Object[]> list = q.list();
				List<IG599Info> processInfoList = new ArrayList<IG599Info>();
				IG599TB tb = null;
				for(Object[] lstInfo : list){
					tb = new IG599TB();
					tb.setPiid(Integer.parseInt(String.valueOf(lstInfo[0])));
					tb.setPidaccess(lstInfo[11].toString());
					processInfoList.add(tb);
				}
				session.clear();
				return processInfoList;
			}
		};
		return (List<IG599Info>) execute(action);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * 自定义流程关闭状态变量查看权限视图（缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG599Info> searchIG599InfoForSee(final IG599SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("ProcessInfoTBDAO.searchProcessInfoForSee").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("pi", IG599TB.class);
				setFetchPoint(q, 0, 0);
				List<IG599Info> list = q.list();
				List<IG599Info> lstInfo = new ArrayList<IG599Info>();
				for(IG599Info info : list){
					IG599TB tb = (IG599TB)SerializationUtils.clone(info);
					tb.setPidaccess(tb.getPivarname());
					tb.setPivarname(tb.getPivarlabel());
					lstInfo.add(tb);
				}
				return lstInfo;
			}
		};
		return (List<IG599Info>) execute(action);
	}
	
	protected void lazyLoad(List<IG599Info> list){
		if(list==null || list.isEmpty()){
			return ;
		}
		for(IG599Info info:list){
			Hibernate.initialize(info.getProcessPrivateInfofList());
		}
	}
	
	/**
	 * 功能：查询当前最大流水号
	 * @param prserialnum 流水号
	 * @param label 名称
	 * @return 最大流水号
	 */
	@SuppressWarnings("rawtypes")
	public String searchMaxSerialnum(String prserialnum, String label){
		String sql =  "select max(tb.pivarvalue) from IG599TB tb where PIVARLABEL='" + label + "' and PIVARVALUE like :prserialnum";
		NamedParamMap p = getNamedParamMap();
		p.setString("prserialnum", "WD"+prserialnum+"%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}
}
