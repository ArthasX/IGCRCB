package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0124VW;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * ����2��??������?DAO����??
 * 
 */
public class SOC0124DAOImpl extends BaseHibernateDAOImpl<SOC0124Info> implements SOC0124DAO {

	static Log log = LogFactory.getLog(SOC0124DAOImpl.class);

	/**
	 * ����2��??������?11?��o����y
	 * 
	 */
	public SOC0124DAOImpl(){
		super(SOC0124VW.class);
	}

	/**
	 * ��??t?��?��?��1??t��y��?��?
	 * @param cond ?��?�¨�??t
	 * @return ?��?��?��1??t��y
	 */
	public int getSearchCount(final SOC0124SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EntityItemVWDAO.getSearchCount").getQueryString());
				
				String configItemQuery = session.getNamedQuery("EntityItemVWDAO.configItemQuery").getQueryString();
				
				getSQL(cond, query, configItemQuery);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);

				session.clear();

				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}


	/**
	 * ��??t?��?�¡�|����
	 * @param cond ?��?�¨�??t
	 * @param start ?��?��?????e��?DDo?
	 * @param count ?��?��?????t��y
	 * @return ?��?��?��1?��D����
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0124Info> findByCond(final SOC0124SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EntityItemVWDAO.findByCond").getQueryString());
				
				String configItemQuery = session.getNamedQuery("EntityItemVWDAO.configItemQuery").getQueryString();
				
				getSQL(cond, query, configItemQuery);
				
				query.append(" order by ei.esyscoding,ei.eilabel");
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",SOC0124VW.class);

				q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<SOC0124Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?��?�¨���??��o" + (end - start)/1000 + "??");
					log.debug("?��?��?��1??t��y��o" + list.size() + "?t");
					log.debug("?��?��SQL��o" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<SOC0124Info>) execute(action);
	}
	
	/**
	 * ��??t?��?�¡�|����
	 * @param cond ?��?�¨�??t
	 * @param start ?��?��?????e��?DDo?
	 * @param count ?��?��?????t��y
	 * @return ?��?��?��1?��D����
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0124Info> findSwitchByCond(final SOC0124SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EntityItemVWDAO.findByCond").getQueryString());
				
				String configItemQuery = session.getNamedQuery("EntityItemVWDAO.configItemQuery").getQueryString();
				
				getSQL(cond, query, configItemQuery);
				
				query.append(" order by ei.esyscoding,ei.eilabel");
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",SOC0124VW.class);

				q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<SOC0124Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?��?�¨���??��o" + (end - start)/1000 + "??");
					log.debug("?��?��?��1??t��y��o" + list.size() + "?t");
					log.debug("?��?��SQL��o" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<SOC0124Info>) execute(action);
	}

	/**
	 * ?��?�¨�??t����3��
	 * 
	 * @param cond ?��?�¨�??t
	 * @return ?��?�¨�??��?�¨�??t����
	 */
	protected void getSQL(SOC0124SearchCond cond, StringBuffer query, String configItemQuery){
		if(cond instanceof SOC0124SearchCondImpl){
		    SOC0124SearchCondImpl form= (SOC0124SearchCondImpl) cond;
		    String flag=form.getModifyflag();
		    if(StringUtils.isNotEmpty(flag)&&"true".equals(flag)){
                query.append(" AND EXISTS(");
                query.append("        SELECT A.EIID FROM SOC0118 A");
                query.append("       LEFT JOIN SOC0107 B ON A.EIID =B.EIID AND A.EIVERSION =B.CIVERSION AND A.EISMALLVERSION=B.CISMALLVERSION AND B.CID='CI010000001019'");
                query.append("       LEFT JOIN SOC0107 C ON A.EIID =C.EIID AND A.EIVERSION =C.CIVERSION AND A.EISMALLVERSION=C.CISMALLVERSION AND C.CID='CI010000001004'");
                query.append(" WHERE A.EIID =ei.eiid AND (C.CIVALUE  <> '已出库' OR C.CIVALUE IS NULL)AND (B.CIVALUE <> '待出库' OR B.CIVALUE IS NULL) AND (B.CIVALUE <> '变更锁定' OR B.CIVALUE IS NULL)) ");
		    }
		    //应急管理用：组合场景编辑器选单一场景
		    if(StringUtils.isNotEmpty(flag)&&"999060".equals(flag)){
				//应急场景查询，过滤组合场景
				query.append(" and eiid in (select eiid from soc0107 where cid = 'CI600000001008' and civalue = '0')");
				
		    }
		}
		
		//����2����1��??��11
		if( !StringUtils.isEmpty(cond.getUsesyscoding())){
			 query.append(" AND ei.useorgan = :usesyscoding ");
		}
		
		//����2��???����??��11
		if( !StringUtils.isEmpty(cond.getEiorgcode())){
			query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding||'%') ");
		}
		
		//����2��???����??��11
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding()) && StringUtils.isEmpty(cond.getEistatus())){
			query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding||'%') ");
		}	
		
		//����2��???����??��D��
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding_q()) && !CommonDefineUtils.ENTITYITEM_STARUS_USE.equals(cond.getEistatus_q())){
			query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding_q||'%') ");
		}
		
		//����2��???����??��D��
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			//ORACLE,WEBLOGIC,Tuxedo,Jboss Server��??��??2��?��
			if (cond.getEsyscoding().startsWith(CommonDefineUtils.ORACLE_ESYSCODING) ||
					cond.getEsyscoding().startsWith(CommonDefineUtils.WEBLOGIC_ESYSCODING) ||
					cond.getEsyscoding().startsWith(CommonDefineUtils.Tuxedo_ESYSCODING) ||
					cond.getEsyscoding().startsWith(CommonDefineUtils.Jboss_Server_ESYSCODING)||
					cond.getEsyscoding().startsWith("999001029002")) {
				query.append(" AND ei.esyscoding = :esyscoding ");
			} 
			//????����2��?��oy?��??
			else {
				query.append(" AND ei.esyscoding like (:esyscoding||'%') ");
			}
		}
		//����2��?��D������o?
		if( !StringUtils.isEmpty(cond.getElabel())){
			query.append(" AND ei.elabel = :elabel");
		}	
		//����2��?��D��??
