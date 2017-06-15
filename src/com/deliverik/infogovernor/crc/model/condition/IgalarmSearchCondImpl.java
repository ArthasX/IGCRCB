/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.condition;

import com.deliverik.infogovernor.crc.form.IGCRC0203Form;

/**
  * ����: ���ɸ澯���������ʵ��
  * ��������: ���ɸ澯���������ʵ��
  * ������¼: 2014/06/21
  * �޸ļ�¼: 
  */
public class IgalarmSearchCondImpl implements
		IgalarmSearchCond {
	
	public IgalarmSearchCondImpl(){
		super();
	}
	
	public IgalarmSearchCondImpl(IGCRC0203Form form){
		startDate = form.getStartDate() == null ? null : form.getStartDate();
		endDate = form.getEndDate() == null ? null : form.getEndDate();
		appname = form.getAppname() == null ? null : form.getAppname();
		summary = form.getSummary() == null ? null : form.getSummary();
		status = form.getStatus() == null ? null : form.getStatus();
		lasttime = form.getLasttime()==null?null : form.getLasttime();
		isShow = form.getIsShow()==null?null : form.getIsShow();
		pedeventid = form.getPedeventid()==null?null : form.getPedeventid();
	}

	private String serial;//�ȶԼ��ɸ澯�����
	
	/**IPd��ַ*/
	private String ipaddr;
	
	/** 
	 * �Ƿ���Ӧ����������״̬�ı�ʶ	2016.09.02 by wangxing
	 *  0:����״̬
	 *  1:����״̬
	 **/
	protected String shieldflag;
	
	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getShieldflag() {
		return shieldflag;
	}

	public void setShieldflag(String shieldflag) {
		this.shieldflag = shieldflag;
	}

	/**  ��ʼʱ�� */
	private String startDate;
	
	/** ����ʱ�� */
	private String endDate;
	
	/** �������� */
	private String appname;
	
	/** ʱ������ */
	private String summary;
	
	/** �澯id�� */
	private String[] alarmIds;
	
	/** ״̬(0:�澯;1:�ָ�;2:�ر�) */
	private String status;
	
	/** ����/�ָ�ʱ�� */
	protected String lasttime;
	
	/** �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)  */	
	protected String isShow;
	
	/** �¼������ */
	protected String pedeventid;
	
	/** 2016/10/14�޸�   ���ܣ��������������߽���(1.�����¼�/�ָ��¼� 2.ip��ַ 3.��������)    gongyunpeng */
	
	/** ������������״̬�� */
	private String appnamestatus;
	
	/** ip��ַ����״̬�� */
	private String ipaddrstatus;
	
	/** ����ʱ������״̬�� */
	private String lasttimestatus;
	
	/** �ָ�ʱ������״̬�� */
	private String recoverytimestatus;
	
	
	
	/**
	 * �ȶԼ��ɸ澯����Ż�ȡ
	 * @return �ȶԼ��ɸ澯�����
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * �ȶԼ��ɸ澯���������
	 * @param serial �ȶԼ��ɸ澯�����
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String[] getAlarmIds() {
		return alarmIds;
	}

	public void setAlarmIds(String[] alarmIds) {
		this.alarmIds = alarmIds;
	}

	/**
	 * ״̬(0:�澯;1:�ָ�;2:�ر�)ȡ��
	 * @return status  ״̬(0:�澯;1:�ָ�;2:�ر�)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ״̬(0:�澯;1:�ָ�;2:�ر�)�趨
	 * @param status  ״̬(0:�澯;1:�ָ�;2:�ر�)
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ����/�ָ�ʱ��ȡ��
	 *
	 * @return ����/�ָ�ʱ��
	 */
	public String getLasttime() {
		return lasttime;
	}

	/**
	 * ����/�ָ�ʱ���趨
	 *
	 * @param lasttime ����/�ָ�ʱ��
	 */
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
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
	
	/**
	 * �¼������ȡ��
	 *
	 * @return �¼������
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * �¼�������趨
	 *
	 * @param pedeventid �¼������
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}
	

	/**
	 * ������������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ������������״̬��
	 */
	public String getAppnamestatus() {
		return appnamestatus;
	}

	/**
	 * ������������״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param ������������״̬��
	 */
	public void setAppnamestatus(String appnamestatus) {
		this.appnamestatus = appnamestatus;
	}

	/**
	 * ip��ַ����״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ip��ַ����״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getIpaddrstatus() {
		return ipaddrstatus;
	}

	/**
	 * ip��ַ����״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param  ip��ַ����״̬��(1Ϊ���� 2Ϊ����)
	 */
	public void setIpaddrstatus(String ipaddrstatus) {
		this.ipaddrstatus = ipaddrstatus;
	}

	/**
	 * ����ʱ������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ����ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getLasttimestatus() {
		return lasttimestatus;
	}

	/**
	 * ����ʱ������״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param ����ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public void setLasttimestatus(String lasttimestatus) {
		this.lasttimestatus = lasttimestatus;
	}

	/**
	 * �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getRecoverytimestatus() {
		return recoverytimestatus;
	}

	/**
	 * �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public void setRecoverytimestatus(String recoverytimestatus) {
		this.recoverytimestatus = recoverytimestatus;
	}

	
	
	
	
	
}