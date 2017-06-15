/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00009Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00009SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00009DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00009TB;

/**
  * ����: mss00009ҵ���߼�ʵ��
  * ��������: mss00009ҵ���߼�ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00009BLImpl extends BaseBLImpl implements
		Mss00009BL {

	/** mss00009DAO�ӿ� */
	protected Mss00009DAO mss00009DAO;
	
	/**
	 * mss00009DAO�ӿ��趨
	 *
	 * @param mss00009DAO mss00009DAO�ӿ�
	 */
	public void setMss00009DAO(Mss00009DAO mss00009DAO) {
		this.mss00009DAO = mss00009DAO;
	}

	/**
	 * mss00009ʵ��ȡ��
	 *
	 * @return mss00009ʵ��
	 */
	public Mss00009TB getMss00009TBInstance() {
		return new Mss00009TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00009Info> searchMss00009() {
		return mss00009DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00009Info searchMss00009ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00009SearchCond cond) throws Exception{
		return mss00009DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00009Info> searchMss00009(
			Mss00009SearchCond cond) throws Exception{
		return mss00009DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00009Info> searchMss00009(
			Mss00009SearchCond cond, int start,
			int count) throws Exception{
		return mss00009DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00009Info registMss00009(Mss00009Info instance)
		throws BLException {
		int maxid = mss00009DAO.getMaxID();
		Mss00009TB bean = (Mss00009TB) SerializationUtils.clone(instance);
		bean.setId(maxid+1);
		return mss00009DAO.save(bean);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00009Info updateMss00009(Mss00009Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return mss00009DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00009ByPK(Integer pk)
		throws BLException {
		mss00009DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00009(Mss00009Info instance)
		throws BLException {
		mss00009DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00009Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00009Info instance = mss00009DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}