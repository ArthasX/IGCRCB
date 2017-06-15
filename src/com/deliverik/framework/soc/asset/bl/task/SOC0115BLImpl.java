/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0115SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0115DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0115TB;

/**
  * ����: ����������ҵ���߼�ʵ��
  * ��������: ����������ҵ���߼�ʵ��
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
public class SOC0115BLImpl extends BaseBLImpl implements
		SOC0115BL {

	/** ����������DAO�ӿ� */
	protected SOC0115DAO soc0115DAO;
	


	/**
	 * ����������DAO�ӿ��趨
	 *
	 * @param soc0115DAO ����������DAO�ӿ�
	 */
	public void setSoc0115DAO(SOC0115DAO soc0115DAO) {
		this.soc0115DAO = soc0115DAO;
	}

	/**
	 * ����������ʵ��ȡ��
	 *
	 * @return ����������ʵ��
	 */
	public SOC0115TB getEiWaitTaskTBInstance() {
		return new SOC0115TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0115Info> searchEiWaitTask() {
		return soc0115DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0115Info searchEiWaitTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0115SearchCond cond) {
		return soc0115DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0115Info> searchEiWaitTask(
			SOC0115SearchCond cond) {
		return soc0115DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0115Info> searchEiWaitTask(
			SOC0115SearchCond cond, int start,
			int count) {
		return soc0115DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0115Info registEiWaitTask(SOC0115Info instance)
		throws BLException {
		return soc0115DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0115Info updateEiWaitTask(SOC0115Info instance)
		throws BLException {
		checkExistInstance(instance.getEitid());
		return soc0115DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiWaitTaskByPK(Integer pk)
		throws BLException {
		soc0115DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiWaitTask(SOC0115Info instance)
		throws BLException {
		soc0115DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SOC0115Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0115Info instance = soc0115DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}