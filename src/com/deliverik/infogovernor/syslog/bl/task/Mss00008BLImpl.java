/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00008Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00008SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00008DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00008TB;

/**
  * ����: SYSLOG��Ϣ��ҵ���߼�ʵ��
  * ��������: SYSLOG��Ϣ��ҵ���߼�ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00008BLImpl extends BaseBLImpl implements
		Mss00008BL {

	/** SYSLOG��Ϣ��DAO�ӿ� */
	protected Mss00008DAO mss00008DAO;
	
	/**
	 * SYSLOG��Ϣ��DAO�ӿ��趨
	 *
	 * @param mss00008DAO SYSLOG��Ϣ��DAO�ӿ�
	 */
	public void setMss00008DAO(Mss00008DAO mss00008DAO) {
		this.mss00008DAO = mss00008DAO;
	}

	/**
	 * SYSLOG��Ϣ��ʵ��ȡ��
	 *
	 * @return SYSLOG��Ϣ��ʵ��
	 */
	public Mss00008TB getMss00008TBInstance() {
		return new Mss00008TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00008Info> searchMss00008() {
		return mss00008DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00008Info searchMss00008ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00008SearchCond cond) throws Exception{
		return mss00008DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00008Info> searchMss00008 (
			Mss00008SearchCond cond) throws Exception{
		return mss00008DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00008Info> searchMss00008(
			Mss00008SearchCond cond, int start,
			int count) throws Exception{
		return mss00008DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00008Info registMss00008(Mss00008Info instance)
		throws BLException {
		return mss00008DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00008Info updateMss00008(Mss00008Info instance)
		throws BLException {
		checkExistInstance(instance.getID());
		return mss00008DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00008ByPK(Integer pk)
		throws BLException {
		mss00008DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00008(Mss00008Info instance)
		throws BLException {
		mss00008DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00008Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00008Info instance = mss00008DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}