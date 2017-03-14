/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00012Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00012SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00012DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00012TB;

/**
  * ����: MSS00012ҵ���߼�ʵ��
  * ��������: MSS00012ҵ���߼�ʵ��
  * ������¼: 2013/04/25
  * �޸ļ�¼: 
  */
public class Mss00012BLImpl extends BaseBLImpl implements
		Mss00012BL {

	/** MSS00012DAO�ӿ� */
	protected Mss00012DAO Mss00012DAO;
	

	/**
	 * MSS00012ʵ��ȡ��
	 *
	 * @return MSS00012ʵ��
	 */
	public Mss00012TB getMSS00012TBInstance() {
		return new Mss00012TB();
	}

	public Mss00012DAO getMss00012DAO() {
		return Mss00012DAO;
	}

	public void setMss00012DAO(Mss00012DAO mss00012DAO) {
		Mss00012DAO = mss00012DAO;
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00012Info> searchMSS00012() {
		return Mss00012DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00012Info searchMSS00012ByPK(Integer id)
		throws BLException {
		return checkExistInstance(id);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00012SearchCond cond) throws Exception{
		return Mss00012DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00012Info> searchMSS00012 (
			Mss00012SearchCond cond) throws Exception{
		return Mss00012DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00012Info> searchMSS00012(
			Mss00012SearchCond cond, int start,
			int count) throws Exception{
		return Mss00012DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00012Info registMSS00012(Mss00012Info instance)
		throws BLException {
		return Mss00012DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00012Info updateMSS00012(Mss00012Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return Mss00012DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMSS00012ByPK(Integer pk)
		throws BLException {
		Mss00012DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMSS00012(Mss00012Info instance)
		throws BLException {
		Mss00012DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Mss00012Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00012Info instance = Mss00012DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}