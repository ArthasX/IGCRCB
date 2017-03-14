/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
  * ����: ����ģ��DAOʵ��
  * ��������: ����ģ��DAOʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateDAOImpl�����޸�ΪSOC0207DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0207DAOImpl extends
		BaseHibernateDAOImpl<SOC0207Info> implements SOC0207DAO {

	/**
	 * ���캯��
	 */
	public SOC0207DAOImpl(){
		super(SOC0207TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0207Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0207Info findByPK(Serializable pk) {
		SOC0207Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0207SearchCond cond){
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
	public List<SOC0207Info> findByCond(final SOC0207SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rtId"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0207SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getRtname_like())) {
			c.add(Expression.like("rtName", "%"+cond.getRtname_like()+"%"));			
		}
		if (!StringUtils.isEmpty(cond.getRtdatetype_eq())) {
			c.add(Expression.eq("rtDateType", cond.getRtdatetype_eq()));
		}
		return c;
	}

}