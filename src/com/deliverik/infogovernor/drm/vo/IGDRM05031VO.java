package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.infogovernor.vo.IGCOM03072VO;

/**
 * 人员历史纪录信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM05031VO extends BaseVO implements Serializable{
	
	/** 资产项信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;

	/** 人员所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;
	
	/** 资产项配置信息检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 显示VO */
	protected List<IGCOM03072VO> voList;
	
	/** 版本日期 */
	protected Map<String, String> versionDate;
	
	/** 版本个数 */
	protected Integer versionsize = 0;
	
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
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemMap　资产项配置信息检索结果
	 */
	public IGDRM05031VO(SOC0124Info entityItemData,Map<String,List<SOC0107Info>> configItemMap) {
		this.entityItemData = entityItemData;
		this.configItemMap = configItemMap;
	}
	
	/**
	 * 资产项信息取得
	 * @return 资产项信息
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}
	
	/**
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * 资产版本列表设定
	 *
	 * @param configItemVersionTime 资产版本列表
	 */
	public void setConfigItemVersionTime(
			List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	public SOC0124Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(SOC0124Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	public List<IGCOM03072VO> getVoList() {
		return voList;
	}

	public void setVoList(List<IGCOM03072VO> voList) {
		this.voList = voList;
	}

	public Map<String, String> getVersionDate() {
		return versionDate;
	}

	public void setVersionDate(Map<String, String> versionDate) {
		this.versionDate = versionDate;
	}

	public Integer getVersionsize() {
		return versionsize;
	}

	public void setVersionsize(Integer versionsize) {
		this.versionsize = versionsize;
	}

	public void setConfigItemMap(Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}
	
}


