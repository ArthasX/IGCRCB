package com.deliverik.framework.soc.asset.model.dao;

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

import com.deliverik.framework.soc.asset.model.dao.SOC0151DAO;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;

/**
 * �ʲ���������DAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0151DAOImpl extends BaseHibernateDAOImpl<SOC0151Info> implements SOC0151DAO {

	/**
	 * ���캯��
	 * 
	 */
	public SOC0151DAOImpl(){
		super(SOC0151TB.class);
	}

	public List<SOC0151Info> findByCond(
			SOC0151SearchCond cond, int start, int count) {
		DetachedCriteria c = getCriteria(cond);
//		ProjectionList projectionList = Projections.projectionList();  
//		projectionList.add(Property.forName("ccdcategory").as("ccdcategory"));  
//		projectionList.add(Projections.property("ccdlabel").as("ccdlabel"));  
//		c.setProjection(Projections.distinct(projectionList));
		c.addOrder(Order.asc("ccdcategory"));
		c.addOrder(Order.asc("ccdid"));
		List<SOC0151Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0151SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * ��ȡȡֵ��Χ��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<ConfigurationCodeDetailBean> findConfigurationCodeDetailBean(final SOC0151SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				String query = session.getNamedQuery("ConfigurationCodeDetailDAO.ConfigurationCodeDetail").getQueryString();
				SQLQuery q = session.createSQLQuery(query);
				q.setProperties(cond);
				setFetchPoint(q, 0, 0);
				List<Object[]> list = q.list();
				List<ConfigurationCodeDetailBean> ccdList = new ArrayList<ConfigurationCodeDetailBean>();
				for(Object[] o : list){
					ConfigurationCodeDetailBean bean = new ConfigurationCodeDetailBean();
					bean.setCcdcategory(o[0].toString());
					bean.setCcdlabel(o[1].toString());
					ccdList.add(bean);
				}
				session.clear();
				return ccdList;
			}
		};
		return (List<ConfigurationCodeDetailBean>) execute(action);
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0151SearchCond cond){
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
