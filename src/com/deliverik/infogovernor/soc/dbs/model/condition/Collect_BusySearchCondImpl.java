/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.model.condition;

/**
 * 
 * @Description:�洢������ϢCond��
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_BusySearchCondImpl implements Collect_BusySearchCond {
	
	/**
	 * ��ѯʱ�俪ʼ
	 */
	protected String date_from;
	
	/**
	 * ��ѯʱ�����
	 */
	protected String date_to;
	
	/**
	 * ��ѯdataid
	 */
	private String dataid;
	
	/**
	 * ��ѯflag Max Ϊ���AVGΪƽ��
	 */
	private String flag;
	
	private String symm_model;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDataid() {
		return dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
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

	public String getSymm_model() {
		return symm_model;
	}

	public void setSymm_model(String symm_model) {
		this.symm_model = symm_model;
	}
}
