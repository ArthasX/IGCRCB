/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ���������Ϣ��ʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0004Info extends BaseModel{
	
	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();
	
	/**
	 * �ƻ�IDȡ��
	 * @return planid �ƻ�ID
	 */
	public Integer getPlanid();

	/**
	 * ������ϢIDȡ��
	 * @return prid ������ϢID
	 */
	public Integer getPrid();

	/**
	 * ״̬IDȡ��
	 * @return psdid ״̬ID
	 */
	public String getPsdid();

	/**
	 * �û�IDȡ��
	 * @return usersid �û�ID
	 */
	public String getUserid();

	/**
	 * �����ɫIDȡ��
	 * @return roleid �����ɫID
	 */
	public Integer getRoleid();
}
