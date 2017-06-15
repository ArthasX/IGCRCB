package com.deliverik.infogovernor.risk.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.RiskCheck;


/**
 * ���ռ����FORM
 * 
 */
@SuppressWarnings("serial")
public class IGRIS0204Form extends BaseForm {
	
	/** ���ռ����ID */
	protected Integer rcrid;
	
	/** ���ռ��ID */
	protected Integer rcid;

	/** ���ռ��ƻ����ʱ�� */
	protected String rcrplandate;
	
	/** ���ռ��ʵ�ʼ��ʱ�� */
	protected String rcrrealtime;
	
	/** ���ռ�����ύ��ID */
	protected String rcruserid;
	
	/** ���ռ�����ύ������ */
	protected String rcrusername;
	
	/** ���ռ���� */
	protected String rcrresult;
	
	/** ���ռ����˵�� */
	protected String rcrcomment;
	
	/** ���ռ����� */
	protected RiskCheck riskCheck;
	
	/** �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������ */
	protected String startdate;
	
	/** �ƻ�ִ�м��������ڣ���ѯ������*/
	protected String enddate;

	/** ���ռ������ */
	protected String rcrtitle;
	
	/** ���ռ����� */
	protected String rccategoryname;
	
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	
	/**
	 * �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������ȡ��
	 * @return �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * ���ռ������ȡ��
	 * @return ���ռ������
	 */
	public String getRcrtitle() {
		return rcrtitle;
	}

	/**
	 * ���ռ�������趨
	 * @param rcrtitle ���ռ������
	 */
	public void setRcrtitle(String rcrtitle) {
		this.rcrtitle = rcrtitle;
	}


	/**
	 * �ƻ�ִ�м��������ڣ���ѯ������ȡ��
	 * @return �ƻ�ִ�м��������ڣ���ѯ������
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������ȡ��
	 * @return �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	/**
	 * �ƻ�ִ�м��������ڣ���ѯ�������趨
	 * @param enddate �ƻ�ִ�м��������ڣ���ѯ������
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	/**
	 * @return the fileMap
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}


	/**
	 * @param fileMap the fileMap to set
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}


	/**
	 * ���ռ������������ȡ��
	 * @return ���ռ������������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * ���ռ������������
	 *
	 * @param index ���ռ��������������������
	 * @param file ���ռ������������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}
	

	/**
	 * ���ռ����IDȡ��
	 * @return ���ռ����ID
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * ���ռ��IDȡ��
	 * @return the ���ռ��ID
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * ���ռ��ƻ����ʱ��ȡ��
	 * @return ���ռ��ƻ����ʱ��
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}

	/**
	 * ���ռ��ʵ�ʼ��ʱ��ȡ��
	 * @return ���ռ��ʵ�ʼ��ʱ��
	 */
	public String getRcrrealtime() {
		return rcrrealtime;
	}

	/**
	 * ���ռ�����ύ��IDȡ��
	 * @return ���ռ�����ύ��ID
	 */
	public String getRcruserid() {
		return rcruserid;
	}

	/**
	 * ���ռ�����ύ������ȡ��
	 * @return ���ռ�����ύ������
	 */
	public String getRcrusername() {
		return rcrusername;
	}

	/**
	 * ���ռ����ȡ��
	 * @return ���ռ����
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * ���ռ����˵��ȡ��
	 * @return ���ռ����˵��
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * ���ռ�����ȡ��
	 * @return ���ռ�����
	 */
	public RiskCheck getRiskCheck() {
		return riskCheck;
	}

	/**
	 * ���ռ����ID�趨
	 * @param rcrid ���ռ����ID
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * ���ռ��ID�趨
	 * @param rcid ���ռ��ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ���ռ��ƻ����ʱ���趨
	 * @param rcrplandate ���ռ��ƻ����ʱ��
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	/**
	 * ���ռ��ʵ�ʼ��ʱ���趨
	 * @param rcrrealtime ���ռ��ʵ�ʼ��ʱ��
	 */
	public void setRcrrealtime(String rcrrealtime) {
		this.rcrrealtime = rcrrealtime;
	}

	/**
	 * ���ռ�����ύ��ID�趨
	 * @param rcruserid ���ռ�����ύ��ID
	 */
	public void setRcruserid(String rcruserid) {
		this.rcruserid = rcruserid;
	}

	/**
	 * ���ռ�����ύ�������趨
	 * @param rcrusername ���ռ�����ύ������
	 */
	public void setRcrusername(String rcrusername) {
		this.rcrusername = rcrusername;
	}

	/**
	 * ���ռ�����趨
	 * @param rcrresult ���ռ����
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * ���ռ����˵���趨
	 * @param rcrcomment ���ռ����˵��
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}

	/**
	 * ���ռ������趨
	 * @param riskCheck ���ռ�����
	 */
	public void setRiskCheck(RiskCheck riskCheck) {
		this.riskCheck = riskCheck;
	}

	/**
	 * ���ռ�����ȡ��
	 * @return ���ռ�����
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}

	/**
	 * ���ռ������趨
	 * @param rccategoryname ���ռ�����
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}

}
