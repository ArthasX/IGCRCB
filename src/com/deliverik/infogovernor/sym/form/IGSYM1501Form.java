package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���ݷ����б���FORM
 *  
 */
@SuppressWarnings("serial")
public class IGSYM1501Form extends BaseForm{

	/** ���ݷ���CD */
	protected String ccid ;
	
	/** ���ݷ����� */
	protected String ccname ;
	
	/** ���ݷ���˵�� */
	protected String ccinfo ;
	
	/** ���ݷ���༭��ʶ */
	protected String cceditable ;
	
	/** ���ݷ�����ϼ����ݷ���ID�����λ��������ã� */
	protected String pccid ;
	
	/** ���λ�������֧����󼶱� */
	protected String pcflag ;
	
	
	
	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getCcinfo() {
		return ccinfo;
	}

	public void setCcinfo(String ccinfo) {
		this.ccinfo = ccinfo;
	}

	public String getCceditable() {
		return cceditable;
	}

	public void setCceditable(String cceditable) {
		this.cceditable = cceditable;
	}

	public String getPccid() {
		return pccid;
	}

	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	public String getPcflag() {
		return pcflag;
	}

	public void setPcflag(String pcflag) {
		this.pcflag = pcflag;
	}

	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * ���ݷ���CD�趨
	 *
	 * @param ccid ���ݷ���CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

}
