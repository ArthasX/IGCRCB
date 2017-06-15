/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����������Ϣʵ���ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS03SearchCond {
	
	/**
	 * ��IDȡ��
	 * @return gid ��ID
	 */
	public Integer getGid();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getType();

	/**
	 * ��ʼIPȡ��
	 * @return ��ʼIP
	 */
	public String getFromIP();

	/**
	 * ����IPȡ��
	 * @return ����IP
	 */
	public String getToIP();

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getSubNet();

	/**
	 * ɾ����ʶȡ��
	 * @return ɾ����ʶ
	 */
	public String getDeleteflag();
	
	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public Integer getVersion();
}
