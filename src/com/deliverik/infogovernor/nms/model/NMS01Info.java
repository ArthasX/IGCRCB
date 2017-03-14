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
 * Description: ����Ϣʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS01Info extends BaseModel {

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();

	/**
	 * ������ȡ��
	 * @return name ������
	 */
	public String getName();

	/**
	 * �ϼ���ȡ��
	 * @return parentid �ϼ���
	 */
	public Integer getParentid();

	/**
	 * ��עȡ��
	 * @return remark ��ע
	 */
	public String getRemark();

	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public Integer getVersion();

	/**
	 * ����ʱ��ȡ��
	 * @return instime ����ʱ��
	 */
	public String getInstime();
}
