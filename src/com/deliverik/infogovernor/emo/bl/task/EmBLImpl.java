/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.emo.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.emo.model.EmInfo;
import com.deliverik.infogovernor.emo.model.condition.EmSearchCond;
import com.deliverik.infogovernor.emo.model.dao.EmDAO;
import com.deliverik.infogovernor.emo.model.entity.EmTB;

/**
  * ����: oracle���ܲɼ�ҵ���߼�ʵ��
  * ��������: oracle���ܲɼ�ҵ���߼�ʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public class EmBLImpl extends BaseBLImpl implements
		EmBL {

	/** oracle���ܲɼ�DAO�ӿ� */
	protected EmDAO emDAO;
	
	/**
	 * oracle���ܲɼ�DAO�ӿ��趨
	 *
	 * @param emDAO oracle���ܲɼ�DAO�ӿ�
	 */
	public void setEmDAO(EmDAO emDAO) {
		this.emDAO = emDAO;
	}

	/**
	 * oracle���ܲɼ�ʵ��ȡ��
	 *
	 * @return oracle���ܲɼ�ʵ��
	 */
	public EmTB getEmTBInstance() {
		return new EmTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EmInfo> searchEm() {
		return emDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EmInfo searchEmByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EmSearchCond cond) {
		return emDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EmInfo> searchEm(
			EmSearchCond cond) {
		return emDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EmInfo> searchEm(
			EmSearchCond cond, int start,
			int count) {
		return emDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EmInfo registEm(EmInfo instance)
		throws BLException {
		return emDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EmInfo updateEm(EmInfo instance)
		throws BLException {
		checkExistInstance(instance.getEm_id());
		return emDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEmByPK(Integer pk)
		throws BLException {
		emDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEm(EmInfo instance)
		throws BLException {
		emDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public EmInfo checkExistInstance(Integer pk)
		throws BLException {
		EmInfo instance = emDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}