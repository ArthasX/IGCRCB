/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.bl.task.CMDBConstants;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0115SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0115TB;

/**
  * ����: ����������DAOʵ��
  * ��������: ����������DAOʵ��
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0115DAOImpl extends
		BaseHibernateDAOImpl<SOC0115Info> implements SOC0115DAO {

	/**
	 * ���캯��
	 */
	public SOC0115DAOImpl(){
		super(SOC0115TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0115Info> findAll() {
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
	public SOC0115Info findByPK(Serializable pk) {
		SOC0115Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0115SearchCond cond){
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
	public List<SOC0115Info> findByCond(final SOC0115SearchCond cond, final int start, final int count){
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
	protected DetachedCriteria getCriteria(SOC0115SearchCond cond){
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