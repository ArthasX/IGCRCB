/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00005SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00005DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00005TB;

/**
  * ����: �澯��Ϣ���ҵ���߼�ʵ��
  * ��������: �澯��Ϣ���ҵ���߼�ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00005BLImpl extends BaseBLImpl implements
		Mss00005BL {

	/** �澯��Ϣ���DAO�ӿ� */
	protected Mss00005DAO mss00005DAO;
	
	/**
	 * �澯��Ϣ���DAO�ӿ��趨
	 *
	 * @param mss00005DAO �澯��Ϣ���DAO�ӿ�
	 */
	public void setMss00005DAO(Mss00005DAO mss00005DAO) {
		this.mss00005DAO = mss00005DAO;
	}

	/**
	 * �澯��Ϣ���ʵ��ȡ��
	 *
	 * @return �澯��Ϣ���ʵ��
	 */
	public Mss00005TB getMss00005TBInstance() {
		return new Mss00005TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00005Info> searchMss00005() {
		return mss00005DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00005Info searchMss00005ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00005SearchCond cond) throws Exception{
		return mss00005DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00005Info> searchMss00005(
			Mss00005SearchCond cond) throws Exception{
		return mss00005DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00005Info> searchMss00005(
			Mss00005SearchCond cond, int start,
			int count) throws Exception{
		return mss00005DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00005Info registMss00005(Mss00005Info instance)
		throws BLException {
		return mss00005DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00005Info updateMss00005(Mss00005Info instance)
		throws BLException {
		checkExistInstance(instance.getAlarmid());
		return mss00005DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00005ByPK(Integer pk)
		throws BLException {
		mss00005DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00005(Mss00005Info instance)
		throws BLException {
		mss00005DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00005Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00005Info instance = mss00005DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}