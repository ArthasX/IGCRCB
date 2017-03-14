/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.asset.model.StorageEventInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: StorageEventʵ��
  * ��������: StorageEventʵ��
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(StorageEventPK.class)
@Table(name="StorageEvent")
public class StorageEventTB extends BaseEntity implements Serializable,
		Cloneable, StorageEventInfo {

	/** ��־��¼ʱ�� */
	@Id
	protected String detectiontime;

	/** dir */
	@Id
	protected String dir;

	/** src */
	protected String src;

	/** ���� */
	@Id
	protected String category;

	/** ���� */
	@Id
	protected String severity;

	/** ����� */
	@Id
	protected String errornum;
	
	/**eirootmark	 */
	@Id
	protected String eirootmark;
	
	/**״̬	 */
	protected String state;
	
	/**һ������	 */
	protected String sort;

	/** ��Ϣ���� */
	protected String errordesc;

	/** ��¼ʱ��� */
	protected String fingerprint;

	/**
	 * ��־��¼ʱ��ȡ��
	 *
	 * @return ��־��¼ʱ��
	 */
	public String getDetectiontime() {
		return detectiontime;
	}

	/**
	 * ��־��¼ʱ���趨
	 *
	 * @param detectiontime��־��¼ʱ��
	 */
	public void setDetectiontime(String detectiontime) {
		this.detectiontime = detectiontime;
	}

	/**
	 * dirȡ��
	 *
	 * @return dir
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * dir�趨
	 *
	 * @param dirdir
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * srcȡ��
	 *
	 * @return src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * src�趨
	 *
	 * @param srcsrc
	 */
	public void setSrc(String src) {
		this.src = src;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * �����趨
	 *
	 * @param category����
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * �����趨
	 *
	 * @param severity����
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public String getErrornum() {
		return errornum;
	}

	/**
	 * ������趨
	 *
	 * @param errornum�����
	 */
	public void setErrornum(String errornum) {
		this.errornum = errornum;
	}

	/**
	 * ��Ϣ����ȡ��
	 *
	 * @return ��Ϣ����
	 */
	public String getErrordesc() {
		return errordesc;
	}

	/**
	 * ��Ϣ�����趨
	 *
	 * @param errordesc��Ϣ����
	 */
	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}

	/**
	 * eirootmarkȡ��
	 * @return eirootmark
	 */
	public String getEirootmark() {
		return eirootmark;
	}

	/**
	 * eirootmark����
	 * @param eirootmark
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * ״̬ȡ��
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * ״̬����
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * һ������ȡ��
	 * @return sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * һ����������
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * ��¼ʱ���ȡ��
	 *
	 * @return ��¼ʱ���
	 */
	public String getFingerprint() {
		return fingerprint;
	}

	/**
	 * ��¼ʱ����趨
	 *
	 * @param fingerprint��¼ʱ���
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new StorageEventPK(detectiontime, dir, category, severity, errornum, eirootmark);
	}

}