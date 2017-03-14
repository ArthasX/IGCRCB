/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.RemindInfoInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindInfoSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RemindInfoTB;

/**
  * ����: ������Ϣ��DAOʵ��
  * ��������: ������Ϣ��DAOʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class RemindInfoDAOImpl extends
		BaseHibernateDAOImpl<RemindInfoInfo> implements RemindInfoDAO {

	/**
	 * ���캯��
	 */
	public RemindInfoDAOImpl(){
		super(RemindInfoTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RemindInfoInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RemindInfoInfo findByPK(Serializable pk) {
		RemindInfoInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RemindInfoSearchCond cond){
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
	public List<RemindInfoInfo> findByCond(final RemindInfoSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RemindInfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}