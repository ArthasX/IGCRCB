/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0113SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;

/**
  * ����: �����������ҵ���߼��ӿ�
  * ��������: �����������ҵ���߼��ӿ�
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
public interface SOC0113BL extends BaseBL {

	/**
	 * �����������ʵ��ȡ��
	 *
	 * @return �����������ʵ��
	 */
	public SOC0113TB getEiImportProgrammeTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0113Info> searchEiImportProgramme();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0113Info searchEiImportProgrammeByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0113SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0113Info> searchEiImportProgramme(
			SOC0113SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0113Info> searchEiImportProgramme(
			SOC0113SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0113Info registEiImportProgramme(SOC0113Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0113Info updateEiImportProgramme(SOC0113Info instance)
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
	public void deleteEiImportProgramme(SOC0113Info instance)
		throws BLException;

}