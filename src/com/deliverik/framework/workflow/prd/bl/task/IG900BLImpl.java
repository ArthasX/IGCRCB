/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG900Info;
import com.deliverik.framework.workflow.prd.model.condition.IG900SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG900DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG900TB;

/**
  * ����: ���̰�ť�����ҵ���߼�ʵ��
  * ��������: ���̰�ť�����ҵ���߼�ʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public class IG900BLImpl extends BaseBLImpl implements
		IG900BL {

	/** ���̰�ť�����DAO�ӿ� */
	protected IG900DAO ig900DAO;
	
	/**
	 * ���̰�ť�����DAO�ӿ��趨
	 *
	 * @param ig900DAO ���̰�ť�����DAO�ӿ�
	 */
	public void setIg900DAO(IG900DAO ig900DAO) {
		this.ig900DAO = ig900DAO;
	}

	/**
	 * ���̰�ť�����ʵ��ȡ��
	 *
	 * @return ���̰�ť�����ʵ��
	 */
	public IG900TB getIG900TBInstance() {
		return new IG900TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG900Info> searchIG900Info() {
		return ig900DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG900Info searchIG900InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG900SearchCond cond) {
		return ig900DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG900Info> searchIG900Info(
			IG900SearchCond cond) {
		return ig900DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG900Info> searchIG900Info(
			IG900SearchCond cond, int start,
			int count) {
		return ig900DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG900Info registIG900Info(IG900Info instance)
		throws BLException {
		return ig900DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG900Info updateIG900Info(IG900Info instance)
		throws BLException {
		checkExistInstance(instance.getPbdid());
		return ig900DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG900InfoByPK(String pk)
		throws BLException {
		ig900DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG900Info(IG900Info instance)
		throws BLException {
		ig900DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG900Info checkExistInstance(String pk)
		throws BLException {
		IG900Info instance = ig900DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}