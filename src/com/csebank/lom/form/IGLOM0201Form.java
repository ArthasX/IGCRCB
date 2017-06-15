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
public class IGLOM0201Form extends BaseForm implements Goods{

	private static final long serialVersionUID = 1L;
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
	
	/** �Ӵ�����ID*/
	protected Integer rid;
	
	/** ����*/
	protected Integer[] gids;
	
	/** ��Ʒ����*/
	protected String[] gcategorys;
	
	/** ��Ʒ����*/
	protected String[] gnames;
	
	/** ��Ʒ���*/
	protected String[] gcodes;
	
	/** Ԥ����ʾ����*/
	protected Integer[] gwarningnums;
	
	/** ��Ʒ�ڲ�ת�ƶ��ۣ�%��*/
	protected BigDecimal[] gprices;
	
	/** ״̬��0:ͣ�� 1:���ã�*/
	protected String[] gstatuss;
	
	/** ��λ */
	protected String gunit;
	
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
	
	protected String mode;
	
	/** ԭ�� */
	protected String greason;
	
	
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
	 * @return the gids
	 */
	public Integer[] getGids() {
		return gids;
	}

	/**
	 * @param gids the gids to set
	 */
	public void setGids(Integer[] gids) {
		this.gids = gids;
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
	 * @return the gwarningnums
	 */
	public Integer[] getGwarningnums() {
		return gwarningnums;
	}

	/**
	 * @param gwarningnums the gwarningnums to set
	 */
	public void setGwarningnums(Integer[] gwarningnums) {
		this.gwarningnums = gwarningnums;
	}

	/**
	 * @return the gprices
	 */
	public BigDecimal[] getGprices() {
		return gprices;
	}

	/**
	 * @param gprices the gprices to set
	 */
	public void setGprices(BigDecimal[] gprices) {
		this.gprices = gprices;
	}

	/**
	 * @return the gstatuss
	 */
	public String[] getGstatuss() {
		return gstatuss;
	}

	/**
	 * @param gstatuss the gstatuss to set
	 */
	public void setGstatuss(String[] gstatuss) {
		this.gstatuss = gstatuss;
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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
