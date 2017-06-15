/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;
import com.deliverik.infogovernor.iam.model.condition.AUDITPROJECTSearchCond;
import com.deliverik.infogovernor.iam.model.entity.AUDITPROJECTTB;

/**
  * ����: ��Ʊ����DAOʵ��
  * ��������: ��Ʊ����DAOʵ��
  * ������¼: 2012/08/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class AUDITPROJECTDAOImpl extends
		BaseHibernateDAOImpl<AUDITPROJECTInfo> implements AUDITPROJECTDAO {

	/**
	 * ���캯��
	 */
	public AUDITPROJECTDAOImpl(){
		super(AUDITPROJECTTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AUDITPROJECTInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AUDITPROJECTInfo findByPK(Serializable pk) {
		AUDITPROJECTInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AUDITPROJECTSearchCond cond){
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
	public List<AUDITPROJECTInfo> findByCond(final AUDITPROJECTSearchCond cond, final int start, final int count){
//		DetachedCriteria c = getCriteria(cond);
//		return findByCriteria(c, start, count);
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("AUDITPROJECTDAO.problemSumInfo").getQueryString());
				if(StringUtils.isNotEmpty(cond.getProjectName())){
					query.append(" and a.approjectname like :name ");
				}
				if(StringUtils.isNotEmpty(cond.getAuditReportType())){
					query.append(" and a.apreporttype = :type");
				}
				if(StringUtils.isNotEmpty(cond.getApprojectyear())){
					query.append(" and a.approjectyear = :year");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				if(StringUtils.isNotEmpty(cond.getProjectName())){
					q.setString("name", "%"+cond.getProjectName()+"%");
				}
				if(StringUtils.isNotEmpty(cond.getAuditReportType())){
					q.setString("type", cond.getAuditReportType());
				}
				if(StringUtils.isNotEmpty(cond.getApprojectyear())){
					q.setString("year", cond.getApprojectyear());
				}
				q.setFirstResult(start);
				q.setMaxResults(count);
				q.addEntity("a",AUDITPROJECTTB.class);
				q.addScalar("ps", Hibernate.INTEGER);
				List queryList = q.list();
				Iterator it = queryList.iterator();
				List<AUDITPROJECTInfo> result = new ArrayList<AUDITPROJECTInfo>();
				while(it.hasNext()){
					Object[] obj = (Object[])it.next();
					AUDITPROJECTTB info = (AUDITPROJECTTB)obj[0];
					int ps = (Integer)obj[1];
					info.setFingerPrint(String.valueOf(ps));
					result.add(info);
				}
				List<AUDITPROJECTInfo> list = result;
				session.clear();
				return list;
			}
		};
		return (List<AUDITPROJECTInfo>) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AUDITPROJECTSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��Ŀ����
		if(StringUtils.isNotEmpty(cond.getProjectName())){
			c.add(Expression.like("approjectname", "%" + cond.getProjectName() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getAuditReportType())){
			c.add(Expression.eq("apreporttype", cond.getAuditReportType()));
		}
		return c;
	}

}