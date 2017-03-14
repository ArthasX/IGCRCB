/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIEntityItemInfo;
import com.deliverik.framework.asset.model.condition.CIEntityItemSearchCond;
import com.deliverik.framework.asset.model.entity.CIEntityItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * ����: CI����ʲ���ҵ���߼��ӿ�
  * ��������: CI����ʲ���ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIEntityItemBL extends BaseBL {

	/**
	 * CI����ʲ���ʵ��ȡ��
	 *
	 * @return CI����ʲ���ʵ��
	 */
	public CIEntityItemTB getCIEntityItemTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIEntityItemInfo> searchCIEntityItem();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIEntityItemInfo searchCIEntityItemByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CIEntityItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIEntityItemInfo> searchCIEntityItem(
			CIEntityItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIEntityItemInfo> searchCIEntityItem(
			CIEntityItemSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CIEntityItemInfo registCIEntityItem(CIEntityItemInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CIEntityItemInfo updateCIEntityItem(CIEntityItemInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCIEntityItemByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCIEntityItem(CIEntityItemInfo instance)
		throws BLException;

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteCIEntityItem();

}