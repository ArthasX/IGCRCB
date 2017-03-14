/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.prj.model.Pbsummary;


/**
 * <p>����:Ԥ�㼰���̷�����Ϣ��ͼʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */

@SuppressWarnings("serial")
@Entity
@Table(name="PbsummaryVW")

public class PbsummaryVW implements Serializable,Cloneable, Pbsummary {
	/** ����*/
	@Id
	protected Integer pbrid;
	
	/** Ԥ���ID*/
	protected Integer bid;
	
	/** Ԥ������*/
	protected String btype;
	
	/** Ԥ��״̬*/
	protected String bstatus;
	
	/** Ԥ������*/
	protected String btitle;
	
	/** Ԥ����*/
	protected String bdesc;
	
	/** Ԥ�����*/
	protected String byear;
	
	/** Ԥ���ܶ�*/
	protected Double bamount;
	
	/** Ԥ������*/
	protected String pquality;	

	/** Ԥ�㴢��Ԥ����*/
	protected String pstorecode;
	
	/** Ԥ��������*/
	protected String pneeddispart;
	
	/** Ԥ�����*/
	protected String pbuggetform;
	
	/** Ԥ����;*/
	protected String puse;
	
	/** Ԥ�㱸ע*/
	protected String remark;
	
	/** �ʱ��𿪷�Ԥ���ܶ�*/
	protected float total1;

	/** �ʱ���Ӳ��Ԥ���ܶ�*/
	protected float total2;

	/** �ʱ������Ԥ���ܶ�*/
	protected float total3;
	
	/** �ʱ��𹤳�Ԥ���ܶ�*/
	protected float total4;
	
	/** �ʱ�������Ԥ���ܶ�*/
	protected float total5;

	/** �ɱ���ʵʩԤ���ܶ�*/
	protected float total6;
	
	/** �ɱ�������Ԥ���ܶ�*/
	protected float total7;
	
	/** �ʱ��𿪷���ʹ���ܶ�*/
	protected float totaluse1;

	/** �ʱ���Ӳ����ʹ���ܶ�*/
	protected float totaluse2;

	/** �ʱ��������ʹ���ܶ�*/
	protected float totaluse3;
	
	/** �ʱ��𹤳���ʹ���ܶ�*/
	protected float totaluse4;
	
	/** �ʱ���������ʹ���ܶ�*/
	protected float totaluse5;

	/** �ɱ���ʵʩ��ʹ���ܶ�*/
	protected float totaluse6;
	
	/** �ɱ���������ʹ���ܶ�*/
	protected float totaluse7;
	
	/** �ʱ��𿪷�ʣ���ܶ�*/
	protected float sub1;

	/** �ʱ���Ӳ��ʣ���ܶ�*/
	protected float sub2;

	/** �ʱ������ʣ���ܶ�*/
	protected float sub3;
	
	/** �ʱ��𹤳�ʣ���ܶ�*/
	protected float sub4;
	
	/** �ʱ�������ʣ���ܶ�*/
	protected float sub5;

	/** �ɱ���ʵʩʣ���ܶ�*/
	protected float sub6;
	
	/** �ɱ�������ʣ���ܶ�*/
	protected float sub7;
	
	/** �ʱ��𿪷�����Ԥ��ʹ�ö�*/
	protected float use1;

	/** �ʱ���Ӳ������Ԥ��ʹ�ö�*/
	protected float use2;

	/** �ʱ����������Ԥ��ʹ�ö�*/
	protected float use3;
	
	/** �ʱ��𹤳̵���Ԥ��ʹ�ö�*/
	protected float use4;
	
	/** �ʱ�����������Ԥ��ʹ�ö�*/
	protected float use5;

	/** �ɱ���ʵʩ����Ԥ��ʹ�ö�*/
	protected float use6;
	
	/** �ɱ�����������Ԥ��ʹ�ö�*/
	protected float use7;
	
	/** ��ĿID*/
	protected Integer pid;
	
	/** Ԥ����Ŀ��ϵ��ID*/
	protected Integer pbid;
	
	public boolean equals(Object obj) {
		if (!(obj instanceof PbsummaryVW))
			return false;
		Pbsummary target = (Pbsummary) obj;
		if (!(getPbrid().equals(target.getPbrid())))
			return false;
		return true;
	}
	
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getPbrid() {
		return pbrid;
	}

