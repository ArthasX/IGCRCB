package com.deliverik.infogovernor.scheduling.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.infogovernor.scheduling.form.IGSCH0201Form;
import com.deliverik.infogovernor.scheduling.form.IGSCH0202Form;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

public class IGSCH02DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private QuartzJobs quartzJobs;
	private QuartzProcessRecord quartzProcessRecord;
	private IGSCH0201Form igsch0201Form;
	private IGSCH0202Form igsch0202Form;
	private String triggerName;
	private List<IG380Info> pdList;
	private List<IG007Info> pidList;
	private IG007Info processInfoDef;
	private String pdid;
	/**流程变量*/

	public List<IG007Info> getPidList() {
		return pidList;
	}

	public void setPidList(List<IG007Info> pidList) {
		this.pidList = pidList;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}

	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	public List<IG380Info> getPdList() {
		return pdList;
	}

	public void setPdList(List<IG380Info> pdList) {
		this.pdList = pdList;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public IGSCH0202Form getIgsch0202Form() {
		return igsch0202Form;
	}

	public void setIgsch0202Form(IGSCH0202Form igsch0202Form) {
		this.igsch0202Form = igsch0202Form;
	}

	public QuartzProcessRecord getQuartzProcessRecord() {
		return quartzProcessRecord;
	}

	public void setQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord) {
		this.quartzProcessRecord = quartzProcessRecord;
	}

	public QuartzJobs getQuartzJobs() {
		return quartzJobs;
	}

	public void setQuartzJobs(QuartzJobs quartzJobs) {
		this.quartzJobs = quartzJobs;
	}

	public IGSCH0201Form getIgsch0201Form() {
		return igsch0201Form;
	}

	public void setIgsch0201Form(IGSCH0201Form igsch0201Form) {
		this.igsch0201Form = igsch0201Form;
	}

}