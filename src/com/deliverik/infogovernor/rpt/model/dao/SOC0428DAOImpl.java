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
import com.deliverik.infogovernor.rpt.model.SOC0428Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0428SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0428VW;

/**
  * ����: ҵ��ϵͳ��ͼDAOʵ��
  * ��������: ҵ��ϵͳ��ͼDAOʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��BusinessCapacityRealTimeVWDAOImpl������ΪSOC0428DAOImpl
  * 					������BusinessCapacityRealTimeVW�ķ������еĸ��ֶ��޸�ΪSOC0428����Ǳ�ʾ�������޸�ΪСд��soc0428
  */
@SuppressWarnings("deprecation")
public class SOC0428DAOImpl extends
		BaseHibernateDAOImpl<SOC0428Info> implements SOC0428DAO {

	/**
	 * ���캯��
	 */
	public SOC0428DAOImpl(){
		super(SOC0428VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0428Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0428Info findByPK(Serializable pk) {
		SOC0428Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0428SearchCond cond){
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
	public List<SOC0428Info> findByCond(final SOC0428SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0428SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getSName())){
			c.add(Expression.eq("sName", cond.getSName()));
		}
		return c;
	}

}