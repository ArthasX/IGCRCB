/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.csebank.items.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.csebank.items.model.ItemsPay;

@SuppressWarnings("serial")
@Entity
public class ItemsPayVW implements Serializable, Cloneable, ItemsPay {

	@Id
	protected String reqorg;
	
	protected String orgname;

	protected double notpayment;

	protected double payment;

	public String getReqorg() {
		return reqorg;
	}

	public void setReqorg(String reqorg) {
		this.reqorg = reqorg;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public double getNotpayment() {
		return notpayment;
	}

	public void setNotpayment(double notpayment) {
		this.notpayment = notpayment;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

}
