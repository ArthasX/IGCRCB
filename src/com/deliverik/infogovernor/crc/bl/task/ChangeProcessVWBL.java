/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.condition.ChangeProcessVWSearchCond;
import com.deliverik.infogovernor.crc.model.entity.ChangeProcessVWTB;

/**
  * ����: �������ҵ���߼��ӿ�
  * ��������: �������ҵ���߼��ӿ�
  * ������¼: 2015/01/04
  * �޸ļ�¼: 
  */
public interface ChangeProcessVWBL extends BaseBL {

	/**
	 * �������ʵ��ȡ��
	 *
	 * @return �������ʵ��
	 */
	public ChangeProcessVWTB getChangeProcessVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ChangeProcessVWInfo> searchChangeProcessVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ChangeProcessVWInfo searchChangeProcessVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ChangeProcessVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ChangeProcessVWInfo> searchChangeProcessVW(
			ChangeProcessVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ChangeProcessVWInfo> searchChangeProcessVW(
			ChangeProcessVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ChangeProcessVWInfo registChangeProcessVW(ChangeProcessVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ChangeProcessVWInfo updateChangeProcessVW(ChangeProcessVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteChangeProcessVWByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteChangeProcessVW(ChangeProcessVWInfo instance)
		throws BLException;

}