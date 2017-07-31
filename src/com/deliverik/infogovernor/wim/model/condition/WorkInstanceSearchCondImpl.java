/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * ����: ����ʵ����������ʵ��
  * ��������: ����ʵ����������ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkInstanceSearchCondImpl implements
		WorkInstanceSearchCond {

	protected Integer wiid;

	/** ������������� */
	protected Integer wdid;
	
	/** ���������� */
	protected String wdname;

	/** ����ʵ������ */
	protected String winame;

	/** ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ���� */
	protected String wistatus;
	
	/** �����ˣ�userid�� */
	protected String initiatorId;

	/** ����/Ƶ�� */
	protected String cycle;

	/** ���������� */
	protected String description;

	/** ��ʼ���� */
	protected String beginDate;

	/** ������ */
	protected String leaderId;
	
	/** ���������� */
	protected String leaderName;
	
	/** ִ���� */
	protected String excutorId;

	/** ִ�������� */
	protected String excutorName;

	/** �������ͣ�1���Զ�����2���ֶ����� */
	protected String wiLunchType;

	/** ִ������ʱ�䣨Сʱ�� */
	protected String excuteTime;
	
	/** ִ��������� */
	protected String wiDescription;

	/** ����ȷ������ */
	protected String confirmDate;

	/** ���������� */
	protected String titleDate;

	/** ���¼�������� */
	protected String crtDate;
	
	/** ʱ��� */
	protected String fingerPrint;
	/**����ʱ��*/
	protected String workDate ;
	
	/**����*/
	protected String orgsyscoding ;
	
	/**��Ա*/
	protected String userid;

	/**��ʼ���ڴ�*/
	protected String begindate_from;
	
	/**��ʼ���ڵ�*/
	protected String begindate_to;
	
	/**
	 * @return the ����ʱ��
	 */
	public String getWorkDate() {
		return workDate;
	}
	

	/**
	 * @param ����ʱ�� the workDate to set
	 */
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	

	/**
	 * @return the ����
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}
	

	/**
	 * @param ���� the orgsyscoding to set
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}
	

	/**
	 * @return the ��Ա
	 */
	public String getUserid() {
		return userid;
	}
	

	/**
	 * @param ��Ա the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * ȡ�� ����
	 * 
	 * @return wiid
	*/
	public Integer getPK() {
		return wiid;
	}

	/**
	 * ȡ�� ����
	 * 
	 * @return wiid
	*/
	public Integer getWiid() {
		return wiid;
	}
	

	/**
	 * ȡ�� �������������
	 * 
	 * @return wdid
	*/
	public Integer getWdid() {
		return wdid;
	}
	

	/**
	 * ȡ�� ����������
	 * 
	 * @return wdname
	*/
	public String getWdname() {
		return wdname;
	}
	

	/**
	 * ȡ�� ����ʵ������
	 * 
	 * @return winame
	*/
	public String getWiname() {
		return winame;
	}
	

	/**
	 * ȡ�� ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����
	 * 
	 * @return wistatus
	*/
	public String getWistatus() {
		return wistatus;
	}
	

	/**
	 * ȡ�� �����ˣ�userid��
	 * 
	 * @return initiatorId
	*/
	public String getInitiatorId() {
		return initiatorId;
	}
	

	/**
	 * ȡ�� ����Ƶ��
	 * 
	 * @return cycle
	*/
	public String getCycle() {
		return cycle;
	}
	

	/**
	 * ȡ�� ����������
	 * 
	 * @return description
	*/
	public String getDescription() {
		return description;
	}
	

	/**
	 * ȡ�� ��ʼ����
	 * 
	 * @return beginDate
	*/
	public String getBeginDate() {
		return beginDate;
	}
	

	/**
	 * ȡ�� ������
	 * 
	 * @return leaderId
	*/
	public String getLeaderId() {
		return leaderId;
	}
	

	/**
	 * ȡ�� ����������
	 * 
	 * @return leaderName
	*/
	public String getLeaderName() {
		return leaderName;
	}
	

	/**
	 * ȡ�� ִ����
	 * 
	 * @return excutorId
	*/
	public String getExcutorId() {
		return excutorId;
	}
	

	/**
	 * ȡ�� ִ��������
	 * 
	 * @return excutorName
	*/
	public String getExcutorName() {
		return excutorName;
	}
	

	/**
	 * ȡ�� �������ͣ�1���Զ�����2���ֶ�����
	 * 
	 * @return wiLunchType
	*/
	public String getWiLunchType() {
		return wiLunchType;
	}
	

	/**
	 * ȡ�� ִ������ʱ�䣨Сʱ��
	 * 
	 * @return excuteTime
	*/
	public String getExcuteTime() {
		return excuteTime;
	}
	

	/**
	 * ȡ�� ִ���������
	 * 
	 * @return wiDescription
	*/
	public String getWiDescription() {
		return wiDescription;
	}
	

	/**
	 * ȡ�� ����ȷ������
	 * 
	 * @return confirmDate
	*/
	public String getConfirmDate() {
		return confirmDate;
	}
	

	/**
	 * ȡ�� ����������
	 * 
	 * @return titleDate
	*/
	public String getTitleDate() {
		return titleDate;
	}
	

	/**
	 * ȡ�� ���¼��������
	 * 
	 * @return crtDate
	*/
	public String getCrtDate() {
		return crtDate;
	}
	

	/**
	 * ȡ�� ʱ���
	 * 
	 * @return fingerPrint
	*/
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 *  �����趨
	 * 
	 * @param wiid
	 */
	public void setWiid(Integer wiid) {
		this.wiid = wiid;
	}
	

	/**
	 *  ��������������趨
	 * 
	 * @param wdid
	 */
	public void setWdid(Integer wdid) {
		this.wdid = wdid;
	}
	

	/**
	 *  �����������趨
	 * 
	 * @param wdname
	 */
	public void setWdname(String wdname) {
		this.wdname = wdname;
	}
	

	/**
	 *  ����ʵ�������趨
	 * 
	 * @param winame
	 */
	public void setWiname(String winame) {
		this.winame = winame;
	}
	

	/**
	 *  ����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ�����趨
	 * 
	 * @param wistatus
	 */
	public void setWistatus(String wistatus) {
		this.wistatus = wistatus;
	}
	

	/**
	 *  �����ˣ�userid���趨
	 * 
	 * @param initiatorId
	 */
	public void setInitiatorId(String initiatorId) {
		this.initiatorId = initiatorId;
	}
	

	/**
	 *  ����Ƶ���趨
	 * 
	 * @param cycle
	 */
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	

	/**
	 *  �����������趨
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

	/**
	 *  ��ʼ�����趨
	 * 
	 * @param beginDate
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	

	/**
	 *  �������趨
	 * 
	 * @param leaderId
	 */
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	

	/**
	 *  �����������趨
	 * 
	 * @param leaderName
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	

	/**
	 *  ִ�����趨
	 * 
	 * @param excutorId
	 */
	public void setExcutorId(String excutorId) {
		this.excutorId = excutorId;
	}
	

	/**
	 *  ִ���������趨
	 * 
	 * @param excutorName
	 */
	public void setExcutorName(String excutorName) {
		this.excutorName = excutorName;
	}
	

	/**
	 *  �������ͣ�1���Զ�����2���ֶ������趨
	 * 
	 * @param wiLunchType
	 */
	public void setWiLunchType(String wiLunchType) {
		this.wiLunchType = wiLunchType;
	}
	

	/**
	 *  ִ������ʱ�䣨Сʱ���趨
	 * 
	 * @param excuteTime
	 */
	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
	}
	

	/**
	 *  ִ����������趨
	 * 
	 * @param wiDescription
	 */
	public void setWiDescription(String wiDescription) {
		this.wiDescription = wiDescription;
	}
	

	/**
	 *  ����ȷ�������趨
	 * 
	 * @param confirmDate
	 */
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}
	

	/**
	 *  �����������趨
	 * 
	 * @param titleDate
	 */
	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}
	

	/**
	 *  ���¼���������趨
	 * 
	 * @param crtDate
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}
	

	/**
	 *  ʱ����趨
	 * 
	 * @param fingerPrint
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getBegindate_from() {
		return begindate_from;
	}

	public void setBegindate_from(String begindate_from) {
		this.begindate_from = begindate_from;
	}

	public String getBegindate_to() {
		return begindate_to;
	}

	public void setBegindate_to(String begindate_to) {
		this.begindate_to = begindate_to;
	}
}