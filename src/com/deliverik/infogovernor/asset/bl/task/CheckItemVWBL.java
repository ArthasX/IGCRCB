/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;

/**
  * ����: ������ѯҵ���߼��ӿ�
  * ��������: ������ѯҵ���߼��ӿ�
  * ������¼: 2014/07/01
  * �޸ļ�¼: 
  */
public interface CheckItemVWBL extends BaseBL {

	/**
	 * ������ѯʵ��ȡ��
	 *
	 * @return ������ѯʵ��
	 */
	public CheckItemVW getCheckItemVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckItemVWInfo> searchCheckItemVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckItemVWInfo searchCheckItemVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckItemVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckItemVWInfo> searchCheckItemVW(
			CheckItemVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckItemVWInfo> searchCheckItemVW(
			CheckItemVWSearchCond cond, int start,
			int count);
	
	/**
	 * (��Ϣ��ȫ �����)������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckItemVWInfo> searchSafeInfoCheckItemVW(
			CheckItemVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckItemVWInfo registCheckItemVW(CheckItemVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckItemVWInfo updateCheckItemVW(CheckItemVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckItemVWByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckItemVW(CheckItemVWInfo instance)
		throws BLException;

}