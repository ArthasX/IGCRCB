/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;



/**
 * 
 * ��Ʒ�������ϸ��Ϣ��ѯ�ӿ�ʵ��
 *
 */
public class GinoutstockdetailSearchCondImpl implements GinoutstockdetailSearchCond {
	
	/** ��Ʒ�������ϸ��ϢID */
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

//	/** ���ⵥ�� */
//	protected BigDecimal giodoutprice;
	
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
	
	protected String giodoutype;
	
	public String getGiodoutype() {
		return giodoutype;
	}


	public void setGiodoutype(String giodoutype) {
		this.giodoutype = giodoutype;
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


	/**
	 * ��Ʒ�������ϸ��ϢIDȡ��
	 * @return ��Ʒ�������ϸ��ϢID
	 */
	public Integer getGiodid() {
		return giodid;
	}


	/**
	 * ��Ʒ����¼IDȡ��
	 * @return ��Ʒ����¼ID
	 */
	public Integer getGioid() {
		return gioid;
	}




	/**
	 * ��Ʒ����¼ID�趨
	 * @param gioid ��Ʒ����¼ID
	 */
	public void setGioid(Integer gioid) {
		this.gioid = gioid;
	}


	/**
	 * ��Ʒ�������ϸ��ϢID�趨
	 * @param giodid ��Ʒ�������ϸ��ϢID
	 */
	public void setGiodid(Integer giodid) {
		this.giodid = giodid;
	}




	/**
	 * ���������(0:��� 1:���� 2:���� 3:����)ȡ��
	 * @return ���������(0:��� 1:���� 2:���� 3:����)
	 */
	public String getGiodtype() {
		return giodtype;
	}




	/**
	 * ���������(0:��� 1:���� 2:���� 3:����)�趨
	 * @param giodtype ���������(0:��� 1:���� 2:���� 3:����)
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
	 * ��ⵥ��ȡ��
	 * @return ��ⵥ��
	 */
	public BigDecimal getGiodinprice() {
		return giodinprice;
	}




	/**
	 * ��ⵥ���趨
	 * @param giodinprice ��ⵥ��
	 */
	public void setGiodinprice(BigDecimal giodinprice) {
		this.giodinprice = giodinprice;
	}




//	/**
//	 * ���ⵥ��ȡ��
//	 * @return ���ⵥ��
//	 */
//	public BigDecimal getGiodoutprice() {
//		return giodoutprice;
//	}
//
//
//
//
//	/**
//	 * ���ⵥ���趨
//	 * @param giodoutprice ���ⵥ��
//	 */
//	public void setGiodoutprice(BigDecimal giodoutprice) {
//		this.giodoutprice = giodoutprice;
//	}




	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public Integer getGiodinnum() {
		return giodinnum;
	}




	/**
	 * ����������趨
	 * @param giodinnum ���������
	 */
	public void setGiodinnum(Integer giodinnum) {
		this.giodinnum = giodinnum;
	}



	/**
	 * ������λȡ��
	 * @return ������λ
	 */
	public String getGiodunit() {
		return giodunit;
	}




	/**
	 * ������λ�趨
	 * @param giodunit ������λ
	 */
	public void setGiodunit(String giodunit) {
		this.giodunit = giodunit;
	}




	/**
	 * ��Ӧ��ȡ��
	 * @return ��Ӧ��
	 */
	public String getGiodprovider() {
		return giodprovider;
	}




	/**
	 * ��Ӧ���趨
	 * @param giodprovider ��Ӧ��
	 */
	public void setGiodprovider(String giodprovider) {
		this.giodprovider = giodprovider;
	}




	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getGiodpurchaser() {
		return giodpurchaser;
	}




	/**
	 * �������趨
	 * @param giodpurchaser ������
	 */
	public void setGiodpurchaser(String giodpurchaser) {
		this.giodpurchaser = giodpurchaser;
	}




	/**
	 * �����۸�ȡ��
	 * @return �����۸�
	 */
	public BigDecimal getGiodreliefprice() {
		return giodreliefprice;
	}




	/**
	 * �����۸��趨
	 * @param giodreliefprice �����۸�
	 */
	public void setGiodreliefprice(BigDecimal giodreliefprice) {
		this.giodreliefprice = giodreliefprice;
	}




	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGiodreliefnum() {
		return giodreliefnum;
	}




	/**
	 * ���������趨
	 * @param giodreliefnum ��������
	 */
	public void setGiodreliefnum(Integer giodreliefnum) {
		this.giodreliefnum = giodreliefnum;
	}




	/**
	 * �����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)ȡ��
	 * @return �����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)
	 */
	public String getGiodstatus() {
		return giodstatus;
	}




	/**
	 * �����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)�趨
	 * @param giodstatus �����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)
	 */
	public void setGiodstatus(String giodstatus) {
		this.giodstatus = giodstatus;
	}




	/**
	 * ���û���/�������������ȡ��
	 * @return ���û���/�������������
	 */
	public String getGiodreqorg() {
		return giodreqorg;
	}




	/**
	 * ���û���/��������������趨
	 * @param giodstatus ���û���/�������������
	 */
	public void setGiodreqorg(String giodreqorg) {
		this.giodreqorg = giodreqorg;
	}




	/**
	 * ������/������IDȡ��
	 * @return ������/������ID
	 */
	public String getGiodrequser() {
		return giodrequser;
	}




	/**
	 * ������/������ID�趨
	 * @param giodrequser ������/������ID
	 */
	public void setGiodrequser(String giodrequser) {
		this.giodrequser = giodrequser;
	}




	/**
	 * ������/����������ȡ��
	 * @return ������/����������
	 */
	public String getGiodrequsername() {
		return giodrequsername;
	}




	/**
	 * ������/�����������趨
	 * @param giodrequsername ������/����������
	 */
	public void setGiodrequsername(String giodrequsername) {
		this.giodrequsername = giodrequsername;
	}




	/**
	 * �Ǽ���ȡ��
	 * @return �Ǽ���
	 */
	public String getGioduser() {
		return gioduser;
	}




	/**
	 * �Ǽ����趨
	 * @param gioduser �Ǽ���
	 */
	public void setGioduser(String gioduser) {
		this.gioduser = gioduser;
	}




	/**
	 * �Ǽ�������ȡ��
	 * @return �Ǽ�������
	 */
	public String getGiodusername() {
		return giodusername;
	}




	/**
	 * �Ǽ��������趨
	 * @param giodusername �Ǽ�������
	 */
	public void setGiodusername(String giodusername) {
		this.giodusername = giodusername;
	}




	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGiodchknum() {
		return giodchknum;
	}




	/**
	 * ���������趨
	 * @param giodchknum ��������
	 */
	public void setGiodchknum(Integer giodchknum) {
		this.giodchknum = giodchknum;
	}




	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public String getGiodchkid() {
		return giodchkid;
	}




	/**
	 * ������ID�趨
	 * @param giodchkid ������ID
	 */
	public void setGiodchkid(String giodchkid) {
		this.giodchkid = giodchkid;
	}




	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getGiodchkkname() {
		return giodchkkname;
	}




	/**
	 * �����������趨
	 * @param giodchkkname ����������
	 */
	public void setGiodchkkname(String giodchkkname) {
		this.giodchkkname = giodchkkname;
	}
	
	/**
	 * ��Ʒ������ϢIDȡ��
	 * @return ��Ʒ������ϢID
	 */
	public Integer getGoid() {
		return goid;
	}




	/**
	 * ��Ʒ������ϢID�趨
	 * @param goid ��Ʒ������ϢID
	 */
	public void setGoid(Integer goid) {
		this.goid = goid;
	}

}
