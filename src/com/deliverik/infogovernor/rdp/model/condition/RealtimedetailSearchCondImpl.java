/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.condition;

/**
  * ����: ��־��Ϣ��������ʵ��
  * ��������: ��־��Ϣ��������ʵ��
  * ������¼: 2014/05/06
  * �޸ļ�¼: 
  */
public class RealtimedetailSearchCondImpl implements
		RealtimedetailSearchCond {
	
	private Integer taskid;
	private String hostip;
	private Integer rtdid_gt;
	
	
	
	public Integer getRtdid_gt() {
		return rtdid_gt;
	}
	public void setRtdid_gt(Integer rtdid_gt) {
		this.rtdid_gt = rtdid_gt;
	}
	public Integer getTaskid() {
		return taskid;
	}
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	public String getHostip() {
		return hostip;
	}
	public void setHostip(String hostip) {
		this.hostip = hostip;
	}
	
	

}