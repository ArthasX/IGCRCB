package com.deliverik.infogovernor.sym.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.condition.CodeDetailSearchCond;

/**
 * ������ϸ��Ϣ����FORM
 * 
 */
public class IGSYM1006Form extends BaseForm implements CodeDetailSearchCond {

	private static final long serialVersionUID = 1L;
	
	/** ���ݷ���CD */
	protected String ccid ;
	
	/** ����CD */
	protected String cid ;
	
	/** ���ݷ���CD */
	protected String ccname ;
	
	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public String getCdinfo_eq() {
		return cdinfo_eq;
	}

	public void setCdinfo_eq(String cdinfo_eq) {
		this.cdinfo_eq = cdinfo_eq;
	}

	protected String cvalue;
	
	protected String cdinfo_eq;
	
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

	/**
	 * ����CDȡ��
	 * @return ����CD
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * ����CD�趨
	 *
	 * @param cid ����CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getPccid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPcid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCdstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getClevel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBusinesscode_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSyscoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCdinfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getCidList() {
		// TODO Auto-generated method stub
		return null;
	}
}
