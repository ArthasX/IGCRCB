/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.condition.CITaskSearchCond;
import com.deliverik.framework.asset.model.dao.CITaskDAO;
import com.deliverik.framework.asset.model.entity.CITaskTB;

/**
  * ����: CI��������ҵ���߼�ʵ��
  * ��������: CI��������ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class CITaskBLImpl extends BaseBLImpl implements
		CITaskBL {

	/** CI��������DAO�ӿ� */
	protected CITaskDAO ciTaskDAO;
	
	/**
	 * CI��������DAO�ӿ��趨
	 *
	 * @param ciTaskDAO CI��������DAO�ӿ�
	 */
	public void setCiTaskDAO(CITaskDAO ciTaskDAO) {
		this.ciTaskDAO = ciTaskDAO;
	}

	/**
	 * CI��������ʵ��ȡ��
	 *
	 * @return CI��������ʵ��
	 */
	public CITaskTB getCITaskTBInstance() {
		return new CITaskTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CITaskInfo> searchCITask() {
		return ciTaskDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CITaskInfo searchCITaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CITaskSearchCond cond) {
		return ciTaskDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CITaskInfo> searchCITask(
			CITaskSearchCond cond) {
		return ciTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CITaskInfo> searchCITask(
			CITaskSearchCond cond, int start,
			int count) {
		return ciTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CITaskInfo registCITask(CITaskInfo instance)
		throws BLException {
		return ciTaskDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CITaskInfo updateCITask(CITaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getCitid());
		return ciTaskDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCITaskByPK(Integer pk)
		throws BLException {
		ciTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCITask(CITaskInfo instance)
		throws BLException {
		ciTaskDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CITaskInfo checkExistInstance(Integer pk)
		throws BLException {
		CITaskInfo instance = ciTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}