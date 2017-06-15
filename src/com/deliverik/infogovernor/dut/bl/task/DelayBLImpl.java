/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCond;
import com.deliverik.infogovernor.dut.model.dao.DelayDAO;
import com.deliverik.infogovernor.dut.model.entity.DelayTB;

/**
  * ����: ��ʱ������Ϣ��ҵ���߼�ʵ��
  * ��������: ��ʱ������Ϣ��ҵ���߼�ʵ��
  * ������¼: 2012/04/05
  * �޸ļ�¼: 
  */
public class DelayBLImpl extends BaseBLImpl implements
		DelayBL {

	/** ��ʱ������Ϣ��DAO�ӿ� */
	protected DelayDAO delayDAO;
	
	/**
	 * ��ʱ������Ϣ��DAO�ӿ��趨
	 *
	 * @param delayDAO ��ʱ������Ϣ��DAO�ӿ�
	 */
	public void setDelayDAO(DelayDAO delayDAO) {
		this.delayDAO = delayDAO;
	}

	/**
	 * ��ʱ������Ϣ��ʵ��ȡ��
	 *
	 * @return ��ʱ������Ϣ��ʵ��
	 */
	public DelayTB getDelayTBInstance() {
		return new DelayTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DelayInfo> searchDelay() {
		return delayDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DelayInfo searchDelayByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(DelaySearchCond cond) {
		return delayDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<DelayInfo> searchDelay(
			DelaySearchCond cond) {
		return delayDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DelayInfo> searchDelay(
			DelaySearchCond cond, int start,
			int count) {
		return delayDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public DelayInfo registDelay(DelayInfo instance)
		throws BLException {
		return delayDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public DelayInfo updateDelay(DelayInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return delayDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteDelayByPK(Integer pk)
		throws BLException {
		delayDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteDelay(DelayInfo instance)
		throws BLException {
		delayDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public DelayInfo checkExistInstance(Integer pk)
		throws BLException {
		DelayInfo instance = delayDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}