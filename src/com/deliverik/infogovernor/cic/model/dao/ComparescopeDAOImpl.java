/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.ComparescopeInfo;
import com.deliverik.infogovernor.cic.model.condition.ComparescopeSearchCond;
import com.deliverik.infogovernor.cic.model.entity.ComparescopeTB;

/**
  * ����: �Ա���DAOʵ��
  * ��������: �Ա���DAOʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ComparescopeDAOImpl extends
		BaseHibernateDAOImpl<ComparescopeInfo> implements ComparescopeDAO {

	/**
	 * ���캯��
	 */
	public ComparescopeDAOImpl(){
		super(ComparescopeTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ComparescopeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ComparescopeInfo findByPK(Serializable pk) {
		ComparescopeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ComparescopeSearchCond cond){
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
	public List<ComparescopeInfo> findByCond(final ComparescopeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ComparescopeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}