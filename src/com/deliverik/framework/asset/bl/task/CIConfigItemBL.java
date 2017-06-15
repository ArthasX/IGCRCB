/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.asset.model.condition.CIConfigItemSearchCond;
import com.deliverik.framework.asset.model.entity.CIConfigItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * ����: CI����ʲ����Ա�ҵ���߼��ӿ�
  * ��������: CI����ʲ����Ա�ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIConfigItemBL extends BaseBL {

	/**
	 * CI����ʲ����Ա�ʵ��ȡ��
	 *
	 * @return CI����ʲ����Ա�ʵ��
	 */
	public CIConfigItemTB getCIConfigItemTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIConfigItemInfo> searchCIConfigItem();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIConfigItemInfo searchCIConfigItemByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CIConfigItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIConfigItemInfo> searchCIConfigItem(
			CIConfigItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIConfigItemInfo> searchCIConfigItem(
			CIConfigItemSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CIConfigItemInfo registCIConfigItem(CIConfigItemInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CIConfigItemInfo updateCIConfigItem(CIConfigItemInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCIConfigItemByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCIConfigItem(CIConfigItemInfo instance)
		throws BLException;

	/**
	 * �����ʲ����Լ����ԶԱȷ���
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIConfigItemInfo> searchCIConfigItemForAucmptype(Integer eiid);

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteCIConfigItem();

}