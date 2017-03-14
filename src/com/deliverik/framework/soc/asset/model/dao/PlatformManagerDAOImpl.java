package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.PlatformManagerVW;

/**
 * �ʲ����ϵ��ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class PlatformManagerDAOImpl extends BaseHibernateDAOImpl<PlatformManagerInfo> implements PlatformManagerDAO {

	/**
	 * ���캯��
	 */
	public PlatformManagerDAOImpl(){
		super(PlatformManagerVW.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	@Override
	public List<PlatformManagerInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eirid"));
		List<PlatformManagerInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param eirid ����
	 * @return �������
	 */
	@Override
	public PlatformManagerInfo findByPK(Serializable eirid) {

		PlatformManagerInfo entityitemrelation = super.findByPK(eirid);
		if(entityitemrelation == null) return null;

		return entityitemrelation;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PlatformManagerVWSearchCond cond){
		
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				StringBuffer sql = new StringBuffer();
				sql.append(session.getNamedQuery("PlatformManagerDAO.getCountPlatformManagerVW").getQueryString());
				
				sql = appendSql(sql, cond);
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				
				q.setProperties(cond);
				
				Integer count = Integer.valueOf(q.uniqueResult().toString());
				session.clear();
				session.close();
				
				return count;
			}
		};
		
		return (Integer) execute(action);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PlatformManagerInfo> findByCond(final PlatformManagerVWSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				StringBuffer sql = new StringBuffer();
				sql.append(session.getNamedQuery("PlatformManagerDAO.searchPlatformManagerVW").getQueryString());
				
				sql = appendSql(sql, cond);
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addEntity(PlatformManagerVW.class);
				
				q.setProperties(cond);
				setFetchPoint(q, start,count);
				List<PlatformManagerInfo> ret = q.list();
				session.clear();
				session.close();
				return ret;
			}
		};
		
		return (List<PlatformManagerInfo>)execute(action);
	}


	private StringBuffer appendSql(StringBuffer sql,PlatformManagerVWSearchCond cond){
		if(StringUtils.isNotEmpty(cond.getEiName())){
			sql.append(" and a.einame ='"+cond.getEiName()+"'");
		}
		if(StringUtils.isNotEmpty(cond.getSdate())){
			sql.append(" and a.eiinsdate >= '"+cond.getSdate()+"'");
		}
		if(StringUtils.isNotEmpty(cond.getEdate())){
			sql.append(" and a.eiinsdate <= '"+cond.getEdate()+"'");
		}
		return sql;
	}

	

	

	
}
