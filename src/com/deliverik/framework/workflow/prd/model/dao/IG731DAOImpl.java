/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;

/**
 * 
 * �����ʲ���ϵDAO�ӿ�ʵ��
 *
 */
@SuppressWarnings("deprecation")
public class IG731DAOImpl extends BaseHibernateDAOImpl<IG731Info> implements IG731DAO {
	

	/**
	 * ���캯��
	 */
	public IG731DAOImpl(){
		super(IG731TB.class);
	}
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG731Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("piid"));
		List<IG731Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * @param pieid ����
	 * @return �������
	 */
	public IG731Info findByPK(Serializable pieid){
		
		IG731Info processStatusInfoDef = super.findByPK(pieid);
		
		if(processStatusInfoDef == null) return null;

		return processStatusInfoDef;
	}	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG731SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG731Info> findByCond(final IG731SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("piid"));
		List<IG731Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG731SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		
		if( cond.getPrid() != null && cond.getPrid() != 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		// ���̱�����
		if( cond.getPiid() != null && cond.getPiid() != 0){
			c.add(Expression.eq("piid", cond.getPiid()));
		}
		
		if(StringUtils.isNotEmpty(cond.getTableColumnValue())){
			if("Y".equals(cond.getTableColumnValue())){
				c.add(Expression.isNull("piid"));
			}else{
				c.add(Expression.isNotNull("piid"));
			}
		}
		
		return c;
	}
	
	/**
	 * ͨ������prid��ѯ��ص�ҵ��ϵͳ�ʲ�
	 * @param prid
	 * @return ��������б�
	 */
	public List<IG731Info> searchIG731InfoBySePrid(final Integer prid,final String flowType){
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException,
	                    SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                
	                query.append(session.getNamedQuery("IG731DAO.searchDrillDetailBySePrid").getQueryString());
	                //�ж��Ƿ�ΪӦ��ָ������
	                query.append(" and a.pivarname = '"+flowType+"'");	
	                query.append(" and a.pivarvalue = '"+prid+"'");
	                //��ȡSQLQuery
	                SQLQuery q = session.createSQLQuery(query.toString());
	                q.addEntity(IG731TB.class);
	                List<IG731Info> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IG731Info>) execute(action);
	}
	
	/**
	 * ��������prid��ѯ������eiid
	 * @param prid ����id
	 * @param flowType ��������
	 * @return
	 */
	public List<IG731Info> searchSenceBySePrid(final Integer prid,final String flowType){
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException,
	                    SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("IG731DAO.searchSenceBySePrid").getQueryString());
	                //�ж��Ƿ�ΪӦ��ָ������
	                query.append(" and a.prid = '"+prid+"'");	
	                query.append(" and b.pivarname = '"+flowType+"'");
	                //��ȡSQLQuery
	                SQLQuery q = session.createSQLQuery(query.toString());
	                q.addEntity(IG731TB.class);
	                List<IG731Info> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IG731Info>) execute(action);
	}
}
