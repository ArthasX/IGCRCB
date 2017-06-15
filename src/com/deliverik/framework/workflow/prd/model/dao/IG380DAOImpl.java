/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG913VW;

/**
 * <p>概述:流程类型定义DAO实现</p>
 * <p>功能描述：1.流程类型全部检索</p>
 * <p>          2.条件查询结果数</p>
 * <p>          3.主键查询</p>
 * <p>          4.条件查询结果</p>
 * <p>          5.检索条件生成</p>
 * <p>          6.条件检索处理（人员角色检索SearchCond 全部检索）</p>
 * <p>          7.条件检索处理（人员角色检索SearchCond）</p>
 * <p>          8.检索处理(运维计划用)</p>
 * <p>创建记录：</p>
 * <p>修改记录：杨盛楠	2010-12-13</p>
 */
public class IG380DAOImpl extends
		BaseHibernateDAOImpl<IG380Info> implements
		IG380DAO {
	
	private static String nextPdid = "";

	/**
	 * 功能：构造函数
	 */
	public IG380DAOImpl() {
		super(IG380TB.class);
	}

	/**
	 * 功能：流程类型全部检索
	 * @return 流程类型定义结果集
	 */
	@Override
	public List<IG380Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ptid"));
		c.addOrder(Order.asc("pdid"));
		List<IG380Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 功能：主键查询
	 * @param prid
	 * @return IG380Info
	 */
	@Override
	public IG380Info findByPK(Serializable prid) {

		IG380Info pr = super.findByPK(prid);
		if (pr == null)
			return null;

		return pr;
	}

	/**
	 * 功能：条件查询结果
	 * @param cond
	 * @param start
	 * @param count
	 * @return 查询结果集
	 */
	public List<IG380Info> findByCond(
			final IG380SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ptid"));
		//应急管理专用，19代表场景流程定义
		if(cond.getPtid()!=null&&cond.getPtid()==19){
			c.addOrder(Order.desc("pdid"));
		}else{
			c.addOrder(Order.asc("pdid"));
		}
		List<IG380Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG380SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Restrictions.eq("pdid", cond.getPdid()));
		}
		if (cond.getPtid() != null && cond.getPtid() != 0) {
			c.add(Restrictions.eq("ptid", cond.getPtid()));
		}
		if (!StringUtils.isEmpty(cond.getPdname())) {
			c.add(Restrictions.eq("pdname", cond.getPdname()));
		}
		if (!StringUtils.isEmpty(cond.getPdstatus())) {
			c.add(Restrictions.eq("pdstatus", cond.getPdstatus()));
		}
		
		if (cond.getNotSelfPd() != null && cond.getNotSelfPd() != 0) {
			c.add(Restrictions.ne("ptid", cond.getNotSelfPd()));
		}
		if(cond.getPrTypeArray() != null){
			c.add(Restrictions.in("ptid", cond.getPrTypeArray()));
		}
		if(cond.getPdstatuses()!=null){
			c.add(Restrictions.in("pdstatus", cond.getPdstatuses()));
		}
		
		if(!StringUtils.isEmpty(cond.getPermission())){
			c.add(Restrictions.eq("permission", cond.getPermission()));
		}
		
		if(!StringUtils.isEmpty(cond.getPdid_like())){
			c.add(Restrictions.like("pdid", cond.getPdid_like() + "%"));
		}
		if(cond.getPdid_in()!=null &&cond.getPdid_in().length>0){
			c.add(Restrictions.in("pdid", cond.getPdid_in()));
		}
		if(cond.getPdid_not_in()!=null &&cond.getPdid_not_in().length>0){
			c.add(Restrictions.not(Restrictions.in("pdid", cond.getPdid_not_in())));
		}
		
		if(cond.getPrpdid_like_or() != null && cond.getPrpdid_like_or().length > 0){
		    String[] prpdid_like_or = cond.getPrpdid_like_or();
            StringBuffer query = new StringBuffer();
            query.append(" ( ");
            for (int i = 0; i < prpdid_like_or.length; i++) {
                query.append(" pdid like '").append(prpdid_like_or[i]).append("%' ");
                if(i < prpdid_like_or.length - 1){
                    query.append(" or ");
                }
            }
            query.append(" ) ");
            c.add(Restrictions.sqlRestriction(query.toString()));
        }
		if(StringUtils.isNotEmpty(cond.getActname())){
		    c.add(Restrictions.eq("pdactname", cond.getActname()));
		}
		if(cond.getPdid_in()!=null){	
			if(cond.getPdid_in().length>0){
				c.add(Restrictions.in("pdid", cond.getPdid_in()));
			}else{
				c.add(Restrictions.in("pdid", new String[]{"1"}));
			}
		}
		if(cond.getPdid_not_in()!=null){
			if(cond.getPdid_not_in().length>0){
				c.add(Restrictions.not(Restrictions.in("pdid", cond.getPdid_not_in())));
			}else{
				c.add(Restrictions.not(Restrictions.in("pdid", new String[]{"1"})));
			}
		}
		
		return c;
	}

	
	public int getSearchCount(final IG380SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * 指定用户可发起自定义流程查询处理
	 * @param userid 用户ID
	 * @param pdstatus 自定义流程状态
	 * @return 指定用户可发起自定义流程列表
	 */
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findSelfDefinitionByUserId(final String userid, final String pdstatus){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.selfDefQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("userid", userid);
				q.setString("pdstatus", pdstatus);
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, 0, 0);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	
	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findSelfDefinitionByUserIdCom(final UserRoleSearchCond cond, final Integer ptid
			, final String pdstatus){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.selfDefComQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.setInteger("ptid", ptid);
				q.setString("pdstatus", pdstatus);
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, 0, 0);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	//====>监管报表Begin
	/**
	 * PDID主键值取得
	 * @param pdid_one 模板标识
	 * 
	 * @return PDID主键值
	 */
	
	public String getPdidSequenceNextValue(String firstsite,String pdsequence) {
		return StringUtils.leftPad(getSequenceNextValue(pdsequence) + "", IGPRDCONSTANTS.ID_PREFIX_LENGTH, firstsite)
				+ StringUtils.leftPad("1", IGPRDCONSTANTS.ID_VERSION_LENGTH, "0");
		
	}
	//====>监管报表End
	/**
	 * 升版后PDID主键值取得
	 * 
	 * @return 升版后PDID主键值
	 */
	private static String getPdidUpgradeNextValue(String pdid) {
		return pdid.substring(0, IGPRDCONSTANTS.ID_PREFIX_LENGTH)
		+ StringUtils.leftPad(Integer.parseInt(pdid.substring(
				IGPRDCONSTANTS.ID_PREFIX_LENGTH, IGPRDCONSTANTS.ID_PREFIX_LENGTH + IGPRDCONSTANTS.ID_VERSION_LENGTH)) + 1 + "", 
				IGPRDCONSTANTS.ID_VERSION_LENGTH, "0");
	}
	
	/**
	 * 流程定义升版处理
	 * 
	 * @param pdid 流程定义ID
	 */
//	public void upgradeProcessDefVersion(final String pdid) {
//		HibernateCallback action = new HibernateCallback() {
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				session.flush();
//				SQLQuery q = session.createSQLQuery(
//						"{Call PRO_PROCESSDEFVERSION(?, ?, ?)}");
//
//				q.setString(0, pdid);
//				q.setString(1, getPdidUpgradeNextValue(pdid));
//				q.setString(2,"0");
//				Object o = q.executeUpdate();
//				session.clear();
//				return o; 
//			}
//		};
//		execute(action);
//	}
	
	public String upgradeProcessDefVersion(final String pdid) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				String newPdid = getPdidUpgradeNextValue(pdid);
				SQLQuery q = session.createSQLQuery(
//						"SELECT PRO_PROCESSDEFVERSION(?, ?, ?)");
			//调用存储过程
						"{Call PRO_PROCESSDEFVERSION(?, ?, '0')}");
				q.setString(0, pdid);
				q.setString(1, newPdid);
//				q.setString(2,"0");
				q.executeUpdate();
				session.clear();
				return newPdid; 
			}
		};
		return (String) execute(action);
	}
	/**
	 * 流程定义复制处理
	 * 
	 * @param pdid 流程定义ID
	 * @param pdsequence 序列定义
	 */
