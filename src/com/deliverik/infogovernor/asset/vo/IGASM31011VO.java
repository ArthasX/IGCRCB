package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;

/**
 * 检查项信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM31011VO extends BaseVO implements Serializable{
	
	/** 检查项信息检索结果 */
	protected List<SOC0124Info> entityDataList;
	
	/**风险指标--是否关键指标下拉*/
	protected List<SOC0151Info> keyIndexList;
	
	/**风险指标--阀值下拉*/
	protected List<SOC0151Info> thresholdList;
	
	/**风险指标查询返回集合*/
	protected List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList;

	/**
	 * 构造函数
	 * @param entityData　检查项信息检索结果
	 */
	public IGASM31011VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 检查项信息检索结果取得
	 * @return 资产项信息检索结果
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}
	/**
	 * 风险指标--是否关键指标下拉取得
	 * @return list集合
	 */
	public List<SOC0151Info> getKeyIndexList() {
		return keyIndexList;
	}
	/**
	 * 风险指标--是否关键指标下拉设定
	 */
	public void setKeyIndexList(List<SOC0151Info> keyIndexList) {
		this.keyIndexList = keyIndexList;
	}
	
	/**
	 * 风险指标--阀值下拉取得
	 * @return list集合
	 */
	public List<SOC0151Info> getThresholdList() {
		return thresholdList;
	}
	/**
	 * 风险指标--阀值下拉设定
	 */
	public void setThresholdList(List<SOC0151Info> thresholdList) {
		this.thresholdList = thresholdList;
	}

	public List<RiskIndexSearchVWInfo> getSearchRiskIndexSearchVWList() {
		return searchRiskIndexSearchVWList;
	}

	public void setSearchRiskIndexSearchVWList(
			List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList) {
		this.searchRiskIndexSearchVWList = searchRiskIndexSearchVWList;
	}

}


