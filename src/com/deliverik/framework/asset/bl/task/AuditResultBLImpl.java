/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.condition.AuditResultSearchCond;
import com.deliverik.framework.asset.model.dao.AuditResultDAO;
import com.deliverik.framework.asset.model.entity.AuditResultTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * ����: ��ƶԱȽ����Ϣ��ҵ���߼�ʵ��
  * ��������: ��ƶԱȽ����Ϣ��ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class AuditResultBLImpl extends BaseBLImpl implements
		AuditResultBL {

	/** ��ƶԱȽ����Ϣ��DAO�ӿ� */
	protected AuditResultDAO auditResultDAO;
	
	/**
	 * ��ƶԱȽ����Ϣ��DAO�ӿ��趨
	 *
	 * @param auditResultDAO ��ƶԱȽ����Ϣ��DAO�ӿ�
	 */
	public void setAuditResultDAO(AuditResultDAO auditResultDAO) {
		this.auditResultDAO = auditResultDAO;
	}

	/**
	 * ��ƶԱȽ����Ϣ��ʵ��ȡ��
	 *
	 * @return ��ƶԱȽ����Ϣ��ʵ��
	 */
	public AuditResultTB getAuditResultTBInstance() {
		return new AuditResultTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditResultInfo> searchAuditResult() {
		return auditResultDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditResultInfo searchAuditResultByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditResultSearchCond cond) {
		return auditResultDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditResultInfo> searchAuditResult(
			AuditResultSearchCond cond) {
		return auditResultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditResultInfo> searchAuditResult(
			AuditResultSearchCond cond, int start,
			int count) {
		return auditResultDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditResultInfo registAuditResult(AuditResultInfo instance)
		throws BLException {
		return auditResultDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditResultInfo updateAuditResult(AuditResultInfo instance)
		throws BLException {
		checkExistInstance(instance.getAurid());
		return auditResultDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditResultByPK(Integer pk)
		throws BLException {
		auditResultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditResult(AuditResultInfo instance)
		throws BLException {
		auditResultDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AuditResultInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditResultInfo instance = auditResultDAO.findByPK(pk);
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
	public Integer updateAuditResultWithout(AuditResultSearchCond cond)
		throws BLException{
		return auditResultDAO.updateAuditResultWithout(cond);
	}

}