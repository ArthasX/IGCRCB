/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.nms.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����������Ϣ�ӿ�
  * ��������: ����������Ϣ�ӿ�
  * ������¼: 2014/01/07
  * �޸ļ�¼: 
  */
public interface NMS17Info extends BaseModel {

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
     * �������ȡ��
     * @return title
     */
    public String getTitle();
    
    /**
     * ��ȡ��ת�Ƕ�
     * @return ��ת�Ƕ� 
     */
    public String getRotation();
    
}