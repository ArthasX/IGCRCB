/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.lom.form;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0212Form extends BaseForm implements GoutstockSearchCond,GoutstockVWSearchCond{

	private static final long serialVersionUID = -9166241878591311552L;
	
	protected String gcategory;
	
	protected String gcategoryname;
	
	/**��Ʒ������ϢID */
	protected Integer goid;
	
	/** ��������(0:��� 1:���� 2:���� 3:����) */
	protected String gotype;
	
	/** ������������� */
	protected String goorg;
	
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
	
	protected Integer[] selectids;
	
	/** �Ƿ�����Ʒcode*/
	protected boolean hascategory;
	
	/** ˵��*/
	protected String goreason;
	
	/** �������ͼ��� */
	protected List<String> gotypeList;


	
	
	/** ��Ʒ�������ϸ��ϢID */
	protected Integer giodid;
	
	/** ��������� */
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
	
	/** �����״̬ */
	protected String giodstatus;

	/** ��Ʒ�����ϢID */
	protected Integer gsid;
	
	/** ������ */
	protected Integer gsnum;
	
	/** ������������� */
	protected String gsorg;
	
	/** �ɹ�ƽ���� */
	protected BigDecimal gsavgprice;
	
	/** �������� */
	protected Integer gsfreezenum;
	
	/**
	 * ��Ʒ�������ϸ��ϢIDȡ��
	 * @return ��Ʒ�������ϸ��ϢID
	 */
	public Integer getGiodid() {
		return giodid;
	}


	/**
	 * ��Ʒ�������ϸ��ϢID�趨
	 * @param giodid ��Ʒ�������ϸ��ϢID
	 */
	public void setGiodid(Integer giodid) {
		this.giodid = giodid;
	}

	/**
	 * ���������ȡ��
	 * @return ��������� 
	 */
	public String getGiodtype() {
		return giodtype;
	}


	/**
	 * ����������趨
	 * @param giodtype ��������� 
	 */
	public void setGiodtype(String giodtype) {
		this.giodtype = giodtype;
	}

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGiodorg() {
		return giodorg;
	}

	/**
	 * ��������������趨
	 * @param giodorg �������������
	 */
	public void setGiodorg(String giodorg) {
		this.giodorg = giodorg;
	}

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGiodcategory() {
		return giodcategory;
	}

	/**
	 * ��Ʒ�����趨
	 * @param giodcategory ��Ʒ����
	 */
	public void setGiodcategory(String giodcategory) {
		this.giodcategory = giodcategory;
	}

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGiodname() {
		return giodname;
	}

	/**
	 * ��Ʒ�����趨
	 * @param giodname ��Ʒ����
	 */
	public void setGiodname(String giodname) {
		this.giodname = giodname;
	}

	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGiodcode() {
		return giodcode;
	}

	/**
	 * ��Ʒ����趨
	 * @param giodcode ��Ʒ���
	 */
	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}

	/**
	 * �����ʱ��ȡ��
	 * @return �����ʱ��
	 */
	public String getGiodtime() {
		return giodtime;
	}

	/**
	 * �����ʱ���趨
	 * @param giodtime �����ʱ��
	 */
	public void setGiodtime(String giodtime) {
		this.giodtime = giodtime;
	}

	/**
	 * �ɹ����뵥����ȡ��
	 * @return �ɹ����뵥����
	 */
	public String getGiodreqnum() {
		return giodreqnum;
	}

	/**
	 * �ɹ����뵥�����趨
	 * @param giodreqnum �ɹ����뵥����
	 */
	public void setGiodreqnum(String giodreqnum) {
		this.giodreqnum = giodreqnum;
	}

	/**
	 * �����״̬ȡ��
	 * @return �����״̬
	 */
	public String getGiodstatus() {
		return giodstatus;
	}

	/**
	 * �����״̬�趨
	 * @param giodstatus �����״̬
	 */
	public void setGiodstatus(String giodstatus) {
		this.giodstatus = giodstatus;
	}

	
	/**
	 * ��Ʒ�����ϢIDȡ��
	 * @return ��Ʒ�����ϢID
	 */
	public Integer getGsid() {
		return gsid;
	}
	/**
	 * ��Ʒ�����ϢID
	 * @param gsid ��Ʒ�����ϢID
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public Integer getGsnum() {
		return gsnum;
	}
	/**
	 * ������
	 * @param ������
	 */
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGsorg() {
		return gsorg;
	}
	/**
	 * �������������
	 * @param �������������
	 */
	public void setGsorg(String gsorg) {
		this.gsorg = gsorg;
	}
	/**
	 * �ɹ�ƽ����ȡ��
	 * @return �ɹ�ƽ����
	 */
	public BigDecimal getGsavgprice() {
		return gsavgprice;
	}
	/**
	 * �ɹ�ƽ����
	 * @param ���ɹ�ƽ����
	 */
	public void setGsavgprice(BigDecimal gsavgprice) {
		this.gsavgprice = gsavgprice;
	}
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}
	/**
	 * ��������
	 * @param ��������
	 */
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}

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
	 * ˵��ȡ��
	 * @return ˵��
	 */
	public String getGoreason() {
		return goreason;
	}


	/**
	 * ˵���趨
	 * @param goreason ˵��
	 */
	public void setGoreason(String goreason) {
		this.goreason = goreason;
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
	public Integer[] getSelectids() {
		return selectids;
	}

	public void setSelectids(Integer[] selectids) {
		this.selectids = selectids;
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
		// TODO Auto-generated method stub
		return null;
	}

	public String getGotime_t() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGcategory() {
		return gcategory;
	}

	public void setGcategory(String gcategory) {
		this.gcategory = gcategory;
	}

	public String getGcategoryname() {
		return gcategoryname;
	}

	public void setGcategoryname(String gcategoryname) {
		this.gcategoryname = gcategoryname;
	}

	
	
}
