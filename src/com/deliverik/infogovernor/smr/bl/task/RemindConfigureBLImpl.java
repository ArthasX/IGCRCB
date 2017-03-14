/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindConfigureSearchCond;
import com.deliverik.infogovernor.smr.model.dao.RemindConfigureDAO;
import com.deliverik.infogovernor.smr.model.entity.RemindConfigureTB;

/**
  * ����: �������ñ�ҵ���߼�ʵ��
  * ��������: �������ñ�ҵ���߼�ʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public class RemindConfigureBLImpl extends BaseBLImpl implements
		RemindConfigureBL {

	/** �������ñ�DAO�ӿ� */
	protected RemindConfigureDAO remindConfigureDAO;
	
	/**
	 * �������ñ�DAO�ӿ��趨
	 *
	 * @param remindConfigureDAO �������ñ�DAO�ӿ�
	 */
	public void setRemindConfigureDAO(RemindConfigureDAO remindConfigureDAO) {
		this.remindConfigureDAO = remindConfigureDAO;
	}

	/**
	 * �������ñ�ʵ��ȡ��
	 *
	 * @return �������ñ�ʵ��
	 */
	public RemindConfigureTB getRemindConfigureTBInstance() {
		return new RemindConfigureTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RemindConfigureInfo> searchRemindConfigure() {
		return remindConfigureDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RemindConfigureInfo searchRemindConfigureByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RemindConfigureSearchCond cond) {
		return remindConfigureDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RemindConfigureInfo> searchRemindConfigure(
			RemindConfigureSearchCond cond) {
		return remindConfigureDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RemindConfigureInfo> searchRemindConfigure(
			RemindConfigureSearchCond cond, int start,
			int count) {
		return remindConfigureDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RemindConfigureInfo registRemindConfigure(RemindConfigureInfo instance)
		throws BLException {
		return remindConfigureDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RemindConfigureInfo updateRemindConfigure(RemindConfigureInfo instance)
		throws BLException {
		checkExistInstance(instance.getRcid());
		return remindConfigureDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRemindConfigureByPK(Integer pk)
		throws BLException {
		remindConfigureDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRemindConfigure(RemindConfigureInfo instance)
		throws BLException {
		remindConfigureDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RemindConfigureInfo checkExistInstance(Integer pk)
		throws BLException {
		RemindConfigureInfo instance = remindConfigureDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}