/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0401Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0401SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0401DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0401TB;

/**
  * ����: ���ݿ�����ʵʱ��ҵ���߼�ʵ��
  * ��������: ���ݿ�����ʵʱ��ҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��DBCapacityRealTimeBLImpl������ΪSOC0401BLImpl
  */
public class SOC0401BLImpl extends BaseBLImpl implements
		SOC0401BL {

	/** ���ݿ�����ʵʱ��DAO�ӿ� */
	protected SOC0401DAO soc0401DAO;
	
	/**
	 * ���ݿ�����ʵʱ��DAO�ӿ��趨
	 *
	 * @param soc0401DAO ���ݿ�����ʵʱ��DAO�ӿ�
	 */
	public void setSoc0401DAO(SOC0401DAO soc0401DAO) {
		this.soc0401DAO = soc0401DAO;
	}

	/**
	 * ���ݿ�����ʵʱ��ʵ��ȡ��
	 *
	 * @return ���ݿ�����ʵʱ��ʵ��
	 */
	public SOC0401TB getSOC0401Instance() {
		return new SOC0401TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0401Info> searchSOC0401() {
		return soc0401DAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0401SearchCond cond) {
		return soc0401DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0401Info> searchSOC0401(
			SOC0401SearchCond cond) {
		return soc0401DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0401Info> searchSOC0401(
			SOC0401SearchCond cond, int start,
			int count) {
		return soc0401DAO.findByCond(cond, start, count);
	}
}