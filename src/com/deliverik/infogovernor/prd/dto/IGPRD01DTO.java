/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG211TB;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.infogovernor.prd.form.IGPRD0101Form;
import com.deliverik.infogovernor.prd.form.IGPRD0102Form;
import com.deliverik.infogovernor.prd.form.IGPRD0104Form;
import com.deliverik.infogovernor.prd.form.IGPRD0105Form;
import com.deliverik.infogovernor.prd.form.IGPRD0107Form;
import com.deliverik.infogovernor.prd.form.IGPRD0108Form;
import com.deliverik.infogovernor.prd.form.IGPRD0109Form;
import com.deliverik.infogovernor.prd.form.IGPRD0110Form;
import com.deliverik.infogovernor.prd.form.IGPRD0111Form;
import com.deliverik.infogovernor.prd.form.IGPRD0114Form;
import com.deliverik.infogovernor.prd.form.IGPRD0115Form;
import com.deliverik.infogovernor.prd.form.IGPRD0116Form;
import com.deliverik.infogovernor.prd.form.IGPRD0118Form;
import com.deliverik.infogovernor.prd.form.IGPRD0124Form;
import com.deliverik.infogovernor.prd.form.IGPRD0125Form;
import com.deliverik.infogovernor.prd.form.IGPRD0126Form;
import com.deliverik.infogovernor.prd.form.IGPRD0131Form;
import com.deliverik.infogovernor.prd.form.IGPRD0134Form;
import com.deliverik.infogovernor.prd.form.IGPRD0139Form;
import com.deliverik.infogovernor.prd.form.IGPRD0141Form;
import com.deliverik.infogovernor.prd.form.IGPRD0142Form;
import com.deliverik.infogovernor.prd.form.IGPRD0143Form;
import com.deliverik.infogovernor.prd.form.IGPRD0145Form;
import com.deliverik.infogovernor.prd.form.IGPRD0158Form;
import com.deliverik.infogovernor.prd.form.IGPRD0159Form;
import com.deliverik.infogovernor.prd.form.IGPRD0161Form;
import com.deliverik.infogovernor.prd.form.IGPRD0165Form;
import com.deliverik.infogovernor.prd.form.IGPRD0166Form;
import com.deliverik.infogovernor.prd.form.IGPRD0168Form;
import com.deliverik.infogovernor.prd.form.IGPRD0169Form;
import com.deliverik.infogovernor.prd.form.IGPRD0171Form;
import com.deliverik.infogovernor.prd.form.IGPRD0172Form;
import com.deliverik.infogovernor.prd.form.IGPRD0173Form;
import com.deliverik.infogovernor.prd.form.IGPRD0190Form;

/**
 * 概述: 流程定义业务DTO 功能描述: 流程定义业务DTO 创建记录: 2010/11/07 修改记录: 2013/02/25 130225
 * 流程机构相关修改-状态节点参与者类型修改
 */
@SuppressWarnings("serial")
public class IGPRD01DTO extends BaseDTO implements Serializable {

	// -----------------------------------------------------------流程定义----------------------------------------------------------------------

	// ====>130225Begin

	/** 流程定义状态节点参与者类型集合(人员和角色) */
	protected List<LabelValueBean> lvPsdassignListUR;
	/** 流程定义状态节点参与者类型集合(角色和机构) */
	protected List<LabelValueBean> lvPsdassignListRO;

	/** 状态节点可分派机构Form */
	protected IGPRD0143Form igPRD0143Form;

	/** 状态节点可分派机构集合 */
	protected List<Organization> lst_org;

	/** 已选机构列表 */
	protected List<IG299Info> lst_ProcessStatusOrgDef;

	/** 参与者支持机构选择form */
	protected IGPRD0134Form igprd0134Form;

	/** 机构范围选择form */
	protected IGPRD0131Form igprd0131Form;

	/** 可选机构 */
	protected List<IG123Info> lst_orgdef;

	/** 表格类表单预览form */
	protected IGPRD0173Form igprd0173Form;
	
	/** 表单定义信息 */
	protected IG007Info processInfoDef;
	
	/** 页面显示策略信息Map */
	protected Map<IG238Info, List<IG335Info>> showMap;

	/** 状态个数 */
	protected int pssize;
	
	/** 状态表单值个数 */
	protected int pisize;
	
	/** 超时提醒通知BL定义List */
	protected List<LabelValueBean> proccessBLList;
	
	/** 整体超时提醒通知BL定义List */
	protected List<LabelValueBean> processtacticsbl_alllist;
	
	/** 流程整体策略 */
	protected List<IG335Info> processWholeTactic_list;
	
	/** 流程整体策略表单值个数 */
	protected Integer processWholeTactic_listSize;
	
	/** 状态级私有表单默认值列表  */
    protected List<IG560VWInfo> defaultlist;
    
    /** 已设定流程查询显示列集合 */
    protected List<IG110Info> queryShowColumnList;
    
    /** 未设定流程查询显示列集合 */
    protected Map<String, String> queryShowColumnMap;
    
    /** 已设定查询条件集合 */
    protected List<IG111Info> queryList;
    
    /** 未设定查询条件集合 */
    protected Map<String, String> queryMap;
    

    public List<IG560VWInfo> getDefaultlist() {
        return defaultlist;
    }

    public void setDefaultlist(List<IG560VWInfo> defaultlist) {
        this.defaultlist = defaultlist;
    }
	
	/**
	 * 状态节点可分派机构Form取得
	 * 
	 * @return igPRD0143Form 状态节点可分派机构Form
	 */
	public IGPRD0143Form getIgPRD0143Form() {
		return igPRD0143Form;
	}

	/**
	 * 状态节点可分派机构Form设定
	 * 
	 * @param igPRD0143Form
	 *            状态节点可分派机构Form
	 */
	public void setIgPRD0143Form(IGPRD0143Form igPRD0143Form) {
		this.igPRD0143Form = igPRD0143Form;
	}

	/**
	 * 流程定义状态节点参与者类型集合取得
	 * 
	 * @return lvPsdassignListUR 流程定义状态节点参与者类型集合
	 */

	public List<LabelValueBean> getLvPsdassignListUR() {
		return lvPsdassignListUR;
	}

	/**
	 * 流程定义状态节点参与者类型集合设定
	 * 
	 * @param lvPsdassignListUR
	 *            流程定义状态节点参与者类型集合
	 */
	public void setLvPsdassignListUR(List<LabelValueBean> lvPsdassignListUR) {
		this.lvPsdassignListUR = lvPsdassignListUR;
	}

	/**
	 * 流程定义状态节点参与者类型集合(角色和机构)取得
	 * 
	 * @return lvPsdassignListRO 流程定义状态节点参与者类型集合(角色和机构)
	 */
	public List<LabelValueBean> getLvPsdassignListRO() {
		return lvPsdassignListRO;
	}

	/**
	 * 流程定义状态节点参与者类型集合(角色和机构)设定
	 * 
	 * @param lvPsdassignListRO
	 *            流程定义状态节点参与者类型集合(角色和机构)
	 */
	public void setLvPsdassignListRO(List<LabelValueBean> lvPsdassignListRO) {
		this.lvPsdassignListRO = lvPsdassignListRO;
	}

	/**
	 * 状态节点可分派机构集合取得
	 * 
	 * @return lst_org 状态节点可分派机构集合
	 */
	public List<Organization> getLst_org() {
		return lst_org;
	}

	/**
	 * 状态节点可分派机构集合设定
	 * 
	 * @param lst_org
	 *            状态节点可分派机构集合
	 */
	public void setLst_org(List<Organization> lst_org) {
		this.lst_org = lst_org;
	}

