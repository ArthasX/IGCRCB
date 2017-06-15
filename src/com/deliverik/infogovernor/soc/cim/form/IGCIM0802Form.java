package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;

/**
 * �ɼ������ѯ����FORM
 * 
 */
public class IGCIM0802Form extends BaseForm implements SOC0120SearchCond{

	private static final long serialVersionUID = 1L;
	
	/** �汾�� */
	public Integer impversion;
	
	/** �豸���� */
	public String impeiname;
	
	/** �豸ģ���� */
	protected String ename;
	
	/** ���²ɼ�ʱ�� */
	protected String impcreatetime_s;
	
	/** ���²ɼ�ʱ�� */
	protected String impcreatetime_e;
	
	/** ip */
	protected String impip;

	/** �豸ID */
	protected Integer impeiid;
	
	protected String impeiname_like;
	
	protected String esyscoding;
	
	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public Integer getImpversion() {
		return impversion;
	}

	public String getImpcreatetime_s() {
		return impcreatetime_s;
	}

	public void setImpcreatetime_s(String impcreatetime_s) {
		this.impcreatetime_s = impcreatetime_s;
	}

	public String getImpcreatetime_e() {
		return impcreatetime_e;
	}

	public void setImpcreatetime_e(String impcreatetime_e) {
		this.impcreatetime_e = impcreatetime_e;
	}

	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	public String getImpeiname() {
		return impeiname;
	}

	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getImpip() {
		return impip;
	}

	public void setImpip(String impip) {
		this.impip = impip;
	}

	public Integer getImpeiid() {
		return impeiid;
	}

	public void setImpeiid(Integer impeiid) {
		this.impeiid = impeiid;
	}

	public String getDeleteflag_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImpeiname_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImpeiname_like() {
		return impeiname_like;
	}

	public void setImpeiname_like(String impeiname_like) {
		this.impeiname_like = impeiname_like;
	}

}
