package com.deliverik.infogovernor.sym.model.condition;

public class CustomReportSearchCondImpl implements CustomReportSearchCond {

	

	/**
	 *�û���ID
	 */
	protected String userid;

	/**
	 *�û���IDȡ��
	 * 
	 * @return �û���ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 *�û���ID�趨
	 * 
	 * @param userid�û���ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 *����ID
	 */
	protected Integer rfdid;

	/**
	 *����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 *����ID�趨
	 * 
	 * @param rfdid����ID
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 *������
	 */
	protected Integer ordernum;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public Integer getOrdernum() {
		return ordernum;
	}

	/**
	 *�������趨
	 * 
	 * @param ordernum������
	 */
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

}
