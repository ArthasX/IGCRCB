package com.deliverik.infogovernor.dto;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.infogovernor.vo.IGCOM03041VO;

public class IGCOM04DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	private String userId;

	private UserPermission perm;
	 
	private IGCOM03041VO igcom03041VO;
	
	/** ��������flex������*/
	private String workCountXml;
	
	/** �����¼����� */
	protected int currentMouthEventCount;
	
	/** ������������ */
	protected int currentMouthProblemCount;
	
	/** ��������������͹������� */
	protected String allTypeWorkCount;
	
	/** xml�����ַ��� */
	protected String resultXML;
	
	/** ����ƻ�����xml */
	protected String changePlanCalender;
	
	/**
	 * ���ܣ���������flex������ȡ��
	 * @return workCountXml ��������
	 */
	public String getWorkCountXml() {
		return workCountXml;
	}
	/**
	 * ���ܣ���������flex�������趨
	 * @param workCountXml ��������flex������
	 */
	public void setWorkCountXml(String workCountXml) {
		this.workCountXml = workCountXml;
	}

	public UserPermission getPerm() {
		return perm;
	}

	public void setPerm(UserPermission perm) {
		this.perm = perm;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public IGCOM03041VO getIgcom03041VO() {
		return igcom03041VO;
	}

	public void setIgcom03041VO(IGCOM03041VO igcom03041VO) {
		this.igcom03041VO = igcom03041VO;
	}
	/**
	 * �����¼�����ȡ��
	 * @return currentMouthEventCount �����¼�����
	 */
	public int getCurrentMouthEventCount() {
		return currentMouthEventCount;
	}
	
	/**
	 * �����¼������趨
	 * @param currentMouthEventCount �����¼�����
	 */
	public void setCurrentMouthEventCount(int currentMouthEventCount) {
		this.currentMouthEventCount = currentMouthEventCount;
	}
	/**
	 * ������������ȡ��
	 * @return currentMouthProblemCount ������������
	 */
	public int getCurrentMouthProblemCount() {
		return currentMouthProblemCount;
	}
	/**
	 * �������������趨
	 * @param currentMouthProblemCount ������������
	 */
	public void setCurrentMouthProblemCount(int currentMouthProblemCount) {
		this.currentMouthProblemCount = currentMouthProblemCount;
	}
	/**
	 * ��������������͹�������ȡ��
	 * @return allTypeWorkCount ��������������͹�������
	 */
	public String getAllTypeWorkCount() {
		return allTypeWorkCount;
	}
	/**
	 * ��������������͹��������趨
	 * @param allTypeWorkCount ��������������͹�������
	 */
	public void setAllTypeWorkCount(String allTypeWorkCount) {
		this.allTypeWorkCount = allTypeWorkCount;
	}
	/**
	 * xml�����ַ���ȡ��
	 * @return resultXML xml�����ַ���
	 */
	public String getResultXML() {
		return resultXML;
	}
	/**
	 * xml�����ַ����趨
	 * @param resultXML xml�����ַ���
	 */
	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}
	/**
	 * ����ƻ�����xmlȡ��
	 * @return changePlanCalender ����ƻ�����xml
	 */
	public String getChangePlanCalender() {
		return changePlanCalender;
	}
	/**
	 * ����ƻ�����xml�趨
	 * @param changePlanCalender ����ƻ�����xml
	 */
	public void setChangePlanCalender(String changePlanCalender) {
		this.changePlanCalender = changePlanCalender;
	}

}
