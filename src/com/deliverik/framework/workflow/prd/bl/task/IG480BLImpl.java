/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG480DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;

/**
  * ����: �����鶨���ҵ���߼�ʵ��
  * ��������: �����鶨���ҵ���߼�ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG480BLImpl extends BaseBLImpl implements IG480BL {

	/** �����鶨���DAO�ӿ� */
	protected IG480DAO ig480DAO;
	
	/**
	 * �����鶨���DAO�ӿ��趨
	 *
	 * @param ig480DAO �����鶨���DAO�ӿ�
	 */
	public void setIg480DAO(IG480DAO ig480DAO) {
		this.ig480DAO = ig480DAO;
	}

	/**
	 * �����鶨���ʵ��ȡ��
	 *
	 * @return �����鶨���ʵ��
	 */
	public IG480TB getIG480TBInstance() {
		return new IG480TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG480Info> searchIG480() {
		return ig480DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG480Info searchIG480ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG480SearchCond cond) {
		return ig480DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG480Info> searchIG480(
			IG480SearchCond cond) {
		return ig480DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG480Info> searchIG480(
			IG480SearchCond cond, int start,
			int count) {
		return ig480DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG480Info registIG480(IG480Info instance)
		throws BLException {
		return ig480DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG480Info updateIG480(IG480Info instance)
		throws BLException {
		checkExistInstance(instance.getPgdid());
		return ig480DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG480ByPK(String pk)
		throws BLException {
		ig480DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG480(IG480Info instance)
		throws BLException {
		ig480DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG480Info checkExistInstance(String pk)
		throws BLException {
		IG480Info instance = ig480DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * �����鶨������ֵȡ��
	 * @param firstsite ������λ��ʶ
	 * @param pdsequence ��������
	 * @return PDID����ֵ
	 */
	public String getPdidNextValue(String firstsite,String pdsequence){
		return ig480DAO.getPgdidSequenceNextValue(firstsite, pdsequence);
	}
	
	/**
	 * �����鶨�����洦��
	 * 
	 * @param pdid ���̶���ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid) throws BLException {
		if(StringUtils.isEmpty(pgdid)) {
			throw new BLException("IGCO10000.E004","�����鶨�����");
		}
		ig480DAO.upgradeGroupProcessDefVersion(pgdid);
	}
	/**
	 * �����鶨�帴�ƴ���
	 * 
	 * @param pgdid �����鶨��ID
	 * @param pdsequence ���ж���
	 */
	public String copyGroupProcessDefVersion(String pgdid,String pdsequence) throws BLException {
		if(StringUtils.isEmpty(pgdid)) {
			throw new BLException("IGCO10000.E004","�����鶨�����");
		}
		return ig480DAO.copyGroupProcessDefVersion(pgdid,pdsequence);
	}
}