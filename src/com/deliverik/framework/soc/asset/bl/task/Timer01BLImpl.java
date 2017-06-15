/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCond;
import com.deliverik.framework.soc.asset.model.dao.Timer01DAO;
import com.deliverik.framework.soc.asset.model.entity.Timer01TB;

/**
  * ����: timer01ҵ���߼�ʵ��
  * ��������: timer01ҵ���߼�ʵ��
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public class Timer01BLImpl extends BaseBLImpl implements
		Timer01BL {

	/** timer01DAO�ӿ� */
	protected Timer01DAO timer01DAO;
	
	/**
	 * timer01DAO�ӿ��趨
	 *
	 * @param timer01DAO timer01DAO�ӿ�
	 */
	public void setTimer01DAO(Timer01DAO timer01DAO) {
		this.timer01DAO = timer01DAO;
	}

	/**
	 * timer01ʵ��ȡ��
	 *
	 * @return timer01ʵ��
	 */
	public Timer01TB getTimer01TBInstance() {
		return new Timer01TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Timer01Info> searchTimer01() {
		return timer01DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Timer01Info searchTimer01ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Timer01SearchCond cond) {
		return timer01DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Timer01Info> searchTimer01(
			Timer01SearchCond cond) {
		return timer01DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Timer01Info> searchTimer01(
			Timer01SearchCond cond, int start,
			int count) {
		return timer01DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Timer01Info registTimer01(Timer01Info instance)
		throws BLException {
		return timer01DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Timer01Info updateTimer01(Timer01Info instance)
		throws BLException {
		checkExistInstance(instance.getUuid());
		return timer01DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTimer01ByPK(String pk)
		throws BLException {
		timer01DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTimer01(Timer01Info instance)
		throws BLException {
		timer01DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Timer01Info checkExistInstance(String pk) {
		Timer01Info instance = timer01DAO.findByPK(pk);
		return instance;
	}

}