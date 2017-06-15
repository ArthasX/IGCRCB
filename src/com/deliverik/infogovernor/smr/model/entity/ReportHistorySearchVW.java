/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;

/**
 * ����:ͨ�ò�ѯ��ͼ
 * ����������ͨ�ò�ѯ��ͼ
 * �����ˣ�����͢
 * ������¼�� 2013-08-13
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
public class ReportHistorySearchVW implements ReportHistorySearchVWInfo{
	@Id
	protected Integer prid;
	
	/** ������ */
	protected String prtitle;
	
	/** ���*/
	protected String fillinname;
	
	/** ����������*/
	protected String reportapprovename;
	
	/** ������*/
	protected String prusername;
	
	/** ����ʱ��*/
	protected String prstarttime;
	
	/** ��������*/
	protected String prpdid;
	
	/** ��������*/
	protected String prtype;
	
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPrid() {
		return prid;
	}
	
	/**
	 * �����趨
	 *
	 * @param prid ����
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	/**
	 * ������ ȡ��
	 *
	 * @return ������ 
	 */
	public String getPrtitle() {
		return prtitle;
	}
	/**
	 * ������ �趨
	 *
	 * @param prtitle ������ 
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	/**
	 * ��� ȡ��
	 *
	 * @return ��� 
	 */
	public String getFillinname() {
		return fillinname;
	}
	/**
	 * ��� �趨
	 *
	 * @param fillinusername ��� 
	 */
	public void setFillinname(String fillinname) {
		this.fillinname = fillinname;
	}
	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getReportapprovename() {
		return reportapprovename;
	}
	/**
	 * ���������� �趨
	 *
	 * @param reportapprovename ����������
	 */
	public void setReportapprovename(String reportapprovename) {
		this.reportapprovename = reportapprovename;
	}
	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPrusername() {
		return prusername;
	}
	/**
	 * �������趨
	 *
	 * @param prusername ������
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}
	/**
	 *����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getPrstarttime() {
		return prstarttime;
	}
	/**
	 * ����ʱ���趨
	 *
	 * @param prstarttime ����ʱ��
	 */
	public void setPrstarttime(String prstarttime) {
		this.prstarttime = prstarttime;
	}
	/**
	 *��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrpdid() {
		return prpdid;
	}
	/**
	 * ���������趨
	 *
	 * @param prpdid ��������
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	
	
	
	


}
