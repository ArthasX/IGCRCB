/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.asset.model.entity.ImportVersionTB;

/**
  * ����: �������ݰ汾�����ҵ���߼��ӿ�
  * ��������: �������ݰ汾�����ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface ImportVersionBL extends BaseBL {

	/**
	 * �������ݰ汾�����ʵ��ȡ��
	 *
	 * @return �������ݰ汾�����ʵ��
	 */
	public ImportVersionTB getImportVersionTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ImportVersionInfo> searchImportVersion();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public ImportVersionInfo searchImportVersionByPK(Serializable pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(ImportVersionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<ImportVersionInfo> searchImportVersion(
			ImportVersionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<ImportVersionInfo> searchImportVersion(
			ImportVersionSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public ImportVersionInfo registImportVersion(ImportVersionInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ImportVersionInfo updateImportVersion(ImportVersionInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteImportVersionByPK(Serializable pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteImportVersion(ImportVersionInfo instance)
		throws BLException;
	
	/**
	 * �������汾����
	 * @param impeiname
	 * @param impversion 
	 * @return
	 */
	public List<ImportVersionInfo> searchImportVersionByPK(String impeiname, Integer impversion) throws BLException;

	/**
	 * ������󲻴��ڼ��
	 * 
	 * @param eilabelʵ����
	 * @return
	 * @throws BLException 
	 */
	public void checkNotImportVersion(String impeiname) throws BLException;
}