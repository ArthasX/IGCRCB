/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectHistorySearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectHistoryTB;

/**
  * ����: �Աȶ�����ʷ��DAOʵ��
  * ��������: �Աȶ�����ʷ��DAOʵ��
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CompareobjectHistoryDAOImpl extends
		BaseHibernateDAOImpl<CompareobjectHistoryInfo> implements CompareobjectHistoryDAO {

	/**
	 * ���캯��
	 */
	public CompareobjectHistoryDAOImpl(){
		super(CompareobjectHistoryTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<CompareobjectHistoryInfo> findAll() {
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
	public CompareobjectHistoryInfo findByPK(Serializable pk) {
		CompareobjectHistoryInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareobjectHistorySearchCond cond){
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
	public List<CompareobjectHistoryInfo> findByCond(final CompareobjectHistorySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CompareobjectHistorySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (null != cond.getFkCrid_eq()) {
		    c.add(Restrictions.eq("fkCrid", cond.getFkCrid_eq()));
		}
		
		if (null != cond.getCrversion_eq()) {
		    c.add(Restrictions.eq("crversion", cond.getCrversion_eq()));
		}
		if(null!=cond.getCoid_eq()){
			c.add(Restrictions.eq("coid", cond.getCoid_eq()));
		}
		return c;
	}

}