/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:vCloud��֯��ƽ̨��������ʵ��ӿ� 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface VCD06Info extends BaseModel{
	
	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();

	/**
	 * vCloud��֯ȡ��
	 * @return vorg vCloud��֯
	 */
	public String getVorg();

	/**
	 * ������ȡ��
	 * @return orgsyscoding ������
	 */
	public String getOrgsyscoding();

	/**
	 * ��������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname();
}
