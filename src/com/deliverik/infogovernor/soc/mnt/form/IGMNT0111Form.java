/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.form;

import com.deliverik.framework.base.BaseForm;

/**
 * debug�������FORM
 * IGMNT0111Form ActionForm
 */
public class IGMNT0111Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	/** ����id */
	protected Integer moId;
	
	/** ����id */
	protected Integer mtId;

	/** �洢���к� */
	protected String mtSsn;

	/** ������� */
	protected String mtCname;
	/** kpi */
	protected String mtKpi;
	/** �ɼ���� */
	protected String mtInterval;

	/** �ɼ����� */
	protected Integer mtNum;

	/** ��ʼʱ�� */
	protected String mtStartTime;

	/** ����ʱ�� */
	protected String mtStopTime;

	/** Ԥ�ƽ���ʱ�� */
	protected String mtPStopTime;

	/** ����״̬ */
	protected String mtStatus;

	/** ��¼ʱ�� */
	protected String mtRecordTime;

	/** ��¼�û�id */
	protected String mtUserId;

	/** �û�����ID */
	protected String mtOrgId;
	
	/**����id*/
	protected String[] selectedid;
	
	/**�������ʶ*/
	protected String cnameIdent;
	
	/**kpi��ʶ*/
	protected String kpiIdent;
	
	/**ʱ������ʶ*/
	protected String intervalIdent;
	/**ʱ��Ĭ��*/
	protected String interValDefault;
	
	/**checkbox��������*/
	protected String checkedCount;
	/**
	 * ����idȡ��
	 *
	 * @return mtId ����id
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * ����id�趨
	 *
	 * @param mtId ����id
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * �洢���к�ȡ��
	 *
	 * @return mtSsn �洢���к�
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * �洢���к��趨
	 *
	 * @param mtSsn �洢���к�
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}

	/**
	 * �������ȡ��
	 *
	 * @return mtCname �������
	 */
	public String getMtCname() {
		return mtCname;
	}

	/**
	 * ��������趨
	 *
	 * @param mtCname �������
	 */
	public void setMtCname(String mtCname) {
		this.mtCname = mtCname;
	}

	/**
	 * kpiȡ��
	 *
	 * @return mtKpi kpi
	 */
	public String getMtKpi() {
		return mtKpi;
	}

	/**
	 * kpi�趨
	 *
	 * @param mtKpi kpi
	 */
	public void setMtKpi(String mtKpi) {
		this.mtKpi = mtKpi;
	}

	/**
	 * �ɼ����ȡ��
	 *
	 * @return mtInterval �ɼ����
	 */
	public String getMtInterval() {
		return mtInterval;
	}

	/**
	 * �ɼ�����趨
	 *
	 * @param mtInterval �ɼ����
	 */
	public void setMtInterval(String mtInterval) {
		this.mtInterval = mtInterval;
	}

	/**
	 * �ɼ�����ȡ��
	 *
	 * @return mtNum �ɼ�����
	 */
	public Integer getMtNum() {
		return mtNum;
	}

	/**
	 * �ɼ������趨
	 *
	 * @param mtNum �ɼ�����
	 */
	public void setMtNum(Integer mtNum) {
		this.mtNum = mtNum;
	}

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return mtStartTime ��ʼʱ��
	 */
	public String getMtStartTime() {
		return mtStartTime;
	}

	/**
	 * ��ʼʱ���趨
	 *
	 * @param mtStartTime ��ʼʱ��
	 */
	public void setMtStartTime(String mtStartTime) {
		this.mtStartTime = mtStartTime;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return mtStopTime ����ʱ��
	 */
	public String getMtStopTime() {
		return mtStopTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param mtStopTime ����ʱ��
	 */
	public void setMtStopTime(String mtStopTime) {
		this.mtStopTime = mtStopTime;
	}

	/**
	 * Ԥ�ƽ���ʱ��ȡ��
	 *
	 * @return mtPStopTime Ԥ�ƽ���ʱ��
	 */
	public String getMtPStopTime() {
		return mtPStopTime;
	}

	/**
	 * Ԥ�ƽ���ʱ���趨
	 *
	 * @param mtPStopTime Ԥ�ƽ���ʱ��
	 */
	public void setMtPStopTime(String mtPStopTime) {
		this.mtPStopTime = mtPStopTime;
	}

	/**
	 * ����״̬ȡ��
	 *
	 * @return mtStatus ����״̬
	 */
	public String getMtStatus() {
		return mtStatus;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param mtStatus ����״̬
	 */
	public void setMtStatus(String mtStatus) {
		this.mtStatus = mtStatus;
	}

	/**
	 * ��¼ʱ��ȡ��
	 *
	 * @return mtRecordTime ��¼ʱ��
	 */
	public String getMtRecordTime() {
		return mtRecordTime;
	}

	/**
	 * ��¼ʱ���趨
	 *
	 * @param mtRecordTime ��¼ʱ��
	 */
	public void setMtRecordTime(String mtRecordTime) {
		this.mtRecordTime = mtRecordTime;
	}

	/**
	 * ��¼�û�idȡ��
	 *
	 * @return mtUserId ��¼�û�id
	 */
	public String getMtUserId() {
		return mtUserId;
	}

	/**
	 * ��¼�û�id�趨
	 *
	 * @param mtUserId ��¼�û�id
	 */
	public void setMtUserId(String mtUserId) {
		this.mtUserId = mtUserId;
	}

	/**
	 * �û�����IDȡ��
	 *
	 * @return mtOrgId �û�����ID
	 */
	public String getMtOrgId() {
		return mtOrgId;
	}

	/**
	 * �û�����ID�趨
	 *
	 * @param mtOrgId �û�����ID
	 */
	public void setMtOrgId(String mtOrgId) {
		this.mtOrgId = mtOrgId;
	}

	/**
	 * ����idȡ��
	 *
	 * @return moId ����id
	 */
	public Integer getMoId() {
		return moId;
	}

	/**
	 * ����id�趨
	 *
	 * @param moId ����id
	 */
	public void setMoId(Integer moId) {
		this.moId = moId;
	}

	/**
	 * ����idȡ��
	 *
	 * @return selectedid ����id
	 */
	public String[] getSelectedid() {
		return selectedid;
	}

	/**
	 * ����id�趨
	 *
	 * @param selectedid ����id
	 */
	public void setSelectedid(String[] selectedid) {
		this.selectedid = selectedid;
	}

	/**
	 * �������ʶȡ��
	 *
	 * @return cnameIdent �������ʶ
	 */
	public String getCnameIdent() {
		return cnameIdent;
	}

	/**
	 * �������ʶ�趨
	 *
	 * @param cnameIdent �������ʶ
	 */
	public void setCnameIdent(String cnameIdent) {
		this.cnameIdent = cnameIdent;
	}

	/**
	 * kpi��ʶȡ��
	 *
	 * @return kpiIdent kpi��ʶ
	 */
	public String getKpiIdent() {
		return kpiIdent;
	}

	/**
	 * kpi��ʶ�趨
	 *
	 * @param kpiIdent kpi��ʶ
	 */
	public void setKpiIdent(String kpiIdent) {
		this.kpiIdent = kpiIdent;
	}

	/**
	 * ʱ������ʶȡ��
	 *
	 * @return intervalIdent ʱ������ʶ
	 */
	public String getIntervalIdent() {
		return intervalIdent;
	}

	/**
	 * ʱ������ʶ�趨
	 *
	 * @param intervalIdent ʱ������ʶ
	 */
	public void setIntervalIdent(String intervalIdent) {
		this.intervalIdent = intervalIdent;
	}

	/**
	 * checkbox��������ȡ��
	 *
	 * @return checkedCount checkbox��������
	 */
	public String getCheckedCount() {
		return checkedCount;
	}

	/**
	 * checkbox���������趨
	 *
	 * @param checkedCount checkbox��������
	 */
	public void setCheckedCount(String checkedCount) {
		this.checkedCount = checkedCount;
	}

	/**
	 * ʱ��Ĭ��ȡ��
	 *
	 * @return interValDefault ʱ��Ĭ��
	 */
	public String getInterValDefault() {
		return interValDefault;
	}

	/**
	 * ʱ��Ĭ���趨
	 *
	 * @param interValDefault ʱ��Ĭ��
	 */
	public void setInterValDefault(String interValDefault) {
		this.interValDefault = interValDefault;
	}
	
}
