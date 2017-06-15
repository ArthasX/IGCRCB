/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG001DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG001TB;

/**
  * ����: OA��ɫ���ñ�ҵ���߼�ʵ��
  * ��������: OA��ɫ���ñ�ҵ���߼�ʵ��
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public class IG001BLImpl extends BaseBLImpl implements IG001BL {

	/** OA��ɫ���ñ�DAO�ӿ� */
	protected IG001DAO ig001DAO;
	
	/**
	 * OA��ɫ���ñ�DAO�ӿ��趨
	 *
	 * @param iG001DAO OA��ɫ���ñ�DAO�ӿ�
	 */
	public void setIg001DAO(IG001DAO ig001dao) {
		ig001DAO = ig001dao;
	}

	/**
	 * OA��ɫ���ñ�ʵ��ȡ��
	 *
	 * @return OA��ɫ���ñ�ʵ��
	 */
	public IG001TB getIG001TBInstance() {
		return new IG001TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG001Info> searchIG001() {
		return ig001DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG001Info searchIG001ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG001SearchCond cond) {
		return ig001DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG001Info> searchIG001(IG001SearchCond cond) {
		return ig001DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG001Info> searchIG001(IG001SearchCond cond, int start,int count) {
		return ig001DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG001Info registIG001(IG001Info instance) throws BLException {
		return ig001DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG001Info updateIG001(IG001Info instance) throws BLException {
		checkExistInstance(instance.getProid());
		return ig001DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG001ByPK(Integer pk) throws BLException {
		ig001DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG001(IG001Info instance) throws BLException {
		ig001DAO.delete(instance);
	}
	
	/**
	 * ɾ������
	 * @param infoList
	 */
	public void deleteIG001(List<IG001Info> infoList) throws BLException {
		ig001DAO.delete(infoList);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG001Info checkExistInstance(Integer pk) throws BLException {
		IG001Info instance = ig001DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}