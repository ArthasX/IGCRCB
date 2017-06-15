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
import com.deliverik.infogovernor.rpt.model.SOC0424Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0424SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0424TB;

/**
  * ����: �������ͱ�DAOʵ��
  * ��������: �������ͱ�DAOʵ��
  * ������¼: 2012/07/18
  * �޸ļ�¼: 2012/08/10 ��ReportTypeDAOImpl�����޸�ΪSOC0424DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0424DAOImpl extends
		BaseHibernateDAOImpl<SOC0424Info> implements SOC0424DAO {

	/**
	 * ���캯��
	 */
	public SOC0424DAOImpl(){
		super(SOC0424TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0424Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0424Info findByPK(Serializable pk) {
		SOC0424Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0424SearchCond cond){
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
	public List<SOC0424Info> findByCond(final SOC0424SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0424SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getReportName_eq())) {
			c.add(Expression.eq("reportName", cond.getReportName_eq()));			
		}
		if (!StringUtils.isEmpty(cond.getStorageType_eq())) {
			c.add(Expression.eq("storageType", cond.getStorageType_eq()));			
		}
		if (!StringUtils.isEmpty(cond.getRtType_eq())) {
			c.add(Expression.eq("rtType", cond.getRtType_eq()));			
		}
		return c;
	}

}