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
 * Description: �����Դ����Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1301Form extends BaseForm{

	/** vCenter���� */
	protected Integer vcid;
	
	/** �������� */
	protected String hostname;

	/**
	 * vCenter����ȡ��
	 * @return vcid vCenter����
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter�����趨
	 * @param vcid vCenter����
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * ��������ȡ��
	 * @return hostname ��������
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * ���������趨
	 * @param hostname ��������
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
}
