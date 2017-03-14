/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.EiWaitTaskSearchCond;
import com.deliverik.framework.asset.model.dao.EiWaitTaskDAO;
import com.deliverik.framework.asset.model.entity.EiWaitTaskTB;

/**
  * ����: ����������ҵ���߼�ʵ��
  * ��������: ����������ҵ���߼�ʵ��
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
public class EiWaitTaskBLImpl extends BaseBLImpl implements
		EiWaitTaskBL {

	/** ����������DAO�ӿ� */
	protected EiWaitTaskDAO eiWaitTaskDAO;
	
	/**
	 * ����������DAO�ӿ��趨
	 *
	 * @param eiWaitTaskDAO����������DAO�ӿ�
	 */
	public void setEiWaitTaskDAO(EiWaitTaskDAO eiWaitTaskDAO) {
		this.eiWaitTaskDAO = eiWaitTaskDAO;
	}

	/**
	 * ����������ʵ��ȡ��
	 *
	 * @return ����������ʵ��
	 */
	public EiWaitTaskTB getEiWaitTaskTBInstance() {
		return new EiWaitTaskTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask() {
		return eiWaitTaskDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public EiWaitTaskInfo searchEiWaitTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiWaitTaskSearchCond cond) {
		return eiWaitTaskDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask(
			EiWaitTaskSearchCond cond) {
		return eiWaitTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask(
			EiWaitTaskSearchCond cond, int start,
			int count) {
		return eiWaitTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public EiWaitTaskInfo registEiWaitTask(EiWaitTaskInfo instance)
		throws BLException {
		return eiWaitTaskDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiWaitTaskInfo updateEiWaitTask(EiWaitTaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getEitid());
		return eiWaitTaskDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiWaitTaskByPK(Integer pk)
		throws BLException {
		eiWaitTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiWaitTask(EiWaitTaskInfo instance)
		throws BLException {
		eiWaitTaskDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public EiWaitTaskInfo checkExistInstance(Integer pk)
		throws BLException {
		EiWaitTaskInfo instance = eiWaitTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}