/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS01Info;
import com.deliverik.infogovernor.nms.model.condition.NMS01SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS01DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS01BLImpl extends NMSBaseBLImpl implements NMS01BL {

	/** ����Ϣʵ��DAO */
	protected NMS01DAO nms01DAO;

	/**
	 * ����Ϣʵ��DAO�趨
	 * @param nms01DAO ����Ϣʵ��DAO
	 */
	public void setNms01DAO(NMS01DAO nms01dao) {
		nms01DAO = nms01dao;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS01Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS01SearchCond cond) {
		return nms01DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS01Info> search(NMS01SearchCond cond) {
		return nms01DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS01Info> search(NMS01SearchCond cond, int start,int count) {
		return nms01DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS01Info regist(NMS01Info instance) throws BLException {
		return nms01DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS01Info update(NMS01Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms01DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		nms01DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS01Info instance) throws BLException {
		nms01DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS01Info checkExistInstance(Integer pk) throws BLException {
		NMS01Info instance = nms01DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E140", "����Ϣ�����ڣ�");
		}
		return instance;
	}
}
