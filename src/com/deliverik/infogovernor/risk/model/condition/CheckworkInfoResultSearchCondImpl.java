/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.condition;

import java.io.Serializable;

/**
  * ����: ��鹤���������������������ʵ��
  * ��������: ��鹤���������������������ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public class CheckworkInfoResultSearchCondImpl implements
		CheckworkInfoResultSearchCond {

	
	protected Integer cwirid;

	/** �������id */
	protected Integer cwrid;

	/** ��鹤��id */
	protected Integer rcrid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCwirid() {
		return cwirid;
	}

	/**
	 * �����趨
	 *
	 * @param cwirid ����
	 */
	public void setCwirid(Integer cwirid) {
		this.cwirid = cwirid;
	}

	/**
	 * �������idȡ��
	 *
	 * @return �������id
	 */
	public Integer getCwrid() {
		return cwrid;
	}

	/**
	 * �������id�趨
	 *
	 * @param cwrid �������id
	 */
	public void setCwrid(Integer cwrid) {
		this.cwrid = cwrid;
	}

	/**
	 * ��鹤��idȡ��
	 *
	 * @return ��鹤��id
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * ��鹤��id�趨
	 *
	 * @param rcrid ��鹤��id
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return cwirid;
	}

	
}