	/**
	 * 已选机构列表取得
	 * 
	 * @return lst_ProcessStatusOrgDef 已选机构列表
	 */
	public List<IG299Info> getLst_ProcessStatusOrgDef() {
		return lst_ProcessStatusOrgDef;
	}

	/**
	 * 已选机构列表设定
	 * 
	 * @param lst_ProcessStatusOrgDef
	 *            已选机构列表
	 */
	public void setLst_ProcessStatusOrgDef(
			List<IG299Info> lst_ProcessStatusOrgDef) {
		this.lst_ProcessStatusOrgDef = lst_ProcessStatusOrgDef;
	}

	// ====>130225End

	/** 流程定义信息检索条件 */
	protected IG380SearchCond processDefinitionSearchCond;

	/** 流程定义信息Form */
	protected IGPRD0102Form igPRD0102Form;

	/** 流程定义信息检索结果集 */
	protected List<IG380Info> processDefinitionList;

	/** 相关发起自定义流程类型信息检索结果集 */
	protected List<IG913Info> relevantProcessDefinitionList;

	/** 判断当前是否存在未关闭的流程在使用模板 */
	protected String isProcessDefinitionInUse;

	protected String delFalg;

	protected List<IG413Info> processEventDefList;

	protected List<IG156Info> processStatusButtonDefList;

	/** 表单联动检索条件 */
	protected IG286SearchCond processLinkageDefSearchCond;

	/** 表单级联检索结果集 */
	protected List<IG286Info> processLinkageDefList;

	/** 表单联动Form */
	protected IGPRD0125Form igPRD0125Form;

	protected List<IG725Info> participantDefaultButtonDefInfoList;

	protected List<IG333TB> psdTBList;

	/** 流程定义导入Form */
	protected IGPRD0101Form igPRD0101Form;

	/** 导出文件路径 */
	protected String filepath_export;

	// -----------------------------------------------------------表单信息----------------------------------------------------------------------

	public List<IG725Info> getParticipantDefaultButtonDefInfoList() {
		return participantDefaultButtonDefInfoList;
	}

	public void setParticipantDefaultButtonDefInfoList(
			List<IG725Info> participantDefaultButtonDefInfoList) {
		this.participantDefaultButtonDefInfoList = participantDefaultButtonDefInfoList;
	}

	public List<IG156Info> getProcessStatusButtonDefList() {
		return processStatusButtonDefList;
	}

	public List<IG413Info> getProcessEventDefList() {
		return processEventDefList;
	}

	public void setProcessEventDefList(List<IG413Info> processEventDefList) {
		this.processEventDefList = processEventDefList;
	}

	public void setProcessStatusButtonDefList(
			List<IG156Info> processStatusButtonDefList) {
		this.processStatusButtonDefList = processStatusButtonDefList;
	}

	public String getDelFalg() {
		return delFalg;
	}

	public void setDelFalg(String delFalg) {
		this.delFalg = delFalg;
	}

	/** 表单信息信息检索条件 */
	protected IG007SearchCond processInfoDefSearchCond;

	protected IG202SearchCond processInfoDefGeneralSearchCond;

	/** 表单信息信息检索结果集 */
	protected List<IG007Info> processInfoDefList;

	/** 表单信息信息Form */
	protected IGPRD0111Form igPRD0111Form;

	protected IGPRD0118Form igPRD0118Form;

	protected IGPRD0124Form igPRD0124Form;

	protected IGPRD0171Form igPRD0171Form;

	protected IGPRD0172Form igPRD0172Form;

	/** 参与者表单权限信息集合 */
	protected List<IG100Info> lst_ProcessInfoParticipantDefVW;

	/** 缺省表单权限信息集合 */
	protected List<IG909Info> lst_ParticipantDefaultVariableVW;

	// -----------------------------------------------------------流程状态----------------------------------------------------------------------

	/** 流程状态信息检索条件 */
	protected IG333SearchCond processStatusDefSearchCond;

	/** 流程状态信息检索结果集 */
	protected List<IG333Info> processStatusDefList;

	/** 流程状态_参与者集合 */
	protected List<IG222Info> processParticipantDefList;
	
	/** 流程状态_参与者集合 */
	protected Map<Integer, List<IG222Info>> processParticipantDefMap;

	/** 流程状态_参与者_流程变量的授权信息集合 */
	protected List<IG881Info> processInfoParticipantDefList;

	/** 流程状态_缺省参与者_流程变量的授权信息集合 */
	protected List<IG699Info> participantDefaultVariableList;

	/** 流程状态_参与者 */
	protected IG222Info processParticipantDef;

	/** 流程状态信息检索Form */
	protected IGPRD0104Form igPRD0104Form;

	/** 流程状态新增信息Form */
	protected IGPRD0105Form igPRD0105Form;
	
	/** 流程状态参与者Form */
	protected IGPRD0107Form igPRD0107Form;

	/** 流程状态参与者_权限Form */
	protected IGPRD0108Form igPRD0108Form;

	/** 流程状态缺省参与者_权限Form */
	protected IGPRD0116Form igPRD0116Form;

	/** 流程状态可添加参与者集合 */
	protected List<Role> roleList;

	/** 流程状态_参与者是否拥有批准权限 */
	protected String isPpapprove;//

	/** 流程状态_参与者是否拥有驳回权限 */
	protected String isPpdeny;

	/** 流程状态_参与者是否拥有提交权限 */
	protected String isPpsubmit;

	/** 流程状态_参与者是否拥有中止权限 */
	protected String isPpterm;

	/** 流程状态_参与者是否拥有更新权限 */
	protected String isPpupdate;
	// -----------------------------------------------------------分派角色----------------------------------------------------------------------

	/** 分派角色信息Form */
	protected IGPRD0114Form igPRD0114Form;

	/** 流程状态可分派角色定义Form */
	protected IGPRD0139Form igPRD0139Form;

	/** 可选角色列表 */
	protected List<Role> lst_Role;

	/** 已选角色列表 */
	protected List<IG298Info> lst_ProcessStatusRoleDef;
	// -----------------------------------------------------------前处理----------------------------------------------------------------------
	/** 前处理变量信息集合 */
	protected List<IG211TB> psidList;

	protected IGPRD0126Form igPRD0126Form;

	public IGPRD0126Form getIgPRD0126Form() {
		return igPRD0126Form;
	}

	public void setIgPRD0126Form(IGPRD0126Form igPRD0126Form) {
		this.igPRD0126Form = igPRD0126Form;
	}

	/** 自定义流程页面设置Form 20121113 崔学志 */
	protected IGPRD0168Form igPRD0168Form;
	/** 自定义流程页面设置新增Form 20121113 崔学志 */
	protected IGPRD0169Form igPRD0169Form;

	/** 自定义流程页面设置检索结果集 */
	protected List<IG126Info> processJspInfoList;

	/** 自定义路程页面设置 查询流程名称 */
	protected IG380Info ig380info;
	// -----------------------------------------------------------规则定义----------------------------------------------------------------------

	/** 规则定义信息Form */
	protected IGPRD0109Form igPRD0109Form;

	/** 并行节点规则定义信息Form */
	protected IGPRD0115Form igPRD0115Form;

	/** 流程状态信息 */
	protected IG333Info processStatusDef;

	/** 规则定义信息检索结果 */
	protected List<IG273Info> processTransitionDefList;

	/** 已选角色类型结果 */
	protected List<IG213Info> processRoleTypeDefList;

	/** 下拉列表 */
	protected List<LabelValueBean> labelList;

	protected List<CodeDetail> codeDetailList;

	protected List<IG202Info> processInfoDefGeneralList;

	/** 流程导出校验错误信息 */
	protected List<String> errorMessages;

