/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;


/**
 * 
 * �Ӵ���ѯ�ӿ�ʵ��
 *
 */
public class GoodsSearchCondImpl implements GoodsSearchCond {
	
	/** ��Ʒ��ϢID */
	protected Integer gid;
	
	/** ��Ʒ���� */
	protected String gcategory;
	
	/** ��Ʒ���� */
	protected String gname;
	
	/** ��Ʒ��� */
	protected String gcode;
	
	/** Ԥ����ʾ���� */
	protected Integer gwarningnum;
	
	/** ��Ʒ�ڲ�ת�ƶ��ۣ�%�� */
	protected BigDecimal gprice;
	
	/** ״̬��0:ͣ�� 1:���ã� */
	protected String gstatus;
	

	/**
	 * ��Ʒ��ϢIDȡ��
	 * @return ��Ʒ��ϢID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * ��Ʒ��ϢID�趨
	 * @param gid ��Ʒ��ϢID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGcategory() {
		return gcategory;
	}

	/**
	 * ��Ʒ�����趨
	 * @param gcategory ��Ʒ����
	 */
	public void setGcategory(String gcategory) {
		this.gcategory = gcategory;
	}

	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGname() {
		return gname;
	}

	/**
	 * ��Ʒ�����趨
	 * @param gname ��Ʒ����
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}

	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGcode() {
		return gcode;
	}

	/**
	 * ��Ʒ����趨
	 * @param gcode ��Ʒ���
	 */
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	/**
	 * Ԥ����ʾ����ȡ��
	 * @return Ԥ����ʾ����
	 */
	public Integer getGwarningnum() {
		return gwarningnum;
	}

	/**
	 * Ԥ����ʾ�����趨
	 * @param gwarningnum Ԥ����ʾ����
	 */
	public void setGwarningnum(Integer gwarningnum) {
		this.gwarningnum = gwarningnum;
	}

	/**
	 * ��Ʒ�ڲ�ת�ƶ��ۣ�%��ȡ��
	 * @return ��Ʒ�ڲ�ת�ƶ��ۣ�%��
	 */
	public BigDecimal getGprice() {
		return gprice;
	}

	/**
	 * ��Ʒ�ڲ�ת�ƶ��ۣ�%���趨
	 * @param gprice ��Ʒ�ڲ�ת�ƶ��ۣ�%��
	 */
	public void setGprice(BigDecimal gprice) {
		this.gprice = gprice;
	}

	/**
	 * ״̬��0:ͣ�� 1:���ã�ȡ��
	 * @return ״̬��0:ͣ�� 1:���ã�
	 */
	public String getGstatus() {
		return gstatus;
	}

	/**
	 * ״̬��0:ͣ�� 1:���ã��趨
	 * @param gstatus ״̬��0:ͣ�� 1:���ã�
	 */
	public void setGstatus(String gstatus) {
		this.gstatus = gstatus;
	}

}
