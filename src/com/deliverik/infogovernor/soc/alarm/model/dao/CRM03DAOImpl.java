/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM03Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM03SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM03TB;

/**
  * ����: CRM03DAOʵ��
  * ��������: CRM03DAOʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CRM03DAOImpl extends
		BaseHibernateDAOImpl<CRM03Info> implements CRM03DAO {

	/**
	 * ���캯��
	 */
	public CRM03DAOImpl(){
		super(CRM03TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM03Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM03Info findByPK(Serializable pk) {
		CRM03Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM03SearchCond cond){
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
	public List<CRM03Info> findByCond(final CRM03SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CRM03SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}