/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0605SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0605VW;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * �ʲ�����ͼDAOʵ��
 * 
 */
public class SOC0605DAOImpl extends BaseHibernateDAOImpl<SOC0605Info> implements SOC0605DAO {

	static Log log = LogFactory.getLog(SOC0605DAOImpl.class);

	/**
	 * �ʲ�����ͼ���캯��
	 * 
	 */
	public SOC0605DAOImpl(){
		super(SOC0605VW.class);
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0605SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("SOC0605DAO.getSearchCount").getQueryString());
				
				String configItemQuery = session.getNamedQuery("SOC0605DAO.configItemQuery").getQueryString();
				
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
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0605Info> findByCond(final SOC0605SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("SOC0605DAO.findByCond").getQueryString());
				
				String configItemQuery = session.getNamedQuery("SOC0605DAO.configItemQuery").getQueryString();
				
				getSQL(cond, query, configItemQuery);
				
				query.append(" order by ei.esyscoding,ei.eilabel desc");
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",SOC0605VW.class);

				q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<SOC0605Info> list = q.list();
				
				session.clear();
				session.close();
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("����ʱ�䣺" + (end - start)/1000 + "��");
					log.debug("�������������" + list.size() + "��");
					log.debug("����SQL��" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<SOC0605Info>) execute(action);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0605Info> findSwitchByCond(final SOC0605SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("SOC0605DAO.findByCond").getQueryString());
				
				String configItemQuery = session.getNamedQuery("SOC0605DAO.configItemQuery").getQueryString();
				
				getSQL(cond, query, configItemQuery);
				
				query.append(" order by ei.esyscoding,ei.eilabel desc");
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",SOC0605VW.class);

				q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<SOC0605Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("����ʱ�䣺" + (end - start)/1000 + "��");
					log.debug("�������������" + list.size() + "��");
					log.debug("����SQL��" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<SOC0605Info>) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(SOC0605SearchCond cond, StringBuffer query, String configItemQuery){
		
	    if(StringUtils.isNotEmpty(cond.getQueryflag())){
	        query.append(" AND ECATEGORY NOT IN ('007','008')");
	    }else{
	        query.append(" AND ECATEGORY NOT IN ('007','008','014')");
	    }
		//�ʲ�ʹ�û���
		if( !StringUtils.isEmpty(cond.getUsesyscoding())){
			 query.append(" AND ei.useorgan = :usesyscoding ");
		}
		
		//�ʲ�����������
		if( !StringUtils.isEmpty(cond.getEiorgcode())){
			query.append(" AND ei.eiorgsyscoding like (:eiorgcode||'%') ");
		}
		
		//�ʲ�����������
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding()) && StringUtils.isEmpty(cond.getEistatus())){
			query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding||'%') ");
		}	
		
		//�ʲ�������ģ��
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding_q()) && !CommonDefineUtils.ENTITYITEM_STARUS_USE.equals(cond.getEistatus_q())){
			query.append(" AND ei.eiorgsyscoding like (:eiorgsyscoding_q||'%') ");
		}
		
		//�ʲ�������ģ��
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			query.append(" AND ei.esyscoding like (:esyscoding||'%') ");
		}
		//�ʲ�ģ�ͱ��
		if( !StringUtils.isEmpty(cond.getElabel())){
			query.append(" AND ei.elabel = :elabel");
		}	
		//�ʲ�ģ����
//		if( !StringUtils.isEmpty(cond.getEname())){
//			query.append(" AND ei.ename like ('%'||:ename||'%') ");
//		}	
		
		//�ʲ�ģ����
