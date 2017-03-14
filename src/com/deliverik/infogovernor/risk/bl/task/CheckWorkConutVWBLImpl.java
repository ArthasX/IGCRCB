/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkConutVWSearchCond;
import com.deliverik.infogovernor.risk.model.dao.CheckWorkConutVWDAO;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkConutVW;

/**
  * ����: ��鹤��ͳ�Ʊ���ҵ���߼�ʵ��
  * ��������: ��鹤��ͳ�Ʊ���ҵ���߼�ʵ��
  * ������¼: 2014/07/09
  * �޸ļ�¼: 
  */
public class CheckWorkConutVWBLImpl extends BaseBLImpl implements
		CheckWorkConutVWBL {

	/** ��鹤��ͳ�Ʊ���DAO�ӿ� */
	protected CheckWorkConutVWDAO checkWorkConutVWDAO;
	
	/**
	 * ��鹤��ͳ�Ʊ���DAO�ӿ��趨
	 *
	 * @param checkWorkConutVWDAO ��鹤��ͳ�Ʊ���DAO�ӿ�
	 */
	public void setCheckWorkConutVWDAO(CheckWorkConutVWDAO checkWorkConutVWDAO) {
		this.checkWorkConutVWDAO = checkWorkConutVWDAO;
	}

	/**
	 * ��鹤��ͳ�Ʊ���ʵ��ȡ��
	 *
	 * @return ��鹤��ͳ�Ʊ���ʵ��
	 */
	public CheckWorkConutVW getCheckWorkConutVWTBInstance() {
		return new CheckWorkConutVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckWorkConutVWInfo> searchCheckWorkConutVW() {
		return checkWorkConutVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckWorkConutVWInfo searchCheckWorkConutVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckWorkConutVWSearchCond cond) {
		return checkWorkConutVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckWorkConutVWInfo> searchCheckWorkConutVW(
			CheckWorkConutVWSearchCond cond) {
		return checkWorkConutVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckWorkConutVWInfo> searchCheckWorkConutVW(
			CheckWorkConutVWSearchCond cond, int start,
			int count) {
		return checkWorkConutVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckWorkConutVWInfo registCheckWorkConutVW(CheckWorkConutVWInfo instance)
		throws BLException {
		return checkWorkConutVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckWorkConutVWInfo updateCheckWorkConutVW(CheckWorkConutVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getRcid());
		return checkWorkConutVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckWorkConutVWByPK(Integer pk)
		throws BLException {
		checkWorkConutVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckWorkConutVW(CheckWorkConutVWInfo instance)
		throws BLException {
		checkWorkConutVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CheckWorkConutVWInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckWorkConutVWInfo instance = checkWorkConutVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}