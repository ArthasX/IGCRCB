/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0429Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0429SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0429DAO;

/**
  * ����: ����������ͼҵ���߼�ʵ��
  * ��������: ����������ͼҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��HostCapacityRealTimeVWBLImpl������ΪSOC0429BLImpl
  */
public class SOC0429BLImpl extends BaseBLImpl implements
		SOC0429BL {

	/** ����������ͼDAO�ӿ� */
	protected SOC0429DAO soc0429DAO;
	
	/**
	 * ����������ͼDAO�ӿ��趨
	 *
	 * @param hostCapacityVWDAO ����������ͼDAO�ӿ�
	 */
	public void setSoc0429DAO(SOC0429DAO soc0429DAO) {
		this.soc0429DAO = soc0429DAO;
	}


	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0429Info> searchSOC0429() {
		return soc0429DAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0429SearchCond cond) {
		return soc0429DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0429Info> searchSOC0429(
			SOC0429SearchCond cond) {
		return soc0429DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0429Info> searchSOC0429(
			SOC0429SearchCond cond, int start,
			int count) {
		return soc0429DAO.findByCond(cond, start, count);
	}

	

}