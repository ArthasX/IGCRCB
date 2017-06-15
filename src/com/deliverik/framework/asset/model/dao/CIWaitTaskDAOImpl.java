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
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.CIWaitTaskSearchCond;
import com.deliverik.framework.asset.model.entity.CIWaitTaskTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: CI�������������DAOʵ��
  * ��������: CI�������������DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CIWaitTaskDAOImpl extends
		BaseHibernateDAOImpl<CIWaitTaskInfo> implements CIWaitTaskDAO {

	/**
	 * ���캯��
	 */
	public CIWaitTaskDAOImpl(){
		super(CIWaitTaskTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIWaitTaskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("ciwtid"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIWaitTaskInfo findByPK(Serializable pk) {
		CIWaitTaskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CIWaitTaskSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("ciwtid"));
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
	public List<CIWaitTaskInfo> findByCond(final CIWaitTaskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CIWaitTaskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�����Ƿ�������
		if(cond.isTaskError()) {
			c.add(Expression.gt("ciwtstatus", CMDBConstants.TASK_STATUS_DONE));//�����
		} else {
			//����״̬�Ƿ����
			if(cond.isTaskDone()) {
				c.add(Expression.eq("ciwtstatus", CMDBConstants.TASK_STATUS_DONE));//�����
			} else {
				c.add(Expression.lt("ciwtstatus", CMDBConstants.TASK_STATUS_DONE));//δ���
			}
		}
		
		//ɾ����־
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		return c;
	}

}