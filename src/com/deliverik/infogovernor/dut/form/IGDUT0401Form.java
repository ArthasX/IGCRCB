/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.DelayInfo;

/**
 * 
 * ��ʱ�����Ǽ�form
 *
 */
public class IGDUT0401Form extends BaseForm implements DelayInfo {
	
	private static final long serialVersionUID = 1L;

	/** ����id */
	protected Integer id;

	/** ����ʱ�� */
	protected String datetime;

	/** ���뵥λ */
	protected String orgname;

	/** ������� */
	protected String title;
	
	/** ����������� */
	protected String[] titles;
	
	/** �г����� */
	protected String hzname;

	/** �г��绰 */
	protected String hztel;
	
	/** �������� */
	protected String jlname;

	/** ����绰 */
	protected String jltel;

	/** ��ע */
	protected String remark;

	/** ��ʼʱ�� */
	protected String starttime;

	/** ����ʱ�� */
	protected String endtime;

	/** ������ */
	protected String operater;
	
	/** ����ʱ�� */
	protected String unlocktime;
	
	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode = "0";

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * ����id�趨
	 *
	 * @param id ����id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param delaydate ����ʱ��
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * ���뵥λȡ��
	 *
	 * @return ���뵥λ
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���뵥λ�趨
	 *
	 * @param orgname ���뵥λ
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * �г��绰ȡ��
	 *
	 * @return �г��绰
	 */
	public String getHztel() {
		return hztel;
	}

	/**
	 * �г��绰�趨
	 *
	 * @param hztel �г��绰
	 */
	public void setHztel(String hztel) {
		this.hztel = hztel;
	}

	/**
	 * ����绰ȡ��
	 *
	 * @return ����绰
	 */
	public String getJltel() {
		return jltel;
	}

	/**
	 * ����绰�趨
	 *
	 * @param jltel ����绰
	 */
	public void setJltel(String jltel) {
		this.jltel = jltel;
	}

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ��ע�趨
	 *
	 * @param comment ��ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * ��ʼʱ���趨
	 *
	 * @param starttime ��ʼʱ��
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param endtime ����ʱ��
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getOperater() {
		return operater;
	}

	/**
	 * �������趨
	 *
	 * @param operater ������
	 */
	public void setOperater(String operater) {
		this.operater = operater;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	/**
	 * �г�����ȡ��
	 * @return
	 */
	public String getHzname() {
		return hzname;
	}

	/**
	 * �г������趨
	 * @param hzname
	 */
	public void setHzname(String hzname) {
		this.hzname = hzname;
	}

	/**
	 * ��������ȡ��
	 * @return
	 */
	public String getJlname() {
		return jlname;
	}

	/**
	 * ���������趨
	 * @param jlname
	 */
	public void setJlname(String jlname) {
		this.jlname = jlname;
	}

	public String getFingerPrint() {
		return null;
	}

	/**
	 * �����������ʶȡ��
	 */
	public String getMode() {
		return mode;
	}
	
	/**
	 * �����������ʶ�趨
	 * @return mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * ����ʱ��ȡ��
	 * @return
	 */
	public String getUnlocktime() {
		return unlocktime;
	}

	/**
	 * ����ʱ���趨
	 * @param unlocktime
	 */
	public void setUnlocktime(String unlocktime) {
		this.unlocktime = unlocktime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

}
