/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դʹ�����ͳ��Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1402Form extends BaseForm{

	/** vCenter����ID */
	protected Integer vcid;
	
	/** ����IP */
	protected String hostname;

	/**
	 * vCenter����IDȡ��
	 * @return vcid vCenter����ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter����ID�趨
	 * @param vcid vCenter����ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * ����IPȡ��
	 * @return hostname ����IP
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * ����IP�趨
	 * @param hostname ����IP
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
}
