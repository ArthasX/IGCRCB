/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;

/**
 * ����: 
 * ��������: 
 * ������¼: 2012/04/27
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT02001VO extends BaseVO{
	
	/** �Զ��屨�� ���� */
	protected List<SOC0204Info> reportCustomLinkList_Pref;
	
	/** �Զ��屨�� ���� */
	protected List<SOC0204Info> reportCustomLinkList_Cap;

	/**
	 * �Զ��屨������ȡ��
	 *
	 * @return reportCustomLinkList_Pref �Զ��屨������
	 */
	public List<SOC0204Info> getReportCustomLinkList_Pref() {
		return reportCustomLinkList_Pref;
	}

	/**
	 * �Զ��屨������ȡ��
	 *
	 * @return reportCustomLinkList_Cap �Զ��屨������
	 */
	public List<SOC0204Info> getReportCustomLinkList_Cap() {
		return reportCustomLinkList_Cap;
	}

	/**
	 * �Զ��屨�������趨
	 *
	 * @param reportCustomLinkList_Pref �Զ��屨������
	 */
	public void setReportCustomLinkList_Pref(
			List<SOC0204Info> reportCustomLinkList_Pref) {
		this.reportCustomLinkList_Pref = reportCustomLinkList_Pref;
	}

	/**
	 * �Զ��屨�������趨
	 *
	 * @param reportCustomLinkList_Cap �Զ��屨������
	 */
	public void setReportCustomLinkList_Cap(
			List<SOC0204Info> reportCustomLinkList_Cap) {
		this.reportCustomLinkList_Cap = reportCustomLinkList_Cap;
	}
}
