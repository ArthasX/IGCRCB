/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.Timer02Info;
import com.deliverik.framework.soc.asset.model.condition.Timer02SearchCond;
import com.deliverik.framework.soc.asset.model.dao.Timer02DAO;
import com.deliverik.framework.soc.asset.model.entity.Timer02TB;

/**
  * ����: timer02ҵ���߼�ʵ��
  * ��������: timer02ҵ���߼�ʵ��
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public class Timer02BLImpl extends BaseBLImpl implements
		Timer02BL {

	/** timer02DAO�ӿ� */
	protected Timer02DAO timer02DAO;
	
	/**
	 * timer02DAO�ӿ��趨
	 *
	 * @param timer02DAO timer02DAO�ӿ�
	 */
	public void setTimer02DAO(Timer02DAO timer02DAO) {
		this.timer02DAO = timer02DAO;
	}

	/**
	 * timer02ʵ��ȡ��
	 *
	 * @return timer02ʵ��
	 */
	public Timer02TB getTimer02TBInstance() {
		return new Timer02TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Timer02Info> searchTimer02() {
		return timer02DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Timer02Info searchTimer02ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Timer02SearchCond cond) {
		return timer02DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Timer02Info> searchTimer02(
			Timer02SearchCond cond) {
		return timer02DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Timer02Info> searchTimer02(
			Timer02SearchCond cond, int start,
			int count) {
		return timer02DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Timer02Info registTimer02(Timer02Info instance)
		throws BLException {
		return timer02DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Timer02Info updateTimer02(Timer02Info instance)
		throws BLException {
		checkExistInstance(instance.getUuid());
		return timer02DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTimer02ByPK(String pk)
		throws BLException {
		timer02DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTimer02(Timer02Info instance)
		throws BLException {
		timer02DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Timer02Info checkExistInstance(String pk)
		throws BLException {
		Timer02Info instance = timer02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}