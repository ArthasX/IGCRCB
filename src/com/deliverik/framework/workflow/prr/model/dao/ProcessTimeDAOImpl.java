/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessTimeTB;


/**
  * ����: ���̼�ʱ��DAOʵ��
  * ��������: ���̼�ʱ��DAOʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ProcessTimeDAOImpl extends
		BaseHibernateDAOImpl<ProcessTimeInfo> implements ProcessTimeDAO {

	/**
	 * ���캯��
	 */
	public ProcessTimeDAOImpl(){
		super(ProcessTimeTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessTimeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProcessTimeInfo findByPK(Serializable pk) {
		ProcessTimeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ProcessTimeSearchCond cond){
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
	public List<ProcessTimeInfo> findByCond(final ProcessTimeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("prtstartTime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ProcessTimeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid()!=null){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(StringUtils.isNotEmpty(cond.getUserId())){
			c.add(Expression.eq("userid", cond.getUserId()));
		}
		if(StringUtils.isNotEmpty(cond.getPrtstartTime_le())){
			c.add(Expression.le("prtstartTime", cond.getPrtstartTime_le()));
		}
		if(StringUtils.isNotEmpty(cond.getPrtEndTime_ge())){
			c.add(Expression.ge("prtEndTime", cond.getPrtEndTime_ge()));
		}
		return c;
	}
}