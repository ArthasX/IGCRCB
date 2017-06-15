package com.deliverik.framework.asset.model.dao;

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

import com.deliverik.framework.asset.model.IG778Info;
import com.deliverik.framework.asset.model.condition.IG778SearchCond;
import com.deliverik.framework.asset.model.entity.IG778VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * ������Ϣ��ͼDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG778DAOImpl extends BaseHibernateDAOImpl<IG778Info> implements IG778DAO {

	/**
	 * ���캯��
	 * 
	 */
	public IG778DAOImpl(){
		super(IG778VW.class);
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG778SearchCond cond){
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
	public List<IG778Info> findByCond(final IG778SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//c.addOrder(Order.asc("eiid"));
		//c.addOrder(Order.asc("eilabel"));
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		//�����豸������������
		c.addOrder(Order.asc("room_einame"));
		c.addOrder(Order.asc("eilabel"));
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		List<IG778Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * �����������������յ���UPS
	 * 
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<IG778Info> findByIG778Info(final IG778SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG778DAO.findByComputerContainer").getQueryString());
				query = getSQL(cond, query);
				query.append(" AND TABLE1.EIVERSION <> 0");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG778VW",IG778VW.class);
				List<IG778Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG778Info>) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected StringBuffer getSQL(IG778SearchCond cond, StringBuffer query) {
		
		if (cond.getEiid()!=null) {
			query.append(" AND TABLE1.EIID=:eiid");
		}

		if ((cond.getRoom_eiid()!=null)){
			query.append(" AND TABLE1.ROOM_EIID=:room_eiid");
		}

		if (StringUtils.isNotEmpty(cond.getEilabel())) {
			query.append(" AND TABLE1.EILABEL=:eilabel");
		}

		if (StringUtils.isNotEmpty(cond.getEiname())) {
			query.append(" AND TABLE1.EINAME LIKE ('%'||:einame||'%')");
		}

		if (StringUtils.isNotEmpty(cond.getU_total())) {
			query.append(" AND TABLE1.U_TOTAL=:u_total");
		}

        if(StringUtils.isNotEmpty(cond.getGraphstatus())){
        	if ("0".equals(cond.getGraphstatus())) {//δ�ϼ�
        		query.append(" AND (TABLE1.GRAPHSTATUS IS NULL OR TABLE1.GRAPHSTATUS=:graphstatus OR TABLE1.GRAPHSTATUS='')");
        	}else{//���ϼ�
        		query.append(" AND TABLE1.GRAPHSTATUS=:graphstatus");
        	}
		}
        
        if (StringUtils.isNotEmpty(cond.getContainertype())) {
        	query.append(" AND TABLE1.CONTAINERTYPE=:containertype");
		}
        
		return query;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG778SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (cond.getEiid()!=null) {
			c.add(Expression.eq("eiid", cond.getEiid()));
		}

		if ((cond.getRoom_eiid()!=null)) {
			c.add(Expression.eq("room_eiid", cond.getRoom_eiid()));
		}

		if (StringUtils.isNotEmpty(cond.getEilabel())) {
			c.add(Expression.eq("eilabel", cond.getEilabel()));
		}

		if (StringUtils.isNotEmpty(cond.getEiname())) {
			c.add(Expression.like("einame", "%" + cond.getEiname() + "%"));
		}

		if (StringUtils.isNotEmpty(cond.getU_total())) {
			c.add(Expression.eq("u_total", cond.getU_total()));
		}
		
		if(StringUtils.isNotEmpty(cond.getGraphstatus())){
			c.add(Expression.eq("graphstatus", cond.getGraphstatus()));
		}
		
        if (StringUtils.isNotEmpty(cond.getContainertype())) {
			c.add(Expression.eq("containertype", cond.getContainertype()));
		}
        
		return c;
	}
}
