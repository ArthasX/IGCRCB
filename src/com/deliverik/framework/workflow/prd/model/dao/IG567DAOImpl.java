/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG567Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG567VW;


/**
 * ����:���̲�������������ͼDAOʵ��
 * ����������
 *           
 * ������¼���κ���    2010/11/26
 */
public class IG567DAOImpl extends
		BaseHibernateDAOImpl<IG567Info> implements
		IG567DAO {

	/**
	 * ���̲�����������DAO���캯��
	 * 
	 */
	public IG567DAOImpl() {
		super(IG567VW.class);
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG567Info> findByCond(final IG433SearchCond cond,final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG433DAO.searchIG433").getQueryString());
				query.append(getSearchCond(cond));
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.addEntity("IG567VW", IG567VW.class);
				setFetchPoint(q,start, count);
				List<IG567Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG567Info>) execute(action);
	}
	
	/**
	 * ���������ѯ����ƴ��sql
	 * 
	 * @param cond��������
	 * @return ƴ�Ӻõ�sql
	 */
	private String getSearchCond(IG433SearchCond cond){
		String searchSql = "";
		//���̱��
		if(cond.getPrserialnum() != null && !"".equals(cond.getPrserialnum())){
			searchSql = searchSql + " AND prserialnum  LIKE '%" + cond.getPrserialnum() + "%'";
		}
		// ��������
		if(cond.getPrtitle() != null && !"".equals(cond.getPrtitle())){
			searchSql = searchSql + " AND prtitle LIKE '%" + cond.getPrtitle() + "%'";
		}
		// ���̷�����
		if(cond.getPrusername() != null && !"".equals(cond.getPrusername())){
			searchSql = searchSql + " AND prusername LIKE '%" + cond.getPrusername() + "%'";
		}
		// ���̽����̶�
		if(cond.getPrurgency() != null && !"".equals(cond.getPrurgency())){
			searchSql = searchSql + " AND prurgency = '" + cond.getPrurgency() + "'";
		}
		// �¼���������
		if(StringUtils.isNotEmpty(cond.getPrpdid())){
			searchSql = searchSql + " AND prpdid = '" + cond.getPrpdid() + "'";
		}
		// ��������
		if(cond.getPrtype() != null && !"".equals(cond.getPrtype())){
			searchSql = searchSql + " AND pr.prtype LIKE '%" + cond.getPrtype() + "%'";
		}
		// ����״̬
		if(cond.getAssessmentstatus() != null && !"".equals(cond.getAssessmentstatus())){
			// ����
			if("1".equals(cond.getAssessmentstatus())){
				searchSql = searchSql + " AND pa.pastatus = '1' ";
			}
			// δ����
			if("0".equals(cond.getAssessmentstatus())){
				searchSql = searchSql + " AND pa.paid is null ";
			}
			// �ݸ�
			if("2".equals(cond.getAssessmentstatus())){
				searchSql = searchSql + " AND pa.pastatus = '2' ";
			}
			
		}
		// ����״̬
		if(cond.getPropentime() != null && !"".equals(cond.getPropentime())){
			searchSql = searchSql + " AND propentime >= '" + cond.getPropentime() + "'";
		}
		// ����״̬
		if(cond.getPrclosetime() != null && !"".equals(cond.getPrclosetime())){
			searchSql = searchSql + " AND propentime <= '" + cond.getPrclosetime() + "'";
		}
		
		// ����˳��
		if(StringUtils.isNotEmpty(cond.getOrder())){
			if("ASC".equals(cond.getSing())){
				
				searchSql = searchSql + " ORDER BY  " + cond.getOrder() + " asc ";
			}else{
				searchSql = searchSql + " ORDER BY  " + cond.getOrder() + " desc ";
			}
		}else{
			searchSql = searchSql + " ORDER BY prclosetime desc ";
		}
		return searchSql;
		
	}
}
