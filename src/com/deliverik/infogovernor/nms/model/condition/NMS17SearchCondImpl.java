/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.nms.model.condition;


/**
  * ����: ����������Ϣ��������ʵ��
  * ��������: ����������Ϣ��������ʵ��
  * ������¼: 2014/01/07
  * �޸ļ�¼: 
  */
public class NMS17SearchCondImpl implements
		NMS17SearchCond {
    /** ���� */
    protected String id;

    /** ���������� */
    protected Integer gid;

    /** ������汾 */
    protected Integer gversion;

    /** �����û���ȫ��ʱΪ�գ� */
    protected String userid;

    /** x���� */
    protected String x;

    /** y���� */
    protected String y;

    /** ��� */
    protected String width;

    /** �߶� */
    protected String height;

    /** ����չ�����ͣ�1��ȫ������ͼ 2�������豸����ͼ�� */
    protected String type;
    
    /**
     * ����ȡ��
     *
     * @return ����
     */
    public String getId() {
        return id;
    }

    /**
     * �����趨
     *
     * @param id ����
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ����������ȡ��
     *
     * @return ����������
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * �����������趨
     *
     * @param gid ����������
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * ������汾ȡ��
     *
     * @return ������汾
     */
    public Integer getGversion() {
        return gversion;
    }

    /**
     * ������汾�趨
     *
     * @param gversion ������汾
     */
    public void setGversion(Integer gversion) {
        this.gversion = gversion;
    }

    /**
     * �����û���ȫ��ʱΪ�գ�ȡ��
     *
     * @return �����û���ȫ��ʱΪ�գ�
     */
    public String getUserid() {
        return userid;
    }

    /**
     * �����û���ȫ��ʱΪ�գ��趨
     *
     * @param userid �����û���ȫ��ʱΪ�գ�
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * x����ȡ��
     *
     * @return x����
     */
    public String getX() {
        return x;
    }

    /**
     * x�����趨
     *
     * @param x x����
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * y����ȡ��
     *
     * @return y����
     */
    public String getY() {
        return y;
    }

    /**
     * y�����趨
     *
     * @param y y����
     */
    public void setY(String y) {
        this.y = y;
    }

    /**
     * ���ȡ��
     *
     * @return ���
     */
    public String getWidth() {
        return width;
    }

    /**
     * ����趨
     *
     * @param width ���
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * �߶�ȡ��
     *
     * @return �߶�
     */
    public String getHeight() {
        return height;
    }

    /**
     * �߶��趨
     *
     * @param height �߶�
     */
    public void setHeight(String height) {
        this.height = height;
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