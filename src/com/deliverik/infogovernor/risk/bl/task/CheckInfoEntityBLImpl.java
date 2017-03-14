/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.CheckInfoEntityInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoEntitySearchCond;
import com.deliverik.infogovernor.risk.model.dao.CheckInfoEntityDAO;
import com.deliverik.infogovernor.risk.model.entity.CheckInfoEntityTB;

/**
  * ����: �����Թ����ʲ���ҵ���߼�ʵ��
  * ��������: �����Թ����ʲ���ҵ���߼�ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public class CheckInfoEntityBLImpl extends BaseBLImpl implements
		CheckInfoEntityBL {

	/** �����Թ����ʲ���DAO�ӿ� */
	protected CheckInfoEntityDAO checkInfoEntityDAO;
	
	/**
	 * �����Թ����ʲ���DAO�ӿ��趨
	 *
	 * @param checkInfoEntityDAO �����Թ����ʲ���DAO�ӿ�
	 */
	public void setCheckInfoEntityDAO(CheckInfoEntityDAO checkInfoEntityDAO) {
		this.checkInfoEntityDAO = checkInfoEntityDAO;
	}

	/**
	 * �����Թ����ʲ���ʵ��ȡ��
	 *
	 * @return �����Թ����ʲ���ʵ��
	 */
	public CheckInfoEntityTB getCheckInfoEntityTBInstance() {
		return new CheckInfoEntityTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckInfoEntityInfo> searchCheckInfoEntity() {
		return checkInfoEntityDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckInfoEntityInfo searchCheckInfoEntityByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckInfoEntitySearchCond cond) {
		return checkInfoEntityDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckInfoEntityInfo> searchCheckInfoEntity(
			CheckInfoEntitySearchCond cond) {
		return checkInfoEntityDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckInfoEntityInfo> searchCheckInfoEntity(
			CheckInfoEntitySearchCond cond, int start,
			int count) {
		return checkInfoEntityDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckInfoEntityInfo registCheckInfoEntity(CheckInfoEntityInfo instance)
		throws BLException {
		return checkInfoEntityDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckInfoEntityInfo updateCheckInfoEntity(CheckInfoEntityInfo instance)
		throws BLException {
		checkExistInstance(instance.getCieid());
		return checkInfoEntityDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckInfoEntityByPK(Integer pk)
		throws BLException {
		checkInfoEntityDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckInfoEntity(CheckInfoEntityInfo instance)
		throws BLException {
		checkInfoEntityDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CheckInfoEntityInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckInfoEntityInfo instance = checkInfoEntityDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}