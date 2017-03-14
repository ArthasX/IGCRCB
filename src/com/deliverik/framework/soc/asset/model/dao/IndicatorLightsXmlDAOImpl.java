/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.IndicatorLightsXmlInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsXmlSearchCond;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsXmlTB;

/**
  * ����: �澯ϵͳ��ʾ�����DAOʵ��
  * ��������: �澯ϵͳ��ʾ�����DAOʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IndicatorLightsXmlDAOImpl extends
		BaseHibernateDAOImpl<IndicatorLightsXmlInfo> implements IndicatorLightsXmlDAO {

	/**
	 * ���캯��
	 */
	public IndicatorLightsXmlDAOImpl(){
		super(IndicatorLightsXmlTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IndicatorLightsXmlInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IndicatorLightsXmlInfo findByPK(Serializable pk) {
		IndicatorLightsXmlInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IndicatorLightsXmlSearchCond cond){
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
	public List<IndicatorLightsXmlInfo> findByCond(final IndicatorLightsXmlSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IndicatorLightsXmlSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}