	/**
	 * ��������
	 * @param pbrid  ����
	 */
	public void setPbrid(Integer pbrid) {
		this.pbrid = pbrid;
	}

	/**
	 * ��ȡԤ���ID
	 * @return Ԥ���ID
	 */
	public Integer getBid() {
		return bid;
	}

	/**
	 * ����Ԥ���ID
	 * @param bid  Ԥ���ID
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}

	/**
	 * ��ȡԤ������
	 * @return Ԥ������
	 */
	public String getBtype() {
		return btype;
	}

	/**
	 * ����Ԥ������
	 * @param btype  Ԥ������
	 */
	public void setBtype(String btype) {
		this.btype = btype;
	}

	/**
	 * ��ȡԤ��״̬
	 * @return Ԥ��״̬
	 */
	public String getBstatus() {
		return bstatus;
	}

	/**
	 * ����Ԥ��״̬
	 * @param bstatus  Ԥ��״̬
	 */
	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	/**
	 * ��ȡԤ������
	 * @return Ԥ������
	 */
	public String getBtitle() {
		return btitle;
	}

	/**
	 * ����Ԥ������
	 * @param btitle  Ԥ������
	 */
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	/**
	 * ��ȡԤ����
	 * @return Ԥ����
	 */
	public String getBdesc() {
		return bdesc;
	}

