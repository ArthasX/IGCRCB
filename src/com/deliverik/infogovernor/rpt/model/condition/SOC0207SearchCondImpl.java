/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ����ģ���������ʵ��
  * ��������: ����ģ���������ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateSearchCondImpl�����޸�ΪSOC0207SearchCondImpl
  */
public class SOC0207SearchCondImpl implements SOC0207SearchCond {
	protected String rtname_like;
	protected String rtdatetype_eq;
	/**
	 * rtname_likeȡ��
	 *
	 * @return rtname_like rtname_like
	 */
	public String getRtname_like() {
		return rtname_like;
	}
	/**
	 * rtdatetype_eqȡ��
	 *
	 * @return rtdatetype_eq rtdatetype_eq
	 */
	public String getRtdatetype_eq() {
		return rtdatetype_eq;
	}
	/**
	 * rtname_like�趨
	 *
	 * @param rtname_like rtname_like
	 */
	public void setRtname_like(String rtname_like) {
		this.rtname_like = rtname_like;
	}
	/**
	 * rtdatetype_eq�趨
	 *
	 * @param rtdatetype_eq rtdatetype_eq
	 */
	public void setRtdatetype_eq(String rtdatetype_eq) {
		this.rtdatetype_eq = rtdatetype_eq;
	}

}