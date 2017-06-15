/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyResourceSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyResourceTB;

/**
  * ����: EmergencyResourceDAOʵ��
  * ��������: EmergencyResourceDAOʵ��
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public class EmergencyResourceDAOImpl extends
		BaseHibernateDAOImpl<EmergencyResourceInfo> implements EmergencyResourceDAO {

	/**
	 * ���캯��
	 */
	public EmergencyResourceDAOImpl(){
		super(EmergencyResourceTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EmergencyResourceInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EmergencyResourceInfo findByPK(Serializable pk) {
		EmergencyResourceInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EmergencyResourceSearchCond cond){
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
	public List<EmergencyResourceInfo> findByCond(final EmergencyResourceSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EmergencyResourceSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(StringUtils.isNotEmpty(cond.getErparcode())){
			c.add(Restrictions.eq("erparcode", cond.getErparcode()));
		}
		
		if(StringUtils.isNotEmpty(cond.getErparcode_like())){
			c.add(Restrictions.like("erparcode", cond.getErparcode_like()+"%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getErname())){
			c.add(Restrictions.like("ername", "%" + cond.getErname()+"%"));
		}
		
		if(StringUtils.isNotBlank(cond.getOrderby())){
			if(StringUtils.isNotEmpty(cond.getOrder())&&"ASC".equals(cond.getOrder())){
				c.addOrder(Order.asc(cond.getOrderby()));
			}else{
				c.addOrder(Order.desc(cond.getOrderby()));
			}
		}
		return c;
	}

}