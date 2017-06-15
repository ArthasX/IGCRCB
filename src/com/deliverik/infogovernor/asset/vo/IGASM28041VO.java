package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;

/**
 * 检查项详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM28041VO extends BaseVO implements Serializable{
	
	/** 检查项信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGASM28041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** 检查项所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/**检查项内容查询*/
	protected IGASM2814Form igasm2814form;
	
	/**检查项内容集合查询*/
	protected List<CheckItemVWInfo> itemList;
	/**版本集合*/
	protected Map<Integer,Integer> checkVersionMap;
	
	/**检查项到风险点关系集合*/
	List<CheckToRiskRelateVWInfo> checkToRiskRelateList;
	
	/**检查项---指标*/
	protected List<RiskToZhRelateVWInfo> riskToZhRelateList;
	
	/**
	 * 检查项---指标取得
	 * @return riskToZhRelateList 检查项---指标
	 */
	public List<RiskToZhRelateVWInfo> getRiskToZhRelateList() {
		return riskToZhRelateList;
	}

	/**
	 * 检查项---指标设定
	 * @param riskToZhRelateList 检查项---指标
	 */
	public void setRiskToZhRelateList(List<RiskToZhRelateVWInfo> riskToZhRelateList) {
		this.riskToZhRelateList = riskToZhRelateList;
	}

	/**
	 * 检查项到风险点关系集合取得
	 * @return checkToRiskRelateList 检查项到风险点关系集合
	 */
	public List<CheckToRiskRelateVWInfo> getCheckToRiskRelateList() {
		return checkToRiskRelateList;
	}

	/**
	 * 检查项到风险点关系集合设定
	 * @param checkToRiskRelateList 检查项到风险点关系集合
	 */
	public void setCheckToRiskRelateList(
			List<CheckToRiskRelateVWInfo> checkToRiskRelateList) {
		this.checkToRiskRelateList = checkToRiskRelateList;
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
	 * 检查项内容集合查询取得
	 * @return itemList 检查项内容集合查询
	 */
	public List<CheckItemVWInfo> getItemList() {
		return itemList;
	}

	/**
	 * 检查项内容集合查询设定
	 * @param itemList 检查项内容集合查询
	 */
	public void setItemList(List<CheckItemVWInfo> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 检查项内容查询取得
	 * @return igasm2814form 检查项内容查询
	 */
	public IGASM2814Form getIgasm2814form() {
		return igasm2814form;
	}

	/**
	 * 检查项内容查询设定
	 * @param igasm2814form 检查项内容查询
	 */
	public void setIgasm2814form(IGASM2814Form igasm2814form) {
		this.igasm2814form = igasm2814form;
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
	 * 检查项信息取得
	 * @return 检查项信息
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
}


