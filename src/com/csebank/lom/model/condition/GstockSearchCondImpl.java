/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ��Ʒ��ѯ�ӿ�ʵ��
 *
 */
public class GstockSearchCondImpl implements GstockSearchCond {
	
	/** GStock���� */
	protected Integer gsid;
	
	/** ��Ʒ���� */
	protected String gscategory;
	
	/** ��Ʒ���� */
	protected String gsname;
	
	/** ��Ʒ��� */
	protected String gscode;

	/** ������������� */
	protected String gsorg;
	
	
	
	/** ������ */
	protected Integer gsnum;
	
	/** �ɹ�ƽ���� */
	protected String gsavgprice;
	/** �������� */
	protected Integer gsfreezenum;
	/** ���һ�θ�����ID */
	protected String gsuserid;
	/** ���һ�θ��������� */
	protected String gsusername;
	/** ���һ�θ���ʱ�� */
	protected String gsdate;
	
	/** Ԥ������ */
	protected String wnum;
	
	
	/**
	 * @return the wnum
	 */
	public String getWnum() {
		return wnum;
	}
	/**
	 * @param wnum the wnum to set
	 */
	public void setWnum(String wnum) {
		this.wnum = wnum;
	}
	public Integer getGsnum() {
		return gsnum;
	}
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}
	
	public String getGsavgprice() {
		return gsavgprice;
	}
	public void setGsavgprice(String gsavgprice) {
		this.gsavgprice = gsavgprice;
	}
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}
	public String getGsuserid() {
		return gsuserid;
	}
	public void setGsuserid(String gsuserid) {
		this.gsuserid = gsuserid;
	}
	public String getGsusername() {
		return gsusername;
	}
	public void setGsusername(String gsusername) {
		this.gsusername = gsusername;
	}
	public String getGsdate() {
		return gsdate;
	}
	public void setGsdate(String gsdate) {
		this.gsdate = gsdate;
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
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGscategory() {
		return gscategory;
	}
	/**
	 * ��Ʒ����
	 * @param ��Ʒ����
	 */
	public void setGscategory(String gscategory) {
		this.gscategory = gscategory;
	}
	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGsname() {
		return gsname;
	}
	/**
	 * ��Ʒ����
	 * @param ��Ʒ����
	 */
	public void setGsname(String gsname) {
		this.gsname = gsname;
	}
	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGscode() {
		return gscode;
	}
	/**
	 * ��Ʒ���
	 * @param ��Ʒ���
	 */
	public void setGscode(String gscode) {
		this.gscode = gscode;
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

}
