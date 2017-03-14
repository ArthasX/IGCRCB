/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareresultDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareresultTB;

/**
  * ����: �ȶԽ��ҵ���߼�ʵ��
  * ��������: �ȶԽ��ҵ���߼�ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public class CompareresultBLImpl extends BaseBLImpl implements
		CompareresultBL {

	/** �ȶԽ��DAO�ӿ� */
	protected CompareresultDAO compareresultDAO;
	
	/**
	 * �ȶԽ��DAO�ӿ��趨
	 *
	 * @param compareresultDAO �ȶԽ��DAO�ӿ�
	 */
	public void setCompareresultDAO(CompareresultDAO compareresultDAO) {
		this.compareresultDAO = compareresultDAO;
	}

	/**
	 * �ȶԽ��ʵ��ȡ��
	 *
	 * @return �ȶԽ��ʵ��
	 */
	public CompareresultTB getCompareresultTBInstance() {
		return new CompareresultTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareresultInfo> searchCompareresult() {
		return compareresultDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareresultInfo searchCompareresultByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareresultSearchCond cond) {
		return compareresultDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareresultInfo> searchCompareresult(
			CompareresultSearchCond cond) {
		return compareresultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareresultInfo> searchCompareresult(
			CompareresultSearchCond cond, int start,
			int count) {
		return compareresultDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareresultInfo registCompareresult(CompareresultInfo instance)
		throws BLException {
		return compareresultDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareresultInfo updateCompareresult(CompareresultInfo instance)
		throws BLException {
		checkExistInstance(instance.getCrid());
		return compareresultDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareresultByPK(Integer pk)
		throws BLException {
		compareresultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareresult(CompareresultInfo instance)
		throws BLException {
		compareresultDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CompareresultInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareresultInfo instance = compareresultDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<CompareresultVWInfo> searchCompareresultVW(CompareresultSearchCond cond) throws BLException {
        return compareresultDAO.searchCompareresultVW(cond);
    }
    
    /**
     * ���ݶ���ȶԽ������List
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<Object[]> getEnameList(final CompareresultSearchCond cond) throws BLException {
        return compareresultDAO.getEnameList(cond);
    }
}