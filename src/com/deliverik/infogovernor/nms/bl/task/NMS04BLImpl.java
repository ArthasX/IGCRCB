/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS04Info;
import com.deliverik.infogovernor.nms.model.NMS04VWInfo;
import com.deliverik.infogovernor.nms.model.condition.NMS04SearchCond;
import com.deliverik.infogovernor.nms.model.condition.NMS04VWSearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS04DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS04BLImpl extends NMSBaseBLImpl implements NMS04BL {

    /** �豸��Ϣʵ��DAO */
    protected NMS04DAO nms04DAO;

    /**
     * �豸��Ϣʵ��DAO�趨
     * @param nms04DAO �豸��Ϣʵ��DAO
     */
    public void setNms04DAO(NMS04DAO nms04dao) {
        nms04DAO = nms04dao;
    }
    
    /**
     * ������������
     *
     * @param pk ����
     * @return �������
     */
    public NMS04Info searchByPK(String pk) throws BLException {
        return checkExistInstance(pk);
    }
    
    /**
     * ���������������ȡ��
     *
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(NMS04SearchCond cond) {
        return nms04DAO.getSearchCount(cond);
    }

    /**
     * ������������
     *
     * @param cond ��������
     * @return ��������б�
     */
    public List<NMS04Info> search(NMS04SearchCond cond) {
        return nms04DAO.findByCond(cond, 0, 0);
    }
    
    /**
     * ������������
     *
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<NMS04Info> search(NMS04SearchCond cond, int start,int count) {
        return nms04DAO.findByCond(cond, start, count);
    }
    
    /**
     * ��������
     *
     * @param instance ����ʵ��
     * @return ����ʵ��
     */
    public NMS04Info regist(NMS04Info instance) throws BLException {
        return nms04DAO.save(instance);
    }
    
    /**
     * ��������
     *
     * @param instance ����ʵ��
     * @return ����ʵ��
     */
    public List<NMS04Info> regist(List<NMS04Info> instances) throws BLException {
        List<NMS04Info> list = new ArrayList<NMS04Info>(instances.size());
        for(NMS04Info instance:instances){
            list.add(nms04DAO.save(instance));
        }
        return list;
    }
    
    /**
     * �޸Ĵ���
     *
     * @param instance �޸�ʵ��
     * @return �޸�ʵ��
     */
    public NMS04Info update(NMS04Info instance) throws BLException {
        checkExistInstance(instance.getId());
        return nms04DAO.save(instance);
    }
    
    /**
     * ɾ������
     *
     * @param pk ����
     */
    public void delete(String pk) throws BLException {
        nms04DAO.delete(checkExistInstance(pk));
    }
    
    /**
     * ɾ������
     *
     * @param instance ɾ��ʵ��
     */
    public void delete(NMS04Info instance) throws BLException {
        nms04DAO.delete(instance);
    }
    
    /**
     * ʵ�����ڼ�鴦��
     *
     * @param pk ����
     * @return ʵ��
     */
    public NMS04Info checkExistInstance(String pk) throws BLException {
        NMS04Info instance = nms04DAO.findByPK(pk);
        if (instance == null) {
            throw new BLException("IGCO10000.E004", "ʵ������");
        }
        return instance;
    }
	
	/**
     * ������汾��ѯ�豸��Ϣ
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<NMS04VWInfo> searchDeviceByGroup(final NMS04VWSearchCond cond, final Integer version) throws BLException {
        return nms04DAO.searchDeviceByGroup(cond, version);
    }
}
