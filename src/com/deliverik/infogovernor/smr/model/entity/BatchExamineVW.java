/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;

/**
 * ����:�������� 
 * ������������������ 
 * �����ˣ�����͢
 * ������¼�� 2013-07-31
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
public class BatchExamineVW implements BatchExamineVWInfo{

	@Id
	protected Integer prid;
	
	/** ������ */
	protected String prtitle;
	
	/** ����ʱ�� */
	protected String fillintime;
	
	/** �����������ʱ�� */
	protected String examinetime;
	
	/** ��� */
	protected String fillinusername;
	
	/** ���������� */
	protected String exanimeusername;
	
	/** ״̬ */
	protected String prstatus;
	
	/** ����ʱ�� */
	protected String rejecttime;
	
	/** ��������id */
	protected String prpdid;
	
	/** �Ƿ��Ϳձ��ʶ */
	protected String flag;
	

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
	 * ����ʱ�� ȡ��
	 *
	 * @return ����ʱ�� 
	 */
	public String getFillintime() {
		return fillintime;
	}
	/**
	 * ����ʱ���趨
	 *
	 * @param fillintime ����ʱ�� 
	 */
	public void setFillintime(String fillintime) {
		this.fillintime = fillintime;
	}
	/**
	 * �����������ʱ�� ȡ��
	 *
	 * @return �����������ʱ�� 
	 */
	public String getExaminetime() {
		return examinetime;
	}
	/**
	 * �����������ʱ���趨
	 *
	 * @param examinetime �����������ʱ��
	 */
	public void setExaminetime(String examinetime) {
		this.examinetime = examinetime;
	}
	/**
	 * ��� ȡ��
	 *
	 * @return ��� 
	 */
	public String getFillinusername() {
		return fillinusername;
	}
	/**
	 * ��� �趨
	 *
	 * @param fillinusername ��� 
	 */
	public void setFillinusername(String fillinusername) {
		this.fillinusername = fillinusername;
	}
	/**
	 * ���������� ȡ��
	 *
	 * @return ���������� 
	 */
	public String getExanimeusername() {
		return exanimeusername;
	}
	/**
	 * ���������� �趨
	 *
	 * @param exanimeusername ���������� 
	 */
	public void setExanimeusername(String exanimeusername) {
		this.exanimeusername = exanimeusername;
	}
	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}
	/**
	 * ״̬�趨
	 *
	 * @param prstatus ״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getRejecttime() {
		return rejecttime;
	}
	/**
	 * ����ʱ���趨
	 *
	 * @param rejecttime ����ʱ��
	 */
	public void setRejecttime(String rejecttime) {
		this.rejecttime = rejecttime;
	}
	public String getPrpdid() {
		return prpdid;
	}
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
}
