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
 * Description: ����������Ϣʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS03Info extends BaseModel {

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
	 * �汾ȡ��
	 * @return version �汾
	 */
	public Integer getVersion();

	/**
	 * ��������ȡ��
	 * @return type ��������
	 */
	public String getType();

	/**
	 * �Ƿ�����PINGȡ��
	 * @return isEnablePing �Ƿ�����PING
	 */
	public String getIsEnablePing() ;

	/**
	 * �Ƿ�����ARPȡ��
	 * @return isEnableArp �Ƿ�����ARP
	 */
	public String getIsEnableArp();

	/**
	 * ��ʼIPȡ��
	 * @return fromIP ��ʼIP
	 */
	public String getFromIP();

	/**
	 * ����IPȡ��
	 * @return toIP ����IP
	 */
	public String getToIP();

	/**
	 * ����ȡ��
	 * @return subNet ����
	 */
	public String getSubNet();

	/**
	 * ����ʱ��ȡ��
	 * @return instime ����ʱ��
	 */
	public String getInstime();
	
	/**
	 * ɾ����ʶȡ��
	 * @return ɾ����ʶ
	 */
	public String getDeleteflag();

}
