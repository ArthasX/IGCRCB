/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;

/**
 * ����汾��Ϣ��ѯForm
 * 
 */
@SuppressWarnings("serial")
public class IGSYM0412Form extends BaseForm implements ReportFileVersionSearchCond {

	/** �������� */
	protected Integer rfdid;
	
	/** �汾���� */
	protected Integer rfvid;
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * ���������趨
	 * @param rfdid ��������
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}
	
	/**
	 * �汾����ȡ��
	 * @return �汾����
	 */
	public Integer getRfvid() {
		return rfvid;
	}
	
	/**
	 * �汾�����趨
	 * @param rfvid �汾����
	 */
	public void setRfvid(Integer rfvid) {
		this.rfvid = rfvid;
	}
	
}