//	public void copyProcessDefVersion(final String pdid,final String pdsequence) {
//		HibernateCallback action = new HibernateCallback() {
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				session.flush();
//				
//				SQLQuery q = session.createSQLQuery(
//						"{Call PRO_PROCESSDEFVERSION(?, ?, ?)}");
//				q.setString(0, pdid);
//				q.setString(1, getPdidSequenceNextValue(new String(new char[]{pdid.charAt(0)}),pdsequence));
//				q.setString(2,"1");
//				Object o = q.executeUpdate();
//				session.clear();
//				return o; 
//			}
//		};
//		execute(action);
//	}
	
	public String copyProcessDefVersion(final String pdid,final String pdsequence) {
		nextPdid = getPdidSequenceNextValue(new String(new char[]{pdid.charAt(0)}),pdsequence);
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				
				SQLQuery q = session.createSQLQuery(
"{CALL PRO_PROCESSDEFVERSION(?, ?, ?)}");
				q.setString(0, pdid);
				q.setString(1, nextPdid);
				q.setString(2,"1"); 
				int i = q.executeUpdate();
				session.clear();  
				return i; 
			}
		};
		execute(action);
		//新生成的pdid 
		return nextPdid; 
	}
	
	public int getSearchLastCount(final IG380SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.searchLastCount1").getQueryString()).append(" ");
				getSQL(cond,query);
				query.append(session.getNamedQuery("IG380DAO.searchLastCount3").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer)execute(action);
	}
	
	/**
	 * 检索历史流程定义版本信息
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	
	public int getSearchHistoryCount(final IG380SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.searchHistoryCount1").getQueryString());
				getSQLHistory(cond,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer)execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(IG380SearchCond cond, StringBuffer query){
		if(cond.getPrTypeArray() != null && cond.getPrTypeArray().length > 0){
			StringBuffer queryBuf = new StringBuffer(" AND PTID IN (");
			for(int typeId : cond.getPrTypeArray()){
				queryBuf.append(typeId).append(",");
			}
			query.append(queryBuf.toString().substring(0, queryBuf.toString().length()-1)).append(") ");
		}
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQLHistory(IG380SearchCond cond, StringBuffer query){
		if(cond.getPtid() != null && cond.getPtid() > 0){
			query.append(" and ptid = ");
			query.append(cond.getPtid());
			query.append(" ");
		}
		if(cond.getPrTypeArray() != null && cond.getPrTypeArray().length > 0){
			StringBuffer queryBuf = new StringBuffer(" AND PTID IN (");
			for(int typeId : cond.getPrTypeArray()){
				queryBuf.append(typeId).append(",");
			}
			query.append(queryBuf.toString().substring(0, queryBuf.toString().length()-1)).append(") ");
		}
		//取PDID的前五位
		if(StringUtils.isNotEmpty(cond.getPdid()) && cond.getPdid().length() == 7){
			query.append(" AND PDID LIKE '").append(cond.getPdid().substring(0,5)).append("%' AND PDID !='").append(cond.getPdid()).append("'");
		}
		if(StringUtils.isNotEmpty(cond.getPdstatus())){
			query.append(" AND PDSTATUS = '").append(cond.getPdstatus()).append("' ");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findLastByCond(
			final IG380SearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.searchLastCount2").getQueryString()).append(" ");
				getSQL(cond,query);
				query.append(session.getNamedQuery("IG380DAO.searchLastCount3").getQueryString());
				query.append(" ORDER BY PDID ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, start, count);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findHistoryByCond(
			final IG380SearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.searchHistoryCount2").getQueryString());
				getSQLHistory(cond,query);
				query.append(" ORDER BY PDID ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, start, count);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	
	/**
	 * 功能：检索处理(运维计划用)
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findSelfDefinitionAll(){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.selfDefAllQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, 0, 0);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	
	/**
     * 查询相关发起的自定义流程类型信息
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    
	@SuppressWarnings("unchecked")
    public List<IG913Info> relevantProcessfindByCond(final IG913SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            
			public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG380DAO.searchIG911").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG913VW", IG913VW.class);
                setFetchPoint(q, 0, 0);
                List<IG913Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG913Info>) execute(action);
    }
    
    /**
     * 查询缺省权限的相关发起的自定义流程类型信息
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    
	@SuppressWarnings("unchecked")
    public List<IG913Info> relevantProcessfindByCondDefault(final IG913SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            
			public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG380DAO.searchIG931").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG913VW", IG913VW.class);
                setFetchPoint(q, 0, 0);
                List<IG913Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG913Info>) execute(action);
    }
}
