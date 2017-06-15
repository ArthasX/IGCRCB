/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �澯��Ϣ��ѯForm
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */


@SuppressWarnings("serial")
public class IGCRC0204Form extends BaseForm{
	
	/** ��ʼʱ�� */
	private String startDate;
	
	/** ����ʱ�� */
	private String endDate;
	
	/** �������� */
	private String appname;
	
	/** �¼����� */
	private String summary;
	
	/** ������ */
	private String fingerPrint;
	
	/** ������ϵ��  */	
	protected String faultContact;
	
	/** ��ѡ�� �澯Id*/
	private String[] alarmId;

	/** ״̬(0:δ����;1:�Ѵ���)  */	
	private String status;
	
	/** ��� */
	private String serial;
	
	/** �¼������ */
	private String pedeventid;
	
	/** IP��ַ */
	private String ipaddr;
	
	/** ����ʱ�� */
	private String lasttime;
	
	/** �ָ�ʱ��  */	
	private String recoveryTime; 
	
	/** ����  */	
	private String description;
	
	/** �Ƿ����ɹ���  */	
	private String isCreateOrder;
	
	/** ����  */	
	private Integer pk;

	/** ����id  */	
	private Integer prcorid;
	
	/** �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)  */	
	protected String isShow;
	
    /**
     * ��ʼʱ���ȡ
     * @return ��ʼʱ��
     */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * ��ʼʱ������
	 * @param startDate ��ʼʱ��
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
     * ����ʱ���ȡ
     * @return ��ʼʱ��
     */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * ����ʱ������
	 * @param endDate ����ʱ��
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
     * �������ƻ�ȡ
     * @return ��������
     */
	public String getAppname() {
		return appname;
	}

	/**
	 * ������������
	 * @param appname ��������
	 */
	public void setAppname(String appname) {
		this.appname = appname;
	}

	/**
     * ʱ�����ݻ�ȡ
     * @return ʱ������
     */
	public String getSummary() {
		return summary;
	}

	/**
	 * ʱ����������
	 * @param summary ʱ������
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * ��ȡ�澯ID
	 * @return �澯��Ϣ�б�
	 */
	public String[] getAlarmId() {
		return alarmId;
	}

	/**
	 * ���ø澯Id
	 */
	public void setAlarmId(String[] alarmId) {
		this.alarmId = alarmId;
	}

	/**
	 * ״̬(0:δ����;1:�Ѵ���)ȡ��
	 * @return status  ״̬(0:δ����;1:�Ѵ���)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ״̬(0:δ����;1:�Ѵ���)�趨
	 * @param status  ״̬(0:δ����;1:�Ѵ���)
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * �ָ�ʱ��ȡ��
	 * @return recoveryTime  �ָ�ʱ��
	 */
	public String getRecoveryTime() {
		return recoveryTime;
	}

	/**
	 * �ָ�ʱ���趨
	 * @param recoveryTime  �ָ�ʱ��
	 */
	public void setRecoveryTime(String recoveryTime) {
		this.recoveryTime = recoveryTime;
	}

	/**
	 * ����ȡ��
	 * @return description  ����
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * �����趨
	 * @param description  ����
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * �Ƿ����ɹ���ȡ��
	 * @return isCreateOrder  �Ƿ����ɹ���
	 */
	public String getIsCreateOrder() {
		return isCreateOrder;
	}

	/**
	 * �Ƿ����ɹ����趨
	 * @param isCreateOrder  �Ƿ����ɹ���
	 */
	public void setIsCreateOrder(String isCreateOrder) {
		this.isCreateOrder = isCreateOrder;
	}

	/**
	 * ����ȡ��
	 * @return pk  ����
	 */
	public Integer getPk() {
		return pk;
	}

	/**
	 * �����趨
	 * @param pk  ����
	 */
	public void setPk(Integer pk) {
		this.pk = pk;
	}

	/**
	 * �¼������ȡ��
	 * @return pedeventid  �¼������
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * �¼�������趨
	 * @param pedeventid  �¼������
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}

	/**
	 * ���ȡ��
	 * @return serial  ���
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * ����趨
	 * @param serial  ���
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * IP��ַȡ��
	 * @return ipaddr  IP��ַ
	 */
	public String getIpaddr() {
		return ipaddr;
	}

	/**
	 * IP��ַ�趨
	 * @param ipaddr  IP��ַ
	 */
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	/**
	 * ������ȡ��
	 * @return fingerPrint  ������
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * �������趨
	 * @param fingerPrint  ������
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return lasttime  ����ʱ��
	 */
	public String getLasttime() {
		return lasttime;
	}

	/**
	 * ����ʱ���趨
	 * @param lasttime  ����ʱ��
	 */
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	/**
	 * ����idȡ��
	 * @return prcorid  ����id
	 */
	public Integer getPrcorid() {
		return prcorid;
	}

	/**
	 * ����id�趨
	 * @param prcorid  ����id
	 */
	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	/**
	 * ������ϵ��ȡ��
	 * @return faultContact  ������ϵ��
	 */
	public String getFaultContact() {
		return faultContact;
	}

	/**
	 * ������ϵ���趨
	 * @param faultContact  ������ϵ��
	 */
	public void setFaultContact(String faultContact) {
		this.faultContact = faultContact;
	}
	
	/**
	 * �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)ȡ��
	 * @return isShow  �Ƿ���ʾ��ʶ
	 */
	public String getIsShow() {
		return isShow;
	}

	/**
	 * �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)�趨
	 * @param isShow  �Ƿ���ʾ��ʶ
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
}
