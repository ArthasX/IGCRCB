/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeStatisticsVW;

/**
 * ����: ֪ʶ��ͳ��DAOʵ��
 * ����������֪ʶ��ͳ��DAOʵ��
 * ������¼��wanglei 2014/3/13
 * �޸ļ�¼��
 */
public class KnowLedgeStatisticsDAOImpl extends BaseHibernateDAOImpl<KnowLedgeInfo>
		implements KnowLedgeStatisticsDAO {
	/**
	 * ���캯��
	 */
	public KnowLedgeStatisticsDAOImpl() {
		super(KnowledgeStatisticsVW.class);
	}

	/**
	 * ������������(��������)
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<KnowledgeStatisticsInfo> findByKnprofferCond(final KnowledgeStatisticsSearchCond cond,
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select row_number( ) over(order by a.klscount)  as klsid,klscount,knproffer,knproffername,knclass,knclassname ");
				query.append("from ( ");
				query.append("select count(k.knproffer) as klscount,k.knproffer,k.knproffername,null as knclass,null as knclassname ");
				query.append("from ( ");
				query.append("select knid,knproffer,knproffername,knclass,knclassname from Knowledge where knstatus = '1'  ");
				query.append("group by knid,knproffer,knproffername,knclass,knclassname )k ");
				query.append("group by k.knproffer,k.knproffername) a");
//				StringBuffer sql = getCriteria(cond);
//				query.append(sql);
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.setProperties(cond);
				q.addEntity("KnowledgeStatisticsVW",KnowledgeStatisticsVW.class);
				
				setFetchPoint(q, start, count);
				List<KnowledgeStatisticsInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<KnowledgeStatisticsInfo>) execute(action);
	}
	
	/**
	 * ������������(������)
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<KnowledgeStatisticsInfo> findByKnclassCond(final KnowledgeStatisticsSearchCond cond,
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select row_number( ) over(order by a.klscount) as klsid,klscount,knproffer,knproffername,knclass,knclassname ");
				query.append("from ( ");
				query.append("select count(k.knclass) as klscount,null as knproffer,null as knproffername,k.knclass,k.knclassname ");
				query.append("from ( ");
				query.append("select knid,knproffer,knproffername,knclass,knclassname from Knowledge where knstatus = '1' ");
				query.append("group by knid,knproffer,knproffername,knclass,knclassname )k ");
				query.append("group by k.knclass,k.knclassname)a");
//				StringBuffer sql = getCriteria(cond);
//				query.append(sql);
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.setProperties(cond);
				q.addEntity("KnowledgeStatisticsVW",KnowledgeStatisticsVW.class);
				
				setFetchPoint(q, start, count);
				List<KnowledgeStatisticsInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<KnowledgeStatisticsInfo>) execute(action);
	}
	
	/**
	 * Լ������sqlƴд
	 * @param cond
	 * @return StringBuffer
	 */
	protected StringBuffer getCriteria(KnowledgeStatisticsSearchCond cond) {
		StringBuffer sql = new StringBuffer();
		
//		if(StringUtils.isNotEmpty(cond.getKnclass())){
//			sql.append(" and Upper(j.knclass)= Upper(:knclass)");
//		}
		return sql;
	}
}
