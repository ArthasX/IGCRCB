/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �û�������ͼ��Ϣʵ���ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS09SearchCondImpl implements NMS09SearchCond{

    /** ��ID */
    protected Integer gid_eq;
    
    /** ��汾 */
    protected Integer gversion_eq;
    
    /** �û�ID */
    protected String userid_eq;
    
    /** �û�IDΪ�� */
    protected boolean useridEmpty =  false;

    /** ����չ�����ͣ�1��ȫ������ͼ 2�������豸����ͼ�� */
    protected String showtype;
    
    /**
     * ��ȡ��ID
     * @return ��ID 
     */
    public Integer getGid_eq() {
        return gid_eq;
    }

    /**
     * ������ID
     * @param gid_eq ��ID
     */
    public void setGid_eq(Integer gid_eq) {
        this.gid_eq = gid_eq;
    }

    /**
     * ��ȡ��汾
     * @return ��汾 
     */
    public Integer getGversion_eq() {
        return gversion_eq;
    }

    /**
     * ������汾
     * @param gversion_eq ��汾
     */
    public void setGversion_eq(Integer gversion_eq) {
        this.gversion_eq = gversion_eq;
    }

    /**
     * ��ȡ�û�ID
     * @return �û�ID 
     */
    public String getUserid_eq() {
        return userid_eq;
    }

    /**
     * �����û�ID
     * @param userid_eq �û�ID
     */
    public void setUserid_eq(String userid_eq) {
        this.userid_eq = userid_eq;
    }

    /**
     * ��ȡ�û�IDΪ��
     * @return �û�IDΪ�� 
     */
    public boolean isUseridEmpty() {
        return useridEmpty;
    }

    /**
     * �����û�IDΪ��
     * @param useridEmpty �û�IDΪ��
     */
    public void setUseridEmpty(boolean useridEmpty) {
        this.useridEmpty = useridEmpty;
    }

    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getShowtype() {
        return showtype;
    }

    /**
     * ��������չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @param showtype ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     */
    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }
    
}
