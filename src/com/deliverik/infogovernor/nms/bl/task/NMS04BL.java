/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS04Info;
import com.deliverik.infogovernor.nms.model.NMS04VWInfo;
import com.deliverik.infogovernor.nms.model.condition.NMS04SearchCond;
import com.deliverik.infogovernor.nms.model.condition.NMS04VWSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��Ϣʵ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS04BL extends NMSBaseBL {

    /**
     * ������������
     *
     * @param pk ����
     * @return �������
     */
    public NMS04Info searchByPK(String pk) throws BLException;
    
    /**
     * ���������������ȡ��
     *
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(NMS04SearchCond cond);

    /**
     * ������������
     *
     * @param cond ��������
     * @return ��������б�
     */
    public List<NMS04Info> search(NMS04SearchCond cond);
    
    /**
     * ������������
     *
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<NMS04Info> search(NMS04SearchCond cond, int start,int count);
    
    /**
     * ��������
     *
     * @param instance ����ʵ��
     * @return ����ʵ��
     */
    public NMS04Info regist(NMS04Info instance) throws BLException;
    
    /**
     * ��������
     *
     * @param instance ����ʵ��
     * @return ����ʵ��
     */
    public List<NMS04Info> regist(List<NMS04Info> instances) throws BLException;
    
    /**
     * �޸Ĵ���
     *
     * @param instance �޸�ʵ��
     * @return �޸�ʵ��
     */
    public NMS04Info update(NMS04Info instance) throws BLException;
    
    /**
     * ɾ������
     *
     * @param pk ����
     */
    public void delete(String pk) throws BLException;
    
    /**
     * ɾ������
     *
     * @param instance ɾ��ʵ��
     */
    public void delete(NMS04Info instance) throws BLException;
	
	/**
     * ������汾��ѯ�豸��Ϣ
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<NMS04VWInfo> searchDeviceByGroup(final NMS04VWSearchCond cond, final Integer version) throws BLException;
}
