/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanitemSearchCond;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;

/**
  * ����: �����ƻ���ĿDAOʵ��
  * ��������: �����ƻ���ĿDAOʵ��
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class DrillplanitemDAOImpl extends
		BaseHibernateDAOImpl<DrillplanitemInfo> implements DrillplanitemDAO {

	/**
	 * ���캯��
	 */
	public DrillplanitemDAOImpl(){
		super(DrillplanitemTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
    public List<DrillplanitemInfo> findAll() {
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
    public DrillplanitemInfo findByPK(Serializable pk) {
		DrillplanitemInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DrillplanitemSearchCond cond){
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
	public List<DrillplanitemInfo> findByCond(final DrillplanitemSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DrillplanitemSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getDid()!=null&&0!=cond.getDid().intValue()){
		    c.add(Expression.eq("did", cond.getDid()));
		}
		return c;
	}

	/**��ѯ����������Ϣ*/
	public List<Map<String,Object>> searchDrillDetailByPrid(final String prid, final String flowType){
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException,
	                    SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                if(flowType.equals("all")){
	                	query.append(session.getNamedQuery("DrillplanitemDAO.searchDrillDetailByAllPrid").getQueryString());
	                }else{
	                	query.append(session.getNamedQuery("DrillplanitemDAO.searchDrillDetailByEmPrid").getQueryString());
	                }
	                query.append(" and a.prid = "+ prid);
	                //��ȡSQLQuery
	                SQLQuery q = session.createSQLQuery(query.toString());
	                q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	        		q.addScalar("DRILLNAME", Hibernate.STRING);
	        		q.addScalar("OPENTIME", Hibernate.STRING);
	        		q.addScalar("CLOSETIME", Hibernate.STRING);
	        		q.addScalar("AUTHOR", Hibernate.STRING);
	        		q.addScalar("DRILLFORMALITY", Hibernate.STRING);
	        		q.addScalar("DRILLCONTENT", Hibernate.STRING);
	        		q.addScalar("DRILLOBJECTIVE", Hibernate.STRING);
	        		q.addScalar("PLANNAME", Hibernate.STRING);
	        		q.addScalar("SENCENAME", Hibernate.STRING);
	        		q.addScalar("DEPARTMENT",Hibernate.STRING);
	                List<Map<String,Object>> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<Map<String,Object>>) execute(action);
	}
}