/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * �Ƽ������ۺϷ���(һ)DashBaord��ѯ��� VO
 * 
 * @author
 * 
 */
@SuppressWarnings("serial")
public class IGDBM1201VO extends BaseVO implements Serializable {

	/* ���񹤵�ֵ */
	protected String swoValue;

	/* �����걨ֵ */
	protected String ftdValue;

	/* �������� */
	protected String serValue;

	/* �¼� */
	protected String teValue;

	/* ���� */
	protected String tpValue;

	/* ��� */
	protected String chaValue;

	/* ���� */
	protected String reqValue;

	/* ָ�� */
	protected String assValue;
	
	/*����һ����Ҫxml�����ַ���*/
	protected String resultXML;

	/** �Ƽ������ۺϷ���(һ)DashBaord��ѯ��� */
	protected List<IG500Info> IG500InfoList;

	/**
	 * �Ƽ������ۺϷ���(һ)DashBaord��ѯ��� is returned.
	 * 
	 * @return IG500InfoList
	 */
	public List<IG500Info> getIG500InfoList() {
		return IG500InfoList;
	}

	/**
	 * �Ƽ������ۺϷ���(һ)DashBaord��ѯ��� is set.
	 * 
	 * @param IG500InfoList
	 *            ȫ��IP��ַ������Ϣ
	 */
	public void setIG500InfoList(List<IG500Info> iG500InfoList) {
		IG500InfoList = iG500InfoList;
	}

	public String getSwoValue() {
		return swoValue;
	}

	public void setSwoValue(String swoValue) {
		this.swoValue = swoValue;
	}

	public String getFtdValue() {
		return ftdValue;
	}

	public void setFtdValue(String ftdValue) {
		this.ftdValue = ftdValue;
	}

	public String getSerValue() {
		return serValue;
	}

	public void setSerValue(String serValue) {
		this.serValue = serValue;
	}

	public String getTeValue() {
		return teValue;
	}

	public void setTeValue(String teValue) {
		this.teValue = teValue;
	}

	public String getTpValue() {
		return tpValue;
	}

	public void setTpValue(String tpValue) {
		this.tpValue = tpValue;
	}

	public String getChaValue() {
		return chaValue;
	}

	public void setChaValue(String chaValue) {
		this.chaValue = chaValue;
	}

	public String getReqValue() {
		return reqValue;
	}

	public void setReqValue(String reqValue) {
		this.reqValue = reqValue;
	}

	public String getAssValue() {
		return assValue;
	}

	public void setAssValue(String assValue) {
		this.assValue = assValue;
	}

	public String getResultXML() {
		return resultXML;
	}

	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}
}
