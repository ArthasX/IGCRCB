/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0123SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;

/**
  * ����: �ʲ�ģ����ͼDAOʵ��
  * ��������: �ʲ�ģ����ͼDAOʵ��
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public class SOC0123DAOImpl extends
		BaseHibernateDAOImpl<SOC0123Info> implements SOC0123DAO {

	/**
	 * ���캯��
	 */
	public SOC0123DAOImpl(){
		super(SOC0123VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0123Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0123Info findByPK(Serializable pk) {
		SOC0123Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0123SearchCond cond){
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
	public List<SOC0123Info> findByCond(final SOC0123SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0123SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}