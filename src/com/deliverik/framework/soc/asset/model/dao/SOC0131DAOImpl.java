/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.SOC0131TB;
import com.deliverik.framework.soc.asset.model.condition.SOC0131SearchCond;


/**
 * ����: �豸��ϵ��ϢDAOʵ��(VG-PV-Meta)
 * ��������: �豸��ϵ��ϢDAOʵ��(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public class SOC0131DAOImpl extends BaseHibernateDAOImpl<SOC0131Info> implements SOC0131DAO{

	/**
	 * ���캯��
	 */
	public SOC0131DAOImpl(){
		super(SOC0131TB.class);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<SOC0131Info> searchVgPvMeta(final SOC0131SearchCond cond) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
				query.append(session.getNamedQuery("VgPvMetaDao.findVgPvMetaByVW").getQueryString());
				SQLQuery q = session.createSQLQuery(
						query.toString().replaceAll(":srcreatetime_eq","'"+cond.getSrcreatetime_eq()+"'")
						.replaceAll(":srdomainid_eq","'"+cond.getSrdomainid_eq()+"'") 
						.replaceAll(":srdomainversion_eq","'"+cond.getSrdomainversion_eq()+"'")
						.replaceAll(":srpareiid_eq","'"+cond.getSrpareiid_eq()+"'")
						.replaceAll(":srparversion_eq","'"+cond.getSrparversion_eq()+"'")
						.replaceAll(":srparsmallversion_eq","'"+cond.getSrparsmallversion_eq()+"'")	
				);				q.setProperties(cond); 
				q.addEntity(SOC0131TB.class);
				List<SOC0131TB> list = q.list();
				return list;
			}		
		};
		return (ArrayList<SOC0131Info>)execute(action);
	}


}
