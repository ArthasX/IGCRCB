package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.asset.model.entity.IG545TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * �ʲ���������DAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG545DAOImpl extends BaseHibernateDAOImpl<IG545Info> implements IG545DAO {

	/**
	 * ���캯��
	 * 
	 */
	public IG545DAOImpl(){
		super(IG545TB.class);
	}

	public List<IG545Info> findByCond(
			IG545SearchCond cond, int start, int count) {
		DetachedCriteria c = getCriteria(cond);
//		ProjectionList projectionList = Projections.projectionList();  
//		projectionList.add(Property.forName("ccdcategory").as("ccdcategory"));  
//		projectionList.add(Projections.property("ccdlabel").as("ccdlabel"));  
//		c.setProjection(Projections.distinct(projectionList));
		c.addOrder(Order.asc("ccdcategory"));
		c.addOrder(Order.asc("ccdid"));
		List<IG545Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG545SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * ��ȡȡֵ��Χ��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG545Bean> findIG545Bean(final IG545SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				String query = session.getNamedQuery("IG545DAO.ConfigurationCodeDetail").getQueryString();
				SQLQuery q = session.createSQLQuery(query);
				q.setProperties(cond);
				setFetchPoint(q, 0, 0);
				List<Object[]> list = q.list();
				List<IG545Bean> ccdList = new ArrayList<IG545Bean>();
				for(Object[] o : list){
					IG545Bean bean = new IG545Bean();
					bean.setCcdcategory(o[0].toString());
					bean.setCcdlabel(o[1].toString());
					ccdList.add(bean);
				}
				session.clear();
				session.close();
				return ccdList;
			}
		};
		return (List<IG545Bean>) execute(action);
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG545SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�ʲ�ȡֵ��Χ��ʶ
		if( !StringUtils.isEmpty(cond.getCcdcategory())){
			c.add(Expression.eq("ccdcategory", cond.getCcdcategory()));
		}	
		//�ʲ�ȡֵ��Χ״̬
		if( !StringUtils.isEmpty(cond.getCcdstatus())){
			c.add(Expression.eq("ccdstatus", cond.getCcdstatus()));
		}	
		// �ʲ�ȡֵ��Χ����Ӧ��
		if( !StringUtils.isEmpty(cond.getCcdtype())){
			c.add(Expression.eq("ccdtype", cond.getCcdtype()));
		}	
		return c;
	}
}
