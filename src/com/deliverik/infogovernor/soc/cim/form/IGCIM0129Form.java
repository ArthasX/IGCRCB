package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * FS��ϵѡ����FORM ԭ0813
 * 
 */
public class IGCIM0129Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** �豸id */
	protected Integer eiid;
	/**Ӧ��ID */
	protected Integer pareiid;
	/** FS id */
	protected String[] eiids;
	/** FS �汾 */
	protected String[] eiversions;
	/** FS С�汾 */
	protected String[] eismallversions;
	/**Ӧ�ð汾 */
	protected Integer parversion;
	/**Ӧ��С�汾 */
	protected Integer parsmallversion;
	
	protected String flag;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String[] getEiids() {
		return eiids;
	}

	public void setEiids(String[] eiids) {
		this.eiids = eiids;
	}

	public String[] getEiversions() {
		return eiversions;
	}

	public void setEiversions(String[] eiversions) {
		this.eiversions = eiversions;
	}

	public String[] getEismallversions() {
		return eismallversions;
	}

	public void setEismallversions(String[] eismallversions) {
		this.eismallversions = eismallversions;
	}

	public Integer getPareiid() {
		return pareiid;
	}

	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	public Integer getParversion() {
		return parversion;
	}

	public void setParversion(Integer parversion) {
		this.parversion = parversion;
	}

	public Integer getParsmallversion() {
		return parsmallversion;
	}

	public void setParsmallversion(Integer parsmallversion) {
		this.parsmallversion = parsmallversion;
	}

}
