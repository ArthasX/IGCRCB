/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG481TB;

/**
  * ����: �������Ա��DAOʵ��
  * ��������: �������Ա��DAOʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("unchecked")
public class IG481DAOImpl extends
		BaseHibernateDAOImpl<IG481Info> implements IG481DAO {

	/**
	 * ���캯��
	 */
	public IG481DAOImpl(){
		super(IG481TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<IG481Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	@Override
	public IG481Info findByPK(Serializable pk) {
		IG481Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG481SearchCond cond){
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
	public List<IG481Info> findByCond(final IG481SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
	
		return findByCriteria(c, start, count);
	}
	
	/**
	 * ��������ɾ��
	 * @param cond
	 */
	public void deleteByCond(final IG481SearchCond cond){
		
		delete(this.findByCond(cond, 0, 0));
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG481SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getCreateType())){
			c.add(Restrictions.eq("createType", cond.getCreateType()));
		}
		if(StringUtils.isNotEmpty(cond.getPgdid())){
			c.add(Restrictions.eq("pgdid", cond.getPgdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Restrictions.eq("pdid", cond.getPdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPdid_like())){
			c.add(Restrictions.like("pdid", cond.getPdid_like()+"%"));
		}
		if(cond.getPdids_in()!=null&& cond.getPdids_in().length>0){
			c.add(Restrictions.in("pdid",cond.getPdids_in()));
		}
		return c;
	}
	
	/**
	 * �������̶���ID��ѯ�鶨���б�
	 * @param pdid ���̶���ID
	 * @return �鶨���б�
	 */
	public List<IG480Info> searchIG480(final String pdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append("select a.* from ig480 a ");
				query.append("inner join ig481 b on (a.pgdid = b.pgdid) ");
				query.append("where b.pdid = :pdid");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("pdid", pdid);
				q.addEntity(IG480TB.class);
				List<IG480Info> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<IG480Info>)execute(action);
	}

}