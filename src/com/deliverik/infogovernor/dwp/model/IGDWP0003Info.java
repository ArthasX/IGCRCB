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
 * Description: �ճ������ƻ�����Ϣʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0003Info extends BaseModel{
	
	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();

	/**
	 * ������Ϣ����ȡ��
	 * @return prid ������Ϣ����
	 */
	public Integer getPrid();

	/**
	 * ������IDȡ��
	 * @return pidid ������ID
	 */
	public String getPidid();

	/**
	 * ��ֵȡ��
	 * @return pivarvalue ��ֵ
	 */
	public String getPivarvalue();

	/**
	 * ����keyȡ��
	 * @return attkey ����key
	 */
	public String getAttkey();
}
