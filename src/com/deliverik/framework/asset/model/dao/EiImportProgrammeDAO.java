/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.asset.model.condition.EiImportProgrammeSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: �����������DAO�ӿ�
  * ��������: �����������DAO�ӿ�
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
public interface EiImportProgrammeDAO extends BaseHibernateDAO<EiImportProgrammeInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiImportProgrammeInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiImportProgrammeInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiImportProgrammeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiImportProgrammeInfo> findByCond(
			final EiImportProgrammeSearchCond cond, final int start,
			final int count);

}