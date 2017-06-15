/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG482DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG482TB;

/**
  * ����: �����������ϵ�����ҵ���߼�ʵ��
  * ��������: �����������ϵ�����ҵ���߼�ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG482BLImpl extends BaseBLImpl implements
		IG482BL {

	/** �����������ϵ�����DAO�ӿ� */
	protected IG482DAO ig482DAO;
	
	/**
	 * �����������ϵ�����DAO�ӿ��趨
	 *
	 * @param ig482DAO �����������ϵ�����DAO�ӿ�
	 */
	public void setIg482DAO(IG482DAO ig482DAO) {
		this.ig482DAO = ig482DAO;
	}

	/**
	 * �����������ϵ�����ʵ��ȡ��
	 *
	 * @return �����������ϵ�����ʵ��
	 */
	public IG482TB getIG482TBInstance() {
		return new IG482TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG482Info> searchIG482() {
		return ig482DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG482Info searchIG482ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG482SearchCond cond) {
		return ig482DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG482Info> searchIG482(
			IG482SearchCond cond) {
		return ig482DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG482Info> searchIG482(
			IG482SearchCond cond, int start,
			int count) {
		return ig482DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG482Info registIG482(IG482Info instance)
		throws BLException {
		return ig482DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG482Info updateIG482(IG482Info instance)
		throws BLException {
		checkExistInstance(instance.getPgreid());
		return ig482DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG482ByPK(String pk)
		throws BLException {
		ig482DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG482(IG482Info instance)
		throws BLException {
		ig482DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG482Info checkExistInstance(String pk)
		throws BLException {
		IG482Info instance = ig482DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}