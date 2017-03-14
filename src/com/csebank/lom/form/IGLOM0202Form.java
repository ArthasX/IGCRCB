/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.Goods;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * �Ӵ������ǼǱ��Form
 * 
 */
public class IGLOM0202Form extends BaseForm implements Goods{

	private static final long serialVersionUID = 1L;

	protected String mode;
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	/** ��Ʒ��ϢID */
	protected Integer gid;
	
	/** ��Ʒ���� */
	protected String gcategory;
	
	/** ��Ʒ�������� */
	protected String gcategoryname;
	
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

	/** ɾ��Goodid */
	protected Integer[] deleteGoodid;
	
	/** ��Ʒ���Ʋ�ѯ */
	protected String gname_q;
	
	/** ����·�� */
	protected String path;
	
	/** ��λ */
	protected String gunit;
	
	/** ԭ�� */
	protected String greason;
	
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

	public String getFingerPrint() {
		return null;
	}

	public Integer[] getDeleteGoodid() {
		return deleteGoodid;
	}

	public void setDeleteGoodid(Integer[] deleteGoodid) {
		this.deleteGoodid = deleteGoodid;
	}

	public String getGname_q() {
		return gname_q;
	}

	public void setGname_q(String gname_q) {
		this.gname_q = gname_q;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getGunit() {
		return gunit;
	}

	public void setGunit(String gunit) {
		this.gunit = gunit;
	}

	public String getGcategoryname() {
		return gcategoryname;
	}

	public void setGcategoryname(String gcategoryname) {
		this.gcategoryname = gcategoryname;
	}

	public String getGreason() {
		return greason;
	}

	public void setGreason(String greason) {
		this.greason = greason;
	}
	
	

}
