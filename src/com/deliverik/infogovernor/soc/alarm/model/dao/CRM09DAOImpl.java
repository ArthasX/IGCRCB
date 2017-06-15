/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM09SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM09TB;

/**
  * ����: CRM09DAOʵ��
  * ��������: CRM09DAOʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CRM09DAOImpl extends
		BaseHibernateDAOImpl<CRM09Info> implements CRM09DAO {

	/**
	 * ���캯��
	 */
	public CRM09DAOImpl(){
		super(CRM09TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM09Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM09Info findByPK(Serializable pk) {
		CRM09Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM09SearchCond cond){
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
	public List<CRM09Info> findByCond(final CRM09SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CRM09SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getServerid_eq())){
			c.add(Expression.eq("serverid",Integer.parseInt(cond.getServerid_eq())));
		}
		//ruletempid
		if(cond.getRuletempid_eq() != null){
			c.add(Expression.eq("ruletempid",cond.getRuletempid_eq()));
		}
		if(cond.getRuletempids_notIn() != null && cond.getRuletempids_notIn().length != 0){
			c.add(Expression.not(Expression.in("ruletempid", cond.getRuletempids_notIn())));
		}
		return c;
	}

}