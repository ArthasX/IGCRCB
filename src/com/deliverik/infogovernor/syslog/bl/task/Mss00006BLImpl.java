/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00006Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00006SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00006DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00006TB;

/**
  * ����: �澯��Ϣ�±�ҵ���߼�ʵ��
  * ��������: �澯��Ϣ�±�ҵ���߼�ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00006BLImpl extends BaseBLImpl implements
		Mss00006BL {

	/** �澯��Ϣ�±�DAO�ӿ� */
	protected Mss00006DAO mss00006DAO;
	
	/**
	 * �澯��Ϣ�±�DAO�ӿ��趨
	 *
	 * @param mss00006DAO �澯��Ϣ�±�DAO�ӿ�
	 */
	public void setMss00006DAO(Mss00006DAO mss00006DAO) {
		this.mss00006DAO = mss00006DAO;
	}

	/**
	 * �澯��Ϣ�±�ʵ��ȡ��
	 *
	 * @return �澯��Ϣ�±�ʵ��
	 */
	public Mss00006TB getMss00006TBInstance() {
		return new Mss00006TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00006Info> searchMss00006() {
		return mss00006DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00006Info searchMss00006ByPK(Integer pk)
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
	public int getSearchCount(Mss00006SearchCond cond) throws Exception {
		return mss00006DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 * @throws Exception 
	 */
	public List<Mss00006Info> searchMss00006(
			Mss00006SearchCond cond) throws Exception {
		return mss00006DAO.findByCond(cond, 0, 0);
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
	public List<Mss00006Info> searchMss00006(
			Mss00006SearchCond cond, int start,
			int count) throws Exception {
		return mss00006DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00006Info registMss00006(Mss00006Info instance)
		throws BLException {
		return mss00006DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00006Info updateMss00006(Mss00006Info instance)
		throws BLException {
		checkExistInstance(instance.getAlarmid());
		return mss00006DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00006ByPK(Integer pk)
		throws BLException {
		mss00006DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00006(Mss00006Info instance)
		throws BLException {
		mss00006DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00006Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00006Info instance = mss00006DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}