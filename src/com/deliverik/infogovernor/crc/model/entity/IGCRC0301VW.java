/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC0301VWInfo;

@SuppressWarnings("serial")
@Entity
public class IGCRC0301VW implements Serializable,Cloneable,IGCRC0301VWInfo{
	
	@Id
	protected Integer prid;
	
	/**
	 * ���̼�¼����
	 */
	protected String prtype;
	
	/**
	 * ���̼�¼������
	 */
	protected String prserialnum;
	
	/**
	 * ���̼�¼��Ŀ
	 */
	protected String prtitle;
	
	
	/**
	 * ���̼�¼�������û�����
	 */
	protected String prusername;
	
	
	
	

	
	
	/**
	 * ���̼�¼����ʱ��
	 */
	protected String propentime;
	
	/**
	 * ���̼�¼�ر�ʱ��
	 */
	protected String prclosetime;
	
	/**
	 * ���̼�¼״̬
	 */
	protected String prstatus;
	

	/**
	 * ���̼�¼״̬��״̬
	 */
	protected String prsubstatus;
	
	/**
	 * ���̼�¼��������ID
	 */
	protected String prpdid;
	
	/**
	 * ��������
	 */
	protected String pbcontent;
	
	/**
	 * ��������
	 */
	protected String afterplan;
	
	/**
	 * ��������
	 */
	protected String planstime;
	
	/**
	 * ��������
	 */
	protected String dutypersion;
	
	
	
	/**
	 * �ڵ�����
	 */
	protected String orderstatus;

	/**
	 * �ڵ�id
	 */
	protected String psdid;
	
	
	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrusername() {
		return prusername;
	}

	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	public String getPrsubstatus() {
		return prsubstatus;
	}

	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPbcontent() {
		return pbcontent;
	}

	public void setPbcontent(String pbcontent) {
		this.pbcontent = pbcontent;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getAfterplan() {
		return afterplan;
	}

	public void setAfterplan(String afterplan) {
		this.afterplan = afterplan;
	}

	public String getPlanstime() {
		return planstime;
	}

	public void setPlanstime(String planstime) {
		this.planstime = planstime;
	}

	public String getDutypersion() {
		return dutypersion;
	}

	public void setDutypersion(String dutypersion) {
		this.dutypersion = dutypersion;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	
	
	
	
	
}
