package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.infogovernor.asset.form.IGASM2704Form;
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;

/**
 * 风险点详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM27041VO extends BaseVO implements Serializable{
	
	/** 风险点信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGASM27041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** 风险点所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/**风险点查询 */
	protected List<RiskPointVMInfo> riskPointList;
	/**版本集合*/
	protected Map<Integer,Integer> checkVersionMap;
	
	protected IGASM2704Form igASM2704Form;
	/**风险---检查项*/
	protected List<RiskCheckVWInfo> searchRiskCheckList;

	/**风险---指标*/
	protected List<RiskToZhRelateVWInfo> riskToZhRelateList;
	
	/**
	 * 风险---指标取得
	 * @return riskToZhRelateList 风险---指标
	 */
	public List<RiskToZhRelateVWInfo> getRiskToZhRelateList() {
		return riskToZhRelateList;
	}

	/**
	 * 风险---指标设定
	 * @param riskToZhRelateList 风险---指标
	 */
	public void setRiskToZhRelateList(List<RiskToZhRelateVWInfo> riskToZhRelateList) {
		this.riskToZhRelateList = riskToZhRelateList;
	}

	/**
	 * 风险---检查项取得
	 * @return searchRiskCheckList 风险---检查项
	 */
	public List<RiskCheckVWInfo> getSearchRiskCheckList() {
		return searchRiskCheckList;
	}

	/**
	 * 风险---检查项设定
	 * @param searchRiskCheckList 风险---检查项
	 */
	public void setSearchRiskCheckList(List<RiskCheckVWInfo> searchRiskCheckList) {
		this.searchRiskCheckList = searchRiskCheckList;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	/**
	 * 风险点信息取得
	 * @return 风险点信息
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * 风险点查询取得
	 * @return riskPointList 风险点查询
	 */
	public List<RiskPointVMInfo> getRiskPointList() {
		return riskPointList;
	}

	/**
	 * 风险点查询设定
	 * @param riskPointList 风险点查询
	 */
	public void setRiskPointList(List<RiskPointVMInfo> riskPointList) {
		this.riskPointList = riskPointList;
	}

	/**
	 * 版本集合取得
	 * @return checkVersionMap 版本集合
	 */
	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}

	/**
	 * 版本集合设定
	 * @param checkVersionMap 版本集合
	 */
	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
	}

	/**
	 * igASM2704Form取得
	 * @return igASM2704Form igASM2704Form
	 */
	public IGASM2704Form getIgASM2704Form() {
		return igASM2704Form;
	}

	/**
	 * igASM2704Form设定
	 * @param igASM2704Form igASM2704Form
	 */
	public void setIgASM2704Form(IGASM2704Form igASM2704Form) {
		this.igASM2704Form = igASM2704Form;
	}
}


