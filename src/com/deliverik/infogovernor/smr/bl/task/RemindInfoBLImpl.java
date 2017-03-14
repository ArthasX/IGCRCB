/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.RemindInfoInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindInfoSearchCond;
import com.deliverik.infogovernor.smr.model.dao.RemindInfoDAO;
import com.deliverik.infogovernor.smr.model.entity.RemindInfoTB;

/**
  * ����: ������Ϣ��ҵ���߼�ʵ��
  * ��������: ������Ϣ��ҵ���߼�ʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public class RemindInfoBLImpl extends BaseBLImpl implements
		RemindInfoBL {

	/** ������Ϣ��DAO�ӿ� */
	protected RemindInfoDAO remindInfoDAO;
	
	/**
	 * ������Ϣ��DAO�ӿ��趨
	 *
	 * @param remindInfoDAO ������Ϣ��DAO�ӿ�
	 */
	public void setRemindInfoDAO(RemindInfoDAO remindInfoDAO) {
		this.remindInfoDAO = remindInfoDAO;
	}

	/**
	 * ������Ϣ��ʵ��ȡ��
	 *
	 * @return ������Ϣ��ʵ��
	 */
	public RemindInfoTB getRemindInfoTBInstance() {
		return new RemindInfoTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RemindInfoInfo> searchRemindInfo() {
		return remindInfoDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RemindInfoInfo searchRemindInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RemindInfoSearchCond cond) {
		return remindInfoDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RemindInfoInfo> searchRemindInfo(
			RemindInfoSearchCond cond) {
		return remindInfoDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RemindInfoInfo> searchRemindInfo(
			RemindInfoSearchCond cond, int start,
			int count) {
		return remindInfoDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RemindInfoInfo registRemindInfo(RemindInfoInfo instance)
		throws BLException {
		return remindInfoDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RemindInfoInfo updateRemindInfo(RemindInfoInfo instance)
		throws BLException {
		checkExistInstance(instance.getRiid());
		return remindInfoDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRemindInfoByPK(Integer pk)
		throws BLException {
		remindInfoDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRemindInfo(RemindInfoInfo instance)
		throws BLException {
		remindInfoDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RemindInfoInfo checkExistInstance(Integer pk)
		throws BLException {
		RemindInfoInfo instance = remindInfoDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}