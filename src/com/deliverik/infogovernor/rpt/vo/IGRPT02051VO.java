/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;

/**
 * ����: ����ģ������ҳ��
 * ��������: 
 * ������¼: ����ȫ 2012/06/18
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT02051VO extends BaseVO{
	/**ģ�弯��*/
	protected List<SOC0207Info> reportTemplateList;
	/**Ĭ��ģ������*/
	protected String rtDateType;
	/**���Ӽ���*/
	private List<SOC0202Info> reportAnnexationList=new ArrayList<SOC0202Info>();

	/**
	 * ģ�弯��ȡ��
	 *
	 * @return reportTemplateList ģ�弯��
	 */
	public List<SOC0207Info> getReportTemplateList() {
		return reportTemplateList;
	}
	/**
	 * ģ�弯���趨
	 *
	 * @param reportTemplateList ģ�弯��
	 */
	public void setReportTemplateList(List<SOC0207Info> reportTemplateList) {
		this.reportTemplateList = reportTemplateList;
	}
	/**
	 * Ĭ��ģ������ȡ��
	 *
	 * @return rtDateType Ĭ��ģ������
	 */
	public String getRtDateType() {
		return rtDateType;
	}
	/**
	 * Ĭ��ģ�������趨
	 *
	 * @param rtDateType Ĭ��ģ������
	 */
	public void setRtDateType(String rtDateType) {
		this.rtDateType = rtDateType;
	}
	/**
	 * ���Ӽ���ȡ��
	 *
	 * @return reportAnnexationList ���Ӽ���
	 */
	public List<SOC0202Info> getReportAnnexationList() {
		return reportAnnexationList;
	}
	/**
	 * ���Ӽ����趨
	 *
	 * @param reportAnnexationList ���Ӽ���
	 */
	public void setReportAnnexationList(
			List<SOC0202Info> reportAnnexationList) {
		this.reportAnnexationList = reportAnnexationList;
	}
	
}