//		if( !StringUtils.isEmpty(cond.getEname())){
//			query.append(" AND ei.ename like ('%'||:ename||'%') ");
//		}	
		
		//�ʲ�����
		if( !StringUtils.isEmpty(cond.getEilabel())){
			query.append(" AND ei.eilabel = :eilabel");
		}
		//�ʲ�����
		if( !StringUtils.isEmpty(cond.getEilabel_like())){
		    query.append(" AND ei.eilabel like (:eilabel_like||'%') ");
		}
		//�ʲ�����
		if( !StringUtils.isEmpty(cond.getEiname())){
			query.append(" AND ei.einame like ('%' || :einame || '%') ");
		}
		//�ʲ�ģ�ͷ���
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
		//�ʲ�ģ��һ������
		if( !StringUtils.isEmpty(cond.getEkey1())){
			query.append(" AND ei.ekey1 = :ekey1");
		}
		//�ʲ�ģ�Ͷ�������
		if( !StringUtils.isEmpty(cond.getEkey2())){
			query.append(" AND ei.ekey2 = :ekey2");
		}*/
		//�ʲ���Ǽ���FROM
		if( !StringUtils.isEmpty(cond.getEiupdtime_from())){
			query.append(" AND ei.eiinsdate >= :eiupdtime_from");
		}
		//�ʲ���Ǽ���TO
		if( !StringUtils.isEmpty(cond.getEiupdtime_to())){
			query.append(" AND ei.eiinsdate <= :eiupdtime_to");
		}
		
		//�ʲ��ͨ�������ԣ�ֵ��������
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

		//�ʲ����������ԣ�ֵ��������
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
		
		//�ʲ����״̬
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
				//���õ���ҳ�治��ʾ�ѱ����豸
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
				//�ʲ�����������
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
		
		//�ʲ�ID����
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
		
		//ά����ʼ����
		if( !StringUtils.isEmpty(cond.getWbdate_from())){
			if("weibao".equals(cond.getWbdate_from())){
				query.append(" AND ei.wbdate is not null");
			}else{
				query.append(" AND ei.wbdate >= :wbdate_from");
				
			}
		}
		
		//ά����������
		if( !StringUtils.isEmpty(cond.getWbdate_to())){
			query.append(" AND ei.wbdate <= :wbdate_to");
		}
		
		//ģ��״̬��ͣ��=2\����=1��
		//Ĭ�ϵ���������õģ���Ҫ�����ú�ͣ�õ�ʱΪestatus��ֵ
		if( StringUtils.isEmpty(cond.getEstatus())){
			query.append(" AND ei.estatus = '1' ");
		}
		//�ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ�
		if( StringUtils.isNotEmpty(cond.getEmodeltype_eq())){
			query.append(" AND ei.emodeltype = '1' ");
		}
		if(StringUtils.isNotEmpty(cond.getEidesc_like())){
		    query.append(" AND ei.eidesc like ('%'||:eidesc_like||'%') ");
		}
		//ʹ������
		if( StringUtils.isNotEmpty(cond.getBjstatus())){
            query.append(" AND exists ( select 1 from IG800 coi where coi.cid = (select cid from ig225 c where c.CLABEL = 'IG_5012') and coi.eiid = ei.eiid and coi.civalue = :bjstatus and coi.civersion = ei.eiversion ) ");
        }
		//�������к�
        if( StringUtils.isNotEmpty(cond.getBjserialnum())){
            query.append(" AND exists ( select 1 from IG800 coi where coi.cid = (select cid from ig225 c where c.CLABEL = 'IG_5008') and coi.eiid = ei.eiid and coi.civalue = :bjserialnum and coi.civersion = ei.eiversion ) ");
        }
        //��������
        if( StringUtils.isNotEmpty(cond.getBjdesc_like())){
            query.append(" AND exists ( select 1 from IG800 coi where coi.cid = (select cid from ig225 c where c.CLABEL = 'IG_5006') and coi.eiid = ei.eiid and coi.civalue like ('%'||:bjdesc_like||'%') and coi.civersion = ei.eiversion ) ");
        }
        //�������ж�
        if(!StringUtils.isEmpty(cond.getFlagFWS())){
			query.append("AND EI.EIID IN (SELECT A.EIID FROM IG013 A,IG800 B,IG225 C WHERE A.EIID = B.EIID AND A.EIVERSION = B.CIVERSION AND C.CID = B.CID AND C.CLABEL = '");
			query.append(EntityItemKeyWords.CLABEL_ISMYSERVICE);
			query.append("' AND B.CIVALUE = '��')");
		}
		if(StringUtils.isNotEmpty(cond.getEiorgsyscoding_in())){
        	query.append(" AND ei.eiorgsyscoding in ('").append(cond.getEiorgsyscoding_in()).append("')");
        }
	}
}
