/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;

/**
 * 审计结果信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01171VO extends BaseVO implements Serializable{
	
	/** 风险审计结果信息检索结果集 */
	protected List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList;
	
	/** 审计项最大级次 */
	protected Integer radMaxLevel;
	
	/** 审计项级次list */
	protected List<Integer> radMaxLevelList;
	
	/** 统计各级审计项孩子数 */
	protected Map<String, Integer> childCountMap;
	
	/** 风险审计项风险程度list */
	protected List<CodeDetail> radrisklevelList;
	
	/** 风险审计项风险程度size */
	protected int radrisklevelSizeColspan = 1;
	
	/** 风险审计项控制频率list */
	protected List<CodeDetail> radfrequencyList;
	
	/** 风险审计项控制频率size */
	protected int radfrequencySizeColspan = 1;
	
	/** 风险审计项控制手段list */
	protected List<CodeDetail> radmodeList;
	
	/** 风险审计项控制手段size */
	protected int radmodeSizeColspan = 1;
	
	/** 风险审计项控制类型list */
	protected List<CodeDetail> radtypeList;
	
	/** 风险审计项控制类型size */
	protected int radtypeSizeColspan = 1;
	
	/** 风险审计制度建设评分list */
	protected List<CodeDetail> rarplanscoreList;

	/** 风险审计制度建设评分size */
	protected int rarplanscoreSizeColspan = 1;
	
	/** 风险审计制度执行评分list */
	protected List<CodeDetail> rarexecscoreList;

	/** 风险审计制度执行评分size */
	protected int rarexecscoreSizeColspan = 1;
	
	/** 风险审计总体评分list */
	protected List<CodeDetail> raroverallscoreList;

	/** 风险审计总体评分size */
	protected int raroverallscoreSizeColspan = 1;
	
	/** 风险审计发起信息 */
	protected RiskAuditIns riskAuditIns;
	
	/**
	 * 风险审计结果信息检索结果集取得
	 * 
	 * @return 风险审计结果信息检索结果集
	 */
	public List<RiskAuditDefResultVWInfo> getRiskAuditDefResultVWInfoList() {
		return riskAuditDefResultVWInfoList;
	}

	/**
	 * 风险审计结果信息检索结果集设定
	 *
	 * @param riskAuditDefResultVWInfoList 风险审计结果信息检索结果集
	 */
	public void setRiskAuditDefResultVWInfoList(
			List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList) {
		this.riskAuditDefResultVWInfoList = riskAuditDefResultVWInfoList;
	}

	/**
	 * 审计项最大级次取得
	 * 
	 * @return 审计项最大级次
	 */
	public Integer getRadMaxLevel() {
		return radMaxLevel;
	}
	
	/**
	 * 审计项最大级次设定
	 *
	 * @param radMaxLevel 审计项最大级次
	 */
	public void setRadMaxLevel(Integer radMaxLevel) {
		this.radMaxLevel = radMaxLevel;
	}
	
	/**
	 * 审计项级次list取得
	 * 
	 * @return 审计项级次list
	 */
	public List<Integer> getRadMaxLevelList() {
		return radMaxLevelList;
	}

	/**
	 * 审计项级次list设定
	 *
	 * @param List<Integer> 审计项级次list
	 */
	public void setRadMaxLevelList(List<Integer> radMaxLevelList) {
		this.radMaxLevelList = radMaxLevelList;
	}
	
	/**
	 * 统计各级审计项孩子数取得
	 * 
	 * @return 统计各级审计项孩子数
	 */
	public Map<String, Integer> getChildCountMap() {
		return childCountMap;
	}

	/**
	 * 统计各级审计项孩子数设定
	 *
	 * @param childCountMap 统计各级审计项孩子数
	 */
	public void setChildCountMap(Map<String, Integer> childCountMap) {
		this.childCountMap = childCountMap;
	}

	/**
	 * 风险审计项风险程度List取得
	 * 
	 * @return 风险审计项风险程度List
	 */
	public List<CodeDetail> getRadrisklevelList() {
		return radrisklevelList;
	}

	/**
	 * 风险审计项风险程度List设定
	 *
	 * @param radrisklevelList 风险审计项风险程度List
	 */
	public void setRadrisklevelList(List<CodeDetail> radrisklevelList) {
		this.radrisklevelList = radrisklevelList;
		if(radrisklevelList != null && !radrisklevelList.isEmpty()) {
			radrisklevelSizeColspan = radrisklevelList.size();
		}
	}

	/**
	 * 风险审计项控制频率list取得
	 * 
	 * @return 风险审计项控制频率list
	 */
	public List<CodeDetail> getRadfrequencyList() {
		return radfrequencyList;
	}

	/**
	 * 风险审计项控制频率list设定
	 *
	 * @param radfrequencyList 风险审计项控制频率list
	 */
	public void setRadfrequencyList(List<CodeDetail> radfrequencyList) {
		this.radfrequencyList = radfrequencyList;
		if(radfrequencyList != null && !radfrequencyList.isEmpty()) {
			radfrequencySizeColspan = radfrequencyList.size();
		}
	}

	/**
	 * 风险审计项控制手段list取得
	 * 
	 * @return 风险审计项控制手段list
	 */
	public List<CodeDetail> getRadmodeList() {
		return radmodeList;
	}

	/**
	 * 风险审计项控制手段list设定
	 *
	 * @param radmodeList 风险审计项控制手段list
	 */
	public void setRadmodeList(List<CodeDetail> radmodeList) {
		this.radmodeList = radmodeList;
		if(radmodeList != null && !radmodeList.isEmpty()) {
			radmodeSizeColspan = radmodeList.size();
		}
	}

	/**
	 * 风险审计项控制类型list取得
	 * 
	 * @return 风险审计项控制类型list
	 */
	public List<CodeDetail> getRadtypeList() {
		return radtypeList;
	}

	/**
	 * 风险审计项控制类型list设定
	 *
	 * @param radtypeList 风险审计项控制类型list
	 */
	public void setRadtypeList(List<CodeDetail> radtypeList) {
		this.radtypeList = radtypeList;
		if(radtypeList != null && !radtypeList.isEmpty()) {
			radtypeSizeColspan = radtypeList.size();
		}
	}

	/**
	 * 风险审计制度建设评分list取得
	 * 
	 * @return 风险审计制度建设评分list
	 */
	public List<CodeDetail> getRarplanscoreList() {
		return rarplanscoreList;
	}

	/**
	 * 风险审计制度建设评分list设定
	 *
	 * @param rarplanscoreList 风险审计制度建设评分list
	 */
	public void setRarplanscoreList(List<CodeDetail> rarplanscoreList) {
		this.rarplanscoreList = rarplanscoreList;
		if(rarplanscoreList != null && !rarplanscoreList.isEmpty()) {
			rarplanscoreSizeColspan = rarplanscoreList.size();
		}
	}

	/**
	 * 风险审计制度执行评分list取得
	 * 
	 * @return 风险审计制度执行评分list
	 */
	public List<CodeDetail> getRarexecscoreList() {
		return rarexecscoreList;
	}

	/**
	 * 风险审计制度执行评分list设定
	 *
	 * @param rarexecscoreList 风险审计制度执行评分list
	 */
	public void setRarexecscoreList(List<CodeDetail> rarexecscoreList) {
		this.rarexecscoreList = rarexecscoreList;
		if(rarexecscoreList != null && !rarexecscoreList.isEmpty()) {
			rarexecscoreSizeColspan = rarexecscoreList.size();
		}
	}

	/**
	 * 风险审计总体评分list取得
	 * 
	 * @return 风险审计总体评分list
	 */
	public List<CodeDetail> getRaroverallscoreList() {
		return raroverallscoreList;
	}

	/**
	 * 风险审计总体评分list设定
	 *
	 * @param raroverallscoreList 风险审计总体评分list
	 */
	public void setRaroverallscoreList(List<CodeDetail> raroverallscoreList) {
		this.raroverallscoreList = raroverallscoreList;
		if(raroverallscoreList != null && !raroverallscoreList.isEmpty()) {
			raroverallscoreSizeColspan = raroverallscoreList.size();
		}
	}
	
	/**
	 * 风险审计项风险程度size取得
	 * 
	 * @return 风险审计项风险程度size
	 */
	public int getRadrisklevelSizeColspan() {
		return radrisklevelSizeColspan;
	}

	/**
	 * 风险审计项控制频率size取得
	 * 
	 * @return 风险审计项控制频率size
	 */
	public int getRadfrequencySizeColspan() {
		return radfrequencySizeColspan;
	}

	/**
	 * 风险审计项控制手段size取得
	 * 
	 * @return 风险审计项控制手段size
	 */
	public int getRadmodeSizeColspan() {
		return radmodeSizeColspan;
	}

	/**
	 * 风险审计项控制类型size取得
	 * 
	 * @return 风险审计项控制类型size
	 */
	public int getRadtypeSizeColspan() {
		return radtypeSizeColspan;
	}

	/**
	 * 风险审计制度建设评分size取得
	 * 
	 * @return 风险审计制度建设评分size
	 */
	public int getRarplanscoreSizeColspan() {
		return rarplanscoreSizeColspan;
	}

	/**
	 * 风险审计制度执行评分size取得
	 * 
	 * @return 风险审计制度执行评分size
	 */
	public int getRarexecscoreSizeColspan() {
		return rarexecscoreSizeColspan;
	}

	/**
	 * 风险审计总体评分size取得
	 * 
	 * @return 风险审计总体评分size
	 */
	public int getRaroverallscoreSizeColspan() {
		return raroverallscoreSizeColspan;
	}
	
	/**
	 * 风险审计发起信息取得
	 * 
	 * @return 风险审计发起信息
	 */
	public RiskAuditIns getRiskAuditIns() {
		return riskAuditIns;
	}

	/**
	 * 风险审计发起信息设定
	 *
	 * @param riskAuditIns 风险审计发起信息
	 */
	public void setRiskAuditIns(RiskAuditIns riskAuditIns) {
		this.riskAuditIns = riskAuditIns;
	}
	
}


