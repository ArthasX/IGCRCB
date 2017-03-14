/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0424Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0424SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0424DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0424TB;

/**
  * ����: �������ͱ�ҵ���߼�ʵ��
  * ��������: �������ͱ�ҵ���߼�ʵ��
  * ������¼: 2012/07/18
  * �޸ļ�¼: 2012/08/10 ��ReportTypeBLImpl�����޸�ΪSOC0424BLImpl
  */
public class SOC0424BLImpl extends BaseBLImpl implements
		SOC0424BL {

	/** �������ͱ�DAO�ӿ� */
	protected SOC0424DAO soc0424DAO;
	
	/**
	 * �������ͱ�DAO�ӿ��趨
	 *
	 * @param soc0424DAO �������ͱ�DAO�ӿ�
	 */
	public void setSoc0424DAO(SOC0424DAO soc0424DAO) {
		this.soc0424DAO = soc0424DAO;
	}

	/**
	 * �������ͱ�ʵ��ȡ��
	 *
	 * @return �������ͱ�ʵ��
	 */
	public SOC0424TB getSOC0424Instance() {
		return new SOC0424TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0424Info> searchSOC0424() {
		return soc0424DAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0424SearchCond cond) {
		return soc0424DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0424Info> searchSOC0424(
			SOC0424SearchCond cond) {
		return soc0424DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0424Info> searchSOC0424(
			SOC0424SearchCond cond, int start,
			int count) {
		return soc0424DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0424Info registSOC0424(SOC0424Info instance)
		throws BLException {
		return soc0424DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0424Info updateSOC0424(SOC0424Info instance)
		throws BLException {
		return soc0424DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0424(SOC0424Info instance)
		throws BLException {
		soc0424DAO.delete(instance);
	}


}