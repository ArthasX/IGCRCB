/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectSearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareobjectDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectTB;

/**
  * ����: �Աȶ���ҵ���߼�ʵ��
  * ��������: �Աȶ���ҵ���߼�ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public class CompareobjectBLImpl extends BaseBLImpl implements
		CompareobjectBL {

	/** �Աȶ���DAO�ӿ� */
	protected CompareobjectDAO compareobjectDAO;
	
	/**
	 * �Աȶ���DAO�ӿ��趨
	 *
	 * @param compareobjectDAO �Աȶ���DAO�ӿ�
	 */
	public void setCompareobjectDAO(CompareobjectDAO compareobjectDAO) {
		this.compareobjectDAO = compareobjectDAO;
	}

	/**
	 * �Աȶ���ʵ��ȡ��
	 *
	 * @return �Աȶ���ʵ��
	 */
	public CompareobjectTB getCompareobjectTBInstance() {
		return new CompareobjectTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareobjectInfo> searchCompareobject() {
		return compareobjectDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareobjectInfo searchCompareobjectByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareobjectSearchCond cond) {
		return compareobjectDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareobjectInfo> searchCompareobject(
			CompareobjectSearchCond cond) {
		return compareobjectDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareobjectInfo> searchCompareobject(
			CompareobjectSearchCond cond, int start,
			int count) {
		return compareobjectDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareobjectInfo registCompareobject(CompareobjectInfo instance)
		throws BLException {
		return compareobjectDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareobjectInfo updateCompareobject(CompareobjectInfo instance)
		throws BLException {
		checkExistInstance(instance.getCoid());
		return compareobjectDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareobjectByPK(Integer pk)
		throws BLException {
		compareobjectDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareobject(CompareobjectInfo instance)
		throws BLException {
		compareobjectDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CompareobjectInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareobjectInfo instance = compareobjectDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * ���ϱ���
	 * @param instantce
	 * @throws BLException
	 */
	public void save(List<CompareobjectInfo> instantce)throws BLException{
		compareobjectDAO.delByCrid(instantce.get(0).getFkCrid());
		compareobjectDAO.saveOrUpdateAll(instantce);
		
	}
	
	/**
	 * ת�ƶԱȶ��� ��ʷ����
	 * @param crid
	 * @return
	 */
	public boolean toHistory(Integer crid)throws BLException{
		return compareobjectDAO.toHistory(crid);
	}
	
	/**
	 * ���ݹ���ɾ���Աȶ���
	 * @param crid
	 * @return
	 */
	public boolean delByCrid(Integer crid)throws BLException{
		return compareobjectDAO.delByCrid(crid);
	}
}