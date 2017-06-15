package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

public class IGCIM0808Form extends BaseForm{
	
	private static final long serialVersionUID = 1L;

	/** ÈÎÎñ¸´Ñ¡¿ò */
	private String[] eitids;
	
	private String actionStatus;
	
	private String einame;
	
	private String serverstatus;
	
	private String pluginNmae;

	public String[] getEitids() {
		return eitids;
	}

	public void setEitids(String[] eitids) {
		this.eitids = eitids;
	}

	public String getActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getServerstatus() {
		return serverstatus;
	}

	public void setServerstatus(String serverstatus) {
		this.serverstatus = serverstatus;
	}

	public String getPluginNmae() {
		return pluginNmae;
	}

	public void setPluginNmae(String pluginNmae) {
		this.pluginNmae = pluginNmae;
	}

	
}
