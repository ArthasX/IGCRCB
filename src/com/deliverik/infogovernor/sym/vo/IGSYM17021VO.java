/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * 概述: 流程策略信息ＶＯ
 * 功能描述：流程策略信息ＶＯ
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSYM17021VO extends BaseVO implements Serializable{
	
	/** 紧急程度集合 */
	protected List<LabelValueBean> prurgencyList;
	
	/** 流程状态集合 */
	protected List<IG333Info> processStatusDefList;
	
	/** 流程状态集合 */
	protected List<LabelValueBean> prstatusList;
	
	/** 流程定义信息 */
	protected IG380Info processDefinition;
	
	/** 流程策略最大版本号 */
	protected Integer maxPsdversion;
	
	/**
	 * 紧急程度集合设定
	 * @param prurgencyList紧急程度集合
	 */
	public List<LabelValueBean> getPrurgencyList() {
		return prurgencyList;
	}

	/**
	 * 紧急程度集合取得
	 * @return 紧急程度集合
	 */
	public void setPrurgencyList(List<LabelValueBean> prurgencyList) {
		this.prurgencyList = prurgencyList;
	}
	
	/**
	 * 流程状态集合设定
	 * @param processStatusDefList流程状态集合
	 */
	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	/**
	 * 流程状态集合取得
	 * @return 流程状态集合
	 */
	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}
	
	/**
	 * 流程状态集合设定
	 * @param prstatusList流程状态集合
	 */
	public List<LabelValueBean> getPrstatusList() {
		return prstatusList;
	}

	/**
	 * 流程状态集合取得
	 * @return 流程状态集合
	 */
	public void setPrstatusList(List<LabelValueBean> prstatusList) {
		this.prstatusList = prstatusList;
	}
	
	/**
	 * 流程定义信息设定
	 * @param processDefinition流程定义信息
	 */
	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * 流程定义信息取得
	 * @return 流程定义信息
	 */
	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}
	
	/**
	 * 流程策略最大版本号取得
	 * @return 流程策略最大版本号
	 */
	public Integer getMaxPsdversion() {
		if(maxPsdversion != null && maxPsdversion == 0) {
			return null;
		} else {
			return maxPsdversion;
		}
	}

	/**
	 * 流程策略最大版本号设定
	 * @param maxPsdversion流程策略最大版本号
	 */
	public void setMaxPsdversion(Integer maxPsdversion) {
		this.maxPsdversion = maxPsdversion;
	}

}


