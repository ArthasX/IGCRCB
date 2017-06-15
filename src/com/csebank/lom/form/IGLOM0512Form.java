/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.Ginoutstockdetail;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0512Form extends BaseForm implements Ginoutstockdetail{

	private static final long serialVersionUID = 1L;

	protected Integer giodid;
	
	/** ���������(0:��� 1:���� 2:���� 3:����) */
	protected String giodtype;
	
	/** ������������� */
	protected String giodorg;
	
	/** ��Ʒ���� */
	protected String giodcategory;
	
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
	
	/** GStock���� */
	protected Integer gsid;
	
	/** ��Ʒ���� */
	protected String gscategory;
	
	/** ��Ʒ���� */
	protected String gsname;
	
	/** ��Ʒ��� */
	protected String gscode;
	
	/** ������ */
	protected Integer gsnum;
	
	/** ������������� */
	protected String gsorg;
	
	/** �ɹ�ƽ���� */
	protected BigDecimal gsavgprice;
	
	/** �������� */
	protected Integer gsfreezenum;
	
	
	/** ��Ʒ����*/
	protected String[] gcategorys;
	
	/** ��Ʒ����*/
	protected String[] gnames;
	
	/** ��Ʒ���*/
	protected String[] gcodes;
	
	/** ��������*/
	protected Integer[] goinnums;

	/** ���û�������� */
	protected String goorg;
	
	/** ���û�������*/
	protected String goorgname;
	
	/** ������*/
	protected String gorequsername;
	
	/** �ɹ����뵥���*/
	protected String goreqnum;
	
	/** �Ӵ�����ID*/
	protected Integer rid;
	
	protected Integer giodhavocnum;
	
	/** �Ӵ���������*/
	protected String rname;
	
	/** GStock�������� */
	protected Integer[] gsids;
	
	
	
	/**
	 * @return the gsids
	 */
	public Integer[] getGsids() {
		return gsids;
	}

	/**
	 * @param gsids the gsids to set
	 */
	public void setGsids(Integer[] gsids) {
		this.gsids = gsids;
	}

	/**
	 * @return the rname
	 */
	public String getRname() {
		return rname;
	}

	/**
	 * @param rname the rname to set
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

	/**
	 * @return the gsid
	 */
	public Integer getGsid() {
		return gsid;
	}

	/**
	 * @param gsid the gsid to set
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}

	/**
	 * @return the gscategory
	 */
	public String getGscategory() {
		return gscategory;
	}

	/**
	 * @param gscategory the gscategory to set
	 */
	public void setGscategory(String gscategory) {
		this.gscategory = gscategory;
	}

	/**
	 * @return the gsname
	 */
	public String getGsname() {
		return gsname;
	}

	/**
	 * @param gsname the gsname to set
	 */
	public void setGsname(String gsname) {
		this.gsname = gsname;
	}

	/**
	 * @return the gscode
	 */
	public String getGscode() {
		return gscode;
	}

	/**
	 * @param gscode the gscode to set
	 */
	public void setGscode(String gscode) {
		this.gscode = gscode;
	}

	/**
	 * @return the gsnum
	 */
	public Integer getGsnum() {
		return gsnum;
	}

	/**
	 * @param gsnum the gsnum to set
	 */
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}

	/**
	 * @return the gsorg
	 */
	public String getGsorg() {
		return gsorg;
	}

	/**
	 * @param gsorg the gsorg to set
	 */
	public void setGsorg(String gsorg) {
		this.gsorg = gsorg;
	}

	/**
	 * @return the gsavgprice
	 */
	public BigDecimal getGsavgprice() {
		return gsavgprice;
	}

	/**
	 * @param gsavgprice the gsavgprice to set
	 */
	public void setGsavgprice(BigDecimal gsavgprice) {
		this.gsavgprice = gsavgprice;
	}

	/**
	 * @return the gsfreezenum
	 */
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}

	/**
	 * @param gsfreezenum the gsfreezenum to set
	 */
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}

	/**
	 * @return the gcategorys
	 */
	public String[] getGcategorys() {
		return gcategorys;
	}

	/**
	 * @param gcategorys the gcategorys to set
	 */
	public void setGcategorys(String[] gcategorys) {
		this.gcategorys = gcategorys;
	}

	/**
	 * @return the gnames
	 */
	public String[] getGnames() {
		return gnames;
	}

	/**
	 * @param gnames the gnames to set
	 */
	public void setGnames(String[] gnames) {
		this.gnames = gnames;
	}

	/**
	 * @return the gcodes
	 */
	public String[] getGcodes() {
		return gcodes;
	}

	/**
	 * @param gcodes the gcodes to set
	 */
	public void setGcodes(String[] gcodes) {
		this.gcodes = gcodes;
	}

	/**
	 * @return the goinnums
	 */
	public Integer[] getGoinnums() {
		return goinnums;
	}

	/**
	 * @param goinnums the goinnums to set
	 */
	public void setGoinnums(Integer[] goinnums) {
		this.goinnums = goinnums;
	}

	/**
	 * @return the goorg
	 */
	public String getGoorg() {
		return goorg;
	}

	/**
	 * @param goorg the goorg to set
	 */
	public void setGoorg(String goorg) {
		this.goorg = goorg;
	}

	/**
	 * @return the goorgname
	 */
	public String getGoorgname() {
		return goorgname;
	}

	/**
	 * @param goorgname the goorgname to set
	 */
	public void setGoorgname(String goorgname) {
		this.goorgname = goorgname;
	}

	/**
	 * @return the gorequsername
	 */
	public String getGorequsername() {
		return gorequsername;
	}

	/**
	 * @param gorequsername the gorequsername to set
	 */
	public void setGorequsername(String gorequsername) {
		this.gorequsername = gorequsername;
	}

	/**
	 * @return the goreqnum
	 */
	public String getGoreqnum() {
		return goreqnum;
	}

	/**
	 * @param goreqnum the goreqnum to set
	 */
	public void setGoreqnum(String goreqnum) {
		this.goreqnum = goreqnum;
	}

	/**
	 * @return the rid
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getGiodid() {
		return giodid;
	}

	public String getGiodcode() {
		return giodcode;
	}

	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}

	public String getGiodname() {
		return giodname;
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

	public void setGiodname(String giodname) {
		this.giodname = giodname;
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

	public String getFingerPrint() {
		return null;
	}

	public Integer getGiodhavocnum() {
		return giodhavocnum;
	}

	public void setGiodhavocnum(Integer giodhavocnum) {
		this.giodhavocnum = giodhavocnum;
	}

	public Integer getGiodoutnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGioid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getGoid() {
		// TODO Auto-generated method stub
		return null;
	}

}
