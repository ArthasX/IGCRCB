/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.condition;

import java.io.Serializable;

/**
  * ����: �����Թ����������������ʵ��
  * ��������: �����Թ����������������ʵ��
  * ������¼: 2014/09/03
  * �޸ļ�¼: 
  */
public class CheckInfoRiskSearchCondImpl implements
		CheckInfoRiskSearchCond {
	protected Integer cieid;

	/** ������id */
	protected Integer csid;

	/** �����id */
	protected Integer rcid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCieid() {
		return cieid;
	}

	/**
	 * �����趨
	 *
	 * @param cieid ����
	 */
	public void setCieid(Integer cieid) {
		this.cieid = cieid;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * ������id�趨
	 *
	 * @param csid ������id
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * �����idȡ��
	 *
	 * @return �����id
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * �����id�趨
	 *
	 * @param rcid �����id
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return cieid;
	}
}