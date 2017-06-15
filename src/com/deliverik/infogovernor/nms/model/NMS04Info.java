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
 * Description: �豸��Ϣʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS04Info extends BaseModel {

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public String getId();

	/**
	 * �豸����ȡ��
	 * @return name �豸����
	 */
	public String getName();

	/**
	 * ��ʾIPȡ��
	 * @return ip ��ʾIP
	 */
	public String getIp();

	/**
	 * ��ʾMAC��ַȡ��
	 * @return mac ��ʾMAC��ַ
	 */
	public String getMac();

	/**
	 * �豸����ȡ��
	 * @return type �豸����
	 */
	public String getType();

	/**
	 * �ʲ�IDȡ��
	 * @return eiid �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ���汾ȡ��
	 * @return eiversion �ʲ���汾
	 */
	public Integer getEiversion();

	/**
	 * �ʲ�С�汾ȡ��
	 * @return eismallVersion �ʲ�С�汾
	 */
	public Integer getEismallVersion();

	/**
	 * ����ʱ��ȡ��
	 * @return instime ����ʱ��
	 */
	public String getInstime();

	/**
	 * ����ʱ��ȡ��
	 * @return updtime ����ʱ��
	 */
	public String getUpdtime();
	
	/**
     * ��ȡ�豸����
     * @return �豸���� 
     */
    public String getDispname();
}
