/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG037Info;
import com.deliverik.framework.workflow.prr.model.condition.IG037SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG037DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG037TB;

/**
  * ����: ���̵�����־��ҵ���߼�ʵ��
  * ��������: ���̵�����־��ҵ���߼�ʵ��
  * ������¼: 2014/11/14
  * �޸ļ�¼: 
  */
public class IG037BLImpl extends BaseBLImpl implements
		IG037BL {

	/** ���̵�����־��DAO�ӿ� */
	protected IG037DAO ig037DAO;
	
	/**
	 * ���̵�����־��DAO�ӿ��趨
	 *
	 * @param ig037DAO ���̵�����־��DAO�ӿ�
	 */
	public void setIg037DAO(IG037DAO ig037DAO) {
		this.ig037DAO = ig037DAO;
	}

	/**
	 * ���̵�����־��ʵ��ȡ��
	 *
	 * @return ���̵�����־��ʵ��
	 */
	public IG037TB getIG037TBInstance() {
		return new IG037TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG037Info> searchIG037() {
		return ig037DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG037Info searchIG037ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG037SearchCond cond) {
		return ig037DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG037Info> searchIG037(
			IG037SearchCond cond) {
		return ig037DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG037Info> searchIG037(
			IG037SearchCond cond, int start,
			int count) {
		return ig037DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG037Info registIG037(IG037Info instance)
		throws BLException {
		return ig037DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG037Info updateIG037(IG037Info instance)
		throws BLException {
		checkExistInstance(instance.getIrid());
		return ig037DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG037ByPK(Integer pk)
		throws BLException {
		ig037DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG037(IG037Info instance)
		throws BLException {
		ig037DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG037Info checkExistInstance(Integer pk)
		throws BLException {
		IG037Info instance = ig037DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}