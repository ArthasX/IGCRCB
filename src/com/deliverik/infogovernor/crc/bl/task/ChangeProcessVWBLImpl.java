/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.condition.ChangeProcessVWSearchCond;
import com.deliverik.infogovernor.crc.model.dao.ChangeProcessVWDAO;
import com.deliverik.infogovernor.crc.model.entity.ChangeProcessVWTB;

/**
  * ����: �������ҵ���߼�ʵ��
  * ��������: �������ҵ���߼�ʵ��
  * ������¼: 2015/01/04
  * �޸ļ�¼: 
  */
public class ChangeProcessVWBLImpl extends BaseBLImpl implements
		ChangeProcessVWBL {

	/** �������DAO�ӿ� */
	protected ChangeProcessVWDAO changeProcessVWDAO;
	
	/**
	 * �������DAO�ӿ��趨
	 *
	 * @param changeProcessVWDAO �������DAO�ӿ�
	 */
	public void setChangeProcessVWDAO(ChangeProcessVWDAO changeProcessVWDAO) {
		this.changeProcessVWDAO = changeProcessVWDAO;
	}

	/**
	 * �������ʵ��ȡ��
	 *
	 * @return �������ʵ��
	 */
	public ChangeProcessVWTB getChangeProcessVWTBInstance() {
		return new ChangeProcessVWTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ChangeProcessVWInfo> searchChangeProcessVW() {
		return changeProcessVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ChangeProcessVWInfo searchChangeProcessVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ChangeProcessVWSearchCond cond) {
		return changeProcessVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ChangeProcessVWInfo> searchChangeProcessVW(
			ChangeProcessVWSearchCond cond) {
		return changeProcessVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ChangeProcessVWInfo> searchChangeProcessVW(
			ChangeProcessVWSearchCond cond, int start,
			int count) {
		return changeProcessVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ChangeProcessVWInfo registChangeProcessVW(ChangeProcessVWInfo instance)
		throws BLException {
		return changeProcessVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ChangeProcessVWInfo updateChangeProcessVW(ChangeProcessVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getPrid());
		return changeProcessVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteChangeProcessVWByPK(Integer pk)
		throws BLException {
		changeProcessVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteChangeProcessVW(ChangeProcessVWInfo instance)
		throws BLException {
		changeProcessVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ChangeProcessVWInfo checkExistInstance(Integer pk)
		throws BLException {
		ChangeProcessVWInfo instance = changeProcessVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}