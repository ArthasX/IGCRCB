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
 * Description: �Զ����ּ�¼ʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS15Info extends BaseModel{

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();
	
	/**
	 * ����汾ȡ��
	 * @return rversion ����汾
	 */
	public Integer getRversion();

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
	 * ��ʼʱ��ȡ��
	 * @return starttime ��ʼʱ��
	 */
	public String getStarttime();

	/**
	 * ����ʱ��ȡ��
	 * @return endtime ����ʱ��
	 */
	public String getEndtime();
}
