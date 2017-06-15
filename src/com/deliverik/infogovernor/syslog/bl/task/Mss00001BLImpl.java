/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00001DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00001TB;

/**
  * ����: �豸��Ϣ��ҵ���߼�ʵ��
  * ��������: �豸��Ϣ��ҵ���߼�ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00001BLImpl extends BaseBLImpl implements
		Mss00001BL {

	/** �豸��Ϣ��DAO�ӿ� */
	protected Mss00001DAO mss00001DAO;
	
	/**
	 * �豸��Ϣ��DAO�ӿ��趨
	 *
	 * @param mss00001DAO �豸��Ϣ��DAO�ӿ�
	 */
	public void setMss00001DAO(Mss00001DAO mss00001DAO) {
		this.mss00001DAO = mss00001DAO;
	}

	/**
	 * �豸��Ϣ��ʵ��ȡ��
	 *
	 * @return �豸��Ϣ��ʵ��
	 */
	public Mss00001TB getMss00001TBInstance() {
		return new Mss00001TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00001Info> searchMss00001() {
		return mss00001DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00001Info searchMss00001ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00001SearchCond cond) {
		return mss00001DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00001Info> searchMss00001(
			Mss00001SearchCond cond) {
		return mss00001DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00001Info> searchMss00001(
			Mss00001SearchCond cond, int start,
			int count) {
		return mss00001DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00001Info registMss00001(Mss00001Info instance)
		throws BLException {
		return mss00001DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00001Info updateMss00001(Mss00001Info instance)
		throws BLException {
		checkExistInstance(instance.getDeviceid());
		return mss00001DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00001ByPK(Integer pk)
		throws BLException {
		mss00001DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00001(Mss00001Info instance)
		throws BLException {
		mss00001DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00001Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00001Info instance = mss00001DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}