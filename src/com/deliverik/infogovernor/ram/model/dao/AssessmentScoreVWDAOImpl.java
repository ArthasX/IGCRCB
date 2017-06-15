/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.model.dao;

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
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCond;
import com.deliverik.infogovernor.ram.model.entity.AssessmentScoreVW;

/**
  * ����: ������ʷ��ѯDAOʵ��
  * ��������: ������ʷ��ѯDAOʵ��
  * ������¼: 2013/10/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class AssessmentScoreVWDAOImpl extends
		BaseHibernateDAOImpl<AssessmentScoreVWInfo> implements AssessmentScoreVWDAO {

	/**
	 * ���캯��
	 */
	public AssessmentScoreVWDAOImpl(){
		super(AssessmentScoreVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AssessmentScoreVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AssessmentScoreVWInfo findByPK(Serializable pk) {
		AssessmentScoreVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AssessmentScoreVWSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AssessmentScoreVWInfo> findByCond(final AssessmentScoreVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	/**
	 * ������������������
	 * @return ������ȱ���
	 */
	public List<Object[]> assessmentYearReport(final AssessmentScoreVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(session.getNamedQuery("AssessmentScoreDAO.AssessmentOfYearReportVW").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				if(!StringUtils.isEmpty(cond.getCurrentyear())){
					q.setString("currentyear", cond.getCurrentyear()+"%");				
				}
				
				setFetchPoint(q, 0, 0);
				List<Object[]> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<Object[]>)execute(action);
	}
	/**
	 * �������������������
	 * @return ������ȱ���
	 */
	public List<Object[]> assessmentOrganizationReport(final AssessmentScoreVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(session.getNamedQuery("AssessmentScoreDAO.AssessmentOfOrganizationReportVW").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				if(!StringUtils.isEmpty(cond.getBegintime())&&!StringUtils.isEmpty(cond.getEndtime())){
					q.setString("pdid1", cond.getList().get(0).substring(0, 5)+"%");
					q.setString("pdid2", cond.getList().get(1).substring(0, 5)+"%");
					q.setString("pdid3", cond.getList().get(2).substring(0, 5)+"%");
					q.setString("pdid4", cond.getList().get(3).substring(0, 5)+"%");
					q.setString("BEGINTIME", cond.getBegintime());
					q.setString("ENDTIME", cond.getEndtime());
					q.setString("toporgid", cond.getTopOrgid());
				}
				
				setFetchPoint(q, 0, 0);
				List<Object[]> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<Object[]>)execute(action);
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AssessmentScoreVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid()!=null){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(cond.getUserid()!= null){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		return c;
	}

}