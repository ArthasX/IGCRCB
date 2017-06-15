/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS13Info;
import com.deliverik.infogovernor.nms.model.condition.NMS13SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS13DAO;

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
public class NMS13BLImpl extends NMSBaseBLImpl implements NMS13BL {

	/** ��·��������Ϣʵ��DAO */
	protected NMS13DAO nms13DAO;

	/**
	 * ��·��������Ϣʵ��DAO�趨
	 * @param nms13DAO ��·��������Ϣʵ��DAO
	 */
	public void setNms13DAO(NMS13DAO nms13dao) {
		nms13DAO = nms13dao;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS13Info searchByPK(String pk) throws BLException {
		return nms13DAO.findByPK(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS13SearchCond cond) {
		return nms13DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS13Info> search(NMS13SearchCond cond) {
		return nms13DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS13Info> search(NMS13SearchCond cond, int start,int count) {
		return nms13DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS13Info regist(NMS13Info instance) throws BLException {
		return nms13DAO.save(instance);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS13Info> regist(List<NMS13Info> instances) throws BLException {
		List<NMS13Info> list = new ArrayList<NMS13Info>(instances.size());
		for(NMS13Info instance:instances){
			list.add(nms13DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS13Info update(NMS13Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms13DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(String pk) throws BLException {
		nms13DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS13Info instance) throws BLException {
		nms13DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS13Info checkExistInstance(String pk) throws BLException {
		NMS13Info instance = nms13DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO13000.E004", "ʵ������");
		}
		return instance;
	}
}
