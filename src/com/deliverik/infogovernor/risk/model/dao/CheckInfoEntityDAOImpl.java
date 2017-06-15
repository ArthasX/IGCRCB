/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckInfoEntityInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoEntitySearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckInfoEntityTB;

/**
  * ����: �����Թ����ʲ���DAOʵ��
  * ��������: �����Թ����ʲ���DAOʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CheckInfoEntityDAOImpl extends
		BaseHibernateDAOImpl<CheckInfoEntityInfo> implements CheckInfoEntityDAO {

	/**
	 * ���캯��
	 */
	public CheckInfoEntityDAOImpl(){
		super(CheckInfoEntityTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckInfoEntityInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckInfoEntityInfo findByPK(Serializable pk) {
		CheckInfoEntityInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckInfoEntitySearchCond cond){
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
	public List<CheckInfoEntityInfo> findByCond(final CheckInfoEntitySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CheckInfoEntitySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}