/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowLedgeInfoVW;

/**
 * 
 * @Description:知识库查询表DAO实现
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowLedgeInfoDAOImpl extends BaseHibernateDAOImpl<KnowLedgeInfo>
		implements KnowLedgeInfoDAO {
	/**
	 * 构造函数
	 */
	public KnowLedgeInfoDAOImpl() {
		super(KnowLedgeInfoVW.class);
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final KnowledgeSearchCond cond) {
		
		return this.findByCondForCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<KnowLedgeInfo> findByCond(final KnowledgeSearchCond cond,
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(StringUtils.isEmpty(cond.getSystemid())){
					query.append(session.getNamedQuery("KnowLedgeInfoDAO.knowLedgeInfoDAO").getQueryString());
				}else{
					query.append(session.getNamedQuery("KnowLedgeInfoDAO.knowLedgeInfoDAOWithSI").getQueryString());
					
				}
				StringBuffer sql = getCriteria(cond);
				query.append(sql);
				//query.append(" order by a.grade desc");
				//System.out.println(query.toString());

				SQLQuery q = session.createSQLQuery(query.toString());
				
				List<String> paramList = new ArrayList<String>();
				List<Type> typeList = new ArrayList<Type>();
				//需要按顺序给？参数赋值
				if(StringUtils.isNotEmpty(cond.getSystemid())){
					paramList.add(cond.getSystemid());
					typeList.add(Hibernate.STRING);
				}
				if(cond.getKnkeys()!=null && (StringUtils.isNotEmpty(cond.getKnkeys()[0])) && cond.getKnkeys().length>0){
					int length = cond.getKnkeys().length;
					paramList.addAll(Arrays.asList(cond.getKnkeys()));
					for(int i = 0; i < length; i++){
						typeList.add(Hibernate.STRING);
					}
				}
				if(cond.getKntitles()!=null && (StringUtils.isNotEmpty(cond.getKntitles()[0])) && cond.getKntitles().length>0){
					paramList.addAll(Arrays.asList(cond.getKntitles()));
					paramList.addAll(Arrays.asList(cond.getKntitles()));
					paramList.addAll(Arrays.asList(cond.getKntitles()));
					paramList.addAll(Arrays.asList(cond.getKntitles()));
					int length = cond.getKntitles().length * 4;
					for(int i = 0; i < length; i++){
						typeList.add(Hibernate.STRING);
					}
				}
				q.setParameters(paramList.toArray(), typeList.toArray(new Type[0]));
				
				q.setProperties(cond);
				q.addEntity("KnowLedgeInfoVW",KnowLedgeInfoVW.class);
				
				setFetchPoint(q, start, count);
				List<KnowLedgeInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<KnowLedgeInfo>) execute(action);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int findByCondForCount(final KnowledgeSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(StringUtils.isEmpty(cond.getSystemid())){
					query.append(session.getNamedQuery("KnowLedgeInfoDAO.knowLedgeInfoCountDAO").getQueryString());
				}else{
					query.append(session.getNamedQuery("KnowLedgeInfoDAO.knowLedgeInfoCountDAOWithSI").getQueryString());
					
				}
				StringBuffer sql = getCriteria(cond);
				query.append(sql);
				query.append(") V2");

				SQLQuery q = session.createSQLQuery(query.toString());
				List<String> paramList = new ArrayList<String>();
				List<Type> typeList = new ArrayList<Type>();
				//需要按顺序给？参数赋值
				if(StringUtils.isNotEmpty(cond.getSystemid())){
					paramList.add(cond.getSystemid());
					typeList.add(Hibernate.STRING);
				}
				if(cond.getKnkeys()!=null && (StringUtils.isNotEmpty(cond.getKnkeys()[0])) && cond.getKnkeys().length>0){
					int length = cond.getKnkeys().length;
					paramList.addAll(Arrays.asList(cond.getKnkeys()));
					for(int i = 0; i < length; i++){
						typeList.add(Hibernate.STRING);
					}
				}
				if(cond.getKntitles()!=null && (StringUtils.isNotEmpty(cond.getKntitles()[0])) && cond.getKntitles().length>0){
					paramList.addAll(Arrays.asList(cond.getKntitles()));
					paramList.addAll(Arrays.asList(cond.getKntitles()));
					paramList.addAll(Arrays.asList(cond.getKntitles()));
					paramList.addAll(Arrays.asList(cond.getKntitles()));
					int length = cond.getKntitles().length * 4;
					for(int i = 0; i < length; i++){
						typeList.add(Hibernate.STRING);
					}
				}
				q.setParameters(paramList.toArray(), typeList.toArray(new Type[0]));
				
				q.setProperties(cond);
				
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<KnowLedgeInfo> findByCondTime(final KnowledgeSearchCond cond,
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("KnowLedgeInfoDAO.knowLedgeInfoDAO").getQueryString());
				StringBuffer sql = getCriteriaTime(cond);
				query.append(sql);
				//query.append(" order by a.grade desc");
				//System.out.println(query.toString());
				SQLQuery q = session.createSQLQuery(query.toString());
				//q.setProperties(cond);
				q.addEntity("KnowLedgeInfoVW",KnowLedgeInfoVW.class);
				
				setFetchPoint(q, start, count);
				List<KnowLedgeInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<KnowLedgeInfo>) execute(action);
	}
	
	/**
	 * 约束条件sql拼写
	 * @param cond
	 * @return StringBuffer
	 */
	protected StringBuffer getCriteria(KnowledgeSearchCond cond) {
		StringBuffer sql = new StringBuffer();
		
		
		if(cond.getKnkeys() != null){
			if((!"".equals(cond.getKnkeys()[0])) && cond.getKnkeys().length>0){
				sql.append(" and (");
				for(int i=0;i<cond.getKnkeys().length;i++){
					sql.append(" Upper(j.knkey) like ('%' || Upper(?) || '%') or");
				}
				int length = sql.length();
				//query.substring(0, length);
				sql.delete(length-3, length);
				sql.append(")");
			}
		}
		
		if(cond.getKntitles()!=null && (StringUtils.isNotEmpty(cond.getKntitles()[0])) && cond.getKntitles().length>0){
			sql.append(" and (");
			for(int i=0;i<cond.getKntitles().length;i++){
				sql.append(" Upper(j.kntitle) like ('%' || Upper(?) || '%') or");
			}
			for(int i=0;i<cond.getKntitles().length;i++){
				sql.append(" Upper(j.knfaultcause) like ('%' || Upper(?) || '%') or");
			}
			for(int i=0;i<cond.getKntitles().length;i++){
				sql.append(" Upper(j.knsolveway) like ('%' || Upper(?) || '%') or");
			}
			for(int i=0;i<cond.getKntitles().length;i++){
				sql.append(" Upper(j.kndes) like ('%' || Upper(?) || '%') or");
			}
			int length = sql.length();
			//query.substring(0, length);
			sql.delete(length-3, length);
			sql.append(")");
		}
		if(StringUtils.isNotEmpty(cond.getKnclass())){
			sql.append(" and Upper(j.knclass)= Upper(:knclass)");
		}
		if(StringUtils.isNotEmpty(cond.getKnclass_like())){
			sql.append(" and Upper(j.knclass) like (Upper(:knclass_like)|| '%')");
		}
		if(StringUtils.isNotEmpty(cond.getKnproffername())){
			sql.append(" and ");
			sql.append(" Upper(j.knproffername) like ('%' || Upper(:knproffername) || '%')");
		}
		if(StringUtils.isNotEmpty(cond.getKnapprovetime_f())){
			sql.append(" and ");
			sql.append(" j.knapprovetime >= :knapprovetime_f");
		}
		if(StringUtils.isNotEmpty(cond.getKnapprovetime_t())){
			sql.append(" and ");
			sql.append(" j.knapprovetime <= (:knapprovetime_t || '/23:59')");
		}
		if(StringUtils.isNotEmpty(cond.getKntelarea())){
			sql.append(" and ");
			sql.append(" j.kntelarea = :kntelarea");
		}
//		if(!"".equals(cond.getKnarea())){
//			sql.append(" and ");
//			sql.append(" b.knarea = '"+cond.getKnarea()+"'");
//		}
		if(StringUtils.isNotEmpty(cond.getKnorigin())){
			sql.append(" and ");
			sql.append(" j.knorigin = :knorigin");
		}
		
		if(StringUtils.isNotEmpty(cond.getKnserial_like())){
			sql.append(" and ");
			sql.append(" Upper(j.knserial) like ('%' || Upper(:knserial_like) || '%')");
		}
		if(StringUtils.isNotEmpty(cond.getOrder())){
			if("ASC".equals(cond.getSing())){
				sql.append("  order by "+cond.getOrder()+" asc");
			}else{
				sql.append("  order by "+cond.getOrder()+" desc");
			}
		}else{
			sql.append("   order by i.grade desc");
		}
		
		return sql;
	}

	/**
	 * 检索个部门贡献知识数量
	 * @return 检索个部门贡献知识数量
	 */
	@SuppressWarnings("unchecked")
	public List<KnowLedgeInfo> findKgmSummary() {
			HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("KnowLedgeDAO.knowLedgeForSummary").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("KnowLedgeInfoVW",KnowLedgeInfoVW.class);
				setFetchPoint(q, 0, 0);
				List<KnowLedgeInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<KnowLedgeInfo>) execute(action);
	}
	
	/**
	 * 约束条件sql拼写
	 * @param cond
	 * @return StringBuffer
	 */
	protected StringBuffer getCriteriaTime(KnowledgeSearchCond cond) {
		StringBuffer sql = new StringBuffer();
		sql.append(" order by j.knapprovetime desc");
		return sql;
	}
}
