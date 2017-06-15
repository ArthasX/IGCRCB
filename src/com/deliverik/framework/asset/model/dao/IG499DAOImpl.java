/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

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

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.asset.model.entity.IG499VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: ��ͬ�ʲ���Ϣ��ͼDAOʵ��
  * ��������: ��ͬ�ʲ���Ϣ��ͼDAOʵ��
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG499DAOImpl extends
		BaseHibernateDAOImpl<IG499Info> implements IG499DAO {

	/**
	 * ���캯��
	 */
	public IG499DAOImpl(){
		super(IG499VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG499Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG499Info findByPK(Serializable pk) {
		IG499Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG499SearchCond cond){
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
	@SuppressWarnings("unchecked")
	public List<IG499Info> findByCond(final IG499SearchCond cond, final int start, final int count){
		final String payed = cond.getPayed();
		if("0".equals(payed)||"1".equals(payed)){//0:����δ���  1���������
			HibernateCallback action = new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();

					StringBuffer query = new StringBuffer();
					
					if("0".equals(payed)){
						query.append(session.getNamedQuery("IG499DAO.searchImprestByCond1").getQueryString());
						getSQL(cond, query);
						query.append(session.getNamedQuery("IG499DAO.searchImprestByCondEnd").getQueryString());
						//System.out.println("����δ���SQL��"+query.toString());
					}
					if("1".equals(payed)){
						query.append(session.getNamedQuery("IG499DAO.searchImprestByCond2").getQueryString());
						getSQL(cond, query);
						//System.out.println("���������SQL��"+query.toString());
					}
					query.append(" ORDER BY EILABEL DESC");
					
					SQLQuery q = session.createSQLQuery(query.toString());
					
					q.addEntity("ei",IG499VW.class);

					setFetchPoint(q, start, count);
					
					List<IG499Info> list = q.list();
					
					session.clear();
					session.close();
					
					return list;
				}
			};
			return (List<IG499Info>) execute(action);
		}
		
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("eilabel"));
		return findByCriteria(c, start, count);
	}
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchImprestCount(final IG499SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG499DAO.getSearchImprestCountStart").getQueryString());
				
				getSQL(cond, query);
				
				query.append(session.getNamedQuery("IG499DAO.findImprestByCondEnd").getQueryString());
				
				query.append(" ) uu ORDER BY EILABEL DESC");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);

				session.clear();
				session.close();
				return getCount(q.list());
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
	public List<IG499Info> findImprestByCond(final IG499SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append(session.getNamedQuery("IG499DAO.findImprestByCondStart").getQueryString());
				
				
				getSQL(cond, query);
				
				query.append(session.getNamedQuery("IG499DAO.findImprestByCondEnd").getQueryString());
				
				query.append(" order by eilabel desc");
				
				//System.out.println("��ǰSQL��"+query.toString());
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",IG499VW.class);
				
				q.setProperties(cond);
				
				setFetchPoint(q, start, count);
				
				List<IG688Info> list = q.list();
				
				session.clear();
				session.close();
				
				return list;
			}
		};
		return (List<IG499Info>) execute(action);
	}

	/**
	 * ������������
	 * @param cond
	 * @param query
	 */
	protected void getSQL(IG499SearchCond cond, StringBuffer query) {
		query.append(" ");
		//��ͬ���
		if(StringUtils.isNotEmpty(cond.getCompacttype())){
			query.append(" and u.compacttype='"+cond.getCompacttype()+"' ");
		}
		//��ͬ����
		if(StringUtils.isNotEmpty(cond.getEiname())){
			query.append(" and u.einame like '%"+cond.getEiname()+"%' ");
		}
		//������
		if(StringUtils.isNotEmpty(cond.getFacilitator())){
			query.append(" and u.facilitator like '%"+cond.getFacilitator()+"%' ");
		}
		//��ѯʱ���
		if(StringUtils.isNotEmpty(cond.getDatetime())){
			query.append(" and u.expectday <='"+cond.getDatetime()+"' ");
		}
		//��ͬ���
		if(StringUtils.isNotEmpty(cond.getEilabel())){
			query.append(" and u.eilabel like '%"+cond.getEilabel()+"%' ");
		}
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG499SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��ͬ���
		if(StringUtils.isNotEmpty(cond.getCompacttype())){
			c.add(Expression.eq("compacttype", cond.getCompacttype()));
		}
		//������
		if(StringUtils.isNotEmpty(cond.getFacilitator())){
			c.add(Expression.like("facilitator", "%"+cond.getFacilitator()+"%"));
		}
		//������
		if(StringUtils.isNotEmpty(cond.getOperator())){
			c.add(Expression.like("operator", "%"+cond.getOperator()+"%"));
		}
		//��ͬ����
		if(StringUtils.isNotEmpty(cond.getEiname())){
			c.add(Expression.like("einame", "%"+cond.getEiname()+"%"));
		}
		//��ͬ���
		if(StringUtils.isNotEmpty(cond.getEilabel())){
			c.add(Expression.like("eilabel", "%"+cond.getEilabel()+"%"));
		}
		//ǩ��ʱ��
		if(StringUtils.isNotEmpty(cond.getCondudetime_from())){
			c.add(Expression.ge("condudetime", cond.getCondudetime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getCondudetime_to())){
			c.add(Expression.le("condudetime", cond.getCondudetime_to()));
		}
		if(StringUtils.isNotEmpty(cond.getEiid())){
			c.add(Expression.eq("eiid", Integer.parseInt(cond.getEiid())));
		}
		if(StringUtils.isNotEmpty(cond.getEiusername())){
			c.add(Expression.like("eiusername", "%"+cond.getEiusername()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getEiorgsyscoding_in())){
			c.add(Expression.sql(" eiorgsyscoding in ('"+cond.getEiorgsyscoding_in()+"')"));
		}
		return c;
	}

}