/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG485Info;
import com.deliverik.framework.workflow.prr.model.condition.IG485SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;

/**
  * ����: �����������ϵʵ����DAOʵ��
  * ��������: �����������ϵʵ����DAOʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("unchecked")
public class IG485DAOImpl extends BaseHibernateDAOImpl<IG485Info> implements IG485DAO {

	/**
	 * ���캯��
	 */
	public IG485DAOImpl(){
		super(IG485TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG485Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG485Info findByPK(Serializable pk) {
		IG485Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG485SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG485Info> findByCond(final IG485SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG485SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�ο�����ID
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		//״̬
		if(StringUtils.isNotEmpty(cond.getPgrrstatus())){
			c.add(Restrictions.eq("pgrrstatus", cond.getPgrrstatus()));
		}
		return c;
	}
	
	/**
	 * ����ָ�����̺�״̬����ѯ�������ϵʵ�����У�
	 * �����̵Ĳο����̺Ͳο�״̬�ļ�¼
	 * @param pgrid ������ID
	 * @param pgdid �����鶨��ID
	 * @param ipsdid Ӱ��״̬ID
	 * @return �ο������б�
	 */
	public List<Object[]> checkPend(final Integer pgrid, final String pgdid, final String ipsdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append("select a.rpsdid, b.pgrrstatus from ig482 a ");
				query.append("left outer join ig485 b on (a.pgreid = b.pgreid and b.pgrid = :pgrid) ");
				query.append("where a.ipsdid = :ipsdid and a.pgdid = :pgdid");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("pgrid", pgrid);
				q.setString("pgdid", pgdid);
				q.setString("ipsdid", ipsdid);
				q.addScalar("rpsdid", Hibernate.STRING).addScalar("pgrrstatus", Hibernate.STRING); 
				List<Object[]> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<Object[]>)execute(action);
	}
	
	/**
	 * ����ָ���������״̬����ѯ״̬��صĹ��������У�
	 * @param pgrid ������ʵ��ID
	 * @param ipsdid Ӱ��״̬ID
	 * @return Ӱ����searchPendPrid��ID�б�
	 */
	public List<IG224VW> searchPendPrid(final Integer pgrid, final String ipsdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append("select c.prid,c.pendpsdid,c.pendpsdnum,c.psdid,c.psdnum,c.rslid from ig483 a ");
				query.append("inner join ig484 b on (a.pgrid = b.pgrid) ");
				query.append("inner join ig591 c on (b.prid = c.PRID and c.PSDID = :ipsdid and c.PEND = '0') ");
				query.append("where a.pgrid = :pgrid");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("pgrid", pgrid);
				q.setString("ipsdid", ipsdid);
				q.addEntity(IG224VW.class);
				List<IG224VW> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<IG224VW>)execute(action);
	}
	
	/**
	 * ��ѯ������ϵʵ��δ�����¼
	 * @param prid �ο�����ID
	 * @param rpsdid �ο�����״̬ID
	 * @return δ�����¼
	 */
	public List<IG485VW> searchNotDone(final Integer prid, final String rpsdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append("select a.*, b.rtpsdid, b.ipsdid, b.transferhandler, b.ipdid from ig485 a ");
				query.append("inner join ig482 b on (a.pgreid = b.pgreid) ");
				query.append("where a.prid = :prid and a.pgrrstatus = '0' and b.rpsdid = :rpsdid");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("prid", prid);
				q.setString("rpsdid", rpsdid);
				q.addEntity(IG485VW.class);
				List<IG485VW> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<IG485VW>)execute(action);
	}
	
}