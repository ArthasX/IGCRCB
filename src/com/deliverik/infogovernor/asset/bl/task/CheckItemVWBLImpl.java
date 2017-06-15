/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.CheckItemVWDAO;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;

/**
  * ����: ������ѯҵ���߼�ʵ��
  * ��������: ������ѯҵ���߼�ʵ��
  * ������¼: 2014/07/01
  * �޸ļ�¼: 
  */
public class CheckItemVWBLImpl extends BaseBLImpl implements
		CheckItemVWBL {

	/** ������ѯDAO�ӿ� */
	protected CheckItemVWDAO checkItemVWDAO;
	
	/**
	 * ������ѯDAO�ӿ��趨
	 *
	 * @param checkItemVWDAO ������ѯDAO�ӿ�
	 */
	public void setCheckItemVWDAO(CheckItemVWDAO checkItemVWDAO) {
		this.checkItemVWDAO = checkItemVWDAO;
	}

	/**
	 * ������ѯʵ��ȡ��
	 *
	 * @return ������ѯʵ��
	 */
	public CheckItemVW getCheckItemVWTBInstance() {
		return new CheckItemVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckItemVWInfo> searchCheckItemVW() {
		return checkItemVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckItemVWInfo searchCheckItemVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckItemVWSearchCond cond) {
		return checkItemVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckItemVWInfo> searchCheckItemVW(
			CheckItemVWSearchCond cond) {
		return checkItemVWDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return checkItemVWDAO.findByCond(cond, start, count);
	}
	
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
			int count) {
		return checkItemVWDAO.safeInfoFindByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckItemVWInfo registCheckItemVW(CheckItemVWInfo instance)
		throws BLException {
		return checkItemVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckItemVWInfo updateCheckItemVW(CheckItemVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return checkItemVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckItemVWByPK(Integer pk)
		throws BLException {
		checkItemVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckItemVW(CheckItemVWInfo instance)
		throws BLException {
		checkItemVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CheckItemVWInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckItemVWInfo instance = checkItemVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}