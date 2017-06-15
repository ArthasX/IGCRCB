/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkConutVWSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkConutVW;

/**
  * ����: ��鹤��ͳ�Ʊ���ҵ���߼��ӿ�
  * ��������: ��鹤��ͳ�Ʊ���ҵ���߼��ӿ�
  * ������¼: 2014/07/09
  * �޸ļ�¼: 
  */
public interface CheckWorkConutVWBL extends BaseBL {

	/**
	 * ��鹤��ͳ�Ʊ���ʵ��ȡ��
	 *
	 * @return ��鹤��ͳ�Ʊ���ʵ��
	 */
	public CheckWorkConutVW getCheckWorkConutVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckWorkConutVWInfo> searchCheckWorkConutVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckWorkConutVWInfo searchCheckWorkConutVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckWorkConutVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckWorkConutVWInfo> searchCheckWorkConutVW(
			CheckWorkConutVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckWorkConutVWInfo> searchCheckWorkConutVW(
			CheckWorkConutVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckWorkConutVWInfo registCheckWorkConutVW(CheckWorkConutVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckWorkConutVWInfo updateCheckWorkConutVW(CheckWorkConutVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckWorkConutVWByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckWorkConutVW(CheckWorkConutVWInfo instance)
		throws BLException;

}