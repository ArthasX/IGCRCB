package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;

/**
 * 检查项详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM31041VO extends BaseVO implements Serializable{
	
	/** 检查项信息 */
	protected SOC0124Info entityItemData;
	
	protected int looksign;
	
	public SOC0124Info getEntityItemData() {
		return entityItemData;
	}
	
	/**
	 * @return the looksign
	 */
	public int getLooksign() {
		return looksign;
	}

	/**
	 * @param looksign the looksign to set
	 */
	public void setLooksign(int looksign) {
		this.looksign = looksign;
	}

	protected Map<Integer,Integer> checkVersionMap;
	
	protected Integer selecteiversion;
	
	
	public Integer getSelecteiversion() {
		return selecteiversion;
	}

	public void setSelecteiversion(Integer selecteiversion) {
		this.selecteiversion = selecteiversion;
	}

	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}

	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
	}

	public void setEntityItemData(SOC0124Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	
	/**风险指标查询返回集合*/
	protected List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList;
	
	
	public List<RiskIndexSearchVWInfo> getSearchRiskIndexSearchVWList() {
		return searchRiskIndexSearchVWList;
	}

	public void setSearchRiskIndexSearchVWList(
			List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList) {
		this.searchRiskIndexSearchVWList = searchRiskIndexSearchVWList;
	}

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGASM31041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** 检查项所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
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


