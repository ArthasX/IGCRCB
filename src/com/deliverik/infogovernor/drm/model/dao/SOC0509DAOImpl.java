/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.SOC0509Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0509SearchCond;
import com.deliverik.infogovernor.drm.model.entity.SOC0509TB;

/**
  * ����: Ԥ���½���ϢDAOʵ��
  * ��������: Ԥ���½���ϢDAOʵ��
  * ������¼: 2016/07/07
  * �޸ļ�¼: 
  */
public class SOC0509DAOImpl extends
		BaseHibernateDAOImpl<SOC0509Info> implements SOC0509DAO {

	/**
	 * ���캯��
	 */
	public SOC0509DAOImpl(){
		super(SOC0509TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0509Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0509Info findByPK(Serializable pk) {
		SOC0509Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0509SearchCond cond){
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
	public List<SOC0509Info> findByCond(final SOC0509SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(cond.getEsyscodingList() != null && !cond.getEsyscodingList().isEmpty()){
			c.addOrder(Order.asc("cid"));
		} else if (StringUtils.isNotBlank(cond.getPcid()) || StringUtils.isNotBlank(cond.getEsyscoding())){
			// Ĭ�ϰ������ֶν�������
			c.addOrder(Order.asc("corder"));
		} else {
			c.addOrder(Order.desc("cid"));
		}
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0509SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�����
		if(StringUtils.isNotEmpty(cond.getEsyscoding_like())){
			c.add(Restrictions.like("esyscoding", cond.getEsyscoding_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getCname())){
			c.add(Restrictions.like("cname", "%" + cond.getCname() + "%"));
		}
		//�����in
		if(cond.getEsyscodingList() != null && !cond.getEsyscodingList().isEmpty()){
			c.add(Restrictions.in("esyscoding", cond.getEsyscodingList()));
		}
		// ��PCID��ѯ
		if(StringUtils.isNotEmpty(cond.getPcid())){
			c.add(Restrictions.eq("pcid", cond.getPcid()));
		}
		//��EID��ѯ
		if(StringUtils.isNotEmpty(cond.getEid())){
			c.add(Restrictions.eq("eid", cond.getEid()));
		}
		//��������ѯ
		if(StringUtils.isNotBlank(cond.getEsyscoding())){
			c.add(Restrictions.eq("esyscoding", cond.getEsyscoding()));
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public Integer getNextCorder() {
		Session session = getSession();
		String query = "SELECT MAX(corder) FROM soc0509";
		SQLQuery q = session.createSQLQuery(query);
		List<Integer> rt = q.list();
		if(null != rt && rt.size() > 0 && null != rt.get(0)){
			return ((Number)rt.get(0)).intValue() + 1;
		}
		else{
			return 1;
		}
	}

}