	public List<IG202Info> getProcessInfoDefGeneralList() {
		return processInfoDefGeneralList;
	}

	public void setProcessInfoDefGeneralList(
			List<IG202Info> processInfoDefGeneralList) {
		this.processInfoDefGeneralList = processInfoDefGeneralList;
	}

	public IG202SearchCond getProcessInfoDefGeneralSearchCond() {
		return processInfoDefGeneralSearchCond;
	}

	public void setProcessInfoDefGeneralSearchCond(
			IG202SearchCond processInfoDefGeneralSearchCond) {
		this.processInfoDefGeneralSearchCond = processInfoDefGeneralSearchCond;
	}

	/** 流程定义信息最大检索件数 */
	protected int maxSearchCount;

	/** 分页用DTO */
	protected PagingDTO pagingDto;

	protected String imgxml;

	protected String pdid;

	protected String flag;

	/** 流程状态ID */
	protected String psdid;
	
	/** 流程通知策略设定Form */
	protected IGPRD0158Form igPRD0158Form;

	/** 流程策略列表 */
	protected List<IG238Info> lst_ProcessNoticeStrategyDef;

	/** 角色用户列表 */
	protected List<UserRoleInfo> lst_UserRoleInfo;

	/** 流程策略通知人查询Form */
	protected IGPRD0159Form igPRD0159Form;

	/** 表单初始化配置查询Form */
	protected IGPRD0165Form igPRD0165Form;

	/** 表单初始化配置列表 */
	protected List<IG373Info> lst_IG373Info;

	/** 表单初始化配置新增Form */
	protected IGPRD0166Form igPRD0166Form;

	/** 已选机构集合 */
	protected List<IG123Info> pordList;

	/** 可选机构集合 */
	protected Map<Organization, List<Organization>> orgTreeMap;
	
	/** 表单管理form */
	protected IGPRD0110Form igprd0110Form;
	
	/** 流程类型 */
	protected String pttype;
	
	/** 流程模板信息 */
	protected IG259Info processTemplate;

	/**
	 * 参与者支持机构选择form取得
	 * 
	 * @return igprd0134Form 参与者支持机构选择form
	 */
	public IGPRD0134Form getIgprd0134Form() {
		return igprd0134Form;
	}

	/**
	 * 参与者支持机构选择form设定
	 * 
	 * @param igprd0134Form
	 *            参与者支持机构选择form
	 */
	public void setIgprd0134Form(IGPRD0134Form igprd0134Form) {
		this.igprd0134Form = igprd0134Form;
	}

	/**
	 * 机构范围选择form取得
	 * 
	 * @return igprd0131Form 机构范围选择form
	 */

	public IGPRD0131Form getIgprd0131Form() {
		return igprd0131Form;
	}

	/**
	 * 机构范围选择form设定
	 * 
	 * @param igprd0131Form
	 *            机构范围选择form
	 */
	public void setIgprd0131Form(IGPRD0131Form igprd0131Form) {
		this.igprd0131Form = igprd0131Form;
	}

	/**
	 * 可选机构取得
	 * 
	 * @return lst_orgdef 可选机构
	 */
	public List<IG123Info> getLst_orgdef() {
		return lst_orgdef;
	}

	/**
	 * 可选机构设定
	 * 
	 * @param lst_orgdef
	 *            可选机构
	 */
	public void setLst_orgdef(List<IG123Info> lst_orgdef) {
		this.lst_orgdef = lst_orgdef;
	}

	/**
	 * 已选机构集合取得
	 * 
	 * @return pordList 已选机构集合
	 */
	public List<IG123Info> getPordList() {
		return pordList;
	}

	/**
	 * 已选机构集合设定
	 * 
	 * @param pordList
	 *            已选机构集合
	 */
	public void setPordList(List<IG123Info> pordList) {
		this.pordList = pordList;
	}

	/**
	 * 可选机构集合取得
	 * 
	 * @return orgTreeMap 可选机构集合
	 */
	public Map<Organization, List<Organization>> getOrgTreeMap() {
		return orgTreeMap;
	}

	/**
	 * 可选机构集合设定
	 * 
	 * @param orgTreeMap
	 *            可选机构集合
	 */
	public void setOrgTreeMap(Map<Organization, List<Organization>> orgTreeMap) {
		this.orgTreeMap = orgTreeMap;
	}

	public IGPRD0118Form getIgPRD0118Form() {
		return igPRD0118Form;
	}

