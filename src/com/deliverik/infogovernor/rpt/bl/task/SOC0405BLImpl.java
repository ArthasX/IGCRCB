/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0405Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0405SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0405DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0405TB;

/**
  * ����: �߼�������ʵʱ��ҵ���߼�ʵ��
  * ��������: �߼�������ʵʱ��ҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��LVCapacityRealTimeBLImpl������ΪSOC0405BLImpl
  */
public class SOC0405BLImpl extends BaseBLImpl implements
		SOC0405BL {

	/** �߼�������ʵʱ��DAO�ӿ� */
	protected SOC0405DAO soc0405DAO;
	
	/**
	 * �߼�������ʵʱ��DAO�ӿ��趨
	 *
	 * @param soc0405DAO �߼�������ʵʱ��DAO�ӿ�
	 */
	public void setSoc0405DAO(SOC0405DAO soc0405DAO) {
		this.soc0405DAO = soc0405DAO;
	}

	/**
	 * �߼�������ʵʱ��ʵ��ȡ��
	 *
	 * @return �߼�������ʵʱ��ʵ��
	 */
	public SOC0405TB getSOC0405Instance() {
		return new SOC0405TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0405Info> searchSOC0405() {
		return soc0405DAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0405SearchCond cond) {
		return soc0405DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0405Info> searchSOC0405(
			SOC0405SearchCond cond) {
		return soc0405DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0405Info> searchSOC0405(
			SOC0405SearchCond cond, int start,
			int count) {
		return soc0405DAO.findByCond(cond, start, count);
	}


}