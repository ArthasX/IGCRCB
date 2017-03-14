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
import com.deliverik.infogovernor.rpt.model.SOC0415Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0415SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0415TB;

/**
  * ����: ��ռ�����ʵʱ��DAOʵ��
  * ��������: ��ռ�����ʵʱ��DAOʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��TSCapacityRealTimeDAOImpl�����޸�ΪSOC0415DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0415DAOImpl extends
		BaseHibernateDAOImpl<SOC0415Info> implements SOC0415DAO {

	/**
	 * ���캯��
	 */
	public SOC0415DAOImpl(){
		super(SOC0415TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0415Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0415Info findByPK(Serializable pk) {
		SOC0415Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0415SearchCond cond){
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
	public List<SOC0415Info> findByCond(final SOC0415SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0415SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getHostName_eq())) {
			c.add(Expression.eq("hostName", cond.getHostName_eq()));
		}
		if (!StringUtils.isEmpty(cond.getDbName_eq())) {
			c.add(Expression.eq("dbName", cond.getDbName_eq()));
		}
		return c;
	}

}