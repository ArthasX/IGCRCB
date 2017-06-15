package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * IGDRM11021VO
 * 
 * ��ǩ��VO
 *
 */
@SuppressWarnings("serial")
public class IGDRM11021VO extends BaseVO implements Serializable{
	
	/**��ǩ��Map*/
	protected List<Map<String,Object>> signinMap ;

	/**
	 * ��ǩ��Mapȡ��
	 * @return signinMap ��ǩ��Map
	 */
	public List<Map<String, Object>> getSigninMap() {
		return signinMap;
	}

	/**
	 * ��ǩ��Map�趨
	 * @param signinMap ��ǩ��Map
	 */
	public void setSigninMap(List<Map<String, Object>> signinMap) {
		this.signinMap = signinMap;
	}
}


