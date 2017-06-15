/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * �������Զ����ѯͨ��DAO �����������Զ����ѯͨ��DAO ������¼��2014/05/19
 */
@SuppressWarnings("rawtypes")
public class CustomQueryDAOImpl extends BaseHibernateDAOImpl implements CustomQueryDAO {

	

	public List<Map<String, Object>> queryBySql(String sql, Map<String, Type> resultField) {
		Session session = getSession();
		SQLQuery q = session.createSQLQuery(sql);

		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		for (Iterator<String> it = resultField.keySet().iterator(); it.hasNext();) {
			String key = it.next();

			q.addScalar(key, resultField.get(key));

		}
		return q.list();
	}

}