/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���豸�����ѯ����ʵ��
 * </p>
 * 
 * @version 1.0
 */
public class NMS04VWSearchCondImpl implements NMS04VWSearchCond{

    /** ��ID */
    protected Integer gid;

    /** ��汾 */
    protected Integer gversion;

    /** �û�id */
    protected String userid;
    
    /** ����չ�����ͣ�1��ȫ������ͼ 2�������豸����ͼ�� */
    protected String showType;
    
    /**
     * ��ȡ��ID
     * @return ��ID 
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * ������ID
     * @param gid ��ID
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * ��ȡ��汾
     * @return ��汾 
     */
    public Integer getGversion() {
        return gversion;
    }

    /**
     * ������汾
     * @param gversion ��汾
     */
    public void setGversion(Integer gversion) {
        this.gversion = gversion;
    }

    /**
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * �����û�id
     * @param userid �û�id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getShowType() {
        return showType;
    }

    /**
     * ��������չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @param showType ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     */
    public void setShowType(String showType) {
        this.showType = showType;
    }
    
}