	public void setIgPRD0118Form(IGPRD0118Form igPRD0118Form) {
		this.igPRD0118Form = igPRD0118Form;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	// 自定义流程管理列表流程类型
	protected Map<String, String> map;

	/** 下拉列表信息 */
	protected Map<String, String[]> optionMap;

	/** 已添加角色类型List */
	protected List<IG700Info> ig700InfoList;

	/** 已添加表单List */
	protected List<IG701Info> ig701InfoList;

	/** 已选查询条件 */
	protected List<IG108Info> pqList;
	/** 可选查询条件 */
	protected List<IG007Info> pdList;

	/** 查询条件配置form */
	protected IGPRD0145Form igprd0145Form;

	/** 分派节点信息集合 */
	protected List<IG233Info> apList;

	/** 表格类表单列信息 */
	protected Map<String, List<IG007Info>> columnInfoMap;

	/** 表单定义信息 */
	protected IG007Info pidInfo;
	
	/** AJAX返回结果 */
	protected String ajaxResult;

	public List<IG701Info> getIg701InfoList() {
		return ig701InfoList;
	}

	public void setIg701InfoList(List<IG701Info> ig701InfoList) {
		this.ig701InfoList = ig701InfoList;
	}

	public List<IG700Info> getIg700InfoList() {
		return ig700InfoList;
	}

	public void setIg700InfoList(List<IG700Info> ig700InfoList) {
		this.ig700InfoList = ig700InfoList;
	}

	public Map<String, String[]> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(Map<String, String[]> optionMap) {
		this.optionMap = optionMap;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getIsProcessDefinitionInUse() {
		return isProcessDefinitionInUse;
	}

	public void setIsProcessDefinitionInUse(String isProcessDefinitionInUse) {
		this.isProcessDefinitionInUse = isProcessDefinitionInUse;
	}

	public String getImgxml() {
		return imgxml;
	}

	public void setImgxml(String imgxml) {
		this.imgxml = imgxml;
	}

	/**
	 * 流程状态_参与者是否拥有批准权限取得
	 * 
	 * @return 流程状态_参与者是否拥有批准权限
	 */
	public String getIsPpapprove() {
		return isPpapprove;
	}

	/**
	 * 流程状态_参与者是否拥有批准权限设定
	 * 
	 * @param isPpapprove
	 *            流程状态_参与者是否拥有批准权限
	 */
	public void setIsPpapprove(String isPpapprove) {
		this.isPpapprove = isPpapprove;
	}

	/**
	 * 流程状态_参与者是否拥有驳回权限取得
	 * 
	 * @return 流程状态_参与者是否拥有驳回权限
	 */
	public String getIsPpdeny() {
		return isPpdeny;
	}

	/**
	 * 流程状态_参与者是否拥有驳回权限设定
	 * 
	 * @param isPpdeny
	 *            流程状态_参与者是否拥有驳回权限
	 */
	public void setIsPpdeny(String isPpdeny) {
		this.isPpdeny = isPpdeny;
	}

	/**
	 * 流程状态_参与者是否拥有提交权限取得
	 * 
	 * @return 流程状态_参与者是否拥有提交权限
	 */
	public String getIsPpsubmit() {
		return isPpsubmit;
	}

	/**
	 * 流程状态_参与者是否拥有提交权限设定
	 * 
	 * @param isPpsubmit
	 *            流程状态_参与者是否拥有提交权限
	 */
	public void setIsPpsubmit(String isPpsubmit) {
		this.isPpsubmit = isPpsubmit;
	}

	/**
	 * 流程状态_参与者是否拥有中止权限取得
	 * 
	 * @return 流程状态_参与者是否拥有中止权限
	 */
	public String getIsPpterm() {
		return isPpterm;
	}

	/**
	 * 流程状态_参与者是否拥有中止权限设定
	 * 
	 * @param isPpterm
	 *            流程状态_参与者是否拥有中止权限
	 */
	public void setIsPpterm(String isPpterm) {
		this.isPpterm = isPpterm;
	}

	/**
	 * 流程状态_参与者是否拥有更新权限取得
	 * 
	 * @return 流程状态_参与者是否拥有更新权限
	 */
	public String getIsPpupdate() {
		return isPpupdate;
	}

	/**
	 * 流程状态_参与者是否拥有更新权限设定
	 * 
	 * @param isPpupdate
	 *            流程状态_参与者是否拥有更新权限
	 */
	public void setIsPpupdate(String isPpupdate) {
		this.isPpupdate = isPpupdate;
	}

	/**
	 * 流程状态_参与者_流程变量的授权信息集合取得
	 * 
	 * @return 流程状态_参与者_流程变量的授权信息集合
	 */
	public List<IG881Info> getProcessInfoParticipantDefList() {
		return processInfoParticipantDefList;
	}

	/**
	 * 流程状态_参与者_流程变量的授权信息集合设定
	 * 
	 * @param processInfoParticipantDefList
	 *            流程状态_参与者_流程变量的授权信息集合
	 */
	public void setProcessInfoParticipantDefList(
			List<IG881Info> processInfoParticipantDefList) {
		this.processInfoParticipantDefList = processInfoParticipantDefList;
	}

	/**
	 * 流程状态_参与者取得
	 * 
	 * @return 流程状态_参与者
	 */
	public IG222Info getProcessParticipantDef() {
		return processParticipantDef;
	}

	/**
	 * 流程状态_参与者设定
	 * 
	 * @param processParticipantDef
	 *            流程状态_参与者
	 */
	public void setProcessParticipantDef(IG222Info processParticipantDef) {
		this.processParticipantDef = processParticipantDef;
	}

	/**
	 * 流程状态参与者_权限Form取得
	 * 
	 * @return 流程状态参与者_权限Form
	 */
	public IGPRD0108Form getIgPRD0108Form() {
		return igPRD0108Form;
	}

	/**
	 * 流程状态参与者_权限Form设定
	 * 
	 * @param roleList
	 *            流程状态参与者_权限Form
	 */
	public void setIgPRD0108Form(IGPRD0108Form igPRD0108Form) {
		this.igPRD0108Form = igPRD0108Form;
	}

	/**
	 * 流程状态可添加参与者集合取得
	 * 
	 * @return 流程状态可添加参与者集合
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * 流程状态可添加参与者集合设定
	 * 
	 * @param roleList
	 *            流程状态可添加参与者集合
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 流程状态信息检索条件取得
	 * 
	 * @return 流程状态信息检索条件
	 */
	public IG333SearchCond getProcessStatusDefSearchCond() {
		return processStatusDefSearchCond;
	}

	/**
	 * 流程状态信息检索条件设定
	 * 
	 * @param processStatusDefSearchCond
	 *            流程状态信息检索条件
	 */
	public void setProcessStatusDefSearchCond(
			IG333SearchCond processStatusDefSearchCond) {
		this.processStatusDefSearchCond = processStatusDefSearchCond;
	}

	/**
	 * 流程状态信息检索结果集取得
	 * 
	 * @return 流程状态信息检索结果集
	 */
	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	/**
	 * 流程状态信息检索结果集设定
	 * 
	 * @param processStatusDefList
	 *            流程状态信息检索结果集
	 */
	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}

	/**
	 * 流程状态信息检索form取得
	 * 
	 * @return 流程状态信息检索form
	 */
	public IGPRD0104Form getIgPRD0104Form() {
		return igPRD0104Form;
	}

	/**
	 * 流程状态信息检索form设定
	 * 
	 * @param igPRD0104Form
	 *            流程状态信息检索form
	 */
	public void setIgPRD0104Form(IGPRD0104Form igPRD0104Form) {
		this.igPRD0104Form = igPRD0104Form;
	}

	/**
	 * 流程状态新增信息form取得
	 * 
	 * @return 流程状态新增信息form
	 */
	public IGPRD0105Form getIgPRD0105Form() {
		return igPRD0105Form;
	}

	/**
	 * 流程状态新增信息form设定
	 * 
	 * @param igPRD0105Form
	 *            流程状态新增信息form
	 */
	public void setIgPRD0105Form(IGPRD0105Form igPRD0105Form) {
		this.igPRD0105Form = igPRD0105Form;
	}

	/**
	 * 流程状态参与者集合取得
	 * 
	 * @return 流程状态参与者集合
	 */
	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}

	/**
	 * 流程状态参与者集合设定
	 * 
	 * @param processParticipantDefList
	 *            流程状态参与者集合
	 */
	public void setProcessParticipantDefList(
			List<IG222Info> processParticipantDefList) {
		this.processParticipantDefList = processParticipantDefList;
	}

	/**
	 * 流程状态参与者Form取得
	 * 
	 * @return 流程状态参与者Form
	 */
	public IGPRD0107Form getIgPRD0107Form() {
		return igPRD0107Form;
	}

	/**
	 * 流程状态参与者Form设定
	 * 
	 * @param igPRD0104Form
	 *            流程状态参与者Form
	 */
	public void setIgPRD0107Form(IGPRD0107Form igPRD0107Form) {
		this.igPRD0107Form = igPRD0107Form;
	}

	/**
	 * 流程定义信息检索条件取得
	 * 
	 * @return 流程定义信息检索条件
	 */
	public IG380SearchCond getProcessDefinitionSearchCond() {
		return processDefinitionSearchCond;
	}

	/**
	 * 流程定义信息检索条件设定
	 * 
	 * @param processDefinitionSearchCond
	 *            流程定义信息检索条件
	 */
	public void setProcessDefinitionSearchCond(
			IG380SearchCond processDefinitionSearchCond) {
		this.processDefinitionSearchCond = processDefinitionSearchCond;
	}

	/**
	 * 流程定义信息检索结果集取得
	 * 
	 * @return 流流程定义信息检索结果集
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * 流程定义信息检索结果集设定
	 * 
	 * @param processDefinitionList
	 *            流程定义信息检索结果集
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * 流程定义信息最大检索件数取得
	 * 
	 * @return 流程定义信息最大检索件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 流程定义信息最大检索件数设定
	 * 
	 * @param maxSearchCount
	 *            流程定义信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页用DTO取得
	 * 
	 * @return 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 * 
	 * @param pagingDto
	 *            分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 流程定义信息Form取得
	 * 
	 * @return 流程定义信息Form
	 */
	public IGPRD0102Form getIgPRD0102Form() {
		return igPRD0102Form;
	}

	/**
	 * 流程定义信息Form设定
	 * 
	 * @param igPRD0102Form
	 *            流程定义信息Form
	 */
	public void setIgPRD0102Form(IGPRD0102Form igPRD0102Form) {
		this.igPRD0102Form = igPRD0102Form;
	}

	/**
	 * 表单信息信息检索条件取得
	 * 
	 * @return 表单信息信息检索条件
	 */
	public IG007SearchCond getProcessInfoDefSearchCond() {
		return processInfoDefSearchCond;
	}

