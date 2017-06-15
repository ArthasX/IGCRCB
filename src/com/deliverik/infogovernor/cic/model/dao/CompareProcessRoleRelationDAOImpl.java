/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareProcessRoleRelationInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareProcessRoleRelationSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareProcessRoleRelationTB;

/**
  * ����: ��ϵ��DAOʵ��
  * ��������: ��ϵ��DAOʵ��
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CompareProcessRoleRelationDAOImpl extends
		BaseHibernateDAOImpl<CompareProcessRoleRelationInfo> implements CompareProcessRoleRelationDAO {

	/**
	 * ���캯��
	 */
	public CompareProcessRoleRelationDAOImpl(){
		super(CompareProcessRoleRelationTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareProcessRoleRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareProcessRoleRelationInfo findByPK(Serializable pk) {
		CompareProcessRoleRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareProcessRoleRelationSearchCond cond){
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
	public List<CompareProcessRoleRelationInfo> findByCond(final CompareProcessRoleRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CompareProcessRoleRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}