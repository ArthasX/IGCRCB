/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0419Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0419SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0419DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0419TB;

/**
  * ����: ��������ʵʱ��ҵ���߼�ʵ��
  * ��������: ��������ʵʱ��ҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��VGCapacityRealTimeBLImpl�����޸�ΪSOC0419BLImpl
  */
public class SOC0419BLImpl extends BaseBLImpl implements
		SOC0419BL {

	/** ��������ʵʱ��DAO�ӿ� */
	protected SOC0419DAO soc0419DAO;
	
	/**
	 * ��������ʵʱ��DAO�ӿ��趨
	 *
	 * @param soc0419DAO ��������ʵʱ��DAO�ӿ�
	 */
	public void setSoc0419DAO(SOC0419DAO soc0419DAO) {
		this.soc0419DAO = soc0419DAO;
	}

	/**
	 * ��������ʵʱ��ʵ��ȡ��
	 *
	 * @return ��������ʵʱ��ʵ��
	 */
	public SOC0419TB getSOC0419Instance() {
		return new SOC0419TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0419Info> searchSOC0419() {
		return soc0419DAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0419SearchCond cond) {
		return soc0419DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0419Info> searchSOC0419(
			SOC0419SearchCond cond) {
		return soc0419DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0419Info> searchSOC0419(
			SOC0419SearchCond cond, int start,
			int count) {
		return soc0419DAO.findByCond(cond, start, count);
	}


}