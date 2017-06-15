/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG394Info;
import com.deliverik.framework.workflow.prr.model.condition.IG394SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG394DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG394TB;

/**
  * ����: ���Ѽ�¼��ҵ���߼�ʵ��
  * ��������: ���Ѽ�¼��ҵ���߼�ʵ��
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public class IG394BLImpl extends BaseBLImpl implements
		IG394BL {

	/** ���Ѽ�¼��DAO�ӿ� */
	protected IG394DAO ig394DAO;
	
	/**
	 * ���Ѽ�¼��DAO�ӿ��趨
	 *
	 * @param ig394DAO ���Ѽ�¼��DAO�ӿ�
	 */
	public void setIg394DAO(IG394DAO ig394DAO) {
		this.ig394DAO = ig394DAO;
	}

	/**
	 * ���Ѽ�¼��ʵ��ȡ��
	 *
	 * @return ���Ѽ�¼��ʵ��
	 */
	public IG394TB getIG394TBInstance() {
		return new IG394TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG394Info> searchIG394Info() {
		return ig394DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG394Info searchIG394InfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG394SearchCond cond) {
		return ig394DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG394Info> searchIG394Info(
			IG394SearchCond cond) {
		return ig394DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG394Info> searchIG394Info(
			IG394SearchCond cond, int start,
			int count) {
		return ig394DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param ig394Info ����ʵ��
	 * @return ����ʵ��
	 */
	public IG394Info registIG394Info(IG394Info ig394Info)
		throws BLException {
		return ig394DAO.save(ig394Info);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param ig394Info �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG394Info updateIG394Info(IG394Info ig394Info)
		throws BLException {
		checkExistInstance(ig394Info.getPnssid());
		return ig394DAO.save(ig394Info);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG394InfoByPK(Integer pk)
		throws BLException {
		ig394DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param ig394Info ɾ��ʵ��
	 */
	public void deleteIG394Info(IG394Info ig394Info)
		throws BLException {
		ig394DAO.delete(ig394Info);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG394Info checkExistInstance(Integer pk)
		throws BLException {
		IG394Info instance = ig394DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}