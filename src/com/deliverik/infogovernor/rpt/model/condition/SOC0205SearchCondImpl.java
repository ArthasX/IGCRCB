/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ���������������ʵ��
  * ��������: ���������������ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportManageSearchCondImpl�����޸�ΪSOC0205SearchCondImpl
  */
public class SOC0205SearchCondImpl implements
		SOC0205SearchCond {
	
	protected String rmName_like;
	protected String dateFrom;
	protected String dateTo;
	protected String rtdatetype_eq;
	/**
	 * rmName_likeȡ��
	 *
	 * @return rmName_like rmName_like
	 */
	public String getRmName_like() {
		return rmName_like;
	}
	/**
	 * dateFromȡ��
	 *
	 * @return dateFrom dateFrom
	 */
	public String getDateFrom() {
		return dateFrom;
	}
	/**
	 * dateToȡ��
	 *
	 * @return dateTo dateTo
	 */
	public String getDateTo() {
		return dateTo;
	}
	/**
	 * rmName_like�趨
	 *
	 * @param rmName_like rmName_like
	 */
	public void setRmName_like(String rmName_like) {
		this.rmName_like = rmName_like;
	}
	/**
	 * dateFrom�趨
	 *
	 * @param dateFrom dateFrom
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	/**
	 * dateTo�趨
	 *
	 * @param dateTo dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
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
	 * rtdatetype_eq�趨
	 *
	 * @param rtdatetype_eq rtdatetype_eq
	 */
	public void setRtdatetype_eq(String rtdatetype_eq) {
		this.rtdatetype_eq = rtdatetype_eq;
	}


	
}