package com.deliverik.infogovernor.sdl.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sdl.model.SdlSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlSummarySearchCond;
import com.deliverik.infogovernor.sdl.model.entity.SdlSummaryVW;

public class SdlSummaryVWDAOImpl extends BaseHibernateDAOImpl<SdlSummary> implements SdlSummaryVWDAO {

	/**
	 * ����ˮƽ������ͼ���캯��
	 * 
	 */
	public SdlSummaryVWDAOImpl(){
		super(SdlSummaryVW.class);
	}
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SdlSummary> findByCond(final SdlSummarySearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("SdlSummaryVWDAO.sdlSummaryQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("yearSummary",SdlSummaryVW.class);
				setFetchPoint(q, start, count);
				List<SdlSummary> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SdlSummary>) execute(action);
	}

}
