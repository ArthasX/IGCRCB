package com.csebank.lom.form;


import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0109Form extends BaseForm implements RecptionGuestInfoCond {
 
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * ������λ
	 */
	protected String rgunit;
	
	/**
	 * ��������
	 */
	protected String rgname;
	
	/**
	 * �Ӵ���������
	 */
	protected String rname;
	
	/**
	 * ��Ҫ���벿�� 
	 */
	protected String rapporgid;
	
	/** �Ӵ���ʼ���� */
	protected String rstime;
	
	/** �Ӵ���������*/
	protected String retime;

	public String getRapporgid() {
		return rapporgid;
	}

	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	public String getRstime() {
		return rstime;
	}

	public void setRstime(String rstime) {
		this.rstime = rstime;
	}

	public String getRetime() {
		return retime;
	}

	public void setRetime(String retime) {
		this.retime = retime;
	}

	public String getRpporg() {
		return rpporg;
	}

	public void setRpporg(String rpporg) {
		this.rpporg = rpporg;
	}

	public String getRdescription() {
		return rdescription;
	}

	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}

	/** �������벿�� */
	protected String rpporg;
	
	/** �Ӵ��������� */
	protected String rdescription;
	
	
	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRgname() {
		
		return rgname;
	}
	
    public void setRgname(String rgname){
    	this.rgname=rgname;
    }
	
	public String getRgunit() {
		
		return rgunit;
	}
	
	public void setRgunit(String rgunit){
		this.rgunit=rgunit;
	}

}
