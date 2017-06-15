/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCond;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
  * ����: ���������ҵ���߼��ӿ�
  * ��������: ���������ҵ���߼��ӿ�
  * ������¼: 2013/07/22
  * �޸ļ�¼: 
  */
public interface ApproveSuggestionBL extends BaseBL {

	/**
	 * ���������ʵ��ȡ��
	 *
	 * @return ���������ʵ��
	 */
	public ApproveSuggestionTB getApproveSuggestionTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ApproveSuggestionInfo searchApproveSuggestionInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ApproveSuggestionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo(
			ApproveSuggestionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo(
			ApproveSuggestionSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ApproveSuggestionInfo registApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ApproveSuggestionInfo updateApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteApproveSuggestionInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException;

}