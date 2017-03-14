/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表钻取VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDBM12001VO extends BaseVO{

	/** 流程信息集合 */
	protected List<IG500Info> prList;
	

	/** 资产信息集合 */
	protected List<SOC0118Info> assetList;
	
	
	public List<SOC0118Info> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<SOC0118Info> assetList) {
		this.assetList = assetList;
	}

	/** 检查工作集合 */
	protected List<RiskCheckResult> rcrList;

	/**资产列表*/
	protected List<SOC0124Info> soc0124List;
	
	
	/**检查项集合*/
	protected  List<CheckItemVWInfo> checkItemList;
	/**风险点集合*/
	protected List<RiskPointVMInfo> riskPointList;
	
	/**风险事件集合*/
	protected List<RiskcaseVWInfo> riskcaseList;
	/**
	 * 流程信息集合取得
	 * @return prList 流程信息集合
	 */
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * 流程信息集合设定
	 * @param prList 流程信息集合
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}

	/**
	 * 检查工作集合取得
	 * @return rcrList 检查工作集合
	 */
	public List<RiskCheckResult> getRcrList() {
		return rcrList;
	}

	/**
	 * 检查工作集合设定
	 * @param rcrList 检查工作集合
	 */
	public void setRcrList(List<RiskCheckResult> rcrList) {
		this.rcrList = rcrList;
	}

	/**
	 * 资产列表   取得
	 * @return soc0124List 资产列表
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	/**
	 * 资产列表   设定
	 * @param soc0124List 资产列表
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}

	/**
	 * 检查项集合   取得
	 * @return checkItemList 检查项集合
	 */
	public List<CheckItemVWInfo> getCheckItemList() {
		return checkItemList;
	}

	/**
	 * 检查项集合   设定
	 * @param checkItemList 检查项集合
	 */
	public void setCheckItemList(List<CheckItemVWInfo> checkItemList) {
		this.checkItemList = checkItemList;
	}

	/**
	 * 风险点集合   取得
	 * @return riskPointList 风险点集合
	 */
	public List<RiskPointVMInfo> getRiskPointList() {
		return riskPointList;
	}

	/**
	 * 风险点集合   设定
	 * @param riskPointList 风险点集合
	 */
	public void setRiskPointList(List<RiskPointVMInfo> riskPointList) {
		this.riskPointList = riskPointList;
	}

	public List<RiskcaseVWInfo> getRiskcaseList() {
		return riskcaseList;
	}

	public void setRiskcaseList(List<RiskcaseVWInfo> riskcaseList) {
		this.riskcaseList = riskcaseList;
	}
	
	
	
}
