/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
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

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VW;

/**
  * ����: SOC0151VWDAOʵ��
  * ��������: SOC0151VWDAOʵ��
  * ������¼: 2016/06/23
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0151VWDAOImpl extends
		BaseHibernateDAOImpl<SOC0151VWInfo> implements SOC0151VWDAO {

	/**
	 * ���캯��
	 */
	public SOC0151VWDAOImpl(){
		super(SOC0151VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0151VWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0151VWInfo findByPK(Serializable pk) {
		SOC0151VWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0151VWSearchCond cond){
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
	public List<SOC0151VWInfo> findByCond(final SOC0151VWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ccdcategory"));
		c.addOrder(Order.asc("ccdid"));
		List<SOC0151VWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0151VWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�ʲ�ȡֵ��Χ��ʶ
		if(cond.getId()!=null&&cond.getId()>0){
			c.add(Expression.eq("id", cond.getId()));
		}	
		if (!StringUtils.isEmpty(cond.getCcdcategory())) {
			c.add(Expression.eq("ccdcategory", cond.getCcdcategory()));
		}
		// �ʲ�ȡֵ��Χ״̬
		if (!StringUtils.isEmpty(cond.getCcdstatus())) {
			c.add(Expression.eq("ccdstatus", cond.getCcdstatus()));
		}
		// �ʲ�ȡֵ��Χ����Ӧ��
		if (!StringUtils.isEmpty(cond.getCcdtype())) {
			c.add(Expression.eq("ccdtype", cond.getCcdtype()));
		}
		return c;
	}

	/**
	 * ��ȡȡֵ��Χ��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<ConfigurationCodeDetailBean> findConfigurationCodeDetailBean(final SOC0151VWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				String query = session.getNamedQuery("ConfigurationCodeDetailDAO.ConfigurationCodeDetailByVW").getQueryString();
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
}