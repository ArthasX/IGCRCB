/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS06Info;
import com.deliverik.infogovernor.nms.model.condition.NMS06SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS06DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸MAC/IP��Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS06BLImpl extends NMSBaseBLImpl implements NMS06BL {

	/** �豸MAC/IP��Ϣʵ��DAO */
	protected NMS06DAO nms06DAO;

	/**
	 * �豸MAC/IP��Ϣʵ��DAO�趨
	 * @param nms06DAO �豸MAC/IP��Ϣʵ��DAO
	 */
	public void setNms06DAO(NMS06DAO nms06dao) {
		nms06DAO = nms06dao;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS06Info searchByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS06SearchCond cond) {
		return nms06DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS06Info> search(NMS06SearchCond cond) {
		return nms06DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS06Info> search(NMS06SearchCond cond, int start,int count) {
		return nms06DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS06Info regist(NMS06Info instance) throws BLException {
		return nms06DAO.save(instance);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS06Info> regist(List<NMS06Info> instances) throws BLException {
		List<NMS06Info> list = new ArrayList<NMS06Info>();
		for(NMS06Info instance:instances){
			list.add(nms06DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS06Info update(NMS06Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms06DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(String pk) throws BLException {
		nms06DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS06Info instance) throws BLException {
		nms06DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS06Info checkExistInstance(String pk) throws BLException {
		NMS06Info instance = nms06DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
