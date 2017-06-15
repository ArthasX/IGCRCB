/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS15Info;
import com.deliverik.infogovernor.nms.model.condition.NMS15SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS15DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ����ּ�¼ʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS15BLImpl extends NMSBaseBLImpl implements NMS15BL {

	/** �Զ����ּ�¼ʵ��DAO */
	protected NMS15DAO nms15DAO;

	/**
	 * �Զ����ּ�¼ʵ��DAO�趨
	 * @param nms15DAO �Զ����ּ�¼ʵ��DAO
	 */
	public void setNms15DAO(NMS15DAO nms15dao) {
		nms15DAO = nms15dao;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS15Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS15SearchCond cond) {
		return nms15DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS15Info> search(NMS15SearchCond cond) {
		return nms15DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS15Info> search(NMS15SearchCond cond, int start,int count) {
		return nms15DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS15Info regist(NMS15Info instance) throws BLException {
		return nms15DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS15Info update(NMS15Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms15DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		nms15DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS15Info instance) throws BLException {
		nms15DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS15Info checkExistInstance(Integer pk) throws BLException {
		NMS15Info instance = nms15DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("����Ϣ�����ڣ�");
		}
		return instance;
	}
}
