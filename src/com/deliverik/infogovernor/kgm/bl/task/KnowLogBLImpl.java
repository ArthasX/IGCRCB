/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowLogDAO;
import com.deliverik.infogovernor.kgm.model.entity.KnowLogTB;

/**
  * ����: knowLogҵ���߼�ʵ��
  * ��������: knowLogҵ���߼�ʵ��
  * ������¼: 2011/05/30
  * �޸ļ�¼: 
  */
public class KnowLogBLImpl extends BaseBLImpl implements
		KnowLogBL {

	/** knowLogDAO�ӿ� */
	protected KnowLogDAO knowLogDAO;
	
	/**
	 * knowLogDAO�ӿ��趨
	 *
	 * @param knowLogDAO knowLogDAO�ӿ�
	 */
	public void setKnowLogDAO(KnowLogDAO knowLogDAO) {
		this.knowLogDAO = knowLogDAO;
	}

	/**
	 * knowLogʵ��ȡ��
	 *
	 * @return knowLogʵ��
	 */
	public KnowLogTB getKnowLogTBInstance() {
		return new KnowLogTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<KnowLogInfo> searchKnowLog() {
		return knowLogDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public KnowLogInfo searchKnowLogByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(KnowLogSearchCond cond) {
		return knowLogDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<KnowLogInfo> searchKnowLog(
			KnowLogSearchCond cond) {
		return knowLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowLogInfo> searchKnowLog(
			KnowLogSearchCond cond, int start,
			int count) {
		return knowLogDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public KnowLogInfo registKnowLog(KnowLogInfo instance)
		throws BLException {
		return knowLogDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public KnowLogInfo updateKnowLog(KnowLogInfo instance)
		throws BLException {
		checkExistInstance(instance.getKlid());
		return knowLogDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteKnowLogByPK(Integer pk)
		throws BLException {
		knowLogDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteKnowLog(KnowLogInfo instance)
		throws BLException {
		knowLogDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public KnowLogInfo checkExistInstance(Integer pk)
		throws BLException {
		KnowLogInfo instance = knowLogDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * �����־��Ϣ
	 *
	 * @param instance  �����־��Ϣ
	 */
	public KnowLogInfo addKnowLog(Integer klkid,String userId,String userName,String time,String desc) throws BLException{
		//�����־��Ϣ��ʼ
		KnowLogTB kltb = new KnowLogTB();
		kltb.setKlkid(klkid);
		kltb.setKluserid(userId);
		kltb.setKlusername(userName);
		kltb.setKltime(time);
		kltb.setKldesc(desc);
		return this.registKnowLog(kltb);
		//�����־��Ϣ����
	}

}