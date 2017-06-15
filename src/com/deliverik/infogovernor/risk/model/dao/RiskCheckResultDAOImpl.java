/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;

/**
 * 风险检查结果DAO实现
 */
@SuppressWarnings("unchecked")
public class RiskCheckResultDAOImpl extends BaseHibernateDAOImpl<RiskCheckResult> implements RiskCheckResultDAO {

	static Log log = LogFactory.getLog(RiskCheckResultDAOImpl.class);
	/**
	 * 构造函数
	 */
	public RiskCheckResultDAOImpl(){
		super(RiskCheckResultTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskCheckResult> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rcrid"));
		List<RiskCheckResult> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rcid 主键
	 * @return 检索结果
	 */
	public RiskCheckResult findByPK(Serializable rcrid) {

		RiskCheckResult result = super.findByPK(rcrid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskCheckResultSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskCheckResultDAOImpl.selCount").getQueryString());
				if(StringUtils.isNotEmpty(cond.getRcclass())){
					query.append(" and rc.rcclass = :rcclass ");
				}
				if(StringUtils.isNotEmpty(cond.getRcusername())){
					query.append(" and rc.rcusername like '%' || :rcusername || '%'");
				}
				/*if(StringUtils.isNotEmpty(cond.getCiiop())){
					query.append(" and rc.ciiop like '%' || :ciiop || '%'");
				}*/
				if(StringUtils.isNotEmpty(cond.getRcapprovetime())){
					query.append(" and rcr.rcrplandate < :rcapprovetime   and  :rcapprovetime <rc.rcenddate");
				}
				if(StringUtils.isNotEmpty(cond.getRcrplandate_from())){
					query.append(" and rcr.rcrplandate > :rcrplandate_from");
				}
				if(StringUtils.isNotEmpty(cond.getRcrplandate_to())){
					query.append(" and rcr.rcrplandate < :rcrplandate_to");
				}
				if(StringUtils.isNotEmpty(cond.getRcrrealtime_isNull())){
					query.append(" and rcr.rcrrealtime is null");
				}
				if(StringUtils.isNotEmpty(cond.getRcruserid_isNull())){
					query.append(" and (rcr.rcruserid='' or rcr.rcruserid is null)");
				}
				if(cond.getRcrid_in()!=null && cond.getRcrid_in().length>0){
					query.append(" and rcr.rcrid in (");
					for(int i=0;i<cond.getRcrid_in().length;i++){
						query.append("'");
						query.append(cond.getRcrid_in()[i]);
						query.append("'");
						if(i < cond.getRcrid_in().length-1){
							query.append(",");
						}
					}
					query.append(")");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				Integer count = getCount(q.list());
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> findByCond(final RiskCheckResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rctype"));
		c.addOrder(Order.asc("rcrid"));
		List<RiskCheckResult> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskCheckResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//风险检查设定的执行日期
		if( !StringUtils.isEmpty(cond.getRcrplandate())){
			c.add(Restrictions.like("rcrplandate", cond.getRcrplandate()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getRcrplandate_from())){
			c.add(Restrictions.le("rcrplandate", cond.getRcrplandate()));
		}
		if( !StringUtils.isEmpty(cond.getRcrplandate_to())){
			c.add(Restrictions.ge("rcrplandate", cond.getRcrplandate()));
		}
		if( !StringUtils.isEmpty(cond.getRcruserid_isNull())){
			c.add(Restrictions.or(Restrictions.eq("rcruserid", ""),Restrictions.isNull("rcruserid")));
		}
		
		if( !StringUtils.isEmpty(cond.getStartdate())){
			c.add(Restrictions.ge("rcrplandate", cond.getStartdate() + " 00:00"));
		}
		
		if( !StringUtils.isEmpty(cond.getEnddate())){
			c.add(Restrictions.le("rcrplandate", cond.getEnddate() + " 23:59"));
		}
		if( !StringUtils.isEmpty(cond.getRcclass())){
			c.add(Restrictions.sqlRestriction(" exists (select 1 from riskcheck rc where rc.rcid = this_.rcid and rc.rcclass = '"+cond.getRcclass()+"')"));
		}
		if( cond.getRcid()!=null && cond.getRcid()!=0){
			c.add(Restrictions.eq("rcid", cond.getRcid()));
		}
		if(StringUtils.isNotEmpty(cond.getRcruserid())){
			c.add(Restrictions.eq("rcruserid", cond.getRcruserid()));
		}
		
		if(StringUtils.isNotEmpty(cond.getRccategory())){
		    c.createCriteria("riskCheck").add(Restrictions.like("rccategory", cond.getRccategory() + "%"));
		}
		
		if(cond.getRcroleid() != null && cond.getRcroleid().length > 0){
			StringBuffer sql = new StringBuffer();
			sql.append(" riskcheckt2_.rcroleid in(");
			Integer[] roleids = cond.getRcroleid();
			for(int i = 0; i < cond.getRcroleid().length; i++){
				sql.append(roleids[i]);
				if(cond.getRcroleid().length != i + 1){
					sql.append(", ");
				}
			}
			sql.append(") ");
			c.add(Restrictions.sqlRestriction(sql.toString()));  
		}
		
		if(StringUtils.isNotEmpty(cond.getRcuserid_ne())){
			StringBuffer sql = new StringBuffer();
			sql.append(" (riskcheckt2_.rcuserid <> '");
			sql.append(cond.getRcuserid_ne());
			sql.append("' or riskcheckt2_.rcuserid is null)");
			
			c.add(Restrictions.sqlRestriction(sql.toString())); 
			
		}
		
		if(StringUtils.isNotEmpty(cond.getRcuserid())){
			StringBuffer sql = new StringBuffer();
			sql.append(" riskcheckt2_.rcuserid = '");
			sql.append(cond.getRcuserid());
			sql.append("' ");
			
			c.add(Restrictions.sqlRestriction(sql.toString())); 
			
		}

		//风险检查状态
		if(StringUtils.isNotEmpty(cond.getRcrstatic())){
			StringBuffer sql = new StringBuffer();
			// 已检查
			if("1".equals(cond.getRcrstatic())){
				sql.append(" rcrrealtime is not null ");
			}
			// 未检查
			else if("2".equals(cond.getRcrstatic())){
				sql.append(" rcrrealtime is null ");
			}
			c.add(Restrictions.sqlRestriction(sql.toString())); 
		}
		return c;
	}

	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> findResultByCond(final RiskCheckResultSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskCheckResultDAOImpl.lastRiskCheckResultQuery").getQueryString());
				if(StringUtils.isNotEmpty(cond.getRcusername_like())){
					query.append(" and r.rcusername like :username");
				}
				if(StringUtils.isNotEmpty(cond.getRcname_like())){
					query.append(" and r.rcname like :rcname");
				}
				if(StringUtils.isNotEmpty(cond.getRcrusername())){
					query.append(" and t.rcrusername like :rcrusername");
				}
				if(StringUtils.isNotEmpty(cond.getRcruserid())){
					query.append(" and t.rcruserid like :rcruserid");
				}
				if(StringUtils.isNotEmpty(cond.getRcrresult())){
					query.append(" and t.rcrresult = :rcrresult");
				}
				//重要程度
				if(StringUtils.isNotEmpty(cond.getRctype_eq())){
					query.append(" and t.rctype = '" + cond.getRctype_eq() + "'");
				}
				if(StringUtils.isNotEmpty(cond.getRcclass())){
					query.append(" and r.rcclass = '"+ cond.getRcclass()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getRcrtestmode())){
					query.append(" and r.rcrtestmode = '");
					query.append(cond.getRcrtestmode());
					query.append("' ");
				}
				//风险检查状态
				if(StringUtils.isNotEmpty(cond.getRcrstatic())){
					// 已检查
					if("1".equals(cond.getRcrstatic())){
						query.append(" and t.rcrrealtime is not null ");
					}
					// 未检查
					else if("2".equals(cond.getRcrstatic())){
						query.append(" and t.rcrrealtime is null ");
					}
				}
				if(StringUtils.isNotEmpty(cond.getNtime_from())){
					query.append(" and t.rcrplandate >= :ntime_ge");
				}
				if(StringUtils.isNotEmpty(cond.getNtime_to())){
					query.append(" and t.rcrplandate <= :ntime_le ");
				}
				if(StringUtils.isNotEmpty(cond.getRccategory())){
					query.append(" and r.rccategory = '"+cond.getRccategory()+"'");
				}
				if( cond.getRcid()!=null && cond.getRcid()!=0){
					query.append(" and t.rcid = "+cond.getRcid()+"");
				}
				if(StringUtils.isNotEmpty(cond.getStartdate())){
					query.append(" and t.rcrrealtime >= '"+cond.getStartdate()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getEnddate())){
					query.append(" and t.rcrrealtime <= '"+cond.getEnddate()+" 23:59'");
				}
				if(StringUtils.isNotEmpty(cond.getRcrrealtime_like())){
					query.append(" and t.rcrrealtime like '");
					query.append(cond.getRcrrealtime_like());
					query.append("%' ");
				}
				if(StringUtils.isNotEmpty(cond.getChtype())){
					query.append(" and t.rcrrealtime is null");
				}
				if(StringUtils.isNotEmpty(cond.getRcrrealtime_isNull())){
					query.append(" and t.rcrrealtime is null");
				}
				//风险检查相关人员
				if(StringUtils.isNotEmpty(cond.getRcrelateduser())){
					query.append(" and (r.RCUSERNAME like :relateduser or t.RCRUSERNAME  like :relateduser)");
				}
				//getSQL(cond, query, riskCheckResultQuery);
			    query.append(" order by rcrrealtime DESC,RCRPLANDATE DESC ");
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("t",RiskCheckResultTB.class);
				if(StringUtils.isNotEmpty(cond.getRcusername_like())){
					q.setString("username", "%"+cond.getRcusername_like()+"%");
				}
				if(StringUtils.isNotEmpty(cond.getRcrusername())){
					q.setString("rcrusername", "%"+cond.getRcrusername()+"%");
				}
				if(StringUtils.isNotEmpty(cond.getRcname_like())){
					q.setString("rcname", "%"+cond.getRcname_like()+"%");
				}
				if(StringUtils.isNotEmpty(cond.getRcrresult())){
					q.setString("rcrresult",cond.getRcrresult());
				}
				if(StringUtils.isNotEmpty(cond.getNtime_from())){
					q.setString("ntime_ge", cond.getNtime_from());
				}
				if(StringUtils.isNotEmpty(cond.getNtime_to())){
					q.setString("ntime_le", cond.getNtime_to()+" 23:59");
				}
				if(StringUtils.isNotEmpty(cond.getRcruserid())){
					q.setString("rcruserid", cond.getRcruserid());
				}
				//风险检查相关人员
				if(StringUtils.isNotEmpty(cond.getRcrelateduser())){
					q.setString("relateduser", "%"+cond.getRcrelateduser()+"%");
				}

				//q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<RiskCheckResult> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("检索时间：" + (end - start)/1000 + "秒");
					log.debug("检索结果件数：" + list.size() + "件");
					log.debug("检索SQL：" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<RiskCheckResult>) execute(action);
	}

	/**
	 * 首页检查工作查询
	 * @param userid 查询用户ID
	 * @param desc 是否按时间倒序排列
	 * @param group 是否查询相关检查工作信息(true:是;flase:否) 
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> riskCheckResultGoup(final String userid, final boolean desc, final boolean group){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskCheckResultDAOImpl.riskCheckResultGoup").getQueryString());
				
				
				//是否查询相关检查工作信息（责任组或合作组）
				if(group){
					query.append(" and ( ");
					//责任组
					query.append(" exists (select 1 from userrole ur where ur.roleid = rc.rcroleid and ur.userid = '").append(userid).append("') ");
					//或
					query.append(" or ");
					//合作组
					query.append(" exists (select 1 from userrole ur where varchar(ur.roleid) = rc.cogid and ur.userid = '").append(userid).append("') ");
					query.append(" ) ");
				}else{
					//是检查工作的负责人或者合作人
					query.append(" and (rc.rcuserid = '").append(userid).append("' or rc.ciiopid  = '").append(userid).append("')");
				}
				
				if(desc){
					query.append(" order by RCRPLANDATE DESC ");
				}else{
					query.append(" order by RCRPLANDATE ");
				}
			   
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("t",RiskCheckResultTB.class);

				setFetchPoint(q, 0, 0);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<RiskCheckResult> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("检索时间：" + (end - start)/1000 + "秒");
					log.debug("检索结果件数：" + list.size() + "件");
					log.debug("检索SQL：" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<RiskCheckResult>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(RiskCheckResultSearchCond cond, StringBuffer query, String riskCheckResultQuery){
		
//		if( !StringUtils.isEmpty(cond.getElabel())){
//			query.append(" AND ei.elabel = :elabel");
//		}	

		
	}

	public List<RiskCheckResult> sel(final RiskCheckResultSearchCondImpl cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskCheckResultDAOImpl.sel").getQueryString());
				if(StringUtils.isNotEmpty(cond.getRcclass())){
					query.append(" and rcr.rcrclass = :rcclass ");
				}
				if(cond.getRcrid()!=null && !(cond.getRcrid().equals("0"))){
					query.append(" and rcr.rcrid = :rcrid");
				}
				if(StringUtils.isNotEmpty(cond.getRcusername())){
					query.append(" and rcr.rcrusername like '%' || :rcusername || '%'");
				}
				if(StringUtils.isNotEmpty(cond.getCiiop())){
					query.append(" and rc.ciiop like '%' || :ciiop || '%'");
				}
				if(StringUtils.isNotEmpty(cond.getRcapprovetime())){
					query.append(" and rcr.rcrplandate < :rcapprovetime   and  :rcapprovetime <rc.rcenddate");
				}
				if(StringUtils.isNotEmpty(cond.getRcrplandate_from())){
					query.append(" and rcr.rcrplandate > :rcrplandate_from");
				}
				if(StringUtils.isNotEmpty(cond.getRcrplandate_to())){
					query.append(" and rcr.rcrplandate < :rcrplandate_to");
				}
				if(StringUtils.isNotEmpty(cond.getRcrrealtime_isNull())){
					query.append(" and rcr.rcrrealtime is null");
				}
				if(StringUtils.isNotEmpty(cond.getRcruserid_isNull())){
					query.append(" and (rcr.rcruserid='' or rcr.rcruserid is null)");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				setFetchPoint(q, start, count);
				q.addEntity("RiskCheckResultTB",RiskCheckResultTB.class);
				setFetchPoint(q, start, count);
				List<RiskCheckResult> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<RiskCheckResult>) execute(action);
	}
	public List<RiskCheckResult>  dbmrcrsel(String year){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskCheckResultDAOImpl.dbmsel").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				setFetchPoint(q, 0, 0);
				List<RiskCheckResult> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<RiskCheckResult>) execute(action);
	}

	public List<RiskCheckResult> getRiskCheckResult(final RiskCheckResultSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("RiskCheckResultDAOImpl.getriskcheckresult").getQueryString());
				if(StringUtils.isNotEmpty(cond.getYear())){
					query.append(" and   ");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				setFetchPoint(q, 0, 0);
				q.addEntity("t",RiskCheckTB.class);
				List<RiskCheck> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<RiskCheckResult>) execute(action);
	}
	
	/**
	 * 条件检索结果(百分比)件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCountForRate(final RiskCheckResultSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskCheckResultDAOImpl.selCountForRate").getQueryString());
				if(StringUtils.isNotEmpty(cond.getRcrplandate_from())){
					query.append(" and rcr.rcrplandate > :rcrplandate_from");
				}
				if(StringUtils.isNotEmpty(cond.getRcrplandate_to())){
					query.append(" and rcr.rcrplandate < :rcrplandate_to");
				}
				if(StringUtils.isNotEmpty(cond.getRcrrealtime_isNull())){
					query.append(" and rcr.rcrrealtime is null");
				}
				if(StringUtils.isNotEmpty(cond.getRcruserid_isNull())){
					query.append(" and (rcr.rcruserid='' or rcr.rcruserid is null)");
				}
				if(cond.getRcrid_in()!=null && cond.getRcrid_in().length>0){
					query.append(" and rcr.rcrid in (");
					for(int i=0;i<cond.getRcrid_in().length;i++){
						query.append("'");
						query.append(cond.getRcrid_in()[i]);
						query.append("'");
						if(i < cond.getRcrid_in().length-1){
							query.append(",");
						}
					}
					query.append(")");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				Integer count = getCount(q.list());
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}
}
