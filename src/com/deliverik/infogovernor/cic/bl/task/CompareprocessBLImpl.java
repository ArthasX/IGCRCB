/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareprocessSearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareprocessDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareprocessTB;

/**
  * ����: �Աȼ�¼ҵ���߼�ʵ��
  * ��������: �Աȼ�¼ҵ���߼�ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public class CompareprocessBLImpl extends BaseBLImpl implements
		CompareprocessBL {

	/** �Աȼ�¼DAO�ӿ� */
	protected CompareprocessDAO compareprocessDAO;
	
	/**
	 * �Աȼ�¼DAO�ӿ��趨
	 *
	 * @param compareprocessDAO �Աȼ�¼DAO�ӿ�
	 */
	public void setCompareprocessDAO(CompareprocessDAO compareprocessDAO) {
		this.compareprocessDAO = compareprocessDAO;
	}

	/**
	 * �Աȼ�¼ʵ��ȡ��
	 *
	 * @return �Աȼ�¼ʵ��
	 */
	public CompareprocessTB getCompareprocessTBInstance() {
		return new CompareprocessTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareprocessInfo> searchCompareprocess() {
		return compareprocessDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareprocessInfo searchCompareprocessByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareprocessSearchCond cond) {
		return compareprocessDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareprocessInfo> searchCompareprocess(
			CompareprocessSearchCond cond) {
		return compareprocessDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareprocessInfo> searchCompareprocess(
			CompareprocessSearchCond cond, int start,
			int count) {
		return compareprocessDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareprocessInfo registCompareprocess(CompareprocessInfo instance)
		throws BLException {
		return compareprocessDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareprocessInfo updateCompareprocess(CompareprocessInfo instance)
		throws BLException {
		checkExistInstance(instance.getCpid());
		return compareprocessDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareprocessByPK(Integer pk)
		throws BLException {
		compareprocessDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareprocess(CompareprocessInfo instance)
		throws BLException {
		compareprocessDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CompareprocessInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareprocessInfo instance = compareprocessDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}