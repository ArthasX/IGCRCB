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
 * Description: �豸MAC/IP��Ϣʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS06Info extends BaseModel {

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public String getId();

	/**
	 * �豸IDȡ��
	 * @return did �豸ID
	 */
	public String getDid();

	/**
	 * IPȡ��
	 * @return ip IP
	 */
	public String getIp();

	/**
	 * MAC��ַȡ��
	 * @return mac MAC��ַ
	 */
	public String getMac();

	/**
	 * ����ʱ��ȡ��
	 * @return instime ����ʱ��
	 */
	public String getInstime();
}
