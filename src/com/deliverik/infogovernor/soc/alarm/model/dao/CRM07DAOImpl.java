/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM07Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM07SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;

/**
  * ����: CRM07DAOʵ��
  * ��������: CRM07DAOʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CRM07DAOImpl extends
		BaseHibernateDAOImpl<CRM07Info> implements CRM07DAO {

	/**
	 * ���캯��
	 */
	public CRM07DAOImpl(){
		super(CRM07TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM07Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM07Info findByPK(Serializable pk) {
		CRM07Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM07SearchCond cond){
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
	public List<CRM07Info> findByCond(final CRM07SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CRM07SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRuletempid()!=null){
			c.add(Expression.eq("ruletempid", cond.getRuletempid()));
		}
		return c;
	}

}