	/**
	 * ����Ԥ����
	 * @param bdesc  Ԥ����
	 */
	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}

	/**
	 * ��ȡԤ�����
	 * @return Ԥ�����
	 */
	public String getByear() {
		return byear;
	}

	/**
	 * ����Ԥ�����
	 * @param byear  Ԥ�����
	 */
	public void setByear(String byear) {
		this.byear = byear;
	}

	/**
	 * ��ȡԤ���ܶ�
	 * @return Ԥ���ܶ�
	 */
	public Double getBamount() {
		return bamount;
	}

	/**
	 * ����Ԥ���ܶ�
	 * @param bamount  Ԥ���ܶ�
	 */
	public void setBamount(Double bamount) {
		this.bamount = bamount;
	}

	/**
	 * ��ȡԤ������
	 * @return Ԥ������
	 */
	public String getPquality() {
		return pquality;
	}

	/**
	 * ����Ԥ������
	 * @param pquality  Ԥ������
	 */
	public void setPquality(String pquality) {
		this.pquality = pquality;
	}

	/**
	 * ��ȡԤ�㴢��Ԥ����
	 * @return Ԥ�㴢��Ԥ����
	 */
	public String getPstorecode() {
		return pstorecode;
	}

	/**
	 * ����Ԥ�㴢��Ԥ����
	 * @param pstorecode  Ԥ�㴢��Ԥ����
	 */
	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}

	/**
	 * ��ȡԤ��������
	 * @return Ԥ��������
	 */
	public String getPneeddispart() {
		return pneeddispart;
	}

	/**
	 * ����Ԥ��������
	 * @param pneeddispart  Ԥ��������
	 */
	public void setPneeddispart(String pneeddispart) {
		this.pneeddispart = pneeddispart;
	}

	/**
	 * ��ȡԤ�����
	 * @return Ԥ�����
	 */
	public String getPbuggetform() {
		return pbuggetform;
	}

	/**
	 * ����Ԥ�����
	 * @param pbuggetform  Ԥ�����
	 */
	public void setPbuggetform(String pbuggetform) {
		this.pbuggetform = pbuggetform;
	}

	/**
	 * ��ȡԤ����;
	 * @return Ԥ����;
	 */
	public String getPuse() {
		return puse;
	}

	/**
	 * ����Ԥ����;
	 * @param puse  Ԥ����;
	 */
	public void setPuse(String puse) {
		this.puse = puse;
	}

	/**
	 * ��ȡԤ�㱸ע
	 * @return Ԥ�㱸ע
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ����Ԥ�㱸ע
	 * @param remark  Ԥ�㱸ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * ��ȡ�ʱ��𿪷�Ԥ���ܶ�
	 * @return �ʱ��𿪷�Ԥ���ܶ�
	 */
	public float getTotal1() {
		return total1;
	}

	/**
	 * �����ʱ��𿪷�Ԥ���ܶ�
	 * @param total1  �ʱ��𿪷�Ԥ���ܶ�
	 */
	public void setTotal1(float total1) {
		this.total1 = total1;
	}

	/**
	 * ��ȡ�ʱ���Ӳ��Ԥ���ܶ�
	 * @return �ʱ���Ӳ��Ԥ���ܶ�
	 */
	public float getTotal2() {
		return total2;
	}

	/**
	 * �����ʱ���Ӳ��Ԥ���ܶ�
	 * @param total2  �ʱ���Ӳ��Ԥ���ܶ�
	 */
	public void setTotal2(float total2) {
		this.total2 = total2;
	}

	/**
	 * ��ȡ�ʱ������Ԥ���ܶ�
	 * @return �ʱ������Ԥ���ܶ�
	 */
	public float getTotal3() {
		return total3;
	}

	/**
	 * �����ʱ������Ԥ���ܶ�
	 * @param total3  �ʱ������Ԥ���ܶ�
	 */
	public void setTotal3(float total3) {
		this.total3 = total3;
	}

	/**
	 * ��ȡ�ʱ��𹤳�Ԥ���ܶ�
	 * @return �ʱ��𹤳�Ԥ���ܶ�
	 */
	public float getTotal4() {
		return total4;
	}

	/**
	 * �����ʱ��𹤳�Ԥ���ܶ�
	 * @param total4  �ʱ��𹤳�Ԥ���ܶ�
	 */
	public void setTotal4(float total4) {
		this.total4 = total4;
	}

	/**
	 * ��ȡ�ʱ�������Ԥ���ܶ�
	 * @return �ʱ�������Ԥ���ܶ�
	 */
	public float getTotal5() {
		return total5;
	}

	/**
	 * �����ʱ�������Ԥ���ܶ�
	 * @param total5  �ʱ�������Ԥ���ܶ�
	 */
	public void setTotal5(float total5) {
		this.total5 = total5;
	}

	/**
	 * ��ȡ�ɱ���ʵʩԤ���ܶ�
	 * @return �ɱ���ʵʩԤ���ܶ�
	 */
	public float getTotal6() {
		return total6;
	}

	/**
	 * ���óɱ���ʵʩԤ���ܶ�
	 * @param total6  �ɱ���ʵʩԤ���ܶ�
	 */
	public void setTotal6(float total6) {
		this.total6 = total6;
	}

	/**
	 * ��ȡ�ɱ�������Ԥ���ܶ�
	 * @return �ɱ�������Ԥ���ܶ�
	 */
	public float getTotal7() {
		return total7;
	}

	/**
	 * ���óɱ�������Ԥ���ܶ�
	 * @param total7  �ɱ�������Ԥ���ܶ�
	 */
	public void setTotal7(float total7) {
		this.total7 = total7;
	}

	/**
	 * ��ȡ�ʱ��𿪷���ʹ���ܶ�
	 * @return �ʱ��𿪷���ʹ���ܶ�
	 */
	public float getTotaluse1() {
		return totaluse1;
	}

	/**
	 * �����ʱ��𿪷���ʹ���ܶ�
	 * @param totaluse1  �ʱ��𿪷���ʹ���ܶ�
	 */
	public void setTotaluse1(float totaluse1) {
		this.totaluse1 = totaluse1;
	}

	/**
	 * ��ȡ�ʱ���Ӳ����ʹ���ܶ�
	 * @return �ʱ���Ӳ����ʹ���ܶ�
	 */
	public float getTotaluse2() {
		return totaluse2;
	}

	/**
	 * �����ʱ���Ӳ����ʹ���ܶ�
	 * @param totaluse2  �ʱ���Ӳ����ʹ���ܶ�
	 */
	public void setTotaluse2(float totaluse2) {
		this.totaluse2 = totaluse2;
	}

	/**
	 * ��ȡ�ʱ��������ʹ���ܶ�
	 * @return �ʱ��������ʹ���ܶ�
	 */
	public float getTotaluse3() {
		return totaluse3;
	}

	/**
	 * �����ʱ��������ʹ���ܶ�
	 * @param totaluse3  �ʱ��������ʹ���ܶ�
	 */
	public void setTotaluse3(float totaluse3) {
		this.totaluse3 = totaluse3;
	}

	/**
	 * ��ȡ�ʱ��𹤳���ʹ���ܶ�
	 * @return �ʱ��𹤳���ʹ���ܶ�
	 */
	public float getTotaluse4() {
		return totaluse4;
	}

	/**
	 * �����ʱ��𹤳���ʹ���ܶ�
	 * @param totaluse4  �ʱ��𹤳���ʹ���ܶ�
	 */
	public void setTotaluse4(float totaluse4) {
		this.totaluse4 = totaluse4;
	}

	/**
	 * ��ȡ�ʱ���������ʹ���ܶ�
	 * @return �ʱ���������ʹ���ܶ�
	 */
	public float getTotaluse5() {
		return totaluse5;
	}

	/**
	 * �����ʱ���������ʹ���ܶ�
	 * @param totaluse5  �ʱ���������ʹ���ܶ�
	 */
	public void setTotaluse5(float totaluse5) {
		this.totaluse5 = totaluse5;
	}

	/**
	 * ��ȡ�ɱ���ʵʩ��ʹ���ܶ�
	 * @return �ɱ���ʵʩ��ʹ���ܶ�
	 */
	public float getTotaluse6() {
		return totaluse6;
	}

	/**
	 * ���óɱ���ʵʩ��ʹ���ܶ�
	 * @param totaluse6  �ɱ���ʵʩ��ʹ���ܶ�
	 */
	public void setTotaluse6(float totaluse6) {
		this.totaluse6 = totaluse6;
	}

	/**
	 * ��ȡ�ɱ���������ʹ���ܶ�
	 * @return �ɱ���������ʹ���ܶ�
	 */
	public float getTotaluse7() {
		return totaluse7;
	}

	/**
	 * ���óɱ���������ʹ���ܶ�
	 * @param totaluse7  �ɱ���������ʹ���ܶ�
	 */
	public void setTotaluse7(float totaluse7) {
		this.totaluse7 = totaluse7;
	}

	/**
	 * ��ȡ�ʱ��𿪷�ʣ���ܶ�
	 * @return �ʱ��𿪷�ʣ���ܶ�
	 */
	public float getSub1() {
		return sub1;
	}

	/**
	 * �����ʱ��𿪷�ʣ���ܶ�
	 * @param sub1  �ʱ��𿪷�ʣ���ܶ�
	 */
	public void setSub1(float sub1) {
		this.sub1 = sub1;
	}

	/**
	 * ��ȡ�ʱ���Ӳ��ʣ���ܶ�
	 * @return �ʱ���Ӳ��ʣ���ܶ�
	 */
	public float getSub2() {
		return sub2;
	}

	/**
	 * �����ʱ���Ӳ��ʣ���ܶ�
	 * @param sub2  �ʱ���Ӳ��ʣ���ܶ�
	 */
	public void setSub2(float sub2) {
		this.sub2 = sub2;
	}

	/**
	 * ��ȡ�ʱ������ʣ���ܶ�
	 * @return �ʱ������ʣ���ܶ�
	 */
	public float getSub3() {
		return sub3;
	}

	/**
	 * �����ʱ������ʣ���ܶ�
	 * @param sub3  �ʱ������ʣ���ܶ�
	 */
	public void setSub3(float sub3) {
		this.sub3 = sub3;
	}

	/**
	 * ��ȡ�ʱ��𹤳�ʣ���ܶ�
	 * @return �ʱ��𹤳�ʣ���ܶ�
	 */
	public float getSub4() {
		return sub4;
	}

	/**
	 * �����ʱ��𹤳�ʣ���ܶ�
	 * @param sub4  �ʱ��𹤳�ʣ���ܶ�
	 */
	public void setSub4(float sub4) {
		this.sub4 = sub4;
	}

	/**
	 * ��ȡ�ʱ�������ʣ���ܶ�
	 * @return �ʱ�������ʣ���ܶ�
	 */
	public float getSub5() {
		return sub5;
	}

	/**
	 * �����ʱ�������ʣ���ܶ�
	 * @param sub5  �ʱ�������ʣ���ܶ�
	 */
	public void setSub5(float sub5) {
		this.sub5 = sub5;
	}

	/**
	 * ��ȡ�ɱ���ʵʩʣ���ܶ�
	 * @return �ɱ���ʵʩʣ���ܶ�
	 */
	public float getSub6() {
		return sub6;
	}

	/**
	 * ���óɱ���ʵʩʣ���ܶ�
	 * @param sub6  �ɱ���ʵʩʣ���ܶ�
	 */
	public void setSub6(float sub6) {
		this.sub6 = sub6;
	}

	/**
	 * ��ȡ�ɱ�������ʣ���ܶ�
	 * @return �ɱ�������ʣ���ܶ�
	 */
	public float getSub7() {
		return sub7;
	}

	/**
	 * ���óɱ�������ʣ���ܶ�
	 * @param sub7  �ɱ�������ʣ���ܶ�
	 */
	public void setSub7(float sub7) {
		this.sub7 = sub7;
	}

	/**
	 * ��ȡ�ʱ��𿪷�����Ԥ��ʹ�ö�
	 * @return �ʱ��𿪷�����Ԥ��ʹ�ö�
	 */
	public float getUse1() {
		return use1;
	}

	/**
	 * �����ʱ��𿪷�����Ԥ��ʹ�ö�
	 * @param use1  �ʱ��𿪷�����Ԥ��ʹ�ö�
	 */
	public void setUse1(float use1) {
		this.use1 = use1;
	}

	/**
	 * ��ȡ�ʱ���Ӳ������Ԥ��ʹ�ö�
	 * @return �ʱ���Ӳ������Ԥ��ʹ�ö�
	 */
	public float getUse2() {
		return use2;
	}

	/**
	 * �����ʱ���Ӳ������Ԥ��ʹ�ö�
	 * @param use2  �ʱ���Ӳ������Ԥ��ʹ�ö�
	 */
	public void setUse2(float use2) {
		this.use2 = use2;
	}

	/**
	 * ��ȡ�ʱ����������Ԥ��ʹ�ö�
	 * @return �ʱ����������Ԥ��ʹ�ö�
	 */
	public float getUse3() {
		return use3;
	}

	/**
	 * �����ʱ����������Ԥ��ʹ�ö�
	 * @param use3  �ʱ����������Ԥ��ʹ�ö�
	 */
	public void setUse3(float use3) {
		this.use3 = use3;
	}

	/**
	 * ��ȡ�ʱ��𹤳̵���Ԥ��ʹ�ö�
	 * @return �ʱ��𹤳̵���Ԥ��ʹ�ö�
	 */
	public float getUse4() {
		return use4;
	}

	/**
	 * �����ʱ��𹤳̵���Ԥ��ʹ�ö�
	 * @param use4  �ʱ��𹤳̵���Ԥ��ʹ�ö�
	 */
	public void setUse4(float use4) {
		this.use4 = use4;
	}

	/**
	 * ��ȡ�ʱ�����������Ԥ��ʹ�ö�
	 * @return �ʱ�����������Ԥ��ʹ�ö�
	 */
	public float getUse5() {
		return use5;
	}

	/**
	 * �����ʱ�����������Ԥ��ʹ�ö�
	 * @param use5  �ʱ�����������Ԥ��ʹ�ö�
	 */
	public void setUse5(float use5) {
		this.use5 = use5;
	}

	/**
	 * ��ȡ�ɱ���ʵʩ����Ԥ��ʹ�ö�
	 * @return �ɱ���ʵʩ����Ԥ��ʹ�ö�
	 */
	public float getUse6() {
		return use6;
	}

	/**
	 * ���óɱ���ʵʩ����Ԥ��ʹ�ö�
	 * @param use6  �ɱ���ʵʩ����Ԥ��ʹ�ö�
	 */
	public void setUse6(float use6) {
		this.use6 = use6;
	}

	/**
	 * ��ȡ�ɱ�����������Ԥ��ʹ�ö�
	 * @return �ɱ�����������Ԥ��ʹ�ö�
	 */
	public float getUse7() {
		return use7;
	}

	/**
	 * ���óɱ�����������Ԥ��ʹ�ö�
	 * @param use7  �ɱ�����������Ԥ��ʹ�ö�
	 */
	public void setUse7(float use7) {
		this.use7 = use7;
	}

	/**
	 * ��ȡ��ĿID
	 * @return ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ������ĿID
	 * @param pid  ��ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * ��ȡԤ����Ŀ��ϵ��ID
	 * @return Ԥ����Ŀ��ϵ��ID
	 */
	public Integer getPbid() {
		return pbid;
	}

	/**
	 * ����Ԥ����Ŀ��ϵ��ID
	 * @param pbid  Ԥ����Ŀ��ϵ��ID
	 */
	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}
}
