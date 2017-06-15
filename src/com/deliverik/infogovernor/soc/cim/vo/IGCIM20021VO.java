package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

public class IGCIM20021VO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public IGCIM20021VO(){
		
	}
	public IGCIM20021VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap){
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/** 设备信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;

	public SOC0124Info getEntityData() {
		return entityItemData;
	}

	public void setEntityItemData(SOC0124Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}
	
	
	
	

}
