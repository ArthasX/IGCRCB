/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS11Info;
import com.deliverik.infogovernor.nms.model.condition.NMS11SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS11DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������־ʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS11BLImpl extends NMSBaseBLImpl implements NMS11BL {

	/** ������־ʵ��DAO */
	protected NMS11DAO nms11DAO;

	/**
	 * ������־ʵ��DAO�趨
	 * @param nms11DAO ������־ʵ��DAO
	 */
	public void setNms11DAO(NMS11DAO nms11dao) {
		nms11DAO = nms11dao;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS11Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS11SearchCond cond) {
		return nms11DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS11Info> search(NMS11SearchCond cond) {
		return nms11DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS11Info> search(NMS11SearchCond cond, int start,int count) {
		return nms11DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS11Info regist(NMS11Info instance) throws BLException {
		return nms11DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS11Info update(NMS11Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms11DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		nms11DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS11Info instance) throws BLException {
		nms11DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS11Info checkExistInstance(Integer pk) throws BLException {
		NMS11Info instance = nms11DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
