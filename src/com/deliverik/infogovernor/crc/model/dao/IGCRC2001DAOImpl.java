package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2001VW;

/**
 * ����: ��ȹ���ͳ��DAOʵ��
 * ������¼:  lianghongyang 2014-8-7 13:34:11
 * �޸ļ�¼: 
 */
public class IGCRC2001DAOImpl extends BaseHibernateDAOImpl<IGCRC2001VWInfo> implements IGCRC2001DAO{

	
	private static final String IGCRC2001VWInfo = null;

	/**
	 * ���캯��
	 */
	public IGCRC2001DAOImpl() {
		super(IGCRC2001VW.class);
	}
	/**
	 * ���ͳ��
	 * @param cond ��������
	 * @return
	 */
	public List<IGCRC2001VWInfo> getFindStatistics(final IGCRC2001Cond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EntityItemIGCRC2001VWDAO.getYear").getQueryString());
				//������ݲ�ѯ
				query.append(" and pr.prclosetime like '" + (cond.getYear() == null || "".equals(cond.getYear())? "": cond.getYear())+"%'");
				query.append(" group by pr.closetime");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(IGCRC2001VW.class);
				List<IGCRC2001VWInfo> list =q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IGCRC2001VWInfo>) execute(action);
	}
}
