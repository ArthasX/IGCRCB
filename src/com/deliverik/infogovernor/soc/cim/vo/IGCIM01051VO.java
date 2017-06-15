package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 设备历史纪录信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01051VO extends BaseVO implements Serializable{
	
	/** 资产项信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	

	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;
	
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
	public IGCIM01051VO(SOC0124Info entityItemData,Map<String,List<SOC0107Info>> configItemMap) {
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
	
}


