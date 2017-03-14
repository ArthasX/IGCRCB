/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.asset.model.RehearseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RehearseVW;



/**
  * ����: �Ƽ�������ر�DAOʵ��
  * ��������:  �Ƽ�������ر�DAOʵ��
  * ������¼: 2014/08/16
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class RehearseDAOImpl extends
		BaseHibernateDAOImpl<RehearseVWInfo> implements RehearseDAO {

	/**
	 * ���캯��
	 */
	public RehearseDAOImpl(){
		super(RehearseVW.class);
	}

	/**
	 * ��ȡ ����������ѡ�еı���ȷ��չ����������-���յ�+�����
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 * @return ����������ѡ�еķ��յ�&�����  -�����򻮷�(������ȹ��˵��ظ��ķ��յ�)
	 */
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> searchAssessRisk(final RehearseSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<HashMap<String, Object>> list =null;
				query.append(session.getNamedQuery("rehearsedao.risk.inspect.assess").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				q.addScalar("ename",Hibernate.STRING) ;
				q.addScalar("riskcount",Hibernate.STRING) ;
				q.addScalar("riskesyscoding",Hibernate.STRING) ;
				q.addScalar("inspectcount",Hibernate.STRING) ;
				q.addScalar("inspectesyscoding",Hibernate.STRING) ;
				
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<HashMap<String, Object>>) execute(action);
	}
	
	/**
	 * ��ȡ ����ȷ��չ���������� ���յ�+����� 
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 * @return List<HashMap<String, Object>> list ���յ�&����� ����  -�����򻮷�
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> searchRiskInfo(final RehearseSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<HashMap<String, Object>> list =null;
				//��ȡ��������sql��
				query.append(session.getNamedQuery("rehearsedao.risk.inspect").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				//������������
				q.addScalar("ename",Hibernate.STRING) ;
				//���յ�����
				q.addScalar("riskcount",Hibernate.STRING) ;
				//���յ�-esyscoding
				q.addScalar("riskesyscoding",Hibernate.STRING) ;
				//���������
				q.addScalar("inspectcount",Hibernate.STRING) ;
				//�����-esyscoding
				q.addScalar("inspectesyscoding",Hibernate.STRING) ;
				
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<HashMap<String, Object>>) execute(action);
	}
	
	/**
	 * �������� ����:�����򻮷�
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:fieldvalue prcount recount
	 * @return List<HashMap<String, Object>> list ���ظ��������������������Ϣ
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> searchIssueCorrectiveInfo(final RehearseSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<HashMap<String, Object>> list =null;
				//��ȡ��������sql��
				query.append(session.getNamedQuery("rehearsedao.issue.corrective").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				//�趨���ص�map-key
				q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				//��������
				q.addScalar("fieldvalue",Hibernate.STRING) ;
				//����������������
				q.addScalar("prcount",Hibernate.STRING) ;
				//����������������
				q.addScalar("recount",Hibernate.STRING) ;
				
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<HashMap<String, Object>>) execute(action);
	}
	/**
	 * ������������-��ϸ��Ϣby����-��ȡ��
	 * @param cond
	 * @param start
	 * @param count
	 * @return List<IG500Info> list ���ظ����������������������Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> searchIssueCorrectiveByField(final RehearseSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG500Info> list =null;
				//��ȡ��������������sql��
				query.append(session.getNamedQuery("rehearsedao.searchIssueCorrectiveByField").getQueryString());
				//��ӹ�������
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				//��sql�Ĵ��ݲ��� 
				q.setProperties(cond);
				q.addEntity(IG500TB.class);
				
				setFetchPoint(q,start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	/**
	 * sql������������
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(RehearseSearchCond cond, StringBuffer query){
		//�ƻ�״̬(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getPrstatus())){
			//��flex��Ҫ��ʾ��������ʱ
			String prstatus = cond.getPrstatus();
			if("RECTIFY".equals(prstatus)){
				//��ȡ�ѹرյ�������������
				query.append(" AND a.PRCLOSETIME !=''");
			}
		}
			
	}

}