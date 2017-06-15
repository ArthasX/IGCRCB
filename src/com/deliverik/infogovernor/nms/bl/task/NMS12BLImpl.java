/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS12Info;
import com.deliverik.infogovernor.nms.model.condition.NMS12SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS12DAO;

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
public class NMS12BLImpl extends NMSBaseBLImpl implements NMS12BL {

	/** �豸��������Ϣʵ��DAO */
	protected NMS12DAO nms12DAO;

	/**
	 * �豸��������Ϣʵ��DAO�趨
	 * @param nms12DAO �豸��������Ϣʵ��DAO
	 */
	public void setNms12DAO(NMS12DAO nms12dao) {
		nms12DAO = nms12dao;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS12Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS12SearchCond cond) {
		return nms12DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS12Info> search(NMS12SearchCond cond) {
		return nms12DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS12Info> search(NMS12SearchCond cond, int start,int count) {
		return nms12DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS12Info regist(NMS12Info instance) throws BLException {
		return nms12DAO.save(instance);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS12Info> regist(List<NMS12Info> instances) throws BLException {
		List<NMS12Info> list = new ArrayList<NMS12Info>(instances.size());
		for(NMS12Info instance:instances){
			list.add(nms12DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS12Info update(NMS12Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms12DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		nms12DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS12Info instance) throws BLException {
		nms12DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS12Info checkExistInstance(Integer pk) throws BLException {
		NMS12Info instance = nms12DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
