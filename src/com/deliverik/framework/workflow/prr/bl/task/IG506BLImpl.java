/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.condition.IG506SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG506SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG506DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;

/**
  * ����: ��Ա���ֵ��ҵ���߼�ʵ��
  * ��������: ��Ա���ֵ��ҵ���߼�ʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public class IG506BLImpl extends BaseBLImpl implements IG506BL {

	/** ��Ա���ֵ��DAO�ӿ� */
	protected IG506DAO ig506DAO;
	
	/**
	 * ��Ա���ֵ��DAO�ӿ��趨
	 *
	 * @param iG506DAO ��Ա���ֵ��DAO�ӿ�
	 */
	public void setIg506DAO(IG506DAO ig506DAO) {
		this.ig506DAO = ig506DAO;
	}

	/**
	 * ��Ա���ֵ��ʵ��ȡ��
	 *
	 * @return ��Ա���ֵ��ʵ��
	 */
	public IG506TB getIG506TBInstance() {
		return new IG506TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG506Info> searchIG506() {
		return ig506DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG506Info searchIG506ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG506SearchCond cond) {
		return ig506DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG506Info> searchIG506(IG506SearchCond cond) {
		return ig506DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG506Info> searchIG506(IG506SearchCond cond, int start, int count) {
		return ig506DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ����������������
	 * @param prid ��������
	 * @return
	 * @throws BLException
	 */
	public List<IG506Info> findByPrid(Integer prid) throws BLException {
		if(prid == null || prid == 0) return null;
		IG506SearchCondImpl cond = new IG506SearchCondImpl();
		cond.setPrid(prid);
		return searchIG506(cond);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG506Info registIG506(IG506Info instance) throws BLException {
		return ig506DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG506Info updateIG506(IG506Info instance) throws BLException {
		checkExistInstance(instance.getPiuid());
		return ig506DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG506ByPK(Integer pk) throws BLException {
		ig506DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG506(IG506Info instance) throws BLException {
		ig506DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG506Info checkExistInstance(Integer pk) throws BLException {
		IG506Info instance = ig506DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}