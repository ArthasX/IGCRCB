/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * ��Ȩ��������ӿ�
 * 
 * 
 */

public interface IG463Info extends BaseModel {
	/**
	 * ��Ȩ����IDȡ��
	 * 
	 * @return ��Ȩ����ID
	 */
	public Integer getPpwid();
	
	
	/**
	 * ����idȡ��
	 * 
	 * @return ����id
	 */
	public Integer getPpwprid();
	
	
	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getPpwprtype();
	

	/**
	 * ���̱��ȡ��
	 * 
	 * @return ���̱��
	 */
	public String getPpwprserialnum();
	
	
	/**
	 * ���̱���ȡ��
	 * 
	 * @return ���̱���
	 */
	public String getPpwprtitle();
	
	/**
	 * ��Ȩ��idȡ��
	 * 
	 * @return ��Ȩ��id
	 */
	public String getPpwauthorizeuserid();
	
	/**
	 * ������idȡ��
	 * 
	 * @return ������id
	 */
	public String getPpwproxyuserid();
	
	/**
	 * ����������ȡ��
	 * 
	 * @return ����������
	 */
	public String getPpwproxyusername();
	
	
	/**
	 * �����˴���ʱ��ȡ��
	 * 
	 * @return �����˴���ʱ��
	 */
	public String getPpwoptiontime();
	
	
	/**
	 * �رձ�־ȡ��
	 * 
	 * @return �رձ�־
	 */
	public String getPpwcloseflag();
	
}