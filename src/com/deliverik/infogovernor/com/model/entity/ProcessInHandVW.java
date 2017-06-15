/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.com.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;

/**
 * 
 * �����й���
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class ProcessInHandVW implements Serializable, Cloneable, ProcessInHandVWInfo {
	
	@Id
	private Integer rid;
	
	/**
	 * ����ID 
	 */
	private Integer prid;
	
	/** ���������� */
	private String prusername;
	
	/**
	 * �����̶�
	 */
	private String prurgency;
	
	/**
	 * �������
	 */
	private String prserialnum;
	
	/**
	 * ���̱���
	 */
	private String prtitle;
	/**
	 * ����ģ��id
	 */
	private String prpdid;
	/**
	 * ����ģ������
	 */
	private String prpdname;
	
	/**
	 * ��������
	 */
	private String prtype;
	
	/**
	 * ��ʼʱ��
	 */
	private String propentime;
	
	/** �ر�ʱ�� */
	private String prclosetime;
	
	/**
	 * ������
	 */
	private String ppusername;
	
	/**
	 * ״̬
	 */
	private String prstatus;
	
	/** �����ɫ���� */
	private String pprolename;
	
	/**
	 * ������ʾ
	 */
	@Transient
	private String showtype;
	
	/**
	 * ��ʾ����
	 */
	@Transient
	private String showtitle;
	@Transient
	private String showrolename;
	@Transient
	private String showpdname;
	@Transient
	private String showimg;
	@Transient
	private String showurl;
	
	private String prrolename;
	
	private Integer prstrategyversion;
	
	/** ����״̬  */	
	private String orderstatus;

	/**
	 * ����״̬ID
	 */
	protected String psdid;

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����������ȡ��
	 * @return prusername ����������
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * �����������趨
	 * @param prusername ����������
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * �ر�ʱ��ȡ��
	 * @return prclosetime �ر�ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * �ر�ʱ���趨
	 * @param prclosetime �ر�ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getPpusername() {
		return ppusername;
	}

	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * �����ɫ����ȡ��
	 * @return pprolename �����ɫ����
	 */
	public String getPprolename() {
		return pprolename;
	}

	/**
	 * �����ɫ�����趨
	 * @param pprolename �����ɫ����
	 */
	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPrpdname() {
		return prpdname;
	}

	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	public Integer getPrstrategyversion() {
		return prstrategyversion;
	}

	public void setPrstrategyversion(Integer prstrategyversion) {
		this.prstrategyversion = prstrategyversion;
	}

	public String getShowtype() {
		this.showtype = "2";
		return showtype;
	}

	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}

	public String getShowtitle() {
		if(StringUtils.isNotEmpty(prtitle)){
			if(this.prtitle.length() > 9){
				this.showtitle = this.prtitle.substring(0,9) + "...";
			}else{
				this.showtitle = this.prtitle;
			}
		}
		return showtitle;
	}

	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
	}

	public String getPrrolename() {
		return prrolename;
	}

	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	public String getShowrolename() {
		if(StringUtils.isNotEmpty(this.prrolename)){
			if(this.prrolename.length() > 5){
				this.showrolename = this.prrolename.substring(0,4) + "...";
			}else{
				this.showrolename = this.prrolename;
			}
		}
		
		return showrolename;
	}

	public void setShowrolename(String showrolename) {
		this.showrolename = showrolename;
	}

	public String getShowpdname() {
		if(StringUtils.isNotEmpty(this.prpdname)){
			if(this.prpdname.length() > 5){
				this.showpdname = this.prpdname.substring(0,4) + "...";
			}else{
				this.showpdname = this.prpdname;
			}
		}
		return showpdname;
	}

	public void setShowpdname(String showpdname) {
		this.showpdname = showpdname;
	}

	public String getShowimg() {
		if(StringUtils.isNotEmpty(this.prtype)){
			if(this.prtype.length() > 2){
				this.showimg = this.prtype.substring(0,2);
			}else{
				this.showimg = this.prtype;
			}
		}
		return showimg;
	}

	public void setShowimg(String showimg) {
		this.showimg = showimg;
	}

	public String getShowurl() {
		this.showurl = "IGPRR0102_Disp.do?prtype=" + prtype + "&prid=";
		return showurl;
	}

	public void setShowurl(String showurl) {
		this.showurl = showurl;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ����״̬ȡ��
	 * @return orderstatus  ����״̬
	 */
	public String getOrderstatus() {
		return orderstatus;
	}

	/**
	 * ����״̬�趨
	 * @param orderstatus  ����״̬
	 */
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	
}
