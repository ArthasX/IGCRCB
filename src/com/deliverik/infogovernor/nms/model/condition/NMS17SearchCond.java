/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.nms.model.condition;

/**
  * ����: ����������Ϣ���������ӿ�
  * ��������: ����������Ϣ���������ӿ�
  * ������¼: 2014/01/07
  * �޸ļ�¼: 
  */
public interface NMS17SearchCond {

    /**
     * ����ȡ��
     *
     * @return ����
     */
    public String getId();

    /**
     * ����������ȡ��
     *
     * @return ����������
     */
    public Integer getGid();

    /**
     * ������汾ȡ��
     *
     * @return ������汾
     */
    public Integer getGversion();

    /**
     * �����û���ȫ��ʱΪ�գ�ȡ��
     *
     * @return �����û���ȫ��ʱΪ�գ�
     */
    public String getUserid();

    /**
     * x����ȡ��
     *
     * @return x����
     */
    public String getX();

    /**
     * y����ȡ��
     *
     * @return y����
     */
    public String getY();

    /**
     * ���ȡ��
     *
     * @return ���
     */
    public String getWidth();

    /**
     * �߶�ȡ��
     *
     * @return �߶�
     */
    public String getHeight();

    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getType();
}