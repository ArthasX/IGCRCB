/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;
import com.deliverik.infogovernor.sta.model.condition.ProcessRecordSummarySearchCond;
import com.deliverik.infogovernor.sta.model.entity.ProcessRecordSummaryVW;

/**
 * �������ͳ��DAOʵ��
 */
public class ProcessRecordSummaryVWDAOImpl extends BaseHibernateDAOImpl<ProcessRecordSummary> implements ProcessRecordSummaryVWDAO {
	/**
	 * ���캯��
	 */
	public ProcessRecordSummaryVWDAOImpl(){
		super(ProcessRecordSummaryVW.class);
	}
	
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessRecordSummary> findByCond(final ProcessRecordSummarySearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if("1".equals(cond.getStatistictype())){// ͳ����ѡ����������
					query.append(session.getNamedQuery("ProcessRecordSummaryVWDAO.examineProblemStatistics1").getQueryString());
					if(StringUtils.isNotEmpty(cond.getPcode())){
						query.append("and pr.pcode = '" + cond.getPcode() + "'");
					}
					if(StringUtils.isNotEmpty(cond.getPrassetname())){
						query.append("and pr.prassetname = '" + cond.getPrassetname() + "'");
					}
					if(StringUtils.isNotEmpty(cond.getPropentime_from())){
						query.append("and pr.propentime >= '" + cond.getPropentime_from() + " 00:00'");
					}
					if(StringUtils.isNotEmpty(cond.getPropentime_to())){
						query.append("and pr.propentime <= '" + cond.getPropentime_to() + " 23:59'");
					}
					query.append(") a group by pname,pcode) prs) prcount");
				}else if("2".equals(cond.getStatistictype())){// ͳ����ѡ��������Դ
					query.append(session.getNamedQuery("ProcessRecordSummaryVWDAO.examineProblemStatistics2").getQueryString());
					if(StringUtils.isNotEmpty(cond.getPrassetname())){
						query.append("and pr.prassetname = '" + cond.getPrassetname() + "'");
					}
					if(StringUtils.isNotEmpty(cond.getPcode())){
						query.append("and pr.pcode = '" + cond.getPcode() + "'");
					}
					if(StringUtils.isNotEmpty(cond.getPropentime_from())){
						query.append("and pr.propentime >= '" + cond.getPropentime_from() + " 00:00'");
					}
					if(StringUtils.isNotEmpty(cond.getPropentime_to())){
						query.append("and pr.propentime <= '" + cond.getPropentime_to() + " 23:59'");
					}
					query.append(") a group by prassetname) prs) prcount");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",ProcessRecordSummaryVW.class);
				setFetchPoint(q, start, count);
				List<ProcessRecordSummary> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<ProcessRecordSummary>) execute(action);
	}
	
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(ProcessRecordSummarySearchCond cond, StringBuffer query){
		//ʱ�俪ʼ
//		if( StringUtils.isNotEmpty(cond.getDate_from()) ){
//			query.append(" AND ACINSDATE >=:date_from ");
//		}	
//		//ʱ�����
//		if( StringUtils.isNotEmpty(cond.getDate_to()) ){
//			query.append(" AND ACINSDATE <=:date_to ");
//		}	
	}
}
