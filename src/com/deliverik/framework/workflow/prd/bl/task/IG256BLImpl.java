/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG256DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;

/**
  * ����: ���̲�������ҵ���߼�ʵ��
  * ��������: ���̲�������ҵ���߼�ʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public class IG256BLImpl extends BaseBLImpl implements
		IG256BL {

	/** ���̲�������DAO�ӿ� */
	protected IG256DAO ig256DAO;
	
	/**
	 * ���̲�������DAO�ӿ��趨
	 *
	 * @param ig256DAO ���̲�������DAO�ӿ�
	 */
	public void setig256DAO(IG256DAO ig256DAO) {
		this.ig256DAO = ig256DAO;
	}

	/**
	 * ���̲�������ʵ��ȡ��
	 *
	 * @return ���̲�������ʵ��
	 */
	public IG256TB getIG256TBInstance() {
		return new IG256TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG256Info> searchIG256() {
		return ig256DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG256Info searchIG256ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG256SearchCond cond) {
		return ig256DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG256Info> searchIG256(
			IG256SearchCond cond) {
		return ig256DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG256Info> searchIG256(
			IG256SearchCond cond, int start,
			int count) {
		return ig256DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG256Info registIG256(IG256Info instance)
		throws BLException {
		return ig256DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG256Info updateIG256(IG256Info instance)
		throws BLException {
		checkExistInstance(instance.getFnid());
		return ig256DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG256ByPK(Integer pk)
		throws BLException {
		ig256DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG256(IG256Info instance)
		throws BLException {
		ig256DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG256Info checkExistInstance(Integer pk)
		throws BLException {
		IG256Info instance = ig256DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}