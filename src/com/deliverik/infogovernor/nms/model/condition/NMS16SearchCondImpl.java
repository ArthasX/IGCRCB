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
public class NMS16SearchCondImpl implements NMS16SearchCond{

    /** ��ID */
    protected Integer gid;
    
    /** �豸ID */
    protected String did;
    
    /** ��汾 */
    protected Integer gversion;
    
    /** �û�id */
    protected String userid;

    /** �û�idΪ�գ���ѯȫ������ʱ�ã� */
    protected boolean useridEmpty;
    
    /** ����չ�����ͣ�1��ȫ������ͼ 2�������豸����ͼ�� */
    protected String type;
    
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
     * ��ȡ�豸ID
     * @return �豸ID 
     */
    public String getDid() {
        return did;
    }

    /**
     * �����豸ID
     * @param did �豸ID
     */
    public void setDid(String did) {
        this.did = did;
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
     * ��ȡ�û�idΪ�գ���ѯȫ������ʱ�ã�
     * @return �û�idΪ�գ���ѯȫ������ʱ�ã� 
     */
    public boolean isUseridEmpty() {
        return useridEmpty;
    }

    /**
     * �����û�idΪ�գ���ѯȫ������ʱ�ã�
     * @param useridEmpty �û�idΪ�գ���ѯȫ������ʱ�ã�
     */
    public void setUseridEmpty(boolean useridEmpty) {
        this.useridEmpty = useridEmpty;
    }

    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getType() {
        return type;
    }

    /**
     * ��������չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @param type ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     */
    public void setType(String type) {
        this.type = type;
    }
}
