/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;

/**
  * ����: ����ʵ����ʵ��
  * ��������: ����ʵ����ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workInstance")
public class WorkInstanceTB extends BaseEntity implements Serializable,
		Cloneable, WorkInstanceInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="WORKINSTANCE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKINSTANCE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKINSTANCE_TABLE_GENERATOR")
	protected Integer wiid;

	/** ������������� */
	protected Integer wdid;
	
	/** ���������� */
	protected String wdname;

	/** ����ʵ������ */
	protected String winame;

	/** ����״̬��δִ�У�ִ���У���������ֹ���� */
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
	 * ȡ�� ����״̬��δִ�У�ִ���У���������ֹ����
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
	 *  ����״̬��δִ�У�ִ���У���������ֹ�����趨
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
	 * ���¼��������ȡ��
	 * @return ���¼��������
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * ���¼���������趨
	 * @param ���¼��������
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}
	
}