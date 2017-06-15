/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG481DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG481PK;
import com.deliverik.framework.workflow.prd.model.entity.IG481TB;

/**
  * ����: �������Ա��ҵ���߼�ʵ��
  * ��������: �������Ա��ҵ���߼�ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG481BLImpl extends BaseBLImpl implements
		IG481BL {

	/** �������Ա��DAO�ӿ� */
	protected IG481DAO ig481DAO;
	
	/**
	 * �������Ա��DAO�ӿ��趨
	 *
	 * @param ig481DAO �������Ա��DAO�ӿ�
	 */
	public void setIg481DAO(IG481DAO ig481DAO) {
		this.ig481DAO = ig481DAO;
	}

	/**
	 * �������Ա��ʵ��ȡ��
	 *
	 * @return �������Ա��ʵ��
	 */
	public IG481TB getIG481TBInstance() {
		return new IG481TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG481Info> searchIG481() {
		return ig481DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG481Info searchIG481ByPK(IG481PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG481SearchCond cond) {
		return ig481DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG481Info> searchIG481(
			IG481SearchCond cond) {
		return ig481DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG481Info> searchIG481(
			IG481SearchCond cond, int start,
			int count) {
		return ig481DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG481Info registIG481(IG481Info instance)
		throws BLException {
		return ig481DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG481Info updateIG481(IG481Info instance)
		throws BLException {
		checkExistInstance(new IG481PK(instance.getPgdid(), instance.getPdid()));
		return ig481DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG481ByPK(IG481PK pk)
		throws BLException {
		ig481DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG481(IG481Info instance)
		throws BLException {
		ig481DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG481Info checkExistInstance(IG481PK pk)
		throws BLException {
		IG481Info instance = ig481DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * ��������ɾ��
	 * @param cond
	 */
	public void deleteByCond(IG481SearchCond cond)throws BLException{
		ig481DAO.deleteByCond(cond);
	}
	
	/**
	 * �������̶���ID��ѯ�鶨���б�
	 * @param pdid ���̶���ID
	 * @return �鶨���б�
	 */
	public List<IG480Info> searchIG480(String pdid) {
		return this.ig481DAO.searchIG480(pdid);
	}

}