package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.asset.model.entity.IG688VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * 资产项视图DAO实现
 * 
 */
public class IG688DAOImpl extends BaseHibernateDAOImpl<IG688Info> implements IG688DAO {

	static Log log = LogFactory.getLog(IG688DAOImpl.class);

	/**
	 * 资产项视图构造函数
	 * 
	 */
	public IG688DAOImpl(){
		super(IG688VW.class);
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG688SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG688DAO.getSearchCount").getQueryString());
				
				String configItemQuery = session.getNamedQuery("IG688DAO.configItemQuery").getQueryString();
				
				getSQL(cond, query, configItemQuery);
				
				SQLQuery q = session.createSQLQuery(query.toString());

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
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG688Info> findByCond(final IG688SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG688DAO.findByCond").getQueryString());
				
				String configItemQuery = session.getNamedQuery("IG688DAO.configItemQuery").getQueryString();
				
				getSQL(cond, query, configItemQuery);
				
				query.append(" order by ei.esyscoding,ei.eilabel desc");
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",IG688VW.class);

				q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG688Info> list = q.list();
				
				session.clear();
				session.close();
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
		return (List<IG688Info>) execute(action);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG688Info> findSwitchByCond(final IG688SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG688DAO.findByCond").getQueryString());
				
				String configItemQuery = session.getNamedQuery("IG688DAO.configItemQuery").getQueryString();
				
				getSQL(cond, query, configItemQuery);
				
				query.append(" order by ei.esyscoding,ei.eilabel desc");
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",IG688VW.class);

				q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG688Info> list = q.list();
				
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
		return (List<IG688Info>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(IG688SearchCond cond, StringBuffer query, String configItemQuery){
		
	    if(StringUtils.isNotEmpty(cond.getQueryflag())){
	        query.append(" AND ECATEGORY NOT IN ('007','008')");
	    }else{
	        query.append(" AND ECATEGORY NOT IN ('007','008','014')");
	    }
		//资产使用机构
		if( !StringUtils.isEmpty(cond.getUsesyscoding())){
			 query.append(" AND ei.useorgan = :usesyscoding ");
		}
		
		//资产项所属机构
		if( !StringUtils.isEmpty(cond.getEiorgcode())){
			query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding||'%') ");
		}
		
		//资产项所属机构
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding()) && StringUtils.isEmpty(cond.getEistatus())){
			query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding||'%') ");
		}	
		
		//资产项所属模型
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding_q()) && !CommonDefineUtils.ENTITYITEM_STARUS_USE.equals(cond.getEistatus_q())){
			query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding_q||'%') ");
		}
		
		//资产项所属模型
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			query.append(" AND ei.esyscoding like (:esyscoding||'%') ");
		}
		//资产模型编号
		if( !StringUtils.isEmpty(cond.getElabel())){
			query.append(" AND ei.elabel = :elabel");
		}	
		//资产模型名
//		if( !StringUtils.isEmpty(cond.getEname())){
//			query.append(" AND ei.ename like ('%'||:ename||'%') ");
//		}	
		
		//资产模型名
