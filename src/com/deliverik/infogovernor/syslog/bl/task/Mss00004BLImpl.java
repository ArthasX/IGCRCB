/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;
import com.deliverik.infogovernor.syslog.model.condition.Mss00004SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00004DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00004TB;

/**
  * ����: �澯����ģ���ҵ���߼�ʵ��
  * ��������: �澯����ģ���ҵ���߼�ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00004BLImpl extends BaseBLImpl implements
		Mss00004BL {

	/** �澯����ģ���DAO�ӿ� */
	protected Mss00004DAO mss00004DAO;
	
	/**
	 * �澯����ģ���DAO�ӿ��趨
	 *
	 * @param mss00004DAO �澯����ģ���DAO�ӿ�
	 */
	public void setMss00004DAO(Mss00004DAO mss00004DAO) {
		this.mss00004DAO = mss00004DAO;
	}

	/**
	 * �澯����ģ���ʵ��ȡ��
	 *
	 * @return �澯����ģ���ʵ��
	 */
	public Mss00004TB getMss00004TBInstance() {
		return new Mss00004TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00004Info> searchMss00004() {
		return mss00004DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00004Info searchMss00004ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00004SearchCond cond) {
		return mss00004DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00004Info> searchMss00004(
			Mss00004SearchCond cond) {
		return mss00004DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00004Info> searchMss00004(
			Mss00004SearchCond cond, int start,
			int count) {
		return mss00004DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00004Info registMss00004(Mss00004Info instance)
		throws BLException {
		return mss00004DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00004Info updateMss00004(Mss00004Info instance)
		throws BLException {
		checkExistInstance(instance.getRuletempid());
		return mss00004DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00004ByPK(Integer pk)
		throws BLException {
		mss00004DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00004(Mss00004Info instance)
		throws BLException {
		mss00004DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00004Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00004Info instance = mss00004DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * 
	 * ��ѯģ����ͼ
	 *
	 * @���� zhaoyong
	 */
	public List<Mss00004VWInfo> findByCondVW(Mss00004SearchCond cond,int start, int end) {
		return mss00004DAO.findByCondVW(cond,start,end);
	}

}