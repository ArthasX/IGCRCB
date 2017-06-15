/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0208SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0208TB;

/**
  * ����: �¼��������Ч��DAOʵ��
  * ��������: �¼��������Ч��DAOʵ��
  * ������¼: 2011/11/23
  * �޸ļ�¼: 2012/08/10 ��ServeEfficiencyDAOImpl�����޸�ΪSOC0208DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0208DAOImpl extends
		BaseHibernateDAOImpl<SOC0208Info> implements SOC0208DAO {

	/**
	 * ���캯��
	 */
	public SOC0208DAOImpl(){
		super(SOC0208TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0208Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0208Info findByPK(Serializable pk) {
		SOC0208Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0208SearchCond cond){
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
	public List<SOC0208Info> findByCond(final SOC0208SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0208SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPrtype())){
			c.add(Expression.eq("prtype", cond.getPrtype()));
		}
		if(StringUtils.isNotEmpty(cond.getIsNotTime())){
			c.add(Expression.sql(" this_.efficiencytime!='"+cond.getIsNotTime()+"'"));
		}
		
		return c;
	}

}