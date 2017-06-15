/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.condition.CustomConfigurationSearchCond;
import com.deliverik.infogovernor.sym.model.entity.CustomConfigurationTB;

/**
  * ����: �Զ����������ñ�DAOʵ��
  * ��������: �Զ����������ñ�DAOʵ��
  * ������¼: 2012/11/05
  * �޸ļ�¼: 
  */
public class CustomConfigurationDAOImpl extends
		BaseHibernateDAOImpl<CustomConfigurationInfo> implements CustomConfigurationDAO {

	/**
	 * ���캯��
	 */
	public CustomConfigurationDAOImpl(){
		super(CustomConfigurationTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CustomConfigurationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CustomConfigurationInfo findByPK(Serializable pk) {
		CustomConfigurationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CustomConfigurationSearchCond cond){
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
	public List<CustomConfigurationInfo> findByCond(final CustomConfigurationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CustomConfigurationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}