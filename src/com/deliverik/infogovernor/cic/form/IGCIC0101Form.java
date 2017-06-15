package com.deliverik.infogovernor.cic.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����һ���Աȶ�
 *	�Աȹ����ѯ����FORM
 * 
 */
public class IGCIC0101Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/**�Աȹ���id*/
	private Integer crid;
	/**�Ա���*/
	private Integer csid;
	/**�Աȹ�������*/
	private String crname;

	/** �Ա����� */
	protected String crtype;
	
	/** ҵ��ϵͳid */
	protected Integer crsystemid;
	protected String crsystemname;

	public String getCrtype() {
		return crtype;
	}

	public void setCrtype(String crtype) {
		this.crtype = crtype;
	}

	public Integer getCrsystemid() {
		return crsystemid;
	}

	public void setCrsystemid(Integer crsystemid) {
		this.crsystemid = crsystemid;
	}
	
	
	/**
	 * ����id ��ȡ
	 * @return
	 */
	public Integer getCrid() {
		return crid;
	}
	/**
	 * ����id  �趨
	 * @param crid
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}
	/**
	 * ��id ��ȡ
	 * @return
	 */
	public Integer getCsid() {
		return csid;
	}
	/**
	 * ��id�趨
	 * @param csid
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	/**
	 * �������� ��ȡ
	 * @return
	 */
	public String getCrname() {
		return crname;
	}
	/**
	 * ���������趨
	 * @param crname
	 */
	public void setCrname(String crname) {
		this.crname = crname;
	}

	public String getCrsystemname() {
		return crsystemname;
	}

	public void setCrsystemname(String crsystemname) {
		this.crsystemname = crsystemname;
	}
	
	
	
}
