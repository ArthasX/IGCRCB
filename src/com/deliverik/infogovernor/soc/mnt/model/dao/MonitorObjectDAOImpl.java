/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectTB;

/**
  * ����: ��ض�����ϢDAOʵ��
  * ��������: ��ض�����ϢDAOʵ��
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class MonitorObjectDAOImpl extends
		BaseHibernateDAOImpl<MonitorObjectInfo> implements MonitorObjectDAO {

	/**
	 * ���캯��
	 */
	public MonitorObjectDAOImpl(){
		super(MonitorObjectTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorObjectInfo findByPK(Serializable pk) {
		MonitorObjectInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorObjectSearchCond cond){
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
	public List<MonitorObjectInfo> findByCond(final MonitorObjectSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(MonitorObjectSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getMtSyscoding())){
			c.add(Expression.eq("mtSyscoding", cond.getMtSyscoding()));
		}
		if(StringUtils.isNotEmpty(cond.getMoName())){
			c.add(Expression.eq("moName", cond.getMoName()));
		}
		if(StringUtils.isNotEmpty(cond.getMoCreateTime_from())){
			c.add(Expression.ge("moCreateTime", cond.getMoCreateTime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getMoCreateTime_to())){
			c.add(Expression.le("moCreateTime", cond.getMoCreateTime_to()));
		}
		return c;
	}

}