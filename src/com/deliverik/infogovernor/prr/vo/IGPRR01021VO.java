/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;

/**
 * @Description: 流程处理VO
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01021VO extends BaseVO implements Serializable{
	
	/** 是否为可分派节点 1-可分派  */
	protected String nodetype;
	
	/** 扩展信息是否有可见项 */
	protected String hid;
	
	protected String riskjobid;
	
	protected Integer riskid;
	
	
	
	protected IG500Info process;
	
	protected String status;
	
	protected String dealtime;
	
	protected String xmlheight;
	
	protected String einame;
	
	protected String riskitem;
	protected String poss;
	protected String levels;
	protected String grad;
	
	protected String prtitle;
	
	
	private List<Map<String, Object>> listMap;
	
	/** 是否角色负责人 */
	protected String isRoleManager;
	/**是否是主办部门*/
	protected String isHost;
	// process0001_begin
	/** 是否发起人(0:不是;1:是;) */
	protected String isInitiator;
	
	/**流程标题信息 */
	protected IG243TB processTitleDefTB;
	
	/** 参与者可视按钮 */
	List<IG309Info> lst_ParticipantVisibleButtonVWInfo;
	
	/**流程关系VO*/
	protected List<IGPRR01022VO> voList;
	
	/**流程关联服务工单信息检索列表*/
	protected List<IG715Info> ig715InfoList;
	
	/** 流程与资产关系 */
	protected List<IG731Info> processInfoEntityList;
	
	/** 相关流程引入页jsp */
	protected String relevantProcessJsp ;
	
	/**流程信息是否公开*/
	protected String isOpen;
	
	/** 表格类表单列附件信息 */
	protected Map<String, List<Attachment>> tableAttMap;
	
	/**
	 * 是否发起人取得
	 *
	 * @return isInitiator 是否发起人
	 */
	public String getIsInitiator() {
		return isInitiator;
	}

	
	
	/**
	 * @return the einame
	 */
	public String getEiname() {
		return einame;
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
	 * @return the riskjobid
	 */
	public String getRiskjobid() {
		return riskjobid;
	}



	/**
	 * @param riskjobid the riskjobid to set
	 */
	public void setRiskjobid(String riskjobid) {
		this.riskjobid = riskjobid;
	}



	/**
	 * @return the riskid
	 */
	public Integer getRiskid() {
		return riskid;
	}



	/**
	 * @param riskid the riskid to set
	 */
	public void setRiskid(Integer riskid) {
		this.riskid = riskid;
	}



	/**
	 * @param einame the einame to set
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}



	/**
	 * @return the riskitem
	 */
	public String getRiskitem() {
		return riskitem;
	}



	/**
	 * @param riskitem the riskitem to set
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}



	/**
	 * @return the poss
	 */
	public String getPoss() {
		return poss;
	}



	/**
	 * @param poss the poss to set
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}



	/**
	 * @return the levels
	 */
	public String getLevels() {
		return levels;
	}



	/**
	 * @param levels the levels to set
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}



	/**
	 * @return the grad
	 */
	public String getGrad() {
		return grad;
	}



	/**
	 * @param grad the grad to set
	 */
	public void setGrad(String grad) {
		this.grad = grad;
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
	 * 是否发起人设定
	 *
	 * @param isInitiator 是否发起人
	 */
	public void setIsInitiator(String isInitiator) {
		this.isInitiator = isInitiator;
	}
	// process0001_end
	
	/** 流程状态_参与者集合 */
	protected List<IG222Info> processParticipantDeflist;
	
	/** 流程状态_前处理集合 */
	protected List<IG211Info> processStatusInfoDeflist;
	
	/** 流程变量集合 */
	protected List<IG599Info> processInfolist;
	
	/** 页面可见按钮集合 */
	protected Map<String,String> actionlist;//每条记录用4位数字表示，1代表可见0代表不可见，顺序为批准--驳回--提交--中止
	
	/** 按钮提示信息 */
	protected Map<String,String> declist;  
	public Map<String, String> getDeclist() {
		return declist;
	}

	public void setDeclist(Map<String, String> declist) {
		this.declist = declist;
	}
	/** 流程状态_参与者变量权限集合 key为参与者的ppdid*/
	protected Map<Integer,List<IG881Info>> processInfoParticipantDefmap;
	
	/** 变量集合 key为变量的pidid*/
	protected Map<String,IG007Info> processInfoDefmap;
	/** 变量集合 key为变量的pidid*/
	protected Map<Integer,IG007Info> processInfoDefmaps;
	
	/** 非发起状态下变量集合 key为变量的pidid*/
	protected Map<Integer,IG599Info> processInfomap;
	
	/** 变量权限集合 key为变量的pidid*/
	protected Map<Integer,String> variableAcessmap;

	protected Map<Integer,IG211Info> variableObjectElsemap;
	
	protected Map<Integer,IG599Info> processInfoElsemap;
	/**角色下拉列表是否显示;0-显示1-不显示 */
	protected String disp;
	/** 是否是流程管理员 */
	protected String isAdmin;
	
	/**关联的流程集合*/
	protected List<IG500Info> prList;
	
	List<RiskPointVM> listPointVMs = new ArrayList<RiskPointVM>();
	List<CheckItemVW> checkItemVWs = new ArrayList<CheckItemVW>();
	
	
	/** 流程日志*/
	protected Map<String,List<IG036Info>> recordLogMap;
	
	/** 流程状态信息 */
	protected IG333Info processStatusDef;
	
	/** 流程SUPER分派标识 */
	protected String  superFlag;
	
	protected List<IG036Info> recordLogList;
	
	/** 值班人标识 */
	protected boolean dutyPerson;
	
	/** 是否存在未授权值班人标识 */
	protected boolean hasDutyPerson;
	
	/** 目标工作“审批确认”节点删除按钮显示标识 */
	protected boolean targetFlag;
	
	/** 当前用户ID*/
	protected String userid;
	
	/** 当前用户选择角色ID*/
	protected Integer roleid;
	
	/** 当前参与者机构码 */
	protected String orgid;
	
	/** 表格类表单关联资产信息 */
	protected Map<String, IG731Info> pieMap;
	
	/** 流程类表单值 Map */
	protected Map<String, IG505Info> processInfoFormValueMap;
	
	/** 人员类表单值Map */
	protected Map<String, IG506Info> participantFormValueMap;
	
	/**
	 * 目标工作“审批确认”节点删除按钮显示标识取得
	 * 
	 * @return 目标工作“审批确认”节点删除按钮显示标识
	 */
	public boolean isTargetFlag() {
		return targetFlag;
	}

	/**
	 * 目标工作“审批确认”节点删除按钮显示标识设定
	 * 
	 * @param targetFlag 目标工作“审批确认”节点删除按钮显示标识
	 */
	public void setTargetFlag(boolean targetFlag) {
		this.targetFlag = targetFlag;
	}
	
	/**文本域绑定附件*/
	protected Map<String,List<Attachment>> textAreaMap;
	
	/** 流程图XML */
	protected String flowChartXml;
	
	/** 是否显示负责人调整执行人链接标识 */
	protected String showExecutor = "true";
	
	/** 当前状态是否可发起多个相关流程(0:不是;1:是;)*/
	protected String isMoreRelevantProcess;
	
    /** 可发起的相关流程定义id*/
    protected String relevantPdid;
    
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
	public Map<String, List<Attachment>> getTextAreaMap() {
		return textAreaMap;
	}

	public void setTextAreaMap(Map<String, List<Attachment>> textAreaMap) {
		this.textAreaMap = textAreaMap;
	}
	public List<IG036Info> getRecordLogList() {
		return recordLogList;
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


	public void setRecordLogList(List<IG036Info> recordLogList) {
		this.recordLogList = recordLogList;
	}

	public Map<String, List<IG036Info>> getRecordLogMap() {
		return recordLogMap;
	}

	public void setRecordLogMap(Map<String, List<IG036Info>> recordLogMap) {
		this.recordLogMap = recordLogMap;
	}

	public String getIsRoleManager() {
		return isRoleManager;
	}

	public void setIsRoleManager(String isRoleManager) {
		this.isRoleManager = isRoleManager;
	}
	
	public String getDealtime() {
		return dealtime;
	}

	public void setDealtime(String dealtime) {
		this.dealtime = dealtime;
	}
	
	public List<IG500Info> getPrList() {
		return prList;
	}

	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}
	
	protected String imgxml;
	
	
	public String getImgxml() {
		return imgxml;
	}


	public void setImgxml(String imgxml) {
		this.imgxml = imgxml;
	}


	public List<IG211Info> getProcessStatusInfoDeflist() {
		return processStatusInfoDeflist;
	}


	public void setProcessStatusInfoDeflist(
			List<IG211Info> processStatusInfoDeflist) {
		this.processStatusInfoDeflist = processStatusInfoDeflist;
	}


	public List<IG599Info> getProcessInfolist() {
		return processInfolist;
	}


	public void setProcessInfolist(List<IG599Info> processInfolist) {
		this.processInfolist = processInfolist;
	}


	public Map<Integer, IG211Info> getVariableObjectElsemap() {
		return variableObjectElsemap;
	}


	public void setVariableObjectElsemap(
			Map<Integer, IG211Info> variableObjectElsemap) {
		this.variableObjectElsemap = variableObjectElsemap;
	}


	public Map<Integer, IG599Info> getProcessInfoElsemap() {
		return processInfoElsemap;
	}


	public void setProcessInfoElsemap(Map<Integer, IG599Info> processInfoElsemap) {
		this.processInfoElsemap = processInfoElsemap;
	}


	public List<IG222Info> getProcessParticipantDeflist() {
		return processParticipantDeflist;
	}


	public void setProcessParticipantDeflist(
			List<IG222Info> processParticipantDeflist) {
		this.processParticipantDeflist = processParticipantDeflist;
	}


	public Map<String,String> getActionlist() {
		return actionlist;
	}


	public void setActionlist(Map<String,String> actionlist) {
		this.actionlist = actionlist;
	}


	public Map<Integer, List<IG881Info>> getProcessInfoParticipantDefmap() {
		return processInfoParticipantDefmap;
	}


	public void setProcessInfoParticipantDefmap(
			Map<Integer, List<IG881Info>> processInfoParticipantDefmap) {
		this.processInfoParticipantDefmap = processInfoParticipantDefmap;
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

	public Map<Integer, IG599Info> getProcessInfomap() {
		return processInfomap;
	}


	public void setProcessInfomap(Map<Integer, IG599Info> processInfomap) {
		this.processInfomap = processInfomap;
	}


	public Map<Integer, String> getVariableAcessmap() {
		return variableAcessmap;
	}


	public void setVariableAcessmap(Map<Integer, String> variableAcessmap) {
		this.variableAcessmap = variableAcessmap;
	}

	public IG500Info getProcess() {
		return process;
	}

	public void setProcess(IG500Info process) {
		this.process = process;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNodetype() {
		return nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}

	public String getDisp() {
		return disp;
	}

	public void setDisp(String disp) {
		this.disp = disp;
	}


//	/**
//	 * 流程参与者的变量权限检索结果取得
//	 * 
//	 * @return 流程参与者的变量权限检索结果
//	 */
//	public List<ProcessInfoParticipantDef> getProcessInfoParticipantDefList() {
//		return processInfoParticipantDefList;
//	}
//
//
//	/**
//	 * 流程参与者的变量权限检索结果设定
//	 *
//	 * @param processInfoParticipantDefList 流程参与者的变量权限检索结果
//	 */
//	public void setProcessInfoParticipantDefList(
//			List<ProcessInfoParticipantDef> processInfoParticipantDefList) {
//		this.processInfoParticipantDefList = processInfoParticipantDefList;
//	}
	
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

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
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
	 * 流程标题定义取得
	 * @return 流程标题定义
	 */
	public IG243TB getProcessTitleDefTB() {
		return processTitleDefTB;
	}

	/**
	 * 设置流程标题定义实体
	 * @param processTitleDefTB流程标题定义实体
	 */
	public void setProcessTitleDefTB(IG243TB processTitleDefTB) {
		this.processTitleDefTB = processTitleDefTB;
	}

	/**
	 * 当前用户ID
	 * @return 当前用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 当前用户ID
	 * @param userid当前用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 当前用户角色ID
	 * @return 当前用户角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * 当前用户角色ID
	 * @param userid当前用户角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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
		if(lst_ParticipantVisibleButtonVWInfo != null) {
			for(IG309Info bean : lst_ParticipantVisibleButtonVWInfo) {
				if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(bean.getVbid())) {
					this.showExecutor = "false";
				}
			}
		}
	}

	public String getXmlheight() {
		return xmlheight;
	}

	public void setXmlheight(String xmlheight) {
		this.xmlheight = xmlheight;
	}

	/**
	 * 是否显示负责人调整执行人链接标识取得
	 * 
	 * @return 是否显示负责人调整执行人链接标识
	 */
	public String getShowExecutor() {
		return showExecutor;
	}

	/**
	 * 是否显示负责人调整执行人链接标识设定
	 * 
	 * @param showExecutor 是否显示负责人调整执行人链接标识
	 */
	public void setShowExecutor(String showExecutor) {
		this.showExecutor = showExecutor;
	}
	protected String hasCLRecord = "0";

	protected List<IG512Info> ig512InfoList;
	
	public String getHasCLRecord() {
		return hasCLRecord;
	}

	public void setHasCLRecord(String hasCLRecord) {
		this.hasCLRecord = hasCLRecord;
	}
	
	/**
	 * 设置流程关系信息检索列表
	 * @param ig512InfoList 流程关系信息检索列表
	 */
	public void setIG512InfoList(List<IG512Info> ig512InfoList) {
		this.ig512InfoList = ig512InfoList;
		if(ig512InfoList != null && ig512InfoList.size() > 0) {
			int prid = this.process.getPrid();
			voList = new ArrayList<IGPRR01022VO>();
			//双向组装VO
			for(IG512Info prr : ig512InfoList) {
				if(prid == prr.getParprid()) {
					IGPRR01022VO vo = new IGPRR01022VO();
					vo.setInfo(prr.getCldProcess());
					vo.setType("C");
					this.voList.add(vo);
				} else if(prid == prr.getCldprid()){
					IGPRR01022VO vo = new IGPRR01022VO();
					vo.setInfo(prr.getParProcess());
					vo.setType("P");
					this.voList.add(vo);
				}
			}
		} else {
			this.ig512InfoList = null;
		}
	}
	
	/**
	 * 设置流程关系信息检索列表
	 * @param ig512InfoList 流程关系信息检索列表
	 */
	public List<IGPRR01022VO> getVoList() {
		return voList;
	}

	public List<IG715Info> getIg715InfoList() {
		return ig715InfoList;
	}

	public void setIg715InfoList(
			List<IG715Info> ig715InfoList) {
		this.ig715InfoList = ig715InfoList;
	}
	
	/**
	 * 流程与资产关系取得
	 * @return 流程与资产关系
	 */
	public List<IG731Info> getProcessInfoEntityList() {
		return processInfoEntityList;
	}

	/**
	 * 流程与资产关系设定
	 * @param processInfoEntityList 流程与资产关系
	 */
	public void setProcessInfoEntityList(
			List<IG731Info> processInfoEntityList) {
		this.processInfoEntityList = processInfoEntityList;
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
     * @return the relevantProcessJsp
     */
    public String getRelevantProcessJsp() {
        return relevantProcessJsp;
    }

    /**
     * @param relevantProcessJsp the relevantProcessJsp to set
     */
    public void setRelevantProcessJsp(String relevantProcessJsp) {
        this.relevantProcessJsp = relevantProcessJsp;
    }
    /**
     * 流程信息是否公开取得
     * @return
     */
	public String getIsOpen() {
		return isOpen;
	}
	/**
	 * 流程信息是否公开设定
	 * @param isOpen
	 */
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	/**
	 * 是否是主办部门取得
	 *
	 * @return isHost 是否是主办部门
	 */
	
	public String getIsHost() {
		return isHost;
	}

	/**
	 * 是否是主办部门设定
	 *
	 * @param isHost 是否是主办部门
	 */
	public void setIsHost(String isHost) {
		this.isHost = isHost;
	}

	/**
	 * 变量集合key为变量的pidid取得
	 *
	 * @return processInfoDefmaps 变量集合key为变量的pidid
	 */
	
	public Map<Integer, IG007Info> getProcessInfoDefmaps() {
		return processInfoDefmaps;
	}

	/**
	 * 变量集合key为变量的pidid设定
	 *
	 * @param processInfoDefmaps 变量集合key为变量的pidid
	 */
	public void setProcessInfoDefmaps(Map<Integer, IG007Info> processInfoDefmaps) {
		this.processInfoDefmaps = processInfoDefmaps;
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
	 * ig512InfoList取得
	 *
	 * @return ig512InfoList ig512InfoList
	 */
	
	public List<IG512Info> getIg512InfoList() {
		return ig512InfoList;
	}

	/**
	 * ig512InfoList设定
	 *
	 * @param ig512InfoList ig512InfoList
	 */
	public void setIg512InfoList(List<IG512Info> ig512InfoList) {
		this.ig512InfoList = ig512InfoList;
	}

	/**
	 * 流程关系VO设定
	 *
	 * @param voList 流程关系VO
	 */
	public void setVoList(List<IGPRR01022VO> voList) {
		this.voList = voList;
	}

	/**
	 * 表格类表单关联资产信息取得
	 * @return pieMap 表格类表单关联资产信息
	 */
	public Map<String, IG731Info> getPieMap() {
		return pieMap;
	}

	/**
	 * 表格类表单关联资产信息设定
	 * @param pieMap 表格类表单关联资产信息
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
	 * 流程类表单值Map取得
	 * @return processInfoFormValueMap 流程类表单值Map
	 */
	public Map<String, IG505Info> getProcessInfoFormValueMap() {
		return processInfoFormValueMap;
	}

	/**
	 * 流程类表单值Map设定
	 * @param processInfoFormValueMap 流程类表单值Map
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
	
}