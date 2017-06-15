/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS08Info;
import com.deliverik.infogovernor.nms.model.condition.NMS08SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS08DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��������Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS08BLImpl extends NMSBaseBLImpl implements NMS08BL {

	/** �豸��������Ϣʵ��DAO */
	protected NMS08DAO nms08DAO;

	/**
	 * �豸��������Ϣʵ��DAO�趨
	 * @param nms08DAO �豸��������Ϣʵ��DAO
	 */
	public void setNms08DAO(NMS08DAO nms08dao) {
		nms08DAO = nms08dao;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS08Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS08SearchCond cond) {
		return nms08DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS08Info> search(NMS08SearchCond cond) {
		return nms08DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS08Info> search(NMS08SearchCond cond, int start,int count) {
		return nms08DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS08Info regist(NMS08Info instance) throws BLException {
		return nms08DAO.save(instance);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS08Info> regist(List<NMS08Info> instances) throws BLException {
		List<NMS08Info> list = new ArrayList<NMS08Info>(instances.size());
		for(NMS08Info instance:instances){
			list.add(nms08DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS08Info update(NMS08Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms08DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		nms08DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS08Info instance) throws BLException {
		nms08DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS08Info checkExistInstance(Integer pk) throws BLException {
		NMS08Info instance = nms08DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