//		if( !StringUtils.isEmpty(cond.getEname())){
//			query.append(" AND ei.ename like ('%'||:ename||'%') ");
//		}	
		
		//����2��?��D��??
//		if( !StringUtils.isEmpty(cond.getEname())){
//			query.append(" AND ei.ename like ('%'||:ename||'%') ");
//		}	
		
		//����2��??����o?
		if( !StringUtils.isEmpty(cond.getEilabel())){
			query.append(" AND ei.eilabel = :eilabel");
		}
		//����2��????
		if( !StringUtils.isEmpty(cond.getEiname())){
			query.append(" AND ei.einame like ('%' || :einame || '%') ");
		}
		//����2��?����????����?
		if( cond.getEirootmark_eq()!=null&&cond.getEirootmark_eq()!=0){
			query.append(" AND ei.eirootmark = :eirootmark_eq");
		}
		//����2��?��D����?����
		if( !StringUtils.isEmpty(cond.getEcategory())){
			if("SVR".equals(cond.getEcategory())){
				query.append(" AND ei.ecategory != '" + CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD + "' AND ei.ecategory != '" + 
						CommonDefineUtils.ENTIY_CATEGORY_SERVICE + "' AND ei.ecategory != '" + CommonDefineUtils.ENTIY_CATEGORY_MODULE + "' ");
			}else if("SDL".equals(cond.getEcategory())){
				query.append(" AND ei.eiid IN (SELECT distinct sdieiid FROM SdlDefineInfo) ");
			}else{
				query.append(" AND ei.ecategory = :ecategory");
			}
		}
		/*
		//����2��?��D����???��������
		if( !StringUtils.isEmpty(cond.getEkey1())){
			query.append(" AND ei.ekey1 = :ekey1");
		}
		//����2��?��D��?t??��������
		if( !StringUtils.isEmpty(cond.getEkey2())){
			query.append(" AND ei.ekey2 = :ekey2");
		}*/
		//����2��??��???��?FROM
		if( !StringUtils.isEmpty(cond.getEiupdtime_from())){
			query.append(" AND ei.eiupdtime >= :eiupdtime_from");
		}
		//����2��??��???��?TO
		if( !StringUtils.isEmpty(cond.getEiupdtime_to())){
			query.append(" AND ei.eiupdtime <= '" + cond.getEiupdtime_to() + " 23:59'");
		}
		//��?o��?��D?��??��
		//FROM
		if( !StringUtils.isEmpty(cond.getEiupdtime_from2())){
			query.append(" AND ei.eiupdtime >= :eiupdtime_from2");
		}
		//����2��??��???��?TO
		if( !StringUtils.isEmpty(cond.getEiupdtime_to2())){
			query.append(" AND ei.eiupdtime <= :eiupdtime_to2");
		}
		
		if(StringUtils.isNotEmpty(cond.getIp())){
			query.append(" AND ei.einame like '%"+cond.getIp()+"%'");
		}
		
		//����2��??12����????��?D?��??��?��?�¨�??t
		if ( cond.getCclabel() != null ) {
			for (int i=0;i<cond.getCclabel().length;i++) {
				if (StringUtils.isNotEmpty(cond.getCclabel()[i])) {
					StringBuffer inSQL = new StringBuffer();
					inSQL.append(configItemQuery);
					inSQL.append(" AND C.CLABEL = '" + cond.getCclabel()[i] + "'");
					
					if (StringUtils.isNotEmpty(cond.getCcivalue()[i])) {
						inSQL.append(" AND B.CIVALUE LIKE '%" + cond.getCcivalue()[i] + "%'");
					}
					
					query.append(" AND EI.EIID IN ( ");
					query.append(inSQL.toString());
					query.append(")");
				}
			}
		}

		//����2��??????��?D?��??��?��?�¨�??t
		if ( cond.getCname() != null ) {
			for (int i=0;i<cond.getCname().length;i++) {
				if (StringUtils.isNotEmpty(cond.getCname()[i])) {
					StringBuffer inSQL = new StringBuffer();
					inSQL.append(configItemQuery);
					inSQL.append(" AND C.CNAME LIKE '%" + cond.getCname()[i] + "%'");
					
					if (StringUtils.isNotEmpty(cond.getCivalue()[i])) {
						inSQL.append(" AND B.CIVALUE LIKE '%" + cond.getCivalue()[i] + "%'");
					}
					
					query.append(" AND EI.EIID IN ( ");
					query.append(inSQL.toString());
					query.append(")");
				}
			}
		}
		
		//����2��??��?���䨬?
		if( !StringUtils.isEmpty(cond.getEistatus())){
			if("ISNULL".equals(cond.getEistatus())){
				query.append(" AND ei.eistatus is null ");
			}else if(cond.getEistatus().split("_").length>1){
				query.append(" AND ei.eistatus in (");
				for(int i=0,j=cond.getEistatus().split("_").length;i<j;i++){
					if(i>0)
						query.append(",");
					
					query.append("'"+cond.getEistatus().split("_")[i]+"'");
				}			
				query.append(")");
			}else{
				//1?��?�̡�3?��3??2???��?��?������?������?
				if("0".equals(cond.getEistatus())){
					query.append(" AND (ei.eistatus != '" + CommonDefineUtils.ENTITYITEM_STARUS_SCRAP + "' or ei.eistatus is NULL or ei.eistatus = '') ");
				}else{
					query.append(" AND ei.eistatus = '"+cond.getEistatus().split("_")[0]+"'");
				}
				
			}
			
			if(CommonDefineUtils.ENTITYITEM_STARUS_USE.equals(cond.getEistatus())){
				if(!StringUtils.isEmpty(cond.getEiorgsyscoding())){
					query.append(" and ei.EIID IN ( select A.EIID from entityitem A, CONFIGITEM B, CONFIGURATION C  where A.EIID = B.EIID");
					query.append(" and A.EIVERSION = B.CIVERSION");
					query.append(" and C.CID = B.CID AND C.CLABEL = '");
					query.append(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE);
					query.append("' AND B.CIVALUE LIKE '");
					query.append(cond.getEiorgsyscoding());
					query.append("%')");
				}
			}else{
				//����2��???����??��11
				if( !StringUtils.isEmpty(cond.getEiorgsyscoding())){
					query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding||'%') ");
				}	
			}
			
		}	
		
		if( !StringUtils.isEmpty(cond.getEistatus_q()) && CommonDefineUtils.ENTITYITEM_STARUS_USE.equals(cond.getEistatus_q())){
			query.append(" and ei.EIID IN ( select A.EIID from entityitem A, CONFIGITEM B, CONFIGURATION C  where A.EIID = B.EIID");
			query.append(" and A.EIVERSION = B.CIVERSION");
			query.append(" and C.CID = B.CID AND C.CLABEL = '");
			query.append(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE);
			query.append("' and A.eistatus='");
			query.append(cond.getEistatus_q());
			query.append("'");
			if(!StringUtils.isEmpty(cond.getEiorgsyscoding_q())){
				query.append(" AND B.CIVALUE LIKE '");
				query.append(cond.getEiorgsyscoding_q());
				query.append("%'");
			}
			query.append(")");
		}
		
		//����2��ID?��o?
		if( cond.getEiidList() != null && cond.getEiidList().size() > 0){
			query.append(" AND ei.eiid in(");
			int i = 0;
			int length = cond.getEiidList().size();
			for(String eiid : cond.getEiidList()){
				query.append(eiid);
				if((++i) != length) {
					query.append(",");
					
				}
			}
			query.append(")");
		}
		//�ʲ�ID����not in
		if( cond.getEiidNotInList() != null && cond.getEiidNotInList().size() > 0){
			query.append(" AND ei.eiid not in(");
			int i = 0;
			int length = cond.getEiidNotInList().size();
			for(String eiid : cond.getEiidNotInList()){
				query.append(eiid);
				if((++i) != length) {
					query.append(",");
					
				}
			}
			query.append(")");
		}
		
		//??����?a��?��??��
		if( !StringUtils.isEmpty(cond.getWbdate_from())){
			if("weibao".equals(cond.getWbdate_from())){
				query.append(" AND ei.wbdate <>''");
			}else{
				query.append(" AND ei.wbdate >= :wbdate_from");
				
			}
		}
		//??����?����?��??��
		if( !StringUtils.isEmpty(cond.getWbdate_to())){
			query.append(" AND ei.wbdate <= :wbdate_to");
		}
		
		if(cond.isTopCiFlag()){
			query.append(" AND ei.eiid=ei.eirootmark");
		}
//		if(!StringUtils.isEmpty(cond.getEid())){
//			query.append(" AND ei.eid="+cond.getEid());
//		}
	}
	
}
