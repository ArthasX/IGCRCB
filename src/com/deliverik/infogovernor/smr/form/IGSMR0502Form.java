/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �˵����ʾform
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSMR0502Form extends BaseForm{

	/** ���̶������� */
	protected String pdid;
	/** �˵�� */
	protected String reportdesc;
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
	 * �˵��ȡ��
	 * @return reportdesc �˵��
	 */
	public String getReportdesc() {
		return reportdesc;
	}
	/**
	 * �˵���趨
	 * @param reportdesc �˵��
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}
	
}
