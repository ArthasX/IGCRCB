/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;






/**
 * 
 * ��Ʒ������Ϣ��ͼ��ѯ�ӿ�ʵ��
 *
 */
public class GoutstockVWSearchCondImpl implements GoutstockVWSearchCond {
	
	/** ��Ʒ������ϢID */
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
	
	/** ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)*/
	protected String gostatus;
	
	/** ���û���/�������������*/
	protected String goreqorg;
	
	/** GStock���� */
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
	 *��Ʒ������ϢIDȡ��
	 * @return ��Ʒ������ϢID
	 */
	public Integer getGoid() {
		return goid;
	}




	/**
	 *��Ʒ������ϢID�趨
	 * @param godid��Ʒ������ϢID
	 */
	public void setGoid(Integer goid) {
		this.goid = goid;
	}




	/**
	 * ��������(0:��� 1:���� 2:���� 3:����)ȡ��
	 * @return ��������(0:��� 1:���� 2:���� 3:����)
	 */
	public String getGotype() {
		return gotype;
	}




	/**
	 * ��������(0:��� 1:���� 2:���� 3:����)�趨
	 * @param godtype ��������(0:��� 1:���� 2:���� 3:����)
	 */
	public void setGotype(String gotype) {
		this.gotype = gotype;
	}



	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGoorg() {
		return goorg;
	}




	/**
	 * ��������������趨
	 * @param goorg �������������
	 */
	public void setGoorg(String goorg) {
		this.goorg = goorg;
	}




	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGocategory() {
		return gocategory;
	}




	/**
	 * ��Ʒ�����趨
	 * @param gocategory ��Ʒ����
	 */
	public void setGocategory(String gocategory) {
		this.gocategory = gocategory;
	}




	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGoname() {
		return goname;
	}




	/**
	 * ��Ʒ�����趨
	 * @param goname ��Ʒ����
	 */
	public void setGoname(String goname) {
		this.goname = goname;
	}




	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGocode() {
		return gocode;
	}




	/**
	 * ��Ʒ����趨
	 * @param godcode ��Ʒ���
	 */
	public void setGocode(String gocode) {
		this.gocode = gocode;
	}




	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getGotime() {
		return gotime;
	}




	/**
	 * ����ʱ���趨
	 * @param godtime ����ʱ��
	 */
	public void setGotime(String gotime) {
		this.gotime = gotime;
	}




	/**
	 * �ɹ����뵥����ȡ��
	 * @return �ɹ����뵥����
	 */
	public String getGoreqnum() {
		return goreqnum;
	}




	/**
	 * �ɹ����뵥�����趨
	 * @param goreqnum �ɹ����뵥����
	 */
	public void setGoreqnum(String goreqnum) {
		this.goreqnum = goreqnum;
	}

	/**
	 * ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)ȡ��
	 * @return ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)
	 */
	public String getGostatus() {
		return gostatus;
	}




	/**
	 * ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)�趨
	 * @param gostatus ����״̬(���ʱ��0:����� 1:�����;����ʱ��0:������� 1:������ 2:����δͨ��)
	 */
	public void setGostatus(String gostatus) {
		this.gostatus = gostatus;
	}




	/**
	 * ���û���/�������������ȡ��
	 * @return ���û���/�������������
	 */
	public String getGoreqorg() {
		return goreqorg;
	}




	/**
	 * ���û���/��������������趨
	 * @param goreqorg ���û���/�������������
	 */
	public void setGoreqorg(String goreqorg) {
		this.goreqorg = goreqorg;
	}

	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getGsid() {
		return gsid;
	}
	/**
	 * ����ID
	 * @param gsid ����ID
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

}
