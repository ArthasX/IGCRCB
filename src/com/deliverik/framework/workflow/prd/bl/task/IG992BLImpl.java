/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG992DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG992TB;

/**
  * ����: �����ⲿ���ö����ҵ���߼�ʵ��
  * ��������: �����ⲿ���ö����ҵ���߼�ʵ��
  * ������¼: 2012/04/20
  * �޸ļ�¼: 
  */
public class IG992BLImpl extends BaseBLImpl implements
		IG992BL {

	/** �����ⲿ���ö����DAO�ӿ� */
	protected IG992DAO ig992DAO;
	
	/**
	 * �����ⲿ���ö����DAO�ӿ��趨
	 *
	 * @param ig992DAO �����ⲿ���ö����DAO�ӿ�
	 */
	public void setIg992DAO(IG992DAO ig992DAO) {
		this.ig992DAO = ig992DAO;
	}

	/**
	 * �����ⲿ���ö����ʵ��ȡ��
	 *
	 * @return �����ⲿ���ö����ʵ��
	 */
	public IG992TB getIG992TBInstance() {
		return new IG992TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG992Info> searchIG992Info() {
		return ig992DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG992Info searchIG992InfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG992SearchCond cond) {
		return ig992DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG992Info> searchIG992Info(
			IG992SearchCond cond) {
		return ig992DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG992Info> searchIG992Info(
			IG992SearchCond cond, int start,
			int count) {
		return ig992DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG992Info registIG992Info(IG992Info instance)
		throws BLException {
		return ig992DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG992Info updateIG992Info(IG992Info instance)
		throws BLException {
		checkExistInstance(instance.getPedid());
		return ig992DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG992InfoByPK(Integer pk)
		throws BLException {
		ig992DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG992Info(IG992Info instance)
		throws BLException {
		ig992DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG992Info checkExistInstance(Integer pk)
		throws BLException {
		IG992Info instance = ig992DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * PEDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	public String getPedidSequenceNextValue(String psdid) {
		return ig992DAO.getPedidSequenceNextValue(psdid);
	}

}