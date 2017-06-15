/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.dao.Mss00011DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00011VW;

import com.deliverik.infogovernor.syslog.model.Mss00011Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00011SearchCond;

/**
  * ����: mss00011ҵ���߼�ʵ��
  * ��������: mss00011ҵ���߼�ʵ��
  * ������¼: 2013/04/16
  * �޸ļ�¼: 
  */
public class Mss00011BLImpl extends BaseBLImpl implements
		Mss00011BL {

	/** mss00011DAO�ӿ� */
	protected Mss00011DAO mss00011DAO;
	
	/**
	 * mss00011DAO�ӿ��趨
	 *
	 * @param mss00011DAO mss00011DAO�ӿ�
	 */
	public void setMss00011DAO(Mss00011DAO mss00011DAO) {
		this.mss00011DAO = mss00011DAO;
	}

	/**
	 * mss00011ʵ��ȡ��
	 *
	 * @return mss00011ʵ��
	 */
	public Mss00011VW getMss00011VWInstance() {
		return new Mss00011VW();
	}
	

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00011Info> searchMss00011() {
		return mss00011DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00011Info searchMss00011ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00011SearchCond cond) {
		return mss00011DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00011Info> searchMss00011(
			Mss00011SearchCond cond) {
		return mss00011DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00011Info> searchMss00011(
			Mss00011SearchCond cond, int start,
			int count) {
		return mss00011DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00011Info registMss00011(Mss00011Info instance)
		throws BLException {
		return mss00011DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00011Info updateMss00011(Mss00011Info instance)
		throws BLException {
		checkExistInstance(instance.getDeviceid());
		return mss00011DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00011ByPK(Integer pk)
		throws BLException {
		mss00011DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00011(Mss00011Info instance)
		throws BLException {
		mss00011DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00011Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00011Info instance = mss00011DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}


}