//		if( !StringUtils.isEmpty(cond.getEname())){
//			query.append(" AND ei.ename like ('%'||:ename||'%') ");
//		}	
		
		//资产项编号
		if( !StringUtils.isEmpty(cond.getEilabel())){
			query.append(" AND ei.eilabel = :eilabel");
		}
		//资产项名
		if( !StringUtils.isEmpty(cond.getEiname())){
			query.append(" AND ei.einame like ('%' || :einame || '%') ");
		}
		//资产模型分类
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
		//资产模型一级子类
		if( !StringUtils.isEmpty(cond.getEkey1())){
			query.append(" AND ei.ekey1 = :ekey1");
		}
		//资产模型二级子类
		if( !StringUtils.isEmpty(cond.getEkey2())){
			query.append(" AND ei.ekey2 = :ekey2");
		}*/
		//资产项登记日FROM
		if( !StringUtils.isEmpty(cond.getEiupdtime_from())){
			query.append(" AND ei.eiinsdate >= :eiupdtime_from");
		}
		//资产项登记日TO
		if( !StringUtils.isEmpty(cond.getEiupdtime_to())){
			query.append(" AND ei.eiinsdate <= :eiupdtime_to");
		}
		
		//资产项共通配置属性，值检索条件
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

		//资产项配置属性，值检索条件
		if ( cond.getCname() != null ) {
			for (int i=0;i<cond.getCname().length;i++) {
				if (StringUtils.isNotEmpty(cond.getCname()[i]) && StringUtils.isNotEmpty(cond.getCivalue()[i])) {
					StringBuffer inSQL = new StringBuffer();
					inSQL.append(configItemQuery);
					inSQL.append(" AND C.CNAME LIKE '%" + cond.getCname()[i] + "%'");
					
//					if (StringUtils.isNotEmpty(cond.getCivalue()[i])) {
					inSQL.append(" AND B.CIVALUE LIKE '%" + cond.getCivalue()[i] + "%'");
//					}
					
					query.append(" AND EI.EIID IN ( ");
					query.append(inSQL.toString());
					query.append(")");
				}
			}
		}
		
		//资产项的状态
		if( !StringUtils.isEmpty(cond.getEistatus())){
			
			if(cond.getEistatus().split("_").length>1){
				query.append(" AND ei.eistatus in (");
				for(int i=0,j=cond.getEistatus().split("_").length;i<j;i++){
					if(i>0)
						query.append(",");
					
					query.append("'"+cond.getEistatus().split("_")[i]+"'");
				}			
				query.append(")");
			}else{
				//公用弹出页面不显示已报废设备
				if("0".equals(cond.getEistatus())){
					query.append(" AND (ei.eistatus != '" + CommonDefineUtils.ENTITYITEM_STARUS_SCRAP + "' or ei.eistatus is NULL or ei.eistatus = '') ");
				}else{
					query.append(" AND ei.eistatus = '"+cond.getEistatus().split("_")[0]+"'");
				}
				
			}
			
			if(CommonDefineUtils.ENTITYITEM_STARUS_USE.equals(cond.getEistatus())){
				if(!StringUtils.isEmpty(cond.getEiorgsyscoding())){
					query.append(" and ei.EIID IN ( select A.EIID from IG013 A, IG800 B, IG225 C  where A.EIID = B.EIID");
					query.append(" and A.EIVERSION = B.CIVERSION");
					query.append(" and C.CID = B.CID AND C.CLABEL = '");
					query.append(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE);
					query.append("' AND B.CIVALUE LIKE '");
					query.append(cond.getEiorgsyscoding());
					query.append("%')");
				}
			}else{
				//资产项所属机构
				if( !StringUtils.isEmpty(cond.getEiorgsyscoding())){
					query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding||'%') ");
				}	
			}
			
		}	
		
		if( !StringUtils.isEmpty(cond.getEistatus_q()) && CommonDefineUtils.ENTITYITEM_STARUS_USE.equals(cond.getEistatus_q())){
			query.append(" and ei.EIID IN ( select A.EIID from IG013 A, IG800 B, IG225 C  where A.EIID = B.EIID");
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
		
		//资产ID集合
		if( cond.getEiidList() != null && cond.getEiidList().size() > 0){
			query.append(" AND ei.eiid in(");
			int i = 0;
			int length = cond.getEiidList().size();
			for(String eiid : cond.getEiidList()){
				query.append(eiid.split("_")[1]);
				if((++i) != length) {
					query.append(",");
					
				}
			}
			query.append(")");
		}
		
		//维保开始日期
		if( !StringUtils.isEmpty(cond.getWbdate_from())){
			if("weibao".equals(cond.getWbdate_from())){
				query.append(" AND ei.wbdate is not null");
			}else{
				query.append(" AND ei.wbdate >= :wbdate_from");
				
			}
		}
		
		//维保结束日期
		if( !StringUtils.isEmpty(cond.getWbdate_to())){
			query.append(" AND ei.wbdate <= :wbdate_to");
		}
		
		//模型状态（停用=2\启用=1）
		//默认的情况查启用的，需要查启用和停用的时为estatus设值
		if( StringUtils.isEmpty(cond.getEstatus())){
			query.append(" AND ei.estatus = '1' ");
		}
		//资产模型类别（0：一般资产模型 1：配置资产模型）
		if( StringUtils.isNotEmpty(cond.getEmodeltype_eq())){
			query.append(" AND ei.emodeltype = '1' ");
		}
		if(StringUtils.isNotEmpty(cond.getEidesc_like())){
		    query.append(" AND ei.eidesc like ('%'||:eidesc_like||'%') ");
		}
	}
	
}
