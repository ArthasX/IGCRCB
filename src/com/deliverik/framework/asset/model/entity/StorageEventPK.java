/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: StorageEventʵ������
  * ��������: StorageEventʵ������
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class StorageEventPK extends BasePK implements Serializable {

	/** ��־��¼ʱ�� */
	protected String detectiontime;

	/** dir */
	protected String dir;
	
	/** ���� */
	protected String category;
	
	/** ���� */
	protected String severity;

	/** ����� */
	protected String errornum;

	/** eirootmark */
	protected String eirootmark;
	
	/**
	 * ���캯��
	 */
	public StorageEventPK() {

	}

	/**
	 * ���캯��
	 */
	public StorageEventPK(String detectiontime,String  dir, String errornum, String eirootmark, String category, String severity) {
		super();
		this.detectiontime = detectiontime;
		this.dir = dir;
		this.category=category;
		this.severity=severity;
		this.errornum = errornum;
		this.eirootmark=eirootmark;
		
	}

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
}