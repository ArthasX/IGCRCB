package com.deliverik.infogovernor.sdl.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCond;
import com.deliverik.infogovernor.sdl.model.entity.IncidentKpiVW;

public class IncidentKpiVWDAOImpl extends BaseHibernateDAOImpl<IncidentKpi> implements IncidentKpiVWDAO {

	/**
	 * �¼�kpi������ͼ���캯��
	 * 
	 */
	public IncidentKpiVWDAOImpl(){
		super(IncidentKpiVW.class);
	}
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IncidentKpi> findByCond(final IncidentKpiSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				//��ʾ��ʽ
				String namedQuery = "IncidentKpiVWDAO.QueryByType";//�¼����
				String radioValue = cond.getRadioValue();
				List<IncidentKpi> idList= new ArrayList<IncidentKpi>(); //�Զ����¼�
				if("B".equals(radioValue)){
					//�����̶�
					namedQuery = "IncidentKpiVWDAO.QueryByUrgency";
				}else if("C".equals(radioValue)){
					//�¼����+�����̶�
					namedQuery = "IncidentKpiVWDAO.QueryByTypeAndUrgency";
				}else if("D".equals(radioValue)){
					//�����̶�+�¼����
					namedQuery = "IncidentKpiVWDAO.QueryByUrgencyAndType";
				}else{
					StringBuffer queryID = new StringBuffer();
					String namedQueryID = "IncidentKpiVWDAO.QueryIDByType";//�Զ����¼����
					queryID.append(session.getNamedQuery(namedQueryID).getQueryString());
					SQLQuery q = session.createSQLQuery(queryID.toString());

					q.setProperties(cond);
					q.addEntity("IncidentKpi",IncidentKpiVW.class);
					setFetchPoint(q, start, count);
					idList = q.list();
					if(idList == null || idList.size()==0){
						IncidentKpiVW vw = new IncidentKpiVW();
						vw.setTypeName("");
						vw.setResolve(0f);
						idList.add(vw);
					}
				}
				query.append(session.getNamedQuery(namedQuery).getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IncidentKpi",IncidentKpiVW.class);
				setFetchPoint(q, start, count);
				List<IncidentKpi> list = q.list();
				list.addAll(idList);
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IncidentKpi>) execute(action);
	}

}
