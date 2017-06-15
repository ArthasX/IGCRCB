package com.deliverik.infogovernor.drm.dto;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.infogovernor.drm.form.IGDRM0101Form;
import com.deliverik.infogovernor.drm.form.IGDRM0104Form;
import com.deliverik.infogovernor.drm.form.IGDRM0108Form;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.util.FlowDetail;


/**
 * 场景定义流程用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM01DTO extends BaseDTO implements Serializable{

	/** 最大检索件数 */
	protected int maxSearchCount;

	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	/** 流程定义信息检索结果集 */
	protected List<IG380Info> processDefinitionList;
	
	protected IGDRM0108Form igdrm0108Form;

	/** ajax结果 */
	protected String ajaxResult;

	/** ajax结果 */
	private List<LabelValueBean> planTypeValues;
	
	/** 场景信息 */
	protected PlanInfo planInfo;

	/** 场景中的pdid */
	protected String pdid;

	/** 输出的html */
	protected String outPrintStr;

	/***
	 * 应急资源集合
	 * */
	protected List<SOC0118VWInfo> zyList;

	/** 场景响应策略集合 */
	protected List<ResponseStrategyInfo> responseStrategyList;

	protected ResponseStrategyInfo responseStrategyInfo;

	/**
	 * 预期恢复时间
	 */
	protected String maxTime;
	/**
	 * 点击切换主备按钮后的返回字符串
	 */
	protected String result;
	/**
	 * 场景的prid
	 */
	protected Integer prid;
	
	/** 文件输出流 */
	protected OutputStream ops;
	
	/**场景详细信息*/
	protected List<FlowDetail> parentStepList;
	
	public OutputStream getOps() {
		return ops;
	}

	public void setOps(OutputStream ops) {
		this.ops = ops;
	}

	/**  
	 * 获取maxTime  
	 * @return maxTime 
	 */
	public String getMaxTime() {
		return maxTime;
	}

	/**  
	 * 设置maxTime  
	 * @param maxTime
	 */
	
	public void setMaxTime(String maxTime) {
		this.maxTime = maxTime;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public List<SOC0118VWInfo> getZyList() {
		return zyList;
	}

	public void setZyList(List<SOC0118VWInfo> zyList) {
		this.zyList = zyList;
	}

	public String getOutPrintStr() {
		return outPrintStr;
	}

	public void setOutPrintStr(String outPrintStr) {
		this.outPrintStr = outPrintStr;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public PlanInfo getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}

	private List<SOC0117Info> entityList;

	public List<SOC0117Info> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<SOC0117Info> entityList) {
		this.entityList = entityList;
	}

	/** 是否需要显示数量 */
	private boolean countNum;

	public boolean isCountNum() {
		return countNum;
	}

	public void setCountNum(boolean countNum) {
		this.countNum = countNum;
	}

	/**
	 * */
	protected IGDRM0101Form igdrm0101Form ;
	

	public IGDRM0101Form getIgdrm0101Form() {
		return igdrm0101Form;
	}

	public void setIgdrm0101Form(IGDRM0101Form igdrm0101Form) {
		this.igdrm0101Form = igdrm0101Form;
	}

	
	/**
	 * 最大检索件数取得
	 * @return maxSearchCount 最大检索件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 最大检索件数设定
	 * @param maxSearchCount 最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页用DTO取得
	 * @return pagingDto 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 流程定义信息检索结果集取得
	 * @return processDefinitionList 流程定义信息检索结果集
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * 流程定义信息检索结果集设定
	 * @param processDefinitionList 流程定义信息检索结果集
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * ajax结果取得
	 * @return ajaxResult ajax结果
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}

	/**
	 * ajax结果设定
	 * @param ajaxResult ajax结果
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}

	public List<LabelValueBean> getPlanTypeValues() {
		return planTypeValues;
	}

	public void setPlanTypeValues(List<LabelValueBean> planTypeValues) {
		this.planTypeValues = planTypeValues;
	}
	
	private User loginUser;
	private Hashtable<String,TreeNode>  nodeMap;
	private List<PlanInfo> planList;
	private IGDRM0104Form igdrm0104Form;
	private Locale locale;
	
	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public Hashtable<String, TreeNode> getNodeMap() {
		return nodeMap;
	}

	public void setNodeMap(Hashtable<String, TreeNode> nodeMap) {
		this.nodeMap = nodeMap;
	}

	public List<PlanInfo> getPlanList() {
		return planList;
	}

	public void setPlanList(List<PlanInfo> planList) {
		this.planList = planList;
	}

	public IGDRM0104Form getIgdrm0104Form() {
		return igdrm0104Form;
	}
	public void setIgdrm0104Form(IGDRM0104Form igdrm0104Form) {
		this.igdrm0104Form = igdrm0104Form;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public IGDRM0108Form getIgdrm0108Form() {
		return igdrm0108Form;
	}

	public void setIgdrm0108Form(IGDRM0108Form igdrm0108Form) {
		this.igdrm0108Form = igdrm0108Form;
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public List<ResponseStrategyInfo> getResponseStrategyList() {
		return responseStrategyList;
	}

	public void setResponseStrategyList(List<ResponseStrategyInfo> responseStrategyList) {
		this.responseStrategyList = responseStrategyList;
	}

	public ResponseStrategyInfo getResponseStrategyInfo() {
		return responseStrategyInfo;
	}

	public void setResponseStrategyInfo(ResponseStrategyInfo responseStrategyInfo) {
		this.responseStrategyInfo = responseStrategyInfo;
	}

	public List<FlowDetail> getParentStepList() {
		return parentStepList;
	}

	public void setParentStepList(List<FlowDetail> parentStepList) {
		this.parentStepList = parentStepList;
	}


	
}