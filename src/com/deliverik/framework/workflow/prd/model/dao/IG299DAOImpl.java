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
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG299TB;

/**
  * ����: ״̬�ɷ��ɻ��������DAOʵ��
  * ��������: ״̬�ɷ��ɻ��������DAOʵ��
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG299DAOImpl extends
		BaseHibernateDAOImpl<IG299Info> implements IG299DAO {

	/**
	 * ���캯��
	 */
	public IG299DAOImpl(){
		super(IG299TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG299Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG299Info findByPK(Serializable pk) {
		IG299Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG299SearchCond cond){
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
	public List<IG299Info> findByCond(final IG299SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG299SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		// ״̬�ڵ�
		if(StringUtils.isNotEmpty(cond.getPsdid_eq())){
			c.add(Expression.eq("psdid", cond.getPsdid_eq()));
		}
		// ����״̬�ڵ�ָ���ɷ��ɻ�������ģ����ѯ
		if(StringUtils.isNotEmpty(cond.getPsodid_like())){
			c.add(Expression.eq("psodid", cond.getPsodid_like()));
		}
		// ����״̬�ڵ�ָ���ɷ��ɻ����뾫ȷ��ѯ
		if(StringUtils.isNotEmpty(cond.getOrgsyscoding_eq())){
			c.add(Expression.eq("orgsyscoding", cond.getOrgsyscoding_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getPsdid_like())){
			c.add(Expression.like("psdid", cond.getPsdid_like()+"%"));
		}
		return c;
	}

	/**
	 * PSODID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSODID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String getPsrdidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(psod.psodid) FROM IG299TB psod WHERE psod.psodid LIKE :psdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("psdid", psdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return psdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return psdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(psdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}
	
	/**
	 * �ɱ����ɵĽ�ɫ��������
	 * @param pdid ��������ID
	 * @param levellen �����ĵ�ǰ����
	 * @param psdid ����״̬�ڵ�ID
	 * @return �ɱ����ɵĽ�ɫ�б�
	 */
	@SuppressWarnings("unchecked")
	public List<Organization> searchToBeAssignOrg(final String pdid, final int levellen, final String psdid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG299DAO.searchToBeAssignOrg").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("pdid", pdid);
				q.setInteger("levellen", levellen);
				q.setString("psdid", psdid);
				q.addEntity("org",OrganizationTB.class);
				setFetchPoint(q, 0, 0);
				List<Organization> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<Organization>) execute(action);
	}
	
}