/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.form;

import java.util.ArrayList;

import com.deliverik.framework.base.BaseForm;

/**
 * Ԥ��ͼ����ʾxml�õ�����Ϣ
 */
public class IGFIN0302Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	
	private Integer bid;//Ԥ��id
	
	private String btitle;//Ԥ������
	
	private Double bamount;//Ԥ����
	
	private Float examount;//ʵ�ʷ��ý��
	
	protected String pquality;//Ԥ������
	
	protected String pstorecode;//����Ԥ����
	
	protected String pneeddispart;//������
	
	protected String pbuggetform;//Ԥ�����
	
	protected String remark;//��ע
	
	private ArrayList examountList;
	
	protected String btitle_q;
	
	protected String byear_q;
	
	protected String btype_q;
	

	
	public String getBtitle_q() {
		return btitle_q;
	}

	public void setBtitle_q(String btitle_q) {
		this.btitle_q = btitle_q;
	}

	public String getByear_q() {
		return byear_q;
	}

	public void setByear_q(String byear_q) {
		this.byear_q = byear_q;
	}

	public String getBtype_q() {
		return btype_q;
	}

	public void setBtype_q(String btype_q) {
		this.btype_q = btype_q;
	}

	public String getPquality() {
		return pquality;
	}

	public void setPquality(String pquality) {
		this.pquality = pquality;
	}

	public String getPstorecode() {
		return pstorecode;
	}

	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}

	public String getPneeddispart() {
		return pneeddispart;
	}

	public void setPneeddispart(String pneeddispart) {
		this.pneeddispart = pneeddispart;
	}

	public String getPbuggetform() {
		return pbuggetform;
	}

	public void setPbuggetform(String pbuggetform) {
		this.pbuggetform = pbuggetform;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ArrayList getExamountList() {
		return examountList;
	}

	public void setExamountList(ArrayList examountList) {
		this.examountList = examountList;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public Double getBamount() {
		return bamount;
	}

	public void setBamount(Double bamount) {
		this.bamount = bamount;
	}

	public Float getExamount() {
		return examount;
	}

	public void setExamount(Float examount) {
		this.examount = examount;
	}

}
