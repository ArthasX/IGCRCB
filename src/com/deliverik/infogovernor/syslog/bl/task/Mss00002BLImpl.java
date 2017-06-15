/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00002Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00002SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00002DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00002TB;

/**
  * ����: �澯�����ҵ���߼�ʵ��
  * ��������: �澯�����ҵ���߼�ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00002BLImpl extends BaseBLImpl implements
		Mss00002BL {

	/** �澯�����DAO�ӿ� */
	protected Mss00002DAO mss00002DAO;
	
	/**
	 * �澯�����DAO�ӿ��趨
	 *
	 * @param mss00002DAO �澯�����DAO�ӿ�
	 */
	public void setMss00002DAO(Mss00002DAO mss00002DAO) {
		this.mss00002DAO = mss00002DAO;
	}

	/**
	 * �澯�����ʵ��ȡ��
	 *
	 * @return �澯�����ʵ��
	 */
	public Mss00002TB getMss00002TBInstance() {
		return new Mss00002TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00002Info> searchMss00002() {
		return mss00002DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00002Info searchMss00002ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00002SearchCond cond) throws Exception{
		return mss00002DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00002Info> searchMss00002(
			Mss00002SearchCond cond) {
		return mss00002DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00002Info> searchMss00002(
			Mss00002SearchCond cond, int start,
			int count) throws Exception{
		return mss00002DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00002Info registMss00002(Mss00002Info instance)
		throws BLException {
		return mss00002DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00002Info updateMss00002(Mss00002Info instance)
		throws BLException {
		checkExistInstance(instance.getRelationid());
		return mss00002DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00002ByPK(Integer pk)
		throws BLException {
		mss00002DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00002(Mss00002Info instance)
		throws BLException {
		mss00002DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00002Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00002Info instance = mss00002DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}