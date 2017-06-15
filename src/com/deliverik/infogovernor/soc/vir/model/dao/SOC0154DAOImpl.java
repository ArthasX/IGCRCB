/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.SOC0154Info;
import com.deliverik.infogovernor.soc.vir.model.condition.SOC0154SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.SOC0154TB;

/**
  * ����: soc0154DAOʵ��
  * ��������: soc0154DAOʵ��
  * ������¼: 2013/12/29
  * �޸ļ�¼: 
  */
public class SOC0154DAOImpl extends
		BaseHibernateDAOImpl<SOC0154Info> implements SOC0154DAO {

	/**
	 * ���캯��
	 */
	public SOC0154DAOImpl(){
		super(SOC0154TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0154Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0154Info findByPK(Serializable pk) {
		SOC0154Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0154SearchCond cond){
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
	public List<SOC0154Info> findByCond(final SOC0154SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0154SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getFromid())){
			c.add(Expression.eq("fromid", cond.getFromid()));
		}
		if(StringUtils.isNotEmpty(cond.getIsellipsis())){
			c.add(Expression.eq("isellipsis", cond.getIsellipsis()));
		}
		return c;
	}

}