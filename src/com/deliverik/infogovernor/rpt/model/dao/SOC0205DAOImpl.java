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
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0205TB;

/**
  * ����: ��������DAOʵ��
  * ��������: ��������DAOʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportManageDAOImpl�����޸�ΪSOC0205DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0205DAOImpl extends
		BaseHibernateDAOImpl<SOC0205Info> implements SOC0205DAO {

	/**
	 * ���캯��
	 */
	public SOC0205DAOImpl(){
		super(SOC0205TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0205Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0205Info findByPK(Serializable pk) {
		SOC0205Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0205SearchCond cond){
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
	public List<SOC0205Info> findByCond(final SOC0205SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rmId"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0205SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getRmName_like())){			
			c.add(Expression.like("rmName","%"+cond.getRmName_like()+"%"));
		}
		if(!StringUtils.isEmpty(cond.getRtdatetype_eq())){			
			c.add(Expression.eq("rmDateType",cond.getRtdatetype_eq()));
		}
		if(!StringUtils.isEmpty(cond.getDateFrom())){
			c.add(Expression.ge("rmLastDay",cond.getDateFrom()));
		}
		if(!StringUtils.isEmpty(cond.getDateTo())){
			c.add(Expression.le("rmLastDay",cond.getDateTo()));
		}
		return c;
	}

}