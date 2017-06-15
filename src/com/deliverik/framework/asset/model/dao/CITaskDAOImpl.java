/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.condition.CITaskSearchCond;
import com.deliverik.framework.asset.model.entity.CITaskTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: ���������DAOʵ��
  * ��������: ��������DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CITaskDAOImpl extends
		BaseHibernateDAOImpl<CITaskInfo> implements CITaskDAO {

	/**
	 * ���캯��
	 */
	public CITaskDAOImpl(){
		super(CITaskTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CITaskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CITaskInfo findByPK(Serializable pk) {
		CITaskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CITaskSearchCond cond){
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
	public List<CITaskInfo> findByCond(final CITaskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("cittime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CITaskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�����������
		if (StringUtils.isNotEmpty(cond.getCitdesc_like())) {
			c.add(Expression.like("citdesc", "%" + cond.getCitdesc_like() + "%"));
		}
		//״̬
		if (StringUtils.isNotEmpty(cond.getCitstatus_eq())) {
			c.add(Expression.eq("citstatus", cond.getCitstatus_eq()));
		}
		return c;
	}

}