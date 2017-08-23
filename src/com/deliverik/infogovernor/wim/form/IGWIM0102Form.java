/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * @Description �������ѯ/ɾ��Form
 *
 * @date 2017��6��14��
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class IGWIM0102Form extends BaseForm{
	
	/** ���� */
	protected Integer wdid;
	
	/** ���������� */
	protected String wdname;

	/** �����ˣ�userid�� */
	protected String initiatorId;
	
	/** ���������� */
	protected String initiatorName;

	/** ����/Ƶ�� */
	protected String cycle;

	/** ����ʱ��  */
	protected String wdcreateTime;

	/** ���������� */
	protected String description;

	/** ��ʼ���� */
	protected String beginDate;
	
	/** ��ʼ���ڴ� */
	protected String beginDateStart;
	
	/** ��ʼ���ڵ� */
	protected String beginDateOver;

	/** �������� */
	protected String endDate;

	/** Ԥ��������� */
	protected String estimateFinishDate;

	/** ʵ��������� */
	protected String actualFinishDate;

	/** ��ʱ����ʱ�䣨�죩 */
	protected String overtimeTipsTime;

	/** �����ˣ�userid�� */
	protected String leaderId;
	
	/** ����������  */
	protected String leaderName;

	/** ִ���ˣ�userid,userid,userid,...�� */
	protected String excutorId;
	
	/** ִ�������� */
	protected String excutorName;

	/** ����״̬��0��δ���ã�1�������ã� */
	protected String wdstatus;

	/** �� */
	protected String wdmonth;

	/** ÿ�����һ�췢��Y���ǣ�N���� */
	protected String monthLastDay;

	/** �� */
	protected String wdweek;

	/** ʱ */
	protected String wdhour;

	/** �� */
	protected String wdminute;

	/** �Ƿ����֪ͨ��Y,�ǣ�N���� */
	protected String isMsgNotice;

	/** ��ע */
	protected String remarks;

	/** ����¼�������� */
	protected String crtDate;
	
	/** Ԥ���ֶ� */
	protected String reservedFiled;
	
	/** 0Ϊ���� 1Ϊ��� */
	protected String mode = "0";
	
	/** ɾ����������� */
	protected String[] deleteEiid;

	 /** ���� */
    protected FormFile fileMap = null;
    
    /**������Ϣ*/
    protected String result;
    
    /** �Ƿ�����ͨ�û���1���ǣ�0���� */
    protected String isNormalUser;
    
	/**
	 * wdidȡ��
	 *
	 * @return wdid
	 */
	public Integer getWdid() {
		return wdid;
	}

	/**
	 * wdid�趨
	 *
	 * @param wdid wdid
	 */
	public void setWdid(Integer wdid) {
		this.wdid = wdid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getWdname() {
		return wdname;
	}

	/**
	 * �����������趨
	 *
	 * @param ����������
	 */
	public void setWdname(String wdname) {
		this.wdname = wdname;
	}

	/**
	 * �����ˣ�userid��ȡ��
	 *
	 * @return �����ˣ�userid��
	 */
	public String getInitiatorId() {
		return initiatorId;
	}

	/**
	 * �����ˣ�userid���趨
	 *
	 * @param �����ˣ�userid��
	 */
	public void setInitiatorId(String initiatorId) {
		this.initiatorId = initiatorId;
	}
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getInitiatorName() {
		return initiatorName;
	}

	/**
	 * �����������趨
	 * @param ����������
	 */
	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	/**
	 * ����/Ƶ��ȡ��
	 *
	 * @return ����/Ƶ��
	 */
	public String getCycle() {
		return cycle;
	}

	/**
	 * ����/Ƶ���趨
	 *
	 * @param ����/Ƶ��
	 */
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getWdcreateTime() {
		return wdcreateTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param ����ʱ��
	 */
	public void setWdcreateTime(String wdcreateTime) {
		this.wdcreateTime = wdcreateTime;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * �����������趨
	 *
	 * @param ����������
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ��ʼ����ȡ��
	 *
	 * @return ��ʼ����
	 */
	public String getBeginDate() {
		return beginDate;
	}

	/**
	 * ��ʼ�����趨
	 *
	 * @param ��ʼ����
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	
	/**
	 * ��ʼ���ڴ�ȡ��
	 * @return ��ʼ���ڴ�
	 */
	public String getBeginDateStart() {
		return beginDateStart;
	}

	/**
	 * ��ʼ���ڴ��趨
	 * @param ��ʼ���ڴ�
	 */
	public void setBeginDateStart(String beginDateStart) {
		this.beginDateStart = beginDateStart;
	}

	/**
	 * ��ʼ���ڵ�ȡ��
	 * @return ��ʼ���ڵ�
	 */
	public String getBeginDateOver() {
		return beginDateOver;
	}

	/**
	 * ��ʼ���ڵ��趨
	 * @param ��ʼ���ڵ�
	 */
	public void setBeginDateOver(String beginDateOver) {
		this.beginDateOver = beginDateOver;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * ���������趨
	 *
	 * @param ��������
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Ԥ���������ȡ��
	 *
	 * @return Ԥ���������
	 */
	public String getEstimateFinishDate() {
		return estimateFinishDate;
	}

	/**
	 * Ԥ����������趨
	 *
	 * @param Ԥ���������
	 */
	public void setEstimateFinishDate(String estimateFinishDate) {
		this.estimateFinishDate = estimateFinishDate;
	}

	/**
	 * ʵ���������ȡ��
	 *
	 * @return ʵ���������
	 */
	public String getActualFinishDate() {
		return actualFinishDate;
	}

	/**
	 * ʵ����������趨
	 *
	 * @param ʵ���������
	 */
	public void setActualFinishDate(String actualFinishDate) {
		this.actualFinishDate = actualFinishDate;
	}

	/**
	 * ��ʱ����ʱ�䣨�죩ȡ��
	 *
	 * @return ��ʱ����ʱ�䣨�죩
	 */
	public String getOvertimeTipsTime() {
		return overtimeTipsTime;
	}

	/**
	 * ��ʱ����ʱ�䣨�죩�趨
	 *
	 * @param ��ʱ����ʱ�䣨�죩
	 */
	public void setOvertimeTipsTime(String overtimeTipsTime) {
		this.overtimeTipsTime = overtimeTipsTime;
	}
	
	/**
	 * �����ˣ�userid��ȡ��
	 * 
	 * @return �����ˣ�userid��
	 */
	public String getLeaderId() {
		return leaderId;
	}

	/**
	 * �����ˣ�userid���趨
	 * @param �����ˣ�userid��
	 */
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	
	/**
	 * ���������� ȡ��
	 * @return ���������� 
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * ���������� �趨
	 * @param ���������� 
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	/**
	 * ִ���ˣ�userid,userid,userid,...��ȡ��
	 *
	 * @return ִ���ˣ�userid,userid,userid,...��
	 */
	public String getExcutorId() {
		return excutorId;
	}

	/**
	 * ִ���ˣ�userid,userid,userid,...���趨
	 *
	 * @param ִ���ˣ�userid,userid,userid,...��
	 */
	public void setExcutorId(String excutorId) {
		this.excutorId = excutorId;
	}
	
	/**
	 * ִ��������ȡ��
	 * @return ִ��������
	 */
	public String getExcutorName() {
		return excutorName;
	}

	/**
	 * ִ���������趨
	 * @param ִ��������
	 */
	public void setExcutorName(String excutorName) {
		this.excutorName = excutorName;
	}

	/**
	 * ����״̬��0��δ���ã�1�������ã�ȡ��
	 *
	 * @return ����״̬��0��δ���ã�1�������ã�
	 */
	public String getWdstatus() {
		return wdstatus;
	}

	/**
	 * ����״̬��0��δ���ã�1�������ã��趨
	 *
	 * @param ����״̬��0��δ���ã�1�������ã�
	 */
	public void setWdstatus(String wdstatus) {
		this.wdstatus = wdstatus;
	}
	
	/**
	 * ��ȡ��
	 * @return the ��
	 */
	public String getWdmonth() {
		return wdmonth;
	}

	/**
	 * ���趨
	 * @param ��
	 */
	public void setWdmonth(String wdmonth) {
		this.wdmonth = wdmonth;
	}

	/**
	 * ÿ�����һ�췢��Y���ǣ�N����ȡ��
	 *
	 * @return ÿ�����һ�췢��Y���ǣ�N����
	 */
	public String getMonthLastDay() {
		return monthLastDay;
	}

	/**
	 * ÿ�����һ�췢��Y���ǣ�N�����趨
	 *
	 * @param ÿ�����һ�췢��Y���ǣ�N����
	 */
	public void setMonthLastDay(String monthLastDay) {
		this.monthLastDay = monthLastDay;
	}

	/**
	 * @return the wdweek
	 */
	public String getWdweek() {
		return wdweek;
	}

	/**
	 * @param wdweek the wdweek to set
	 */
	public void setWdweek(String wdweek) {
		this.wdweek = wdweek;
	}

	/**
	 * ʱȡ��
	 *
	 * @return ʱ
	 */
	public String getWdhour() {
		return wdhour;
	}

	/**
	 * ʱ�趨
	 *
	 * @param ʱ
	 */
	public void setWdhour(String wdhour) {
		this.wdhour = wdhour;
	}

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getWdminute() {
		return wdminute;
	}

	/**
	 * ���趨
	 *
	 * @param ��
	 */
	public void setWdminute(String wdminute) {
		this.wdminute = wdminute;
	}

	/**
	 * �Ƿ����֪ͨ��Y,�ǣ�N����ȡ��
	 *
	 * @return �Ƿ����֪ͨ��Y,�ǣ�N����
	 */
	public String getIsMsgNotice() {
		return isMsgNotice;
	}

	/**
	 * �Ƿ����֪ͨ��Y,�ǣ�N�����趨
	 *
	 * @param �Ƿ����֪ͨ��Y,�ǣ�N����
	 */
	public void setIsMsgNotice(String isMsgNotice) {
		this.isMsgNotice = isMsgNotice;
	}

	/**
	 * ��עȡ��
	 *
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * ��ע�趨
	 *
	 * @param ��ע
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * ����¼��������ȡ��
	 *
	 * @return ����¼��������
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * ����¼���������趨
	 *
	 * @param ����¼��������
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}
	
	/**
	 * Ԥ���ֶ�ȡ��
	 * @return Ԥ���ֶ�
	 */
	public String getReservedFiled() {
		return reservedFiled;
	}

	/**
	 * Ԥ���ֶ��趨
	 * @param Ԥ���ֶ�
	 */
	public void setReservedFiled(String reservedFiled) {
		this.reservedFiled = reservedFiled;
	}
	
	/**
	 * 0Ϊ���� 1Ϊ���ȡ��
	 * @return 0Ϊ���� 1Ϊ���
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 0Ϊ���� 1Ϊ����趨
	 * @param 0Ϊ���� 1Ϊ���
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * ɾ�����������ȡ��
	 * @return ɾ�����������
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}

	/**
	 * ɾ������������趨
	 * @param ɾ�����������
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * @return the ����
	 */
	public FormFile getFileMap() {
		return fileMap;
	}
	

	/**
	 * @param ���� the fileMap to set
	 */
	public void setFileMap(FormFile fileMap) {
		this.fileMap = fileMap;
	}
	

	/**
	 * @return the ������Ϣ
	 */
	public String getResult() {
		return result;
	}
	

	/**
	 * @param ������Ϣ the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * �Ƿ�����ͨ�û���1���ǣ�0����ȡ��
	 * @return �Ƿ�����ͨ�û���1���ǣ�0����
	 */
	public String getIsNormalUser() {
		return isNormalUser;
	}

	/**
	 * �Ƿ�����ͨ�û���1���ǣ�0�����趨
	 * @param isNormalUser the isNormalUser to set
	 */
	public void setIsNormalUser(String isNormalUser) {
		this.isNormalUser = isNormalUser;
	}
}