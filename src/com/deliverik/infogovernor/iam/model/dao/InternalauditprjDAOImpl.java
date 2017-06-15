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
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditprjSearchCond;
import com.deliverik.infogovernor.iam.model.entity.AUDITPROJECTTB;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;
/**
  * ����: ������ĿDAOʵ��
  * ��������: ������ĿDAOʵ��
  * ������¼: 2012/07/19
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class InternalauditprjDAOImpl extends
		BaseHibernateDAOImpl<InternalauditprjInfo> implements InternalauditprjDAO {

	/**
	 * ���캯��
	 */
	public InternalauditprjDAOImpl(){
		super(InternalauditprjTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InternalauditprjInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InternalauditprjInfo findByPK(Serializable pk) {
		InternalauditprjInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InternalauditprjSearchCond cond){
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
	public List<InternalauditprjInfo> findByCond(final InternalauditprjSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	
	public List<InternalauditprjInfo> auditProjectHelpSearch(final InternalauditprjSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("InternalauditprjDAO.projectListInfo").getQueryString());
				if(StringUtils.isNotEmpty(cond.getIapName_like())){
					query.append(" and iapName like :name ");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())){
					query.append(" and iapOpenTime >= :openTime_ge");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())){
					query.append(" and iapOpenTime <= :openTime_le");
				}
				if(StringUtils.isNotEmpty(cond.getIapStatus_eq())){
					query.append(" and iapstatus = :status ");
				}
				if(StringUtils.isNotEmpty(cond.getIapType_eq())){
					query.append(" and iaptype = :type");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				if(StringUtils.isNotEmpty(cond.getIapName_like())){
					q.setString("name", "%"+cond.getIapName_like()+"%");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())){
					q.setString("openTime_le", cond.getIapOpenTimeTo_le());
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())){
					q.setString("openTime_ge", cond.getIapOpenTimeFrom_ge());
				}
				if(StringUtils.isNotEmpty(cond.getIapStatus_eq())){
					q.setString("status", cond.getIapStatus_eq());
				}
				if(StringUtils.isNotEmpty(cond.getIapType_eq())){
					q.setString("type", cond.getIapType_eq());
				}
				q.setFirstResult(start);
				q.setMaxResults(count);
				q.addEntity("a",InternalauditprjTB.class);
				List queryList = q.list();
				Iterator it = queryList.iterator();
				List<InternalauditprjInfo> result = new ArrayList<InternalauditprjInfo>();
				while(it.hasNext()){
					Object obj = (Object)it.next();
					InternalauditprjTB info = (InternalauditprjTB)obj;
					result.add(info);
				}
				List<InternalauditprjInfo> list = result;
				session.clear();
				return list;
			}
		};
		return (List<InternalauditprjInfo>) execute(action);
	}
	
	public int auditProjectHelpSearchConut(final InternalauditprjSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("InternalauditprjDAO.projectListInfo").getQueryString());
				if(StringUtils.isNotEmpty(cond.getIapName_like())){
					query.append(" and iapName like :name ");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())){
					query.append(" and iapOpenTime >= :openTime_ge");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())){
					query.append(" and iapOpenTime <= :openTime_le");
				}
				if(StringUtils.isNotEmpty(cond.getIapStatus_eq())){
					query.append(" and iapstatus = :status ");
				}
				if(StringUtils.isNotEmpty(cond.getIapType_eq())){
					query.append(" and iaptype = :type");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				if(StringUtils.isNotEmpty(cond.getIapName_like())){
					q.setString("name", "%"+cond.getIapName_like()+"%");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())){
					q.setString("openTime_le", cond.getIapOpenTimeTo_le());
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())){
					q.setString("openTime_ge", cond.getIapOpenTimeFrom_ge());
				}
				if(StringUtils.isNotEmpty(cond.getIapStatus_eq())){
					q.setString("status", cond.getIapStatus_eq());
				}
				if(StringUtils.isNotEmpty(cond.getIapType_eq())){
					q.setString("type", cond.getIapType_eq());
				}
				q.addEntity("a",InternalauditprjTB.class);
				List queryList = q.list();
				return queryList.size();
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(InternalauditprjSearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();
		//�ж������Ŀ�����Ƿ�Ϊ��
		if (StringUtils.isNotEmpty(cond.getIapName_like())) {
			//��������Ŀ���Ƽ�������
			c.add(Expression.like("iapName", "%" + cond.getIapName_like() + "%"));
		}
		//�ж�����Ƿ�Ϊ��
		if (StringUtils.isNotEmpty(cond.getIapYear_eq())) {
			//�����ȼ�������
			c.add(Expression.eq("iapYear", cond.getIapYear_eq()));
		}
		//�ж�״̬�Ƿ�Ϊ��
		if (StringUtils.isNotEmpty(cond.getIapStatus_eq())) {
			//����ѯΪ����ȷ��ʱ
			if (cond.getIapStatus_eq().equals("a")) {
				//���״̬��������
				c.add(Expression.ne("iapStatus", "0"));
			//�������
			} else {			
				//���״̬��������
				c.add(Expression.eq("iapStatus", cond.getIapStatus_eq()));
			}
		}
		//�ж�������ڴ��Ƿ�Ϊ��
		if (StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())) {
			//���������ڴӼ�������
			c.add(Expression.ge("iapOpenTime", cond.getIapOpenTimeFrom_ge()));
		}
		//�ж�������ڵ��Ƿ�Ϊ��
		if (StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())) {
			//���������ڵ���������
			c.add(Expression.le("iapOpenTime", cond.getIapOpenTimeTo_le()));
		}
		//�ж����״̬�Ƿ�Ϊ��
		if (StringUtils.isNotEmpty(cond.getIapType_eq())) {
			//������״̬����������
			c.add(Expression.eq("iapType", cond.getIapType_eq()));
		}
		return c;
	}

}