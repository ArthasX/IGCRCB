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
import com.deliverik.infogovernor.rpt.model.SOC0209Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0209SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0209VW;

/**
  * ����: ������Դ��ͼDAOʵ��
  * ��������: ������Դ��ͼDAOʵ��
  * ������¼: 2011/11/24
  * �޸ļ�¼: 2012/08/09 ��ProcessRecordInfoVWDAOImpl������ΪSOC0209DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0209DAOImpl extends
		BaseHibernateDAOImpl<SOC0209Info> implements SOC0209DAO {

	/**
	 * ���캯��
	 */
	public SOC0209DAOImpl(){
		super(SOC0209VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0209Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0209Info findByPK(Serializable pk) {
		SOC0209Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0209SearchCond cond){
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
	public List<SOC0209Info> findByCond(final SOC0209SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0209SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPrtype())){
			c.add(Expression.eq("prtype", cond.getPrtype()));
		}
		if(StringUtils.isNotEmpty(cond.getPropentime())){
			c.add(Expression.sql(" substr(this_.propentime,1,7)='"+cond.getPropentime().substring(0, 7)+"'"));
		}
		return c;
	}

}