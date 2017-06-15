/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;
import com.deliverik.infogovernor.iam.model.condition.AUDITPROJECTSearchCond;
import com.deliverik.infogovernor.iam.model.dao.AUDITPROJECTDAO;
import com.deliverik.infogovernor.iam.model.entity.AUDITPROJECTTB;

/**
  * ����: ��Ʊ����ҵ���߼�ʵ��
  * ��������: ��Ʊ����ҵ���߼�ʵ��
  * ������¼: 2012/08/08
  * �޸ļ�¼: 
  */
public class AUDITPROJECTBLImpl extends BaseBLImpl implements
		AUDITPROJECTBL {

	/** ��Ʊ����DAO�ӿ� */
	protected AUDITPROJECTDAO auditProjectDAO;
	
	/**
	 * ��Ʊ����DAO�ӿ��趨
	 *
	 * @param auditProjectDAO ��Ʊ����DAO�ӿ�
	 */

	public void setauditProjectDAO(AUDITPROJECTDAO auditProjectDAO) {
		this.auditProjectDAO = auditProjectDAO;
	}


	/**
	 * ��Ʊ����ʵ��ȡ��
	 *
	 * @return ��Ʊ����ʵ��
	 */
	public AUDITPROJECTDAO getauditProjectDAO() {
		return auditProjectDAO;
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT() {
		return auditProjectDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AUDITPROJECTInfo searchAUDITPROJECTByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AUDITPROJECTSearchCond cond) {
		return auditProjectDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT(
			AUDITPROJECTSearchCond cond) {
		return auditProjectDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT(
			AUDITPROJECTSearchCond cond, int start,
			int count) {
		return auditProjectDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AUDITPROJECTInfo registAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException {
		return auditProjectDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AUDITPROJECTInfo updateAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException {
		checkExistInstance(instance.getApid());
		return auditProjectDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAUDITPROJECTByPK(Integer pk)
		throws BLException {
		auditProjectDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException {
		auditProjectDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AUDITPROJECTInfo checkExistInstance(Integer pk)
		throws BLException {
		AUDITPROJECTInfo instance = auditProjectDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public AUDITPROJECTTB getAUDITPROJECTTBInstance() {
		// TODO Auto-generated method stub
		return new AUDITPROJECTTB();
	}

}