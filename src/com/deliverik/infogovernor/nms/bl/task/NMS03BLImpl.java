/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS03Info;
import com.deliverik.infogovernor.nms.model.condition.NMS03SearchCond;
import com.deliverik.infogovernor.nms.model.condition.NMS03SearchCondImpl;
import com.deliverik.infogovernor.nms.model.dao.NMS03DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����������Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS03BLImpl extends NMSBaseBLImpl implements NMS03BL {

	/** ����������Ϣʵ��DAO */
	protected NMS03DAO nms03DAO;

	/**
	 * ����������Ϣʵ��DAO�趨
	 * @param nms03DAO ����������Ϣʵ��DAO
	 */
	public void setNms03DAO(NMS03DAO nms03dao) {
		nms03DAO = nms03dao;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS03Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���°汾����
	 * @return ���°汾
	 */
	public List<NMS03Info> searchNewest(NMS03SearchCond cond){
		return nms03DAO.searchNewest(cond);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS03SearchCond cond) {
		return nms03DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS03Info> search(NMS03SearchCond cond) {
		return nms03DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS03Info> search(NMS03SearchCond cond, int start,int count) {
		return nms03DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS03Info regist(NMS03Info instance) throws BLException {
		checkExistInstance(instance.getGid(), instance.getType(),
				instance.getFromIP(), instance.getToIP(), instance.getSubNet());
		return nms03DAO.save(instance);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS03Info> regist(List<NMS03Info> instances) throws BLException {
		List<NMS03Info> list = new ArrayList<NMS03Info>(instances.size());
		for(NMS03Info instance:instances){
			list.add(nms03DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS03Info update(NMS03Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms03DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		nms03DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS03Info instance) throws BLException {
		nms03DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS03Info checkExistInstance(Integer pk) throws BLException {
		NMS03Info instance = nms03DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	

	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param gid ��ID
	 * @param gversion ��汾
	 * @param type ��������
	 * @param fromIP ��ʼIP
	 * @param toIP ����IP
	 * @param subNet ����
	 * @return ʵ��
	 */
	public void checkExistInstance(Integer gid, String type,
			String fromIP, String toIP, String subNet) throws BLException {
		NMS03SearchCondImpl cond = new NMS03SearchCondImpl();
		cond.setDeleteflag("0");
		cond.setGid(gid);
		cond.setType(type);
		if(NMSBaseBLImpl.TaskType_IP.equals(type)) {
			cond.setFromIP(fromIP);
			cond.setToIP(toIP);
		} else if(NMSBaseBLImpl.TaskType_SubNet.equals(type)) {
			cond.setSubNet(subNet);
		} else if(NMSBaseBLImpl.TaskType_Route.equals(type)) {
			cond.setFromIP(fromIP);
		}
		//��ѯ���°汾
		List<NMS03Info> lst_NMS03Info = this.searchNewest(cond);
		if (!lst_NMS03Info.isEmpty()) {
			throw new BLException("IGCO10000.E140", "���û�����Ϣ�Ѵ���");
		}
		//��ѯ0�汾
		cond.setVersion(0);
		lst_NMS03Info = this.search(cond);
		if (!lst_NMS03Info.isEmpty()) {
			throw new BLException("IGCO10000.E140", "���û�����Ϣ�Ѵ���");
		}
	}
	
}
