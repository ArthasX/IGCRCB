/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ������̱�����Ԥ��Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0173Form extends BaseForm{

	/** ���̶������� */
	protected String pdid;
	
	/** ���������� */
	protected String pidid;

	/**
	 * ���̶�������ȡ��
	 * @return pdid ���̶�������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶��������趨
	 * @param pdid ���̶�������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����������ȡ��
	 * @return pidid ����������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * �����������趨
	 * @param pidid ����������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	
	
}
