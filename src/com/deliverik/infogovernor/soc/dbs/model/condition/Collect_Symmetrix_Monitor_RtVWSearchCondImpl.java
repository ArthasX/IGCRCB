/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.model.condition;

/**
 * 
 * @Description:�洢ʵʱ��Ϣ��ͼCond��
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_Monitor_RtVWSearchCondImpl implements
		Collect_Symmetrix_Monitor_RtVWSearchCond {
	/**
	 *���к�
	 */
	protected String symmid;
	
	/**
	 * ��ѯʱ�俪ʼ
	 */
	protected String date_from;
	
	/**
	 * ��ѯʱ�����
	 */
	protected String date_to;
	
	/**
	 * �洢����
	 */
	protected String serverType;

	public String getSymmid() {
		return symmid;
	}

	public void setSymmid(String symmid) {
		this.symmid = symmid;
	}
	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

}
