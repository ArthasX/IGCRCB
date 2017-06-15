package com.deliverik.infogovernor.prm.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.entity.IG286TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

@SuppressWarnings("serial")
public class IGPRM0302Form extends BaseForm implements IG007Info{

	private String pidid;
	private String pdid;
	private String pidname;
	private String pidlabel;
	private String piddesc;
	private String pidtype;
	private String pidoption;
	private String piddefault;
	private String pidrequired;
	/** 排序ID */
	protected String pidsortid;
	
	/** 树标识 */
	private String ccid;
	
	/** 树名称 */
	private String ccid_name;
	
	public String getPidsortid() {
		return pidsortid;
	}

	public void setPidsortid(String pidsortid) {
		this.pidsortid = pidsortid;
	}
	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPidname() {
		return pidname;
	}

	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	public String getPidlabel() {
		return pidlabel;
	}

	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	public String getPiddesc() {
		return piddesc;
	}

	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	public String getPidtype() {
		return pidtype;
	}

	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	public String getPidoption() {
		return pidoption;
	}

	public void setPidoption(String pidoption) {
		this.pidoption = pidoption;
	}

	public String getPiddefault() {
		return piddefault;
	}

	public void setPiddefault(String piddefault) {
		this.piddefault = piddefault;
	}

	public String getPidrequired() {
		return pidrequired;
	}

	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getPidaccess() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPidvalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPiid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPidgid() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IG286TB> getProcessLinkageDefList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 数标识取得
	 * @return 数标识
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 数标识设定
	 * @param ccid 数标识
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 树名称取得
	 * @return 树名称
	 */
	public String getCcid_name() {
		return ccid_name;
	}

	/**
	 * 树名称设定
	 * 
	 * @param ccid_name 树名称
	 */
	public void setCcid_name(String ccid_name) {
		this.ccid_name = ccid_name;
	}

	public String getPidmode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrivatescope() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IG899TB> getProcessPrivateInfoList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRowwidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getHasattach() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPiddisplay() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPiduse() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPidwidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpidid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPidrows() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPidhide() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getShowrownum() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPidunit() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemarks() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getShowstyles() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getShowline() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitledisplay() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNeedidea() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getJsfunction() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPidratio() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPidsize() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWriteable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelecedlast() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNumbertype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAlign() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.IG007Info#getIsFlag()
	 */
	public String getIsFlag() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
