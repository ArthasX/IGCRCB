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
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeTemplateSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTemplateTB;


/**
  * ����: ��Ϣʱ��ģ�嶨���DAOʵ��
  * ��������: ��Ϣʱ��ģ�嶨���DAOʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ProcessWorkTimeTemplateDAOImpl extends
		BaseHibernateDAOImpl<ProcessWorkTimeTemplateInfo> implements ProcessWorkTimeTemplateDAO {

	/**
	 * ���캯��
	 */
	public ProcessWorkTimeTemplateDAOImpl(){
		super(ProcessWorkTimeTemplateTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessWorkTimeTemplateInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProcessWorkTimeTemplateInfo findByPK(Serializable pk) {
		ProcessWorkTimeTemplateInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ProcessWorkTimeTemplateSearchCond cond){
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
	public List<ProcessWorkTimeTemplateInfo> findByCond(final ProcessWorkTimeTemplateSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pwtDate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ProcessWorkTimeTemplateSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getDate_like())){
			c.add(Expression.like("pwtDate", "%"+cond.getDate_like()+"%"));
		}
		return c;
	}

}