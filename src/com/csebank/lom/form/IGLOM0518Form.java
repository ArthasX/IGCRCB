/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.ItemsCodesSt;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * �Ϳ��ǼǱ��Form
 *
 */
public class IGLOM0518Form extends BaseForm  implements ItemsCodesSt {


	private static final long serialVersionUID = 1L;

	/** �������������� */
	protected Integer icid;

	/** �������� */
	protected String selectid;
	
	/** �������� */
	protected String selectname;
	
	/** �Ϳ���� */
	protected String typecode;
	
	/** �Ϳ����� */
	protected String typename;
	
	/** ������ */
	protected String type;
	
	/** �;���ֵ */
	protected String prince;
	
	/** ���� */
	protected String allowance;
	
	/** ������ */
	protected String desc;
	
	/** ������ */
	protected String status;

	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode = "0";	

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ҳ�������ʾȡ��
	 * @return ҳ�������ʾ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ҳ�������ʾ�趨
	 * @param mode ҳ�������ʾ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public Integer getIcid() {
		return icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}

	public String getSelectid() {
		return selectid;
	}

	public void setSelectid(String selectid) {
		this.selectid = selectid;
	}

	public String getSelectname() {
		return selectname;
	}

	public void setSelectname(String selectname) {
		this.selectname = selectname;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrince() {
		return prince;
	}

	public void setPrince(String prince) {
		this.prince = prince;
	}

	public String getAllowance() {
		return allowance;
	}

	public void setAllowance(String allowance) {
		this.allowance = allowance;
	}

}
