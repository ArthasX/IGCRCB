/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.FillInQualityAssessInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;
import com.deliverik.infogovernor.smr.model.condition.FillInQualityAssessSearchCond;
import com.deliverik.infogovernor.smr.model.entity.FillInQualityAssessVW;
import com.deliverik.infogovernor.smr.model.entity.ReportDetailVW;

/**
 * ����:����� 
 * ��������������� 
 * �����ˣ�����͢
 * ������¼�� 2013-08-30
 * �޸ļ�¼��
 */
public class FillInQualityAssessVWDAOImpl extends
BaseHibernateDAOImpl<FillInQualityAssessInfo> implements FillInQualityAssessVWDAO{




	public List<FillInQualityAssessInfo> searchFillInQualityByUser(
			final FillInQualityAssessSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("FillInQualityAssessDAO.FillInQualityAssess").getQueryString());
				if(StringUtils.isNotEmpty(cond.getAssessstartdate())){
					query.append(" and pr.propentime>='"+cond.getAssessstartdate()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getAssessoverdate())){
					query.append(" and pr.propentime<='"+cond.getAssessoverdate()+"'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("FillInQualityAssessVW",FillInQualityAssessVW.class);
				List<RegulatoryReportInstanceInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<FillInQualityAssessInfo>) execute(action);
	}
	
	
	
	
	/**
	 * ��ܱ�����ϸҳ��ѯ
	 * @param cond ��������
	 * @return �������
	 */
	@SuppressWarnings("unchecked")
	public List<ReportDetailVWInfo> searchListForDetailByUser(
			final FillInQualityAssessSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("FillInQualityAssessDAO.detail").getQueryString());
				if(StringUtils.isNotEmpty(cond.getUserid())){
					query.append(" where one.userid_y = '"+cond.getUserid()+"' or one.userid_m = '"+cond.getUserid()+"' or one.userid_z = '"+cond.getUserid()+"'");
				}          
				if(StringUtils.isNotEmpty(cond.getOrgid())){
					query.append(" where one.orgid like '"+cond.getOrgid()+"%'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("ReportDetailVW",ReportDetailVW.class);
				List<ReportDetailVWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<ReportDetailVWInfo>) execute(action);
	}
	

}
