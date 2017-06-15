/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.csebank.lom.model.GoutDetailInfo;


/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ��������ϸʵ��
 * ���ߣ�������
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class GoutDetailTB implements Serializable, Cloneable, GoutDetailInfo {
	@Id
	public String goid;
	/** ʱ�� */
	public String gotime;
	/** ������ */
	public String gorequsername;
	/** ��Ʒ���� */
	public String goname;
	
	/** ��Ʒ��� */
	public String gocode;
	/** �д����� */
	public String rname;
	/** �Ӵ�id */
	public String rid;
	//��������
	public String goinnum;
	
	public String getGorequsername() {
		return gorequsername;
	}
	public void setGorequsername(String gorequsername) {
		this.gorequsername = gorequsername;
	}
	public String getGoname() {
		return goname;
	}
	public void setGoname(String goname) {
		this.goname = goname;
	}
	public String getGocode() {
		return gocode;
	}
	public void setGocode(String gocode) {
		this.gocode = gocode;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getGoinnum() {
		return goinnum;
	}
	public void setGoinnum(String goinnum) {
		this.goinnum = goinnum;
	}
	public String getGotime() {
		return gotime;
	}
	public void setGotime(String gotime) {
		this.gotime = gotime;
	}

	public String getGoid() {
		return goid;
	}
	public void setGoid(String goid) {
		this.goid = goid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}






}
