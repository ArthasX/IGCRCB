/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS17Info;
import com.deliverik.infogovernor.nms.model.condition.NMS17SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS17DAO;
import com.deliverik.infogovernor.nms.model.entity.NMS17TB;

/**
  * ����: ����������Ϣҵ���߼�ʵ��
  * ��������: ����������Ϣҵ���߼�ʵ��
  * ������¼: 2014/01/07
  * �޸ļ�¼: 
  */
public class NMS17BLImpl extends NMSBaseBLImpl implements
		NMS17BL {

	/** ����������ϢDAO�ӿ� */
	protected NMS17DAO nms17DAO;
	
	/**
     * nms17DAO is set.
     * @param nms17dao nms17DAO
     */
    public void setNms17DAO(NMS17DAO nms17dao) {
        nms17DAO = nms17dao;
    }

    /**
	 * ����������Ϣʵ��ȡ��
	 *
	 * @return ����������Ϣʵ��
	 */
	public NMS17TB getNMS17TBInstance() {
		return new NMS17TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<NMS17Info> searchNMS17() {
		return nms17DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS17Info searchNMS17ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS17SearchCond cond) {
		return nms17DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS17Info> searchNMS17(
			NMS17SearchCond cond) {
		return nms17DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS17Info> searchNMS17(
			NMS17SearchCond cond, int start,
			int count) {
		return nms17DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS17Info registNMS17(NMS17Info instance)
		throws BLException {
		return nms17DAO.save(instance);
	}
	
	/**
	 * ������������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public void registNMS17All(List<NMS17Info> instance)
	        throws BLException {
	    nms17DAO.saveOrUpdateAll(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS17Info updateNMS17(NMS17Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return nms17DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteNMS17ByPK(String pk)
		throws BLException {
		nms17DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteNMS17(NMS17Info instance)
		throws BLException {
		nms17DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS17Info checkExistInstance(String pk)
		throws BLException {
		NMS17Info instance = nms17DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}