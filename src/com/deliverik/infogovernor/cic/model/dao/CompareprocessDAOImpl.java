/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareprocessSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareprocessTB;

/**
  * ����: �Աȼ�¼DAOʵ��
  * ��������: �Աȼ�¼DAOʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CompareprocessDAOImpl extends
		BaseHibernateDAOImpl<CompareprocessInfo> implements CompareprocessDAO {

	/**
	 * ���캯��
	 */
	public CompareprocessDAOImpl(){
		super(CompareprocessTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareprocessInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareprocessInfo findByPK(Serializable pk) {
		CompareprocessInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareprocessSearchCond cond){
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
	public List<CompareprocessInfo> findByCond(final CompareprocessSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CompareprocessSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// ��ʼʱ��Form 
		if (StringUtils.isNotEmpty(cond.getCpstarttime_form())) {
		    c.add(Restrictions.ge("cpstarttime", cond.getCpstarttime_form() + " 00:00"));
		}
		
		// ��ʼʱ��To
		if (StringUtils.isNotEmpty(cond.getCpstarttime_to())) {
		    c.add(Restrictions.le("cpstarttime", cond.getCpstarttime_to() + " 23:59"));
		}
		
		return c;
	}

}