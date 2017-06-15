/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0205DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0205TB;

/**
  * ����: ��������ҵ���߼�ʵ��
  * ��������: ��������ҵ���߼�ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportManageBLImpl�����޸�ΪSOC0205BLImpl
  */
public class SOC0205BLImpl extends BaseBLImpl implements
		SOC0205BL {

	/** ��������DAO�ӿ� */
	protected SOC0205DAO soc0205DAO;
	
	/**
	 * ��������DAO�ӿ��趨
	 *
	 * @param soc0205DAO ��������DAO�ӿ�
	 */
	public void setSoc0205DAO(SOC0205DAO soc0205DAO) {
		this.soc0205DAO = soc0205DAO;
	}

	/**
	 * ��������ʵ��ȡ��
	 *
	 * @return ��������ʵ��
	 */
	public SOC0205TB getSOC0205Instance() {
		return new SOC0205TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0205Info> searchSOC0205() {
		return soc0205DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0205Info searchSOC0205ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0205SearchCond cond) {
		return soc0205DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0205Info> searchSOC0205(
			SOC0205SearchCond cond) {
		return soc0205DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0205Info> searchSOC0205(
			SOC0205SearchCond cond, int start,
			int count) {
		return soc0205DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0205Info registSOC0205(SOC0205Info instance)
		throws BLException {
		return soc0205DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0205Info updateSOC0205(SOC0205Info instance)
		throws BLException {
		checkExistInstance(instance.getRmId());
		return soc0205DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0205ByPK(Integer pk)
		throws BLException {
		soc0205DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0205(SOC0205Info instance)
		throws BLException {
		soc0205DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0205Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0205Info instance = soc0205DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}