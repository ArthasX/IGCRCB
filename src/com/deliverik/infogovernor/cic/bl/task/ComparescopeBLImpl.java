/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.ComparescopeInfo;
import com.deliverik.infogovernor.cic.model.condition.ComparescopeSearchCond;
import com.deliverik.infogovernor.cic.model.dao.ComparescopeDAO;
import com.deliverik.infogovernor.cic.model.entity.ComparescopeTB;

/**
  * ����: �Ա���ҵ���߼�ʵ��
  * ��������: �Ա���ҵ���߼�ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public class ComparescopeBLImpl extends BaseBLImpl implements
		ComparescopeBL {

	/** �Ա���DAO�ӿ� */
	protected ComparescopeDAO comparescopeDAO;
	
	/**
	 * �Ա���DAO�ӿ��趨
	 *
	 * @param comparescopeDAO �Ա���DAO�ӿ�
	 */
	public void setComparescopeDAO(ComparescopeDAO comparescopeDAO) {
		this.comparescopeDAO = comparescopeDAO;
	}

	/**
	 * �Ա���ʵ��ȡ��
	 *
	 * @return �Ա���ʵ��
	 */
	public ComparescopeTB getComparescopeTBInstance() {
		return new ComparescopeTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ComparescopeInfo> searchComparescope() {
		return comparescopeDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ComparescopeInfo searchComparescopeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ComparescopeSearchCond cond) {
		return comparescopeDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ComparescopeInfo> searchComparescope(
			ComparescopeSearchCond cond) {
		return comparescopeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ComparescopeInfo> searchComparescope(
			ComparescopeSearchCond cond, int start,
			int count) {
		return comparescopeDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ComparescopeInfo registComparescope(ComparescopeInfo instance)
		throws BLException {
		return comparescopeDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ComparescopeInfo updateComparescope(ComparescopeInfo instance)
		throws BLException {
		checkExistInstance(instance.getCsid());
		return comparescopeDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteComparescopeByPK(Integer pk)
		throws BLException {
		comparescopeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteComparescope(ComparescopeInfo instance)
		throws BLException {
		comparescopeDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ComparescopeInfo checkExistInstance(Integer pk)
		throws BLException {
		ComparescopeInfo instance = comparescopeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}