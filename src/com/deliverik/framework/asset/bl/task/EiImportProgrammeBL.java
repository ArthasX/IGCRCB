/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.asset.model.condition.EiImportProgrammeSearchCond;
import com.deliverik.framework.asset.model.entity.EiImportProgrammeTB;

/**
  * ����: �����������ҵ���߼��ӿ�
  * ��������: �����������ҵ���߼��ӿ�
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
public interface EiImportProgrammeBL extends BaseBL {

	/**
	 * �����������ʵ��ȡ��
	 *
	 * @return �����������ʵ��
	 */
	public EiImportProgrammeTB getEiImportProgrammeTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiImportProgrammeInfo> searchEiImportProgramme();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiImportProgrammeInfo searchEiImportProgrammeByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EiImportProgrammeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiImportProgrammeInfo> searchEiImportProgramme(
			EiImportProgrammeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiImportProgrammeInfo> searchEiImportProgramme(
			EiImportProgrammeSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EiImportProgrammeInfo registEiImportProgramme(EiImportProgrammeInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiImportProgrammeInfo updateEiImportProgramme(EiImportProgrammeInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEiImportProgrammeByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEiImportProgramme(EiImportProgrammeInfo instance)
		throws BLException;

}