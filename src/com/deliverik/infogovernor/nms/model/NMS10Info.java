/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��·��������Ϣʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS10Info extends BaseModel {
    
    /**
     * ��������
     * @return ����
     */
    public String getId();

    /**
     * Դ�豸IDȡ��
     * @return fromdid Դ�豸ID
     */
    public String getFromdid();

    /**
     * Ŀ���豸IDȡ��
     * @return todid Ŀ���豸ID
     */
    public String getTodid();

    /**
     * ��IDȡ��
     * @return gid ��ID
     */
    public Integer getGid();

    /**
     * ��汾ȡ��
     * @return gversion ��汾
     */
    public Integer getGversion();
    
    /**
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid();

    /**
     * Դ�豸����˿�ȡ��
     * @return fromPhysicalPort Դ�豸����˿�
     */
    public Integer getFromPhysicalPort();

    /**
     * Դ�豸IFINDEXȡ��
     * @return fromNodeIfIndex Դ�豸IFINDEX
     */
    public Integer getFromNodeIfIndex();

    /**
     * Դ�豸IFNAMEȡ��
     * @return fromNodeIfName Դ�豸IFNAME
     */
    public String getFromNodeIfName();

    /**
     * Ŀ���豸����˿�ȡ��
     * @return topHysicalPort Ŀ���豸����˿�
     */
    public Integer getTopHysicalPort();

    /**
     * Ŀ���豸IFINDEXȡ��
     * @return toNodeIfIndex Ŀ���豸IFINDEX
     */
    public Integer getToNodeIfIndex();

    /**
     * Ŀ���豸IFNAMEȡ��
     * @return toNodeIfName Ŀ���豸IFNAME
     */
    public String getToNodeIfName();

    /**
     * ����ʱ��ȡ��
     * @return instime ����ʱ��
     */
    public String getInstime();

}
