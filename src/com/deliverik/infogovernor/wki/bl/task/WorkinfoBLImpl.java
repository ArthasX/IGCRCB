/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wki.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;
import com.deliverik.infogovernor.wki.model.condition.WorkinfoSearchCond;
import com.deliverik.infogovernor.wki.model.dao.WorkinfoDAO;
import com.deliverik.infogovernor.wki.model.entity.WorkinfoTB;

/**
  * ����: ������Ϣҵ���߼�ʵ��
  * ��������: ������Ϣҵ���߼�ʵ��
  * ������¼: 2017/03/02
  * �޸ļ�¼: 
  */
public class WorkinfoBLImpl extends BaseBLImpl implements
		WorkinfoBL {

	/** ������ϢDAO�ӿ� */
	protected WorkinfoDAO workinfoDAO;
	
	/**
	 * ������ϢDAO�ӿ��趨
	 *
	 * @param workinfoDAO ������ϢDAO�ӿ�
	 */
	public void setWorkinfoDAO(WorkinfoDAO workinfoDAO) {
		this.workinfoDAO = workinfoDAO;
	}

	/**
	 * ������Ϣʵ��ȡ��
	 *
	 * @return ������Ϣʵ��
	 */
	public WorkinfoTB getWorkinfoTBInstance() {
		return new WorkinfoTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkinfoInfo> searchWorkinfo() {
		return workinfoDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkinfoInfo searchWorkinfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkinfoSearchCond cond) {
		return workinfoDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkinfoInfo> searchWorkinfo(
			WorkinfoSearchCond cond) {
		return workinfoDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkinfoInfo> searchWorkinfo(
			WorkinfoSearchCond cond, int start,
			int count) {
		return workinfoDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkinfoInfo registWorkinfo(WorkinfoInfo instance)
		throws BLException {
		return workinfoDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkinfoInfo updateWorkinfo(WorkinfoInfo instance)
		throws BLException {
		checkExistInstance(instance.getWorkinfoid());
		return workinfoDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkinfoByPK(Integer pk)
		throws BLException {
		workinfoDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkinfo(WorkinfoInfo instance)
		throws BLException {
		workinfoDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public WorkinfoInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkinfoInfo instance = workinfoDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}