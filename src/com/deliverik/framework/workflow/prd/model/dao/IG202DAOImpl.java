/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG202TB;

/**
 * <p>����:���̹�ͨ����DAOʵ��</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.������������</p>
 * <p>          3.����������¼��</p>
 * <p>          4.������������</p>
 * <p>          5.������������</p>
 * <p>          6.���������������ȡ��</p>
 * <p>          7.�����������ɣ�ȫ�������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("deprecation")
public class IG202DAOImpl extends BaseHibernateDAOImpl<IG202Info> implements IG202DAO{

	/**
	 * ���ܣ����캯��
	 */
	public IG202DAOImpl(){
		super(IG202TB.class);
	}
	
	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG202Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pidid"));
		List<IG202Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * @param pdaid ����
	 * @return �������
	 */
	public IG202Info findByPK(Serializable pidid){
		
		IG202Info processInfoDefGeneral = super.findByPK(pidid);
		
		if(processInfoDefGeneral == null) return null;

		return processInfoDefGeneral;
	}
	

	/**
	 * ���ܣ�����������¼��
	 * @return ����������¼��
	 */
	public int searchIG202InfoCount(final IG202SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG202DAO.searchIG202Count").getQueryString());

				getSQL(cond, query);
				
				query.append(" )");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				//q.setProperties(cond);
				
				session.clear();

				return getCount(q.list());

			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG202Info> searchIG202Info(final IG202SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG202DAO.searchIG202").getQueryString());
				
				getSQL(cond, query);
				
				query.append(" ) ORDER BY pg.pidid desc");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("pg",IG202TB.class);

				//q.setProperties(cond);
				
				setFetchPoint(q, start, count);

				
				List<IG202Info> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<IG202Info>) execute(action);
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(IG202SearchCond cond, StringBuffer query){
		if(StringUtils.isNotEmpty(cond.getPdid())){
			query.append(" And pdid = ").append(cond.getPdid());
		}
		
		
	}
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG202SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG202Info> findByCond(final IG202SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG202Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG202SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		if (cond.getPidid_notlike() != null && cond.getPidid_notlike() > 0) {
			c.add(Expression.ne("pidid", cond.getPidid_notlike()));
		}
		if (!StringUtils.isEmpty(cond.getPidlabel())) {
			c.add(Expression.eq("pidlabel", cond.getPidlabel()));
		}
		return c;
	}
	
}
