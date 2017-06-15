/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.asset.model.dao.CIResultDAO;
import com.deliverik.framework.asset.model.entity.CIResultTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * ����: CI����ԱȽ����Ϣ��ҵ���߼�ʵ��
  * ��������: CI����ԱȽ����Ϣ��ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class CIResultBLImpl extends BaseBLImpl implements
		CIResultBL {

	/** CI����ԱȽ����Ϣ��DAO�ӿ� */
	protected CIResultDAO ciResultDAO;
	
	/**
	 * CI����ԱȽ����Ϣ��DAO�ӿ��趨
	 *
	 * @param ciResultDAO CI����ԱȽ����Ϣ��DAO�ӿ�
	 */
	public void setCiResultDAO(CIResultDAO ciResultDAO) {
		this.ciResultDAO = ciResultDAO;
	}

	/**
	 * CI����ԱȽ����Ϣ��ʵ��ȡ��
	 *
	 * @return CI����ԱȽ����Ϣ��ʵ��
	 */
	public CIResultTB getCIResultTBInstance() {
		return new CIResultTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIResultInfo> searchCIResult() {
		return ciResultDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIResultInfo searchCIResultByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CIResultSearchCond cond) {
		return ciResultDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIResultInfo> searchCIResult(
			CIResultSearchCond cond) {
		return ciResultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIResultInfo> searchCIResult(
			CIResultSearchCond cond, int start,
			int count) {
		return ciResultDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CIResultInfo registCIResult(CIResultInfo instance)
		throws BLException {
		return ciResultDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CIResultInfo updateCIResult(CIResultInfo instance)
		throws BLException {
		checkExistInstance(instance.getCirid());
		return ciResultDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCIResultByPK(Integer pk)
		throws BLException {
		ciResultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCIResult(CIResultInfo instance)
		throws BLException {
		ciResultDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CIResultInfo checkExistInstance(Integer pk)
		throws BLException {
		CIResultInfo instance = ciResultDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateCIResultWithout(CIResultSearchCond cond)
		throws BLException{
		return ciResultDAO.updateCIResultWithout(cond);
	}

}