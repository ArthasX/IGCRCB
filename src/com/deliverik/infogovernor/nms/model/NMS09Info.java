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
 * Description: �û�������ͼ��Ϣʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS09Info extends BaseModel {
	
	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();

	/**
	 * ��IDȡ��
	 * @return gid ��ID
	 */
	public Integer getGid();

	/**
	 * ��汾ȡ��
	 * @return gversion ��汾
	 */
	public Integer getGversion();

	/**
	 * �û�IDȡ��
	 * @return userid �û�ID
	 */
	public String getUserid();

	/**
	 * ����ͼȡ��
	 * @return xml ����ͼ
	 */
	public String getXml();

	/**
     * ��ȡ�����
     * @return ����� 
     */
    public String getWidth() ;

    /**
     * ��ȡ���߶�
     * @return ���߶� 
     */
    public String getHeight();
    
	/**
	 * ����ʱ��ȡ��
	 * @return instime ����ʱ��
	 */
	public String getInstime();
	
	/**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getShowtype();
}
