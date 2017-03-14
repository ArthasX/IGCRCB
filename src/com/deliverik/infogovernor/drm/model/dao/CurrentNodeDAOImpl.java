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
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ��������ǰ�ڵ���ϢDAO�ӿ�
 * ������������ǰ�ڵ���ϢDAO�ӿ�
 * ������¼��2014/05/19
 */
public class CurrentNodeDAOImpl extends HibernateDaoSupport implements CurrentNodeDAO{

	/**
	 * ��������id ��ѯ��ǰ�ڵ���Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchCurrentNodes(Integer prid) {
		
		Session session = getSession();
		String sql = "select a.psdid ,a.rslopentime,a.prid,c.psdname,c.ppsdid,b.notifym  ,d.psdname as ppsdname from ig224 a left join ig335 b on  a.psdid = b.psdid left join ig333 c on a.psdid = c.psdid left join ig333 d on d.psdid = c.ppsdid where a.virtualstatus = '0' and  a.prtype = 'WDP' and (a.rslclosetime is null or a.prstatus in ('C','#'))";
		sql+= "  and a.prid = "+prid;
		SQLQuery q = session.createSQLQuery(sql);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("psdid",Hibernate.STRING) ;
		q.addScalar("rslopentime",Hibernate.TIMESTAMP) ;
		q.addScalar("prid",Hibernate.STRING) ;
		q.addScalar("notifym",Hibernate.INTEGER) ;
		q.addScalar("ppsdid",Hibernate.STRING) ;
		q.addScalar("psdname",Hibernate.STRING) ;
		q.addScalar("ppsdname",Hibernate.STRING) ;
		return q.list();
	}
	
	
	/**
	 * ��������id ��ѯ���нڵ���Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchAllNodes(Integer prid,String psdid) {
		
		Session session = getSession();
		String sql = "select a.psdid psdid,a.psdname psdname,b.RSLCLOSETIME factstoptime, b.rslopentime expectstarttime,b.rslopentime factstarttime,a.FINGERPRINT afternode,a.psdcode psdcode,a.bysequence expectusetime from ig333 a left join ig224 b on a.PSDID = b.psdid where 1=1";
		sql+= "  and b.prid = "+prid;
		sql+=" and a.psdid = " +psdid;
		SQLQuery q = session.createSQLQuery(sql);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("psdid",Hibernate.STRING) ;
		q.addScalar("psdname",Hibernate.STRING) ;
		q.addScalar("expectstarttime",Hibernate.TIMESTAMP) ;
		q.addScalar("factstarttime",Hibernate.TIMESTAMP) ;
		q.addScalar("afternode",Hibernate.STRING) ;
		q.addScalar("psdcode",Hibernate.STRING) ;
		q.addScalar("expectusetime",Hibernate.STRING) ;
		q.addScalar("factstoptime",Hibernate.TIMESTAMP) ;
		return q.list();
	}
	
}