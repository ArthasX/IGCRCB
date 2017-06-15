/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.condition.IG505SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG505SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG505DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG505TB;

/**
  * ����: ���̱�ֵ��ҵ���߼�ʵ��
  * ��������: ���̱�ֵ��ҵ���߼�ʵ��
  * ������¼: 2013/08/28
  * �޸ļ�¼: 
  */
public class IG505BLImpl extends BaseBLImpl implements IG505BL {

	/** ���̱�ֵ��DAO�ӿ� */
	protected IG505DAO ig505DAO;
	
	/**
	 * ���̱�ֵ��DAO�ӿ��趨
	 *
	 * @param iG505DAO ���̱�ֵ��DAO�ӿ�
	 */
	public void setIg505DAO(IG505DAO ig505DAO) {
		this.ig505DAO = ig505DAO;
	}

	/**
	 * ���̱�ֵ��ʵ��ȡ��
	 *
	 * @return ���̱�ֵ��ʵ��
	 */
	public IG505TB getIG505TBInstance() {
		return new IG505TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG505Info> searchIG505() {
		return ig505DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG505Info searchIG505ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG505SearchCond cond) {
		return ig505DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG505Info> searchIG505(IG505SearchCond cond) {
		return ig505DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG505Info> searchIG505(IG505SearchCond cond, int start, int count) {
		return ig505DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG505Info registIG505(IG505Info instance) throws BLException {
		return ig505DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG505Info updateIG505(IG505Info instance) throws BLException {
		checkExistInstance(instance.getPiprid());
		return ig505DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG505ByPK(Integer pk) throws BLException {
		ig505DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG505(IG505Info instance) throws BLException {
		ig505DAO.delete(instance);
	}
	
	/**
	 * ����������������
	 * @param prid ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG505Info> findByPrid(Integer prid) throws BLException {
		if(prid == null) return null;
		IG505SearchCondImpl cond = new IG505SearchCondImpl();
		cond.setPrid(prid);
		return ig505DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG505Info checkExistInstance(Integer pk) throws BLException {
		IG505Info instance = ig505DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}