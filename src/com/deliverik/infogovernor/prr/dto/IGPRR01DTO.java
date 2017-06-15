/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;
import com.deliverik.infogovernor.prr.form.IGPRR0101Form;
import com.deliverik.infogovernor.prr.form.IGPRR0102Form;
import com.deliverik.infogovernor.prr.form.IGPRR0104Form;
import com.deliverik.infogovernor.prr.form.IGPRR0106Form;
import com.deliverik.infogovernor.prr.form.IGPRR0109Form;
import com.deliverik.infogovernor.prr.form.IGPRR0113Form;
import com.deliverik.infogovernor.prr.form.IGPRR0121Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01036VO;

/**
 * @Description: 流程驱动业务DTO
 * @Author  
 * @History 2010-9-13     新建 
 * @History 2012-12-18    新建 	121218	定价流程审批信息导出权限标识
 * 			2013-02-27	  修改	130225	流程支持分派机构相关修改
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01DTO extends BaseDTO implements Serializable{
	
	/** 状态模式 */
	protected String psdassign;
	
	/** 处理人所属机构 */
	protected String pporgid;
	
	/** 按机构查询执行人 */
	protected IGPRR0121Form igPRR0121Form;
	
	/** 按机构查询执行人 */
	protected List<UserRoleInfo> lst_UserRoleVW;
	
	/** 可分派机构集合 */
	protected List<Organization> org_List;

	/** 当前参与者机构码 */
	protected String orgid;
	
	/** 机构范围下拉列表 */
	protected List<LabelValueBean> processOrgSelectedOptions;
	
	/** 分派参与者按机构过滤 */
	protected String assign_orgsyscoding;
	
	protected List<RiskPointVM> listPointVMs = new ArrayList<RiskPointVM>();
	
	protected List<CheckItemVW> checkItemVWs = new ArrayList<CheckItemVW>();
	
	protected RiskPointVM pointVM;
	
	
	/** 流程处理参数接口 */
	protected WorkFlowParameterInfo  workFlowParameterInfo;
	
	/** 流程发起Form */
	protected IGPRR0101Form  igPRR0101Form;
	
	/** 流程处理Form */
	protected IGPRR0102Form  igPRR0102Form;
	
	/** 流程分派Form */
	protected IGPRR0104Form  igPRR0104Form;
	
	/** 用户 */
	protected User user;
	
	/** 下拉列表 */
	protected List<LabelValueBean> labelList;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 角色ID */
	protected Integer roleid;
	
	/** 处理角色ID */
	protected Integer selectRoleid;
	
	/** 流程ID */
	protected Integer prid;
	
	/** 流程状态ID */
	protected String psdid;
	
	protected String actsortid;
	
	/**流程关联服务工单信息检索列表*/
	protected List<IG715Info> ig715InfoList;
	
	protected String hasCLRecord;
	
	/** 流程主题显示*/
	protected IG243TB ptdTB;
	
	/** 流程状态_参与者集合 */
	protected List<IG222Info> processParticipantDeflist;
	protected List<IG007Info> varList;
	protected List<IG007Info> notinvarList;
	
	/** 发起状态下变量集合 key为变量的pidid*/
	protected Map<String,IG007Info> processInfoDefmap;
	
	/** 流程每环节处理时间 */
	protected String dealtime;
	
	protected String prtitle;
	
	protected Integer eiid;
	
	/** 流程信息 */
	protected IG500Info process;
	
	/** 流程状态或人员状态 */
	protected String status;
	
	/** 流程状态集合 */
	protected List<LabelValueBean> lst_status;
	
	/** 表单日志*/
	protected Map<String,Map<IG036Info, List<IG113Info>>> varLog_map;
	
	/** 流程日志*/
	protected Map<String,List<IG036Info>> recordLogMap;
	
	/**关联的流程集合*/
	protected List<IG500Info> prList;

	/** 流程状态类型 */
	protected String psdcode;
	
	protected boolean adminRole;
	
	protected boolean roleManager;
	
	/** 临时角色负责人 */
	protected boolean tempRoleManager;
	
	/** 值班人标识 */
	protected boolean dutyPerson;
	
	/** 是否存在未授权值班人标识 */
	protected boolean hasDutyPerson;

	/** 流程类型名称 */
	protected String processName;
	
	/** 流程测试数据标示 */
	protected String prassetcategory;
	
	/** 变量集合 key为变量的pidid*/
	protected Map<String,IG007Info> realmap;
	
	/** 变量集合 key为变量的pidid*/
	protected Map<String,IG007Info> varmap;
	
	/** 扩展信息是否有可见项 */
	protected String hid;
	
	/** 动作标识 如0010 */
	protected String action;
	
	/**流程节点类型*/
	protected String nodetype;
	
	/**流程节点模式*/
	protected String nodemode;
	
	/** 流程类型*/
	protected String pts;
	
	/** 是否为快捷发起*/
	protected String isServiceStart;
	
	protected String parprid;
	
	/** 流程图XML */
	protected String flowChartXml;
	
	/**是否是组合场景*/
	protected boolean isGroup;
	
	/**流程组实例信息*/
	protected IG483Info groupProcessRecord;
	
	/** 参与者 */
	protected List<IG337Info> processParticipantList;
	
	/** 流程状态日志集合 */
	protected List<IG224Info> recordStatusLogList;
	
	/** 表单日志查看Form */
	protected IGPRR0106Form  igPRR0106Form;
	
	/** 表单日志集合*/
	protected List<IG113Info> varLogList;
	
	/** 流程日志ID */
	protected Integer rlid;
	
	/** 流程跳转JSP */
	protected String forwardJsp;
	
	/** 流程跳转JSP页面类型 */
	protected String pjdtype;
	
	/** 流程状态信息 */
	protected IG333Info processStatusDef;
	
	/**角色集合*/
	protected List<Role> roleList;
	
	/** 流程授权人 */
	public User authorizeuser;
	
	/** 用户列表 */
	protected List<UserInfo> userInfoList;
	
	/** OA模式执行人Form */
	protected IGPRR0109Form igPRR0109Form;
	
	/** 流程SUPER分派Form */
	protected IGPRR0113Form  igPRR0113Form;
	
	/** 流程SUPER分派标识 */
	protected String  superFlag;
	
	/** 流程OA模式分派标识，1：不可分派 ,只有super角色负责人可分派*/
	protected String  assignFlag;
	
	/** 流程参与者角色变量权限列表 */
	protected List<IG893Info> participantVariableVWList;
	
	/** 是否进入分派参与者标识(0：不需要，1：需要) */
	protected String psdflag;
	
	protected String xmlheight;
	
	/** 日志列表 */
	protected List<IG036Info> relogList;
	
	protected List<IG036Info> recordLogList;
	
	/**文本域绑定附件*/
	protected Map<String,List<Attachment>> textAreaMap;
