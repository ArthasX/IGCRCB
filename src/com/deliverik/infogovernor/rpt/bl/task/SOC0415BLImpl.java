/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0415Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0415SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0415DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0415TB;

/**
  * ����: ��ռ�����ʵʱ��ҵ���߼�ʵ��
  * ��������: ��ռ�����ʵʱ��ҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��TSCapacityRealTimeBLImpl�����޸�ΪSOC0415BLImpl
  */
public class SOC0415BLImpl extends BaseBLImpl implements
		SOC0415BL {

	/** ��ռ�����ʵʱ��DAO�ӿ� */
	protected SOC0415DAO soc0415DAO;
	
	/**
	 * ��ռ�����ʵʱ��DAO�ӿ��趨
	 *
	 * @param soc0415DAO ��ռ�����ʵʱ��DAO�ӿ�
	 */
	public void setSoc0415DAO(SOC0415DAO soc0415DAO) {
		this.soc0415DAO = soc0415DAO;
	}

	/**
	 * ��ռ�����ʵʱ��ʵ��ȡ��
	 *
	 * @return ��ռ�����ʵʱ��ʵ��
	 */
	public SOC0415TB getSOC0415Instance() {
		return new SOC0415TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0415Info> searchSOC0415() {
		return soc0415DAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0415SearchCond cond) {
		return soc0415DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0415Info> searchSOC0415(
			SOC0415SearchCond cond) {
		return soc0415DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0415Info> searchSOC0415(
			SOC0415SearchCond cond, int start,
			int count) {
		return soc0415DAO.findByCond(cond, start, count);
	}


}