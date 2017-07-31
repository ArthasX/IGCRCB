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
import com.deliverik.infogovernor.wim.model.WorkLogInfo;

/**
  * ����: ������־��ʵ��
  * ��������: ������־��ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workLog")
public class WorkLogTB extends BaseEntity implements Serializable,
		Cloneable, WorkLogInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="WORKLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKLOG_TABLE_GENERATOR")
	protected Integer wlid;

	/** ����ʵ�������� */
	protected Integer wiid;

	/** ִ���� */
	protected String excutorId;
	
	/** ִ�������� */
	protected String excutorName;

	/** ���������� */
	protected String titleDate;

	/** ִ��ʱ�� ��Сʱ��*/
	protected String excuteTime;

	/** ʵ�ʴ������� */
	protected String actualDealwithDate;

	/** ִ��������� */
	protected String wlDescription;

	/** ���¼�������� */
	protected String crtDate;

	/** ��ť���� */
	protected String btnAction;
	
	/**
	 * ȡ�� ����
	 * 
	 * @return wlid
	*/
	public Integer getWlid() {
		return wlid;
	}
	

	/**
	 * ȡ�� ����ʵ��������
	 * 
	 * @return wiid
	*/
	public Integer getWiid() {
		return wiid;
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
	 * ȡ�� ����������
	 * 
	 * @return titleDate
	*/
	public String getTitleDate() {
		return titleDate;
	}
	

	/**
	 * ȡ�� ִ��ʱ�䣨Сʱ��
	 * 
	 * @return excuteTime
	*/
	public String getExcuteTime() {
		return excuteTime;
	}
	

	/**
	 * ȡ�� ʵ�ʴ�������
	 * 
	 * @return actualDealwithDate
	*/
	public String getActualDealwithDate() {
		return actualDealwithDate;
	}
	

	/**
	 * ȡ�� ִ���������
	 * 
	 * @return wlDescription
	*/
	public String getWlDescription() {
		return wlDescription;
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
	 * ȡ�� ��ť����
	 * 
	 * @return btnAction
	*/
	public String getBtnAction() {
		return btnAction;
	}


	/**
	 *  �����趨
	 * 
	 * @param wlid
	 */
	public void setWlid(Integer wlid) {
		this.wlid = wlid;
	}
	


	/**
	 *  ����ʵ���������趨
	 * 
	 * @param wiid
	 */
	public void setWiid(Integer wiid) {
		this.wiid = wiid;
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
	 *  �����������趨
	 * 
	 * @param titleDate
	 */
	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}
	


	/**
	 *  ִ��ʱ�䣨Сʱ���趨
	 * 
	 * @param excuteTime
	 */
	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
	}
	


	/**
	 *  ʵ�ʴ��������趨
	 * 
	 * @param actualDealwithDate
	 */
	public void setActualDealwithDate(String actualDealwithDate) {
		this.actualDealwithDate = actualDealwithDate;
	}
	


	/**
	 *  ִ����������趨
	 * 
	 * @param wlDescription
	 */
	public void setWlDescription(String wlDescription) {
		this.wlDescription = wlDescription;
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
	 *  ��ť�����趨
	 * 
	 * @param btnAction
	 */
	public void setBtnAction(String btnAction) {
		this.btnAction = btnAction;
	}
	/**
	 * ȡ�� ����
	 * 
	 * @return wlid
	*/
	public Integer getPK() {
		return wlid;
	}
	
}