/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS05Info;
import com.deliverik.infogovernor.nms.model.condition.NMS05SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS05DAO;
import com.deliverik.infogovernor.nms.model.entity.NMS05PK;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸���ϵ��Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS05BLImpl extends NMSBaseBLImpl implements NMS05BL {

	/** �豸���ϵ��Ϣʵ��DAO */
	protected NMS05DAO nms05DAO;

	/**
	 * �豸���ϵ��Ϣʵ��DAO�趨
	 * @param nms05DAO �豸���ϵ��Ϣʵ��DAO
	 */
	public void setNms05DAO(NMS05DAO nms05dao) {
		nms05DAO = nms05dao;
	}
	
	/**
	 * ���ð汾
	 * @param version �汾
	 */
	public void setVersion(Integer version) {
		super.setVersion(version);
		nms05DAO.setVersion(version);
	}
	
	/**
	 * ���洦��
	 */
	public void upateVersion(){
		nms05DAO.upateVersionForCreateTable();
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS05Info searchByPK(NMS05PK pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS05SearchCond cond) {
		return nms05DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS05Info> search(NMS05SearchCond cond) {
		return nms05DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS05Info> search(NMS05SearchCond cond, int start,int count) {
		return nms05DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS05Info regist(NMS05Info instance) throws BLException {
		return nms05DAO.save(instance);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS05Info> regist(List<NMS05Info> instances) throws BLException {
		List<NMS05Info> list = new ArrayList<NMS05Info>(instances.size());
		for(NMS05Info instance:instances){
			list.add(nms05DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS05Info update(NMS05Info instance) throws BLException {
		checkExistInstance(new NMS05PK(instance.getGid(), instance.getDid(), instance.getGversion()));
		return nms05DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(NMS05PK pk) throws BLException {
		nms05DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS05Info instance) throws BLException {
		nms05DAO.delete(instance);
	}
	
	/**
	 * ɾ����
	 */
	public void dropTable(){
		nms05DAO.dropTable();
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS05Info checkExistInstance(NMS05PK pk) throws BLException {
		NMS05Info instance = nms05DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
