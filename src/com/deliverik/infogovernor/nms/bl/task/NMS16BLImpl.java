/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS16Info;
import com.deliverik.infogovernor.nms.model.condition.NMS16SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS16DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸���ϵ��Ϣʵ��BLʵ��
 * </p>
 * 
 * @version 1.0
 */
public class NMS16BLImpl extends NMSBaseBLImpl implements NMS16BL {

	/** ���豸������Ϣʵ��DAO */
	protected NMS16DAO nms16DAO;
	
	/**
     * �������豸������Ϣʵ��DAO
     * @param nms16DAO ���豸������Ϣʵ��DAO
     */
    public void setNms16DAO(NMS16DAO nms16dao) {
        nms16DAO = nms16dao;
    }

    /**
	 * ���ð汾
	 * @param version �汾
	 */
	public void setVersion(Integer version) {
		super.setVersion(version);
		nms16DAO.setVersion(version);
	}
	
	/**
	 * ���洦��
	 */
	public void upateVersion(){
		nms16DAO.upateVersionForCreateTable();
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS16Info searchByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS16SearchCond cond) {
		return nms16DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS16Info> search(NMS16SearchCond cond) {
		return nms16DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS16Info> search(NMS16SearchCond cond, int start,int count) {
		return nms16DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS16Info regist(NMS16Info instance) throws BLException {
		return nms16DAO.save(instance);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS16Info> regist(List<NMS16Info> instances) throws BLException {
		List<NMS16Info> list = new ArrayList<NMS16Info>(instances.size());
		for(NMS16Info instance:instances){
			list.add(nms16DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS16Info update(NMS16Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms16DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(String pk) throws BLException {
		nms16DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS16Info instance) throws BLException {
		nms16DAO.delete(instance);
	}
	
	/**
	 * ɾ����
	 */
	public void dropTable(){
		nms16DAO.dropTable();
	}
	
	/**
     * У�鵱ǰ���Ƿ����
     * @return true ���� false ������
     */
    public boolean checkTableExits() {
        return nms16DAO.checkTableExits();
    }
    
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS16Info checkExistInstance(String pk) throws BLException {
		NMS16Info instance = nms16DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
