/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0204SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0204DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0204TB;

/**
  * ����: �����Զ�����ҵ���߼�ʵ��
  * ��������: �����Զ�����ҵ���߼�ʵ��
  * ������¼: 2012/07/20
  * �޸ļ�¼: 2012/08/10 ��ReportCustomLinkBLImpl�����޸�ΪSOC0204BLImpl
  */
public class SOC0204BLImpl extends BaseBLImpl implements
		SOC0204BL {

	/** �����Զ�����DAO�ӿ� */
	protected SOC0204DAO soc0204DAO;
	
	/**
	 * �����Զ�����DAO�ӿ��趨
	 *
	 * @param soc0204DAO �����Զ�����DAO�ӿ�
	 */
	public void setSoc0204DAO(SOC0204DAO soc0204DAO) {
		this.soc0204DAO = soc0204DAO;
	}

	/**
	 * �����Զ�����ʵ��ȡ��
	 *
	 * @return �����Զ�����ʵ��
	 */
	public SOC0204TB getSOC0204Instance() {
		return new SOC0204TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0204Info> searchSOC0204() {
		return soc0204DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0204Info searchSOC0204ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0204SearchCond cond) {
		return soc0204DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0204Info> searchSOC0204(
			SOC0204SearchCond cond) {
		return soc0204DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0204Info> searchSOC0204(
			SOC0204SearchCond cond, int start,
			int count) {
		return soc0204DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0204Info registSOC0204(SOC0204Info instance)
		throws BLException {
		return soc0204DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0204Info updateSOC0204(SOC0204Info instance)
		throws BLException {
		checkExistInstance(instance.getRclId());
		return soc0204DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0204ByPK(Integer pk)
		throws BLException {
		soc0204DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0204(SOC0204Info instance)
		throws BLException {
		soc0204DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0204Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0204Info instance = soc0204DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}