/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: soc0154ʵ������
  * ��������: soc0154ʵ������
  * ������¼: 2013/12/29
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class SOC0154PK extends BasePK implements Serializable {

	/** myid */
	protected String myid;

	/** fromid */
	protected String fromid;

	/** isellipsis */
	protected String isellipsis;

	/**
	 * ���캯��
	 */
	public SOC0154PK() {

	}

	/**
	 * ���캯��
	 */
	public SOC0154PK(String myid, String fromid, String isellipsis) {
		super();
		this.myid = myid;
		this.fromid = fromid;
		this.isellipsis = isellipsis;
	}

	/**
	 * myidȡ��
	 *
	 * @return myid
	 */
	public String getMyid() {
		return myid;
	}

	/**
	 * myid�趨
	 *
	 * @param myid myid
	 */
	public void setMyid(String myid) {
		this.myid = myid;
	}

	/**
	 * fromidȡ��
	 *
	 * @return fromid
	 */
	public String getFromid() {
		return fromid;
	}

	/**
	 * fromid�趨
	 *
	 * @param fromid fromid
	 */
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	/**
	 * isellipsisȡ��
	 *
	 * @return isellipsis
	 */
	public String getIsellipsis() {
		return isellipsis;
	}

	/**
	 * isellipsis�趨
	 *
	 * @param isellipsis isellipsis
	 */
	public void setIsellipsis(String isellipsis) {
		this.isellipsis = isellipsis;
	}

}