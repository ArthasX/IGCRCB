/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0211Form extends BaseForm implements GinoutstockdetailSearchCond{

	private static final long serialVersionUID = -9166241878591311552L;
	
	/** ��Ʒ�������ϸ��ϢID */
	protected Integer giodid;
	
	/** ���������(0:��� 1:���� 2:���� 3:����) */
	protected String giodtype;
	
	/** ������������� */
	protected String giodorg;
	
	/** ��Ʒ���� */
	protected String giodcategory;
	
	/** ��Ʒ�������� */
	protected String giodcategoryname;
	
	
	/** ��Ʒ���� */
	protected String giodname;
	
	/** ��Ʒ��� */
	protected String giodcode;
	
	/** �����ʱ�� */
	protected String giodtime;

	/** �ɹ����뵥���� */
	protected String giodreqnum;

	/** ��ⵥ�� */
	protected BigDecimal giodinprice;

	/** ���ⵥ�� */
	protected BigDecimal giodoutprice;
	
	/** ��������� */
	protected Integer giodinnum;
	
	/** ������λ */
	protected String giodunit;
	
	/** ��Ӧ��*/
	protected String giodprovider;
	
	/** ������*/
	protected String giodpurchaser;

	/** �����۸�*/
	protected BigDecimal giodreliefprice;
	
	/** ��������*/
	protected Integer giodreliefnum;
	
	/** �����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)*/
	protected String giodstatus;
	
	/** ���û���/�������������*/
	protected String giodreqorg;
	
	/** ������/������ID*/
	protected String giodrequser;
	
	/** ������/����������*/
	protected String giodrequsername;
	
	/** �Ǽ���*/
	protected String gioduser;
	
	/** �Ǽ�������*/
	protected String giodusername;
	
	/** ��������*/
	protected Integer giodchknum;
	
	/** ������ID*/
	protected String giodchkid;
	
	/** ����������*/
	protected String giodchkkname;
	
	/**��Ʒ������ϢID */
	protected Integer goid;

	/** ��Ʒ����¼ID */
	protected Integer gioid;
	/** �����ʱ�� */
	protected String giotime_f;
	/** �����ʱ�� */
	protected String giotime_t;
	
	protected Integer[] selectids;
	protected Integer[] giodhavocnums;
	
	/** ˵��*/
	protected String[] goreasons;
	
	/** ˵��*/
	protected String goreason;
	
	

	
	/**
	 * @return the goreason
	 */
	public String getGoreason() {
		return goreason;
	}

	/**
	 * @param goreason the goreason to set
	 */
	public void setGoreason(String goreason) {
		this.goreason = goreason;
	}

	/**
	 * @return the goreasons
	 */
	public String[] getGoreasons() {
		return goreasons;
	}

	/**
	 * @param goreasons the goreasons to set
	 */
	public void setGoreasons(String[] goreasons) {
		this.goreasons = goreasons;
	}
	
	public Integer[] getSelectids() {
		return selectids;
	}
	public void setSelectids(Integer[] selectids) {
		this.selectids = selectids;
	}

	public Integer[] getGiodhavocnums() {
		return giodhavocnums;
	}
	public void setGiodhavocnums(Integer[] giodhavocnums) {
		this.giodhavocnums = giodhavocnums;
	}
	public Integer getGiodid() {
		return giodid;
	}
	public void setGiodid(Integer giodid) {
		this.giodid = giodid;
	}
	public String getGiodtype() {
		return giodtype;
	}
	public void setGiodtype(String giodtype) {
		this.giodtype = giodtype;
	}
	public String getGiodorg() {
		return giodorg;
	}
	public void setGiodorg(String giodorg) {
		this.giodorg = giodorg;
	}
	public String getGiodcategory() {
		return giodcategory;
	}
	public void setGiodcategory(String giodcategory) {
		this.giodcategory = giodcategory;
	}
	public String getGiodname() {
		return giodname;
	}
	public void setGiodname(String giodname) {
		this.giodname = giodname;
	}
	public String getGiodcode() {
		return giodcode;
	}
	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}
	public String getGiodtime() {
		return giodtime;
	}
	public void setGiodtime(String giodtime) {
		this.giodtime = giodtime;
	}
	public String getGiodreqnum() {
		return giodreqnum;
	}
	public void setGiodreqnum(String giodreqnum) {
		this.giodreqnum = giodreqnum;
	}
	public BigDecimal getGiodinprice() {
		return giodinprice;
	}
	public void setGiodinprice(BigDecimal giodinprice) {
		this.giodinprice = giodinprice;
	}
	public BigDecimal getGiodoutprice() {
		return giodoutprice;
	}
	public void setGiodoutprice(BigDecimal giodoutprice) {
		this.giodoutprice = giodoutprice;
	}
	public Integer getGiodinnum() {
		return giodinnum;
	}
	public void setGiodinnum(Integer giodinnum) {
		this.giodinnum = giodinnum;
	}
	public String getGiodunit() {
		return giodunit;
	}
	public void setGiodunit(String giodunit) {
		this.giodunit = giodunit;
	}
	public String getGiodprovider() {
		return giodprovider;
	}
	public void setGiodprovider(String giodprovider) {
		this.giodprovider = giodprovider;
	}
	public String getGiodpurchaser() {
		return giodpurchaser;
	}
	public void setGiodpurchaser(String giodpurchaser) {
		this.giodpurchaser = giodpurchaser;
	}
	public BigDecimal getGiodreliefprice() {
		return giodreliefprice;
	}
	public void setGiodreliefprice(BigDecimal giodreliefprice) {
		this.giodreliefprice = giodreliefprice;
	}
	public Integer getGiodreliefnum() {
		return giodreliefnum;
	}
	public void setGiodreliefnum(Integer giodreliefnum) {
		this.giodreliefnum = giodreliefnum;
	}
	public String getGiodstatus() {
		return giodstatus;
	}
	public void setGiodstatus(String giodstatus) {
		this.giodstatus = giodstatus;
	}
	public String getGiodreqorg() {
		return giodreqorg;
	}
	public void setGiodreqorg(String giodreqorg) {
		this.giodreqorg = giodreqorg;
	}
	public String getGiodrequser() {
		return giodrequser;
	}
	public void setGiodrequser(String giodrequser) {
		this.giodrequser = giodrequser;
	}
	public String getGiodrequsername() {
		return giodrequsername;
	}
	public void setGiodrequsername(String giodrequsername) {
		this.giodrequsername = giodrequsername;
	}
	public String getGioduser() {
		return gioduser;
	}
	public void setGioduser(String gioduser) {
		this.gioduser = gioduser;
	}
	public String getGiodusername() {
		return giodusername;
	}
	public void setGiodusername(String giodusername) {
		this.giodusername = giodusername;
	}
	public Integer getGiodchknum() {
		return giodchknum;
	}
	public void setGiodchknum(Integer giodchknum) {
		this.giodchknum = giodchknum;
	}
	public String getGiodchkid() {
		return giodchkid;
	}
	public void setGiodchkid(String giodchkid) {
		this.giodchkid = giodchkid;
	}
	public String getGiodchkkname() {
		return giodchkkname;
	}
	public void setGiodchkkname(String giodchkkname) {
		this.giodchkkname = giodchkkname;
	}
	public Integer getGoid() {
		return goid;
	}
	public void setGoid(Integer goid) {
		this.goid = goid;
	}
	public Integer getGioid() {
		return gioid;
	}
	public void setGioid(Integer gioid) {
		this.gioid = gioid;
	}
	public String getGiotime_f() {
		return giotime_f;
	}
	public void setGiotime_f(String giotime_f) {
		this.giotime_f = giotime_f;
	}
	public String getGiotime_t() {
		return giotime_t;
	}
	public void setGiotime_t(String giotime_t) {
		this.giotime_t = giotime_t;
	}
	public String getGiodoutype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGiodcategoryname() {
		return giodcategoryname;
	}

	public void setGiodcategoryname(String giodcategoryname) {
		this.giodcategoryname = giodcategoryname;
	}

	
	
}
