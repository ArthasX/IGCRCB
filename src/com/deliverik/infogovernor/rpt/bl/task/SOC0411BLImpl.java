/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0411Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0411SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0411DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0411TB;

/**
  * ����: �洢����ʵʱ��ҵ���߼�ʵ��
  * ��������: �洢����ʵʱ��ҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��StorageCapacityRealTimeBLImpl������ΪSOC0411BLImpl
  */
public class SOC0411BLImpl extends BaseBLImpl implements
		SOC0411BL {

	/** �洢����ʵʱ��DAO�ӿ� */
	protected SOC0411DAO soc0411DAO;
	
	/**
	 * �洢����ʵʱ��DAO�ӿ��趨
	 *
	 * @param soc0411DAO �洢����ʵʱ��DAO�ӿ�
	 */
	public void setSoc0411DAO(SOC0411DAO soc0411DAO) {
		this.soc0411DAO = soc0411DAO;
	}

	/**
	 * �洢����ʵʱ��ʵ��ȡ��
	 *
	 * @return �洢����ʵʱ��ʵ��
	 */
	public SOC0411TB getSOC0411Instance() {
		return new SOC0411TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0411Info> searchSOC0411() {
		return soc0411DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0411Info searchSOC0411ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0411SearchCond cond) {
		return soc0411DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0411Info> searchSOC0411(
			SOC0411SearchCond cond) {
		return soc0411DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0411Info> searchSOC0411(
			SOC0411SearchCond cond, int start,
			int count) {
		return soc0411DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0411Info registSOC0411(SOC0411Info instance)
		throws BLException {
		return soc0411DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0411Info updateSOC0411(SOC0411Info instance)
		throws BLException {
		checkExistInstance(instance.getScid());
		return soc0411DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0411ByPK(Integer pk)
		throws BLException {
		soc0411DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0411(SOC0411Info instance)
		throws BLException {
		soc0411DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0411Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0411Info instance = soc0411DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}