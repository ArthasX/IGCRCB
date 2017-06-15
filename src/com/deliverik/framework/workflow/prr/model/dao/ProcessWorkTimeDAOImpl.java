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
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTB;


/**
  * ����: �û���Ϣʱ�䶨���DAOʵ��
  * ��������: �û���Ϣʱ�䶨���DAOʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ProcessWorkTimeDAOImpl extends
		BaseHibernateDAOImpl<ProcessWorkTimeInfo> implements ProcessWorkTimeDAO {

	/**
	 * ���캯��
	 */
	public ProcessWorkTimeDAOImpl(){
		super(ProcessWorkTimeTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessWorkTimeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProcessWorkTimeInfo findByPK(Serializable pk) {
		ProcessWorkTimeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ProcessWorkTimeSearchCond cond){
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
	public List<ProcessWorkTimeInfo> findByCond(final ProcessWorkTimeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pwDate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ProcessWorkTimeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(StringUtils.isNotEmpty(cond.getStartDate())){
			c.add(Expression.ge("pwDate", cond.getStartDate()));
		}
		if(StringUtils.isNotEmpty(cond.getEndDate())){
			c.add(Expression.le("pwDate", cond.getEndDate()));
		}
		if(StringUtils.isNotEmpty(cond.getPwDate())){
			c.add(Expression.eq("pwDate", cond.getPwDate()));
		}
		if(StringUtils.isNotEmpty(cond.getPwFlg())){
			c.add(Expression.eq("pwFlg", cond.getPwFlg()));
		}
		if(StringUtils.isNotEmpty(cond.getPwDate_like())){
			c.add(Expression.like("pwDate", "%"+cond.getPwDate_like()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getUserId())){
			c.add(Expression.eq("userId", cond.getUserId()));
		}
		return c;
	}

}