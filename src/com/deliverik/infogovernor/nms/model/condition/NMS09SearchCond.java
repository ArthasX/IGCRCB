/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �û�������ͼ��Ϣʵ���ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS09SearchCond {
    /**
     * ��ȡ��ID
     * @return ��ID 
     */
    public Integer getGid_eq() ;

    /**
     * ��ȡ��汾
     * @return ��汾 
     */
    public Integer getGversion_eq();

    /**
     * ��ȡ�û�ID
     * @return �û�ID 
     */
    public String getUserid_eq();
    
    /**
     * ��ȡ�û�IDΪ��
     * @return �û�IDΪ�� 
     */
    public boolean isUseridEmpty();
    
    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getShowtype();
}
