/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00013Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00013SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00013DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00013TB;

/**
  * ����: mss00013ҵ���߼�ʵ��
  * ��������: mss00013ҵ���߼�ʵ��
  * ������¼: 2013/08/15
  * �޸ļ�¼: 
  */
public class Mss00013BLImpl extends BaseBLImpl implements
		Mss00013BL {

	/** mss00013DAO�ӿ� */
	protected Mss00013DAO mss00013DAO;
	
	/**
	 * mss00013DAO�ӿ��趨
	 *
	 * @param mss00013DAO mss00013DAO�ӿ�
	 */
	public void setMss00013DAO(Mss00013DAO mss00013DAO) {
		this.mss00013DAO = mss00013DAO;
	}

	/**
	 * mss00013ʵ��ȡ��
	 *
	 * @return mss00013ʵ��
	 */
	public Mss00013TB getMss00013TBInstance() {
		return new Mss00013TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00013Info> searchMss00013() {
		return mss00013DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00013Info searchMss00013ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00013SearchCond cond) {
		return mss00013DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00013Info> searchMss00013(
			Mss00013SearchCond cond) {
		return mss00013DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00013Info> searchMss00013(
			Mss00013SearchCond cond, int start,
			int count) {
		return mss00013DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00013Info registMss00013(Mss00013Info instance)
		throws BLException {
		return mss00013DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00013Info updateMss00013(Mss00013Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return mss00013DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00013ByPK(Integer pk)
		throws BLException {
		mss00013DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00013(Mss00013Info instance)
		throws BLException {
		mss00013DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00013Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00013Info instance = mss00013DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}