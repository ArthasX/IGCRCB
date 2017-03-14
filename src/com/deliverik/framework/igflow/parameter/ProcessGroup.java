/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


/**
 * �����鷢����Ϣ
 */
public class ProcessGroup implements ProcessGroupInfo {
	
	/** �����鷢����ID */
	private String crtuserid;

	/** �����鶨��ID */
	private String defid;
	
	/** �����鶨��״̬��1���ԣ�2������ */
	private String defstatus;
	
	/** ���������� */
	private String description;
	
	/** ���������� */
	private String title;
	
	/** ����ʵ�����Ƽ��� */
	public Map<String, String> processTitle = new HashMap<String, String>();

	/**
	 * �����鷢����IDȡ��
	 * 
	 * @return �����鷢����ID
	 */
	public String getCrtuserid() {
		return crtuserid;
	}

	/**
	 * �����鶨��IDȡ��
	 * 
	 * @return �����鶨��ID
	 */
	public String getDefid() {
		return defid;
	}

	/**
	 * �����鶨��״̬ȡ��
	 * 
	 * @return �����鶨��״̬
	 */
	public String getDefstatus() {
		return defstatus;
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
	 * ����������ȡ��
	 * 
	 * @return ����������
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * ����ʵ������ȡ��
	 * @param pdid ���̶���ID
	 * @return ����ʵ������
	 */
	public String getProcessTitle(String pdid) {
		if(StringUtils.isEmpty(processTitle.get(pdid))) {
			return "";
		} else {
			return "_" + processTitle.get(pdid);
		}
	}

	/**
	 * �����鷢����ID�趨
	 * 
	 * @param crtuserid �����鷢����ID
	 */
	public void setCrtuserid(String crtuserid) {
		this.crtuserid = crtuserid;
	}

	/**
	 * �����鶨��ID�趨
	 * 
	 * @param defid �����鶨��ID
	 */
	public void setDefid(String defid) {
		this.defid = defid;
	}
	
	/**
	 * �����鶨��״̬�趨
	 * 
	 * @param defstatus �����鶨��״̬
	 */
	public void setDefstatus(String defstatus) {
		this.defstatus = defstatus;
	}

	/**
	 * �����������趨
	 * 
	 * @param description ����������
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * �����������趨
	 * 
	 * @param title ����������
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * ����ʵ�����Ƽ����趨
	 * 
	 * @param pdid ���̶���ID
	 * @param processTitle ����ʵ������
	 */
	public void addProcessTitle(String pdid, String processTitle) {
		this.processTitle.put(pdid, processTitle);
	}
	
}
