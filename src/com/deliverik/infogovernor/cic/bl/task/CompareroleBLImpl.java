/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareroleDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareroleTB;

/**
  * ����: �Աȹ���ҵ���߼�ʵ��
  * ��������: �Աȹ���ҵ���߼�ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public class CompareroleBLImpl extends BaseBLImpl implements
		CompareroleBL {

	/** �Աȹ���DAO�ӿ� */
	protected CompareroleDAO compareroleDAO;
	
	/**
	 * �Աȹ���DAO�ӿ��趨
	 *
	 * @param compareroleDAO �Աȹ���DAO�ӿ�
	 */
	public void setCompareroleDAO(CompareroleDAO compareroleDAO) {
		this.compareroleDAO = compareroleDAO;
	}

	/**
	 * �Աȹ���ʵ��ȡ��
	 *
	 * @return �Աȹ���ʵ��
	 */
	public CompareroleTB getCompareroleTBInstance() {
		return new CompareroleTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareroleInfo> searchComparerole() {
		return compareroleDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareroleInfo searchCompareroleByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareroleSearchCond cond) {
		return compareroleDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareroleInfo> searchComparerole(
			CompareroleSearchCond cond) {
		return compareroleDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareroleInfo> searchComparerole(
			CompareroleSearchCond cond, int start,
			int count) {
		return compareroleDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareroleInfo registComparerole(CompareroleInfo instance)
		throws BLException {
		return compareroleDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareroleInfo updateComparerole(CompareroleInfo instance)
		throws BLException {
		checkExistInstance(instance.getCrid());
		return compareroleDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareroleByPK(Integer pk)
		throws BLException {
		compareroleDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteComparerole(CompareroleInfo instance)
		throws BLException {
		compareroleDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CompareroleInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareroleInfo instance = compareroleDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * ����
	 * @param instantce
	 * @return
	 */
	public CompareroleInfo save(CompareroleInfo instantce)throws BLException{
		return compareroleDAO.save(instantce);
	}


	
	/**
     * ���ݹ�ϵ���ѯ���򼰶���
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<CompareroleInfo> searchCompareroleByRelation(CompareroleSearchCond cond) throws BLException {
        return compareroleDAO.searchCompareroleByRelation(cond);
    }
}