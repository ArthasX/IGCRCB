/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���豸�����ѯ�����ӿ�
 * </p>
 * 
 * @version 1.0
 */
public interface NMS16SearchCond {


    /**
     * ��ȡ��ID
     * @return ��ID 
     */
    public Integer getGid();

    /**
     * ��ȡ�豸ID
     * @return �豸ID 
     */
    public String getDid();
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
     * ��ȡ�û�idΪ�գ���ѯȫ������ʱ�ã�
     * @return �û�idΪ�գ���ѯȫ������ʱ�ã� 
     */
    public boolean isUseridEmpty();
    
    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getType();
}
