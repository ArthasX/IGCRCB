/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.model.PortRelationInfo;
import com.deliverik.infogovernor.soc.model.condition.PortRelationSearchCond;
import com.deliverik.infogovernor.soc.model.entity.PortRelationTB;

/**
  * 概述: 端到端关系表DAO实现
  * 功能描述: 端到端关系表DAO实现
  * 创建记录: 2013/01/17
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class PortRelationDAOImpl extends
		BaseHibernateDAOImpl<PortRelationInfo> implements PortRelationDAO {

	/**
	 * 构造函数
	 */
	public PortRelationDAOImpl(){
		super(PortRelationTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PortRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PortRelationInfo findByPK(Serializable pk) {
		PortRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PortRelationSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
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
	public List<String> findByCondStr(final PortRelationSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
								
				query.append("select a.eiName from SOC0118 a LEFT OUTER JOIN (select distinct devicesname from portrelation where  symmetrixid='"+cond.getSymmetrixid()+"') b on a.eiName=b.devicesname where b.devicesname is null and a.eid='CM01020014' and a.eirootmark="+cond.getEiid());
				
				SQLQuery q = session.createSQLQuery(query.toString());

				List<String> list = q.list();
				
				session.clear();
				
				
				return list;
			}
		};
		return (List<String>) execute(action);
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
	public List<String> findByCondBuss(final PortRelationSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();

				//query.append(session.getNamedQuery("PortRelationDAO.BussfindQuery").getQueryString());
				query.append("SELECT a.einame||'#'||a.eiid FROM SOC0118 a JOIN (SELECT distinct einame ");
				query.append("FROM SOC0114 where linkid in (SELECT linkid FROM SOC0114 b ");
				query.append("where b.eiid="+cond.getEiid()+")) c ON a.einame=c.einame where a.eid='CM03010001' ");
				
				if(!"".equals(cond.getEiname()))
					query.append("and a.einame like '%"+cond.getEiname()+"%'");
				//处理点击查询链路
				if(!"".equals(cond.getTempid())){
					query.append("and a.eiid in(SELECT distinct a.eiid FROM SOC0114 a join(select linkid from SOC0114 where eiid in("+cond.getTempid()+")) b on a.linkid=b.linkid where a.esyscoding='999003001')");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);
				
				List<String> list = q.list();
				
				session.clear();
				
				
				return list;
			}
		};
		return (List<String>) execute(action);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> findByCondHost(final PortRelationSearchCond cond, int start,
			int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				if(cond.getStyle().equals("hyper")){
				    query.append("select distinct eirootmark from SOC0118 where eilabel in(select  hbaport_wwn from portrelation where devicesname ='"+cond.getTempid()+"')");
				}
				else{
				//分段查询不同数据段
				if(!cond.isFlag()){
					query.append("SELECT c.eiid FROM SOC0118 c  JOIN (SELECT distinct eiid FROM SOC0114 ");
					query.append("b WHERE b.eiid in (SELECT a.eirootmark FROM SOC0118 a WHERE a.eid='CM01010003' ");
					query.append("and a.eilabel='"+cond.getWwn()+"' )) d on c.eiid = d.eiid ");
				}else{
						if(cond.getStyle().equals("Zj")){
							query.append("SELECT einame FROM  SOC0118 WHERE eiid="+cond.getEiid());
						}else if(cond.getStyle().equals("Hba")){
							query.append("SELECT einame||'#'||eiid FROM SOC0118 WHERE eirootmark="+cond.getEiid()+" and eid='CM01010002' ");
						}else if(cond.getStyle().equals("HbaCol")){
							query.append("SELECT eiid FROM SOC0118 WHERE eirootmark="+cond.getEiid()+" and eid='CM01010002' ");
							if(!"".equals(cond.getTempid()) && cond.getTempid()!=null){
								query.append("and eiid in(SELECT distinct a.eiid FROM SOC0114 a join(select linkid from SOC0114 where eiid in("+cond.getTempid()+")) b on a.linkid=b.linkid where a.esyscoding='999001002')");
							}
						}else if(cond.getStyle().equals("PortCol")){
							query.append("SELECT eiid FROM SOC0118 a join (");
							query.append("select BRCLDEIID from SOC0127 where brassetrelation ='CR010100020001' and  brpareiid="+cond.getBrpareiid()+") b ");
							query.append("on a.eiid =b.BRCLDEIID where a.eirootmark="+cond.getEiid()+" and a.eid='CM01010003' ");
							if(!"".equals(cond.getTempid()) && cond.getTempid()!=null){
								query.append("and a.eiid in(SELECT distinct a.eiid FROM SOC0114 a join(select linkid from SOC0114 where eiid in("+cond.getTempid()+")) b on a.linkid=b.linkid where a.esyscoding='999001003')");
							}
						}else if(cond.getStyle().equals("HbaPort")){
							query.append("SELECT einame||'#'||eiid||'#'||eilabel FROM SOC0118 a join (");
							query.append("select BRCLDEIID from SOC0110 where brassetrelation ='CR010100020001' and  brpareiid="+cond.getBrpareiid()+") b ");
							query.append("on a.eiid =b.BRCLDEIID where a.eirootmark="+cond.getEiid()+" and a.eid='CM01010003' ");
						}else if(cond.getStyle().equals("Nnknow")){
							query.append("select eilabel from SOC0118 a where a.eid='CM01010003' and a.eilabel='"+cond.getWwn()+"'");	
						}else if(cond.getStyle().equals("getEiid")){
							query.append("SELECT a.eiid FROM SOC0118 a JOIN (SELECT distinct eiid FROM SOC0114 where ");
							query.append("linkid in(SELECT linkid FROM SOC0114 b where b.eiid="+cond.getEiid()+")) c ON a.eiid=c.eiid ");
							query.append("where a.eid in('CM01010022','CM01010020','CM01010031')");
							if(!"".equals(cond.getEiname()))
								query.append("and a.einame like '%"+cond.getHba()+"%'");
							//处理点击查询链路 
							if(!"".equals(cond.getTempid()) && cond.getTempid()!=null){
								query.append("and a.eiid in(SELECT distinct a.eiid FROM SOC0114 a join(select linkid from SOC0114 where eiid in("+cond.getTempid()+")) b on a.linkid=b.linkid where a.esyscoding='999001001001')");
							}
							
						}
					}
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);
				
				List<String> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<String>) execute(action);	
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
	public List<String> findByCondSwitch(final PortRelationSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				if(cond.getStyle().equals("Fa")){
					
					query.append("SELECT a.einame||'#'||a.eiid FROM SOC0118 a JOIN (SELECT distinct eiid FROM SOC0114 where ");
					query.append("linkid in(SELECT linkid FROM SOC0114 b where b.eiid="+cond.getEiid()+")) c ON a.eiid=c.eiid ");
					//处理点击查询链路 
					if(!"".equals(cond.getTempid()))
						query.append("where a.eirootmark="+cond.getEiid()+" and a.eiid in(SELECT distinct a.eiid FROM SOC0114 a join(select linkid from SOC0114 where eiid in("+cond.getTempid()+")) b on a.linkid=b.linkid where a.esyscoding='999001008')");
					else
						query.append("where a.esyscoding='999001008'");
					
					
				}else{
					query.append("SELECT a.einame||'#'||a.eiid FROM SOC0118 a JOIN (SELECT distinct eiid FROM SOC0114 where ");
					query.append("linkid in(SELECT linkid FROM SOC0114 b where b.eiid="+cond.getEiid()+")) c ON a.eiid=c.eiid ");
					query.append("where a.eid in('CM01010021','CM01010029','CM01010030')");
					if(!"".equals(cond.getEiname()))
						query.append("and a.einame like '%"+cond.getEiname()+"%'");
					//处理点击查询链路 
					if(!"".equals(cond.getTempid()))
						query.append("and a.eiid in(SELECT distinct a.eiid FROM SOC0114 a join(select linkid from SOC0114 where eiid in("+cond.getTempid()+")) b on a.linkid=b.linkid where a.esyscoding in('999001006001','999001006002'))");
				}
				
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);
				
				List<String> list = q.list();
				
				session.clear();
				
				
				return list;
			}
		};
		return (List<String>) execute(action);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> findByCondFa(final PortRelationSearchCond cond, int start,
			int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				if(cond.getStyle().equals("Fa")){
					query.append("select einame||'#'||eiid from SOC0118 where eirootmark="+cond.getEiid()+" and eid='CM01010010'");
				}else if(cond.getStyle().equals("Fa_p")){		
					query.append("SELECT c.einame||'#'||c.eiid FROM SOC0118 c join SOC0110 d on d.brpareiid=c.eiid where  c.eid='CM01010011'  and d.brcldeiid="+cond.getEiid());
				} else if(cond.getStyle().equals("faColor")){		
					query.append("select eiid from SOC0118 where einame in(select faname from portrelation where symmetrixid =(SELECT einame FROM SOC0118 where eiid="+cond.getEiid()+") and devicesname='"+cond.getTempid()+"') and eirootmark="+cond.getEiid()+"");
				} else if(cond.getStyle().equals("fapColor")){		
					query.append("select a.eiid from (select e.eiid,split_part(split_part(e.einame, ')', 1), '(', 2) einame from SOC0118 e where e.eirootmark="+cond.getEiid()+" and eid='CM01010011' ) a join "
							+"(select faportname from portrelation where symmetrixid =(SELECT einame FROM SOC0118 where eiid="+cond.getEiid()+") and devicesname='"+cond.getTempid()+"') b on a.einame=b.faportname");
				} 
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);
				
				List<String> list = q.list();
				
				session.clear();
				
				
				return list;
			}
		};
		return (List<String>) execute(action);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> findByCondHyper(final PortRelationSearchCond cond, int start,
			int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				String type ="";
				if(cond.getStyle().equals("mate") || cond.getStyle().equals("Meta Head"))
					type="1";
				else
					type="3";
				StringBuffer query = new StringBuffer();
				if(cond.getWwn()!=null &&cond.getWwn().equals("SearchEid")){
					   query.append("select eid from SOC0118 where eiid="+cond.getTempid());
				}
				else if(cond.getWwn()!=null && cond.getWwn().equals("getPort")){
					   query.append("select distinct devicesname from portrelation c join (select eilabel from SOC0118  where eiid in("+cond.getTempid()+")) d on ");
					   query.append("c.hbaport_wwn=d.eilabel where c.hypertype='"+type+"' and c.symmetrixid='"+cond.getSymmetrixid().split(":")[1]+"' order by devicesname");
				}else if(cond.getWwn()!=null && cond.getWwn().equals("getHba")){
					   query.append("select distinct devicesname from portrelation c join (select eilabel from SOC0118  where eiid in(select brcldeiid from SOC0110 where brpareiid="+cond.getTempid()+")) d on ");
					   query.append("c.hbaport_wwn=d.eilabel where c.hypertype='"+type+"' and c.symmetrixid='"+cond.getSymmetrixid().split(":")[1]+"' order by devicesname");
				}else{
				   if("".equals(cond.getTempid()) || "0".equals(cond.getTempid())){
					    query.append("select distinct devicesname from portrelation ");
					    query.append("where hypertype='"+type+"' and symmetrixid='"+cond.getSymmetrixid().split(":")[1]+"' ");
						if(!"".equals(cond.getEiname()))
							query.append("and devicesname='"+cond.getEiname()+"'" );
						query.append("order by devicesname");
				   }else{
					   query.append("select distinct c.devicesname from portrelation c join ");
					   query.append("(SELECT distinct split_part(split_part(a.einame, ')', 1), '(', 2) einame FROM ");
					   query.append("SOC0114 a join(select linkid from SOC0114 where eiid in("+cond.getTempid()+")) b on a.linkid=b.linkid where a.esyscoding='999001011' ) d ");
					   query.append("on c.faportname=d.einame where c.hypertype='"+type+"' and c.symmetrixid='"+cond.getSymmetrixid().split(":")[1]+"' order by c.devicesname");
				   }
				   }
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);
				
				List<String> list = q.list();
				
				session.clear();
				
				
				return list;
			}
		};
		return (List<String>) execute(action);
	}
	/**
	 * 条件检索处理
	 *
	 * @return 检索结果列表
	 */
	public List<String> getHypeEiid(final String eiid,final String einame) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
			    query.append("select distinct eiid from SOC0114 where einame in(select  faname from portrelation where devicesname ='"+einame+"')and linkid in(select linkid from SOC0114 where eiid="+eiid+")");

				SQLQuery q = session.createSQLQuery(query.toString());
				
				List<String> list = q.list();
				
				session.clear();
				
				
				return list;
			}
		};
		return (List<String>) execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(PortRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if( !StringUtils.isEmpty(cond.getSymmetrixid())){
			c.add(Expression.eq("SymmetrixID", cond.getSymmetrixid()));
		}
		if( !StringUtils.isEmpty(cond.getWwn())){
			c.add(Expression.eq("HBAPort_WWN", cond.getWwn()));
		}
		return c;
	}

	public List<PortRelationInfo> findByCond(PortRelationSearchCond cond,
			int start, int count) {
		DetachedCriteria c = getCriteria(cond);
		List<PortRelationInfo> pri = findByCriteria(c, start, count);	
		return pri;
	}
}