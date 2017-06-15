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

import com.deliverik.framework.asset.bl.task.CMDBConstants;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditWaitTaskSearchCond;
import com.deliverik.framework.asset.model.entity.AuditWaitTaskTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: ��ƴ���������DAOʵ��
  * ��������: ��ƴ���������DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class AuditWaitTaskDAOImpl extends
		BaseHibernateDAOImpl<AuditWaitTaskInfo> implements AuditWaitTaskDAO {

	/**
	 * ���캯��
	 */
	public AuditWaitTaskDAOImpl(){
		super(AuditWaitTaskTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditWaitTaskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("auwtid"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditWaitTaskInfo findByPK(Serializable pk) {
		AuditWaitTaskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AuditWaitTaskSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("auwtid"));
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
	public List<AuditWaitTaskInfo> findByCond(final AuditWaitTaskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AuditWaitTaskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�����Ƿ�������
		if(cond.isTaskError()) {
			c.add(Expression.gt("auwtstatus", CMDBConstants.TASK_STATUS_DONE));//�����
		} else {
			//����״̬�Ƿ����
			if(cond.isTaskDone()) {
				c.add(Expression.eq("auwtstatus", CMDBConstants.TASK_STATUS_DONE));//�����
			} else {
				c.add(Expression.lt("auwtstatus", CMDBConstants.TASK_STATUS_DONE));//δ���
			}
		}
		
		//ɾ����־
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		return c;
	}

}