/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM02Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM02SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM02TB;

/**
  * ����: CRM02DAOʵ��
  * ��������: CRM02DAOʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CRM02DAOImpl extends
		BaseHibernateDAOImpl<CRM02Info> implements CRM02DAO {

	/**
	 * ���캯��
	 */
	public CRM02DAOImpl(){
		super(CRM02TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM02Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM02Info findByPK(Serializable pk) {
		CRM02Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM02SearchCond cond){
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
	public List<CRM02Info> findByCond(final CRM02SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CRM02SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}