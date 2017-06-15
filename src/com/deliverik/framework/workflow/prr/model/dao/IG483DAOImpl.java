/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
  * ����: ������ʵ����DAOʵ��
  * ��������: ������ʵ����DAOʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("unchecked")
public class IG483DAOImpl extends
		BaseHibernateDAOImpl<IG483Info> implements IG483DAO {

	/**
	 * ���캯��
	 */
	public IG483DAOImpl(){
		super(IG483TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG483Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG483Info findByPK(Serializable pk) {
		IG483Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG483SearchCond cond){
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
	public List<IG483Info> findByCond(final IG483SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getOrder())){
			if("ASC".equals(cond.getSing())){
				c.addOrder(Order.asc(cond.getOrder()));
			}else{
				c.addOrder(Order.desc(cond.getOrder()));	
			}
		}else{
			c.addOrder(Order.desc("pgrclosetime"));
			c.addOrder(Order.asc("pgropentime"));
			c.addOrder(Order.asc("pgrserialnum"));
		}
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG483SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�����鷢��ʱ�俪ʼ
		if(StringUtils.isNotEmpty(cond.getPgropentime_begin())){
			c.add(Restrictions.ge("pgropentime", cond.getPgropentime_begin()));
		}
		//�����鷢��ʱ�俪ʼ
		if(StringUtils.isNotEmpty(cond.getPgropentime_end())){
			c.add(Restrictions.le("pgropentime", cond.getPgropentime_end() + " 23:59"));
		}
		// ���������к�
		if(StringUtils.isNotEmpty(cond.getPgrserialnum_like())){
			c.add(Restrictions.like("pgrserialnum", "%" + cond.getPgrserialnum_like() + "%"));
		}
		// �����鷢��������
		if(StringUtils.isNotEmpty(cond.getPgrusername_like())){
			c.add(Restrictions.like("pgrusername", "%" + cond.getPgrusername_like() + "%"));
		}
		// ���������
		if(StringUtils.isNotEmpty(cond.getPgrtitle_like())){
			c.add(Restrictions.like("pgrtitle", "%" + cond.getPgrtitle_like() + "%"));
		}
		// ����ģ������
		if(StringUtils.isNotEmpty(cond.getPttype())){
			c.add(Restrictions.eq("pttype", cond.getPttype()));
		}
		// �Ƿ��������
		if(StringUtils.isNotEmpty(cond.getIstest())){
			c.add(Restrictions.eq("istest", cond.getIstest()));
		}
		// �����鶨��ID
		if(StringUtils.isNotEmpty(cond.getPgdid())){
			c.add(Restrictions.eq("pgdid", cond.getPgdid()));
		}
		// �Ƿ�ر�
		if(cond.isActive()){
			c.add(Restrictions.isNull("pgrclosetime"));
		}
		return c;
	}
	
	/**
	 * ��ѯ��ǰĬ�������ˮ�ţ�WG+2λ��+6λ��ˮ��
	 * @param pgrserialnum ��ˮ��
	 * @return �����ˮ��
	 */
	@SuppressWarnings("rawtypes")
	public String getMaxPgrserialnum(String pgrserialnum){
		
		String sql =  "select max(prg.pgrserialnum) from IG483TB prg where prg.pgrserialnum like :pgrserialnum";
		NamedParamMap p = getNamedParamMap();
		p.setString("pgrserialnum", pgrserialnum+"%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}
	
	/**
	 * ��ѯ�������Ա�б�
	 * @param pgrid ������ID
	 * @return �������Ա�б�
	 */
	public List<IG500Info> searchProcess(final Integer pgrid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append("select a.* from ig500 a ");
				query.append("inner join ig484 b on (a.prid = b.prid) ");
				query.append("where b.pgrid = :pgrid order by a.prclosetime desc, a.propentime asc, a.prserialnum");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("pgrid", pgrid);
				q.addEntity(IG500TB.class);
				List<IG485VW> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<IG500Info>)execute(action);
	}
	
	/**
	 * ��ѯ�������ⷢ�������prid
	 * @param pgrid ��������-������ʵ��ID
	 */
	public List<Map<String,Object>> searchProcessInfoByCond(final int pgrid) {
		
		Session session = getSession();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select a.prid as prid from ig484 a ");
		sql.append("inner join ig483 b on  b.pgrid = a.pgrid ");
		sql.append("inner join ig481 c on  c.pgdid = b.pgdid and c.pdid= a.pdid and c.createtype = '0' ");
		sql.append("where a.pgrid=:pgrid ");
		SQLQuery q = session.createSQLQuery(sql.toString());
		q.setInteger("pgrid", pgrid);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("PRID", Hibernate.STRING);
		return q.list();
	  }
}