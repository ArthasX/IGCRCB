/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG898DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG898PK;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;

/**
  * ����: ������ֵ��ҵ���߼�ʵ��
  * ��������: ������ֵ��ҵ���߼�ʵ��
  * ������¼: 2013/06/25
  * �޸ļ�¼: 
  */
public class IG898BLImpl extends BaseBLImpl implements IG898BL {

	/** ������ֵ��DAO�ӿ� */
	protected IG898DAO ig898DAO;
	
	/**
	 * ������ֵ��DAO�ӿ��趨
	 *
	 * @param iG898DAO ������ֵ��DAO�ӿ�
	 */
	public void setIg898DAO(IG898DAO ig898DAO) {
		this.ig898DAO = ig898DAO;
	}

	/**
	 * ������ֵ��ʵ��ȡ��
	 *
	 * @return ������ֵ��ʵ��
	 */
	public IG898TB getIG898TBInstance() {
		return new IG898TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG898Info> searchIG898() {
		return ig898DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG898Info searchIG898ByPK(IG898PK pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG898SearchCond cond) {
		return ig898DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG898Info> searchIG898(IG898SearchCond cond) {
		return ig898DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG898Info> searchIG898(IG898SearchCond cond, int start, int count) {
		return ig898DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG898Info registIG898(IG898Info instance) throws BLException {
		return ig898DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG898Info updateIG898(IG898Info instance) throws BLException {
		checkExistInstance(new IG898PK(instance.getPrid(), instance.getPidid(), instance.getPvcolpidid(), instance.getPvrownumber()));
		return ig898DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG898ByPK(IG898PK pk) throws BLException {
		ig898DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG898(IG898Info instance) throws BLException {
		ig898DAO.delete(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG898(List<IG898Info> list) throws BLException {
		ig898DAO.delete(list);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG898Info checkExistInstance(IG898PK pk) throws BLException {
		IG898Info instance = ig898DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
     * ȡ�ñ�����ͱ�������
     *
     * @param cond ��������
     * @return ��������
     */
	public int getTableRowCount(IG898SearchCond cond) throws BLException {
	    return ig898DAO.getTableRowCount(cond);
	}
	
}