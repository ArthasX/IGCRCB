/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * ������Ӧ����Ա��λ��DAOʵ��
 * ����������Ӧ����Ա��λ��DAOʵ��
 * ������¼��2014/05/19
 */
public class ParentNodeDAOImpl extends BaseHibernateDAOImpl<Object> implements ParentNodeDAO {
	/**
	 * ���캯��
	 */
	public ParentNodeDAOImpl(){
		super();
	}

	/**
	 * ��������id ��ѯ��ǰ�ڵ���Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchParentNodes(String psdid) {
		
		Session session = getSession();
		String sql = "select p.psdid,p.psdname from ig.ig333 c left join ig.ig333 p on c.ppsdid = p.psdid where c.ppsdid is not null";
		sql+= "  and c.psdid = '"+psdid+"'";
		SQLQuery q = session.createSQLQuery(sql);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		q.addScalar("psdid",Hibernate.STRING) ;
		q.addScalar("psdname",Hibernate.STRING) ;
		
		
		return q.list();
	}
	
}