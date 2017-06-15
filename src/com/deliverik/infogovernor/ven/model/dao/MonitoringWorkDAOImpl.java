/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCond;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;

/**
  * ����: ��⹤�����DAOʵ��
  * ��������: ��⹤�����DAOʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class MonitoringWorkDAOImpl extends
		BaseHibernateDAOImpl<MonitoringWorkInfo> implements MonitoringWorkDAO {

	/**
	 * ���캯��
	 */
	public MonitoringWorkDAOImpl(){
		super(MonitoringWorkTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitoringWorkInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitoringWorkInfo findByPK(Serializable pk) {
		MonitoringWorkInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitoringWorkSearchCond cond){
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
	public List<MonitoringWorkInfo> findByCond(final MonitoringWorkSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(MonitoringWorkSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getRmid() != null && !("0".equals(cond.getRmid()))) {
			c.add(Restrictions.eq("rmid", cond.getRmid()));
		}
		if (StringUtils.isNotEmpty(cond.getResult_isNotNull())){
			if("1".equals(cond.getResult_isNotNull())){
				c.add(Restrictions.isNotNull("result"));
			}
		}
		if (StringUtils.isNotEmpty(cond.getEiname())){
			c.add(Restrictions.sqlRestriction(" exists(select 1 from soc0118 t where t.eiid = this_.riid and t.einame like '%"+ cond.getEiname() +"%') "));
		}
		
		if (StringUtils.isNotEmpty(cond.getEilabel())){
			c.add(Restrictions.sqlRestriction(" exists(select 1 from soc0118 t where t.eiid = this_.riid and t.eilabel like '%"+ cond.getEilabel() +"%') "));
		}
		return c;
	}

}