/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ͨ�ò�ѯʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ProcessQueryDAOImpl extends HibernateDaoSupport implements ProcessQueryDAO{

	/**
	 * ȡ�ò�ѯ����
	 * @param sql ִ��sql
	 * @return ��ѯ����
	 */
	public int getSearchCount(String sql) {
		//ȡ��session
		Session session = this.getSession();
		session.flush();
		StringBuffer query = new StringBuffer();
//		query.append(" select count(1) from ( ");
		query.append(sql);
//		query.append(") ");
		SQLQuery q = session.createSQLQuery(query.toString());
//		Integer count = ((Number)q.list().get(0)).intValue();
		Integer count = q.list().size();
		session.clear();
		return count;
	}
	
	/**
	 * ���̲�ѯ����
	 * @param sql ִ��sql
	 * @param start ��ʼҳ��
	 * @param count ��ʾ����
	 * @return ������Ϣ����
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> searchProcessRecordInfo(String sql, int start, int count) {
		//ȡ��session
		Session session = this.getSession();
		session.flush();
		StringBuffer sb = new StringBuffer(sql);
		if(start >= 0){
			sb.append(" and rownum > " +start);
//			
//			q.setFirstResult(start);
		}
		if(count > 0){
			sb.append(" and rownum <= "+(start+count) );
//			q.setMaxResults(count);
		}
		SQLQuery q = session.createSQLQuery(sb.toString());
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> list = q.list();
		session.clear();
		return list;
	}
}
