/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��Ϣʵ���ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS04VWSearchCond {
    
    /**
     * ��ȡ��ID
     * @return ��ID 
     */
    public Integer getGid();

    /**
     * ��ȡ��汾
     * @return ��汾 
     */
    public Integer getGversion();
    
    /**
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid();
    
    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getShowType();
}
