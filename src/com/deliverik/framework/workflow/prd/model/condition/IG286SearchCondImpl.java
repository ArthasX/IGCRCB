/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * <p>����:���̼�������ѯ����ʵ��</p>
 * <p>��������:</p>
 * <p>������¼��</p>
 */
public class IG286SearchCondImpl implements IG286SearchCond {
	
	/** ������ID*/
	protected String plid;

	/** ������ID*/
	protected String initiativepidid;
	
	/** ������ID*/
	protected String passivitypidid;
	
	/** ������˵��*/
	protected String pldesc;
	
	/** ������BL */
	protected String plblname;
	
	/** ������JS */
	protected String pljsevent;
	
	/** ���������� */
	protected String pljtype;

	/** ����id*/
	protected String pldpdid;
	
	/** ����ActionID */
	protected String pldactionid;
	
	/** ���� */
	protected String plid_like;
	
	/**
	 * ���ܣ�������IDȡ��
	 * @return plid ������ID
	 */
	public String getPlid() {
		return plid;
	}

	/**
	 * ���ܣ�������ID�趨
	 * @param  plid ������ID
	 */
	public void setPlid(String plid) {
		this.plid = plid;
	}

	/**
	 * ���ܣ�������IDȡ��
	 * @return initiativepidid ������ID
	 */
	public String getInitiativepidid() {
		return initiativepidid;
	}

	/**
	 * ���ܣ�������ID�趨
	 * @param  initiativepidid ������ID
	 */
	public void setInitiativepidid(String initiativepidid) {
		this.initiativepidid = initiativepidid;
	}

	/**
	 * ���ܣ�������IDȡ��
	 * @return passivitypidid ������ID
	 */
	public String getPassivitypidid() {
		return passivitypidid;
	}

	/**
	 * ���ܣ�������ID�趨
	 * @param  passivitypidid ������ID
	 */
	public void setPassivitypidid(String passivitypidid) {
		this.passivitypidid = passivitypidid;
	}

	/**
	 * ���ܣ�������˵��ȡ��
	 * @return pldesc ������˵��
	 */
	public String getPldesc() {
		return pldesc;
	}

	/**
	 * ���ܣ�������˵���趨
	 * @param  pldesc ������˵��
	 */
	public void setPldesc(String pldesc) {
		this.pldesc = pldesc;
	}

	/**
	 * ���ܣ�������BL����ȡ��
	 * @return plblname ������BL����
	 */
	public String getPlblname() {
		return plblname;
	}

	/**
	 * ���ܣ�������BL�����趨
	 * @param  plblname ������BL����
	 */
	public void setPlblname(String plblname) {
		this.plblname = plblname;
	}

	/**
	 * ���ܣ�������JS�¼�ȡ��
	 * @return pljsevent ������JS�¼�
	 */
	public String getPljsevent() {
		return pljsevent;
	}

	/**
	 * ���ܣ�������JS�¼��趨
	 * @param  pljsevent ������JS�¼�
	 */
	public void setPljsevent(String pljsevent) {
		this.pljsevent = pljsevent;
	}
	
	/**
	 * ���ܣ�����������ȡ��
	 * @return pljtype ����������
	 */
	public String getPljtype() {
		return pljtype;
	}

	/**
	 * ���ܣ������������趨
	 * @param  pljtype ����������
	 */
	public void setPljtype(String pljtype) {
		this.pljtype = pljtype;
	}

	/**
	 * ���ܣ�����IDȡ��
	 * @return pldpdid ����ID
	 */
	public String getPldpdid() {
		return pldpdid;
	}

	/**
	 * ���ܣ�����ID�趨
	 * @param  pldpdid ����ID
	 */
	public void setPldpdid(String pldpdid) {
		this.pldpdid = pldpdid;
	}

	/**
	 * ���ܣ�����actionIDȡ��
	 * @return pldactionid ����actionID
	 */
	public String getPldactionid() {
		return pldactionid;
	}

	/**
	 * ���ܣ�����actionID�趨
	 * @param  pldactionid ����actionID
	 */
	public void setPldactionid(String pldactionid) {
		this.pldactionid = pldactionid;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPlid_like() {
		return plid_like;
	}

	/**
	 * �����趨
	 * 
	 * @param plid_like ����
	 */
	public void setPlid_like(String plid_like) {
		this.plid_like = plid_like;
	}
	
}
