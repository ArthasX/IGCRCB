/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0120TB;

/**
  * ����: �������ݰ汾�����ҵ���߼��ӿ�
  * ��������: �������ݰ汾�����ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0120BL extends BaseBL {

	/**
	 * �������ݰ汾�����ʵ��ȡ��
	 *
	 * @return �������ݰ汾�����ʵ��
	 */
	public SOC0120TB getImportVersionTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0120Info> searchImportVersion();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0120Info searchImportVersionByPK(Serializable pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0120SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0120Info> searchImportVersion(
			SOC0120SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0120Info> searchImportVersion(
			SOC0120SearchCond cond, int start,
			int count);
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0120Info> searchImportVersionAutoCollect(
			SOC0120SearchCond cond, int start,
			int count);
	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0120Info registImportVersion(SOC0120Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0120Info updateImportVersion(SOC0120Info instance)
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
	public void deleteImportVersion(SOC0120Info instance)
		throws BLException;
	
	/**
	 * �������汾����
	 * @param impeiname
	 * @param impversion 
	 * @return
	 */
	public List<SOC0120Info> searchImportVersionByPK(String impeiname, Integer impversion) throws BLException;

	/**
	 * ������󲻴��ڼ��
	 * 
	 * @param eilabelʵ����
	 * @return
	 * @throws BLException 
	 */
	public void checkNotImportVersion(String impeiname) throws BLException;
	
}