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
import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.EiWaitTaskSearchCond;
import com.deliverik.framework.asset.model.entity.EiWaitTaskTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: ����������DAOʵ��
  * ��������: ����������DAOʵ��
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class EiWaitTaskDAOImpl extends
		BaseHibernateDAOImpl<EiWaitTaskInfo> implements EiWaitTaskDAO {

	/**
	 * ���캯��
	 */
	public EiWaitTaskDAOImpl(){
		super(EiWaitTaskTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiWaitTaskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("eitid"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiWaitTaskInfo findByPK(Serializable pk) {
		EiWaitTaskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiWaitTaskSearchCond cond){
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
	public List<EiWaitTaskInfo> findByCond(final EiWaitTaskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("eitid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������,Ĭ�ϲ�ѯδ���
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EiWaitTaskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�����Ƿ�������
		if(cond.isTaskError()) {
			c.add(Expression.gt("eitstatus", CMDBConstants.TASK_STATUS_DONE));//�����
		} else {
			//����״̬�Ƿ����
			if(cond.isTaskDone()) {
				c.add(Expression.eq("eitstatus", CMDBConstants.TASK_STATUS_DONE));//�����
			} else {
				c.add(Expression.lt("eitstatus", CMDBConstants.TASK_STATUS_DONE));//δ���
			}
		}
		
		//ɾ����־
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		return c;
	}

}