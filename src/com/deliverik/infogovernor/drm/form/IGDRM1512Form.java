/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѵ�ƻ�����ѵ�������Form
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1512Form extends BaseForm {
	
	/** ����ID */
	protected Integer upTpid;
	
	/**�¼�����*/
	protected String upTpname;
	
	/** ������id */
	protected String upTpuserid;

	/** ���������� */
	protected String upTpusername;

	/** ������id */
	protected String upTporgid;

	/** ���������� */
	protected String upTporgname;

	/** �������� */
	protected String upTptime;

	/** �ƻ�״̬ */
	protected String upTstatus;

	
	/** ��ѵ�γ� */
	protected String[] tmcourse;

	/** ��ѵ���� */
	protected String[] tmorg;

	/** ��ѵʱ�� */
	protected String[] tmtime;

	/** ��ѵ���� */
	protected String[] tmtarget;

	/** ���� */
	protected String[] tmatt;
	
	/**
	 * ����ʱ��
	 */
	private String startTime;
	
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/** ���� */
	protected Map<Integer, FormFile> fileListMap = new LinkedHashMap<Integer, FormFile>();
	protected String [] attkeys;

	/**
	 * @return the fileListMap
	 */
	public Map<Integer, FormFile> getFileListMap() {
		return this.fileListMap;
	}

	/**
	 * @return the attkeys
	 */
	public String[] getAttkeys() {
		return this.attkeys;
	}

	/**
	 * @param attkeys the attkeys to set
	 */
	public void setAttkeys(String[] attkeys) {
		this.attkeys = attkeys;
	}
	
	/**
	 * ���ø���
	 * @param index ������������
	 * @param file ����
	 */
	public void setAttachment(int index, FormFile file) {
		fileListMap.put(index, file);
	}
	
	/**
	 * �����
	 */
	private List<Map<String, Object>> resultList;
	
	/**
	 * �����ȡ��
	 * @return resultList �����
	 */
	public List<Map<String, Object>> getResultList() {
		return resultList;
	}
	/**
	 * ������趨
	 * @param resultList �����
	 */
	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getUpTpid() {
		return upTpid;
	}

	/**
	 * �����趨
	 *
	 * @param upTpid ����
	 */
	public void setUpTpid(Integer upTpid) {
		this.upTpid = upTpid;
	}

	/**
	 * �ƻ�����ȡ��
	 *
	 * @return �ƻ�����
	 */
	public String getUpTpname() {
		return upTpname;
	}

	/**
	 * �ƻ������趨
	 *
	 * @param upTpname �ƻ�����
	 */
	public void setUpTpname(String upTpname) {
		this.upTpname = upTpname;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getUpTpuserid() {
		return upTpuserid;
	}

	/**
	 * ������id�趨
	 *
	 * @param upTpuserid ������id
	 */
	public void setUpTpuserid(String upTpuserid) {
		this.upTpuserid = upTpuserid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getUpTpusername() {
		return upTpusername;
	}

	/**
	 * �����������趨
	 *
	 * @param upTpusername ����������
	 */
	public void setUpTpusername(String upTpusername) {
		this.upTpusername = upTpusername;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getUpTporgid() {
		return upTporgid;
	}

	/**
	 * ������id�趨
	 *
	 * @param upTporgid ������id
	 */
	public void setUpTporgid(String upTporgid) {
		this.upTporgid = upTporgid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getUpTporgname() {
		return upTporgname;
	}

	/**
	 * �����������趨
	 *
	 * @param upTporgname ����������
	 */
	public void setUpTporgname(String upTporgname) {
		this.upTporgname = upTporgname;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getUpTptime() {
		return upTptime;
	}

	/**
	 * ���������趨
	 *
	 * @param upTptime ��������
	 */
	public void setUpTptime(String upTptime) {
		this.upTptime = upTptime;
	}

	/**
	 * �ƻ�״̬ȡ��
	 *
	 * @return �ƻ�״̬
	 */
	public String getUpTstatus() {
		return upTstatus;
	}

	/**
	 * �ƻ�״̬�趨
	 *
	 * @param upTstatus �ƻ�״̬
	 */
	public void setUpTstatus(String upTstatus) {
		this.upTstatus = upTstatus;
	}

	/**
	 * ��ѵ�γ�ȡ��
	 *
	 * @return ��ѵ�γ�
	 */
	public String[] getTmcourse() {
		return tmcourse;
	}

	/**
	 * ��ѵ�γ��趨
	 *
	 * @param tmcourse ��ѵ�γ�
	 */
	public void setTmcourse(String[] tmcourse) {
		this.tmcourse = tmcourse;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String[] getTmorg() {
		return tmorg;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param tmorg ��ѵ����
	 */
	public void setTmorg(String[] tmorg) {
		this.tmorg = tmorg;
	}

	/**
	 * ��ѵʱ��ȡ��
	 *
	 * @return ��ѵʱ��
	 */
	public String[] getTmtime() {
		return tmtime;
	}

	/**
	 * ��ѵʱ���趨
	 *
	 * @param tmtime ��ѵʱ��
	 */
	public void setTmtime(String[] tmtime) {
		this.tmtime = tmtime;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String[] getTmtarget() {
		return tmtarget;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param tmtarget ��ѵ����
	 */
	public void setTmtarget(String[] tmtarget) {
		this.tmtarget = tmtarget;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String[] getTmatt() {
		return tmatt;
	}

	/**
	 * �����趨
	 *
	 * @param tmatt ����
	 */
	public void setTmatt(String[] tmatt) {
		this.tmatt = tmatt;
	}
	
}
