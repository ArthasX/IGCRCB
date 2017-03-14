package com.deliverik.infogovernor.prm.dto;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.prm.form.IGPRM0202Form;
import com.deliverik.infogovernor.prm.form.IGPRM0302Form;
import com.deliverik.infogovernor.prm.form.IGPRM0304Form;
import com.deliverik.infogovernor.prm.form.IGPRM0305Form;

public class IGPRM01DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String[] pidids;
	private IG259Info processTemplate;
	private IG380Info processDefinition;
	
	private List<String> processDefinitionSubscript;
	
	Map<IG259Info,List<IG380Info>> processMap = new LinkedHashMap<IG259Info, List<IG380Info>>();
	
	private IG007Info processInfoDef;
	
	private IGPRM0304Form igprm0304Form;
	
	private IGPRM0305Form igprm0305Form;
	
	/**服务目录URL*/
	private HashMap<String,String> map = new HashMap<String,String>();
	
	/**缺省审批人*/
	private Map<String,List<IG337Info>> approvorsMap;
	
	/**审批角色*/
	private Map<String,List<Role>> approveRolesMap;
	
	/**缺省审批分派人*/
	private List<IG337Info> approveDispatcherList;
	
	/**审批角色*/
	private List<Role> approveDispatcherRoleList;
	
	private List<IG259Info> processTemplateList;
	
	private List<IG380Info> processDefinitionList;
	
	private List<IG007Info> processInfoDefList;
	
	/**是否可以增加缺省审批人 1是0否*/
	private String addDefaultApprover;
	
	/**是否可以增加缺省审批分派人 1是0否*/
	private String addDefaultApproveDispatcher;

	/**
	 * 允许查询的最大记录数
	 */
	
	private int maxSearchCount;

	/**
	 * 分页Bean
	 */
	
	private PagingDTO pagingDto;
	
	private IGPRM0202Form igPRM0202Form;
	
	private IGPRM0302Form igPRM0302Form;
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public String[] getPidids() {
		return pidids;
	}

	public void setPidids(String[] pidids) {
		this.pidids = pidids;
	}

	public IG259Info getProcessTemplate() {
		return processTemplate;
	}

	public void setProcessTemplate(IG259Info processTemplate) {
		this.processTemplate = processTemplate;
	}

	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}

	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}

	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	public IGPRM0304Form getIgprm0304Form() {
		return igprm0304Form;
	}

	public void setIgprm0304Form(IGPRM0304Form igprm0304Form) {
		this.igprm0304Form = igprm0304Form;
	}

	public Map<String,List<IG337Info>> getApprovorsMap() {
		return approvorsMap;
	}

	public void setApprovorsMap(Map<String,List<IG337Info>> approvorsMap) {
		this.approvorsMap = approvorsMap;
	}

	public Map<String, List<Role>> getApproveRolesMap() {
		return approveRolesMap;
	}

	public void setApproveRolesMap(Map<String, List<Role>> approveRolesMap) {
		this.approveRolesMap = approveRolesMap;
	}

	public List<IG337Info> getApproveDispatcherList() {
		return approveDispatcherList;
	}

	public void setApproveDispatcherList(
			List<IG337Info> approveDispatcherList) {
		this.approveDispatcherList = approveDispatcherList;
	}

	public List<Role> getApproveDispatcherRoleList() {
		return approveDispatcherRoleList;
	}

	public void setApproveDispatcherRoleList(List<Role> approveDispatcherRoleList) {
		this.approveDispatcherRoleList = approveDispatcherRoleList;
	}

	public IGPRM0305Form getIgprm0305Form() {
		return igprm0305Form;
	}

	public void setIgprm0305Form(IGPRM0305Form igprm0305Form) {
		this.igprm0305Form = igprm0305Form;
	}

	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}

	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}

	public void setProcessInfoDefList(List<IG007Info> processInfoDefList) {
		this.processInfoDefList = processInfoDefList;
	}

	public String getAddDefaultApprover() {
		return addDefaultApprover;
	}

	public void setAddDefaultApprover(String addDefaultApprover) {
		this.addDefaultApprover = addDefaultApprover;
	}

	public String getAddDefaultApproveDispatcher() {
		return addDefaultApproveDispatcher;
	}

	public void setAddDefaultApproveDispatcher(String addDefaultApproveDispatcher) {
		this.addDefaultApproveDispatcher = addDefaultApproveDispatcher;
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public List<String> getProcessDefinitionSubscript() {
		return processDefinitionSubscript;
	}

	public void setProcessDefinitionSubscript(List<String> processDefinitionSubscript) {
		this.processDefinitionSubscript = processDefinitionSubscript;
	}

	public Map<IG259Info, List<IG380Info>> getProcessMap() {
		return processMap;
	}

	public void setProcessMap(
			Map<IG259Info, List<IG380Info>> processMap) {
		this.processMap = processMap;
	}

	public IGPRM0202Form getIgPRM0202Form() {
		return igPRM0202Form;
	}

	public void setIgPRM0202Form(IGPRM0202Form igPRM0202Form) {
		this.igPRM0202Form = igPRM0202Form;
	}

	public IGPRM0302Form getIgPRM0302Form() {
		return igPRM0302Form;
	}

	public void setIgPRM0302Form(IGPRM0302Form igPRM0302Form) {
		this.igPRM0302Form = igPRM0302Form;
	}
	
}