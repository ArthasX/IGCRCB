/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.lom.form;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0217Form extends BaseForm implements GoutstockSearchCond{

	private static final long serialVersionUID = -9166241878591311552L;
	
	/**��Ʒ������ϢID */
	protected Integer goid;
	
	/** ��������(0:��� 1:���� 2:���� 3:����) */
	protected String gotype;
	
	/** ������������� */
	protected String goorg;
	
	/** ������������ */
	protected String goorgname;
	
	/** ��Ʒ���� */
	protected String gocategory;
	
	/** ��Ʒ���� */
	protected String goname;
	
	/** ��Ʒ��� */
	protected String gocode;
	
	/** ����ʱ�� */
	protected String gotime;

	/** �ɹ����뵥���� */
	protected String goreqnum;

	/** ���ⵥ�� */
	protected BigDecimal gooutprice;
	
	/** �������� */
	protected Integer goinnum;
	
	/** ������λ */
	protected String gounit;
	
	/** ��Ӧ��*/
	protected String goprovider;
	
	/** ������*/
	protected String gopurchaser;

	/** �����۸�*/
	protected BigDecimal goreliefprice;
	
	/** ��������*/
	protected Integer goreliefnum;
	
	/** ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)*/
	protected String gostatus;
	
	/** ���û���/�������������*/
	protected String goreqorg;
	
	/** ������/������ID*/
	protected String gorequser;
	
	/** ������/����������*/
	protected String gorequsername;
	
	/** �Ǽ���*/
	protected String gouser;
	
	/** �Ǽ�������*/
	protected String gousername;
	
	/** ��������*/
	protected Integer gochknum;
	
	/** ������ID*/
	protected String gochkid;
	
	/** ����������*/
	protected String gochkkname;
	
	protected String gotime_f;
	
	protected String gotime_t;
	
	/** �Ƿ�����Ʒcode*/
	protected boolean hascategory;

	/** �������ͼ��� */
	protected List<String> gotypeList;


	
	/**
	 * @return the gotypeList
	 */
	public List<String> getGotypeList() {
		return gotypeList;
	}

	/**
	 * @param gotypeList the gotypeList to set
	 */
	public void setGotypeList(List<String> gotypeList) {
		this.gotypeList = gotypeList;
	}

	/**
	 * @return the hascategory
	 */
	public boolean isHascategory() {
		return hascategory;
	}
	
	/**
	 * @param hascategory to set
	 */
	public void setHascategory(boolean hascategory) {
		this.hascategory = hascategory;
	}
	public Integer getGoid() {
		return goid;
	}

	public void setGoid(Integer goid) {
		this.goid = goid;
	}

	public String getGotype() {
		return gotype;
	}

	public void setGotype(String gotype) {
		this.gotype = gotype;
	}

	public String getGoorg() {
		return goorg;
	}

	public void setGoorg(String goorg) {
		this.goorg = goorg;
	}

	public String getGocategory() {
		return gocategory;
	}

	public void setGocategory(String gocategory) {
		this.gocategory = gocategory;
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

	public String getGotime() {
		return gotime;
	}

	public void setGotime(String gotime) {
		this.gotime = gotime;
	}

	public String getGoreqnum() {
		return goreqnum;
	}

	public void setGoreqnum(String goreqnum) {
		this.goreqnum = goreqnum;
	}

	public BigDecimal getGooutprice() {
		return gooutprice;
	}

	public void setGooutprice(BigDecimal gooutprice) {
		this.gooutprice = gooutprice;
	}

	public Integer getGoinnum() {
		return goinnum;
	}

	public void setGoinnum(Integer goinnum) {
		this.goinnum = goinnum;
	}

	public String getGounit() {
		return gounit;
	}

	public void setGounit(String gounit) {
		this.gounit = gounit;
	}

	public String getGoprovider() {
		return goprovider;
	}

	public void setGoprovider(String goprovider) {
		this.goprovider = goprovider;
	}

	public String getGopurchaser() {
		return gopurchaser;
	}

	public void setGopurchaser(String gopurchaser) {
		this.gopurchaser = gopurchaser;
	}

	public BigDecimal getGoreliefprice() {
		return goreliefprice;
	}

	public void setGoreliefprice(BigDecimal goreliefprice) {
		this.goreliefprice = goreliefprice;
	}

	public Integer getGoreliefnum() {
		return goreliefnum;
	}

	public void setGoreliefnum(Integer goreliefnum) {
		this.goreliefnum = goreliefnum;
	}

	public String getGostatus() {
		return gostatus;
	}

	public void setGostatus(String gostatus) {
		this.gostatus = gostatus;
	}

	public String getGoreqorg() {
		return goreqorg;
	}

	public void setGoreqorg(String goreqorg) {
		this.goreqorg = goreqorg;
	}

	public String getGorequser() {
		return gorequser;
	}

	public void setGorequser(String gorequser) {
		this.gorequser = gorequser;
	}

	public String getGorequsername() {
		return gorequsername;
	}

	public void setGorequsername(String gorequsername) {
		this.gorequsername = gorequsername;
	}

	public String getGouser() {
		return gouser;
	}

	public void setGouser(String gouser) {
		this.gouser = gouser;
	}

	public String getGousername() {
		return gousername;
	}

	public void setGousername(String gousername) {
		this.gousername = gousername;
	}

	public Integer getGochknum() {
		return gochknum;
	}

	public void setGochknum(Integer gochknum) {
		this.gochknum = gochknum;
	}

	public String getGochkid() {
		return gochkid;
	}

	public void setGochkid(String gochkid) {
		this.gochkid = gochkid;
	}

	public String getGochkkname() {
		return gochkkname;
	}

	public void setGochkkname(String gochkkname) {
		this.gochkkname = gochkkname;
	}

	public String getGotime_f() {
		return gotime_f;
	}

	public void setGotime_f(String gotime_f) {
		this.gotime_f = gotime_f;
	}

	public String getGotime_t() {
		return gotime_t;
	}

	public void setGotime_t(String gotime_t) {
		this.gotime_t = gotime_t;
	}

	public Integer getRid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoorgname() {
		return goorgname;
	}

	public void setGoorgname(String goorgname) {
		this.goorgname = goorgname;
	}
	
	

}
