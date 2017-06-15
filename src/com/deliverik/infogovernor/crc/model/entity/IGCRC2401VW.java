/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2401VWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ��ʵ��
 * </p>
 *
 * @version 1.0
 */
@Entity
public class IGCRC2401VW implements IGCRC2401VWInfo{
	@Id
	protected String mainId;
	
	/** ��������*/
	protected Integer prid ;
	//id
	protected String userId;
	//����
	protected String userName;
	//��ʼʱ��
	protected String startTime;
	//�����¼�
	protected String endTime;
	//����
	protected String grade;
	
	
	//ȷ��ʱ��
	protected String confirmtime;
	
	public IGCRC2401VW() {
		super();
	}
	public IGCRC2401VW(String userId, String userName, String startTime,
			String endTime, String grade,String confirmtime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.grade = grade;
		this.confirmtime = confirmtime;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getConfirmtime() {
		return confirmtime;
	}
	public void setConfirmtime(String confirmtime) {
		this.confirmtime = confirmtime;
	}
	/**
	 * userIdȡ��
	 * @return userId  userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * userId�趨
	 * @param userId  userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the mainId
	 */
	public String getMainId() {
		return mainId;
	}
	/**
	 * @param mainId the mainId to set
	 */
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	/**
	 * ����������ȡ
	 * @return the prid
	 */
	public Integer getPrid() {
		return prid;
	}
	/**
	 * ���������趨
	 * @param prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}
