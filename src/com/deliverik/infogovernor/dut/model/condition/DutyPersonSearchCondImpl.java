/**
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.model.condition;

import java.util.List;

/**
 * 
 * ֵ���˲�ѯʵ����
 *
 */
public class DutyPersonSearchCondImpl  implements DutyPersonSearchCond{
	
	/** ֵ��ƻ�ID */
	protected Integer dpid;
	
	/** ֵ����ID */
	protected String dperuserid;
	
	/** �װ�ҹ�� */
	protected String dptype;
	
	/** ֵ������ */
	protected String dpertime;
	
	protected List<Integer> DpidList;
	/**
	 * ֵ��ƻ�IDȡ��
	 * @return ֵ��ƻ�ID
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * ֵ��ƻ�ID�趨
	 *
	 * @param dpid ֵ��ƻ�ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	/**
	 * ֵ����IDȡ��
	 * @return ֵ����ID
	 */
	public String getDperuserid() {
		return dperuserid;
	}

	/**
	 * ֵ����ID�趨
	 *
	 * @param dperuserid ֵ����ID
	 */
	public void setDperuserid(String dperuserid) {
		this.dperuserid = dperuserid;
	}

	public String getDptype() {
		return dptype;
	}

	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	public String getDpertime() {
		return dpertime;
	}

	public void setDpertime(String dpertime) {
		this.dpertime = dpertime;
	}

	public List<Integer> getDpidList() {
		return DpidList;
	}

	public void setDpidList(List<Integer> dpidList) {
		DpidList = dpidList;
	}
	
}
