/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
  * ����: MSGFILTER��������ʵ��
  * ��������: MSGFILTER��������ʵ��
  * ������¼: 2013/08/21
  * �޸ļ�¼: 
  */
public class MSGFILTERSearchCondImpl implements
		MSGFILTERSearchCond {
	
	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getDeviceip() {
		return deviceip;
	}

	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	protected Integer[] ids;

	/** deviceip */
	protected String deviceip;

	/** state */
	protected String state;

}