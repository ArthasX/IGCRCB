package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 资产属性默认值ＶＯ
 * 
 */
@SuppressWarnings("serial")
public class IGASM01141VO extends BaseVO implements Serializable{
	
	/** 资产属性默认值集合 */
	protected Map<String,List<IG612Info>> map_IG612Info;

	/**
	 * 构造函数
	 * @param map_IG612Info 资产属性默认值集合
	 */
	public IGASM01141VO(Map<String,List<IG612Info>> map_IG612Info) {
		this.map_IG612Info = map_IG612Info;
	}
	
	/**
	 * 资产属性默认值集合取得
	 * 
	 * @return 资产属性默认值集合
	 */
	public Map<String, List<IG612Info>> getMap_IG612Info() {
		return map_IG612Info;
	}
}