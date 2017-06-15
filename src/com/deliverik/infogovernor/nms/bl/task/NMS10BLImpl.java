/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS10Info;
import com.deliverik.infogovernor.nms.model.condition.NMS10SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS10DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��·��������Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS10BLImpl extends NMSBaseBLImpl implements NMS10BL {

	/** ��·��������Ϣʵ��DAO */
	protected NMS10DAO nms10DAO;

	/**
	 * ��·��������Ϣʵ��DAO�趨
	 * @param nms10DAO ��·��������Ϣʵ��DAO
	 */
	public void setNms10DAO(NMS10DAO nms10dao) {
		nms10DAO = nms10dao;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS10Info searchByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS10SearchCond cond) {
		return nms10DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS10Info> search(NMS10SearchCond cond) {
		return nms10DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS10Info> search(NMS10SearchCond cond, int start,int count) {
		return nms10DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS10Info regist(NMS10Info instance) throws BLException {
		return nms10DAO.save(instance);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS10Info> regist(List<NMS10Info> instances) throws BLException {
		List<NMS10Info> list = new ArrayList<NMS10Info>(instances.size());
		for(NMS10Info instance:instances){
			list.add(nms10DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS10Info update(NMS10Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms10DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(String pk) throws BLException {
		nms10DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS10Info instance) throws BLException {
		nms10DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS10Info checkExistInstance(String pk) throws BLException {
		NMS10Info instance = nms10DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
