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
 * Description: ������־ʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS11Info extends BaseModel {

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
	 * ��־��Ϣȡ��
	 * @return msg ��־��Ϣ
	 */
	public String getMsg();

	/**
	 * ����ʱ��ȡ��
	 * @return instime ����ʱ��
	 */
	public String getInstime();
}
