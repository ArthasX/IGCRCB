/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0419Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0419SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0419TB;

/**
  * ����: ��������ʵʱ��DAOʵ��
  * ��������: ��������ʵʱ��DAOʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��VGCapacityRealTimeDAOImpl�����޸�ΪSOC0419DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0419DAOImpl extends
		BaseHibernateDAOImpl<SOC0419Info> implements SOC0419DAO {

	/**
	 * ���캯��
	 */
	public SOC0419DAOImpl(){
		super(SOC0419TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0419Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0419Info findByPK(Serializable pk) {
		SOC0419Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0419SearchCond cond){
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
	public List<SOC0419Info> findByCond(final SOC0419SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0419SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getHostName_eq())) {
			c.add(Expression.eq("hostName", cond.getHostName_eq()));
		}
		return c;
	}

}