package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * 配置项配置详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM07081VO extends BaseVO implements Serializable{
	
	/** 配置项信息 */
	protected SOC0124Info soc0124Info;
	
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> soc0129InfoVWMap;
	
	/** 权限标识 */
	protected Boolean flag;
	
	protected Map<String,List<SOC0129Info>> soc0129InfoMap;
	
	/** 资产信息 */
	protected SOC0118Info soc0118Info;
	
	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}

	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}
	
	public SOC0118Info getSoc0118Info() {
		return soc0118Info;
	}

	public void setSoc0118Info(SOC0118Info soc0118Info) {
		this.soc0118Info = soc0118Info;
	}

	public Boolean getFlag() {
		return flag;
	}


	public Map<String, List<SOC0129Info>> getSoc0129InfoVWMap() {
		return soc0129InfoVWMap;
	}

	public void setSoc0129InfoVWMap(Map<String, List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGDRM07081VO(SOC0124Info soc0124Info,Map<String,List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0124Info = soc0124Info;
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}
	
	/**
	 * 配置项信息取得
	 * @return 配置项信息
	 */
	public SOC0124Info getEntityData() {
		return soc0124Info;
	}

	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return soc0129InfoVWMap;
	}
	
	
}


