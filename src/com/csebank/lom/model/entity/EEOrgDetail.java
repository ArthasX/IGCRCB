/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.Eentertainment;


/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ���д����Ż�����ϸʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class EEOrgDetail implements Serializable, Cloneable, Eentertainment {
	@Id
	/** �������������� */
	protected Integer eeid;
	
	/** �Ӵ�����ID */
	protected Integer rid;
	
	/** ������ */
	protected String eeuser;
	
	/** ÿ���˼۸� */
	protected BigDecimal eetableprice;
	
	/** ���� */
	protected Integer eetablenum;
	
	/** �Ƽ� */
	protected BigDecimal eedrinkprice;
	
	/** �̼� */
	protected BigDecimal eesmokeprice;
	
	/** ������Ʒ�۸� */
	protected BigDecimal eeotherprice;
	protected String rname;
	protected String orgname;
	
	/** ���� */
	protected String eedate;
	
	//protected RecptionTB recptionTB;

	public Integer getEeid() {
		return eeid;
	}

	public void setEeid(Integer eeid) {
		this.eeid = eeid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getEeuser() {
		return eeuser;
	}

	public void setEeuser(String eeuser) {
		this.eeuser = eeuser;
	}

	public BigDecimal getEetableprice() {
		return eetableprice;
	}

	public void setEetableprice(BigDecimal eetableprice) {
		this.eetableprice = eetableprice;
	}

	public Integer getEetablenum() {
		return eetablenum;
	}

	public void setEetablenum(Integer eetablenum) {
		this.eetablenum = eetablenum;
	}

	public BigDecimal getEedrinkprice() {
		return eedrinkprice;
	}

	public void setEedrinkprice(BigDecimal eedrinkprice) {
		this.eedrinkprice = eedrinkprice;
	}

	public BigDecimal getEesmokeprice() {
		return eesmokeprice;
	}

	public void setEesmokeprice(BigDecimal eesmokeprice) {
		this.eesmokeprice = eesmokeprice;
	}

	public BigDecimal getEeotherprice() {
		return eeotherprice;
	}

	public void setEeotherprice(BigDecimal eeotherprice) {
		this.eeotherprice = eeotherprice;
	}

	public String getEedate() {
		return eedate;
	}

	public void setEedate(String eedate) {
		this.eedate = eedate;
	}

//	public RecptionTB getRecptionTB() {
//		return recptionTB;
//	}
//
//	public void setRecptionTB(RecptionTB recptionTB) {
//		this.recptionTB = recptionTB;
//	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public RecptionTB getRecptionTB() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	






}
