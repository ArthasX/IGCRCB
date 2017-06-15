/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTaskObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTaskObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTaskObjectTB;

/**
  * ����: �����������DAOʵ��
  * ��������: �����������DAOʵ��
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class MonitorTaskObjectDAOImpl extends
		BaseHibernateDAOImpl<MonitorTaskObjectInfo> implements MonitorTaskObjectDAO {

	/**
	 * ���캯��
	 */
	public MonitorTaskObjectDAOImpl(){
		super(MonitorTaskObjectTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTaskObjectInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTaskObjectInfo findByPK(Serializable pk) {
		MonitorTaskObjectInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorTaskObjectSearchCond cond){
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
	public List<MonitorTaskObjectInfo> findByCond(final MonitorTaskObjectSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(MonitorTaskObjectSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getMtid()!=null){
			c.add(Expression.eq("mtId", cond.getMtid()));
		}
		return c;
	}

}