	/**
	 * 表单信息信息检索条件设定
	 * 
	 * @param processInfoDefSearchCond
	 *            表单信息信息检索条件
	 */
	public void setProcessInfoDefSearchCond(
			IG007SearchCond processInfoDefSearchCond) {
		this.processInfoDefSearchCond = processInfoDefSearchCond;
	}

	/**
	 * 表单信息信息检索结果集取得
	 * 
	 * @return 表单信息信息检索结果集
	 */
	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}

	/**
	 * 表单信息信息检索结果集设定
	 * 
	 * @param processInfoDefList
	 *            表单信息信息检索结果集
	 */
	public void setProcessInfoDefList(List<IG007Info> processInfoDefList) {
		this.processInfoDefList = processInfoDefList;
	}

	/**
	 * 表单信息信息Form取得
	 * 
	 * @return 表单信息信息Form
	 */
	public IGPRD0111Form getIgPRD0111Form() {
		return igPRD0111Form;
	}

	/**
	 * 表单信息信息Form设定
	 * 
	 * @param igPRD0111Form
	 *            表单信息信息Form
	 */
	public void setIgPRD0111Form(IGPRD0111Form igPRD0111Form) {
		this.igPRD0111Form = igPRD0111Form;
	}

	/**
	 * 前处理变量信息集合取得
	 * 
	 * @return 前处理变量信息集合
	 */
	public List<IG211TB> getPsidList() {
		return psidList;
	}

	/**
	 * 前处理变量信息集合设定
	 * 
	 * @param psidList
	 *            前处理变量信息集合
	 */
	public void setPsidList(List<IG211TB> psidList) {
		this.psidList = psidList;
	}

	/**
	 * 规则定义信息Form取得
	 * 
	 * @return 规则定义信息Form
	 */
	public IGPRD0109Form getIgPRD0109Form() {
		return igPRD0109Form;
	}

	/**
	 * 规则定义信息Form设定
	 * 
	 * @param igPRD0109Form
	 *            规则定义信息Form
	 */
	public void setIgPRD0109Form(IGPRD0109Form igPRD0109Form) {
		this.igPRD0109Form = igPRD0109Form;
	}

	/**
	 * 规则定义信息检索结果取得
	 * 
	 * @return 规则定义信息检索结果
	 */
	public List<IG273Info> getProcessTransitionDefList() {
		return processTransitionDefList;
	}

	/**
	 * 规则定义信息检索结果设定
	 * 
	 * @param processTransitionDefList
	 *            规则定义信息检索结果
	 */
	public void setProcessTransitionDefList(
			List<IG273Info> processTransitionDefList) {
		this.processTransitionDefList = processTransitionDefList;
	}

	/**
	 * 流程状态信息取得
	 * 
	 * @return 流程状态信息
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * 流程状态信息设定
	 * 
	 * @param processStatusDef
	 *            流程状态信息
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * 下拉列表取得
	 * 
	 * @return 下拉列表
	 */
	public List<LabelValueBean> getLabelList() {
		return labelList;
	}

	/**
	 * 下拉列表设定
	 * 
	 * @param labelList
	 *            下拉列表
	 */
	public void setLabelList(List<LabelValueBean> labelList) {
		this.labelList = labelList;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	/**
	 * 分派角色Form取得
	 * 
	 * @return 分派角色Form
	 */
	public IGPRD0114Form getIgPRD0114Form() {
		return igPRD0114Form;
	}

	/**
	 * 分派角色Form设定
	 * 
	 * @param igPRD0114Form分派角色Form
	 */
	public void setIgPRD0114Form(IGPRD0114Form igPRD0114Form) {
		this.igPRD0114Form = igPRD0114Form;
	}

	/**
	 * 流程状态可分派角色定义Form取得
	 * 
	 * @return 流程状态可分派角色定义Form
	 */
	public IGPRD0139Form getIgPRD0139Form() {
		return igPRD0139Form;
	}

	/**
	 * 流程状态可分派角色定义Form设定
	 * 
	 * @param igPRD0139Form
	 *            流程状态可分派角色定义Form
	 */
	public void setIgPRD0139Form(IGPRD0139Form igPRD0139Form) {
		this.igPRD0139Form = igPRD0139Form;
	}

	/**
	 * 可选角色列表取得
	 * 
	 * @return 可选角色列表
	 */
	public List<Role> getLst_Role() {
		return lst_Role;
	}

	/**
	 * 可选角色列表设定
	 * 
	 * @param lst_Role
	 *            可选角色列表
	 */
	public void setLst_Role(List<Role> lst_Role) {
		this.lst_Role = lst_Role;
	}

	/**
	 * 已选角色列表取得
	 * 
	 * @return 已选角色列表
	 */
	public List<IG298Info> getLst_ProcessStatusRoleDef() {
		return lst_ProcessStatusRoleDef;
	}

	/**
	 * 已选角色列表设定
	 * 
	 * @param lst_ProcessStatusRoleDef
	 *            已选角色列表
	 */
	public void setLst_ProcessStatusRoleDef(
			List<IG298Info> lst_ProcessStatusRoleDef) {
		this.lst_ProcessStatusRoleDef = lst_ProcessStatusRoleDef;
	}

	/**
	 * 并行节点规则定义信息Form取得
	 * 
	 * @return 并行节点规则定义信息Form
	 */
	public IGPRD0115Form getIgPRD0115Form() {
		return igPRD0115Form;
	}

	/**
	 * 并行节点规则定义信息Form设定
	 * 
	 * @param igPRD0115Form并行节点规则定义信息Form
	 */
	public void setIgPRD0115Form(IGPRD0115Form igPRD0115Form) {
		this.igPRD0115Form = igPRD0115Form;
	}

	/**
	 * 流程状态缺省参与者_权限Form取得
	 * 
	 * @return 流程状态缺省参与者_权限Form
	 */
	public IGPRD0116Form getIgPRD0116Form() {
		return igPRD0116Form;
	}

	/**
	 * 流程状态缺省参与者_权限Form设定
	 * 
	 * @param igPRD0116Form流程状态缺省参与者_权限Form
	 */
	public void setIgPRD0116Form(IGPRD0116Form igPRD0116Form) {
		this.igPRD0116Form = igPRD0116Form;
	}

	/**
	 * 流程状态_缺省参与者_流程变量的授权信息集合取得
	 * 
	 * @return 流程状态_缺省参与者_流程变量的授权信息集合
	 */
	public List<IG699Info> getParticipantDefaultVariableList() {
		return participantDefaultVariableList;
	}

	/**
	 * 流程状态_缺省参与者_流程变量的授权信息集合设定
	 * 
	 * @param participantDefaultVariableList流程状态_缺省参与者_流程变量的授权信息集合
	 */
	public void setParticipantDefaultVariableList(
			List<IG699Info> participantDefaultVariableList) {
		this.participantDefaultVariableList = participantDefaultVariableList;
	}

	public IGPRD0124Form getIgPRD0124Form() {
		return igPRD0124Form;
	}

	public void setIgPRD0124Form(IGPRD0124Form igPRD0124Form) {
		this.igPRD0124Form = igPRD0124Form;
	}

	public List<IG213Info> getProcessRoleTypeDefList() {
		return processRoleTypeDefList;
	}

	public void setProcessRoleTypeDefList(List<IG213Info> processRoleTypeDefList) {
		this.processRoleTypeDefList = processRoleTypeDefList;
	}

	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	public IG286SearchCond getProcessLinkageDefSearchCond() {
		return processLinkageDefSearchCond;
	}

	public void setProcessLinkageDefSearchCond(
			IG286SearchCond processLinkageDefSearchCond) {
		this.processLinkageDefSearchCond = processLinkageDefSearchCond;
	}

	public IGPRD0125Form getIgPRD0125Form() {
		return igPRD0125Form;
	}

	public void setIgPRD0125Form(IGPRD0125Form igPRD0125Form) {
		this.igPRD0125Form = igPRD0125Form;
	}

	public List<IG286Info> getProcessLinkageDefList() {
		return processLinkageDefList;
	}

	public void setProcessLinkageDefList(List<IG286Info> processLinkageDefList) {
		this.processLinkageDefList = processLinkageDefList;
	}

	/**
	 * 参与者表单权限信息集合取得
	 * 
	 * @return 参与者表单权限信息集合
	 */
	public List<IG100Info> getLst_ProcessInfoParticipantDefVW() {
		return lst_ProcessInfoParticipantDefVW;
	}

	/**
	 * 参与者表单权限信息集合设定
	 * 
	 * @param lst_ProcessInfoParticipantDefVW
	 *            参与者表单权限信息集合
	 */
	public void setLst_ProcessInfoParticipantDefVW(
			List<IG100Info> lst_ProcessInfoParticipantDefVW) {
		this.lst_ProcessInfoParticipantDefVW = lst_ProcessInfoParticipantDefVW;
	}

	/**
	 * 缺省表单权限信息集合取得
	 * 
	 * @return 缺省表单权限信息集合
	 */
	public List<IG909Info> getLst_ParticipantDefaultVariableVW() {
		return lst_ParticipantDefaultVariableVW;
	}

	/**
	 * 缺省表单权限信息集合设定
	 * 
	 * @param lst_ParticipantDefaultVariableVW
	 *            缺省表单权限信息集合
	 */
	public void setLst_ParticipantDefaultVariableVW(
			List<IG909Info> lst_ParticipantDefaultVariableVW) {
		this.lst_ParticipantDefaultVariableVW = lst_ParticipantDefaultVariableVW;
	}

	// -----------------------------------------------------------前处理----------------------------------------------------------------------
	/** 按钮事件状态Form */

	protected IGPRD0141Form igPRD0141Form;

	public IGPRD0141Form getIgPRD0141Form() {
		return igPRD0141Form;
	}

	public void setIgPRD0141Form(IGPRD0141Form igPRD0141Form) {
		this.igPRD0141Form = igPRD0141Form;
	}

	public List<IG221Info> processParticipantButtonDefVWInfoList;

	public List<IG221Info> getProcessParticipantButtonDefVWInfoList() {
		return processParticipantButtonDefVWInfoList;
	}

	public void setProcessParticipantButtonDefVWInfoList(
			List<IG221Info> processParticipantButtonDefVWInfoList) {
		this.processParticipantButtonDefVWInfoList = processParticipantButtonDefVWInfoList;
	}

	public Map<String, List<IG132Info>> processParticipantButtonDefMap;

	public Map<String, List<IG132Info>> getProcessParticipantButtonDefMap() {
		return processParticipantButtonDefMap;
	}

	public void setProcessParticipantButtonDefMap(
			Map<String, List<IG132Info>> processParticipantButtonDefMap) {
		this.processParticipantButtonDefMap = processParticipantButtonDefMap;
	}

	/**
	 * 流程通知策略设定Form取得
	 * 
	 * @return 流程通知策略设定Form
	 */
	public IGPRD0158Form getIgPRD0158Form() {
		return igPRD0158Form;
	}

	/**
	 * 流程通知策略设定Form设定
	 * 
	 * @param igPRD0158Form
	 *            流程通知策略设定Form
	 */
	public void setIgPRD0158Form(IGPRD0158Form igPRD0158Form) {
		this.igPRD0158Form = igPRD0158Form;
	}

	/**
	 * 流程策略列表取得
	 * 
	 * @return 流程策略列表
	 */
	public List<IG238Info> getLst_ProcessNoticeStrategyDef() {
		return lst_ProcessNoticeStrategyDef;
	}

	/**
	 * 流程策略列表设定
	 * 
	 * @param lst_ProcessNoticeStrategyDef
	 *            流程策略列表
	 */
	public void setLst_ProcessNoticeStrategyDef(
			List<IG238Info> lst_ProcessNoticeStrategyDef) {
		this.lst_ProcessNoticeStrategyDef = lst_ProcessNoticeStrategyDef;
	}

	/**
	 * 角色用户列表设定
	 * 
	 * @return 角色用户列表
	 */
	public List<UserRoleInfo> getLst_UserRoleInfo() {
		return lst_UserRoleInfo;
	}

	/**
	 * 角色用户列表取得
	 * 
	 * @param lst_UserRoleInfo
	 *            角色用户列表
	 */
	public void setLst_UserRoleInfo(List<UserRoleInfo> lst_UserRoleInfo) {
		this.lst_UserRoleInfo = lst_UserRoleInfo;
	}

	/**
	 * 流程策略通知人查询Form取得
	 * 
	 * @return 流程策略通知人查询Form
	 */
	public IGPRD0159Form getIgPRD0159Form() {
		return igPRD0159Form;
	}

	/**
	 * 流程策略通知人查询Form设定
	 * 
	 * @param igPRD0159Form
	 *            流程策略通知人查询Form
	 */
	public void setIgPRD0159Form(IGPRD0159Form igPRD0159Form) {
		this.igPRD0159Form = igPRD0159Form;
	}

	protected IGPRD0161Form igPRD0161Form;

	public IGPRD0161Form getIgPRD0161Form() {
		return igPRD0161Form;
	}

	public void setIgPRD0161Form(IGPRD0161Form igPRD0161Form) {
		this.igPRD0161Form = igPRD0161Form;
	}

	protected List<IG992Info> processExternalDefList;

	public List<IG992Info> getProcessExternalDefList() {
		return processExternalDefList;
	}

	public void setProcessExternalDefList(List<IG992Info> processExternalDefList) {
		this.processExternalDefList = processExternalDefList;
	}

	protected IGPRD0142Form igPRD0142Form;

	public IGPRD0142Form getIgPRD0142Form() {
		return igPRD0142Form;
	}

	public void setIgPRD0142Form(IGPRD0142Form igPRD0142Form) {
		this.igPRD0142Form = igPRD0142Form;
	}

	public List<IG333TB> getPsdTBList() {
		return psdTBList;
	}

	public void setPsdTBList(List<IG333TB> psdTBList) {
		this.psdTBList = psdTBList;
	}

	/**
	 * 流程定义导入Form取得
	 * 
	 * @return 流程定义导入Form
	 */
	public IGPRD0101Form getIgPRD0101Form() {
		return igPRD0101Form;
	}

	/**
	 * 流程定义导入Form设定
	 * 
	 * @param igPRD0101Form
	 *            流程定义导入Form
	 */
	public void setIgPRD0101Form(IGPRD0101Form igPRD0101Form) {
		this.igPRD0101Form = igPRD0101Form;
	}

	/**
	 * 导出文件路径取得
	 * 
	 * @return 导出文件路径
	 */
	public String getFilepath_export() {
		return filepath_export;
	}

	/**
	 * 导出文件路径设定
	 * 
	 * @param filepath_export
	 *            导出文件路径
	 */
	public void setFilepath_export(String filepath_export) {
		this.filepath_export = filepath_export;
	}

	/**
	 * 表单初始化配置查询Form取得
	 * 
	 * @return 表单初始化配置查询Form
	 */
	public IGPRD0165Form getIgPRD0165Form() {
		return igPRD0165Form;
	}

	/**
	 * 表单初始化配置查询Form设定
	 * 
	 * @param igPRD0165Form
	 *            表单初始化配置查询Form
	 */
	public void setIgPRD0165Form(IGPRD0165Form igPRD0165Form) {
		this.igPRD0165Form = igPRD0165Form;
	}

	/**
	 * 表单初始化配置列表取得
	 * 
	 * @return 表单初始化配置列表
	 */
	public List<IG373Info> getLst_IG373Info() {
		return lst_IG373Info;
	}

	/**
	 * 表单初始化配置列表设定
	 * 
	 * @param lst_IG373Info
	 *            表单初始化配置列表
	 */
	public void setLst_IG373Info(List<IG373Info> lst_IG373Info) {
		this.lst_IG373Info = lst_IG373Info;
	}

	/**
	 * 表单初始化配置新增Form取得
	 * 
	 * @return 表单初始化配置新增Form
	 */
	public IGPRD0166Form getIgPRD0166Form() {
		return igPRD0166Form;
	}

	/**
	 * 表单初始化配置新增Form设定
	 * 
	 * @param igPRD0166Form
	 *            表单初始化配置新增Form
	 */
	public void setIgPRD0166Form(IGPRD0166Form igPRD0166Form) {
		this.igPRD0166Form = igPRD0166Form;
	}

	public IGPRD0171Form getIgPRD0171Form() {
		return igPRD0171Form;
	}

	public void setIgPRD0171Form(IGPRD0171Form igPRD0171Form) {
		this.igPRD0171Form = igPRD0171Form;
	}

	public IGPRD0172Form getIgPRD0172Form() {
		return igPRD0172Form;
	}

	public void setIgPRD0172Form(IGPRD0172Form igPRD0172Form) {
		this.igPRD0172Form = igPRD0172Form;
	}

	/**
	 * @return the 流程定义信息检索结果集
	 */
	public List<IG913Info> getRelevantProcessDefinitionList() {
		return relevantProcessDefinitionList;
	}

	/**
	 * @param 流程定义信息检索结果集
	 *            the relevantProcessDefinitionList to set
	 */
	public void setRelevantProcessDefinitionList(
			List<IG913Info> relevantProcessDefinitionList) {
		this.relevantProcessDefinitionList = relevantProcessDefinitionList;
	}

	/** 所属一级菜单列表 */
	protected List<LabelValueBean> actionLabelValueList;

	/**
	 * @return the 所属一级菜单列表
	 */
	public List<LabelValueBean> getActionLabelValueList() {
		return actionLabelValueList;
	}

	/**
	 * @param 所属一级菜单列表
	 *            the actionLabelValueList to set
	 */
	public void setActionLabelValueList(
			List<LabelValueBean> actionLabelValueList) {
		this.actionLabelValueList = actionLabelValueList;
	}

	/** 选择的所属菜单主键 */
	protected String actname;

	/**
	 * @return the 选择的所属菜单主键
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * @param 选择的所属菜单主键
	 *            the actname to set
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}

	/**
	 * @return the 按钮事件页面的可选按钮列表
	 */
	public List<LabelValueBean> processButtonDefList;

	/**
	 * @return the processButtonDefList
	 */
	public List<LabelValueBean> getProcessButtonDefList() {
		return processButtonDefList;
	}

	/**
	 * @param processButtonDefList
	 *            the processButtonDefList to set
	 */
	public void setProcessButtonDefList(
			List<LabelValueBean> processButtonDefList) {
		this.processButtonDefList = processButtonDefList;
	}

	/**
	 * 自定义流程页面设置Form取得
	 * 
	 * @return the igPRD0168Form
	 */
	public IGPRD0168Form getIgPRD0168Form() {
		return igPRD0168Form;
	}

	/**
	 * 自定义流程页面设置Form设置
	 * 
	 * @param igPRD0168Form
	 *            the igPRD0168Form to set
	 */
	public void setIgPRD0168Form(IGPRD0168Form igPRD0168Form) {
		this.igPRD0168Form = igPRD0168Form;
	}

	/**
	 * 自定义流程页面设置页面显示vo获取
	 * 
	 * @return the processJspInfoList
	 */
	public List<IG126Info> getProcessJspInfoList() {
		return processJspInfoList;
	}

	/**
	 * 自定义流程页面设置页面显示vo设置
	 * 
	 * @param processJspInfoList
	 *            the processJspInfoList to set
	 */
	public void setProcessJspInfoList(List<IG126Info> processJspInfoList) {
		this.processJspInfoList = processJspInfoList;
	}

	/**
	 * 自定义流程页面设置新增form 获取
	 * 
	 * * @return the igPRD0169Form
	 */
	public IGPRD0169Form getIgPRD0169Form() {
		return igPRD0169Form;
	}

	/**
	 * 自定义流程页面设置新增form 设置
	 * 
	 * @param igPRD0169Form
	 *            the igPRD0169Form to set
	 */
	public void setIgPRD0169Form(IGPRD0169Form igPRD0169Form) {
		this.igPRD0169Form = igPRD0169Form;
	}

	/**
	 * 自定义流程查询流程信息 获取
	 * 
	 * @return the ig380info
	 */
	public IG380Info getIg380info() {
		return ig380info;
	}

	/**
	 * 自定义流程查询流程信息 设置
	 * 
	 * @param ig380info
	 *            the ig380info to set
	 */
	public void setIg380info(IG380Info ig380info) {
		this.ig380info = ig380info;
	}

	/**
	 * 已选查询条件取得
	 * 
	 * @return 已选查询条件
	 */
	public List<IG108Info> getPqList() {
		return pqList;
	}

	/**
	 * 可选查询条件取得
	 * 
	 * @return 可选查询条件
	 */
	public List<IG007Info> getPdList() {
		return pdList;
	}

	/**
	 * 已选查询条件设定
	 * 
	 * @param pqList
	 *            已选查询条件
	 */
	public void setPqList(List<IG108Info> pqList) {
		this.pqList = pqList;
	}

	/**
	 * 可选查询条件设定
	 * 
	 * @param pdList
	 *            可选查询条件
	 */
	public void setPdList(List<IG007Info> pdList) {
		this.pdList = pdList;
	}

	/**
	 * 查询条件配置form取得
	 * 
	 * @return 查询条件配置form
	 */
	public IGPRD0145Form getIgprd0145Form() {
		return igprd0145Form;
	}

	/**
	 * 查询条件配置form设定
	 * 
	 * @param igprd0145Form
	 *            查询条件配置form
	 */
	public void setIgprd0145Form(IGPRD0145Form igprd0145Form) {
		this.igprd0145Form = igprd0145Form;
	}

	/**
	 * 分派节点信息集合取得
	 * 
	 * @return 分派节点信息集合
	 */
	public List<IG233Info> getApList() {
		return apList;
	}

	/**
	 * 分派节点信息集合设定
	 * 
	 * @param apList
	 *            分派节点信息集合
	 */
	public void setApList(List<IG233Info> apList) {
		this.apList = apList;
	}

	/**
	 * 表格类表单预览form取得
	 * 
	 * @return igprd0173Form 表格类表单预览form
	 */
	public IGPRD0173Form getIgprd0173Form() {
		return igprd0173Form;
	}

	/**
	 * 表格类表单预览form设定
	 * 
	 * @param igprd0173Form
	 *            表格类表单预览form
	 */
	public void setIgprd0173Form(IGPRD0173Form igprd0173Form) {
		this.igprd0173Form = igprd0173Form;
	}

	/**
	 * 表格类表单列信息取得
	 * 
	 * @return columnInfoMap 表格类表单列信息
	 */
	public Map<String, List<IG007Info>> getColumnInfoMap() {
		return columnInfoMap;
	}

	/**
	 * 表格类表单列信息设定
	 * 
	 * @param columnInfoMap
	 *            表格类表单列信息
	 */
	public void setColumnInfoMap(Map<String, List<IG007Info>> columnInfoMap) {
		this.columnInfoMap = columnInfoMap;
	}

	/**
	 * 表单定义信息取得
	 * @return pidInfo 表单定义信息
	 */
	public IG007Info getPidInfo() {
		return pidInfo;
	}

	/**
	 * 表单定义信息设定
	 * @param pidInfo 表单定义信息
	 */
	public void setPidInfo(IG007Info pidInfo) {
		this.pidInfo = pidInfo;
	}

	/**
	 * 表单定义信息取得
	 * @return processInfoDef 表单定义信息
	 */
	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}

	/**
	 * 表单定义信息设定
	 * @param processInfoDef 表单定义信息
	 */
	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	/**
	 * 表单管理form取得
	 * @return igprd0110Form 表单管理form
	 */
	public IGPRD0110Form getIgprd0110Form() {
		return igprd0110Form;
	}

	/**
	 * 表单管理form设定
	 * @param igprd0110Form 表单管理form
	 */
	public void setIgprd0110Form(IGPRD0110Form igprd0110Form) {
		this.igprd0110Form = igprd0110Form;
	}

	/**
	 * 页面显示策略信息Map取得
	 * @return showMap 页面显示策略信息Map
	 */
	public Map<IG238Info, List<IG335Info>> getShowMap() {
		return showMap;
	}

	/**
	 * 页面显示策略信息Map设定
	 * @param showMap 页面显示策略信息Map
	 */
	public void setShowMap(Map<IG238Info, List<IG335Info>> showMap) {
		this.showMap = showMap;
	}

	/**
	 * 状态个数取得
	 * @return pssize 状态个数
	 */
	public int getPssize() {
		return pssize;
	}

	/**
	 * 状态个数设定
	 * @param pssize 状态个数
	 */
	public void setPssize(int pssize) {
		this.pssize = pssize;
	}

	/**
	 * 状态表单值个数取得
	 * @return pisize 状态表单值个数
	 */
	public int getPisize() {
		return pisize;
	}

	/**
	 * 状态表单值个数设定
	 * @param pisize 状态表单值个数
	 */
	public void setPisize(int pisize) {
		this.pisize = pisize;
	}

	/**
	 * 超市提醒通知BL定义List取得
	 * @return proccessBLList 超市提醒通知BL定义List
	 */
	public List<LabelValueBean> getProccessBLList() {
		return proccessBLList;
	}

	/**
	 * 超市提醒通知BL定义List设定
	 * @param proccessBLList 超市提醒通知BL定义List
	 */
	public void setProccessBLList(List<LabelValueBean> proccessBLList) {
		this.proccessBLList = proccessBLList;
	}

	/**
	 * 整体超时提醒通知BL定义List取得
	 * @return processtacticsbl_alllist 整体超时提醒通知BL定义List
	 */
	public List<LabelValueBean> getProcesstacticsbl_alllist() {
		return processtacticsbl_alllist;
	}

	/**
	 * 整体超时提醒通知BL定义List设定
	 * @param processtacticsbl_alllist 整体超时提醒通知BL定义List
	 */
	public void setProcesstacticsbl_alllist(
			List<LabelValueBean> processtacticsbl_alllist) {
		this.processtacticsbl_alllist = processtacticsbl_alllist;
	}

    /** 
     * 流程整体策略 取得
     * @return processWholeTactic_list 流程整体策略 
     */
    public List<IG335Info> getProcessWholeTactic_list() {
        return processWholeTactic_list;
    }

    /** 
     * 流程整体策略 设定
     * @param processWholeTactic_list 流程整体策略 
     */
    public void setProcessWholeTactic_list(List<IG335Info> processWholeTactic_list) {
        this.processWholeTactic_list = processWholeTactic_list;
    }

    /** 
     * 流程整体策略表单值个数 取得
     * @return processWholeTactic_listSize 流程整体策略表单值个数 
     */
    public Integer getProcessWholeTactic_listSize() {
        return processWholeTactic_listSize;
    }

    /** 
     * 流程整体策略表单值个数 设定
     * @param processWholeTactic_listSize 流程整体策略表单值个数 
     */
    public void setProcessWholeTactic_listSize(Integer processWholeTactic_listSize) {
        this.processWholeTactic_listSize = processWholeTactic_listSize;
    }

	/**
	 * 流程导出校验错误信息取得
	 * @return errorMessages 流程导出校验错误信息
	 */
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * 流程导出校验错误信息设定
	 * @param errorMessages 流程导出校验错误信息
	 */
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	/**
	 * 流程类型取得
	 * @return pttype 流程类型
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * 流程类型设定
	 * @param pttype 流程类型
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * 流程模板信息取得
	 * @return processTemplate 流程模板信息
	 */
	public IG259Info getProcessTemplate() {
		return processTemplate;
	}

	/**
	 * 流程模板信息设定
	 * @param processTemplate 流程模板信息
	 */
	public void setProcessTemplate(IG259Info processTemplate) {
		this.processTemplate = processTemplate;
	}

	/**
	 * 流程状态_参与者集合取得
	 * @return 流程状态_参与者集合
	 */
	public Map<Integer, List<IG222Info>> getProcessParticipantDefMap() {
		return processParticipantDefMap;
	}

	/**
	 * 流程状态_参与者集合设定
	 * @param processParticipantDefMap 流程状态_参与者集合
	 */
	public void setProcessParticipantDefMap(
			Map<Integer, List<IG222Info>> processParticipantDefMap) {
		this.processParticipantDefMap = processParticipantDefMap;
	}

	/**
	 * AJAX返回结果取得
	 * @return ajaxResult AJAX返回结果
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}

	/**
	 * AJAX返回结果设定
	 * @param ajaxResult AJAX返回结果
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
	/**
	 * 已设定流程查询显示列集合取得
	 * @return queryShowColumnList 已设定流程查询显示列集合
	 */
	public List<IG110Info> getQueryShowColumnList() {
		return queryShowColumnList;
	}

	/**
	 * 已设定流程查询显示列集合设定
	 * @param queryShowColumnList 已设定流程查询显示列集合
	 */
	public void setQueryShowColumnList(List<IG110Info> queryShowColumnList) {
		this.queryShowColumnList = queryShowColumnList;
	}

	/**
	 * 未设定流程查询显示列集合取得
	 * @return queryShowColumnMap 未设定流程查询显示列集合
	 */
	public Map<String, String> getQueryShowColumnMap() {
		return queryShowColumnMap;
	}

	/**
	 * 未设定流程查询显示列集合设定
	 * @param queryShowColumnMap 未设定流程查询显示列集合
	 */
	public void setQueryShowColumnMap(Map<String, String> queryShowColumnMap) {
		this.queryShowColumnMap = queryShowColumnMap;
	}

	/**
	 * 已设定查询条件集合取得
	 * @return queryList 已设定查询条件集合
	 */
	public List<IG111Info> getQueryList() {
		return queryList;
	}

	/**
	 * 已设定查询条件集合设定
	 * @param queryList 已设定查询条件集合
	 */
	public void setQueryList(List<IG111Info> queryList) {
		this.queryList = queryList;
	}

	/**
	 * 未设定查询条件集合取得
	 * @return queryMap 未设定查询条件集合
	 */
	public Map<String, String> getQueryMap() {
		return queryMap;
	}

	/**
	 * 未设定查询条件集合设定
	 * @param queryMap 未设定查询条件集合
	 */
	public void setQueryMap(Map<String, String> queryMap) {
		this.queryMap = queryMap;
	}
	/** 流程设计器用Form */
	protected IGPRD0190Form igprd0190Form;
	
	public IGPRD0190Form getIgprd0190Form() {
		return igprd0190Form;
	}

	public void setIgprd0190Form(IGPRD0190Form igprd0190Form) {
		this.igprd0190Form = igprd0190Form;
	}
}
