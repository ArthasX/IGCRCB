/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00014Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00014SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00014DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00014TB;

/**
  * ����: mss00014ҵ���߼�ʵ��
  * ��������: mss00014ҵ���߼�ʵ��
  * ������¼: 2014/01/21
  * �޸ļ�¼: 
  */
public class Mss00014BLImpl extends BaseBLImpl implements
		Mss00014BL {

	/** mss00014DAO�ӿ� */
	protected Mss00014DAO mss00014DAO;
	
	/**
	 * mss00014DAO�ӿ��趨
	 *
	 * @param mss00014DAO mss00014DAO�ӿ�
	 */
	public void setMss00014DAO(Mss00014DAO mss00014DAO) {
		this.mss00014DAO = mss00014DAO;
	}

	/**
	 * mss00014ʵ��ȡ��
	 *
	 * @return mss00014ʵ��
	 */
	public Mss00014TB getMss00014TBInstance() {
		return new Mss00014TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00014Info> searchMss00014() {
		return mss00014DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00014Info searchMss00014ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00014SearchCond cond) {
		return mss00014DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00014Info> searchMss00014(
			Mss00014SearchCond cond) {
		return mss00014DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00014Info> searchMss00014(
			Mss00014SearchCond cond, int start,
			int count) {
		return mss00014DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00014Info registMss00014(Mss00014Info instance)
		throws BLException {
		return mss00014DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00014Info updateMss00014(Mss00014Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return mss00014DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00014ByPK(Integer pk)
		throws BLException {
		mss00014DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00014(Mss00014Info instance)
		throws BLException {
		mss00014DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00014Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00014Info instance = mss00014DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}