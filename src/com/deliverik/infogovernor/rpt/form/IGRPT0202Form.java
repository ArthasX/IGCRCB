/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;

/**
 * ����: �Զ������ѯForm
 * ��������: �Զ������ѯForm
 * ������¼: 2012/06/08
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT0202Form extends BaseForm implements SOC0207SearchCond{
	
	/** ����ɾ�� */
	protected String[] delid;
	/** ���ڷ���eq */
	protected String rtdatetype_eq;
	/** ģ������like */
	protected String rtname_like;

	/**
	 * ���ڷ���eqȡ��
	 *
	 * @return rtdatetype_eq ���ڷ���eq
	 */
	public String getRtdatetype_eq() {
		return rtdatetype_eq;
	}
	/**
	 * ģ������likeȡ��
	 *
	 * @return rtname_like ģ������like
	 */
	public String getRtname_like() {
		return rtname_like;
	}
	/**
	 * ���ڷ���eq�趨
	 *
	 * @param rtdatetype_eq ���ڷ���eq
	 */
	public void setRtdatetype_eq(String rtdatetype_eq) {
		this.rtdatetype_eq = rtdatetype_eq;
	}
	/**
	 * ģ������like�趨
	 *
	 * @param rtname_like ģ������like
	 */
	public void setRtname_like(String rtname_like) {
		this.rtname_like = rtname_like;
	}
	/**
	 * ����ɾ��ȡ��
	 *
	 * @return delid ����ɾ��
	 */
	public String[] getDelid() {
		return delid;
	}
	/**
	 * ����ɾ���趨
	 *
	 * @param delid ����ɾ��
	 */
	public void setDelid(String[] delid) {
		this.delid = delid;
	}

	
}
