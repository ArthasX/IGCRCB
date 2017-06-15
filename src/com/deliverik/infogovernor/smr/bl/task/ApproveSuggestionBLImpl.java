/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCond;
import com.deliverik.infogovernor.smr.model.dao.ApproveSuggestionDAO;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
  * ����: ���������ҵ���߼�ʵ��
  * ��������: ���������ҵ���߼�ʵ��
  * ������¼: 2013/07/22
  * �޸ļ�¼: 
  */
public class ApproveSuggestionBLImpl extends BaseBLImpl implements
		ApproveSuggestionBL {

	/** ���������DAO�ӿ� */
	protected ApproveSuggestionDAO approveSuggestionDAO;
	
	/**
	 * ���������DAO�ӿ��趨
	 *
	 * @param approveSuggestionDAO ���������DAO�ӿ�
	 */
	public void setApproveSuggestionDAO(ApproveSuggestionDAO approveSuggestionDAO) {
		this.approveSuggestionDAO = approveSuggestionDAO;
	}

	/**
	 * ���������ʵ��ȡ��
	 *
	 * @return ���������ʵ��
	 */
	public ApproveSuggestionTB getApproveSuggestionTBInstance() {
		return new ApproveSuggestionTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo() {
		return approveSuggestionDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ApproveSuggestionInfo searchApproveSuggestionInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ApproveSuggestionSearchCond cond) {
		return approveSuggestionDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo(
			ApproveSuggestionSearchCond cond) {
		return approveSuggestionDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return approveSuggestionDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ApproveSuggestionInfo registApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException {
		return approveSuggestionDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ApproveSuggestionInfo updateApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return approveSuggestionDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteApproveSuggestionInfoByPK(Integer pk)
		throws BLException {
		approveSuggestionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException {
		approveSuggestionDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ApproveSuggestionInfo checkExistInstance(Integer pk)
		throws BLException {
		ApproveSuggestionInfo instance = approveSuggestionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "�����������");
		}
		return instance;
	}

}