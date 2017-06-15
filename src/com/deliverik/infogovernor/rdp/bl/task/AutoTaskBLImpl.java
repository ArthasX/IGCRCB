/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rdp.model.AutoTaskInfo;
import com.deliverik.infogovernor.rdp.model.condition.AutoTaskSearchCond;
import com.deliverik.infogovernor.rdp.model.dao.AutoTaskDAO;
import com.deliverik.infogovernor.rdp.model.entity.AutoTaskTB;

/**
  * ����: AutoTaskҵ���߼�ʵ��
  * ��������: AutoTaskҵ���߼�ʵ��
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public class AutoTaskBLImpl extends BaseBLImpl implements
		AutoTaskBL {

	/** AutoTaskDAO�ӿ� */
	protected AutoTaskDAO autoTaskDAO;
	
	/**
	 * AutoTaskDAO�ӿ��趨
	 *
	 * @param autoTaskDAO AutoTaskDAO�ӿ�
	 */
	public void setAutoTaskDAO(AutoTaskDAO autoTaskDAO) {
		this.autoTaskDAO = autoTaskDAO;
	}

	/**
	 * AutoTaskʵ��ȡ��
	 *
	 * @return AutoTaskʵ��
	 */
	public AutoTaskTB getAutoTaskTBInstance() {
		return new AutoTaskTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AutoTaskInfo> searchAutoTask() {
		return autoTaskDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AutoTaskInfo searchAutoTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AutoTaskSearchCond cond) {
		return autoTaskDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AutoTaskInfo> searchAutoTask(
			AutoTaskSearchCond cond) {
		return autoTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AutoTaskInfo> searchAutoTask(
			AutoTaskSearchCond cond, int start,
			int count) {
		return autoTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AutoTaskInfo registAutoTask(AutoTaskInfo instance)
		throws BLException {
		return autoTaskDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AutoTaskInfo updateAutoTask(AutoTaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return autoTaskDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAutoTaskByPK(Integer pk)
		throws BLException {
		autoTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAutoTask(AutoTaskInfo instance)
		throws BLException {
		autoTaskDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AutoTaskInfo checkExistInstance(Integer pk)
		throws BLException {
		AutoTaskInfo instance = autoTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}