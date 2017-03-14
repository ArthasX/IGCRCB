/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-26新建 
 * 修改:	1.添加 风险指标查询返回集合	yukexin 2014-8-19 09:13:05
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGASM31071VO extends BaseVO implements Serializable{

	/**风险指标展示*/
	protected List<RiskIndexShowVWInfo> riskIndexShowList;
	
	/**风险内容*/
	protected List<RiskIndexContextVWInfo> searchRiskIndexContextVW ;

	/**风险指标查询返回集合*/
	protected List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList;
	
	/**
	 * 风险内容取得
	 * @return searchRiskIndexContextVW 风险内容
	 */
	public List<RiskIndexContextVWInfo> getSearchRiskIndexContextVW() {
		return searchRiskIndexContextVW;
	}

	/**
	 * 风险内容设定
	 * @param searchRiskIndexContextVW 风险内容
	 */
	public void setSearchRiskIndexContextVW(
			List<RiskIndexContextVWInfo> searchRiskIndexContextVW) {
		this.searchRiskIndexContextVW = searchRiskIndexContextVW;
	}

	/**
	 * 风险指标展示取得
	 * @return riskIndexShowList 风险指标展示
	 */
	public List<RiskIndexShowVWInfo> getRiskIndexShowList() {
		return riskIndexShowList;
	}

	/**
	 * 风险指标展示设定
	 * @param riskIndexShowList 风险指标展示
	 */
	public void setRiskIndexShowList(List<RiskIndexShowVWInfo> riskIndexShowList) {
		this.riskIndexShowList = riskIndexShowList;
	}

	/**
	 * 风险指标查询返回集合取得
	 * @return searchRiskIndexSearchVWList  风险指标查询返回集合
	 */
	public List<RiskIndexSearchVWInfo> getSearchRiskIndexSearchVWList() {
		return searchRiskIndexSearchVWList;
	}

	/**
	 * 风险指标查询返回集合设定
	 * @param searchRiskIndexSearchVWList  风险指标查询返回集合
	 */
	public void setSearchRiskIndexSearchVWList(
			List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList) {
		this.searchRiskIndexSearchVWList = searchRiskIndexSearchVWList;
	}
}
