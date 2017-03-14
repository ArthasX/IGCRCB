/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.dao;

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
import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;
import com.deliverik.infogovernor.prr.model.condition.DispatchStatisticsVWSearchCond;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;

/**
  * ����: ��������ͳ��DAOʵ��
  * ��������: ��������ͳ��DAOʵ��
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public class DispatchStatisticsVWDAOImpl extends
		BaseHibernateDAOImpl<DispatchStatisticsVWInfo> implements DispatchStatisticsVWDAO {

	/**
	 * ���캯��
	 */
	public DispatchStatisticsVWDAOImpl(){
		super(DispatchStatisticsVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DispatchStatisticsVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DispatchStatisticsVWInfo findByPK(Serializable pk) {
		DispatchStatisticsVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DispatchStatisticsVWSearchCond cond){
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
	public List<DispatchStatisticsVWInfo> findByCond(final DispatchStatisticsVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DispatchStatisticsVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	@SuppressWarnings("unchecked")
	public List<DispatchStatisticsVWInfo> findDispatchStatistics(
			final DispatchStatisticsVWSearchCond cond, final int start,final int count) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append( session.getNamedQuery("DispatchStatisticsVWDAO.findDispatchStatistics1").getQueryString());
		       		   //�û���
		       		   if(StringUtils.isNotEmpty(cond.getDsusername())){
		       			    query.append(" and ds.ppusername like '%"+cond.getDsusername()+"%'");
		       		   }
		       		   //��ѯ������ʼʱ��
		       		   if(StringUtils.isNotEmpty(cond.getPropentime_from()) ){
		       			    query.append(" and ds.propentime > '"+cond.getPropentime_from()+"'");
		       		    }
		       		   //��ѯ��������ʱ��
		       		   if(StringUtils.isNotEmpty(cond.getPropentime_to()) ){
		       			    query.append(" and ds.propentime < '"+cond.getPropentime_to()+"'");
		       		    }
		       		   query.append(" )da GROUP BY dsuserid,dsusername");
		               SQLQuery q = session.createSQLQuery(query.toString());
		               q.addEntity("DispatchStatisticsVW",DispatchStatisticsVW.class);
		               setFetchPoint(q, start, count);
		               List<DispatchStatisticsVWInfo> list = q.list();
		               session.clear();
		               return list;
		           }
		       };
			return (List<DispatchStatisticsVWInfo>) execute(action);
		}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public int findDispatchStatisticsSearchCount(
			final DispatchStatisticsVWSearchCond cond) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append("select count(*) from (");
		               query.append( session.getNamedQuery("DispatchStatisticsVWDAO.findDispatchStatistics1").getQueryString());
		       		   //�û���
		       		   if(StringUtils.isNotEmpty(cond.getDsusername())){
		       			    query.append(" and ds.ppusername like '%"+cond.getDsusername()+"%'");
		       		   }
		       		   //��ѯ������ʼʱ��
		       		   if(StringUtils.isNotEmpty(cond.getPropentime_from()) ){
		       			    query.append(" and ds.propentime > '"+cond.getPropentime_from()+"'");
		       		    }
		       		   //��ѯ��������ʱ��
		       		   if(StringUtils.isNotEmpty(cond.getPropentime_to()) ){
		       			    query.append(" and ds.propentime < '"+cond.getPropentime_to()+"'");
		       		    }
		       		   query.append(" )da GROUP BY dsuserid,dsusername)");
		               SQLQuery q = session.createSQLQuery(query.toString());		               
		               q.setProperties(cond);
		               session.clear();
		               return getCount(q.list());
		           }
		       };
		       return (Integer) execute(action);
		}

}