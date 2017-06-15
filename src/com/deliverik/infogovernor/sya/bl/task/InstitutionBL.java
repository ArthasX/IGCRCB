/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sya.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;
import com.deliverik.infogovernor.sya.model.condition.InstitutionSearchCond;
import com.deliverik.infogovernor.sya.model.entity.InstitutionTB;

/**
  * ����: ��Ч����ҵ���߼��ӿ�
  * ��������: ��Ч����ҵ���߼��ӿ�
  * ������¼: 2015/01/05
  * �޸ļ�¼: 
  */
public interface InstitutionBL extends BaseBL {

	/**
	 * ��Ч����ʵ��ȡ��
	 *
	 * @return ��Ч����ʵ��
	 */
	public InstitutionTB getInstitutionTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InstitutionInfo> searchInstitution();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InstitutionInfo searchInstitutionByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(InstitutionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<InstitutionInfo> searchInstitution(
			InstitutionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InstitutionInfo> searchInstitution(
			InstitutionSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public InstitutionInfo registInstitution(InstitutionInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public InstitutionInfo updateInstitution(InstitutionInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteInstitutionByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteInstitution(InstitutionInfo instance)
		throws BLException;

}