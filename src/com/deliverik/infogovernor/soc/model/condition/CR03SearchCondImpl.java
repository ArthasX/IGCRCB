/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * ����: ����ԭ������������ϵ���������ʵ��
  * ��������: ����ԭ������������ϵ���������ʵ��
  * ������¼: 2013/04/08
  * �޸ļ�¼: 
  */
public class CR03SearchCondImpl implements CR03SearchCond {
	
	/** �豸��ʶ */
	protected String host;
	
	/** ���� */
	protected String tablename;
	
	/** �ɼ�ʱ�� */
	protected String collecttime;
	
	/** �����ʶ */
	protected String orderFlag;
	
	/** ��ʷ�汾��ʼʱ�� */
	protected String collecttimeFrom;
	
	/** ��ʷ�汾����ʱ�� */
	protected String collecttimeTo;

	/**��ѯesyscoding*/
	protected String esyscoding;
	
	/** ״̬*/
	protected String status;
	
	/** IP */
	protected String ip;
	
	/** server���� */
	protected String type;
	
	/** �ű��� */
	protected String servername;
	
	
	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * server����ȡ��
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * server�����趨
	 * @return
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * IPȡ��
	 * @return
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * IP�趨
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * �豸��ʶȡ��
	 * @return �豸��ʶ
	 */
	public String getHost() {
		return host;
	}

	/**
	 * �豸��ʶ�趨
	 * @param host �豸��ʶ
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * �����趨
	 * @param tablename ����
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	/**
	 * �ɼ�ʱ��ȡ��
	 *
	 * @return �ɼ�ʱ��
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * �ɼ�ʱ���趨
	 *
	 * @param collecttime �ɼ�ʱ��
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * �����ʶȡ��
	 * @return �����ʶ
	 */
	public String getOrderFlag() {
		return orderFlag;
	}

	/**
	 * �����ʶ�趨
	 * @param orderFlag �����ʶ
	 */
	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}
	
	/**
	 * ��ʷ�汾��ʼʱ��ȡ��
	 * @return ��ʷ�汾��ʼʱ��
	 */
	public String getCollecttimeFrom() {
		return collecttimeFrom;
	}

	/**
	 * ��ʷ�汾��ʼʱ���趨
	 * @param vdatestart ��ʷ�汾��ʼʱ��
	 */
	public void setCollecttimeFrom(String collecttimeFrom) {
		this.collecttimeFrom = collecttimeFrom;
	}

	/**
	 * ��ʷ�汾����ʱ��ȡ��
	 * @return ��ʷ�汾����ʱ��
	 */
	public String getCollecttimeTo() {
		return collecttimeTo;
	}

	/**
	 * ��ʷ�汾����ʱ���趨
	 * @param vdatestart ��ʷ�汾����ʱ��
	 */
	public void setCollecttimeTo(String collecttimeTo) {
		this.collecttimeTo = collecttimeTo;
	}

	/**
	 * ��ѯesyscodingȡ��
	 * @return esyscoding ��ѯesyscoding
	 */
	
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * ��ѯesyscoding�趨
	 * @param esyscoding ��ѯesyscoding
	 */
	
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * ״̬�趨
	 * @param status ״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}