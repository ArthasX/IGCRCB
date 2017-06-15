/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskcaseVWTB;

/**
  * ����: �����¼�DAOʵ��
  * ��������: �����¼�DAOʵ��
  * ������¼: 2014/07/18
  * �޸ļ�¼: 
  */

public class RiskcaseVWDAOImpl extends
		BaseHibernateDAOImpl<RiskcaseVWInfo> implements RiskcaseVWDAO {

	/**
	 * ���캯��
	 */
	public RiskcaseVWDAOImpl(){
		super(RiskcaseVWTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskcaseVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskcaseVWInfo findByPK(Serializable pk) {
		RiskcaseVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskcaseVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("RiskcaseVWDAO.getSearchCount").getQueryString());
				query.append(" where 1=1 ");
				query = getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				Integer count = getCount(q.list());
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<RiskcaseVWInfo> findByCond(final RiskcaseVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("RiskcaseVWDAO.SearchRiskcaseVW").getQueryString());
				
				query.append(" where 1=1 ");
				
				query = getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("RCTB",RiskcaseVWTB.class);

				setFetchPoint(q, start, count);

				List<RiskcaseVWInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<RiskcaseVWInfo>) execute(action);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<RiskcaseVWInfo> findByCondByVersion(final RiskcaseVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("RiskcaseVWDAO.SearchRiskcaseByVersion").getQueryString());
				
				query.append(" where 1=1 ");
				
				query = getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("RCTB",RiskcaseVWTB.class);


				List<RiskcaseVWInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<RiskcaseVWInfo>) execute(action);
	}
	
	/**
	 * �����¼�Ӧ�Բ��Բ�ѯ
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<RiskcaseVWInfo> findByCond(final RiskcaseVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("RiskcaseVWDAO.SearchRiskPolicys").getQueryString());
				
				query.append(" where 1=1 ");
				
				query = getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("RCTB",RiskcaseVWTB.class);

				List<RiskcaseVWInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<RiskcaseVWInfo>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskcaseVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param query sql
	 * @return �����ü���������
	 */
	protected StringBuffer getSQL(RiskcaseVWSearchCond cond, StringBuffer query){
		//��ѯ���°汾
		if("0".equals(cond.getVersion())){
			
		}else{//��ѯ��ʷ�汾
			query = new StringBuffer(query.toString().replaceAll("REP_VERSION",  "and CIVERSION = '"+cond.getVersion()+"'"));
		}
		//�����¼�ID
		if( cond.getEiid()!=null){
			query.append(" AND a.EIID = "+cond.getEiid());
		}
		//�����¼�����
		if(!StringUtils.isEmpty(cond.getFcname())){
			query.append(" AND fcname like '%"+cond.getFcname()+"%'");
		}
		//�����¼���Դ
		if(!StringUtils.isEmpty(cond.getFcorigin())){
			query.append(" AND fcorigin = '"+cond.getFcorigin()+"'");
		}
		//�����¼���������
		if(!StringUtils.isEmpty(cond.getFccategory())){
			query.append(" AND fccategory = '"+cond.getFccategory()+"'");
		}
		//�����¼�ʶ��ʱ���
		if(!StringUtils.isEmpty(cond.getRiskcatchtime_from())){
			query.append(" AND riskcatchtime >= '"+cond.getRiskcatchtime_from()+"'");
		}
		//�����¼�ʶ��ʱ�䵽
		if(!StringUtils.isEmpty(cond.getRiskcatchtime_to())){
			query.append(" AND riskcatchtime <= '"+cond.getRiskcatchtime_to()+"'");
		}
		//���յ�ID
		if(!StringUtils.isEmpty(cond.getRiskid())){
			query.append(" AND riskid = '"+cond.getRiskid()+"'");
		}
		//�����¼�Ӧ�Բ���
		if(!StringUtils.isEmpty(cond.getFcpolicy())){
			query.append(" AND fcpolicy = '"+cond.getFcpolicy()+"'");
		}
		//�����¼�������
		if(!StringUtils.isEmpty(cond.getRiskreviewresult())){
			query.append(" AND riskreviewresult = '"+cond.getRiskreviewresult()+"'");
		}
		if(StringUtils.isNotEmpty(cond.getEISTATUS())){
			query.append(" AND EISTATUS = '"+cond.getEISTATUS()+"'");
		}
		return query;
	}

}