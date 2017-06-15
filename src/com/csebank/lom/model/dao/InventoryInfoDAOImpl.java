/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.InventoryInfo;
import com.csebank.lom.model.condition.InventoryInfoSearchCond;
import com.csebank.lom.model.entity.InventoryInfoVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ÿ���̵�DAO�ӿ�ʵ��
 *
 */
public class InventoryInfoDAOImpl extends BaseHibernateDAOImpl<InventoryInfo> implements InventoryInfoDAO {

	/**
	 * ���캯��
	 */
	public InventoryInfoDAOImpl(){
		super(InventoryInfoVW.class);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryInfo> findByCond(final InventoryInfoSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<InventoryInfo> list =null;
				
				query.append(session.getNamedQuery("InventoryInfoDAO.inventoryInfo").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(InventoryInfoVW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<InventoryInfo>) execute(action);
	}


}
