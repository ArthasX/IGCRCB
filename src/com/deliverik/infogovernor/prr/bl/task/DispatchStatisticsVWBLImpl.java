/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;
import com.deliverik.infogovernor.prr.model.condition.DispatchStatisticsVWSearchCond;
import com.deliverik.infogovernor.prr.model.dao.DispatchStatisticsVWDAO;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;

/**
  * ����: ��������ͳ��ҵ���߼�ʵ��
  * ��������: ��������ͳ��ҵ���߼�ʵ��
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public class DispatchStatisticsVWBLImpl extends BaseBLImpl implements
		DispatchStatisticsVWBL {

	/** ��������ͳ��DAO�ӿ� */
	protected DispatchStatisticsVWDAO dispatchStatisticsVWDAO;
	
	/**
	 * ��������ͳ��DAO�ӿ��趨
	 *
	 * @param dispatchStatisticsVWDAO ��������ͳ��DAO�ӿ�
	 */
	public void setDispatchStatisticsVWDAO(DispatchStatisticsVWDAO dispatchStatisticsVWDAO) {
		this.dispatchStatisticsVWDAO = dispatchStatisticsVWDAO;
	}

	/**
	 * ��������ͳ��ʵ��ȡ��
	 *
	 * @return ��������ͳ��ʵ��
	 */
	public DispatchStatisticsVW getDispatchStatisticsVWTBInstance() {
		return new DispatchStatisticsVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW() {
		return dispatchStatisticsVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DispatchStatisticsVWInfo searchDispatchStatisticsVWByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(DispatchStatisticsVWSearchCond cond) {
		return dispatchStatisticsVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond) {
		return dispatchStatisticsVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond, int start,
			int count) {
		return dispatchStatisticsVWDAO.findByCond(cond, start, count);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DispatchStatisticsVWInfo> findDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond, int start,
			int count) {
		return dispatchStatisticsVWDAO.findDispatchStatistics(cond, start, count);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getDispatchStatisticsSearchCount(DispatchStatisticsVWSearchCond cond) {
		return dispatchStatisticsVWDAO.findDispatchStatisticsSearchCount(cond);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public DispatchStatisticsVWInfo registDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException {
		return dispatchStatisticsVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public DispatchStatisticsVWInfo updateDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getDsuserid());
		return dispatchStatisticsVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteDispatchStatisticsVWByPK(String pk)
		throws BLException {
		dispatchStatisticsVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException {
		dispatchStatisticsVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public DispatchStatisticsVWInfo checkExistInstance(String pk)
		throws BLException {
		DispatchStatisticsVWInfo instance = dispatchStatisticsVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}