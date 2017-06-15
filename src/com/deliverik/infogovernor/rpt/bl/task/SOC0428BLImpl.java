/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0428Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0428SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0428DAO;

/**
  * ����: ҵ��ϵͳ��ͼҵ���߼�ʵ��
  * ��������: ҵ��ϵͳ��ͼҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��BusinessCapacityRealTimeVWBLImpl������ΪSOC0428BLImpl
  */
public class SOC0428BLImpl extends BaseBLImpl implements
		SOC0428BL {

	/** ҵ��ϵͳ��ͼDAO�ӿ� */
	protected SOC0428DAO soc0428DAO;
	
	/**
	 * ҵ��ϵͳ��ͼDAO�ӿ��趨
	 *
	 * @param soc0428DAO ҵ��ϵͳ��ͼDAO�ӿ�
	 */
	public void setSoc0428DAO(SOC0428DAO soc0428DAO) {
		this.soc0428DAO = soc0428DAO;
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0428Info> searchSOC0428() {
		return soc0428DAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0428SearchCond cond) {
		return soc0428DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0428Info> searchSOC0428(
			SOC0428SearchCond cond) {
		return soc0428DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0428Info> searchSOC0428(
			SOC0428SearchCond cond, int start,
			int count) {
		return soc0428DAO.findByCond(cond, start, count);
	}
	/**
	 * ��������
	 */
	public SOC0428Info searchSOC0428ByPK(Integer pk){
		return soc0428DAO.findByPK(pk); 
	}
}