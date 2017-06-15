/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00003SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00003DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00003TB;

/**
  * ����: �澯����������ҵ���߼�ʵ��
  * ��������: �澯����������ҵ���߼�ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00003BLImpl extends BaseBLImpl implements
		Mss00003BL {

	/** �澯����������DAO�ӿ� */
	protected Mss00003DAO mss00003DAO;
	
	/**
	 * �澯����������DAO�ӿ��趨
	 *
	 * @param mss00003DAO �澯����������DAO�ӿ�
	 */
	public void setMss00003DAO(Mss00003DAO mss00003DAO) {
		this.mss00003DAO = mss00003DAO;
	}

	/**
	 * �澯����������ʵ��ȡ��
	 *
	 * @return �澯����������ʵ��
	 */
	public Mss00003TB getMss00003TBInstance() {
		return new Mss00003TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00003Info> searchMss00003() {
		return mss00003DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00003Info searchMss00003ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00003SearchCond cond) {
		return mss00003DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00003Info> searchMss00003(
			Mss00003SearchCond cond) {
		return mss00003DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00003Info> searchMss00003(
			Mss00003SearchCond cond, int start,
			int count) {
		return mss00003DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00003Info registMss00003(Mss00003Info instance)
		throws BLException {
		return mss00003DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00003Info updateMss00003(Mss00003Info instance)
		throws BLException {
		checkExistInstance(instance.getRuleconditionid());
		return mss00003DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00003ByPK(Integer pk)
		throws BLException {
		mss00003DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00003(Mss00003Info instance)
		throws BLException {
		mss00003DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00003Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00003Info instance = mss00003DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}