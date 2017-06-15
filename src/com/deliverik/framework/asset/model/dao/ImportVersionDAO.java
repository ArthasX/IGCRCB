/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: �������ݰ汾�����DAO�ӿ�
  * ��������: �������ݰ汾�����DAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface ImportVersionDAO extends BaseHibernateDAO<ImportVersionInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ImportVersionInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ImportVersionInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ImportVersionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ImportVersionInfo> findByCond(
			final ImportVersionSearchCond cond, final int start,
			final int count);
	
	/**
	 * �������汾����
	 * @param impversion 
	 */
	public List<ImportVersionInfo> searchImportVersionByImpname(String impeiname, Integer impversion);

	/**
	 * ������󲻴��ڼ��
	 * 
	 * @param impeinameʵ����
	 * @return
	 * @throws BLException 
	 */
	public List<ImportVersionInfo> findByImpeiname(ImportVersionSearchCond cond);
}