/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCond;

/**
 * ����: �����ѯForm
 * ��������: 
 * ������¼: 2012/06/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT0204Form extends BaseForm implements SOC0205SearchCond {
	/**��ѯģ���ר��rtdatetype_eq*/
	protected String rtdatetype_eq;
	/**����ɾ��id*/
	protected String[] delid;
	/**��������ģ��*/
	protected String rmName_like;
	/**ʱ���*/
	protected String dateFrom;
	/**ʱ�䵽*/
	protected String dateTo;
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
	 * ��ѯģ���ר��rtdatetype_eqȡ��
	 *
	 * @return rtdatetype_eq ��ѯģ���ר��rtdatetype_eq
	 */
	public String getRtdatetype_eq() {
		return rtdatetype_eq;
	}
	/**
	 * ����ɾ��idȡ��
	 *
	 * @return delid ����ɾ��id
	 */
	public String[] getDelid() {
		return delid;
	}
	/**
	 * ��ѯģ���ר��rtdatetype_eq�趨
	 *
	 * @param rtdatetype_eq ��ѯģ���ר��rtdatetype_eq
	 */
	public void setRtdatetype_eq(String rtdatetype_eq) {
		this.rtdatetype_eq = rtdatetype_eq;
	}
	/**
	 * ����ɾ��id�趨
	 *
	 * @param delid ����ɾ��id
	 */
	public void setDelid(String[] delid) {
		this.delid = delid;
	}
	
	

	
}
