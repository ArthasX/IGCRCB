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
 * Description: ���豸������Ϣʵ��ӿ�
 * </p>
 * 
 * @version 1.0
 */
public interface NMS16Info extends BaseModel {
    /**
     * ��ȡ����
     * @return ���� 
     */
    public String getId();

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
    public String getUserid() ;
    /**
     * ��ȡX����
     * @return X���� 
     */
    public String getX();

    /**
     * ��ȡY����
     * @return Y���� 
     */
    public String getY();

    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getShowtype();
}
