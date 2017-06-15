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
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefVWInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefVWSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefVW;

/**
  * ����: ��ض���KPI��Ϣ��ͼDAOʵ��
  * ��������: ��ض���KPI��Ϣ��ͼDAOʵ��
  * ������¼: 2012/02/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class MonitorObjectDefVWDAOImpl extends
		BaseHibernateDAOImpl<MonitorObjectDefVWInfo> implements MonitorObjectDefVWDAO {

	/**
	 * ���캯��
	 */
	public MonitorObjectDefVWDAOImpl(){
		super(MonitorObjectDefVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectDefVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorObjectDefVWInfo findByPK(Serializable pk) {
		MonitorObjectDefVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorObjectDefVWSearchCond cond){
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
	public List<MonitorObjectDefVWInfo> findByCond(final MonitorObjectDefVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(MonitorObjectDefVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//����ض������Ʋ�Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getMoName())){
			c.add(Expression.eq("moName", cond.getMoName()));
		}
		
		//״̬
		if(StringUtils.isNotEmpty(cond.getDeleteFlag())){
			c.add(Expression.eq("deleteFlag", cond.getDeleteFlag()));
		}
		return c;
	}

}