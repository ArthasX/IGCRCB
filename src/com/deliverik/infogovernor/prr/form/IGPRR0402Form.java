/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: һ���˵��µķ���Ŀ¼�б�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0402Form extends BaseForm{

	/** �������� */
	protected String syscoding;
	
	/** һ���˵����� */
	protected String firstActlabel;

	/**
	 * ��������ȡ��
	 * @return syscoding ��������
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * ���������趨
	 * @param syscoding ��������
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * һ���˵�����ȡ��
	 * @return firstActlabel һ���˵�����
	 */
	public String getFirstActlabel() {
		return firstActlabel;
	}

	/**
	 * һ���˵������趨
	 * @param firstActlabel һ���˵�����
	 */
	public void setFirstActlabel(String firstActlabel) {
		this.firstActlabel = firstActlabel;
	}
}
