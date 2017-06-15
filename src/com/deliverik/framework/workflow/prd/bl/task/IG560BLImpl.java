/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG560DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;

/**
  * ����: ����״̬��˽�б�Ĭ��ֵ��ҵ���߼�ʵ��
  * ��������: ����״̬��˽�б�Ĭ��ֵ��ҵ���߼�ʵ��
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public class IG560BLImpl extends BaseBLImpl implements
		IG560BL {

	/** ����״̬��˽�б�Ĭ��ֵ��DAO�ӿ� */
	protected IG560DAO ig560DAO;
	
	/**
	 * ����״̬��˽�б�Ĭ��ֵ��DAO�ӿ��趨
	 *
	 * @param ig560DAO ����״̬��˽�б�Ĭ��ֵ��DAO�ӿ�
	 */
	public void setIg560DAO(IG560DAO ig560DAO) {
		this.ig560DAO = ig560DAO;
	}

	/**
	 * ����״̬��˽�б�Ĭ��ֵ��ʵ��ȡ��
	 *
	 * @return ����״̬��˽�б�Ĭ��ֵ��ʵ��
	 */
	public IG560TB getIG560TBInstance() {
		return new IG560TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG560Info> searchIG560() {
		return ig560DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG560Info searchIG560ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG560SearchCond cond) {
		return ig560DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG560Info> searchIG560(
			IG560SearchCond cond) {
		return ig560DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG560Info> searchIG560(
			IG560SearchCond cond, int start,
			int count) {
		return ig560DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG560Info registIG560(IG560Info instance)
		throws BLException {
		return ig560DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG560Info updateIG560(IG560Info instance)
		throws BLException {
		checkExistInstance(instance.getDvid());
		return ig560DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG560ByPK(Integer pk)
		throws BLException {
		ig560DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG560(IG560Info instance)
		throws BLException {
		ig560DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG560Info checkExistInstance(Integer pk)
		throws BLException {
		IG560Info instance = ig560DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	public List<IG560VWInfo> searchIG560VW(IG560SearchCondImpl cond)throws BLException{
		return this.ig560DAO.searchIG560VW(cond);
	}
	
	public void saveOrUpdateAll(List<IG560Info> list)throws BLException{
		this.ig560DAO.saveOrUpdateAll(list);
	}

}