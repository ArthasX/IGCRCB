/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:�����
 * ���������������
 * �����ˣ�����͢
 * ������¼�� 2013-09-02
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0801Form extends BaseForm {

	/** ���˿�ʼ���� */
	protected String assessstartdate;
	
	/** ���˽������� */
	protected String assessoverdate;
	
	/** ������� 1�����ſ��� 2����Ա���� */
	protected String assesstype;

	public String getAssessstartdate() {
		return assessstartdate;
	}
	public void setAssessstartdate(String assessstartdate) {
		this.assessstartdate = assessstartdate;
	}

	public String getAssessoverdate() {
		return assessoverdate;
	}

	public void setAssessoverdate(String assessoverdate) {
		this.assessoverdate = assessoverdate;
	}
	public String getAssesstype() {
		return assesstype;
	}
	public void setAssesstype(String assesstype) {
		this.assesstype = assesstype;
	}
	
	
}
