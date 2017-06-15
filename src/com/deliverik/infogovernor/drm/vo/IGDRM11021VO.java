package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * IGDRM11021VO
 * 
 * 代签到VO
 *
 */
@SuppressWarnings("serial")
public class IGDRM11021VO extends BaseVO implements Serializable{
	
	/**代签到Map*/
	protected List<Map<String,Object>> signinMap ;

	/**
	 * 代签到Map取得
	 * @return signinMap 代签到Map
	 */
	public List<Map<String, Object>> getSigninMap() {
		return signinMap;
	}

	/**
	 * 代签到Map设定
	 * @param signinMap 代签到Map
	 */
	public void setSigninMap(List<Map<String, Object>> signinMap) {
		this.signinMap = signinMap;
	}
}


