/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: EmergencyResource��������ʵ��
  * ��������: EmergencyResource��������ʵ��
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public class EmergencyResourceSearchCondImpl implements
		EmergencyResourceSearchCond {

	protected Integer erid;
	/** ��Դ���� */
	protected String ername;

	/** ��Դ���� */
	protected String erdesc;

	/** ��Դ״̬ */
	protected String erstatus;

	/** ��Դ��� */
	protected String erlabel;

	/** ��Դ���� */
	protected String ercode;

	/** �������� */
	protected String erparcode;
	
	/** ��������like */
	protected String erparcode_like;

	/** ¼��ʱ�� */
	protected String ercreatetime;

	/** ¼����id */
	protected String eruserid;

	/** ¼�������� */
	protected String erusername;
	
	/** ����by */
	protected String orderby;
	
	/** �����ֶ� */
	protected String order;
	
	/** ��Ӧ�ʲ���  */
	protected String esyscoding;
	/**
	 * @return the esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * @param ��Ӧ�ʲ���  the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * @return the erparcode_like
	 */
	public String getErparcode_like() {
		return erparcode_like;
	}

	/**
	 * @param erparcode_like the erparcode_like to set
	 */
	public void setErparcode_like(String erparcode_like) {
		this.erparcode_like = erparcode_like;
	}

	/**
	 * @return the orderby
	 */
	public String getOrderby() {
		return orderby;
	}

	/**
	 * @param orderby the orderby to set
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getErid() {
		return erid;
	}

	/**
	 * �����趨
	 *
	 * @param erid ����
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErname() {
		return ername;
	}

	/**
	 * ��Դ�����趨
	 *
	 * @param ername ��Դ����
	 */
	public void setErname(String ername) {
		this.ername = ername;
	}

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErdesc() {
		return erdesc;
	}

	/**
	 * ��Դ�����趨
	 *
	 * @param erdesc ��Դ����
	 */
	public void setErdesc(String erdesc) {
		this.erdesc = erdesc;
	}

	/**
	 * ��Դ״̬ȡ��
	 *
	 * @return ��Դ״̬
	 */
	public String getErstatus() {
		return erstatus;
	}

	/**
	 * ��Դ״̬�趨
	 *
	 * @param erstatus ��Դ״̬
	 */
	public void setErstatus(String erstatus) {
		this.erstatus = erstatus;
	}

	/**
	 * ��Դ���ȡ��
	 *
	 * @return ��Դ���
	 */
	public String getErlabel() {
		return erlabel;
	}

	/**
	 * ��Դ����趨
	 *
	 * @param erlabel ��Դ���
	 */
	public void setErlabel(String erlabel) {
		this.erlabel = erlabel;
	}

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErcode() {
		return ercode;
	}

	/**
	 * ��Դ�����趨
	 *
	 * @param ercode ��Դ����
	 */
	public void setErcode(String ercode) {
		this.ercode = ercode;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getErparcode() {
		return erparcode;
	}

	/**
	 * ���������趨
	 *
	 * @param erparcode ��������
	 */
	public void setErparcode(String erparcode) {
		this.erparcode = erparcode;
	}

	/**
	 * ¼��ʱ��ȡ��
	 *
	 * @return ¼��ʱ��
	 */
	public String getErcreatetime() {
		return ercreatetime;
	}

	/**
	 * ¼��ʱ���趨
	 *
	 * @param ercreatetime ¼��ʱ��
	 */
	public void setErcreatetime(String ercreatetime) {
		this.ercreatetime = ercreatetime;
	}

	/**
	 * ¼����idȡ��
	 *
	 * @return ¼����id
	 */
	public String getEruserid() {
		return eruserid;
	}

	/**
	 * ¼����id�趨
	 *
	 * @param eruserid ¼����id
	 */
	public void setEruserid(String eruserid) {
		this.eruserid = eruserid;
	}

	/**
	 * ¼��������ȡ��
	 *
	 * @return ¼��������
	 */
	public String getErusername() {
		return erusername;
	}

	/**
	 * ¼���������趨
	 *
	 * @param erusername ¼��������
	 */
	public void setErusername(String erusername) {
		this.erusername = erusername;
	}

}