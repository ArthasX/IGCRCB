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
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;

/**
  * ����: ���������ʵ��
  * ��������: ���������ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="WorkDefinition")
public class WorkDefinitionTB extends BaseEntity implements Serializable,
		Cloneable, WorkDefinitionInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="WORKDEFINITION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKDEFINITION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKDEFINITION_TABLE_GENERATOR")
	protected Integer wdid;

	/** ���������� */
	protected String wdname;

	/** �����ˣ�userid�� */
	protected String initiatorId;

	/** ����/Ƶ�� */
	protected String cycle;

	/** ����ʱ��  */
	protected String wdcreateTime;

	/** ���������� */
	protected String description;

	/** ��ʼ���� */
	protected String beginDate;

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

	/** ִ���ˣ�userid,userid,userid,...�� */
	protected String excutorId;

	/** ����״̬��0��δ���ã�1�������ã� */
	protected Integer wdstatus;

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

	/** ���¼�������� */
	protected String crtDate;
	
	/** Ԥ���ֶ� */
	protected String reservedFiled;

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
	 * beginDate�趨
	 *
	 * @param ��ʼ����
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
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
	 * ����״̬��0��δ���ã�1�������ã�ȡ��
	 *
	 * @return ����״̬��0��δ���ã�1�������ã�
	 */
	public Integer getWdstatus() {
		return wdstatus;
	}

	/**
	 * ����״̬��0��δ���ã�1�������ã��趨
	 *
	 * @param ����״̬��0��δ���ã�1�������ã�
	 */
	public void setWdstatus(Integer wdstatus) {
		this.wdstatus = wdstatus;
	}

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getWdmonth() {
		return wdmonth;
	}

	/**
	 * ���趨
	 *
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
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getWdweek() {
		return wdweek;
	}

	/**
	 * ���趨
	 *
	 * @param ��
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
	 * ���¼��������ȡ��
	 *
	 * @return ���¼��������
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * ���¼���������趨
	 *
	 * @param ���¼��������
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
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return wdid;
	}

}