/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainmissionSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainmissionTB;

/**
  * ����: ��ѵ�����DAOʵ��
  * ��������: ��ѵ�����DAOʵ��
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class TrainmissionDAOImpl extends
		BaseHibernateDAOImpl<TrainmissionInfo> implements TrainmissionDAO {

	/**
	 * ���캯��
	 */
	public TrainmissionDAOImpl(){
		super(TrainmissionTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainmissionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainmissionInfo findByPK(Serializable pk) {
		TrainmissionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TrainmissionSearchCond cond){
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
	public List<TrainmissionInfo> findByCond(final TrainmissionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("tmid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(TrainmissionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTpid()!=null&&cond.getTpid()!=0){
			c.add(Expression.eq("tpid", cond.getTpid()));
		}
		return c;
	}
	
	/**
	 * ���� keyִ��ָ����SQL
	 * @param sqlKeys SQL����ʶ
	 * @param paramMap	��ѯ����
	 * @return List<Map<String, Object>> �����
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getList(final String [] sqlKeys, final Map<String, String> paramMap) {

        HibernateCallback action = new HibernateCallback() {

            /* (non-Javadoc)
             * @see org.springframework.orm.hibernate3.HibernateCallback#doInHibernate(org.hibernate.Session)
             */
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                buildSQL(sqlKeys, session, query);
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(paramMap);
                q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                List<Map<String, Object>> list = q.list();
                session.clear();
                session.close();
                return list;
             } // end method doInHibernate 
         };
         return ((List<Map<String, Object>>) execute(action));
	} // end method getList
	
	/**
	 * ����SQL���
	 * @param sqlKeys
	 * @param session
	 * @param query
	 */
	private void buildSQL(final String[] sqlKeys, Session session, StringBuffer query) {
		for (String sqlKey : sqlKeys) {
			query.append(session.getNamedQuery(sqlKey).getQueryString()).append(" ");
		} // end for each 
	} // end method buildSQL 

}