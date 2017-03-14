/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.EiBelongRelationVWInfo;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCond;
import com.deliverik.framework.asset.model.condition.EiBelongRelationVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: ����������ϵ��DAO�ӿ�
  * ��������: ����������ϵ��DAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface EiBelongRelationDAO extends BaseHibernateDAO<EiBelongRelationInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiBelongRelationInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiBelongRelationInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiBelongRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiBelongRelationInfo> findByCond(
			final EiBelongRelationSearchCond cond, final int start,
			final int count);
	
	/**
	 * ���ð�����ϵ����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiBelongRelationVWInfo> searchEiBelongRelationVW(final EiBelongRelationVWSearchCond cond);
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiBelongRelationInfo> searchMaxEiBelongRelation(final EiBelongRelationSearchCond cond);

}