package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * 设备详细信息ＶＯ
 * 
 * @author
 * 
 */
@SuppressWarnings("serial")
public class IGDRM04301VO extends BaseVO implements Serializable {

	/** 设备信息 */
	protected SOC0118VWInfo entityItemData;

	/** 资产项配置信息检索结果 */
	protected Map<String, List<SOC0129Info>> configItemVWInfoMap;

	/** 设备所属机构名称 */
	protected String eiorgname;

	/** 权限标识 */
	protected Boolean flag;

	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;

	/** 设备是否已上架标志位 */
	protected String inJiguiFlg;

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
	 * 
	 * @param entityItemData
	 *            　资产项信息
	 * @param configItemVWInfoMap
	 *            　资产项配置信息检索结果
	 */
	public IGDRM04301VO(SOC0118VWInfo entityItemData,
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * 设备信息取得
	 * 
	 * @return 设备信息
	 */
	public SOC0118VWInfo getEntityData() {
		return entityItemData;
	}

	/**
	 * 资产项配置信息检索结果取得
	 * 
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * 资产版本列表取得
	 * 
	 * @return 资产版本列表
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * 资产版本列表设定
	 * 
	 * @param configItemVersionTime
	 *            资产版本列表
	 */
	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	/**
	 * @return the inJiguiFlg
	 */
	public String getInJiguiFlg() {
		return inJiguiFlg;
	}

	/**
	 * @param inJiguiFlg
	 *            the inJiguiFlg to set
	 */
	public void setInJiguiFlg(String inJiguiFlg) {
		this.inJiguiFlg = inJiguiFlg;
	}
}
