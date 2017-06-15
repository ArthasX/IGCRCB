/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * @Description: 流程发起VO
 * @Author
 * @History 2010-9-13 新建
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01011VO extends BaseVO implements Serializable {

	/** 页面可见按钮集合 */
	protected Map<String,String> actionlist;// 每条记录用4位数字表示，1代表可见0代表不可见，顺序为批准--驳回--提交--中止

	/** 变量集合 key为变量的pidid */
	protected Map<String, IG007Info> processInfoDefmap;

	/** 表单取值范围为下拉列表信息 */
	protected Map<String, String[]> optionMap;

	/** 角色下拉列表是否显示;0-显示1-不显示 */
	protected String disp;
	/**文本域绑定附件*/
	protected Map<String,List<Attachment>> textAreaMap;
	
	protected String pdidOrgid;
	
	protected IG243TB processTitleDefTB;
	
	/** 参与者可视按钮 */
	List<IG309Info> lst_ParticipantVisibleButtonVWInfo;

	private IG500Info process;
	
	/** 状态定义信息 */
	protected IG333Info processStatusDef;
	
	public String getPdidOrgid() {
		return pdidOrgid;
	}

	public void setPdidOrgid(String pdidOrgid) {
		this.pdidOrgid = pdidOrgid;
	}
	
	/**
	 * 表单取值范围为下拉列表信息取得
	 * @return 表单取值范围为下拉列表信息
	 */
	public Map<String, String[]> getOptionMap() {
		return optionMap;
	}

	/**
	 * 表单取值范围为下拉列表信息设定
	 * @param optionMap 表单取值范围为下拉列表信息
	 */
	public void setOptionMap(Map<String, String[]> optionMap) {
		this.optionMap = optionMap;
	}

	/**
	 * 变量集合（key为变量的PIDID）取得
	 * 
	 * @return 变量集合（key为变量的PIDID）
	 */
	public Map<String, IG007Info> getProcessInfoDefmap() {
		return processInfoDefmap;
	}

	/**
	 * 变量集合（key为变量的PIDID）设定
	 * 
	 * @param processStatusInfoDefmap 变量集合（key为变量的PIDID）
	 */
	public void setProcessInfoDefmap(
			Map<String, IG007Info> processInfoDefmap) {
		this.processInfoDefmap = processInfoDefmap;
	}

	/**
	 * 角色下拉列表是否显示取得
	 * @return 角色下拉列表是否显示
	 */
	public String getDisp() {
		return disp;
	}

	/**
	 * 角色下拉列表是否显示设定
	 * @param disp 角色下拉列表是否显示
	 */
	public void setDisp(String disp) {
		this.disp = disp;
	}
	public Map<String, List<Attachment>> getTextAreaMap() {
		return textAreaMap;
	}

	public void setTextAreaMap(Map<String, List<Attachment>> textAreaMap) {
		this.textAreaMap = textAreaMap;
	}

	public IG243TB getProcessTitleDefTB() {
		return processTitleDefTB;
	}

	public void setProcessTitleDefTB(IG243TB processTitleDefTB) {
		this.processTitleDefTB = processTitleDefTB;
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
	
	public IG500Info getProcess() {
		return process;
	}

	/**
	 * process设定
	 * @param process process
	 */
	public void setProcess(IG500Info process) {
		this.process = process;
	}

	/**
	 * 状态定义信息取得
	 * @return 状态定义信息
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * 状态定义信息设定
	 * @param processStatusDef 状态定义信息
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}
	
}
