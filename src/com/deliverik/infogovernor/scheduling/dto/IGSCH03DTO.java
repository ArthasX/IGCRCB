package com.deliverik.infogovernor.scheduling.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.infogovernor.scheduling.form.IGSCH0301Form;
import com.deliverik.infogovernor.scheduling.form.IGSCH0302Form;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务策略_企业定时任务dto
 * </p>
 * 
 * @author maozhipengpeng@deliverik.com
 * @version 1.0
 */
public class IGSCH03DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private QuartzJobs quartzJobs;
	private IGSCH0301Form igsch0301Form;
	private IGSCH0302Form igsch0302Form;
	private QuartzProcessRecord quartzProcessRecord;
	private List<Role> rolelist;
	private String triggerName;
	private List<IG380Info> pdList;
	private List<IG007Info> pidList;
	private IG007Info processInfoDef;
	private String pdid;
	
	public List<IG380Info> getPdList() {
		return pdList;
	}

	public void setPdList(List<IG380Info> pdList) {
		this.pdList = pdList;
	}

	public List<IG007Info> getPidList() {
		return pidList;
	}

	public void setPidList(List<IG007Info> pidList) {
		this.pidList = pidList;
	}

	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}

	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public QuartzJobs getQuartzJobs() {
		return quartzJobs;
	}

	public void setQuartzJobs(QuartzJobs quartzJobs) {
		this.quartzJobs = quartzJobs;
	}

	public IGSCH0301Form getIgsch0301Form() {
		return igsch0301Form;
	}

	public void setIgsch0301Form(IGSCH0301Form igsch0301Form) {
		this.igsch0301Form = igsch0301Form;
	}

	public List<Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}

	public QuartzProcessRecord getQuartzProcessRecord() {
		return quartzProcessRecord;
	}

	public void setQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord) {
		this.quartzProcessRecord = quartzProcessRecord;
	}

	public IGSCH0302Form getIgsch0302Form() {
		return igsch0302Form;
	}

	public void setIgsch0302Form(IGSCH0302Form igsch0302Form) {
		this.igsch0302Form = igsch0302Form;
	}

}