/** 查看按键附件显示 */
	protected Map<String,List<Attachment>> attachmentMap;
	
	protected String pdidOrgid;
	
	/** 执行人 */
	protected List<IG602Info> processExecutorVWList;
	
	/** 可分派角色 */
	protected Map<Role, List<UserRoleInfo>> map_ParticipantDefToBeAssign;
	
	/** 可分派角色 */
	protected Map<Role, List<IG602Info>> map_ParticipantToBeAssign;
	
	/** 参与者可视按钮 */
	protected List<IG309Info> lst_ParticipantVisibleButtonVWInfo;
	
	/** 参与者 */
	protected IG337Info processParticipant;
	
	/** 流程状态列表 */
	protected List<IG333Info> lst_ProcessStatusDef;
	
	/** 分派参与者集合 */
	protected Map<IG333Info, IGPRR01036VO> map_AssignParticipant;
	
	/** 分派参与者标识 */
	protected boolean assignParticipant = true;
	
	/** 参与者ID */
	protected List<String> lst_participant;
	
	/** 主办部门 */
	protected List<String> lst_ppsuper;

	/** 参与者处理标识集合(0未处理，1已处理) */
	protected Map<String, String> map_ParticipantDoneFlag;
	/** 流程与资产关系 */
	protected List<IG731Info> processInfoEntityList;
	
	/**流程变量参数值*/
	protected List<IG599Info> processInfo;
	
	/** 关联流程 */
	protected List<IG512Info> lst_IG512Info;
	
    /** 当前状态是否可发起多个相关流程(0:不是;1:是;)*/
    protected String isMoreRelevantProcess;
    
    /** 可发起的相关流程定义id*/
    protected String relevantPdid;
    
    /** 流程自定义的分派页面*/
    protected String assignPage;
    
    /** 流程自定义的改派页面*/
    protected String assignChangePage;
    
    /** 流程自定义的分派页面类型*/
    protected String assignPageType;
    
	/**用户角色信息*/
	List<UserRoleInfo> userRoleInfo;
	
    /**工作定义集合*/
    private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
    
    /** 是否全局控制表单值 */
    protected String isFormGlobalControl;
    
    /**信息是否公开*/
    protected String isOpen;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;
	
	private List<Map<String, Object>> listMap;
	
	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/** 状态参与人信息map */
	protected Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap;
	
	/** 表格类表单列信息 */
	protected Map<String, List<IG007Info>> columnInfoMap;
	
	/** 表格类表单列值Map */
	protected Map<String, Map<String, Map<String, String>>> tableColumnValueMap;
	
	/** 表格类表单关联资产信息集合 */
	protected Map<String, IG731Info> pieMap;
	
	/** 表格类表单列附件信息 */
	protected Map<String, List<Attachment>> tableAttMap;

	/** 流程类表单值map */
	protected Map<String, IG505Info> processInfoFormValueMap;
	
	/** 人员类表单值Map */
	protected Map<String, IG506Info> participantFormValueMap;
	
	/** 表单初始化信息 */
	protected Map<String, Object> initFormValueMap;

	/** 处理参与者ID */
	protected String ppidstr;
	
	/** 动态分支编号 */
	protected Integer psdnum;

	
	/**状态级私有表单关闭时显示用map*/
	protected Map<String,List<IG561VWInfo>> statusclosedetails;
	
	/** 定义流程ID */
	protected Integer dprid;
	
	
	
	 /**
     * 状态级私有表单关闭时显示用map
     *
     * @return statusclosedetails 状态级私有表单关闭时显示用map
     */
	public Map<String, List<IG561VWInfo>> getStatusclosedetails() {
        return statusclosedetails;
    }

	/**
     * 状态级私有表单关闭时显示用map
     *
     * @param statusclosedetails 状态级私有表单关闭时显示用map
     */
    public void setStatusclosedetails(Map<String, List<IG561VWInfo>> statusclosedetails) {
        this.statusclosedetails = statusclosedetails;
    }

    /**
	 * 可分派机构集合取得
	 *
	 * @return org_List 可分派机构集合
	 */
	public List<Organization> getOrg_List() {
		return org_List;
	}

	/**
	 * 可分派机构集合设定
	 *
	 * @param org_List 可分派机构集合
	 */
	public void setOrg_List(List<Organization> org_List) {
		this.org_List = org_List;
	}

	/**
	 * 当前参与者机构码取得
	 *
	 * @return orgid 当前参与者机构码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 当前参与者机构码设定
	 *
	 * @param orgid 当前参与者机构码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 机构范围下拉列表取得
	 *
	 * @return processOrgSelectedOptions 机构范围下拉列表
	 */
	public List<LabelValueBean> getProcessOrgSelectedOptions() {
		return processOrgSelectedOptions;
	}

	/**
	 * 机构范围下拉列表设定
	 *
	 * @param processOrgSelectedOptions 机构范围下拉列表
	 */
	public void setProcessOrgSelectedOptions(
			List<LabelValueBean> processOrgSelectedOptions) {
		this.processOrgSelectedOptions = processOrgSelectedOptions;
	}

	/**
	 * 用户角色信息取得
	 *
	 * @return userRoleInfo 用户角色信息
	 */
	public List<UserRoleInfo> getUserRoleInfo() {
		return userRoleInfo;
	}

	/**
	 * 用户角色信息设定
	 *
	 * @param userRoleInfo 用户角色信息
	 */
	public void setUserRoleInfo(List<UserRoleInfo> userRoleInfo) {
		this.userRoleInfo = userRoleInfo;
	}

	/**
	 * 处理人所属机构取得
	 *
	 * @return pporgid 处理人所属机构
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * 处理人所属机构设定
	 *
	 * @param pporgid 处理人所属机构
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	/**
	 * 状态模式取得
	 *
	 * @return psdassign 状态模式
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * 状态模式设定
	 *
	 * @param psdassign 状态模式
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}
	
	/**
	 * 按机构查询执行人取得
	 *
	 * @return igPRR0121Form 按机构查询执行人
	 */
	public IGPRR0121Form getIgPRR0121Form() {
		return igPRR0121Form;
	}

	/**
	 * 按机构查询执行人设定
	 *
	 * @param igPRR0121Form 按机构查询执行人
	 */
	public void setIgPRR0121Form(IGPRR0121Form igPRR0121Form) {
		this.igPRR0121Form = igPRR0121Form;
	}
	
	/**
	 * 按机构查询执行人取得
	 *
	 * @return lst_UserRolevw 按机构查询执行人
	 */
	public List<UserRoleInfo> getLst_UserRoleVW() {
		return lst_UserRoleVW;
	}

	/**
	 * 按机构查询执行人设定
	 *
	 * @param lst_UserRolevw 按机构查询执行人
	 */
	public void setLst_UserRoleVW(List<UserRoleInfo> lst_UserRoleVW) {
		this.lst_UserRoleVW = lst_UserRoleVW;
	}
    
	public List<IG731Info> getProcessInfoEntityList() {
		return processInfoEntityList;
	}

	public void setProcessInfoEntityList(List<IG731Info> processInfoEntityList) {
		this.processInfoEntityList = processInfoEntityList;
	}

	public List<IG599Info> getProcessInfo() {
		return processInfo;
	}

	public void setProcessInfo(List<IG599Info> processInfo) {
		this.processInfo = processInfo;
	}

	public String getPdidOrgid() {
		return pdidOrgid;
	}

	public void setPdidOrgid(String pdidOrgid) {
		this.pdidOrgid = pdidOrgid;
	}

	public Map<String, List<Attachment>> getTextAreaMap() {
		return textAreaMap;
	}

	public void setTextAreaMap(Map<String, List<Attachment>> textAreaMap) {
		this.textAreaMap = textAreaMap;
	}

	public Map<String, List<Attachment>> getAttachmentMap() {
		return attachmentMap;
	}

	public void setAttachmentMap(Map<String, List<Attachment>> attachmentMap) {
		this.attachmentMap = attachmentMap;
	}
	
	public List<IG036Info> getRecordLogList() {
		return recordLogList;
	}

	public void setRecordLogList(List<IG036Info> recordLogList) {
		this.recordLogList = recordLogList;
	}

	public List<IG036Info> getRelogList() {
		return relogList;
	}

	public void setRelogList(List<IG036Info> relogList) {
		this.relogList = relogList;
	}
	
	/**
	 * 流程授权人取得
	 * @return 流程授权人
	 */
	public User getAuthorizeuser() {
		return authorizeuser;
	}
	/**
	 * 流程授权人设置
	 * @param authorizeuser 流程授权人
	 */
	public void setAuthorizeuser(User authorizeuser) {
		this.authorizeuser = authorizeuser;
	}


	/**
	 * 流程日志ID取得
	 * @return 流程日志ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * 流程日志ID设置
	 * @param rlid 流程日志ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}


	/**
	 * 表单日志集合取得
	 * @return 表单日志集合
	 */
	public List<IG113Info> getVarLogList() {
		return varLogList;
	}

	/**
	 * 表单日志集合设置
	 * @param varLogList 表单日志集合
	 */
	public void setVarLogList(List<IG113Info> varLogList) {
		this.varLogList = varLogList;
	}
	
	/**
	 * 表单日志查看Form取得
	 * @return 表单日志查看Form
	 */
	public IGPRR0106Form getIgPRR0106Form() {
		return igPRR0106Form;
	}

	
	public IG243TB getPtdTB() {
		return ptdTB;
	}

	public void setPtdTB(IG243TB ptdTB) {
		this.ptdTB = ptdTB;
	}

	/**
	 * 表单日志查看Form设置
	 * @param igPRR0106Form 表单日志查看Form
	 */
	public void setIgPRR0106Form(IGPRR0106Form igPRR0106Form) {
		this.igPRR0106Form = igPRR0106Form;
	}

	/**
	 * 流程日志取得
	 * @return 流程日志
	 */
	public Map<String, List<IG036Info>> getRecordLogMap() {
		return recordLogMap;
	}

	/**
	 * 流程日志设置
	 * @param recordLogMap 流程日志
	 */
	public void setRecordLogMap(Map<String, List<IG036Info>> recordLogMap) {
		this.recordLogMap = recordLogMap;
	}

	/**
	 * 表单日志取得
	 * @return 表单日志
	 */
	public Map<String, Map<IG036Info, List<IG113Info>>> getVarLog_map() {
		return varLog_map;
	}
	
	/**
	 * 表单日志设置
	 * @param varLog_map 表单日志
	 */
	public void setVarLog_map(
			Map<String, Map<IG036Info, List<IG113Info>>> varLog_map) {
		this.varLog_map = varLog_map;
	}

	/**
	 * 参与者取得
	 * @return 参与者
	 */
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	/**
	 * 参与者设置
	 * @param processParticipantList 参与者
	 */
	public void setProcessParticipantList(
			List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	/**
	 * 流程状态日志取得
	 * @return 流程状态日志
	 */
	public List<IG224Info> getRecordStatusLogList() {
		return recordStatusLogList;
	}

	/**
	 * 流程状态日志设置
	 * @param recordStatusLogList 流程状态日志
	 */
	public void setRecordStatusLogList(List<IG224Info> recordStatusLogList) {
		this.recordStatusLogList = recordStatusLogList;
	}

	
	
	public Map<String, IG007Info> getVarmap() {
		return varmap;
	}

	public void setVarmap(Map<String, IG007Info> varmap) {
		this.varmap = varmap;
	}

	public String getParprid() {
		return parprid;
	}

	public void setParprid(String parprid) {
		this.parprid = parprid;
	}

	public String getIsServiceStart() {
		return isServiceStart;
	}

	public void setIsServiceStart(String isServiceStart) {
		this.isServiceStart = isServiceStart;
	}

	public String getPts() {
		return pts;
	}

	public void setPts(String pts) {
		this.pts = pts;
	}

	/**
	 * 获取流程节点类型
	 * @return 流程节点类型
	 */
	public String getNodetype() {
		return nodetype;
	}

	/**
	 * 设置流程节点类型
	 * @param nodetype 流程节点类型
	 */
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}
	
	/**
	 * 动作标识
	 * @return 动作标识
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 设置动作标识
	 * @param action 动作标识
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * 扩展信息是否有可见项取得
	 * @return 扩展信息是否有可见项
	 */
	public String getHid() {
		return hid;
	}

	/**
	 * 扩展信息是否有可见项设定
	 * @param hid 扩展信息是否有可见项
	 */
	public void setHid(String hid) {
		this.hid = hid;
	}

	/**
	 * 变量集合取得
	 * @return 变量集合
	 */
	public Map<String, IG007Info> getRealmap() {
		return realmap;
	}

	/**
	 * 变量集合设定
	 * @param realmap 变量集合
	 */
	public void setRealmap(Map<String, IG007Info> realmap) {
		this.realmap = realmap;
	}

	/**
	 * 流程测试数据标示取得
	 * @return 流程测试数据标示
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * 流程测试数据标示设定
	 * @param prassetcategory 流程测试数据标示
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * 流程类型名称取得
	 * @return 流程类型名称
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * 流程类型名称设定
	 * @param processName 流程类型名称
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	public boolean isRoleManager() {
		return roleManager;
	}

	public void setRoleManager(boolean roleManager) {
		this.roleManager = roleManager;
	}

	public boolean isAdminRole() {
		return adminRole;
	}

	public void setAdminRole(boolean adminRole) {
		this.adminRole = adminRole;
	}

	/**
	 * 流程状态类型取得
	 * @return 流程状态类型
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 流程状态类型设定
	 * @param psdcode 流程状态类型
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * 关联流程取得
	 * @return 关联流程
	 */
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * 关联流程设定
	 * @param prList 关联流程
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}

	/**
	 * 流程状态或人员状态取得
	 * @return 流程状态或人员状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 流程状态或人员状态设定
	 * @param status 流程状态或人员状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 流程信息取得
	 * @return 流程信息
	 */
	public IG500Info getProcess() {
		return process;
	}

	/**
	 * 流程信息设定
	 * @param process 流程信息
	 */
	public void setProcess(IG500Info process) {
		this.process = process;
	}

	/**
	 * 流程每环节处理时间取得
	 * @return 流程每环节处理时间
	 */
	public String getDealtime() {
		return dealtime;
	}

	/**
	 * 流程每环节处理时间设定
	 * @param dealtime 流程每环节处理时间
	 */
	public void setDealtime(String dealtime) {
		this.dealtime = dealtime;
	}

	/**
	 * 流程处理Form取得
	 * @return 流程处理Form
	 */
	public IGPRR0102Form getIgPRR0102Form() {
		return igPRR0102Form;
	}

	/**
	 * 流程处理Form设定
	 * @param igPRR0102Form 流程处理Form
	 */
	public void setIgPRR0102Form(IGPRR0102Form igPRR0102Form) {
		this.igPRR0102Form = igPRR0102Form;
	}

	/**
	 * 流程发起Form取得
	 * @return 流程发起Form
	 */
	public IGPRR0101Form getIgPRR0101Form() {
		return igPRR0101Form;
	}

	/**
	 * 流程发起Form设定
	 * @param igPRR0101Form 流程发起Form
	 */
	public void setIgPRR0101Form(IGPRR0101Form igPRR0101Form) {
		this.igPRR0101Form = igPRR0101Form;
	}
	
	/**
	 * 用户取得
	 * @return 用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户设定
	 * @param user 用户
	 */
	public void setUser(User user) {
		this.user = user;
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
	 * @param labelList 下拉列表
	 */
	public void setLabelList(List<LabelValueBean> labelList) {
		this.labelList = labelList;
	}
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}


	/**
	 * 流程状态ID设定
	 *
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * 流程状态_参与者集合取得
	 * 
	 * @return 流程状态_参与者集合
	 */
	public List<IG222Info> getProcessParticipantDeflist() {
		return processParticipantDeflist;
	}

	
	/**
	 * 流程状态_参与者集合设定
	 *
	 * @param processParticipantDeflist 流程状态_参与者集合
	 */
	public void setProcessParticipantDeflist(
			List<IG222Info> processParticipantDeflist) {
		this.processParticipantDeflist = processParticipantDeflist;
	}

	public List<IG007Info> getVarList() {
		return varList;
	}

	public void setVarList(List<IG007Info> varList) {
		this.varList = varList;
	}

	public List<IG007Info> getNotinvarList() {
		return notinvarList;
	}

	public void setNotinvarList(List<IG007Info> notinvarList) {
		this.notinvarList = notinvarList;
	}
	
	/**
	 * 发起状态下变量集合取得
	 * 
	 * @return 发起状态下变量集合
	 */
	public Map<String, IG007Info> getProcessInfoDefmap() {
		return processInfoDefmap;
	}

	/**
	 * 发起状态下变量集合设定
	 *
	 * @param processStatusInfoDefmap 发起状态下变量集合
	 */
	public void setProcessInfoDefmap(Map<String, IG007Info> processInfoDefmap) {
		this.processInfoDefmap = processInfoDefmap;
	}
	
	/**
	 * 流程图XML取得
	 * @return 流程图XML
	 */
	public String getFlowChartXml() {
		return flowChartXml;
	}

	/**
	 * 流程图XML设定
	 * @param flowChartXml 流程图XML
	 */
	public void setFlowChartXml(String flowChartXml) {
		this.flowChartXml = flowChartXml;
	}

	/**
	 * 流程分派Form取得
	 * @return 流程分派Form
	 */
	public IGPRR0104Form getIgPRR0104Form() {
		return igPRR0104Form;
	}

	/**
	 * 流程分派Form设定
	 * @param igPRR0104Form 流程分派Form
	 */
	public void setIgPRR0104Form(IGPRR0104Form igPRR0104Form) {
		this.igPRR0104Form = igPRR0104Form;
	}

	/**
	 * 流程跳转JSP取得
	 * @return 流程跳转JSP
	 */
	public String getForwardJsp() {
		return forwardJsp;
	}

	/**
	 * 流程跳转JSP设定
	 * @param forwardJsp流程跳转JSP
	 */
	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}

	/**
	 * 流程跳转JSP页面类型取得
	 * @return 流程跳转JSP页面类型
	 */
	public String getPjdtype() {
		return pjdtype;
	}
	

	/**
	 * 流程跳转JSP页面类型设定
	 * @param pjdtype流程跳转JSP页面类型
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	/**
	 * 流程状态信息取得
	 * @return 流程状态信息
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * 流程状态信息设定
	 * @param processStatusDef流程状态信息
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}
	
	/**
	 * 角色集合取得
	 * @return 角色集合
	 */
	public List<Role> getRoleList() {
		return roleList;
	}
	
	/**
	 * 角色集合设定
	 * @param roleList角色集合
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * 流程节点模式取得
	 * @return 流程节点模式
	 */
	public String getNodemode() {
		return nodemode;
	}
	
	/**
	 * 流程节点模式设定
	 * @param nodemode流程节点模式
	 */
	public void setNodemode(String nodemode) {
		this.nodemode = nodemode;
	}
	
	/**
	 * 用户列表取得
	 * @return 用户列表
	 */
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	
	/**
	 * 用户列表设定
	 * @param userInfoList用户列表
	 */
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	
	/**
	 * OA模式执行人Form取得
	 * @return OA模式执行人Form
	 */
	public IGPRR0109Form getIgPRR0109Form() {
		return igPRR0109Form;
	}
	
	/**
	 * OA模式执行人Form设定
	 * @param igPRR0109FormOA模式执行人Form
	 */
	public void setIgPRR0109Form(IGPRR0109Form igPRR0109Form) {
		this.igPRR0109Form = igPRR0109Form;
	}
	
	/**
	 * 流程SUPER分派Form取得
	 * @return 流程SUPER分派Form
	 */
	public IGPRR0113Form getIgPRR0113Form() {
		return igPRR0113Form;
	}
	
	/**
	 * 流程SUPER分派Form设定
	 * @param igPRR0113Form流程SUPER分派Form
	 */
	public void setIgPRR0113Form(IGPRR0113Form igPRR0113Form) {
		this.igPRR0113Form = igPRR0113Form;
	}
	
	/**
	 * 流程SUPER分派标识取得
	 * @return 流程SUPER分派标识
	 */
	public String getSuperFlag() {
		return superFlag;
	}
	
	/**
	 * 流程SUPER分派标识设定
	 * @param superFlag流程SUPER分派标识
	 */
	public void setSuperFlag(String superFlag) {
		this.superFlag = superFlag;
	}
	
	/**
	 * 流程参与者角色变量权限列表取得
	 * @return 流程参与者角色变量权限列表
	 */
	public List<IG893Info> getParticipantVariableVWList() {
		return participantVariableVWList;
	}
	
	/**
	 * 流程参与者角色变量权限列表设定
	 * @param participantVariableVWList流程参与者角色变量权限列表
	 */
	public void setParticipantVariableVWList(
			List<IG893Info> participantVariableVWList) {
		this.participantVariableVWList = participantVariableVWList;
	}
	
	/**
	 * 流程OA模式分派标识取得
	 * @return 流程OA模式分派标识
	 */
	public String getAssignFlag() {
		return assignFlag;
	}
	
	/**
	 * 流程OA模式分派标识设定
	 * @param assignFlag流程OA模式分派标识
	 */
	public void setAssignFlag(String assignFlag) {
		this.assignFlag = assignFlag;
	}

	/**
	 * 是否进入分派参与者标识取得
	 * @return 是否进入分派参与者标识
	 */
	public String getPsdflag() {
		return psdflag;
	}

	/**
	 * 是否进入分派参与者标识设定
	 * @param psdflag是否进入分派参与者标识
	 */
	public void setPsdflag(String psdflag) {
		this.psdflag = psdflag;
	}

	/**
	 * 值班人标识取得
	 * @return 值班人标识
	 */
	public boolean isDutyPerson() {
		return dutyPerson;
	}

	/**
	 * 值班人标识设定
	 * @param dutyPerson 值班人标识
	 */
	public void setDutyPerson(boolean dutyPerson) {
		this.dutyPerson = dutyPerson;
	}

	/**
	 * 是否存在未授权值班人标识取得
	 * @return 是否存在未授权值班人标识
	 */
	public boolean isHasDutyPerson() {
		return hasDutyPerson;
	}

	/**
	 * 是否存在未授权值班人标识设定
	 * @param hasDutyPerson是否存在未授权值班人标识
	 */
	public void setHasDutyPerson(boolean hasDutyPerson) {
		this.hasDutyPerson = hasDutyPerson;
	}

	/**
	 * 临时角色负责人取得
	 * @return 临时角色负责人
	 */
	public boolean isTempRoleManager() {
		return tempRoleManager;
	}

	/**
	 * 临时角色负责人设定
	 * @param tempRoleManager临时角色负责人
	 */
	public void setTempRoleManager(boolean tempRoleManager) {
		this.tempRoleManager = tempRoleManager;
	}

	/**
	 * 可分派角色取得
	 * 
	 * @return 可分派角色
	 */
	public Map<Role, List<UserRoleInfo>> getMap_ParticipantDefToBeAssign() {
		return map_ParticipantDefToBeAssign;
	}

	/**
	 * 可分派角色设定
	 * 
	 * @param map_ParticipantDefToBeAssign 可分派角色
	 */
	public void setMap_ParticipantDefToBeAssign(
			Map<Role, List<UserRoleInfo>> map_ParticipantDefToBeAssign) {
		this.map_ParticipantDefToBeAssign = map_ParticipantDefToBeAssign;
	}

	/**
	 * 执行人取得
	 * 
	 * @return 执行人
	 */
	public List<IG602Info> getProcessExecutorVWList() {
		return processExecutorVWList;
	}

	/**
	 * 执行人设定
	 * 
	 * @param processExecutorVWList 执行人
	 */
	public void setProcessExecutorVWList(
			List<IG602Info> processExecutorVWList) {
		this.processExecutorVWList = processExecutorVWList;
	}

	/**
	 * 可分派角色取得
	 * 
	 * @return 可分派角色
	 */
	public Map<Role, List<IG602Info>> getMap_ParticipantToBeAssign() {
		return map_ParticipantToBeAssign;
	}

	/**
	 * 可分派角色设定
	 * 
	 * @param map_ParticipantToBeAssign 可分派角色
	 */
	public void setMap_ParticipantToBeAssign(
			Map<Role, List<IG602Info>> map_ParticipantToBeAssign) {
		this.map_ParticipantToBeAssign = map_ParticipantToBeAssign;
	}

	/**
	 * 参与者可视按钮取得
	 * 
	 * @return 参与者可视按钮
	 */
	public List<IG309Info> getLst_ParticipantVisibleButtonVWInfo() {
		return lst_ParticipantVisibleButtonVWInfo;
	}

	/**
	 * 参与者可视按钮设定
	 * 
	 * @param lst_ParticipantVisibleButtonVWInfo 参与者可视按钮
	 */
	public void setLst_ParticipantVisibleButtonVWInfo(
			List<IG309Info> lst_ParticipantVisibleButtonVWInfo) {
		this.lst_ParticipantVisibleButtonVWInfo = lst_ParticipantVisibleButtonVWInfo;
	}

	/**
	 * 参与者取得
	 * 
	 * @return 参与者
	 */
	public IG337Info getProcessParticipant() {
		return processParticipant;
	}

	/**
	 * 参与者设定
	 * 
	 * @param processParticipant 参与者
	 */
	public void setProcessParticipant(IG337Info processParticipant) {
		this.processParticipant = processParticipant;
	}

	public String getXmlheight() {
		return xmlheight;
	}

	public void setXmlheight(String xmlheight) {
		this.xmlheight = xmlheight;
	}

	/**
	 * 流程状态列表取得
	 * 
	 * @return 流程状态列表
	 */
	public List<IG333Info> getLst_ProcessStatusDef() {
		return lst_ProcessStatusDef;
	}

	/**
	 * 流程状态列表设定
	 * 
	 * @param lst_ProcessStatusDef 流程状态列表
	 */
	public void setLst_ProcessStatusDef(List<IG333Info> lst_ProcessStatusDef) {
		this.lst_ProcessStatusDef = lst_ProcessStatusDef;
	}

	/**
	 * 分派参与者集合取得
	 * 
	 * @return 分派参与者集合
	 */
	public Map<IG333Info, IGPRR01036VO> getMap_AssignParticipant() {
		return map_AssignParticipant;
	}

	/**
	 * 分派参与者集合设定
	 * 
	 * @param map_AssignParticipant 分派参与者集合
	 */
	public void setMap_AssignParticipant(
			Map<IG333Info, IGPRR01036VO> map_AssignParticipant) {
		this.map_AssignParticipant = map_AssignParticipant;
	}

	/**
	 * 分派参与者标识取得
	 * 
	 * @return 分派参与者标识
	 */
	public boolean isAssignParticipant() {
		return assignParticipant;
	}

	/**
	 * 分派参与者标识设定
	 * 
	 * @param assignParticipant 分派参与者标识
	 */
	public void setAssignParticipant(boolean assignParticipant) {
		this.assignParticipant = assignParticipant;
	}
	
	/**
	 * 参与者ID取得
	 * 
	 * @return 参与者ID
	 */
	public List<String> getLst_participant() {
		return lst_participant;
	}

	/**
	 * 参与者ID设定
	 * 
	 * @param participant 参与者ID
	 */
	public void setLst_participant(List<String> lst_participant) {
		this.lst_participant = lst_participant;
	}

	/**
	 * 主办部门取得
	 * 
	 * @return 主办部门
	 */
	public List<String> getLst_ppsuper() {
		return lst_ppsuper;
	}

	/**
	 * 主办部门设定
	 * 
	 * @param lst_ppsuper 主办部门
	 */
	public void setLst_ppsuper(List<String> lst_ppsuper) {
		this.lst_ppsuper = lst_ppsuper;
	}

	/**
	 * 参与者处理标识集合取得
	 * 
	 * @return 参与者处理标识集合
	 */
	public Map<String, String> getMap_ParticipantDoneFlag() {
		return map_ParticipantDoneFlag;
	}

	/**
	 * 参与者处理标识集合设定
	 * 
	 * @param map_ParticipantDoneFlag 参与者处理标识集合
	 */
	public void setMap_ParticipantDoneFlag(
			Map<String, String> map_ParticipantDoneFlag) {
		this.map_ParticipantDoneFlag = map_ParticipantDoneFlag;
	}

	public String getActsortid() {
		return actsortid;
	}

	public void setActsortid(String actsortid) {
		this.actsortid = actsortid;
	}

	public List<IG715Info> getIg715InfoList() {
		return ig715InfoList;
	}

	public void setIg715InfoList(
			List<IG715Info> ig715InfoList) {
		this.ig715InfoList = ig715InfoList;
	}
	
	public String getHasCLRecord() {
		return hasCLRecord;
	}

	public void setHasCLRecord(String hasCLRecord) {
		this.hasCLRecord = hasCLRecord;
	}

	/**
	 * 流程处理参数接口取得
	 * 
	 * @return 流程处理参数接口
	 */
	public WorkFlowParameterInfo getWorkFlowParameterInfo() {
		return workFlowParameterInfo;
	}

	/**
	 * 流程处理参数接口设定
	 * 
	 * @param workFlowParameterInfo 流程处理参数接口
	 */
	public void setWorkFlowParameterInfo(WorkFlowParameterInfo workFlowParameterInfo) {
		this.workFlowParameterInfo = workFlowParameterInfo;
	}

	/**
	 * 关联流程取得
	 * 
	 * @return 关联流程
	 */
	public List<IG512Info> getLst_IG512Info() {
		return lst_IG512Info;
	}

	/**
	 * @param lst_IG512Info
	 */
	public void setLst_IG512Info(List<IG512Info> lst_IG512Info) {
		this.lst_IG512Info = lst_IG512Info;
	}

    /**
     * @return the 工作定义集合
     */
    public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
        return templateDefinitionMap;
    }

    /**
     * @param 工作定义集合 the templateDefinitionMap to set
     */
    public void setTemplateDefinitionMap(
            Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
        this.templateDefinitionMap = templateDefinitionMap;
    }

    /**
     * @return the 当前状态是否可发起多个相关流程(0:不是;1:是;)
     */
    public String getIsMoreRelevantProcess() {
        return isMoreRelevantProcess;
    }

    /**
     * @param 当前状态是否可发起多个相关流程(0:不是;1:是;) the isMoreRelevantProcess to set
     */
    public void setIsMoreRelevantProcess(String isMoreRelevantProcess) {
        this.isMoreRelevantProcess = isMoreRelevantProcess;
    }

    /**
     * @return the 可发起的相关流程定义id
     */
    public String getRelevantPdid() {
        return relevantPdid;
    }

    /**
     * @param 可发起的相关流程定义id the relevantPdid to set
     */
    public void setRelevantPdid(String relevantPdid) {
        this.relevantPdid = relevantPdid;
    }

    /**
     * @return the 流程自定义的分派页面
     */
    public String getAssignPage() {
        return assignPage;
    }

    /**
     * @param 流程自定义的分派页面 the assignPage to set
     */
    public void setAssignPage(String assignPage) {
        this.assignPage = assignPage;
    }

    /**
     * @return the 流程自定义的分派页面类型
     */
    public String getAssignPageType() {
        return assignPageType;
    }

    /**
     * @param 流程自定义的分派页面类型 the assignPageType to set
     */
    public void setAssignPageType(String assignPageType) {
        this.assignPageType = assignPageType;
    }

    /**
     * @return the 流程自定义的改派页面
     */
    public String getAssignChangePage() {
        return assignChangePage;
    }

    /**
     * @param 流程自定义的改派页面 the assignChangePage to set
     */
    public void setAssignChangePage(String assignChangePage) {
        this.assignChangePage = assignChangePage;
    }

    /**
     * 是否全局控制表单值取得
     * @return 是否全局控制表单值
     */
	public String getIsFormGlobalControl() {
		return isFormGlobalControl;
	}

	/**
	 * 是否全局控制表单值设定
	 * @param isFormGlobalControl 是否全局控制表单值
	 */
	public void setIsFormGlobalControl(String isFormGlobalControl) {
		this.isFormGlobalControl = isFormGlobalControl;
	}
	
    /**
     * 信息是否公开取得
     * @return
     */
	public String getIsOpen() {
		return isOpen;
	}
	/**
	 * 信息是否公开设定
	 * @param isOpen
	 */
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	
	/**
	 * 获取允许查询的最大记录数
	 * @return 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置允许查询的最大记录数
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	/**
	 * 获取分页Bean
	 * @return 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 设置分页Bean
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 状态参与人信息map取得
	 * @return 状态参与人信息map
	 */
	public Map<IG333Info, List<IG337Info>> getLs_proStatusParticipantMap() {
		return ls_proStatusParticipantMap;
	}

	/**
	 * 状态参与人信息map设定
	 * @param ls_proStatusParticipantMap 状态参与人信息map
	 */
	public void setLs_proStatusParticipantMap(
			Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap) {
		this.ls_proStatusParticipantMap = ls_proStatusParticipantMap;
	}

	/**
	 * 表格类表单列信息取得
	 * @return columnInfoMap 表格类表单列信息
	 */
	public Map<String, List<IG007Info>> getColumnInfoMap() {
		return columnInfoMap;
	}

	/**
	 * 表格类表单列信息设定
	 * @param columnInfoMap 表格类表单列信息
	 */
	public void setColumnInfoMap(Map<String, List<IG007Info>> columnInfoMap) {
		this.columnInfoMap = columnInfoMap;
	}

	/**
	 * 表格类表单列值Map取得
	 * @return tableColumnValueMap 表格类表单列值Map
	 */
	public Map<String, Map<String, Map<String, String>>> getTableColumnValueMap() {
		return tableColumnValueMap;
	}

	/**
	 * 表格类表单列值Map设定
	 * @param tableColumnValueMap 表格类表单列值Map
	 */
	public void setTableColumnValueMap(Map<String, Map<String, Map<String, String>>> tableColumnValueMap) {
		this.tableColumnValueMap = tableColumnValueMap;
	}

	/**
	 * 表格类表单关联资产信息集合取得
	 * @return pieMap 表格类表单关联资产信息集合
	 */
	public Map<String, IG731Info> getPieMap() {
		return pieMap;
	}

	/**
	 * 表格类表单关联资产信息集合设定
	 * @param pieMap 表格类表单关联资产信息集合
	 */
	public void setPieMap(Map<String, IG731Info> pieMap) {
		this.pieMap = pieMap;
	}

	/**
	 * 表格类表单列附件信息取得
	 * @return tableAttMap 表格类表单列附件信息
	 */
	public Map<String, List<Attachment>> getTableAttMap() {
		return tableAttMap;
	}

	/**
	 * 表格类表单列附件信息设定
	 * @param tableAttMap 表格类表单列附件信息
	 */
	public void setTableAttMap(Map<String, List<Attachment>> tableAttMap) {
		this.tableAttMap = tableAttMap;
	}

	/**
	 * 分派参与者按机构过滤取得
	 * @return 分派参与者按机构过滤
	 */
	public String getAssign_orgsyscoding() {
		return assign_orgsyscoding;
	}

	/**
	 * 分派参与者按机构过滤设定
	 * @param assign_orgsyscoding 分派参与者按机构过滤
	 */
	public void setAssign_orgsyscoding(String assign_orgsyscoding) {
		this.assign_orgsyscoding = assign_orgsyscoding;
	}

	/**
	 * 流程类表单值map取得
	 * @return processInfoFormValueMap 流程类表单值map
	 */
	public Map<String, IG505Info> getProcessInfoFormValueMap() {
		return processInfoFormValueMap;
	}

	/**
	 * 流程类表单值map设定
	 * @param processInfoFormValueMap 流程类表单值map
	 */
	public void setProcessInfoFormValueMap(
			Map<String, IG505Info> processInfoFormValueMap) {
		this.processInfoFormValueMap = processInfoFormValueMap;
	}

	/**
	 * 人员类表单值Map取得
	 * @return participantFormValueMap 人员类表单值Map
	 */
	public Map<String, IG506Info> getParticipantFormValueMap() {
		return participantFormValueMap;
	}

	/**
	 * 人员类表单值Map设定
	 * @param participantFormValueMap 人员类表单值Map
	 */
	public void setParticipantFormValueMap(
			Map<String, IG506Info> participantFormValueMap) {
		this.participantFormValueMap = participantFormValueMap;
	}

	/**
	 * 表单初始化信息取得
	 * @return initFormValueMap 表单初始化信息
	 */
	public Map<String, Object> getInitFormValueMap() {
		return initFormValueMap;
	}

	/**
	 * 表单初始化信息设定
	 * @param initFormValueMap 表单初始化信息
	 */
	public void setInitFormValueMap(Map<String, Object> initFormValueMap) {
		this.initFormValueMap = initFormValueMap;
	}

	/**
	 * 处理参与者ID取得
	 * @return 处理参与者ID
	 */
	public String getPpidstr() {
		return ppidstr;
	}

	/**
	 * 处理参与者ID设定
	 * @param ppidstr 处理参与者ID
	 */
	public void setPpidstr(String ppidstr) {
		this.ppidstr = ppidstr;
	}

	/**
	 * 处理角色ID取得
	 * @return 处理角色ID
	 */
	public Integer getSelectRoleid() {
		return selectRoleid;
	}

	/**
	 * 处理角色ID设定
	 * @param selectRoleid 处理角色ID
	 */
	public void setSelectRoleid(Integer selectRoleid) {
		this.selectRoleid = selectRoleid;
	}

	/**
	 * 流程状态集合设定
	 * @return 流程状态集合
	 */
	public List<LabelValueBean> getLst_status() {
		return lst_status;
	}

	/**
	 * 流程状态集合
	 * @param lst_status 流程状态集合
	 */
	public void setLst_status(List<LabelValueBean> lst_status) {
		this.lst_status = lst_status;
	}

	/**
	 * 动态分支编号取得
	 * @return psdnum 动态分支编号
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * 动态分支编号设定
	 * @param psdnum 动态分支编号
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	/**
	 * @return the listPointVMs
	 */
	public List<RiskPointVM> getListPointVMs() {
		return listPointVMs;
	}

	/**
	 * @param listPointVMs the listPointVMs to set
	 */
	public void setListPointVMs(List<RiskPointVM> listPointVMs) {
		this.listPointVMs = listPointVMs;
	}

	/**
	 * @return the checkItemVWs
	 */
	public List<CheckItemVW> getCheckItemVWs() {
		return checkItemVWs;
	}

	/**
	 * @param checkItemVWs the checkItemVWs to set
	 */
	public void setCheckItemVWs(List<CheckItemVW> checkItemVWs) {
		this.checkItemVWs = checkItemVWs;
	}

	/**
	 * @return the listMap
	 */
	public List<Map<String, Object>> getListMap() {
		return listMap;
	}

	/**
	 * @param listMap the listMap to set
	 */
	public void setListMap(List<Map<String, Object>> listMap) {
		this.listMap = listMap;
	}

	/**
	 * @return the pointVM
	 */
	public RiskPointVM getPointVM() {
		return pointVM;
	}

	/**
	 * @param pointVM the pointVM to set
	 */
	public void setPointVM(RiskPointVM pointVM) {
		this.pointVM = pointVM;
	}

	/**
	 * @return the prtitle
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * @param prtitle the prtitle to set
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * @return the eiid
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * @param eiid the eiid to set
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * dprid   取得
	 * @return dprid dprid
	 */
	public Integer getDprid() {
		return dprid;
	}

	/**
	 * dprid   设定
	 * @param dprid dprid
	 */
	public void setDprid(Integer dprid) {
		this.dprid = dprid;
	}
	/**流程工单号*/
	protected String serialNum;
	/**
	 * 流程工单号取得
	 * @return
	 */
	public String getSerialNum() {
		return serialNum;
	}
	/**
	 * 流程工单号获取
	 * @param serialNum
	 */
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public boolean isGroup() {
		return isGroup;
	}

	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}

	public IG483Info getGroupProcessRecord() {
		return groupProcessRecord;
	}

	public void setGroupProcessRecord(IG483Info groupProcessRecord) {
		this.groupProcessRecord = groupProcessRecord;
	}

	
}