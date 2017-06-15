/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0116Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0116SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0116TB;

/**
  * ����: EiWaitTaskTempDAOʵ��
  * ��������: EiWaitTaskTempDAOʵ��
  * ������¼: 2012/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0116DAOImpl extends
		BaseHibernateDAOImpl<SOC0116Info> implements SOC0116DAO {

	/**
	 * ���캯��
	 */
	public SOC0116DAOImpl(){
		super(SOC0116TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0116Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0116Info findByPK(Serializable pk) {
		SOC0116Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0116SearchCond cond){
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
	public List<SOC0116Info> findByCond(final SOC0116SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0116SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}