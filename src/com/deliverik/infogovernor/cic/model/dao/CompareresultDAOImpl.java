/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareresultTB;
import com.deliverik.infogovernor.cic.model.entity.CompareresultVW;

/**
  * ����: �ȶԽ��DAOʵ��
  * ��������: �ȶԽ��DAOʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CompareresultDAOImpl extends
		BaseHibernateDAOImpl<CompareresultInfo> implements CompareresultDAO {

	/**
	 * ���캯��
	 */
	public CompareresultDAOImpl(){
		super(CompareresultTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<CompareresultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	@Override
	public CompareresultInfo findByPK(Serializable pk) {
		CompareresultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareresultSearchCond cond){
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
	public List<CompareresultInfo> findByCond(final CompareresultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CompareresultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (cond.getCoid_eq() != null) {
		    c.add(Restrictions.eq("fkCoid", cond.getCoid_eq()));
		}
		return c;
	}

	/**
	 * ���ݶ���ȶԽ������List
	 * 
	 * @param cond ��������
	 * @param version �汾
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getEnameList(final CompareresultSearchCond cond) {
	    HibernateCallback action = new HibernateCallback() {
	        public Object doInHibernate(Session session) throws HibernateException, SQLException {
	            session.flush();
	            StringBuffer query = new StringBuffer();
	            
	            query.append(session.getNamedQuery("CompareresultDAO.getEname").getQueryString());
	            // ƴ�Ӳ�ѯ����
	            getSql(query, cond);
	            query.append(" group by t5.fkcoid, t5.pename, t5.esyscoding  order by t5.esyscoding");
	            SQLQuery q = session.createSQLQuery(query.toString());
	            
	            q.setProperties(cond);
//	            q.addEntity("t5",CompareresultVW.class);
	            
	            setFetchPoint(q, 0, 0);
	            List<Object[]> list = q.list();
	            session.clear();
	            session.close();
	            return list;
	        }
	    };
	    return (List<Object[]>) execute(action);
	}
	
	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<CompareresultVWInfo> searchCompareresultVW(final CompareresultSearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append(session.getNamedQuery("CompareresultDAO.searchCompareresultVW").getQueryString());
                // ƴ�Ӳ�ѯ����
                getSql(query, cond);
                query.append(" order by t5.esyscoding");
                SQLQuery q = session.createSQLQuery(query.toString());
                
                q.setProperties(cond);
                q.addEntity("t5",CompareresultVW.class);
                
                setFetchPoint(q, 0, 0);
                List<CompareresultVWInfo> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<CompareresultVWInfo>) execute(action);
    }
    
    //  ��ѯ����
    private void getSql(StringBuffer query, CompareresultSearchCond cond){
        if (cond.getCoid_eq() != null) {
            query.append(" and t5.fkcoid= :coid_eq");
        }
        
        if (null != cond.getIsBase()) {
            query.append(" and t5.isbase= :isBase");
        }
        
        if(null!=cond.getCpid_eq()&&cond.getCpid_eq()>0){
        	query.append(" and t5.fkcpid = :cpid_eq");
        }
        if(StringUtils.isNotEmpty(cond.getEid())){
        	query.append(" and t5.eid = :eid");
        }
    }
}