/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS07Info;
import com.deliverik.infogovernor.nms.model.condition.NMS07SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS07DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��·��Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS07BLImpl extends NMSBaseBLImpl implements NMS07BL {

	/** ��·��Ϣʵ��DAO */
	protected NMS07DAO nms07DAO;

	/**
	 * ��·��Ϣʵ��DAO�趨
	 * @param nms07DAO ��·��Ϣʵ��DAO
	 */
	public void setNms07DAO(NMS07DAO nms07dao) {
		nms07DAO = nms07dao;
	}
	
	/**
	 * ���ð汾
	 * @param version �汾
	 */
	public void setVersion(Integer version) {
		super.setVersion(version);
		nms07DAO.setVersion(version);
	}
	
	/**
	 * ���洦��
	 */
	public void upateVersion(){
		nms07DAO.upateVersionForCreateTable();
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS07Info searchByPK(String pk) throws BLException {
		return nms07DAO.findByPK(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS07SearchCond cond) {
		return nms07DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS07Info> search(NMS07SearchCond cond) {
		return nms07DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS07Info> search(NMS07SearchCond cond, int start,int count) {
		return nms07DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS07Info regist(NMS07Info instance) throws BLException {
		return nms07DAO.save(instance);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS07Info> regist(List<NMS07Info> instances) throws BLException {
		List<NMS07Info> list = null;
		if(instances != null && instances.size() > 0){
			list = new ArrayList<NMS07Info>();
			for(NMS07Info entity : instances){
				list.add(nms07DAO.save(entity));
			}
		}
		return list;
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS07Info update(NMS07Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms07DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(String pk) throws BLException {
		nms07DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS07Info instance) throws BLException {
		nms07DAO.delete(instance);
	}
	
	/**
	 * ɾ����
	 */
	public void dropTable(){
		nms07DAO.dropTable();
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS07Info checkExistInstance(String pk) throws BLException {
		NMS07Info instance = nms07DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
