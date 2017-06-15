/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0410Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0410SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0410DAO;

/**
  * ����: �洢lunʵʱ��ҵ���߼�ʵ��
  * ��������: �洢lunʵʱ��ҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVStorageRealTimeBLImpl������ΪSOC0410BLImpl
  */
public class SOC0410BLImpl extends BaseBLImpl implements
		SOC0410BL {

	/** �洢lunʵʱ��DAO�ӿ� */
	protected SOC0410DAO soc0410DAO;

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0410Info> searchSOC0410() {
		return soc0410DAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0410SearchCond cond) {
		return soc0410DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0410Info> searchSOC0410(
			SOC0410SearchCond cond) {
		return soc0410DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0410Info> searchSOC0410(
			SOC0410SearchCond cond, int start,
			int count) {
		return soc0410DAO.findByCond(cond, start, count);
	}


	/**
	 * �洢lunʵʱ��DAO�ӿ��趨
	 *
	 * @param soc0410DAO �洢lunʵʱ��DAO�ӿ�
	 */
	public void setSoc0410DAO(SOC0410DAO soc0410DAO) {
		this.soc0410DAO = soc0410DAO;
	}

}