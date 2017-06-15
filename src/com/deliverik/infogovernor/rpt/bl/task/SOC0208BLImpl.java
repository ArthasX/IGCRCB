/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0208SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0208DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0208PK;
import com.deliverik.infogovernor.rpt.model.entity.SOC0208TB;

/**
  * ����: �¼��������Ч��ҵ���߼�ʵ��
  * ��������: �¼��������Ч��ҵ���߼�ʵ��
  * ������¼: 2011/11/23
  * �޸ļ�¼: 2012/08/10 ��ServeEfficiencyBLImpl�����޸�ΪSOC0208BLImpl
  */
public class SOC0208BLImpl extends BaseBLImpl implements
		SOC0208BL {

	/** �¼��������Ч��DAO�ӿ� */
	protected SOC0208DAO soc0208DAO;
	
	/**
	 * �¼��������Ч��DAO�ӿ��趨
	 *
	 * @param soc0208DAO �¼��������Ч��DAO�ӿ�
	 */
	public void setSoc0208DAO(SOC0208DAO soc0208DAO) {
		this.soc0208DAO = soc0208DAO;
	}

	/**
	 * �¼��������Ч��ʵ��ȡ��
	 *
	 * @return �¼��������Ч��ʵ��
	 */
	public SOC0208TB getSOC0208Instance() {
		return new SOC0208TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0208Info> searchSOC0208() {
		return soc0208DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0208Info searchSOC0208ByPK(SOC0208PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0208SearchCond cond) {
		return soc0208DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0208Info> searchSOC0208(
			SOC0208SearchCond cond) {
		return soc0208DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0208Info> searchSOC0208(
			SOC0208SearchCond cond, int start,
			int count) {
		return soc0208DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0208Info registSOC0208(SOC0208Info instance)
		throws BLException {
		return soc0208DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0208Info updateSOC0208(SOC0208Info instance)
		throws BLException {
		checkExistInstance(new SOC0208PK(instance.getPrtype(), instance.getPivaralue(), instance.getEfficiencyTime()));
		return soc0208DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0208ByPK(SOC0208PK pk)
		throws BLException {
		soc0208DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0208(SOC0208Info instance)
		throws BLException {
		soc0208DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0208Info checkExistInstance(SOC0208PK pk)
		throws BLException {
		SOC0208Info instance = soc0208DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}