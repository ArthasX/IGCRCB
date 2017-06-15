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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;

/**
  * ����: �����鶨���DAOʵ��
  * ��������: �����鶨���DAOʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG480DAOImpl extends
		BaseHibernateDAOImpl<IG480Info> implements IG480DAO {
	private static String nextPgdid = "";
	/**
	 * ���캯��
	 */
	public IG480DAOImpl(){
		super(IG480TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<IG480Info> findAll() {
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
	public IG480Info findByPK(Serializable pk) {
		IG480Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG480SearchCond cond){
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
	public List<IG480Info> findByCond(final IG480SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);

		//������״̬
		if(StringUtils.isEmpty(cond.getPgdstatus())){
			c.addOrder(Order.asc("pgdid"));
		} else {
			c.addOrder(Order.desc("pgdid"));
		}
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG480SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�����鶨��ID
		if(StringUtils.isNotEmpty(cond.getPgdid_like())){
			c.add(Restrictions.like("pgdid", cond.getPgdid_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getPgddesc())){
			c.add(Restrictions.like("pgddesc", cond.getPgddesc()  + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getPgdname_like())){
			c.add(Restrictions.eq("pgdname", cond.getPgdname_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getPgdstatus())){
			c.add(Restrictions.eq("pgdstatus", cond.getPgdstatus()));
		}
		if(cond.getPtid()!=null&&cond.getPtid()>0){
			c.add(Restrictions.eq("ptid", cond.getPtid()));
		}
		return c;
	}
	
	/**
	 * PGDID����ֵȡ��
	 * @param pgdidģ���ʶ
	 * 
	 * @return PGDID����ֵ
	 */
	public String getPgdidSequenceNextValue(String firstsite,String pdsequence) {
		return StringUtils.leftPad(getSequenceNextValue(pdsequence) + "", IGPRDCONSTANTS.ID_PREFIX_LENGTH, firstsite)
				+ StringUtils.leftPad("1", IGPRDCONSTANTS.ID_VERSION_LENGTH, "0");
	}
	/**
	 * �����鶨�����洦��
	 * 
	 * @param pgdid ���̶���ID
	 */
	public void upgradeGroupProcessDefVersion(final String pgdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				SQLQuery q = session.createSQLQuery(
			//���ô洢����
			"{Call PRO_GROUPPROCESSDEFVERSION(?, ?, '0')}");
				q.setString(0, pgdid);
				q.setString(1, getPgdidUpgradeNextValue(pgdid));
				q.executeUpdate();
				session.clear();
				return null; 
			}
		};
		execute(action);
	}
	/**
	 * �����PGDID����ֵȡ��
	 * 
	 * @return �����PGDID����ֵ
	 */
	private static String getPgdidUpgradeNextValue(String pgdid) {
		return pgdid.substring(0, IGPRDCONSTANTS.ID_PREFIX_LENGTH)
		+ StringUtils.leftPad(Integer.parseInt(pgdid.substring(
				IGPRDCONSTANTS.ID_PREFIX_LENGTH, IGPRDCONSTANTS.ID_PREFIX_LENGTH + IGPRDCONSTANTS.ID_VERSION_LENGTH)) + 1 + "", 
				IGPRDCONSTANTS.ID_VERSION_LENGTH, "0");
	}
	/**
	 * �����鶨�帴�ƴ���
	 * 
	 * @param pgdid �����鶨��ID
	 * @param pdsequence ���ж���
	 */
	public String copyGroupProcessDefVersion(final String pgdid,final String pdsequence) {
		nextPgdid = getPgdidSequenceNextValue(new String(new char[]{pgdid.charAt(0)}),pdsequence);
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				
				SQLQuery q = session.createSQLQuery(
						"{Call PRO_GROUPPROCESSDEFVERSION(?, ?, ?)}");
				q.setString(0, pgdid);
				q.setString(1, nextPgdid);
				q.setString(2,"1"); 
				int i = q.executeUpdate();
				session.clear();  
				return i; 
			}
		};
		execute(action);
		//�����ɵ�pgdid 
		return nextPgdid; 
	}
}