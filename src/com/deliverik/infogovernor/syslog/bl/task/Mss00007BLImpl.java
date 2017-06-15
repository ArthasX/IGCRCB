/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00007Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00007SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00007DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00007TB;

/**
  * ����: �澯��Ϣ��ʷ��ҵ���߼�ʵ��
  * ��������: �澯��Ϣ��ʷ��ҵ���߼�ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00007BLImpl extends BaseBLImpl implements
		Mss00007BL {

	/** �澯��Ϣ��ʷ��DAO�ӿ� */
	protected Mss00007DAO mss00007DAO;
	
	/**
	 * �澯��Ϣ��ʷ��DAO�ӿ��趨
	 *
	 * @param mss00007DAO �澯��Ϣ��ʷ��DAO�ӿ�
	 */
	public void setMss00007DAO(Mss00007DAO mss00007DAO) {
		this.mss00007DAO = mss00007DAO;
	}

	/**
	 * �澯��Ϣ��ʷ��ʵ��ȡ��
	 *
	 * @return �澯��Ϣ��ʷ��ʵ��
	 */
	public Mss00007TB getMss00007TBInstance() {
		return new Mss00007TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00007Info> searchMss00007() {
		return mss00007DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00007Info searchMss00007ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws Exception 
	 */
	public int getSearchCount(Mss00007SearchCond cond) throws Exception {
		return mss00007DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 * @throws Exception 
	 */
	public List<Mss00007Info> searchMss00007(
			Mss00007SearchCond cond) throws Exception {
		return mss00007DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws Exception 
	 */
	public List<Mss00007Info> searchMss00007(
			Mss00007SearchCond cond, int start,
			int count) throws Exception {
		return mss00007DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00007Info registMss00007(Mss00007Info instance)
		throws BLException {
		return mss00007DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00007Info updateMss00007(Mss00007Info instance)
		throws BLException {
		checkExistInstance(instance.getAlarmid());
		return mss00007DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00007ByPK(Integer pk)
		throws BLException {
		mss00007DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00007(Mss00007Info instance)
		throws BLException {
		mss00007DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00007Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00007Info instance = mss00007DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}