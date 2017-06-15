/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.IndicatorLightsSystemInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsSystemSearchCond;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsSystemTB;

/**
  * ����: �澯ϵͳ��ʾ��Ϣ��DAOʵ��
  * ��������: �澯ϵͳ��ʾ��Ϣ��DAOʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IndicatorLightsSystemDAOImpl extends
		BaseHibernateDAOImpl<IndicatorLightsSystemInfo> implements IndicatorLightsSystemDAO {

	/**
	 * ���캯��
	 */
	public IndicatorLightsSystemDAOImpl(){
		super(IndicatorLightsSystemTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IndicatorLightsSystemInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IndicatorLightsSystemInfo findByPK(Serializable pk) {
		IndicatorLightsSystemInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IndicatorLightsSystemSearchCond cond){
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
	public List<IndicatorLightsSystemInfo> findByCond(final IndicatorLightsSystemSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IndicatorLightsSystemSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// ϵͳ����
		if ( StringUtils.isNotEmpty(cond.getIlsname())) {
			c.add(Expression.eq("ilsname", cond.getIlsname()));
		}
		
		// ״̬
		if ( StringUtils.isNotEmpty(cond.getIlsstatus())) {
			c.add(Expression.eq("ilsstatus", cond.getIlsstatus()));
		}
		
		return c;
	}

}